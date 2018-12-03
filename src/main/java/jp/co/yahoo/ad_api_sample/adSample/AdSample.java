package jp.co.yahoo.ad_api_sample.adSample;

import jp.co.yahoo.ad_api_sample.error.impl.ErrorEntityFactoryImpl;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201812.adgroup.AdGroup;
import jp.yahooapis.im.v201812.adgroup.AdGroupOperation;
import jp.yahooapis.im.v201812.adgroup.AdGroupSelector;
import jp.yahooapis.im.v201812.adgroup.AdGroupValues;
import jp.yahooapis.im.v201812.adgroupad.AdGroupAdOperation;
import jp.yahooapis.im.v201812.adgroupad.AdGroupAdSelector;
import jp.yahooapis.im.v201812.adgroupad.AdGroupAdValues;
import jp.yahooapis.im.v201812.adgrouptarget.AdGroupTarget;
import jp.yahooapis.im.v201812.adgrouptarget.AdGroupTargetMutateOperation;
import jp.yahooapis.im.v201812.adgrouptarget.AdGroupTargetOperation;
import jp.yahooapis.im.v201812.adgrouptarget.AdGroupTargetPage;
import jp.yahooapis.im.v201812.adgrouptarget.AdGroupTargetReturnValue;
import jp.yahooapis.im.v201812.adgrouptarget.AdGroupTargetSelector;
import jp.yahooapis.im.v201812.adgrouptarget.AdGroupTargetServiceInterface;
import jp.yahooapis.im.v201812.adgrouptarget.AdGroupTargetServiceService;
import jp.yahooapis.im.v201812.adgrouptarget.AdGroupTargetValue;
import jp.yahooapis.im.v201812.adgrouptarget.AdScheduleTarget;
import jp.yahooapis.im.v201812.adgrouptarget.Age;
import jp.yahooapis.im.v201812.adgrouptarget.AgeTarget;
import jp.yahooapis.im.v201812.adgrouptarget.AppTarget;
import jp.yahooapis.im.v201812.adgrouptarget.CarrierTarget;
import jp.yahooapis.im.v201812.adgrouptarget.DayOfWeek;
import jp.yahooapis.im.v201812.adgrouptarget.DeviceTarget;
import jp.yahooapis.im.v201812.adgrouptarget.EstimateFlg;
import jp.yahooapis.im.v201812.adgrouptarget.Gender;
import jp.yahooapis.im.v201812.adgrouptarget.GenderTarget;
import jp.yahooapis.im.v201812.adgrouptarget.GeoTarget;
import jp.yahooapis.im.v201812.adgrouptarget.InterestCategoryTarget;
import jp.yahooapis.im.v201812.adgrouptarget.Operator;
import jp.yahooapis.im.v201812.adgrouptarget.OsTarget;
import jp.yahooapis.im.v201812.adgrouptarget.OsVersionTarget;
import jp.yahooapis.im.v201812.adgrouptarget.PlacementTarget;
import jp.yahooapis.im.v201812.adgrouptarget.SearchTarget;
import jp.yahooapis.im.v201812.adgrouptarget.SiteCategoryTarget;
import jp.yahooapis.im.v201812.adgrouptarget.SiteRetargetingTarget;
import jp.yahooapis.im.v201812.adgrouptarget.Target;
import jp.yahooapis.im.v201812.adgrouptarget.TargetType;
import jp.yahooapis.im.v201812.campaign.BiddingStrategyType;
import jp.yahooapis.im.v201812.campaign.Budget;
import jp.yahooapis.im.v201812.campaign.BudgetDeliveryMethod;
import jp.yahooapis.im.v201812.campaign.Campaign;
import jp.yahooapis.im.v201812.campaign.CampaignOperation;
import jp.yahooapis.im.v201812.campaign.CampaignSelector;
import jp.yahooapis.im.v201812.campaign.CampaignType;
import jp.yahooapis.im.v201812.campaign.CampaignValues;
import jp.yahooapis.im.v201812.campaign.FrequencyCap;
import jp.yahooapis.im.v201812.campaign.FrequencyLevel;
import jp.yahooapis.im.v201812.campaign.FrequencyTimeUnit;
import jp.yahooapis.im.v201812.campaign.ManualCPC;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for CampaignService,AdGroupService,AdGroupAdService,AdGroupTargetService.
 * Copyright (C) 2016 Yahoo Japan Corporation. All Rights Reserved.
 */
