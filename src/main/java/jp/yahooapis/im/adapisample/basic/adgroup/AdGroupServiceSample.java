/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.adgroup;

import jp.yahooapis.im.adapisample.basic.campaign.CampaignServiceSample;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201907.Error;
import jp.yahooapis.im.v201907.Paging;
import jp.yahooapis.im.v201907.adgroup.AdGroupConversionOptimizerType;
import jp.yahooapis.im.v201907.adgroup.BiddingStrategyType;
import jp.yahooapis.im.v201907.adgroup.AdGroup;
import jp.yahooapis.im.v201907.adgroup.AdGroupOperation;
import jp.yahooapis.im.v201907.adgroup.AdGroupPage;
import jp.yahooapis.im.v201907.adgroup.AdGroupReturnValue;
import jp.yahooapis.im.v201907.adgroup.AdGroupSelector;
import jp.yahooapis.im.v201907.adgroup.AdGroupService;
import jp.yahooapis.im.v201907.adgroup.AdGroupServiceInterface;
import jp.yahooapis.im.v201907.adgroup.AdGroupValues;
import jp.yahooapis.im.v201907.adgroup.DeviceAppType;
import jp.yahooapis.im.v201907.adgroup.DeviceOsType;
import jp.yahooapis.im.v201907.adgroup.DeviceType;
import jp.yahooapis.im.v201907.adgroup.DynamicImageExtensions;
import jp.yahooapis.im.v201907.adgroup.ManualCPCAdGroupBid;
import jp.yahooapis.im.v201907.adgroup.NoneAdGroupConversionOptimizer;
import jp.yahooapis.im.v201907.adgroup.Operator;
import jp.yahooapis.im.v201907.adgroup.SmartDeviceCarrier;
import jp.yahooapis.im.v201907.adgroup.UserStatus;
import jp.yahooapis.im.v201907.campaign.CampaignType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example AdGroupService operation and Utility method collection.
 */
public class AdGroupServiceSample {

