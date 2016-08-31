package jp.co.yahoo.ad_api_sample.adSample;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.AdGroupServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.V5.AdGroupService.AdGroup;
import jp.yahooapis.im.V5.AdGroupService.AdGroupOperation;
import jp.yahooapis.im.V5.AdGroupService.AdGroupPage;
import jp.yahooapis.im.V5.AdGroupService.AdGroupReturnValue;
import jp.yahooapis.im.V5.AdGroupService.AdGroupSelector;
import jp.yahooapis.im.V5.AdGroupService.AdGroupServiceInterface;
import jp.yahooapis.im.V5.AdGroupService.AdGroupServiceService;
import jp.yahooapis.im.V5.AdGroupService.AdGroupValues;
import jp.yahooapis.im.V5.AdGroupService.BiddingStrategyType;
import jp.yahooapis.im.V5.AdGroupService.DeviceAppType;
import jp.yahooapis.im.V5.AdGroupService.DeviceOsType;
import jp.yahooapis.im.V5.AdGroupService.DeviceType;
import jp.yahooapis.im.V5.AdGroupService.DynamicImageExtensions;
import jp.yahooapis.im.V5.AdGroupService.ManualCPCAdGroupBid;
import jp.yahooapis.im.V5.AdGroupService.Operator;
import jp.yahooapis.im.V5.AdGroupService.Paging;
import jp.yahooapis.im.V5.AdGroupService.SmartDeviceCarrier;
import jp.yahooapis.im.V5.AdGroupService.UserStatus;

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
   * @throws Exception
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
    Holder<List<jp.yahooapis.im.V5.AdGroupService.Error>> addAdGroupErrorHolder = new Holder<List<jp.yahooapis.im.V5.AdGroupService.Error>>();
    adGroupService.mutate(operation, addAdgroupReturnValueHolder, addAdGroupErrorHolder);

    // if error
    if (addAdGroupErrorHolder.value != null && addAdGroupErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupServiceErrorEntityFactory(addAdGroupErrorHolder.value), true);
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
            SoapUtils.displayErrors(new AdGroupServiceErrorEntityFactory(values.get(i).getError()), true);
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
   * @throws Exception
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
    Holder<List<jp.yahooapis.im.V5.AdGroupService.Error>> setAdGroupErrorHolder = new Holder<List<jp.yahooapis.im.V5.AdGroupService.Error>>();
    adGroupService.mutate(adGroupOperation, setAdgroupReturnValueHolder, setAdGroupErrorHolder);

    // if error
    if (setAdGroupErrorHolder.value != null && setAdGroupErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupServiceErrorEntityFactory(setAdGroupErrorHolder.value), true);
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
            SoapUtils.displayErrors(new AdGroupServiceErrorEntityFactory(values.get(i).getError()), true);
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
   * @throws Exception
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
    Holder<List<jp.yahooapis.im.V5.AdGroupService.Error>> removeAdGroupErrorHolder = new Holder<List<jp.yahooapis.im.V5.AdGroupService.Error>>();
    adGroupService.mutate(operation, removeAdgroupReturnValueHolder, removeAdGroupErrorHolder);

    // if error
    if (removeAdGroupErrorHolder.value != null && removeAdGroupErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupServiceErrorEntityFactory(removeAdGroupErrorHolder.value), true);
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
            SoapUtils.displayErrors(new AdGroupServiceErrorEntityFactory(values.get(i).getError()), true);
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
    Holder<List<jp.yahooapis.im.V5.AdGroupService.Error>> getAdGroupErrorHolder = new Holder<List<jp.yahooapis.im.V5.AdGroupService.Error>>();
    adGroupService.get(selector, adGroupPageHolder, getAdGroupErrorHolder);

    // if error
    if (getAdGroupErrorHolder.value != null && getAdGroupErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupServiceErrorEntityFactory(getAdGroupErrorHolder.value), true);
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
            SoapUtils.displayErrors(new AdGroupServiceErrorEntityFactory(values.get(i).getError()), true);
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
   * @param accountId long
   * @param campaignId long
   * @return AdGroupOperation
   */
  public static AdGroupOperation createSampleAddRequest(long accountId, long campaignId) {
    AdGroup addAdGroupOperand = new AdGroup();
    addAdGroupOperand.setAccountId(accountId);
    addAdGroupOperand.setCampaignId(campaignId);
    addAdGroupOperand.setAdGroupName("SampleAdGroup_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addAdGroupOperand.setUserStatus(UserStatus.ACTIVE);
    ManualCPCAdGroupBid addAdGroupBid = new ManualCPCAdGroupBid();
    addAdGroupBid.setType(BiddingStrategyType.MANUAL_CPC);
    addAdGroupBid.setMaxCpc((long) 120);
    addAdGroupOperand.setBid(addAdGroupBid);
    addAdGroupOperand.getDevice().add(DeviceType.SMARTPHONE);
    addAdGroupOperand.getDeviceOs().add(DeviceOsType.IOS);
    addAdGroupOperand.getDeviceApp().add(DeviceAppType.APP);
    addAdGroupOperand.setDynamicImageExtensions(DynamicImageExtensions.ACTIVE);
    addAdGroupOperand.getSmartDeviceCarriers().add(SmartDeviceCarrier.DOCOMO);

    AdGroupOperation addAdGroupOperation = new AdGroupOperation();
    addAdGroupOperation.setOperator(Operator.ADD);
    addAdGroupOperation.setAccountId(accountId);
    addAdGroupOperation.setCampaignId(campaignId);
    addAdGroupOperation.getOperand().add(addAdGroupOperand);

    return addAdGroupOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param adGroupValues AdGroupValues
   * @return AdGroupOperation
   */
  public static AdGroupOperation createSampleSetRequest(long accountId, List<AdGroupValues> adGroupValues) {
    // Set Operation
    AdGroupOperation setAdGroupOperation = new AdGroupOperation();
    setAdGroupOperation.setOperator(Operator.SET);
    setAdGroupOperation.setAccountId(accountId);

    // Set Operand
    for (AdGroupValues adGroupValue : adGroupValues) {
      setAdGroupOperation.setCampaignId(adGroupValue.getAdGroup().getCampaignId());
      AdGroup setAdGroupOperand = new AdGroup();
      setAdGroupOperand.setAccountId(accountId);
      setAdGroupOperand.setCampaignId(adGroupValue.getAdGroup().getCampaignId());
      setAdGroupOperand.setAdGroupId(adGroupValue.getAdGroup().getAdGroupId());
      setAdGroupOperand.setAdGroupName("SampleAdGroup_UpdateOn_" + SoapUtils.getCurrentTimestamp());
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
   * @param accountId long
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

      removeAdGroupOperation.setCampaignId(adGroupValue.getAdGroup().getCampaignId());
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
   * @param accountId long
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
    if (adGroup.getBid() != null) {
      System.out.println("bid/type = " + ((ManualCPCAdGroupBid) adGroup.getBid()).getType().toString());
      System.out.println("bid/maxCpc = " + ((ManualCPCAdGroupBid) adGroup.getBid()).getMaxCpc().toString());
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
    if(null != adGroup.getSmartDeviceCarriers() && !adGroup.getSmartDeviceCarriers().isEmpty()){
      System.out.println("smartDeviceCarriers = " + adGroup.getSmartDeviceCarriers().get(0).toString());
    }
    System.out.println("---------");
  }

}
