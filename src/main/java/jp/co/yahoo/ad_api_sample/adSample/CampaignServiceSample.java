package jp.co.yahoo.ad_api_sample.adSample;

import jp.co.yahoo.ad_api_sample.error.impl.ErrorEntityFactoryImpl;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201812.Error;
import jp.yahooapis.im.v201812.Paging;
import jp.yahooapis.im.v201812.campaign.AutoCampaignConversionOptimizer;
import jp.yahooapis.im.v201812.campaign.BiddingStrategyType;
import jp.yahooapis.im.v201812.campaign.Budget;
import jp.yahooapis.im.v201812.campaign.BudgetDeliveryMethod;
import jp.yahooapis.im.v201812.campaign.Campaign;
import jp.yahooapis.im.v201812.campaign.CampaignConversionOptimizerType;
import jp.yahooapis.im.v201812.campaign.CampaignOperation;
import jp.yahooapis.im.v201812.campaign.CampaignPage;
import jp.yahooapis.im.v201812.campaign.CampaignReturnValue;
import jp.yahooapis.im.v201812.campaign.CampaignSelector;
import jp.yahooapis.im.v201812.campaign.CampaignServiceInterface;
import jp.yahooapis.im.v201812.campaign.CampaignServiceService;
import jp.yahooapis.im.v201812.campaign.CampaignType;
import jp.yahooapis.im.v201812.campaign.CampaignValues;
import jp.yahooapis.im.v201812.campaign.DeviceOsType;
import jp.yahooapis.im.v201812.campaign.FrequencyCap;
import jp.yahooapis.im.v201812.campaign.FrequencyLevel;
import jp.yahooapis.im.v201812.campaign.FrequencyTimeUnit;
import jp.yahooapis.im.v201812.campaign.ManualCPC;
import jp.yahooapis.im.v201812.campaign.ManualCampaignConversionOptimizer;
import jp.yahooapis.im.v201812.campaign.Operator;
import jp.yahooapis.im.v201812.campaign.UserStatus;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for CampaignService.<br>
 * Copyright (C) 2016 Yahoo Japan Corporation. All Rights Reserved.
 */
public class CampaignServiceSample {
  /**
   * main method for CampaignServiceSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();

      // =================================================================
      // CampaignService::ADD
      // =================================================================
      // Set Operation
      CampaignOperation addCampaignOperation = createSampleAddRequest(accountId);

      // Run
      List<CampaignValues> addCampaignValues = add(addCampaignOperation);

      // =================================================================
      // CampaignService::GET
      // =================================================================
      // Set Selector
      CampaignSelector campaignSelector = createSampleGetRequest(accountId, addCampaignValues);

      // Run
      get(campaignSelector);

      // =================================================================
      // CampaignService::SET
      // =================================================================
      // Set Operation
      CampaignOperation setCampaignOperation = createSampleSetRequest(accountId, addCampaignValues);

      // Run
      set(setCampaignOperation);

      // =================================================================
      // CampaignService::REMOVE
      // =================================================================
      // Set Operation
      CampaignOperation removeCampaignOperation = createSampleRemoveRequest(accountId, addCampaignValues);

      // Run
      remove(removeCampaignOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for CampaignService ADD.
   *
   * @param operation CampaignOperation
   * @return CampaignValues
   */
  public static List<CampaignValues> add(CampaignOperation operation) throws Exception {
    // =================================================================
    // CampaignService
    // =================================================================
    CampaignServiceInterface campaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignServiceService.class);

    // call API
    System.out.println("############################################");
    System.out.println("CampaignService::mutate(ADD)");
    System.out.println("############################################");
    Holder<CampaignReturnValue> addCampaignReturnValueHolder = new Holder<CampaignReturnValue>();
    Holder<List<Error>> addCampaignErrorHolder = new Holder<List<Error>>();
    campaignService.mutate(operation, addCampaignReturnValueHolder, addCampaignErrorHolder);