  /**
   * example AdGroupService operation.
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
      Long campaignId = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(jp.yahooapis.im.v201907.campaign.DeviceOsType.IOS);

      // =================================================================
      // AdGroupService ADD
      // =================================================================
      // create request.
      AdGroupOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<AdGroup>() {{
        add(createExampleAppIOSAdGroup(campaignId));
      }});

      // run
      List<AdGroupValues> addResponse = mutate(addRequest);
      valuesHolder.setAdGroupValuesList(addResponse);

      // =================================================================
      // AdGroupService GET
      // =================================================================
      // create request.
      AdGroupSelector getRequest = buildExampleGetRequest(accountId, valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroups());

      // run
      get(getRequest);

      // =================================================================
      // AdGroupService SET
      // =================================================================
      // create request.
      AdGroupOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId, createExampleSetRequest(valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroups()));

      // run
      mutate(setRequest);

      // =================================================================
      // AdGroupService REMOVE
      // =================================================================
      // create request.
      AdGroupOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId,
          valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroups()
      );

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
   * example mutate AdGroups.
   *
   * @param operation AdGroupOperation
   * @return AdGroupValues
   */
  public static List<AdGroupValues> mutate(AdGroupOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<AdGroupReturnValue> AdGroupReturnValueHolder = new Holder<AdGroupReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupServiceInterface AdGroupService = SoapUtils.createServiceInterface(AdGroupServiceInterface.class, AdGroupService.class);
    AdGroupService.mutate(operation, AdGroupReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, AdGroupReturnValueHolder.value.getValues());

    // Response
    return AdGroupReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupService GET.
   *
   * @param selector AdGroupSelector
   * @return AdGroupValues
   */
  public static List<AdGroupValues> get(AdGroupSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupService::get");
    System.out.println("############################################");

    Holder<AdGroupPage> AdGroupPageHolder = new Holder<AdGroupPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupServiceInterface AdGroupService = SoapUtils.createServiceInterface(AdGroupServiceInterface.class, AdGroupService.class);
    AdGroupService.get(selector, AdGroupPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, AdGroupPageHolder.value.getValues());

    // Response
    return AdGroupPageHolder.value.getValues();
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  private static ValuesHolder setup() throws Exception {
    return CampaignServiceSample.create();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    CampaignServiceSample.cleanup(valuesHolder);
  }

  /**
   * example mutate request.
   *
   * @param operator Operator
   * @param accountId long
   * @param operand List<AdGroup>
   * @return AdGroupOperation
   */
  public static AdGroupOperation buildExampleMutateRequest(Operator operator, long accountId, List<AdGroup> operand)
  {
    AdGroupOperation operation = new AdGroupOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }
  
  /**
   * example Standard AdGroup request.
   *
   * @param campaignId
   * @return AdGroup
   */
  public static AdGroup createExampleStandardAdGroup(long campaignId)
  {
    // bid
    ManualCPCAdGroupBid bid = new ManualCPCAdGroupBid();
    bid.setType(BiddingStrategyType.MANUAL_CPC);
    bid.setMaxCpc((long)120);

    // conversionOptimizer
    NoneAdGroupConversionOptimizer conversionOptimizer = new NoneAdGroupConversionOptimizer();
    conversionOptimizer.setOptimizerType(AdGroupConversionOptimizerType.NONE);

    // adGroup
    AdGroup adGroup = new AdGroup();
    adGroup.setAccountId(SoapUtils.getAccountId());
    adGroup.setCampaignId(campaignId);
    adGroup.setAdGroupName("SampleStandardAdGroup_CreateOn_" + SoapUtils.getCurrentTimestamp());
    adGroup.setUserStatus(UserStatus.ACTIVE);
    adGroup.setBid(bid);
    adGroup.setConversionOptimizer(conversionOptimizer);
    adGroup.getDevice().add(DeviceType.DESKTOP);

    return adGroup;
  }

  /**
   * example App IOS AdGroup request.
   *
   * @param campaignId
   * @return AdGroup
   */
  public static AdGroup createExampleAppIOSAdGroup(long campaignId)
  {
    // bid
    ManualCPCAdGroupBid bid = new ManualCPCAdGroupBid();
    bid.setType(BiddingStrategyType.MANUAL_CPC);
    bid.setMaxCpc((long)120);

    // conversionOptimizer
    NoneAdGroupConversionOptimizer conversionOptimizer = new NoneAdGroupConversionOptimizer();
    conversionOptimizer.setOptimizerType(AdGroupConversionOptimizerType.NONE);

    // adGroup
    AdGroup adGroup = new AdGroup();
    adGroup.setAccountId(SoapUtils.getAccountId());
    adGroup.setCampaignId(campaignId);
    adGroup.setAdGroupName("SampleAppIOSAdGroup_CreateOn_" + SoapUtils.getCurrentTimestamp());
    adGroup.setUserStatus(UserStatus.ACTIVE);
    adGroup.setBid(bid);
    adGroup.setConversionOptimizer(conversionOptimizer);
    adGroup.getDevice().add(DeviceType.SMARTPHONE);
    adGroup.getDeviceOs().add(DeviceOsType.IOS);
    adGroup.getDeviceApp().add(DeviceAppType.APP);
    adGroup.setDynamicImageExtensions(DynamicImageExtensions.ACTIVE);
    adGroup.getSmartDeviceCarriers().add(SmartDeviceCarrier.DOCOMO);

    return adGroup;
  }
  
  /**
   * example App ANDROID AdGroup request.
   *
   * @param campaignId
   * @return AdGroup
   */
  public static AdGroup createExampleAppANDROIDAdGroup(long campaignId)
  {
    // bid
    ManualCPCAdGroupBid bid = new ManualCPCAdGroupBid();
    bid.setType(BiddingStrategyType.MANUAL_CPC);
    bid.setMaxCpc((long)120);

    // conversionOptimizer
    NoneAdGroupConversionOptimizer conversionOptimizer = new NoneAdGroupConversionOptimizer();
    conversionOptimizer.setOptimizerType(AdGroupConversionOptimizerType.NONE);

    // adGroup
    AdGroup adGroup = new AdGroup();
    adGroup.setAccountId(SoapUtils.getAccountId());
    adGroup.setCampaignId(campaignId);
    adGroup.setAdGroupName("SampleAppANDROIDAdGroup_CreateOn_" + SoapUtils.getCurrentTimestamp());
    adGroup.setUserStatus(UserStatus.ACTIVE);
    adGroup.setBid(bid);
    adGroup.setConversionOptimizer(conversionOptimizer);
    adGroup.getDevice().add(DeviceType.TABLET);
    adGroup.getDeviceOs().add(DeviceOsType.ANDROID);
    adGroup.getDeviceApp().add(DeviceAppType.APP);
    adGroup.setDynamicImageExtensions(DynamicImageExtensions.ACTIVE);
    adGroup.getSmartDeviceCarriers().add(SmartDeviceCarrier.SOFTBANK);

    return adGroup;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param adGroups AdGroup
   * @return AdGroupSelector
   */
  public static AdGroupSelector buildExampleGetRequest(long accountId, List<AdGroup> adGroups)
  {
    // Set Selector
    AdGroupSelector selector = new AdGroupSelector();
    selector.setAccountId(accountId);

    for (AdGroup adGroup : adGroups) {
      selector.getCampaignIds().add(adGroup.getCampaignId());
      selector.getAdGroupIds().add(adGroup.getAdGroupId());
    }
    selector.getUserStatuses().addAll(Arrays.asList(UserStatus.ACTIVE, UserStatus.PAUSED));

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
  
  /**
   * example AdGroups set request.
   *
   * @param AdGroups List<AdGroup>
   * @return List<AdGroup>
   */
  public static List<AdGroup> createExampleSetRequest(List<AdGroup> AdGroups)
  {
    // create operands
    List<AdGroup> operands = new ArrayList<>();

    long i = 0;
    for (AdGroup adGroup : AdGroups) {
      // bid
      ManualCPCAdGroupBid bid = new ManualCPCAdGroupBid();
      bid.setMaxCpc((long)120);
      bid.setType(BiddingStrategyType.MANUAL_CPC);

      AdGroup operand = new AdGroup();
      operand.setAccountId(SoapUtils.getAccountId());
      operand.setCampaignId(adGroup.getCampaignId());
      operand.setAdGroupId(adGroup.getAdGroupId());
      operand.setAdGroupName("Sample_UpdateOn_" + i + "_" + SoapUtils.getCurrentTimestamp());
      operand.setUserStatus(UserStatus.PAUSED);
      operand.setBid(bid);
      operand.getDevice().add(DeviceType.SMARTPHONE);
      operand.getDeviceOs().add(DeviceOsType.IOS);
      operand.getDeviceApp().add(DeviceAppType.APP);
      operand.setDynamicImageExtensions(DynamicImageExtensions.PAUSED);
      operand.getSmartDeviceCarriers().add(SmartDeviceCarrier.KDDI);
      operands.add(operand);
      i++;
    }
    return operands;
  }
  
  /**
   * create basic AdGroup.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  public static ValuesHolder create() throws Exception
  {
    ValuesHolder parentValuesHolder = setup();
    ValuesRepositoryFacade parentValuesRepositoryFacade = new ValuesRepositoryFacade(parentValuesHolder);

    long accountId = SoapUtils.getAccountId();
    Long campaignIdStandard = parentValuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);
    Long campaignIdAppIOS = parentValuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(jp.yahooapis.im.v201907.campaign.DeviceOsType.IOS);
    Long campaignIdAppANDROID = parentValuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(jp.yahooapis.im.v201907.campaign.DeviceOsType.ANDROID);

    AdGroupOperation request = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<AdGroup>() {{
      add(createExampleStandardAdGroup(campaignIdStandard));
      add(createExampleAppIOSAdGroup(campaignIdAppIOS));
      add(createExampleAppANDROIDAdGroup(campaignIdAppANDROID));
    }});

    List<AdGroupValues> response = mutate(request);

    ValuesHolder selfValuesHolder = new ValuesHolder();
    selfValuesHolder.setCampaignValuesList(parentValuesHolder.getCampaignValuesList());
    selfValuesHolder.setAdGroupValuesList(response);
    return selfValuesHolder;
  }
}
