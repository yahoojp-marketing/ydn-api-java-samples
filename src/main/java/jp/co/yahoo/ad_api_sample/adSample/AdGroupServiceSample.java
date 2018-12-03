package jp.co.yahoo.ad_api_sample.adSample;

import jp.co.yahoo.ad_api_sample.error.impl.ErrorEntityFactoryImpl;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201812.Paging;
import jp.yahooapis.im.v201812.adgroup.AdGroup;
import jp.yahooapis.im.v201812.adgroup.AdGroupConversionOptimizerType;
import jp.yahooapis.im.v201812.adgroup.AdGroupOperation;
import jp.yahooapis.im.v201812.adgroup.AdGroupPage;
import jp.yahooapis.im.v201812.adgroup.AdGroupReturnValue;
import jp.yahooapis.im.v201812.adgroup.AdGroupSelector;
import jp.yahooapis.im.v201812.adgroup.AdGroupServiceInterface;
import jp.yahooapis.im.v201812.adgroup.AdGroupServiceService;
import jp.yahooapis.im.v201812.adgroup.AdGroupValues;
import jp.yahooapis.im.v201812.adgroup.AutoAdGroupConversionOptimizer;
import jp.yahooapis.im.v201812.adgroup.BiddingStrategyType;
import jp.yahooapis.im.v201812.adgroup.DeviceAppType;
import jp.yahooapis.im.v201812.adgroup.DeviceOsType;
import jp.yahooapis.im.v201812.adgroup.DeviceType;
import jp.yahooapis.im.v201812.adgroup.DynamicImageExtensions;
import jp.yahooapis.im.v201812.adgroup.ManualAdGroupConversionOptimizer;
import jp.yahooapis.im.v201812.adgroup.ManualCPCAdGroupBid;
import jp.yahooapis.im.v201812.adgroup.ManualCPVAdGroupBid;
import jp.yahooapis.im.v201812.adgroup.NoneAdGroupConversionOptimizer;
import jp.yahooapis.im.v201812.adgroup.Operator;
import jp.yahooapis.im.v201812.adgroup.SmartDeviceCarrier;
import jp.yahooapis.im.v201812.adgroup.UserStatus;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.xml.ws.Holder;