public class AdSample {
  /**
   * main method for AdSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {

    try {
      long accountId = SoapUtils.getAccountId();
      long campaignId = -1;
      long adGroupId = -1;

      // -----------------------------------------------
      // CampaignService::mutate(ADD)
      // -----------------------------------------------
      // request
      CampaignOperation addCampaignOperation = createSampleAddRequest(accountId);
      // call API
      List<CampaignValues> campaignValues = CampaignServiceSample.add(addCampaignOperation);

      for (CampaignValues values : campaignValues) {
        if (values.isOperationSucceeded()) {
          // display response
          Campaign campaign = values.getCampaign();
          campaignId = campaign.getCampaignId();
        }
      }

      // -----------------------------------------------
      // CampaignService::get
      // -----------------------------------------------
      // request
      CampaignSelector campaignSelector = CampaignServiceSample.createSampleGetRequest(accountId, campaignValues);
      // call API
      CampaignServiceSample.get(campaignSelector);

      // -----------------------------------------------
      // CampaignService::mutate(SET)
      // -----------------------------------------------
      // request
      CampaignOperation setCampaignOperation = CampaignServiceSample.createSampleSetRequest(accountId, campaignValues);
      // call API
      CampaignServiceSample.set(setCampaignOperation);

      // -----------------------------------------------
      // AdGroupService::mutate(ADD)
      // -----------------------------------------------
      // request
      AdGroupOperation addAdGroupOperation = AdGroupServiceSample.createSampleAddRequest(accountId, campaignId);

      // call API
      List<AdGroupValues> adGroupValues = AdGroupServiceSample.add(addAdGroupOperation);

      // response
      for (AdGroupValues values : adGroupValues) {
        if (values.isOperationSucceeded()) {
          AdGroup adGroup = values.getAdGroup();
          adGroupId = adGroup.getAdGroupId();
        }
      }

      // -----------------------------------------------
      // AdGroupService::get
      // -----------------------------------------------
      // request
      AdGroupSelector adGroupSelector = AdGroupServiceSample.createSampleGetRequest(accountId, adGroupValues);

      // call API
      AdGroupServiceSample.get(adGroupSelector);

      // -----------------------------------------------
      // AdGroupService::mutate(SET)
      // -----------------------------------------------
      // request
      AdGroupOperation setAdGroupOperation = AdGroupServiceSample.createSampleSetRequest(accountId, adGroupValues);

      // call API
      AdGroupServiceSample.set(setAdGroupOperation);

      // -----------------------------------------------
      // AdGroupAdService::add
      // -----------------------------------------------
      // request
      AdGroupAdOperation addAdGroupAdOperation = AdGroupAdServiceSample.createSampleAddRequest(accountId, campaignId, adGroupId);

      // call API
      List<AdGroupAdValues> adGroupAdValues = AdGroupAdServiceSample.add(addAdGroupAdOperation);

      // -----------------------------------------------
      // AdGroupAdService::get
      // -----------------------------------------------
      // request
      AdGroupAdSelector adGroupAdSelector = AdGroupAdServiceSample.createSampleGetRequest(accountId, adGroupAdValues);

      // call API
      AdGroupAdServiceSample.get(adGroupAdSelector);

      // sleep 10 second for review.
      System.out.println("***** sleep 10 seconds for ad review *****");
      Thread.sleep(10000);

      // -----------------------------------------------
      // AdGroupAdService::mutate(SET)
      // -----------------------------------------------
      // request
      AdGroupAdOperation setAdGroupAdOperation = AdGroupAdServiceSample.createSampleSetRequest(accountId, adGroupAdValues);

      // call API
      AdGroupAdServiceSample.set(setAdGroupAdOperation);

      // -----------------------------------------------
      // AdGroupTargetService::mutate(ADD)
      // -----------------------------------------------
      // request
      AdGroupTargetMutateOperation addAdGroupTargetMutateOperation = createAdGroupTargetSampleAddRequest(accountId, campaignId, adGroupId);

      // call API
      List<AdGroupTargetValue> adGroupTargetValues = addAdGroupTarget(addAdGroupTargetMutateOperation);

      // -----------------------------------------------
      // AdGroupTargetService::mutate(SET)
      // -----------------------------------------------
      // request
      AdGroupTargetMutateOperation setAdGroupTargetMutateOperation = createAdGroupTargetSampleSetRequest(accountId, adGroupTargetValues);

      // call API
      setAdGroupTarget(setAdGroupTargetMutateOperation);

      // -----------------------------------------------
      // AdGroupTargetService::replace
      // -----------------------------------------------
      // request
      AdGroupTargetOperation replaceAdGroupTargetMutateOperation = createAdGroupTargetSampleReplaceRequest(accountId, campaignId, adGroupId);

      // call API
      replaceAdGroupTarget(replaceAdGroupTargetMutateOperation);

      // -----------------------------------------------
      // AdGroupTargetService::get
      // -----------------------------------------------
      // request
      AdGroupTargetSelector adGroupTargetSelector = createAdGroupTargetSampleGetRequest(accountId, campaignId, adGroupId);

      // call API
      adGroupTargetValues = getAdGroupTarget(adGroupTargetSelector);

      // =================================================================
      // remove AdGroupTarget, AdGroupAd, AdGroup, Campaign
      // =================================================================

      // -----------------------------------------------
      // AdGroupTargetService::mutate(REMOVE)
      // -----------------------------------------------
      // request
      AdGroupTargetMutateOperation removeAdGroupTargetMutateOperation = createAdGroupTargetSampleRemoveRequest(accountId, adGroupTargetValues);

      // call API
      removeAdGroupTarget(removeAdGroupTargetMutateOperation);

      // -----------------------------------------------
      // AdGroupAdService::mutate(REMOVE)
      // -----------------------------------------------
      // request
      AdGroupAdOperation removeAdGroupAdOperation = AdGroupAdServiceSample.createSampleRemoveRequest(accountId, adGroupAdValues);

      // call API
      AdGroupAdServiceSample.remove(removeAdGroupAdOperation);

      // -----------------------------------------------
      // AdGroupService::mutate(REMOVE)
      // -----------------------------------------------
      // request
      AdGroupOperation removeAdGroupOperation = AdGroupServiceSample.createSampleRemoveRequest(accountId, adGroupValues);
      // call API
      AdGroupServiceSample.remove(removeAdGroupOperation);

      // -----------------------------------------------
      // CampaignService::mutate(REMOVE)
      // -----------------------------------------------
      // request
      CampaignOperation removeCampaignOperation = CampaignServiceSample.createSampleRemoveRequest(accountId, campaignValues);

      // call API
      CampaignServiceSample.remove(removeCampaignOperation);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Sample Program for AdGroupTargetService ADD.
   *
   * @param operation AdGroupTargetMutateOperation
   * @return AdGroupTargetValues
   */
  public static List<AdGroupTargetValue> addAdGroupTarget(AdGroupTargetMutateOperation operation) throws Exception {

    // =================================================================
    // AdGroupTargetService
    // =================================================================
    AdGroupTargetServiceInterface adGroupTargetService = SoapUtils.createServiceInterface(AdGroupTargetServiceInterface.class, AdGroupTargetServiceService.class);

    System.out.println("############################################");
    System.out.println("AdGroupTargetService::mutate(ADD)");
    System.out.println("############################################");
    Holder<AdGroupTargetReturnValue> setAdGroupTargetReturnValueHolder = new Holder<AdGroupTargetReturnValue>();
    Holder<List<jp.yahooapis.im.v201812.Error>> setAdGroupTargetErrorHolder = new Holder<List<jp.yahooapis.im.v201812.Error>>();
    adGroupTargetService.mutate(operation, setAdGroupTargetReturnValueHolder, setAdGroupTargetErrorHolder);

    // if error
    if (setAdGroupTargetErrorHolder.value != null && setAdGroupTargetErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(setAdGroupTargetErrorHolder.value), true);
    }

