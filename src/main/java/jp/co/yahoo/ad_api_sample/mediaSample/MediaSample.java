package jp.co.yahoo.ad_api_sample.mediaSample;

import jp.co.yahoo.ad_api_sample.adSample.AdGroupAdServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdGroupServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdSample;
import jp.co.yahoo.ad_api_sample.adSample.CampaignServiceSample;
import jp.co.yahoo.ad_api_sample.error.impl.ErrorEntityFactoryImpl;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201809.Error;
import jp.yahooapis.im.v201809.Paging;
import jp.yahooapis.im.v201809.adgroup.AdGroup;
import jp.yahooapis.im.v201809.adgroup.AdGroupOperation;
import jp.yahooapis.im.v201809.adgroup.AdGroupSelector;
import jp.yahooapis.im.v201809.adgroup.AdGroupValues;
import jp.yahooapis.im.v201809.adgroup.DeviceAppType;
import jp.yahooapis.im.v201809.adgroup.DeviceOsType;
import jp.yahooapis.im.v201809.adgroup.DeviceType;
import jp.yahooapis.im.v201809.adgroup.ManualCPCAdGroupBid;
import jp.yahooapis.im.v201809.adgroupad.AdGroupAd;
import jp.yahooapis.im.v201809.adgroupad.AdGroupAdOperation;
import jp.yahooapis.im.v201809.adgroupad.AdGroupAdSelector;
import jp.yahooapis.im.v201809.adgroupad.AdGroupAdValues;
import jp.yahooapis.im.v201809.adgroupad.AdStyle;
import jp.yahooapis.im.v201809.adgroupad.AdType;
import jp.yahooapis.im.v201809.adgroupad.ManualCPCAdGroupAdBid;
import jp.yahooapis.im.v201809.adgroupad.TextAd;
import jp.yahooapis.im.v201809.adgrouptarget.AdGroupTarget;
import jp.yahooapis.im.v201809.adgrouptarget.AdGroupTargetMutateOperation;
import jp.yahooapis.im.v201809.adgrouptarget.AdGroupTargetSelector;
import jp.yahooapis.im.v201809.adgrouptarget.AdScheduleTarget;
import jp.yahooapis.im.v201809.adgrouptarget.DayOfWeek;
import jp.yahooapis.im.v201809.adgrouptarget.Gender;
import jp.yahooapis.im.v201809.adgrouptarget.GenderTarget;
import jp.yahooapis.im.v201809.adgrouptarget.TargetType;
import jp.yahooapis.im.v201809.campaign.BiddingStrategyType;
import jp.yahooapis.im.v201809.campaign.Budget;
import jp.yahooapis.im.v201809.campaign.BudgetDeliveryMethod;
import jp.yahooapis.im.v201809.campaign.Campaign;
import jp.yahooapis.im.v201809.campaign.CampaignOperation;
import jp.yahooapis.im.v201809.campaign.CampaignSelector;
import jp.yahooapis.im.v201809.campaign.CampaignValues;
import jp.yahooapis.im.v201809.campaign.ManualCPC;
import jp.yahooapis.im.v201809.media.ImageMedia;
import jp.yahooapis.im.v201809.media.Media;
import jp.yahooapis.im.v201809.media.MediaOperation;
import jp.yahooapis.im.v201809.media.MediaPage;
import jp.yahooapis.im.v201809.media.MediaRecord;
import jp.yahooapis.im.v201809.media.MediaReturnValue;
import jp.yahooapis.im.v201809.media.MediaSelector;
import jp.yahooapis.im.v201809.media.MediaServiceInterface;
import jp.yahooapis.im.v201809.media.MediaServiceService;
import jp.yahooapis.im.v201809.media.MediaValues;
import jp.yahooapis.im.v201809.media.Operator;
import jp.yahooapis.im.v201809.media.UserStatus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for CampaignService,AdGroupService,AdGroupAdService,AdGroupTargetService.
 * Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class MediaSample {

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
      long mediaId = -1;

      // -----------------------------------------------
      // MediaService::mutate(ADD)
      // -----------------------------------------------
      // request
      MediaOperation addMediaOperation = createMediaSampleAddRequest(accountId);

      // call API
      List<MediaValues> addMediaValues = addMedia(addMediaOperation);
      for (MediaValues values : addMediaValues) {
        if (values.isOperationSucceeded()) {
          // display response
          MediaRecord mediaRecord = values.getMediaRecord();
          mediaId = mediaRecord.getMediaId();
        }
      }
      // -----------------------------------------------
      // MediaService::get
      // -----------------------------------------------
      MediaSelector mediaSelector = createMediaSampleGetRequest(accountId, addMediaValues);

      // call API
      getMedia(mediaSelector);

      // -----------------------------------------------
      // MediaService::mutate(SET)
      // -----------------------------------------------
      // request
      MediaOperation setMediaOperation = createMediaSampleSetRequest(accountId, addMediaValues);

      // call API
      setMedia(setMediaOperation);

      // -----------------------------------------------
      // CampaignService::mutate(ADD)
      // -----------------------------------------------
      // request
      CampaignOperation addCampaignOperation = createCampaignSampleAddRequest(accountId);

      // call API
      List<CampaignValues> addCampaignValues = CampaignServiceSample.add(addCampaignOperation);
      for (CampaignValues values : addCampaignValues) {
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
      CampaignSelector campaignSelector = CampaignServiceSample.createSampleGetRequest(accountId, addCampaignValues);

      // call API
      CampaignServiceSample.get(campaignSelector);

      // -----------------------------------------------
      // CampaignService::mutate(SET)
      // -----------------------------------------------
      // request
      CampaignOperation setCampaignOperation = createCampaignSampleSetRequest(accountId, addCampaignValues);

      // call API
      CampaignServiceSample.set(setCampaignOperation);

      // -----------------------------------------------
      // AdGroupService::mutate(ADD)
      // -----------------------------------------------
      // request
      AdGroupOperation addAdGroupOperation = createAdGroupSampleAddRequest(accountId, campaignId);

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
      AdGroupOperation setAdGroupOperation = createAdGroupSampleSetRequest(accountId, adGroupValues);

      // call API
      AdGroupServiceSample.set(setAdGroupOperation);

      // -----------------------------------------------
      // AdGroupAdService::mutate(ADD)
      // -----------------------------------------------
      // request
      AdGroupAdOperation addAdGroupAdOperation = createAdGroupAdSampleAddRequest(accountId, campaignId, adGroupId, mediaId);

      // call API
      List<AdGroupAdValues> adGroupAdValues = AdGroupAdServiceSample.add(addAdGroupAdOperation);

      // -----------------------------------------------
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
      AdGroupAdOperation setAdGroupAdOperation = createAdGroupAdSampleSetRequest(accountId, adGroupAdValues);

      // call API
      AdGroupAdServiceSample.set(setAdGroupAdOperation);

      // -----------------------------------------------
      // AdGroupTargetService::mutate(SET)
      // -----------------------------------------------
      // request
      AdGroupTargetMutateOperation setAdGroupTargetMutateOperation = createAdGroupTargetSampleSetRequest(accountId, campaignId, adGroupId);

      // call API
      AdSample.setAdGroupTarget(setAdGroupTargetMutateOperation);

      // -----------------------------------------------
      // AdGroupTargetService::get
      // -----------------------------------------------
      // request
      AdGroupTargetSelector adGroupTargetSelector = AdSample.createAdGroupTargetSampleGetRequest(accountId, campaignId, adGroupId);

      // call API
      AdSample.getAdGroupTarget(adGroupTargetSelector);

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
      CampaignOperation removeCampaignOperation = CampaignServiceSample.createSampleRemoveRequest(accountId, addCampaignValues);

      // call API
      CampaignServiceSample.remove(removeCampaignOperation);
      // -----------------------------------------------
      // MediaService::mutate(REMOVE)
      // -----------------------------------------------
      // request
      MediaOperation removeMediaOperation = createMediaRemoveRequest(accountId, addMediaValues);

      // call API
      removeMedia(removeMediaOperation);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }


  /**
   * Sample Program for MediaService ADD.
   *
   * @param operation MediaOperation
   * @return MediaValues
   */
  public static List<MediaValues> addMedia(MediaOperation operation) throws Exception {
    // =================================================================
    // MediaService
    // =================================================================
    MediaServiceInterface mediaService = SoapUtils.createServiceInterface(MediaServiceInterface.class, MediaServiceService.class);

    System.out.println("############################################");
    System.out.println("MediaService::mutate(ADD)");
    System.out.println("############################################");
    Holder<MediaReturnValue> addMediaReturnValueHolder = new Holder<MediaReturnValue>();
    Holder<List<Error>> addMediaErrorHolder = new Holder<List<Error>>();
    mediaService.mutate(operation, addMediaReturnValueHolder, addMediaErrorHolder);

    // if error
    if (addMediaErrorHolder.value != null && addMediaErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(addMediaErrorHolder.value), true);
    }

    // response
    if (addMediaReturnValueHolder.value != null) {
      MediaReturnValue returnValue = addMediaReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<MediaValues> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            MediaRecord media = values.get(i).getMediaRecord();

            displayMedia(media);
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }

    // Response
    return addMediaReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for MediaService GET.
   *
   * @param selector MediaSelector
   * @return MediaValues
   */
  public static List<MediaValues> getMedia(MediaSelector selector) throws Exception {
    // =================================================================
    // MediaService
    // =================================================================
    MediaServiceInterface mediaService = SoapUtils.createServiceInterface(MediaServiceInterface.class, MediaServiceService.class);

    // Call API
    System.out.println("############################################");
    System.out.println("MediaService::get");
    System.out.println("############################################");
    Holder<MediaPage> getMediaPageHolder = new Holder<MediaPage>();
    Holder<List<Error>> getMediaErrorHolder = new Holder<List<Error>>();
    mediaService.get(selector, getMediaPageHolder, getMediaErrorHolder);

    // if error
    if (getMediaErrorHolder.value != null && getMediaErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(getMediaErrorHolder.value), true);
    }

    // response
    if (getMediaPageHolder.value != null) {
      MediaPage mediaPage = getMediaPageHolder.value;
      if (mediaPage.getValues() != null && mediaPage.getValues().size() > 0) {
        List<MediaValues> values = mediaPage.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            displayMedia(values.get(i).getMediaRecord());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }

    // Response
    return getMediaPageHolder.value.getValues();
  }


  /**
   * Sample Program for MediaService SET.
   *
   * @param operation MediaOperation
   * @return MediaValues
   */
  public static List<MediaValues> setMedia(MediaOperation operation) throws Exception {
    // =================================================================
    // MediaService
    // =================================================================
    MediaServiceInterface mediaService = SoapUtils.createServiceInterface(MediaServiceInterface.class, MediaServiceService.class);

    System.out.println("############################################");
    System.out.println("MediaService::mutate(SET)");
    System.out.println("############################################");
    Holder<MediaReturnValue> setMediaReturnValueHolder = new Holder<MediaReturnValue>();
    Holder<List<Error>> setMediaErrorHolder = new Holder<List<Error>>();
    mediaService.mutate(operation, setMediaReturnValueHolder, setMediaErrorHolder);

    // if error
    if (setMediaErrorHolder.value != null && setMediaErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(setMediaErrorHolder.value), true);
    }

    // response
    if (setMediaReturnValueHolder.value != null) {
      MediaReturnValue returnValue = setMediaReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<MediaValues> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayMedia(values.get(i).getMediaRecord());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }

    // Response
    return setMediaReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for MediaService REMOVE.
   *
   * @param operation MediaOperation
   * @return MediaValues
   */
  public static List<MediaValues> removeMedia(MediaOperation operation) throws Exception {
    // =================================================================
    // MediaService
    // =================================================================
    MediaServiceInterface mediaService = SoapUtils.createServiceInterface(MediaServiceInterface.class, MediaServiceService.class);

    System.out.println("############################################");
    System.out.println("MediaService::mutate(REMOVE)");
    System.out.println("############################################");
    Holder<MediaReturnValue> removeMediaReturnValueHolder = new Holder<MediaReturnValue>();
    Holder<List<Error>> removeMediaErrorHolder = new Holder<List<Error>>();
    mediaService.mutate(operation, removeMediaReturnValueHolder, removeMediaErrorHolder);

    // if error
    if (removeMediaErrorHolder.value != null && removeMediaErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(removeMediaErrorHolder.value), true);
    }

    // response
    if (removeMediaReturnValueHolder.value != null) {
      MediaReturnValue returnValue = removeMediaReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<MediaValues> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayMedia(values.get(i).getMediaRecord());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }

    // Response
    return removeMediaReturnValueHolder.value.getValues();
  }


  /**
   * create AdGroupTarget ADD sample request.
   *
   * @param accountId long
   * @return MediaOperation
   */
  public static MediaOperation createMediaSampleAddRequest(long accountId) throws Exception {
    ImageMedia imageMedia = new ImageMedia();
    imageMedia.setData(getMediaData("SampleMedia.jpg"));

    MediaRecord addMediaOperand = new MediaRecord();
    addMediaOperand.setAccountId(accountId);
    addMediaOperand.setMediaName("SampleMedia_CreateOn_" + SoapUtils.getCurrentTimestamp() + ".jpg");
    addMediaOperand.setMediaTitle("SampleMedia_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addMediaOperand.setUserStatus(UserStatus.ACTIVE);
    addMediaOperand.setMedia(imageMedia);

    MediaOperation addMediaOperation = new MediaOperation();
    addMediaOperation.setOperator(Operator.ADD);
    addMediaOperation.setAccountId(accountId);
    addMediaOperation.getOperand().add(addMediaOperand);

    return addMediaOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId   long
   * @param mediaValues MediaValues
   * @return MediaSelector
   */
  public static MediaSelector createMediaSampleGetRequest(long accountId, List<MediaValues> mediaValues) {
    // Set Selector
    MediaSelector mediaSelector = new MediaSelector();
    mediaSelector.setAccountId(accountId);
    mediaSelector.getUserStatuses().addAll(Arrays.asList(UserStatus.ACTIVE, UserStatus.PAUSED));

    // Set Operand
    for (MediaValues values : mediaValues) {
      mediaSelector.getMediaIds().add(values.getMediaRecord().getMediaId());
    }

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    mediaSelector.setPaging(paging);

    return mediaSelector;
  }

  /**
   * create Media SET sample request.
   *
   * @param accountId   long
   * @param mediaValues MediaValues
   * @return MediaOperation
   */
  public static MediaOperation createMediaRemoveRequest(long accountId, List<MediaValues> mediaValues) {
    // Set Operation
    MediaOperation removeMediaOperation = new MediaOperation();
    removeMediaOperation.setOperator(Operator.REMOVE);
    removeMediaOperation.setAccountId(accountId);

    // Set Operand
    for (MediaValues values : mediaValues) {
      MediaRecord removeMediaOperand = new MediaRecord();
      removeMediaOperand.setAccountId(accountId);
      removeMediaOperand.setMediaId(values.getMediaRecord().getMediaId());
      removeMediaOperation.getOperand().add(removeMediaOperand);

    }

    return removeMediaOperation;
  }

  /**
   * create Media SET sample request.
   *
   * @param accountId   long
   * @param mediaValues MediaValues
   * @return MediaOperation
   */
  public static MediaOperation createMediaSampleSetRequest(long accountId, List<MediaValues> mediaValues) {
    MediaOperation setMediaOperation = new MediaOperation();
    setMediaOperation.setOperator(Operator.SET);
    setMediaOperation.setAccountId(accountId);

    for (MediaValues values : mediaValues) {
      MediaRecord setMediaOperand = new MediaRecord();
      setMediaOperand.setAccountId(accountId);
      setMediaOperand.setMediaId(values.getMediaRecord().getMediaId());
      setMediaOperand.setMediaTitle("SampleMedia_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setMediaOperand.setUserStatus(UserStatus.PAUSED);
      setMediaOperation.getOperand().add(setMediaOperand);
    }

    return setMediaOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @return CampaignOperation
   */
  public static CampaignOperation createCampaignSampleAddRequest(long accountId) {
    Campaign addCampaignOperand = new Campaign();
    addCampaignOperand.setAccountId(accountId);
    addCampaignOperand.setCampaignName("SampleCampaign_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addCampaignOperand.setUserStatus(jp.yahooapis.im.v201809.campaign.UserStatus.ACTIVE);
    addCampaignOperand.setStartDate("20300101");
    addCampaignOperand.setEndDate("20301231");

    Budget addCampaignBudget = new Budget();
    addCampaignBudget.setAmount((long) 1000);
    addCampaignBudget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);
    addCampaignOperand.setBudget(addCampaignBudget);

    ManualCPC addCampaignManualCpc = new ManualCPC();
    addCampaignManualCpc.setType(BiddingStrategyType.MANUAL_CPC);
    addCampaignOperand.setBiddingStrategy(addCampaignManualCpc);
    addCampaignOperand.setAdProductType("INTEREST_MATCH");

    CampaignOperation addCampaignOperation = new CampaignOperation();
    addCampaignOperation.setOperator(jp.yahooapis.im.v201809.campaign.Operator.ADD);
    addCampaignOperation.setAccountId(accountId);
    addCampaignOperation.getOperand().add(addCampaignOperand);

    return addCampaignOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId      long
   * @param campaignValues CampaignValues
   * @return CampaignOperation
   */
  public static CampaignOperation createCampaignSampleSetRequest(long accountId, List<CampaignValues> campaignValues) {
    CampaignOperation setCampaignOperation = new CampaignOperation();
    setCampaignOperation.setOperator(jp.yahooapis.im.v201809.campaign.Operator.SET);
    setCampaignOperation.setAccountId(accountId);

    for (CampaignValues campaignValue : campaignValues) {
      Campaign setCampaignOperand = new Campaign();
      setCampaignOperand.setAccountId(accountId);
      setCampaignOperand.setCampaignId(campaignValue.getCampaign().getCampaignId());
      setCampaignOperand.setCampaignName("SampleCampaign_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setCampaignOperand.setUserStatus(jp.yahooapis.im.v201809.campaign.UserStatus.PAUSED);
      setCampaignOperand.setStartDate("20300101");
      setCampaignOperand.setEndDate("20301231");

      Budget setCampaignBudget = new Budget();
      setCampaignBudget.setAmount((long) 1000);
      setCampaignBudget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);

      ManualCPC setCampaignManualCpc = new ManualCPC();
      setCampaignManualCpc.setType(BiddingStrategyType.MANUAL_CPC);
      setCampaignOperand.setBiddingStrategy(setCampaignManualCpc);

      setCampaignOperation.getOperand().add(setCampaignOperand);
    }

    return setCampaignOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId  long
   * @param campaignId long
   * @return AdGroupOperation
   */
  public static AdGroupOperation createAdGroupSampleAddRequest(long accountId, long campaignId) {
    AdGroup addAdGroupOperand = new AdGroup();
    addAdGroupOperand.setAccountId(accountId);
    addAdGroupOperand.setCampaignId(campaignId);
    addAdGroupOperand.setAdGroupName("SampleAdGroup_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addAdGroupOperand.setUserStatus(jp.yahooapis.im.v201809.adgroup.UserStatus.ACTIVE);
    ManualCPCAdGroupBid addAdGroupManualCpc = new ManualCPCAdGroupBid();
    addAdGroupManualCpc.setType(jp.yahooapis.im.v201809.adgroup.BiddingStrategyType.MANUAL_CPC);
    addAdGroupManualCpc.setMaxCpc((long) 120);
    addAdGroupOperand.setBid(addAdGroupManualCpc);
    addAdGroupOperand.getDevice().add(DeviceType.SMARTPHONE);
    addAdGroupOperand.getDeviceOs().add(DeviceOsType.IOS);
    addAdGroupOperand.getDeviceApp().add(DeviceAppType.APP);

    AdGroupOperation addAdGroupOperation = new AdGroupOperation();
    addAdGroupOperation.setOperator(jp.yahooapis.im.v201809.adgroup.Operator.ADD);
    addAdGroupOperation.setAccountId(accountId);

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
  public static AdGroupOperation createAdGroupSampleSetRequest(long accountId, List<AdGroupValues> adGroupValues) {
    // Set Operation
    AdGroupOperation setAdGroupOperation = new AdGroupOperation();
    setAdGroupOperation.setOperator(jp.yahooapis.im.v201809.adgroup.Operator.SET);
    setAdGroupOperation.setAccountId(accountId);

    // Set Operand
    for (AdGroupValues adGroupValue : adGroupValues) {
      AdGroup setAdGroupOperand = new AdGroup();
      setAdGroupOperand.setAccountId(accountId);
      setAdGroupOperand.setCampaignId(adGroupValue.getAdGroup().getCampaignId());
      setAdGroupOperand.setAdGroupId(adGroupValue.getAdGroup().getAdGroupId());
      setAdGroupOperand.setAdGroupName("SampleAdGroup_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setAdGroupOperand.setUserStatus(jp.yahooapis.im.v201809.adgroup.UserStatus.PAUSED);
      ManualCPCAdGroupBid setAdGroupManualCpc = new ManualCPCAdGroupBid();
      setAdGroupManualCpc.setMaxCpc((long) 120);
      setAdGroupManualCpc.setType(jp.yahooapis.im.v201809.adgroup.BiddingStrategyType.MANUAL_CPC);
      setAdGroupOperand.setBid(setAdGroupManualCpc);
      setAdGroupOperand.getDevice().add(DeviceType.SMARTPHONE);
      setAdGroupOperand.getDeviceOs().add(DeviceOsType.IOS);
      setAdGroupOperand.getDeviceApp().add(DeviceAppType.APP);

      setAdGroupOperation.getOperand().add(setAdGroupOperand);

    }

    return setAdGroupOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId  long
   * @param campaignId long
   * @param adGroupId  long
   * @param mediaId    long
   * @return AdGroupAdOperation
   */
  public static AdGroupAdOperation createAdGroupAdSampleAddRequest(long accountId, long campaignId, long adGroupId, long mediaId) {

    // request
    TextAd addTextAd = new TextAd();
    addTextAd.setType(AdType.TEXT_LONG_AD_1);
    addTextAd.setUrl("http://www.yahoo.co.jp/");
    addTextAd.setDisplayUrl("www.yahoo.co.jp");
    addTextAd.setHeadline("sample headline");
    addTextAd.setDescription("sample ad desc");
    addTextAd.setDescription2("sample ad desc2");

    AdGroupAd addAdGroupAdOperand = new AdGroupAd();
    addAdGroupAdOperand.setAccountId(accountId);
    addAdGroupAdOperand.setCampaignId(campaignId);
    addAdGroupAdOperand.setAdGroupId(adGroupId);
    addAdGroupAdOperand.setAdName("SampleAdGroupAd_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addAdGroupAdOperand.setAdStyle(AdStyle.IMAGE);
    addAdGroupAdOperand.setMediaId(mediaId);
    addAdGroupAdOperand.setUserStatus(jp.yahooapis.im.v201809.adgroupad.UserStatus.ACTIVE);
    ManualCPCAdGroupAdBid addAdGroupAd = new ManualCPCAdGroupAdBid();
    addAdGroupAd.setMaxCpc((long) 50);
    addAdGroupAd.setType(jp.yahooapis.im.v201809.adgroupad.BiddingStrategyType.MANUAL_CPC);
    addAdGroupAdOperand.setAd(addTextAd);

    AdGroupAdOperation addAdGroupAdOperation = new AdGroupAdOperation();
    addAdGroupAdOperation.setOperator(jp.yahooapis.im.v201809.adgroupad.Operator.ADD);
    addAdGroupAdOperation.setAccountId(accountId);
    addAdGroupAdOperation.getOperand().add(addAdGroupAdOperand);

    return addAdGroupAdOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId       long
   * @param adGroupAdValues AdGroupAdValues
   * @return AdGroupAdOperation
   */
  public static AdGroupAdOperation createAdGroupAdSampleSetRequest(long accountId, List<AdGroupAdValues> adGroupAdValues) {
    // Set Operation
    AdGroupAdOperation setAdGroupAdOperation = new AdGroupAdOperation();
    setAdGroupAdOperation.setOperator(jp.yahooapis.im.v201809.adgroupad.Operator.SET);
    setAdGroupAdOperation.setAccountId(accountId);

    TextAd setTextAd = new TextAd();
    setTextAd.setType(AdType.TEXT_LONG_AD_1);
    setTextAd.setUrl("http://www.yahoo.co.jp/");
    setTextAd.setDisplayUrl("www.yahoo.co.jp");
    setTextAd.setHeadline("sample headline");
    setTextAd.setDescription("sample ad desc");
    setTextAd.setDescription2("sample ad desc2");

    // Set Operand
    for (AdGroupAdValues adGroupAdValue : adGroupAdValues) {
      AdGroupAd setAdGroupAdOperand = new AdGroupAd();
      setAdGroupAdOperand.setAccountId(accountId);
      setAdGroupAdOperand.setCampaignId(adGroupAdValue.getAdGroupAd().getCampaignId());
      setAdGroupAdOperand.setAdGroupId(adGroupAdValue.getAdGroupAd().getAdGroupId());
      setAdGroupAdOperand.setAdId(adGroupAdValue.getAdGroupAd().getAdId());
      setAdGroupAdOperand.setAdName("SampleAdGroupAd_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setAdGroupAdOperand.setUserStatus(jp.yahooapis.im.v201809.adgroupad.UserStatus.PAUSED);
      ManualCPCAdGroupAdBid setAdGroupAdManualCpc = new ManualCPCAdGroupAdBid();
      setAdGroupAdManualCpc.setType(jp.yahooapis.im.v201809.adgroupad.BiddingStrategyType.MANUAL_CPC);
      setAdGroupAdManualCpc.setMaxCpc((long) 60);
      setAdGroupAdOperand.setAd(setTextAd);

      setAdGroupAdOperation.getOperand().add(setAdGroupAdOperand);
    }

    return setAdGroupAdOperation;

  }

  /**
   * create AdGroupTarget SET sample request.
   *
   * @param accountId  long
   * @param campaignId long
   * @param adGroupId  long
   * @return AdGroupTargetMutateOperation
   */
  public static AdGroupTargetMutateOperation createAdGroupTargetSampleSetRequest(long accountId, long campaignId, long adGroupId) {
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
    AdGroupTarget setGenderAdGroupTarget1 = new AdGroupTarget();
    setGenderAdGroupTarget1.setAccountId(accountId);
    setGenderAdGroupTarget1.setAccountId(accountId);
    setGenderAdGroupTarget1.setCampaignId(campaignId);
    setGenderAdGroupTarget1.setAdGroupId(adGroupId);
    setGenderAdGroupTarget1.setTarget(setGenderTarget1);
    setGenderAdGroupTarget1.setBidMultiplier(1.12);


    AdGroupTargetMutateOperation setAdGroupTargetMutateOperation = new AdGroupTargetMutateOperation();
    setAdGroupTargetMutateOperation.setOperator(jp.yahooapis.im.v201809.adgrouptarget.Operator.ADD);
    setAdGroupTargetMutateOperation.setAccountId(accountId);
    setAdGroupTargetMutateOperation.getOperand().addAll(Arrays.asList(setAdScheduleAdGroupTarget1, setAdScheduleAdGroupTarget2, setGenderAdGroupTarget1));
    return setAdGroupTargetMutateOperation;
  }

  /**
   * get upload data.
   *
   * @param filename Media entity for display.
   */
  public static byte[] getMediaData(String filename) throws FileNotFoundException {
    File uploadDir = new File(new File(".").getAbsolutePath() + "/upload");
    File uploadFile = new File(uploadDir, filename);
    if (!uploadFile.exists()) {
      throw new FileNotFoundException("upload file not found. file=" + uploadFile.getAbsolutePath());
    }
    int len = (int) uploadFile.length();
    byte[] buf = new byte[len];

    InputStream is = null;
    try {
      is = new FileInputStream(uploadFile);
      is.read(buf);
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    } finally {
      if (is != null) {
        try {
          is.close();
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    }
    return buf;
  }

  /**
   * display Media entity to stdout.
   *
   * @param mediaRecord Media entity for display.
   */
  private static void displayMedia(MediaRecord mediaRecord) {
    System.out.println("accountId = " + mediaRecord.getAccountId());
    System.out.println("mediaId = " + mediaRecord.getMediaId());
    System.out.println("mediaName = " + mediaRecord.getMediaName());
    System.out.println("mediaTitle = " + mediaRecord.getMediaTitle());
    System.out.println("userStatus = " + mediaRecord.getUserStatus().toString());
    System.out.println("approvalStatus = " + mediaRecord.getApprovalStatus().toString());
    System.out.println("logoFlg = " + mediaRecord.getLogoFlg().toString());
    if (mediaRecord.getMedia() != null) {
      Media media = mediaRecord.getMedia();
      if (media instanceof ImageMedia) {
        ImageMedia imageMedia = (ImageMedia) media;
        System.out.println("media/mediaFileType = " + imageMedia.getMediaFileType().toString());
        System.out.println("media/mediaAdFormat = " + imageMedia.getMediaAdFormat().toString());
        System.out.println("media/fileSize = " + imageMedia.getFileSize());
        System.out.println("media/width = " + imageMedia.getWidth());
        System.out.println("media/height = " + imageMedia.getHeight());
        System.out.println("media/downloadUrl = " + imageMedia.getDownloadUrl());
      }
    }
    System.out.println("---------");
  }

}
