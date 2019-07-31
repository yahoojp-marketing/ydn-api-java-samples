/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.campaign;

import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201907.Error;
import jp.yahooapis.im.v201907.Paging;
import jp.yahooapis.im.v201907.campaign.BiddingStrategyType;
import jp.yahooapis.im.v201907.campaign.Budget;
import jp.yahooapis.im.v201907.campaign.BudgetDeliveryMethod;
import jp.yahooapis.im.v201907.campaign.Campaign;
import jp.yahooapis.im.v201907.campaign.CampaignOperation;
import jp.yahooapis.im.v201907.campaign.CampaignPage;
import jp.yahooapis.im.v201907.campaign.CampaignReturnValue;
import jp.yahooapis.im.v201907.campaign.CampaignSelector;
import jp.yahooapis.im.v201907.campaign.CampaignService;
import jp.yahooapis.im.v201907.campaign.CampaignServiceInterface;
import jp.yahooapis.im.v201907.campaign.CampaignType;
import jp.yahooapis.im.v201907.campaign.CampaignValues;
import jp.yahooapis.im.v201907.campaign.DeviceOsType;
import jp.yahooapis.im.v201907.campaign.FrequencyCap;
import jp.yahooapis.im.v201907.campaign.FrequencyLevel;
import jp.yahooapis.im.v201907.campaign.FrequencyTimeUnit;
import jp.yahooapis.im.v201907.campaign.ManualCPC;
import jp.yahooapis.im.v201907.campaign.Operator;
import jp.yahooapis.im.v201907.campaign.UserStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example CampaignService operation and Utility method collection.
 */
public class CampaignServiceSample {

  /**
   * example CampaignService operation.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {

    // =================================================================
    // Setup
    // =================================================================
    ValuesHolder valuesHolder = new ValuesHolder();
    long accountId = SoapUtils.getAccountId();
    
    try {
      // =================================================================
      // check & create upper service object.
      // =================================================================
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);

      // =================================================================
      // CampaignService ADD
      // =================================================================
      // create request.
      CampaignOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<Campaign>() {{
        add(createExampleStandardCampaign());
        add(createExampleAppCampaignANDROID());
        add(createExampleAppCampaignIOS());
      }});

      // run
      List<CampaignValues> addResponse = mutate(addRequest);
      valuesHolder.setCampaignValuesList(addResponse);

      // =================================================================
      // CampaignService GET
      // =================================================================
      // create request.
      CampaignSelector getRequest = buildExampleGetRequest(accountId, valuesRepositoryFacade.getCampaignValuesRepository().getCampaignIds());

      // run
      get(getRequest);

      // =================================================================
      // CampaignService SET
      // =================================================================
      // create request.
      CampaignOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId,
          createExampleSetRequest(accountId, valuesRepositoryFacade.getCampaignValuesRepository().getCampaigns())
      );

      // run
      mutate(setRequest);

      // =================================================================
      // CampaignService REMOVE
      // =================================================================
      // create request.
      CampaignOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId,
          valuesRepositoryFacade.getCampaignValuesRepository().getCampaigns()
      );

      // run
      mutate(removeRequest);
      valuesHolder.setCampaignValuesList(new ArrayList<>());

    } catch (Exception e) {
      e.printStackTrace();
      throw e;

    } finally {
      // =================================================================
      // Cleanup
      // =================================================================
      cleanup(valuesHolder);
    }
  }

  /**
   * example mutate campaigns.
   *
   * @param operation CampaignOperation
   * @return CampaignValues
   */
  public static List<CampaignValues> mutate(CampaignOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<CampaignReturnValue> campaignReturnValueHolder = new Holder<CampaignReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignServiceInterface campaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignService.class);
    campaignService.mutate(operation, campaignReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, campaignReturnValueHolder.value.getValues());

    // Response
    return campaignReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignService GET.
   *
   * @param selector CampaignSelector
   * @return CampaignValues
   */
  public static List<CampaignValues> get(CampaignSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignService::get");
    System.out.println("############################################");

    Holder<CampaignPage> campaignPageHolder = new Holder<CampaignPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignServiceInterface campaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignService.class);
    campaignService.get(selector, campaignPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, campaignPageHolder.value.getValues());

    // Response
    return campaignPageHolder.value.getValues();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    long accountId = SoapUtils.getAccountId();