    // response
    if (setAdGroupTargetReturnValueHolder.value != null) {
      AdGroupTargetReturnValue returnValue = setAdGroupTargetReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<AdGroupTargetValue> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayAdGroupTargetList(values.get(i).getAdGroupTargetList());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }
    // Response
    return setAdGroupTargetReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupTargetService SET.
   *
   * @param operation AdGroupTargetMutateOperation
   * @return AdGroupTargetValues
   */
  public static List<AdGroupTargetValue> setAdGroupTarget(AdGroupTargetMutateOperation operation) throws Exception {

    // =================================================================
    // AdGroupTargetService
    // =================================================================
    AdGroupTargetServiceInterface adGroupTargetService = SoapUtils.createServiceInterface(AdGroupTargetServiceInterface.class, AdGroupTargetServiceService.class);

    System.out.println("############################################");
    System.out.println("AdGroupTargetService::mutate(SET)");
    System.out.println("############################################");
    Holder<AdGroupTargetReturnValue> setAdGroupTargetReturnValueHolder = new Holder<AdGroupTargetReturnValue>();
    Holder<List<jp.yahooapis.im.v201812.Error>> setAdGroupTargetErrorHolder = new Holder<List<jp.yahooapis.im.v201812.Error>>();
    adGroupTargetService.mutate(operation, setAdGroupTargetReturnValueHolder, setAdGroupTargetErrorHolder);

    // if error
    if (setAdGroupTargetErrorHolder.value != null && setAdGroupTargetErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(setAdGroupTargetErrorHolder.value), true);
    }

