/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.adgrouptarget;

import jp.yahooapis.im.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201911.Error;
import jp.yahooapis.im.v201911.Paging;
import jp.yahooapis.im.v201911.adgrouptarget.AdGroupTarget;
import jp.yahooapis.im.v201911.adgrouptarget.AdGroupTargetMutateOperation;
import jp.yahooapis.im.v201911.adgrouptarget.AdGroupTargetOperation;
import jp.yahooapis.im.v201911.adgrouptarget.AdGroupTargetPage;
import jp.yahooapis.im.v201911.adgrouptarget.AdGroupTargetReturnValue;
import jp.yahooapis.im.v201911.adgrouptarget.AdGroupTargetSelector;
import jp.yahooapis.im.v201911.adgrouptarget.AdGroupTargetService;
import jp.yahooapis.im.v201911.adgrouptarget.AdGroupTargetServiceInterface;
import jp.yahooapis.im.v201911.adgrouptarget.AdGroupTargetValue;
import jp.yahooapis.im.v201911.adgrouptarget.AdScheduleTarget;
import jp.yahooapis.im.v201911.adgrouptarget.Age;
import jp.yahooapis.im.v201911.adgrouptarget.AgeTarget;
import jp.yahooapis.im.v201911.adgrouptarget.AudienceCategoryTarget;
import jp.yahooapis.im.v201911.adgrouptarget.CarrierTarget;
import jp.yahooapis.im.v201911.adgrouptarget.DayOfWeek;
import jp.yahooapis.im.v201911.adgrouptarget.DeviceTarget;
import jp.yahooapis.im.v201911.adgrouptarget.EstimateFlg;
import jp.yahooapis.im.v201911.adgrouptarget.Gender;
import jp.yahooapis.im.v201911.adgrouptarget.GenderTarget;
import jp.yahooapis.im.v201911.adgrouptarget.GeoTarget;
import jp.yahooapis.im.v201911.adgrouptarget.InterestCategoryTarget;
import jp.yahooapis.im.v201911.adgrouptarget.Operator;
import jp.yahooapis.im.v201911.adgrouptarget.PlacementTarget;
import jp.yahooapis.im.v201911.adgrouptarget.PlacementUrlListType;
import jp.yahooapis.im.v201911.adgrouptarget.SiteCategoryTarget;
import jp.yahooapis.im.v201911.adgrouptarget.TargetType;
import jp.yahooapis.im.v201911.campaign.CampaignType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example AdGroupTargetService operation and Utility method collection.
 */
public class AdGroupTargetServiceSample {

  /**
   * example AdGroupTargetService operation.
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
      // AdGroupTargetService ADD
      // =================================================================
      // create request.
      AdGroupTargetMutateOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<AdGroupTarget>() {{
        add(createExampleScheduleTarget(campaignIdStandard, adGroupIdStandard));
        add(createExampleGenderTarget(campaignIdStandard, adGroupIdStandard));
        add(createExampleAgeTarget(campaignIdStandard, adGroupIdStandard));
      }});

      // run
      List<AdGroupTargetValue> addResponse = mutate(addRequest);
      List<AdGroupTarget> adGroupTargets = new ArrayList<>();
      for (AdGroupTargetValue adGroupTargetValue : addResponse) {
        adGroupTargets.add(adGroupTargetValue.getAdGroupTargetList());
      }

      // =================================================================
      // AdGroupTargetService SET
      // =================================================================
      // create request.
      AdGroupTargetMutateOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId, createExampleSetRequest(adGroupTargets));

      // run
      mutate(setRequest);

      // =================================================================
      // AdGroupTargetService REPLACE
      // =================================================================
      // create request.
      AdGroupTargetOperation replaceRequest = buildExampleReplaceRequest(accountId, new ArrayList<AdGroupTarget>() {{
          add(createExampleScheduleTargetReplace(campaignIdStandard, adGroupIdStandard, Boolean.FALSE));
          add(createExampleGenderTargetReplace(campaignIdStandard, adGroupIdStandard, Boolean.FALSE));
          add(createExampleAgeTargetReplace(campaignIdStandard, adGroupIdStandard, Boolean.TRUE));
      }});

      // run
      List<AdGroupTargetValue> replaceResponse = replace(replaceRequest);

      List<AdGroupTarget> repAdGroupTargets = new ArrayList<>();
      for (AdGroupTargetValue adGroupTargetValue : replaceResponse) {
        repAdGroupTargets.add(adGroupTargetValue.getAdGroupTargetList());
      }

      // =================================================================
      // AdGroupTargetService GET
      // =================================================================
      // create request.
      AdGroupTargetSelector getRequest = buildExampleGetRequest(campaignIdStandard, adGroupIdStandard);

      // run
      get(getRequest);

      // =================================================================
      // AdGroupTargetService REMOVE
      // =================================================================
      // create request.
      AdGroupTargetMutateOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, repAdGroupTargets);

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
   * example mutate AdGroupTargets.
   *
   * @param operation AdGroupTargetOperation
   * @return AdGroupTargetValues
   */
  public static List<AdGroupTargetValue> mutate(AdGroupTargetMutateOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupTargetService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<AdGroupTargetReturnValue> AdGroupTargetReturnValueHolder = new Holder<AdGroupTargetReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupTargetServiceInterface AdGroupTargetService = SoapUtils.createServiceInterface(AdGroupTargetServiceInterface.class, AdGroupTargetService.class);
    AdGroupTargetService.mutate(operation, AdGroupTargetReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, AdGroupTargetReturnValueHolder.value.getValues());

    // Response
    return AdGroupTargetReturnValueHolder.value.getValues();
  }

