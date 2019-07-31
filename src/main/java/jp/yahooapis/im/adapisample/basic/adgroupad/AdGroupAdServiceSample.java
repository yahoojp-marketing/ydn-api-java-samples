/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.adgroupad;

import jp.yahooapis.im.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201907.Error;
import jp.yahooapis.im.v201907.Paging;
import jp.yahooapis.im.v201907.adgroupad.AdGroupAd;
import jp.yahooapis.im.v201907.adgroupad.AdGroupAdOperation;
import jp.yahooapis.im.v201907.adgroupad.AdGroupAdPage;
import jp.yahooapis.im.v201907.adgroupad.AdGroupAdReturnValue;
import jp.yahooapis.im.v201907.adgroupad.AdGroupAdSelector;
import jp.yahooapis.im.v201907.adgroupad.AdGroupAdService;
import jp.yahooapis.im.v201907.adgroupad.AdGroupAdServiceInterface;
import jp.yahooapis.im.v201907.adgroupad.AdGroupAdValues;
import jp.yahooapis.im.v201907.adgroupad.AdStyle;
import jp.yahooapis.im.v201907.adgroupad.AdType;
import jp.yahooapis.im.v201907.adgroupad.BiddingStrategyType;
import jp.yahooapis.im.v201907.adgroupad.DynamicAd;
import jp.yahooapis.im.v201907.adgroupad.ManualCPCAdGroupAdBid;
import jp.yahooapis.im.v201907.adgroupad.Operator;
import jp.yahooapis.im.v201907.adgroupad.TextAd;
import jp.yahooapis.im.v201907.adgroupad.UserStatus;
import jp.yahooapis.im.v201907.campaign.CampaignType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example AdGroupAdService operation and Utility method collection.
 */
public class AdGroupAdServiceSample {