    // response
    if (setAdGroupTargetReturnValueHolder.value != null) {
      AdGroupTargetReturnValue returnValue = setAdGroupTargetReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<AdGroupTargetValue> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayAdGroupTargetList(values.get(i).getAdGroupTargetList());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }
    // Response
    return setAdGroupTargetReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupTargetService REMOVE.
   *
   * @param operation AdGroupTargetMutateOperation
   * @return AdGroupTargetValues
   */
  public static List<AdGroupTargetValue> removeAdGroupTarget(AdGroupTargetMutateOperation operation) throws Exception {

    // =================================================================
    // AdGroupTargetService
    // =================================================================
    AdGroupTargetServiceInterface adGroupTargetService = SoapUtils.createServiceInterface(AdGroupTargetServiceInterface.class, AdGroupTargetServiceService.class);

    System.out.println("############################################");
    System.out.println("AdGroupTargetService::mutate(REMOVE)");
    System.out.println("############################################");
    Holder<AdGroupTargetReturnValue> setAdGroupTargetReturnValueHolder = new Holder<AdGroupTargetReturnValue>();
    Holder<List<jp.yahooapis.im.v201812.Error>> setAdGroupTargetErrorHolder = new Holder<List<jp.yahooapis.im.v201812.Error>>();
    adGroupTargetService.mutate(operation, setAdGroupTargetReturnValueHolder, setAdGroupTargetErrorHolder);

    // if error
    if (setAdGroupTargetErrorHolder.value != null && setAdGroupTargetErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(setAdGroupTargetErrorHolder.value), true);
    }