    // if error
    if (addCampaignErrorHolder.value != null && addCampaignErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(addCampaignErrorHolder.value), true);
    }

    // response
    if (addCampaignReturnValueHolder.value != null) {
      CampaignReturnValue returnValue = addCampaignReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<CampaignValues> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            Campaign campaign = values.get(i).getCampaign();
            displayCampaign(campaign);
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }
    // Response
    return addCampaignReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignService SET.
   *
   * @param operation CampaignOperation
   * @return CampaignValues
   */
  public static List<CampaignValues> set(CampaignOperation operation) throws Exception {
    // =================================================================
    // CampaignService
    // =================================================================
    CampaignServiceInterface campaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignServiceService.class);

    // call API
    System.out.println("############################################");
    System.out.println("CampaignService::mutate(SET)");
    System.out.println("############################################");
    Holder<CampaignReturnValue> setCampaignReturnValueHolder = new Holder<CampaignReturnValue>();
    Holder<List<Error>> setCampaignErrorHolder = new Holder<List<Error>>();
    campaignService.mutate(operation, setCampaignReturnValueHolder, setCampaignErrorHolder);

    // if error
    if (setCampaignErrorHolder.value != null && setCampaignErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(setCampaignErrorHolder.value), true);
    }

    // response
    if (setCampaignReturnValueHolder.value != null) {
      CampaignReturnValue returnValue = setCampaignReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<CampaignValues> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayCampaign(values.get(i).getCampaign());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }


    // Response
    return setCampaignReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignService REMOVE.
   *
   * @param operation CampaignOperation
   * @return CampaignValues
   */
  public static List<CampaignValues> remove(CampaignOperation operation) throws Exception {
    // =================================================================
    // CampaignService
    // =================================================================
    CampaignServiceInterface campaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignServiceService.class);

    System.out.println("############################################");
    System.out.println("CampaignService::mutate(REMOVE)");
    System.out.println("############################################");
    Holder<CampaignReturnValue> removeCampaignReturnValueHolder = new Holder<CampaignReturnValue>();
    Holder<List<Error>> removeCampaignErrorHolder = new Holder<List<Error>>();
    campaignService.mutate(operation, removeCampaignReturnValueHolder, removeCampaignErrorHolder);

    // if error
    if (removeCampaignErrorHolder.value != null && removeCampaignErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(removeCampaignErrorHolder.value), true);
    }

    // response
    if (removeCampaignReturnValueHolder.value != null) {
      CampaignReturnValue returnValue = removeCampaignReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<CampaignValues> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayCampaign(values.get(i).getCampaign());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }
    return removeCampaignReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignService GET.
   *
   * @param selector CampaignSelector
   * @return CampaignValues
   */
  public static List<CampaignValues> get(CampaignSelector selector) throws Exception {
    // =================================================================
    // CampaignService
    // =================================================================
    CampaignServiceInterface campaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignServiceService.class);


    System.out.println("############################################");
    System.out.println("CampaignService::get");
    System.out.println("############################################");
    Holder<CampaignPage> campaignPageHolder = new Holder<CampaignPage>();
    Holder<List<Error>> getCampaignErrorHolder = new Holder<List<Error>>();
    campaignService.get(selector, campaignPageHolder, getCampaignErrorHolder);

    // if error
    if (getCampaignErrorHolder.value != null && getCampaignErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(getCampaignErrorHolder.value), true);
    }

    // response
    if (campaignPageHolder.value != null) {
      CampaignPage campaignPage = campaignPageHolder.value;
      if (campaignPage.getValues() != null && campaignPage.getValues().size() > 0) {
        List<CampaignValues> values = campaignPage.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            displayCampaign(values.get(i).getCampaign());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }

    // Response
    return campaignPageHolder.value.getValues();
  }


  /**
   * create sample request.
   *
   * @param accountId long
   * @return CampaignOperation
   */
  public static CampaignOperation createSampleAddRequest(long accountId) {
    Campaign standardCampaignOperand = new Campaign();
    standardCampaignOperand.setAccountId(accountId);
    standardCampaignOperand.setCampaignName("SampleCampaign_CreateOn_" + SoapUtils.getCurrentTimestamp());
    standardCampaignOperand.setUserStatus(jp.yahooapis.im.v201812.campaign.UserStatus.ACTIVE);
    standardCampaignOperand.setStartDate("20300101");
    standardCampaignOperand.setEndDate("20301231");
    Budget standardBudget = new Budget();
    standardBudget.setAmount((long) 1000);
    standardBudget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);
    standardCampaignOperand.setBudget(standardBudget);
    ManualCPC standardManualCPC = new ManualCPC();
    standardManualCPC.setType(BiddingStrategyType.MANUAL_CPC);
    standardCampaignOperand.setBiddingStrategy(standardManualCPC);
    standardCampaignOperand.setAdProductType("TARGET_MATCH");
    FrequencyCap standardFequencyCap = new FrequencyCap();
    standardFequencyCap.setLevel(FrequencyLevel.CAMPAIGN);
    standardFequencyCap.setTimeUnit(FrequencyTimeUnit.WEEK);
    standardFequencyCap.setImpression((long) 10);
    standardCampaignOperand.setFrequencyCap(standardFequencyCap);
    standardCampaignOperand.setCampaignType(CampaignType.STANDARD);

    Campaign androidCampaignOperand = new Campaign();
    androidCampaignOperand.setAccountId(accountId);
    androidCampaignOperand.setCampaignName("AndroidCampaign_CreateOn_" + SoapUtils.getCurrentTimestamp());
    androidCampaignOperand.setUserStatus(jp.yahooapis.im.v201812.campaign.UserStatus.ACTIVE);
    androidCampaignOperand.setStartDate("20300101");
    androidCampaignOperand.setEndDate("20301231");
    Budget androidBudget = new Budget();
    androidBudget.setAmount((long) 1000);
    androidBudget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);
    androidCampaignOperand.setBudget(androidBudget);
    ManualCPC androidManualCPC = new ManualCPC();
    androidManualCPC.setType(BiddingStrategyType.MANUAL_CPC);
    androidCampaignOperand.setBiddingStrategy(androidManualCPC);
    androidCampaignOperand.setAdProductType("TARGET_MATCH");
    FrequencyCap androidFrequencyCap = new FrequencyCap();
    androidFrequencyCap.setLevel(FrequencyLevel.CAMPAIGN);
    androidFrequencyCap.setTimeUnit(FrequencyTimeUnit.WEEK);
    androidFrequencyCap.setImpression((long) 10);
    androidCampaignOperand.setFrequencyCap(androidFrequencyCap);
    androidCampaignOperand.setCampaignType(CampaignType.APP);
    androidCampaignOperand.setAppOs(DeviceOsType.ANDROID);
    androidCampaignOperand.setAppId("jp.co.yahoo.sample");
    androidCampaignOperand.setAppName("Sample Android app");
    ManualCampaignConversionOptimizer manualCampaignConversionOptimizer = new ManualCampaignConversionOptimizer();
    manualCampaignConversionOptimizer.setOptimizerType(CampaignConversionOptimizerType.MANUAL);
    androidCampaignOperand.setConversionOptimizer(manualCampaignConversionOptimizer);

    Campaign iosCampaignOperand = new Campaign();
    iosCampaignOperand.setAccountId(accountId);
    iosCampaignOperand.setCampaignName("IOSCampaign_CreateOn_" + SoapUtils.getCurrentTimestamp());
    iosCampaignOperand.setUserStatus(jp.yahooapis.im.v201812.campaign.UserStatus.ACTIVE);
    iosCampaignOperand.setStartDate("20300101");
    iosCampaignOperand.setEndDate("20301231");
    Budget iosBudget = new Budget();
    iosBudget.setAmount((long) 1000);
    iosBudget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);
    iosCampaignOperand.setBudget(iosBudget);
    ManualCPC iosManualCPC = new ManualCPC();
    iosManualCPC.setType(BiddingStrategyType.MANUAL_CPC);
    iosCampaignOperand.setBiddingStrategy(iosManualCPC);
    iosCampaignOperand.setAdProductType("TARGET_MATCH");
    FrequencyCap iosFrequencyCap = new FrequencyCap();
    iosFrequencyCap.setLevel(FrequencyLevel.CAMPAIGN);
    iosFrequencyCap.setTimeUnit(FrequencyTimeUnit.WEEK);
    iosFrequencyCap.setImpression((long) 10);
    iosCampaignOperand.setFrequencyCap(iosFrequencyCap);
    iosCampaignOperand.setCampaignType(CampaignType.APP);
    iosCampaignOperand.setAppOs(DeviceOsType.IOS);
    iosCampaignOperand.setAppId("1234567890");
    iosCampaignOperand.setAppName("Sample IOS app");

    CampaignOperation addCampaignOperation = new CampaignOperation();
    addCampaignOperation.setOperator(jp.yahooapis.im.v201812.campaign.Operator.ADD);
    addCampaignOperation.setAccountId(accountId);
    addCampaignOperation.getOperand().add(standardCampaignOperand);
    addCampaignOperation.getOperand().add(androidCampaignOperand);
    addCampaignOperation.getOperand().add(iosCampaignOperand);
    AutoCampaignConversionOptimizer autoCampaignConversionOptimizer = new AutoCampaignConversionOptimizer();
    autoCampaignConversionOptimizer.setOptimizerType(CampaignConversionOptimizerType.AUTO);
    androidCampaignOperand.setConversionOptimizer(autoCampaignConversionOptimizer);


    return addCampaignOperation;
  }


  /**
   * create sample request.
   *
   * @param accountId      long
   * @param campaignValues CampaignValues
   * @return CampaignOperation
   */
  public static CampaignOperation createSampleSetRequest(long accountId, List<CampaignValues> campaignValues) {
    CampaignOperation setCampaignOperation = new CampaignOperation();
    setCampaignOperation.setOperator(jp.yahooapis.im.v201812.campaign.Operator.SET);
    setCampaignOperation.setAccountId(accountId);

    for (CampaignValues campaignValue : campaignValues) {
      Campaign setCampaignOperand = new Campaign();
      setCampaignOperand.setAccountId(campaignValue.getCampaign().getAccountId());
      setCampaignOperand.setCampaignId(campaignValue.getCampaign().getCampaignId());
      setCampaignOperand.setCampaignName("SampleCampaign_UpdateOn_" + SoapUtils.getCurrentTimestamp() + campaignValue.getCampaign().getCampaignId());
      setCampaignOperand.setUserStatus(jp.yahooapis.im.v201812.campaign.UserStatus.PAUSED);
      setCampaignOperand.setStartDate("20300101");
      setCampaignOperand.setEndDate("20301231");
      Budget setCamapginBudget = new Budget();
      setCamapginBudget.setAmount((long) 1000);
      setCamapginBudget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);
      setCampaignOperand.setBudget(setCamapginBudget);
      ManualCPC setCampaignManualCpc = new ManualCPC();
      setCampaignManualCpc.setType(BiddingStrategyType.MANUAL_CPC);
      setCampaignOperand.setBiddingStrategy(setCampaignManualCpc);
      FrequencyCap setFrequencyCap = new FrequencyCap();
      setFrequencyCap.setLevel(FrequencyLevel.AD_GROUP);
      setFrequencyCap.setTimeUnit(FrequencyTimeUnit.DAY);
      setFrequencyCap.setImpression((long) 5);
      setCampaignOperand.setFrequencyCap(setFrequencyCap);
      setCampaignOperation.getOperand().add(setCampaignOperand);
    }

    return setCampaignOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId      long
   * @param campaignValues CampaignValues
   * @return CampaignOperation
   */
  public static CampaignOperation createSampleRemoveRequest(long accountId, List<CampaignValues> campaignValues) {
    // Set Operation
    CampaignOperation operation = new CampaignOperation();
    operation.setOperator(Operator.REMOVE);
    operation.setAccountId(accountId);

    // Set Operand
    for (CampaignValues campaignValue : campaignValues) {

      Campaign campaign = new Campaign();
      campaign.setAccountId(campaignValue.getCampaign().getAccountId());
      campaign.setCampaignId(campaignValue.getCampaign().getCampaignId());

      operation.getOperand().add(campaign);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId      long
   * @param campaignValues CampaignValues
   * @return CampaignSelector
   */
  public static CampaignSelector createSampleGetRequest(long accountId, List<CampaignValues> campaignValues) {
    // Set Selector
    CampaignSelector campaignSelector = new CampaignSelector();
    campaignSelector.setAccountId(accountId);
    campaignSelector.getUserStatus().addAll(Arrays.asList(UserStatus.ACTIVE, UserStatus.PAUSED));

    for (CampaignValues campaignValue : campaignValues) {
      campaignSelector.getCampaignIds().add((campaignValue.getCampaign().getCampaignId()));
    }

    Paging campaignPaging = new Paging();
    campaignPaging.setStartIndex(1);
    campaignPaging.setNumberResults(20);
    campaignSelector.setPaging(campaignPaging);

    return campaignSelector;
  }

  /**
   * display Campaign entity to stdout.
   *
   * @param campaign Campaign entity for display.
   */
  private static void displayCampaign(Campaign campaign) {
    System.out.println("accountId = " + campaign.getAccountId());
    System.out.println("campaignId = " + campaign.getCampaignId());
    System.out.println("campaignName = " + campaign.getCampaignName());
    System.out.println("userStatus = " + campaign.getUserStatus().toString());
    System.out.println("startDate = " + campaign.getStartDate());
    System.out.println("endDate = " + campaign.getEndDate());
    System.out.println("campaignType = " + campaign.getCampaignType());
    System.out.println("appId = " + campaign.getAppId());
    System.out.println("appName = " + campaign.getAppName());
    System.out.println("appOs = " + campaign.getAppOs());
    if (campaign.getBudget() != null) {
      System.out.println("budget/amount = " + campaign.getBudget().getAmount());
      System.out.println("budget/deliveryMethod = " + campaign.getBudget().getDeliveryMethod().toString());
    }
    if (campaign.getBiddingStrategy() != null) {
      System.out.println("biddingStrategy = " + campaign.getBiddingStrategy().getType().toString());
    }
    System.out.println("adProductType = " + campaign.getAdProductType());
    if (campaign.getFrequencyCap() != null) {
      System.out.println("frequencyCap/level = " + campaign.getFrequencyCap().getLevel());
      System.out.println("frequencyCap/timeUnit = " + campaign.getFrequencyCap().getTimeUnit());
      System.out.println("frequencyCap/impression = " + campaign.getFrequencyCap().getImpression());
    }
    if (campaign.getConversionOptimizer() != null) {
      System.out.println("conversionOptimizer/optimizerType = " + campaign.getConversionOptimizer().getOptimizerType());
      if (campaign.getConversionOptimizer() instanceof AutoCampaignConversionOptimizer) {
        System.out.println("conversionOptimizer/targetCpa = " + ((AutoCampaignConversionOptimizer) campaign.getConversionOptimizer()).getTargetCpa());
        System.out.println("conversionOptimizer/eligibilityFlg = " + ((AutoCampaignConversionOptimizer) campaign.getConversionOptimizer()).getEligibilityFlg());
      } else if(campaign.getConversionOptimizer() instanceof ManualCampaignConversionOptimizer) {
        System.out.println("conversionOptimizer/eligibilityFlg = " + ((ManualCampaignConversionOptimizer) campaign.getConversionOptimizer()).getEligibilityFlg());
      }
    }
    System.out.println("---------");
  }
}
