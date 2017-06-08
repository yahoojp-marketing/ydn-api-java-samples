package jp.co.yahoo.ad_api_sample.adSample;

import jp.co.yahoo.ad_api_sample.error.impl.AdGroupTargetServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.V6.AdGroupAdService.AdGroupAdOperation;
import jp.yahooapis.im.V6.AdGroupAdService.AdGroupAdSelector;
import jp.yahooapis.im.V6.AdGroupAdService.AdGroupAdValues;
import jp.yahooapis.im.V6.AdGroupService.AdGroup;
import jp.yahooapis.im.V6.AdGroupService.AdGroupOperation;
import jp.yahooapis.im.V6.AdGroupService.AdGroupSelector;
import jp.yahooapis.im.V6.AdGroupService.AdGroupValues;
import jp.yahooapis.im.V6.AdGroupTargetService.AdGroupTargetList;
import jp.yahooapis.im.V6.AdGroupTargetService.AdGroupTargetOperation;
import jp.yahooapis.im.V6.AdGroupTargetService.AdGroupTargetPage;
import jp.yahooapis.im.V6.AdGroupTargetService.AdGroupTargetReturnValue;
import jp.yahooapis.im.V6.AdGroupTargetService.AdGroupTargetSelector;
import jp.yahooapis.im.V6.AdGroupTargetService.AdGroupTargetServiceInterface;
import jp.yahooapis.im.V6.AdGroupTargetService.AdGroupTargetServiceService;
import jp.yahooapis.im.V6.AdGroupTargetService.AdGroupTargetValues;
import jp.yahooapis.im.V6.AdGroupTargetService.AdGroupTargets;
import jp.yahooapis.im.V6.AdGroupTargetService.AdScheduleTarget;
import jp.yahooapis.im.V6.AdGroupTargetService.AdScheduleTargetList;
import jp.yahooapis.im.V6.AdGroupTargetService.Age;
import jp.yahooapis.im.V6.AdGroupTargetService.AgeTarget;
import jp.yahooapis.im.V6.AdGroupTargetService.AgeTargetList;
import jp.yahooapis.im.V6.AdGroupTargetService.DayOfWeek;
import jp.yahooapis.im.V6.AdGroupTargetService.EstimateFlg;
import jp.yahooapis.im.V6.AdGroupTargetService.Gender;
import jp.yahooapis.im.V6.AdGroupTargetService.GenderTarget;
import jp.yahooapis.im.V6.AdGroupTargetService.GenderTargetList;
import jp.yahooapis.im.V6.AdGroupTargetService.GeoTarget;
import jp.yahooapis.im.V6.AdGroupTargetService.GeoTargetList;
import jp.yahooapis.im.V6.AdGroupTargetService.InterestCategoryTarget;
import jp.yahooapis.im.V6.AdGroupTargetService.InterestCategoryTargetList;
import jp.yahooapis.im.V6.AdGroupTargetService.SearchTarget;
import jp.yahooapis.im.V6.AdGroupTargetService.SearchTargetList;
import jp.yahooapis.im.V6.AdGroupTargetService.SiteCategoryTarget;
import jp.yahooapis.im.V6.AdGroupTargetService.SiteCategoryTargetList;
import jp.yahooapis.im.V6.AdGroupTargetService.SiteRetargetingTarget;
import jp.yahooapis.im.V6.AdGroupTargetService.SiteRetargetingTargetList;
import jp.yahooapis.im.V6.AdGroupTargetService.TargetType;
import jp.yahooapis.im.V6.CampaignService.Campaign;
import jp.yahooapis.im.V6.CampaignService.CampaignOperation;
import jp.yahooapis.im.V6.CampaignService.CampaignSelector;
import jp.yahooapis.im.V6.CampaignService.CampaignValues;

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
      CampaignOperation addCampaignOperation = CampaignServiceSample.createSampleAddRequest(accountId);
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
      // AdGroupTargetService::mutate(SET)
      // -----------------------------------------------
      // request
      AdGroupTargetOperation setAdGroupTargetOperation = createAdGroupTargetSampleSetRequest(accountId, campaignId, adGroupId);

      // call API
      setAdGroupTarget(setAdGroupTargetOperation);


      // -----------------------------------------------
      // AdGroupTargetService::get
      // -----------------------------------------------
      // request
      AdGroupTargetSelector adGroupTargetSelector = createAdGroupTargetSampleGetRequest(accountId, campaignId, adGroupId);

      // call API
      getAdGroupTarget(adGroupTargetSelector);

      // =================================================================
      // remove AdGroupAd, AdGroup, Campaign
      // =================================================================
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
   * Sample Program for AdGroupTargetService SET.
   *
   * @param operation AdGroupTargetOperation
   * @return AdGroupTargetValues
   * @throws Exception
   */
  public static List<AdGroupTargetValues> setAdGroupTarget(AdGroupTargetOperation operation) throws Exception {

    // =================================================================
    // AdGroupTargetService
    // =================================================================
    AdGroupTargetServiceInterface adGroupTargetService = SoapUtils.createServiceInterface(AdGroupTargetServiceInterface.class, AdGroupTargetServiceService.class);

    System.out.println("############################################");
    System.out.println("AdGroupTargetService::mutate(SET)");
    System.out.println("############################################");
    Holder<AdGroupTargetReturnValue> setAdGroupTargetReturnValueHolder = new Holder<AdGroupTargetReturnValue>();
    Holder<List<jp.yahooapis.im.V6.AdGroupTargetService.Error>> setAdGroupTargetErrorHolder = new Holder<List<jp.yahooapis.im.V6.AdGroupTargetService.Error>>();
    adGroupTargetService.mutate(operation, setAdGroupTargetReturnValueHolder, setAdGroupTargetErrorHolder);

    // if error
    if (setAdGroupTargetErrorHolder.value != null && setAdGroupTargetErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupTargetServiceErrorEntityFactory(setAdGroupTargetErrorHolder.value), true);
    }

    // response
    if (setAdGroupTargetReturnValueHolder.value != null) {
      AdGroupTargetReturnValue returnValue = setAdGroupTargetReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<AdGroupTargetValues> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayAdGroupTargetList(values.get(i).getTargetList());
          } else {
            // if error
            SoapUtils.displayErrors(new AdGroupTargetServiceErrorEntityFactory(values.get(i).getError()), true);
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
   * @throws Exception
   */
  public static List<AdGroupTargetValues> getAdGroupTarget(AdGroupTargetSelector selector) throws Exception {
    // =================================================================
    // AdGroupTargetService
    // =================================================================
    AdGroupTargetServiceInterface adGroupTargetService = SoapUtils.createServiceInterface(AdGroupTargetServiceInterface.class, AdGroupTargetServiceService.class);

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupTargetService::get");
    System.out.println("############################################");
    Holder<AdGroupTargetPage> adGroupTargetPageHolder = new Holder<AdGroupTargetPage>();
    Holder<List<jp.yahooapis.im.V6.AdGroupTargetService.Error>> getAdGroupTargetErrorHolder = new Holder<List<jp.yahooapis.im.V6.AdGroupTargetService.Error>>();
    adGroupTargetService.get(selector, adGroupTargetPageHolder, getAdGroupTargetErrorHolder);

    // if error
    if (getAdGroupTargetErrorHolder.value != null && getAdGroupTargetErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupTargetServiceErrorEntityFactory(getAdGroupTargetErrorHolder.value), true);
    }

    // response
    if (adGroupTargetPageHolder.value != null) {
      AdGroupTargetPage adGroupTargetPage = adGroupTargetPageHolder.value;
      if (adGroupTargetPage.getValues() != null && adGroupTargetPage.getValues().size() > 0) {
        List<AdGroupTargetValues> values = adGroupTargetPage.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayAdGroupTargetList(values.get(i).getTargetList());
          } else {
            // if error
            SoapUtils.displayErrors(new AdGroupTargetServiceErrorEntityFactory(values.get(i).getError()), true);
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
   * @param campaignId long
   * @param adGroupId long
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
   * @param accountId long
   * @param campaignId long
   * @param adGroupId long
   * @return AdGroupTargetOperation
   */
  public static AdGroupTargetOperation createAdGroupTargetSampleSetRequest(long accountId, long campaignId, long adGroupId) {
    AdScheduleTarget setAdScheduleTarget1 = new AdScheduleTarget();
    setAdScheduleTarget1.setType(TargetType.AD_SCHEDULE_TARGET);
    setAdScheduleTarget1.setDayOfWeek(DayOfWeek.MONDAY);
    setAdScheduleTarget1.setStartHour(13);
    setAdScheduleTarget1.setEndHour(14);
    AdScheduleTarget setAdScheduleTarget2 = new AdScheduleTarget();
    setAdScheduleTarget2.setType(TargetType.AD_SCHEDULE_TARGET);
    setAdScheduleTarget2.setDayOfWeek(DayOfWeek.TUESDAY);
    setAdScheduleTarget2.setStartHour(14);
    setAdScheduleTarget2.setEndHour(15);

    AdScheduleTargetList setAdScheduleTargetList = new AdScheduleTargetList();
    setAdScheduleTargetList.setAccountId(accountId);
    setAdScheduleTargetList.setCampaignId(campaignId);
    setAdScheduleTargetList.setAdGroupId(adGroupId);
    setAdScheduleTargetList.setType(TargetType.AD_SCHEDULE_TARGET);
    setAdScheduleTargetList.getTargets().addAll(Arrays.asList(setAdScheduleTarget1, setAdScheduleTarget2));

    GenderTarget setGenderTarget1 = new GenderTarget();
    setGenderTarget1.setType(TargetType.GENDER_TARGET);
    setGenderTarget1.setGender(Gender.ST_MALE);
    setGenderTarget1.setEstimateFlg(EstimateFlg.ACTIVE);

    GenderTarget setGenderTarget2 = new GenderTarget();
    setGenderTarget2.setType(TargetType.GENDER_TARGET);
    setGenderTarget2.setGender(Gender.ST_UNKNOWN);

    GenderTargetList setGenderTargetList = new GenderTargetList();
    setGenderTargetList.setAccountId(accountId);
    setGenderTargetList.setCampaignId(campaignId);
    setGenderTargetList.setAdGroupId(adGroupId);
    setGenderTargetList.setType(TargetType.GENDER_TARGET);
    setGenderTargetList.getTargets().addAll(Arrays.asList(setGenderTarget1, setGenderTarget2));

    AgeTarget setAgeTarget1 = new AgeTarget();
    setAgeTarget1.setType(TargetType.AGE_TARGET);
    setAgeTarget1.setAge(Age.GT_UNKNOWN);

    AgeTargetList setAgeTargetList = new AgeTargetList();
    setAgeTargetList.setAccountId(accountId);
    setAgeTargetList.setCampaignId(campaignId);
    setAgeTargetList.setAdGroupId(adGroupId);
    setAgeTargetList.setType(TargetType.AGE_TARGET);
    setAgeTargetList.getTargets().add(setAgeTarget1);

    AdGroupTargets setAdGroupTargetOperand = new AdGroupTargets();
    setAdGroupTargetOperand.setAccountId(accountId);
    setAdGroupTargetOperand.setCampaignId(campaignId);
    setAdGroupTargetOperand.setAdGroupId(adGroupId);
    setAdGroupTargetOperand.getTargets().addAll(Arrays.asList(setAdScheduleTargetList, setGenderTargetList, setAgeTargetList));

    AdGroupTargetOperation setAdGroupTargetOperation = new AdGroupTargetOperation();
    setAdGroupTargetOperation.setOperator(jp.yahooapis.im.V6.AdGroupTargetService.Operator.SET);
    setAdGroupTargetOperation.setAccountId(accountId);
    setAdGroupTargetOperation.setCampaignId(campaignId);
    setAdGroupTargetOperation.getOperand().add(setAdGroupTargetOperand);

    return setAdGroupTargetOperation;
  }


  /**
   * display AdGroupTargetList entity to stdout.
   *
   * @param adGroupTargets AdGroupTargets entity for display.
   */
  private static void displayAdGroupTargetList(AdGroupTargets adGroupTargets) {
    System.out.println("accountId = " + adGroupTargets.getAccountId());
    System.out.println("campaignId = " + adGroupTargets.getCampaignId());
    System.out.println("adGroupId = " + adGroupTargets.getAdGroupId());
    if (adGroupTargets.getTargets() != null && adGroupTargets.getTargets().size() > 0) {
      List<AdGroupTargetList> targetList = adGroupTargets.getTargets();
      for (int j = 0; j < targetList.size(); j++) {
        System.out.println("targets---------");
        System.out.println("targets/accountId = " + targetList.get(j).getAccountId());
        System.out.println("targets/campaignId = " + targetList.get(j).getCampaignId());
        System.out.println("targets/adGroupId = " + targetList.get(j).getAdGroupId());
        System.out.println("targets/type = " + targetList.get(j).getType().toString());
        if (targetList.get(j) instanceof AdScheduleTargetList) {
          AdScheduleTargetList adScheduleTargetList = (AdScheduleTargetList) targetList.get(j);
          List<AdScheduleTarget> adScheduleTarget = adScheduleTargetList.getTargets();
          for (int k = 0; k < adScheduleTarget.size(); k++) {
            System.out.println("targets/targets---------");
            System.out.println("targets/targets/type = " + adScheduleTarget.get(k).getType().toString());
            System.out.println("targets/targets/dayOfWeek = " + adScheduleTarget.get(k).getDayOfWeek().toString());
            System.out.println("targets/targets/startHour = " + adScheduleTarget.get(k).getStartHour());
            System.out.println("targets/targets/endHour = " + adScheduleTarget.get(k).getEndHour());

          }
        } else if (targetList.get(j) instanceof GenderTargetList) {
          GenderTargetList genderTargetList = (GenderTargetList) targetList.get(j);
          List<GenderTarget> genderTarget = genderTargetList.getTargets();
          for (int k = 0; k < genderTarget.size(); k++) {
            System.out.println("targets/targets---------");
            System.out.println("targets/targets/type = " + genderTarget.get(k).getType().toString());
            System.out.println("targets/targets/gender = " + genderTarget.get(k).getGender().toString());
            System.out.println("targets/targets/estimateFlg = " + genderTarget.get(k).getEstimateFlg());
          }
        } else if (targetList.get(j) instanceof GeoTargetList) {
          GeoTargetList geoTargetList = (GeoTargetList) targetList.get(j);
          List<GeoTarget> geoTarget = geoTargetList.getTargets();
          for (int k = 0; k < geoTarget.size(); k++) {
            System.out.println("targets/targets---------");
            System.out.println("targets/targets/type = " + geoTarget.get(k).getType().toString());
            System.out.println("targets/targets/geo = " + geoTarget.get(k).getGeo());
          }
        } else if (targetList.get(j) instanceof AgeTargetList) {
          AgeTargetList ageTargetList = (AgeTargetList) targetList.get(j);
          List<AgeTarget> ageTarget = ageTargetList.getTargets();
          for (int k = 0; k < ageTarget.size(); k++) {
            System.out.println("targets/targets---------");
            System.out.println("targets/targets/type = " + ageTarget.get(k).getType().toString());
            System.out.println("targets/targets/age = " + ageTarget.get(k).getAge().toString());
          }
        } else if (targetList.get(j) instanceof InterestCategoryTargetList) {
          InterestCategoryTargetList interestCategoryTargetList = (InterestCategoryTargetList) targetList.get(j);
          List<InterestCategoryTarget> interestCategoryTarget = interestCategoryTargetList.getTargets();
          for (int k = 0; k < interestCategoryTarget.size(); k++) {
            System.out.println("targets/targets---------");
            System.out.println("targets/targets/type = " + interestCategoryTarget.get(k).getType().toString());
            System.out.println("targets/targets/category = " + interestCategoryTarget.get(k).getCategory());
          }
        } else if (targetList.get(j) instanceof SiteCategoryTargetList) {
          SiteCategoryTargetList siteCategoryTargetList = (SiteCategoryTargetList) targetList.get(j);
          List<SiteCategoryTarget> siteCategoryTarget = siteCategoryTargetList.getTargets();
          for (int k = 0; k < siteCategoryTarget.size(); k++) {
            System.out.println("targets/targets---------");
            System.out.println("targets/targets/type = " + siteCategoryTarget.get(k).getType().toString());
            System.out.println("targets/targets/category = " + siteCategoryTarget.get(k).getCategory());
          }
        } else if (targetList.get(j) instanceof SiteRetargetingTargetList) {
          SiteRetargetingTargetList siteRetargetingTargetList = (SiteRetargetingTargetList) targetList.get(j);
          List<SiteRetargetingTarget> siteRetargetingTarget = siteRetargetingTargetList.getTargets();
          for (int k = 0; k < siteRetargetingTarget.size(); k++) {
            System.out.println("targets/targets---------");
            System.out.println("targets/targets/type = " + siteRetargetingTarget.get(k).getType().toString());
            System.out.println("targets/targets/targetListId = " + siteRetargetingTarget.get(k).getTargetListId());
            System.out.println("targets/targets/targetListName = " + siteRetargetingTarget.get(k).getTargetListName().toString());
          }
        } else if (targetList.get(j) instanceof SearchTargetList) {
          SearchTargetList searchTargetList = (SearchTargetList) targetList.get(j);
          List<SearchTarget> searchTarget = searchTargetList.getTargets();
          for (int k = 0; k < searchTarget.size(); k++) {
            System.out.println("targets/targets---------");
            System.out.println("targets/targets/type = " + searchTarget.get(k).getType());
            System.out.println("targets/targets/searchKeywordListId = " + searchTarget.get(k).getSearchKeywordListId());
            System.out.println("targets/targets/searchKeywordListName = " + searchTarget.get(k).getSearchKeywordListName());
          }
        }
      }
    }
    System.out.println("---------");
  }
}