    // response
    if (setAdGroupTargetReturnValueHolder.value != null) {
      AdGroupTargetReturnValue returnValue = setAdGroupTargetReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<AdGroupTargetValue> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayAdGroupTargetList(values.get(i).getAdGroupTargetList());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }
    // Response
    return setAdGroupTargetReturnValueHolder.value.getValues();
  }


  /**
   * Sample Program for AdGroupTargetService replace.
   *
   * @param operation AdGroupTargetMutateOperation
   * @return AdGroupTargetValues
   */
  public static List<AdGroupTargetValue> replaceAdGroupTarget(AdGroupTargetOperation operation) throws Exception {

    // =================================================================
    // AdGroupTargetService
    // =================================================================
    AdGroupTargetServiceInterface adGroupTargetService = SoapUtils.createServiceInterface(AdGroupTargetServiceInterface.class, AdGroupTargetServiceService.class);

    System.out.println("############################################");
    System.out.println("AdGroupTargetService::replace");
    System.out.println("############################################");
    Holder<AdGroupTargetReturnValue> setAdGroupTargetReturnValueHolder = new Holder<AdGroupTargetReturnValue>();
    Holder<List<jp.yahooapis.im.v201812.Error>> setAdGroupTargetErrorHolder = new Holder<List<jp.yahooapis.im.v201812.Error>>();
    adGroupTargetService.replace(operation, setAdGroupTargetReturnValueHolder, setAdGroupTargetErrorHolder);

    // if error
    if (setAdGroupTargetErrorHolder.value != null && setAdGroupTargetErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(setAdGroupTargetErrorHolder.value), true);
    }

    // response
    if (setAdGroupTargetReturnValueHolder.value != null) {
      AdGroupTargetReturnValue returnValue = setAdGroupTargetReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<AdGroupTargetValue> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayAdGroupTargetList(values.get(i).getAdGroupTargetList());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }
    // Response
    return setAdGroupTargetReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupTargetService GET.
   *
   * @param selector AdGroupTargetSelector
   * @return AdGroupValues
   */
  public static List<AdGroupTargetValue> getAdGroupTarget(AdGroupTargetSelector selector) throws Exception {
    // =================================================================
    // AdGroupTargetService
    // =================================================================
    AdGroupTargetServiceInterface adGroupTargetService = SoapUtils.createServiceInterface(AdGroupTargetServiceInterface.class, AdGroupTargetServiceService.class);

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupTargetService::get");
    System.out.println("############################################");
    Holder<AdGroupTargetPage> adGroupTargetPageHolder = new Holder<AdGroupTargetPage>();
    Holder<List<jp.yahooapis.im.v201812.Error>> getAdGroupTargetErrorHolder = new Holder<List<jp.yahooapis.im.v201812.Error>>();
    adGroupTargetService.get(selector, adGroupTargetPageHolder, getAdGroupTargetErrorHolder);

    // if error
    if (getAdGroupTargetErrorHolder.value != null && getAdGroupTargetErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(getAdGroupTargetErrorHolder.value), true);
    }

    // response
    if (adGroupTargetPageHolder.value != null) {
      AdGroupTargetPage adGroupTargetPage = adGroupTargetPageHolder.value;
      if (adGroupTargetPage.getValues() != null && adGroupTargetPage.getValues().size() > 0) {
        List<AdGroupTargetValue> values = adGroupTargetPage.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayAdGroupTargetList(values.get(i).getAdGroupTargetList());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }


    // Response
    return adGroupTargetPageHolder.value.getValues();
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @return CampaignOperation
   */
  public static CampaignOperation createSampleAddRequest(long accountId) {
    Campaign appCampaignOperand = new Campaign();
    appCampaignOperand.setAccountId(accountId);
    appCampaignOperand.setCampaignName("SampleAppCampaign_CreateOn_" + SoapUtils.getCurrentTimestamp());
    appCampaignOperand.setUserStatus(jp.yahooapis.im.v201812.campaign.UserStatus.ACTIVE);
    appCampaignOperand.setStartDate("20300101");
    appCampaignOperand.setEndDate("20301231");
    Budget appBudget = new Budget();
    appBudget.setAmount((long) 1000);
    appBudget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);
    appCampaignOperand.setBudget(appBudget);
    ManualCPC appManualCPC = new ManualCPC();
    appManualCPC.setType(BiddingStrategyType.MANUAL_CPC);
    appCampaignOperand.setBiddingStrategy(appManualCPC);
    appCampaignOperand.setAdProductType("TARGET_MATCH");
    FrequencyCap appFrequencyCap = new FrequencyCap();
    appFrequencyCap.setLevel(FrequencyLevel.CAMPAIGN);
    appFrequencyCap.setTimeUnit(FrequencyTimeUnit.WEEK);
    appFrequencyCap.setImpression((long) 10);
    appCampaignOperand.setFrequencyCap(appFrequencyCap);
    appCampaignOperand.setCampaignType(CampaignType.STANDARD);

    CampaignOperation addCampaignOperation = new CampaignOperation();
    addCampaignOperation.setOperator(jp.yahooapis.im.v201812.campaign.Operator.ADD);
    addCampaignOperation.setAccountId(accountId);
    addCampaignOperation.getOperand().add(appCampaignOperand);

    return addCampaignOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId  long
   * @param campaignId long
   * @param adGroupId  long
   * @return AdGroupTargetSelector
   */
  public static AdGroupTargetSelector createAdGroupTargetSampleGetRequest(long accountId, long campaignId, long adGroupId) {
    // Set Selector
    AdGroupTargetSelector adGroupTargetSelector = new AdGroupTargetSelector();
    adGroupTargetSelector.setAccountId(accountId);
    adGroupTargetSelector.getCampaignIds().add(campaignId);
    adGroupTargetSelector.getAdGroupIds().add(adGroupId);


    return adGroupTargetSelector;
  }

  /**
   * create AdGroupTarget SET sample request.
   *
   * @param accountId  long
   * @param campaignId long
   * @param adGroupId  long
   * @return AdGroupTargetMutateOperation
   */
  public static AdGroupTargetMutateOperation createAdGroupTargetSampleAddRequest(long accountId, long campaignId, long adGroupId) {
    AdScheduleTarget setAdScheduleTarget1 = new AdScheduleTarget();
    setAdScheduleTarget1.setType(TargetType.AD_SCHEDULE_TARGET);
    setAdScheduleTarget1.setDayOfWeek(DayOfWeek.MONDAY);
    setAdScheduleTarget1.setStartHour(13);
    setAdScheduleTarget1.setEndHour(14);
    AdGroupTarget setAdScheduleAdGroupTarget1 = new AdGroupTarget();
    setAdScheduleAdGroupTarget1.setAccountId(accountId);
    setAdScheduleAdGroupTarget1.setAccountId(accountId);
    setAdScheduleAdGroupTarget1.setCampaignId(campaignId);
    setAdScheduleAdGroupTarget1.setAdGroupId(adGroupId);
    setAdScheduleAdGroupTarget1.setTarget(setAdScheduleTarget1);
    setAdScheduleAdGroupTarget1.setBidMultiplier(1.12);

    AdScheduleTarget setAdScheduleTarget2 = new AdScheduleTarget();
    setAdScheduleTarget2.setType(TargetType.AD_SCHEDULE_TARGET);
    setAdScheduleTarget2.setDayOfWeek(DayOfWeek.TUESDAY);
    setAdScheduleTarget2.setStartHour(14);
    setAdScheduleTarget2.setEndHour(15);
    AdGroupTarget setAdScheduleAdGroupTarget2 = new AdGroupTarget();
    setAdScheduleAdGroupTarget2.setAccountId(accountId);
    setAdScheduleAdGroupTarget2.setAccountId(accountId);
    setAdScheduleAdGroupTarget2.setCampaignId(campaignId);
    setAdScheduleAdGroupTarget2.setAdGroupId(adGroupId);
    setAdScheduleAdGroupTarget2.setTarget(setAdScheduleTarget2);
    setAdScheduleAdGroupTarget2.setBidMultiplier(1.12);

    GenderTarget setGenderTarget1 = new GenderTarget();
    setGenderTarget1.setType(TargetType.GENDER_TARGET);
    setGenderTarget1.setGender(Gender.ST_MALE);
    setGenderTarget1.setEstimateFlg(EstimateFlg.ACTIVE);
    AdGroupTarget setGenderAdGroupTarget1 = new AdGroupTarget();
    setGenderAdGroupTarget1.setAccountId(accountId);
    setGenderAdGroupTarget1.setAccountId(accountId);
    setGenderAdGroupTarget1.setCampaignId(campaignId);
    setGenderAdGroupTarget1.setAdGroupId(adGroupId);
    setGenderAdGroupTarget1.setTarget(setGenderTarget1);
    setGenderAdGroupTarget1.setBidMultiplier(1.12);

    GenderTarget setGenderTarget2 = new GenderTarget();
    setGenderTarget2.setType(TargetType.GENDER_TARGET);
    setGenderTarget2.setGender(Gender.ST_UNKNOWN);
    AdGroupTarget setGenderAdGroupTarget2 = new AdGroupTarget();
    setGenderAdGroupTarget2.setAccountId(accountId);
    setGenderAdGroupTarget2.setAccountId(accountId);
    setGenderAdGroupTarget2.setCampaignId(campaignId);
    setGenderAdGroupTarget2.setAdGroupId(adGroupId);
    setGenderAdGroupTarget2.setTarget(setGenderTarget2);
    setGenderAdGroupTarget2.setBidMultiplier(1.12);

    AgeTarget setAgeTarget1 = new AgeTarget();
    setAgeTarget1.setType(TargetType.AGE_TARGET);
    setAgeTarget1.setAge(Age.GT_UNKNOWN);
    AdGroupTarget setAgeAdGroupTarget = new AdGroupTarget();
    setAgeAdGroupTarget.setAccountId(accountId);
    setAgeAdGroupTarget.setAccountId(accountId);
    setAgeAdGroupTarget.setCampaignId(campaignId);
    setAgeAdGroupTarget.setAdGroupId(adGroupId);
    setAgeAdGroupTarget.setTarget(setAgeTarget1);
    setAgeAdGroupTarget.setBidMultiplier(1.12);


    AdGroupTargetMutateOperation setAdGroupTargetMutateOperation = new AdGroupTargetMutateOperation();
    setAdGroupTargetMutateOperation.setOperator(jp.yahooapis.im.v201812.adgrouptarget.Operator.ADD);
    setAdGroupTargetMutateOperation.setAccountId(accountId);
    setAdGroupTargetMutateOperation.getOperand().addAll(Arrays.asList(setAdScheduleAdGroupTarget1, setAdScheduleAdGroupTarget2, setGenderAdGroupTarget1, setGenderAdGroupTarget2, setAgeAdGroupTarget));

    return setAdGroupTargetMutateOperation;
  }


  public static AdGroupTargetMutateOperation createAdGroupTargetSampleSetRequest(long accountId, List<AdGroupTargetValue> adGroupTargetValues) {
    AdGroupTargetMutateOperation adGroupTargetMutateOperation = new AdGroupTargetMutateOperation();
    adGroupTargetMutateOperation.setOperator(Operator.SET);
    adGroupTargetMutateOperation.setAccountId(accountId);
    for (AdGroupTargetValue adGroupTargetValue : adGroupTargetValues) {
      AdGroupTarget adGroupTarget = new AdGroupTarget();
      adGroupTarget.setCampaignId(adGroupTargetValue.getAdGroupTargetList().getCampaignId());
      adGroupTarget.setAdGroupId(adGroupTargetValue.getAdGroupTargetList().getAdGroupId());
      adGroupTarget.setBidMultiplier(2.0);
      Target srcTarget = adGroupTargetValue.getAdGroupTargetList().getTarget();
      Target target;
      switch (srcTarget.getType()) {
        case AD_SCHEDULE_TARGET:
          target = new AdScheduleTarget();
          break;
        case AGE_TARGET:
          target = new AgeTarget();
          break;
        case GENDER_TARGET:
          target = new GenderTarget();
          break;
        case GEO_TARGET:
          target = new GeoTarget();
          break;
        case INTEREST_CATEGORY:
          target = new InterestCategoryTarget();
          break;
        case SITE_CATEGORY:
          target = new SiteCategoryTarget();
          break;
        case DEVICE_TARGET:
          target = new DeviceTarget();
          break;
        case CARRIER_TARGET:
          target = new CarrierTarget();
          break;
        default:
          continue;
      }
      target.setType(srcTarget.getType());
      target.setTargetId(srcTarget.getTargetId());
      adGroupTarget.setTarget(target);
      adGroupTargetMutateOperation.getOperand().add(adGroupTarget);

    }
    return adGroupTargetMutateOperation;
  }

  public static AdGroupTargetMutateOperation createAdGroupTargetSampleRemoveRequest(long accountId, List<AdGroupTargetValue> adGroupTargetValues) {
    AdGroupTargetMutateOperation adGroupTargetMutateOperation = new AdGroupTargetMutateOperation();
    adGroupTargetMutateOperation.setOperator(Operator.REMOVE);
    adGroupTargetMutateOperation.setAccountId(accountId);
    for (AdGroupTargetValue adGroupTargetValue : adGroupTargetValues) {
      AdGroupTarget adGroupTarget = new AdGroupTarget();
      adGroupTarget.setCampaignId(adGroupTargetValue.getAdGroupTargetList().getCampaignId());
      adGroupTarget.setAdGroupId(adGroupTargetValue.getAdGroupTargetList().getAdGroupId());
      Target srcTarget = adGroupTargetValue.getAdGroupTargetList().getTarget();
      Target target;
      switch (srcTarget.getType()) {
        case AD_SCHEDULE_TARGET:
          target = new AdScheduleTarget();
          break;
        case AGE_TARGET:
          target = new AgeTarget();
          break;
        case GENDER_TARGET:
          target = new GenderTarget();
          break;
        case GEO_TARGET:
          target = new GeoTarget();
          break;
        case INTEREST_CATEGORY:
          target = new InterestCategoryTarget();
          break;
        case SITE_CATEGORY:
          target = new SiteCategoryTarget();
          break;
        case DEVICE_TARGET:
          target = new DeviceTarget();
          break;
        case CARRIER_TARGET:
          target = new CarrierTarget();
          break;
        default:
          continue;
      }
      target.setType(srcTarget.getType());
      target.setTargetId(srcTarget.getTargetId());
      adGroupTarget.setTarget(target);
      adGroupTargetMutateOperation.getOperand().add(adGroupTarget);
    }
    return adGroupTargetMutateOperation;
  }

  public static AdGroupTargetOperation createAdGroupTargetSampleReplaceRequest(long accountId, long campaignId, long adGroupId) {
    AdScheduleTarget setAdScheduleTarget1 = new AdScheduleTarget();
    setAdScheduleTarget1.setType(TargetType.AD_SCHEDULE_TARGET);
    setAdScheduleTarget1.setDayOfWeek(DayOfWeek.FRIDAY);
    setAdScheduleTarget1.setStartHour(20);
    setAdScheduleTarget1.setEndHour(21);
    AdGroupTarget setAdScheduleAdGroupTarget1 = new AdGroupTarget();
    setAdScheduleAdGroupTarget1.setAccountId(accountId);
    setAdScheduleAdGroupTarget1.setAccountId(accountId);
    setAdScheduleAdGroupTarget1.setCampaignId(campaignId);
    setAdScheduleAdGroupTarget1.setAdGroupId(adGroupId);
    setAdScheduleAdGroupTarget1.setTarget(setAdScheduleTarget1);
    setAdScheduleAdGroupTarget1.setBidMultiplier(1.7);

    GenderTarget setGenderTarget2 = new GenderTarget();
    setGenderTarget2.setType(TargetType.GENDER_TARGET);
    setGenderTarget2.setIsRemove(true);
    AdGroupTarget setGenderAdGroupTarget2 = new AdGroupTarget();
    setGenderAdGroupTarget2.setAccountId(accountId);
    setGenderAdGroupTarget2.setAccountId(accountId);
    setGenderAdGroupTarget2.setCampaignId(campaignId);
    setGenderAdGroupTarget2.setAdGroupId(adGroupId);
    setGenderAdGroupTarget2.setTarget(setGenderTarget2);

    AgeTarget setAgeTarget1 = new AgeTarget();
    setAgeTarget1.setType(TargetType.AGE_TARGET);
    setAgeTarget1.setIsRemove(true);
    AdGroupTarget setAgeAdGroupTarget = new AdGroupTarget();
    setAgeAdGroupTarget.setAccountId(accountId);
    setAgeAdGroupTarget.setAccountId(accountId);
    setAgeAdGroupTarget.setCampaignId(campaignId);
    setAgeAdGroupTarget.setAdGroupId(adGroupId);
    setAgeAdGroupTarget.setTarget(setAgeTarget1);


    AdGroupTargetOperation adGroupTargetOperation = new AdGroupTargetOperation();
    adGroupTargetOperation.setAccountId(accountId);
    adGroupTargetOperation.getOperand().addAll(Arrays.asList(setAdScheduleAdGroupTarget1, setGenderAdGroupTarget2, setAgeAdGroupTarget));

    return adGroupTargetOperation;
  }

  /**
   * display AdGroupTarget entity to stdout.
   *
   * @param adGroupTarget AdGroupTarget
   */
  private static void displayAdGroupTargetList(AdGroupTarget adGroupTarget) {
    System.out.println("accountId = " + adGroupTarget.getAccountId());
    System.out.println("campaignId = " + adGroupTarget.getCampaignId());
    System.out.println("adGroupId = " + adGroupTarget.getAdGroupId());
    System.out.println("bidMultiplier = " + adGroupTarget.getBidMultiplier());
    Target target = adGroupTarget.getTarget();
    System.out.println("target---------");
    System.out.println("target/type = " + target.getType().toString());
    System.out.println("targets/targetId = " + target.getTargetId());
    if (target instanceof AdScheduleTarget) {
      AdScheduleTarget adScheduleTarget = (AdScheduleTarget) target;
      System.out.println("target/dayOfWeek = " + adScheduleTarget.getDayOfWeek().toString());
      System.out.println("target/startHour = " + adScheduleTarget.getStartHour());
      System.out.println("target/endHour = " + adScheduleTarget.getEndHour());
    } else if (target instanceof GenderTarget) {
      GenderTarget genderTarget = (GenderTarget) target;
      System.out.println("target/gender = " + genderTarget.getGender().toString());
      System.out.println("target/estimateFlg = " + genderTarget.getEstimateFlg());
    } else if (target instanceof GeoTarget) {
      GeoTarget geoTarget = (GeoTarget) target;
      System.out.println("target/geoNameJa = " + geoTarget.getGeoNameEn());
      System.out.println("target/geoNameEn = " + geoTarget.getGeoNameEn());
    } else if (target instanceof AgeTarget) {
      AgeTarget ageTarget = (AgeTarget) target;
      System.out.println("target/age = " + ageTarget.getAge().toString());
    } else if (target instanceof InterestCategoryTarget) {
      InterestCategoryTarget interestCategoryTarget = (InterestCategoryTarget) target;
      System.out.println("target/categoryFullNameJa = " + interestCategoryTarget.getCategoryFullNameJa());
      System.out.println("target/categoryFullNameEn = " + interestCategoryTarget.getCategoryFullNameEn());
    } else if (target instanceof SiteCategoryTarget) {
      SiteCategoryTarget siteCategoryTarget = (SiteCategoryTarget) target;
      System.out.println("target/categoryFullNameJa = " + siteCategoryTarget.getCategoryFullNameJa());
      System.out.println("target/categoryFullNameEn = " + siteCategoryTarget.getCategoryFullNameEn());
    } else if (target instanceof SiteRetargetingTarget) {
      SiteRetargetingTarget siteRetargetingTarget = (SiteRetargetingTarget) target;
      System.out.println("target/targetListName = " + siteRetargetingTarget.getTargetListName());
      System.out.println("target/deliverType = " + siteRetargetingTarget.getDeliverType().toString());
    } else if (target instanceof SearchTarget) {
      SearchTarget searchTarget = (SearchTarget) target;
      System.out.println("target/searchKeywordListName = " + searchTarget.getSearchKeywordListName());
    } else if (target instanceof PlacementTarget) {
      PlacementTarget placementTarget = (PlacementTarget) target;
      System.out.println("target/placementUrlListName = " + placementTarget.getPlacementUrlListName());
      System.out.println("target/deliverType = " + placementTarget.getDeliverType().toString());
    } else if (target instanceof DeviceTarget) {
      DeviceTarget deviceTarget = (DeviceTarget) target;
      System.out.println("target/deviceType = " + deviceTarget.getDeviceType().toString());
    } else if (target instanceof CarrierTarget) {
      CarrierTarget carrierTarget = (CarrierTarget) target;
      System.out.println("target/mobileCarrier = " + carrierTarget.getMobileCarrier().toString());
    } else if (target instanceof AppTarget) {
      AppTarget appTarget = (AppTarget) target;
      System.out.println("target/appType = " + appTarget.getAppType().toString());
    } else if (target instanceof OsTarget) {
      OsTarget osTarget = (OsTarget) target;
      System.out.println("target/osType = " + osTarget.getOsType().toString());
    } else if (target instanceof OsVersionTarget) {
      OsVersionTarget osVersionTarget = (OsVersionTarget) target;
      System.out.println("target/osVersion = " + osVersionTarget.getOsVersion());
    }

    System.out.println("---------");
  }
}