    if (valuesHolder.getCampaignValuesList().size() > 0) {
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      CampaignOperation removeCampaignOperation =
          buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getCampaignValuesRepository().getCampaigns());

      mutate(removeCampaignOperation);
    }
  }

  /**
   * example mutate request.
   *
   * @param operator Operator
   * @param accountId long
   * @param operand List<Campaign>
   * @return CampaignOperation
   */
  public static CampaignOperation buildExampleMutateRequest(Operator operator, long accountId, List<Campaign> operand)
  {
    CampaignOperation operation = new CampaignOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example Standard Campaign request.
   *
   * @return Campaign
   */
  public static Campaign createExampleStandardCampaign()
  {
    // budget
    Budget budget = new Budget();
    budget.setAmount((long)1000);
    budget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);

    // manualCPC
    ManualCPC manualCPC = new ManualCPC();
    manualCPC.setType(BiddingStrategyType.MANUAL_CPC);

    // frequencyCap
    FrequencyCap frequencyCap = new FrequencyCap();
    frequencyCap.setLevel(FrequencyLevel.CAMPAIGN);
    frequencyCap.setTimeUnit(FrequencyTimeUnit.WEEK);
    frequencyCap.setImpression((long)10);

    // campaign
    Campaign campaign = new Campaign();
    campaign.setAccountId(SoapUtils.getAccountId());
    campaign.setCampaignName("SampleStandardCampaign_CreateOn_" + SoapUtils.getCurrentTimestamp());
    campaign.setUserStatus(UserStatus.ACTIVE);
    campaign.setStartDate("20300101");
    campaign.setEndDate("20301231");
    campaign.setBudget(budget);
    campaign.setBiddingStrategy(manualCPC);
    campaign.setAdProductType("TARGET_MATCH");
    campaign.setFrequencyCap(frequencyCap);
    campaign.setCampaignType(CampaignType.STANDARD);

    return campaign;
  }

  /**
   * example App Campaign ANDROID request.
   *
   * @return Campaign
   */
  public static Campaign createExampleAppCampaignANDROID()
  {
    // budget
    Budget budget = new Budget();
    budget.setAmount((long)1000);
    budget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);

    // manualCPC
    ManualCPC manualCPC = new ManualCPC();
    manualCPC.setType(BiddingStrategyType.MANUAL_CPC);

    // frequencyCap
    FrequencyCap frequencyCap = new FrequencyCap();
    frequencyCap.setLevel(FrequencyLevel.CAMPAIGN);
    frequencyCap.setTimeUnit(FrequencyTimeUnit.WEEK);
    frequencyCap.setImpression((long)10);

    // campaign
    Campaign campaign = new Campaign();
    campaign.setAccountId(SoapUtils.getAccountId());
    campaign.setCampaignName("SampleAppAndroidCampaign_CreateOn_" + SoapUtils.getCurrentTimestamp());
    campaign.setUserStatus(UserStatus.ACTIVE);
    campaign.setStartDate("20300101");
    campaign.setEndDate("20301231");
    campaign.setBudget(budget);
    campaign.setBiddingStrategy(manualCPC);
    campaign.setAdProductType("TARGET_MATCH");
    campaign.setFrequencyCap(frequencyCap);
    campaign.setCampaignType(CampaignType.APP);
    campaign.setAppOs(DeviceOsType.ANDROID);
    campaign.setAppId("jp.co.yahoo.sample");
    campaign.setAppName("Sample Android app");

    return campaign;
  }

  /**
   * example App Campaign IOS request.
   *
   * @return Campaign
   */
  public static Campaign createExampleAppCampaignIOS()
  {
    // budget
    Budget budget = new Budget();
    budget.setAmount((long)1000);
    budget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);

    // manualCPC
    ManualCPC manualCPC = new ManualCPC();
    manualCPC.setType(BiddingStrategyType.MANUAL_CPC);

    // frequencyCap
    FrequencyCap frequencyCap = new FrequencyCap();
    frequencyCap.setLevel(FrequencyLevel.CAMPAIGN);
    frequencyCap.setTimeUnit(FrequencyTimeUnit.WEEK);
    frequencyCap.setImpression((long)10);

    // campaign
    Campaign campaign = new Campaign();
    campaign.setAccountId(SoapUtils.getAccountId());
    campaign.setCampaignName("SampleAppIOSCampaign_CreateOn_" + SoapUtils.getCurrentTimestamp());
    campaign.setUserStatus(UserStatus.ACTIVE);
    campaign.setStartDate("20300101");
    campaign.setEndDate("20301231");
    campaign.setBudget(budget);
    campaign.setBiddingStrategy(manualCPC);
    campaign.setAdProductType("TARGET_MATCH");
    campaign.setFrequencyCap(frequencyCap);
    campaign.setCampaignType(CampaignType.APP);
    campaign.setAppOs(DeviceOsType.IOS);
    campaign.setAppId("1234567890");
    campaign.setAppName("Sample IOS app");

    return campaign;
  }

  /**
   * example Dynamic Ads for Display Campaign request.
   *
   * @param feedFolderId
   * @return Campaign
   */
  public static Campaign createExampleDynamicAdsForDisplayCampaign(Long feedFolderId)
  {
    // budget
    Budget budget = new Budget();
    budget.setAmount((long)1000);
    budget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);

    // campaign
    Campaign campaign = new Campaign();
    campaign.setAccountId(SoapUtils.getAccountId());
    campaign.setCampaignName("SampleDynamicAdsForDisplayCampaign_CreateOn_" + SoapUtils.getCurrentTimestamp());
    campaign.setUserStatus(UserStatus.ACTIVE);
    campaign.setStartDate("20300101");
    campaign.setEndDate("20301231");
    campaign.setBudget(budget);
    campaign.setAdProductType("DYNAMIC_ADS");
    campaign.setCampaignType(CampaignType.STANDARD);
    campaign.setFeedHolderId(feedFolderId);

    return campaign;
  }

  /**
   * example get request.
   *
   * @param accountId   long
   * @param campaignIds List<Long>
   * @return CampaignSelector
   */
  public static CampaignSelector buildExampleGetRequest(long accountId, List<Long> campaignIds)
  {
    CampaignSelector selector = new CampaignSelector();
    selector.setAccountId(accountId);
    selector.getUserStatus().addAll(Arrays.asList(UserStatus.ACTIVE, UserStatus.PAUSED));

    if (campaignIds.size() > 0) {
      selector.getCampaignIds().addAll(campaignIds);
    }

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
  
  /**
   * example campaigns set request.
   *
   * @param accountId long
   * @param campaigns List<Campaign>
   * @return List<Campaign>
   */
  public static List<Campaign> createExampleSetRequest(long accountId, List<Campaign> campaigns)
  {
    // create operands
    List<Campaign> operands = new ArrayList<>();

    for (Campaign campaign : campaigns) {
      Budget budget = new Budget();
      budget.setAmount((long)12000);
      budget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);

      // biddingStrategy
      ManualCPC manualCpc = new ManualCPC();
      manualCpc.setType(BiddingStrategyType.MANUAL_CPC);

      // frequencyCap
      FrequencyCap frequencyCap = new FrequencyCap();
      frequencyCap.setLevel(FrequencyLevel.AD_GROUP);
      frequencyCap.setTimeUnit(FrequencyTimeUnit.DAY);
      frequencyCap.setImpression((long)5);

      Campaign operand = new Campaign();
      operand.setAccountId(accountId);
      operand.setCampaignId(campaign.getCampaignId());
      operand.setCampaignName("SampleCampaign_UpdateOn_" + SoapUtils.getCurrentTimestamp() + campaign.getCampaignId());
      operand.setUserStatus(UserStatus.PAUSED);
      operand.setStartDate("20300101");
      operand.setEndDate("20301231");
      operand.setBudget(budget);
      operand.setBiddingStrategy(manualCpc);
      operand.setFrequencyCap(frequencyCap);

      operands.add(operand);
    }

    return operands;
  }

  /**
   * create basic Campaign.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  public static ValuesHolder create() throws Exception {

    long accountId = SoapUtils.getAccountId();

    CampaignOperation addCampaignOperation = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<Campaign>() {{
      add(createExampleStandardCampaign());
      add(createExampleAppCampaignANDROID());
      add(createExampleAppCampaignIOS());
    }});

    List<CampaignValues> addCampaignValues = mutate(addCampaignOperation);

    ValuesHolder selfValuesHolder = new ValuesHolder();
    selfValuesHolder.setCampaignValuesList(addCampaignValues);

    return selfValuesHolder;
  }
}