  /**
   * example AdGroupAdService operation.
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
      valuesHolder = setup();
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      Long campaignIdStandard = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(
          CampaignType.STANDARD
      );
      Long adGroupIdStandard = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignIdStandard);

      // =================================================================
      // AdGroupAdService ADD
      // =================================================================
      // create request.
      AdGroupAdOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<AdGroupAd>() {{
        add(createExampleExtendedTextAd(campaignIdStandard, adGroupIdStandard));
      }});

      // run
      List<AdGroupAdValues> addResponse = mutate(addRequest);
      valuesHolder.setAdGroupAdValuesList(addResponse);

      // =================================================================
      // AdGroupAdService GET
      // =================================================================
      // create request.
      AdGroupAdSelector getRequest = buildExampleGetRequest(accountId, valuesRepositoryFacade.getAdGroupAdValuesRepository().getAdGroupAds());

      // run
      get(getRequest);

      // =================================================================
      // AdGroupAdService SET
      // =================================================================
      // create request.
      AdGroupAdOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId,
          createExampleSetRequest(valuesRepositoryFacade.getAdGroupAdValuesRepository().getAdGroupAds())
      );

      // run
      mutate(setRequest);

      // =================================================================
      // AdGroupAdService REMOVE
      // =================================================================
      // create request.
      AdGroupAdOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getAdGroupAdValuesRepository().getAdGroupAds());

      // run
      mutate(removeRequest);

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
   * example mutate AdGroupAds.
   *
   * @param operation AdGroupAdOperation
   * @return AdGroupAdValues
   */
  public static List<AdGroupAdValues> mutate(AdGroupAdOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupAdService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<AdGroupAdReturnValue> AdGroupAdReturnValueHolder = new Holder<AdGroupAdReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupAdServiceInterface AdGroupAdService = SoapUtils.createServiceInterface(AdGroupAdServiceInterface.class, AdGroupAdService.class);
    AdGroupAdService.mutate(operation, AdGroupAdReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, AdGroupAdReturnValueHolder.value.getValues());

    // Response
    return AdGroupAdReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupAdService GET.
   *
   * @param selector AdGroupAdSelector
   * @return AdGroupAdValues
   */
  public static List<AdGroupAdValues> get(AdGroupAdSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupAdService::get");
    System.out.println("############################################");

    Holder<AdGroupAdPage> AdGroupAdPageHolder = new Holder<AdGroupAdPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupAdServiceInterface AdGroupAdService = SoapUtils.createServiceInterface(AdGroupAdServiceInterface.class, AdGroupAdService.class);
    AdGroupAdService.get(selector, AdGroupAdPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, AdGroupAdPageHolder.value.getValues());

    // Response
    return AdGroupAdPageHolder.value.getValues();
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  private static ValuesHolder setup() throws Exception {
    return AdGroupServiceSample.create();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    AdGroupServiceSample.cleanup(valuesHolder);
  }

  /**
   * example mutate request.
   *
   * @param operator Operator
   * @param accountId long
   * @param operand List<AdGroupAd>
   * @return AdGroupAdOperation
   */
  public static AdGroupAdOperation buildExampleMutateRequest(Operator operator, long accountId, List<AdGroupAd> operand)
  {
    AdGroupAdOperation operation = new AdGroupAdOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * create get request.
   *
   * @param accountId long
   * @param AdGroupAds AdGroupAd
   * @return AdGroupAdSelector
   */
  public static AdGroupAdSelector buildExampleGetRequest(long accountId, List<AdGroupAd> AdGroupAds)
  {
    // Set Selector
    AdGroupAdSelector selector = new AdGroupAdSelector();
    selector.setAccountId(accountId);
    selector.getUserStatuses().addAll(Arrays.asList(UserStatus.ACTIVE, UserStatus.PAUSED));

    for (AdGroupAd adGroupAd : AdGroupAds) {
      selector.getCampaignIds().add(adGroupAd.getCampaignId());
      selector.getAdGroupIds().add(adGroupAd.getAdGroupId());
      selector.getAdIds().add(adGroupAd.getAdId());
    }

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
  
  /**
   * example AdGroupAds set request.
   *
   * @param AdGroupAds
   * @return List<AdGroupAd>
   */
  public static List<AdGroupAd> createExampleSetRequest(List<AdGroupAd> AdGroupAds)
  {
    // create operands
    List<AdGroupAd> operands = new ArrayList<>();

    // bid
    ManualCPCAdGroupAdBid bid = new ManualCPCAdGroupAdBid();
    bid.setMaxCpc((long)60);
    bid.setType(BiddingStrategyType.MANUAL_CPC);

    for (AdGroupAd adGroupAd : AdGroupAds) {
      AdGroupAd operand = new AdGroupAd();
      operand.setAccountId(SoapUtils.getAccountId());
      operand.setCampaignId(adGroupAd.getCampaignId());
      operand.setAdGroupId(adGroupAd.getAdGroupId());
      operand.setAdId(adGroupAd.getAdId());
      operand.setAdName("UpdateOn_" + adGroupAd.getAdId() + "_" + SoapUtils.getCurrentTimestamp());
      operand.setUserStatus(UserStatus.PAUSED);
      operand.setBid(bid);
      operands.add(operand);
    }
    return operands;
  }
  
  /**
   * example ExtendedText Ad request.
   *
   * @param campaignId
   * @param adGroupId
   * @return AdGroupAd
   */
  public static AdGroupAd createExampleExtendedTextAd(long campaignId, long adGroupId)
  {
    // ad
    TextAd ad = new TextAd();
    ad.setType(AdType.TEXT_LONG_AD_1);
    ad.setUrl("http://www.yahoo.co.jp/");
    ad.setDisplayUrl("www.yahoo.co.jp");
    ad.setHeadline("sample headline");
    ad.setDescription("sample ad desc");
    ad.setDescription2("sample ad desc2");

    // bid
    ManualCPCAdGroupAdBid bid = new ManualCPCAdGroupAdBid();
    bid.setMaxCpc((long)50);
    bid.setType(BiddingStrategyType.MANUAL_CPC);

    // adGroupAd
    AdGroupAd adGroupAd = new AdGroupAd();
    adGroupAd.setAccountId(SoapUtils.getAccountId());
    adGroupAd.setCampaignId(campaignId);
    adGroupAd.setAdGroupId(adGroupId);
    adGroupAd.setAdStyle(AdStyle.TEXT);
    adGroupAd.setAdName("SampleExtendedTextAdGroupAd_CreateOn_" + SoapUtils.getCurrentTimestamp());
    adGroupAd.setUserStatus(UserStatus.ACTIVE);
    adGroupAd.setBid(bid);
    adGroupAd.setAd(ad);

    return adGroupAd;
  }

  /**
   * example Dynamic Ad request.
   *
   * @param campaignId
   * @param adGroupId
   * @return AdGroupAd
   */
  public static AdGroupAd createExampleDynamicAd(long campaignId, long adGroupId, List<Long> mediaIds)
  {
    // ad
    DynamicAd ad = new DynamicAd();
    ad.setType(AdType.DYNAMIC_AD);
    ad.setDisplayUrl("www.yahoo.co.jp");
    ad.setUrl("http://www.yahoo.co.jp/");
    ad.setPrincipal("Principal");
    ad.setLogoMediaId(mediaIds.get(0));
    ad.setLogoMediaId2(mediaIds.get(1));
    ad.setLogoMediaId3(mediaIds.get(2));

    // adGroupAd
    AdGroupAd adGroupAd = new AdGroupAd();
    adGroupAd.setAccountId(SoapUtils.getAccountId());
    adGroupAd.setCampaignId(campaignId);
    adGroupAd.setAdGroupId(adGroupId);
    adGroupAd.setAdStyle(AdStyle.TEXT);
    adGroupAd.setAdName("SampleDynamicAd_CreateOn_" + SoapUtils.getCurrentTimestamp());
    adGroupAd.setUserStatus(UserStatus.ACTIVE);
    adGroupAd.setAd(ad);

    return adGroupAd;
  }

  /**
   * create basic AdGroupAd.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  public static ValuesHolder create() throws Exception
  {
    ValuesHolder parentValuesHolder = setup();
    ValuesRepositoryFacade parentValuesRepositoryFacade = new ValuesRepositoryFacade(parentValuesHolder);
    long accountId = SoapUtils.getAccountId();

    Long campaignId = parentValuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);
    Long adGroupId = parentValuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignId);

    AdGroupAdOperation request = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<AdGroupAd>() {{
      add(createExampleExtendedTextAd(campaignId, adGroupId));
    }});

    List<AdGroupAdValues> response = mutate(request);

    ValuesHolder selfValuesHolder = new ValuesHolder();
    selfValuesHolder.setCampaignValuesList(parentValuesHolder.getCampaignValuesList());
    selfValuesHolder.setAdGroupValuesList(parentValuesHolder.getAdGroupValuesList());
    selfValuesHolder.setAdGroupAdValuesList(response);
    return selfValuesHolder;
  }
}