  /**
   * example mutate AdGroupTargets.
   *
   * @param operation AdGroupTargetOperation
   * @return AdGroupTargetValues
   */
  public static List<AdGroupTargetValue> replace(AdGroupTargetOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupTargetService::replace");
    System.out.println("############################################");

    Holder<AdGroupTargetReturnValue> AdGroupTargetReturnValueHolder = new Holder<AdGroupTargetReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupTargetServiceInterface AdGroupTargetService = SoapUtils.createServiceInterface(AdGroupTargetServiceInterface.class, AdGroupTargetService.class);
    AdGroupTargetService.replace(operation, AdGroupTargetReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, AdGroupTargetReturnValueHolder.value.getValues());

    // Response
    return AdGroupTargetReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupTargetService GET.
   *
   * @param selector AdGroupTargetSelector
   * @return AdGroupTargetValue
   */
  public static List<AdGroupTargetValue> get(AdGroupTargetSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupTargetService::get");
    System.out.println("############################################");

    Holder<AdGroupTargetPage> AdGroupTargetPageHolder = new Holder<AdGroupTargetPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupTargetServiceInterface AdGroupTargetService = SoapUtils.createServiceInterface(AdGroupTargetServiceInterface.class, AdGroupTargetService.class);
    AdGroupTargetService.get(selector, AdGroupTargetPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, AdGroupTargetPageHolder.value.getValues());

    // Response
    return AdGroupTargetPageHolder.value.getValues();
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
   * @param operand List<AdGroupTarget>
   * @return AdGroupTargetMutateOperation
   */
  public static AdGroupTargetMutateOperation buildExampleMutateRequest(Operator operator, long accountId, List<AdGroupTarget> operand)
  {
    AdGroupTargetMutateOperation operation = new AdGroupTargetMutateOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example replace request.
   *
   * @param accountId long
   * @param operand List<AdGroupTarget>
   * @return AdGroupTargetOperation
   */
  public static AdGroupTargetOperation buildExampleReplaceRequest(long accountId, List<AdGroupTarget> operand)
  {
    AdGroupTargetOperation operation = new AdGroupTargetOperation();
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * create get request.
   *
   * @param campaignId
   * @param adGroupId
   * @return AdGroupTargetSelector
   */
  public static AdGroupTargetSelector buildExampleGetRequest(Long campaignId, Long adGroupId)
  {
    // Set Selector
    AdGroupTargetSelector selector = new AdGroupTargetSelector();
    selector.setAccountId(SoapUtils.getAccountId());
    selector.getCampaignIds().add(campaignId);
    selector.getAdGroupIds().add(adGroupId);
    selector.getTargetTypes().addAll(Arrays.asList( //
        TargetType.AD_SCHEDULE_TARGET,
        TargetType.GEO_TARGET,
        TargetType.AGE_TARGET,
        TargetType.GENDER_TARGET,
        TargetType.INTEREST_CATEGORY,
        TargetType.SITE_CATEGORY,
        TargetType.SITE_RETARGETING,
        TargetType.SEARCH_TARGET,
        TargetType.PLACEMENT_TARGET,
        TargetType.DEVICE_TARGET,
        TargetType.CARRIER_TARGET,
        TargetType.APP_TARGET,
        TargetType.OS_TARGET,
        TargetType.OS_VERSION_TARGET,
        TargetType.AUDIENCE_CATEGORY_TARGET
    ));

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
  
  /**
   * example AdGroupTargets set request.
   *
   * @param adGroupTargets
   * @return List<AdGroupTarget>
   */
  public static List<AdGroupTarget> createExampleSetRequest(List<AdGroupTarget> adGroupTargets)
  {
    // create operands
    List<AdGroupTarget> operands = new ArrayList<>();

    for (AdGroupTarget adGroupTarget : adGroupTargets) {
      AdGroupTarget operand = new AdGroupTarget();
      operand.setAccountId(SoapUtils.getAccountId());
      operand.setCampaignId(adGroupTarget.getCampaignId());
      operand.setAdGroupId(adGroupTarget.getAdGroupId());
      operand.setBidMultiplier(2.0);

      switch (adGroupTarget.getTarget().getType()) {
        case AD_SCHEDULE_TARGET:
          AdScheduleTarget scheduleTarget = new AdScheduleTarget();
          scheduleTarget.setType(TargetType.AD_SCHEDULE_TARGET);
          scheduleTarget.setTargetId(adGroupTarget.getTarget().getTargetId());
          operand.setTarget(scheduleTarget);
          break;
        case AGE_TARGET:
          AgeTarget ageTarget = new AgeTarget();
          ageTarget.setType(TargetType.AGE_TARGET);
          ageTarget.setTargetId(adGroupTarget.getTarget().getTargetId());
          operand.setTarget(ageTarget);
          break;
        case GENDER_TARGET:
          GenderTarget genderTarget = new GenderTarget();
          genderTarget.setType(TargetType.GENDER_TARGET);
          genderTarget.setTargetId(adGroupTarget.getTarget().getTargetId());
          operand.setTarget(genderTarget);
          break;
        case GEO_TARGET:
          GeoTarget geoTarget = new GeoTarget();
          geoTarget.setType(TargetType.GEO_TARGET);
          geoTarget.setTargetId(adGroupTarget.getTarget().getTargetId());
          operand.setTarget(geoTarget);
          break;
        case INTEREST_CATEGORY:
          InterestCategoryTarget interestCategoryTarget = new InterestCategoryTarget();
          interestCategoryTarget.setType(TargetType.INTEREST_CATEGORY);
          interestCategoryTarget.setTargetId(adGroupTarget.getTarget().getTargetId());
          operand.setTarget(interestCategoryTarget);
          break;
        case SITE_CATEGORY:
          SiteCategoryTarget siteCategoryTarget = new SiteCategoryTarget();
          siteCategoryTarget.setType(TargetType.SITE_CATEGORY);
          siteCategoryTarget.setTargetId(adGroupTarget.getTarget().getTargetId());
          operand.setTarget(siteCategoryTarget);
          break;
        case DEVICE_TARGET:
          DeviceTarget deviceTarget = new DeviceTarget();
          deviceTarget.setType(TargetType.DEVICE_TARGET);
          deviceTarget.setTargetId(adGroupTarget.getTarget().getTargetId());
          operand.setTarget(deviceTarget);
          break;
        case CARRIER_TARGET:
          CarrierTarget carrierTarget = new CarrierTarget();
          carrierTarget.setType(TargetType.CARRIER_TARGET);
          carrierTarget.setTargetId(adGroupTarget.getTarget().getTargetId());
          operand.setTarget(carrierTarget);
          break;
        case AUDIENCE_CATEGORY_TARGET:
          AudienceCategoryTarget audienceCategoryTarget = new AudienceCategoryTarget();
          audienceCategoryTarget.setType(TargetType.AUDIENCE_CATEGORY_TARGET);
          audienceCategoryTarget.setTargetId(adGroupTarget.getTarget().getTargetId());
          operand.setTarget(audienceCategoryTarget);
          break;
        default:
          break;
      }
      operands.add(operand);
    }

    return operands;
  }

  /**
   * example Schedule Target request.
   *
   * @param campaignId
   * @param adGroupId
   * @return AdGroupTarget
   */
  public static AdGroupTarget createExampleScheduleTarget(Long campaignId, Long adGroupId)
  {
    // target
    AdScheduleTarget target = new AdScheduleTarget();
    target.setType(TargetType.AD_SCHEDULE_TARGET);
    target.setDayOfWeek(DayOfWeek.MONDAY);
    target.setStartHour(13);
    target.setEndHour(14);

    // adGroupTarget
    AdGroupTarget adGroupTarget = new AdGroupTarget();
    adGroupTarget.setAccountId(SoapUtils.getAccountId());
    adGroupTarget.setCampaignId(campaignId);
    adGroupTarget.setAdGroupId(adGroupId);
    adGroupTarget.setTarget(target);
    adGroupTarget.setBidMultiplier(1.12);

    return adGroupTarget;
  }

  /**
   * example Gender Target request.
   *
   * @param campaignId
   * @param adGroupId
   * @return AdGroupTarget
   */
  public static AdGroupTarget createExampleGenderTarget(Long campaignId, Long adGroupId)
  {
    // target
    GenderTarget target = new GenderTarget();
    target.setType(TargetType.GENDER_TARGET);
    target.setGender(Gender.ST_MALE);
    target.setEstimateFlg(EstimateFlg.PAUSED);

    // adGroupAd
    AdGroupTarget adGroupTarget = new AdGroupTarget();
    adGroupTarget.setAccountId(SoapUtils.getAccountId());
    adGroupTarget.setCampaignId(campaignId);
    adGroupTarget.setAdGroupId(adGroupId);
    adGroupTarget.setTarget(target);
    adGroupTarget.setBidMultiplier(1.12);

    return adGroupTarget;
  }

  /**
   * example Age Target request.
   *
   * @param campaignId
   * @param adGroupId
   * @return AdGroupTarget
   */
  public static AdGroupTarget createExampleAgeTarget(Long campaignId, Long adGroupId)
  {
    // target
    AgeTarget target = new AgeTarget();
    target.setType(TargetType.AGE_TARGET);
    target.setAge(Age.GT_UNKNOWN);

    // adGroupAd
    AdGroupTarget adGroupTarget = new AdGroupTarget();
    adGroupTarget.setAccountId(SoapUtils.getAccountId());
    adGroupTarget.setCampaignId(campaignId);
    adGroupTarget.setAdGroupId(adGroupId);
    adGroupTarget.setTarget(target);
    adGroupTarget.setBidMultiplier(1.12);

    return adGroupTarget;
  }

  /**
   * example Placement Target request.
   *
   * @param campaignId
   * @param adGroupId
   * @param targetId
   * @return AdGroupTarget
   */
  public static AdGroupTarget createExamplePlacementTarget(Long campaignId, Long adGroupId, Long targetId)
  {
    // target
    PlacementTarget target = new PlacementTarget();
    target.setType(TargetType.PLACEMENT_TARGET);
    target.setTargetId(targetId.toString());
    target.setDeliverType(PlacementUrlListType.BLACK_LIST);

    // adGroupTarget
    AdGroupTarget adGroupTarget = new AdGroupTarget();
    adGroupTarget.setAccountId(SoapUtils.getAccountId());
    adGroupTarget.setCampaignId(campaignId);
    adGroupTarget.setAdGroupId(adGroupId);
    adGroupTarget.setTarget(target);

    return adGroupTarget;
  }

  /**
   * example Interest Category Target request.
   *
   * @param campaignId
   * @param adGroupId
   * @param categoryCode
   * @return AdGroupTarget
   */
  public static AdGroupTarget createExampleInterestCategoryTarget(Long campaignId, Long adGroupId, String categoryCode)
  {
    // target
    InterestCategoryTarget target = new InterestCategoryTarget();
    target.setType(TargetType.INTEREST_CATEGORY);
    target.setTargetId(categoryCode);

    // adGroupTarget
    AdGroupTarget adGroupTarget = new AdGroupTarget();
    adGroupTarget.setAccountId(SoapUtils.getAccountId());
    adGroupTarget.setCampaignId(campaignId);
    adGroupTarget.setAdGroupId(adGroupId);
    adGroupTarget.setTarget(target);

    return adGroupTarget;
  }

  /**
   * example Audience Category Target request.
   *
   * @param campaignId
   * @param adGroupId
   * @param categoryCode
   * @return AdGroupTarget
   */
  public static AdGroupTarget createExampleAudienceCategoryTarget(Long campaignId, Long adGroupId, String categoryCode)
  {
    // target
    AudienceCategoryTarget target = new AudienceCategoryTarget();
    target.setType(TargetType.AUDIENCE_CATEGORY_TARGET);
    target.setTargetId(categoryCode);

    // adGroupTarget
    AdGroupTarget adGroupTarget = new AdGroupTarget();
    adGroupTarget.setAccountId(SoapUtils.getAccountId());
    adGroupTarget.setCampaignId(campaignId);
    adGroupTarget.setAdGroupId(adGroupId);
    adGroupTarget.setTarget(target);

    return adGroupTarget;
  }


  /**
   * example Schedule Target replace request.
   *
   * @param campaignId
   * @param adGroupId
   * @param isRemove
   * @return AdGroupTarget
   */
  public static AdGroupTarget createExampleScheduleTargetReplace(Long campaignId, Long adGroupId, Boolean isRemove)
  {
    // target
    AdScheduleTarget target = new AdScheduleTarget();
    target.setType(TargetType.AD_SCHEDULE_TARGET);
    if (isRemove) {
      target.setIsRemove(Boolean.TRUE);
    } else {
      target.setDayOfWeek(DayOfWeek.FRIDAY);
      target.setStartHour(20);
      target.setEndHour(21);
    }

    // adGroupAd
    AdGroupTarget adGroupTarget = new AdGroupTarget();
    adGroupTarget.setAccountId(SoapUtils.getAccountId());
    adGroupTarget.setCampaignId(campaignId);
    adGroupTarget.setAdGroupId(adGroupId);
    adGroupTarget.setTarget(target);
    adGroupTarget.setBidMultiplier(1.7);

    return adGroupTarget;
  }

  /**
   * example Gender Target replace request.
   *
   * @param campaignId
   * @param adGroupId
   * @param isRemove
   * @return AdGroupTarget
   */
  public static AdGroupTarget createExampleGenderTargetReplace(Long campaignId, Long adGroupId, Boolean isRemove)
  {
    // target
    GenderTarget target = new GenderTarget();
    target.setType(TargetType.GENDER_TARGET);
    if (isRemove) {
      target.setIsRemove(Boolean.TRUE);
    } else {
      target.setGender(Gender.ST_FEMALE);
      target.setEstimateFlg(EstimateFlg.PAUSED);
    }

    // adGroupAd
    AdGroupTarget adGroupTarget = new AdGroupTarget();
    adGroupTarget.setAccountId(SoapUtils.getAccountId());
    adGroupTarget.setCampaignId(campaignId);
    adGroupTarget.setAdGroupId(adGroupId);
    adGroupTarget.setTarget(target);
    adGroupTarget.setBidMultiplier(1.7);

    return adGroupTarget;
  }

  /**
   * example Age Target replace request.
   *
   * @param campaignId
   * @param adGroupId
   * @param isRemove
   * @return AdGroupTarget
   */
  public static AdGroupTarget createExampleAgeTargetReplace(Long campaignId, Long adGroupId, Boolean isRemove)
  {
    // target
    AgeTarget target = new AgeTarget();
    target.setType(TargetType.AGE_TARGET);
    if (isRemove) {
      target.setIsRemove(Boolean.TRUE);
    } else {
      target.setAge(Age.GT_RANGE_15_17);
    }

    // adGroupAd
    AdGroupTarget adGroupTarget = new AdGroupTarget();
    adGroupTarget.setAccountId(SoapUtils.getAccountId());
    adGroupTarget.setCampaignId(campaignId);
    adGroupTarget.setAdGroupId(adGroupId);
    adGroupTarget.setTarget(target);
    adGroupTarget.setBidMultiplier(1.7);

    return adGroupTarget;
  }
}