/**
 * Sample Program for AdGroupService.<br>
 * Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class AdGroupServiceSample {

  /**
   * main method for AdGroupServiceSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      long campaignId = SoapUtils.getCampaignId();

      // =================================================================
      // AdGroupService ADD
      // =================================================================
      // Set Operation
      AdGroupOperation addAdGroupOperation = createSampleAddRequest(accountId, campaignId);

      // Run
      List<AdGroupValues> adGroupValues = add(addAdGroupOperation);

      // =================================================================
      // AdGroupService GET
      // =================================================================
      // Set Selector
      AdGroupSelector adGroupSelector = createSampleGetRequest(accountId, adGroupValues);

      // Run
      get(adGroupSelector);

      // =================================================================
      // AdGroupService SET
      // =================================================================
      // Set Operation
      AdGroupOperation setAdGroupOperation = createSampleSetRequest(accountId, adGroupValues);

      // Run
      set(setAdGroupOperation);

      // =================================================================
      // AdGroupService REMOVE
      // =================================================================
      // Set Operation
      AdGroupOperation removeAdGroupOperation = createSampleRemoveRequest(accountId, adGroupValues);

      // Run
      remove(removeAdGroupOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for AdGroupService ADD.
   *
   * @param operation AdGroupOperation
   * @return AdGroupValues
   */
  public static List<AdGroupValues> add(AdGroupOperation operation) throws Exception {
    // =================================================================
    // AdGroupService
    // =================================================================
    AdGroupServiceInterface adGroupService = SoapUtils.createServiceInterface(AdGroupServiceInterface.class, AdGroupServiceService.class);

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupService::mutate(ADD)");
    System.out.println("############################################");
    Holder<AdGroupReturnValue> addAdgroupReturnValueHolder = new Holder<AdGroupReturnValue>();
    Holder<List<jp.yahooapis.im.v201812.Error>> addAdGroupErrorHolder = new Holder<List<jp.yahooapis.im.v201812.Error>>();
    adGroupService.mutate(operation, addAdgroupReturnValueHolder, addAdGroupErrorHolder);

    // if error
    if (addAdGroupErrorHolder.value != null && addAdGroupErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(addAdGroupErrorHolder.value), true);
    }

    // response
    if (addAdgroupReturnValueHolder.value != null) {
      AdGroupReturnValue returnValue = addAdgroupReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<AdGroupValues> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            AdGroup adGroup = values.get(i).getAdGroup();
            displayAdGroup(adGroup);
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }

    // Response
    return addAdgroupReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupService SET.
   *
   * @param adGroupOperation AdGroupOperation
   * @return AdGroupValues
   */
  public static List<AdGroupValues> set(AdGroupOperation adGroupOperation) throws Exception {
    // =================================================================
    // AdGroupService
    // =================================================================
    AdGroupServiceInterface adGroupService = SoapUtils.createServiceInterface(AdGroupServiceInterface.class, AdGroupServiceService.class);

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupService::mutate(SET)");
    System.out.println("############################################");
    Holder<AdGroupReturnValue> setAdgroupReturnValueHolder = new Holder<AdGroupReturnValue>();
    Holder<List<jp.yahooapis.im.v201812.Error>> setAdGroupErrorHolder = new Holder<List<jp.yahooapis.im.v201812.Error>>();
    adGroupService.mutate(adGroupOperation, setAdgroupReturnValueHolder, setAdGroupErrorHolder);

    // if error
    if (setAdGroupErrorHolder.value != null && setAdGroupErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(setAdGroupErrorHolder.value), true);
    }

    // response
    if (setAdgroupReturnValueHolder.value != null) {
      AdGroupReturnValue returnValue = setAdgroupReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<AdGroupValues> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayAdGroup(values.get(i).getAdGroup());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }
    // Response
    return setAdgroupReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupService REMOVE.
   *
   * @param operation AdGroupOperation
   * @return AdGroupValues
   */
  public static List<AdGroupValues> remove(AdGroupOperation operation) throws Exception {
    // =================================================================
    // AdGroupService
    // =================================================================
    AdGroupServiceInterface adGroupService = SoapUtils.createServiceInterface(AdGroupServiceInterface.class, AdGroupServiceService.class);

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupService::mutate(REMOVE)");
    System.out.println("############################################");
    Holder<AdGroupReturnValue> removeAdgroupReturnValueHolder = new Holder<AdGroupReturnValue>();
    Holder<List<jp.yahooapis.im.v201812.Error>> removeAdGroupErrorHolder = new Holder<List<jp.yahooapis.im.v201812.Error>>();
    adGroupService.mutate(operation, removeAdgroupReturnValueHolder, removeAdGroupErrorHolder);

    // if error
    if (removeAdGroupErrorHolder.value != null && removeAdGroupErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(removeAdGroupErrorHolder.value), true);
    }

    // response
    if (removeAdgroupReturnValueHolder.value != null) {
      AdGroupReturnValue returnValue = removeAdgroupReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<AdGroupValues> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayAdGroup(values.get(i).getAdGroup());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }

    // Response
    return removeAdgroupReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupService GET.
   *
   * @param selector AdGroupSelector
   * @return AdGroupValues
   * @throws Exception
   */
  public static List<AdGroupValues> get(AdGroupSelector selector) throws Exception {
    // =================================================================
    // AdGroupService
    // =================================================================
    AdGroupServiceInterface adGroupService = SoapUtils.createServiceInterface(AdGroupServiceInterface.class, AdGroupServiceService.class);

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupService::get");
    System.out.println("############################################");
    Holder<AdGroupPage> adGroupPageHolder = new Holder<AdGroupPage>();
    Holder<List<jp.yahooapis.im.v201812.Error>> getAdGroupErrorHolder = new Holder<List<jp.yahooapis.im.v201812.Error>>();
    adGroupService.get(selector, adGroupPageHolder, getAdGroupErrorHolder);

    // if error
    if (getAdGroupErrorHolder.value != null && getAdGroupErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(getAdGroupErrorHolder.value), true);
    }

    // response
    if (adGroupPageHolder.value != null) {
      AdGroupPage adGroupPage = adGroupPageHolder.value;
      if (adGroupPage.getValues() != null && adGroupPage.getValues().size() > 0) {
        List<AdGroupValues> values = adGroupPage.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            displayAdGroup(values.get(i).getAdGroup());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }

    // Response
    return adGroupPageHolder.value.getValues();
  }

  /**
   * create sample request.
   *
   * @param accountId  long
   * @param campaignId long
   * @return AdGroupOperation
   */
  public static AdGroupOperation createSampleAddRequest(long accountId, long campaignId) {

    // create NoneAdGroupConversionOptimizer
    AdGroupOperation addAdGroupOperation = new AdGroupOperation();
    addAdGroupOperation.setOperator(Operator.ADD);
    addAdGroupOperation.setAccountId(accountId);

    AdGroup addAdGroupOperand = new AdGroup();
    addAdGroupOperand.setAccountId(accountId);
    addAdGroupOperand.setCampaignId(campaignId);
    addAdGroupOperand.setAdGroupName("SampleAdGroup1_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addAdGroupOperand.setUserStatus(UserStatus.ACTIVE);

    ManualCPCAdGroupBid addAdGroupBid = new ManualCPCAdGroupBid();
    addAdGroupBid.setType(BiddingStrategyType.MANUAL_CPC);
    addAdGroupBid.setMaxCpc((long) 120);
    addAdGroupOperand.setBid(addAdGroupBid);

    NoneAdGroupConversionOptimizer noneAdGroupConversionOptimizer = new NoneAdGroupConversionOptimizer();
    noneAdGroupConversionOptimizer.setOptimizerType(AdGroupConversionOptimizerType.NONE);
    addAdGroupOperand.setConversionOptimizer(noneAdGroupConversionOptimizer);

    addAdGroupOperand.getDevice().add(DeviceType.SMARTPHONE);
    addAdGroupOperand.getDeviceOs().add(DeviceOsType.IOS);
    addAdGroupOperand.getDeviceApp().add(DeviceAppType.APP);
    addAdGroupOperand.setDynamicImageExtensions(DynamicImageExtensions.ACTIVE);
    addAdGroupOperand.getSmartDeviceCarriers().add(SmartDeviceCarrier.DOCOMO);

    addAdGroupOperation.getOperand().add(addAdGroupOperand);

    return addAdGroupOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId     long
   * @param adGroupValues AdGroupValues
   * @return AdGroupOperation
   */
  public static AdGroupOperation createSampleSetRequest(long accountId, List<AdGroupValues> adGroupValues) {
    // Set Operation
    AdGroupOperation setAdGroupOperation = new AdGroupOperation();
    setAdGroupOperation.setOperator(Operator.SET);
    setAdGroupOperation.setAccountId(accountId);

    // Set Operand
    int i = 0;
    for (AdGroupValues adGroupValue : adGroupValues) {
      AdGroup setAdGroupOperand = new AdGroup();
      setAdGroupOperand.setAccountId(accountId);
      setAdGroupOperand.setCampaignId(adGroupValue.getAdGroup().getCampaignId());
      setAdGroupOperand.setAdGroupId(adGroupValue.getAdGroup().getAdGroupId());
      setAdGroupOperand.setAdGroupName("SampleAdGroup_UpdateOn" + String.valueOf(++i)  + "_" +  SoapUtils.getCurrentTimestamp());
      setAdGroupOperand.setUserStatus(UserStatus.PAUSED);
      ManualCPCAdGroupBid setAdGroupBid = new ManualCPCAdGroupBid();
      setAdGroupBid.setMaxCpc((long) 120);
      setAdGroupBid.setType(BiddingStrategyType.MANUAL_CPC);
      setAdGroupOperand.setBid(setAdGroupBid);
      setAdGroupOperand.getDevice().add(DeviceType.SMARTPHONE);
      setAdGroupOperand.getDeviceOs().add(DeviceOsType.IOS);
      setAdGroupOperand.getDeviceApp().add(DeviceAppType.APP);
      setAdGroupOperand.setDynamicImageExtensions(DynamicImageExtensions.PAUSED);
      setAdGroupOperand.getSmartDeviceCarriers().add(SmartDeviceCarrier.KDDI);

      setAdGroupOperation.getOperand().add(setAdGroupOperand);
    }

    return setAdGroupOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId     long
   * @param adGroupValues AdGroupValues
   * @return AdGroupOperation
   */
  public static AdGroupOperation createSampleRemoveRequest(long accountId, List<AdGroupValues> adGroupValues) {
    // Set Operation
    AdGroupOperation removeAdGroupOperation = new AdGroupOperation();
    removeAdGroupOperation.setOperator(Operator.REMOVE);
    removeAdGroupOperation.setAccountId(accountId);

    // Set Operand
    for (AdGroupValues adGroupValue : adGroupValues) {

      AdGroup removeAdGroupOperand = new AdGroup();
      removeAdGroupOperand.setAccountId(accountId);
      removeAdGroupOperand.setCampaignId(adGroupValue.getAdGroup().getCampaignId());
      removeAdGroupOperand.setAdGroupId(adGroupValue.getAdGroup().getAdGroupId());
      removeAdGroupOperation.getOperand().add(removeAdGroupOperand);

    }

    return removeAdGroupOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId     long
   * @param adGroupValues AdGroupValues
   * @return AdGroupSelector
   */
  public static AdGroupSelector createSampleGetRequest(long accountId, List<AdGroupValues> adGroupValues) {
    // Set Selector
    AdGroupSelector adGroupSelector = new AdGroupSelector();
    adGroupSelector.setAccountId(accountId);

    adGroupSelector.getUserStatuses().addAll(Arrays.asList(UserStatus.ACTIVE, UserStatus.PAUSED));
    for (AdGroupValues adGroupValue : adGroupValues) {
      adGroupSelector.getCampaignIds().add(adGroupValue.getAdGroup().getCampaignId());
      adGroupSelector.getAdGroupIds().add(adGroupValue.getAdGroup().getAdGroupId());
    }

    Paging adGroupPaging = new Paging();
    adGroupPaging.setStartIndex(1);
    adGroupPaging.setNumberResults(20);
    adGroupSelector.setPaging(adGroupPaging);

    return adGroupSelector;
  }

  /**
   * display AdGroup entity to stdout.
   *
   * @param adGroup AdGroup entity for display.
   */
  private static void displayAdGroup(AdGroup adGroup) {
    System.out.println("accountId = " + adGroup.getAccountId());
    System.out.println("campaignId = " + adGroup.getCampaignId());
    System.out.println("campaignName = " + adGroup.getCampaignName());
    System.out.println("adGroupId = " + adGroup.getAdGroupId());
    System.out.println("adGroupName = " + adGroup.getAdGroupName());
    System.out.println("userStatus = " + adGroup.getUserStatus().toString());
    if (adGroup.getBid() != null && Objects.equals(adGroup.getBid().getType(), BiddingStrategyType.MANUAL_CPC)) {
      System.out.println("bid/type = " + (adGroup.getBid()).getType().toString());
      System.out.println("bid/maxCpc = " + ((ManualCPCAdGroupBid) adGroup.getBid()).getMaxCpc().toString());
    } else if (adGroup.getBid() != null && Objects.equals(adGroup.getBid().getType(), BiddingStrategyType.MANUAL_CPV)) {
      System.out.println("bid/type = " + (adGroup.getBid()).getType().toString());
      System.out.println("bid/maxCpv = " + ((ManualCPVAdGroupBid) adGroup.getBid()).getMaxCpv().toString());
    }
    if (adGroup.getDevice() != null) {
      System.out.println("device = " + SoapUtils.arrayToLine(adGroup.getDevice().toArray()));
    }
    if (adGroup.getDeviceOs() != null) {
      System.out.println("deviceOs = " + SoapUtils.arrayToLine(adGroup.getDeviceOs().toArray()));
    }
    if (adGroup.getDeviceApp() != null) {
      System.out.println("deviceApp = " + SoapUtils.arrayToLine(adGroup.getDeviceApp().toArray()));
    }
    if (adGroup.getDynamicImageExtensions() != null) {
      System.out.println("dynamicImageExtensions = " + adGroup.getDynamicImageExtensions().toString());
    }
    if (null != adGroup.getSmartDeviceCarriers() && !adGroup.getSmartDeviceCarriers().isEmpty()) {
      System.out.println("smartDeviceCarriers = " + adGroup.getSmartDeviceCarriers().get(0).toString());
    }
    if (null != adGroup.getConversionOptimizer() ) {
      System.out.println("conversionOptimizer/optimizerType = " + adGroup.getConversionOptimizer().getOptimizerType());
      if (AdGroupConversionOptimizerType.MANUAL.equals(adGroup.getConversionOptimizer().getOptimizerType())) {
        System.out.println("conversionOptimizer/eligibilityFlg = " + ((ManualAdGroupConversionOptimizer)adGroup.getConversionOptimizer()).getEligibilityFlg());
      } else if (AdGroupConversionOptimizerType.AUTO.equals(adGroup.getConversionOptimizer().getOptimizerType())) {
        System.out.println("conversionOptimizer/targetCpa = " + ((AutoAdGroupConversionOptimizer)adGroup.getConversionOptimizer()).getTargetCpa());
        System.out.println("conversionOptimizer/eligibilityFlg = " + ((AutoAdGroupConversionOptimizer)adGroup.getConversionOptimizer()).getEligibilityFlg());
      } else if (AdGroupConversionOptimizerType.NONE.equals(adGroup.getConversionOptimizer().getOptimizerType())) {
        System.out.println("conversionOptimizer/eligibilityFlg = " + ((NoneAdGroupConversionOptimizer)adGroup.getConversionOptimizer()).getEligibilityFlg());
      }
    }
    System.out.println("---------");
  }

}
