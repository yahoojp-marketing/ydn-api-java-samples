package jp.co.yahoo.ad_api_sample.videoSample;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.yahoo.ad_api_sample.adSample.AdGroupAdServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdGroupServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.CampaignServiceSample;
import jp.co.yahoo.ad_api_sample.error.impl.ErrorEntityFactoryImpl;
import jp.co.yahoo.ad_api_sample.mediaSample.MediaSample;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201812.Error;
import jp.yahooapis.im.v201812.adgroup.AdGroup;
import jp.yahooapis.im.v201812.adgroup.AdGroupOperation;
import jp.yahooapis.im.v201812.adgroup.AdGroupSelector;
import jp.yahooapis.im.v201812.adgroup.AdGroupValues;
import jp.yahooapis.im.v201812.adgroup.DeviceAppType;
import jp.yahooapis.im.v201812.adgroup.DeviceOsType;
import jp.yahooapis.im.v201812.adgroup.DeviceType;
import jp.yahooapis.im.v201812.adgroup.ManualCPVAdGroupBid;
import jp.yahooapis.im.v201812.adgroupad.AdGroupAd;
import jp.yahooapis.im.v201812.adgroupad.AdGroupAdOperation;
import jp.yahooapis.im.v201812.adgroupad.AdGroupAdSelector;
import jp.yahooapis.im.v201812.adgroupad.AdGroupAdValues;
import jp.yahooapis.im.v201812.adgroupad.AdStyle;
import jp.yahooapis.im.v201812.adgroupad.AdType;
import jp.yahooapis.im.v201812.adgroupad.ManualCPVAdGroupAdBid;
import jp.yahooapis.im.v201812.adgroupad.VideoAd;
import jp.yahooapis.im.v201812.campaign.BiddingStrategyType;
import jp.yahooapis.im.v201812.campaign.Budget;
import jp.yahooapis.im.v201812.campaign.BudgetDeliveryMethod;
import jp.yahooapis.im.v201812.campaign.Campaign;
import jp.yahooapis.im.v201812.campaign.CampaignOperation;
import jp.yahooapis.im.v201812.campaign.CampaignSelector;
import jp.yahooapis.im.v201812.campaign.CampaignValues;
import jp.yahooapis.im.v201812.campaign.ManualCPV;
import jp.yahooapis.im.v201812.media.ImageMedia;
import jp.yahooapis.im.v201812.media.MediaOperation;
import jp.yahooapis.im.v201812.media.MediaRecord;
import jp.yahooapis.im.v201812.media.MediaValues;
import jp.yahooapis.im.v201812.media.ThumbnailFlg;
import jp.yahooapis.im.v201812.video.Operator;
import jp.yahooapis.im.v201812.video.UploadUrlPage;
import jp.yahooapis.im.v201812.video.UploadUrlValue;
import jp.yahooapis.im.v201812.video.UploadUrlValues;
import jp.yahooapis.im.v201812.video.UploadVideo;
import jp.yahooapis.im.v201812.video.UserStatus;
import jp.yahooapis.im.v201812.video.Video;
import jp.yahooapis.im.v201812.video.VideoOperation;
import jp.yahooapis.im.v201812.video.VideoPage;
import jp.yahooapis.im.v201812.video.VideoReturnValue;
import jp.yahooapis.im.v201812.video.VideoSelector;
import jp.yahooapis.im.v201812.video.VideoService;
import jp.yahooapis.im.v201812.video.VideoServiceInterface;
import jp.yahooapis.im.v201812.video.VideoValues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.xml.ws.Holder;

/**
 * Sample Program for VideoService.
 * Copyright (C) 2017 Yahoo Japan Corporation. All Rights Reserved.
 */
public class VideoSample {

  /**
   * main method for VideoSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    try {
      long accountId = SoapUtils.getAccountId();
      long campaignId = -1;
      long adGroupId = -1;
      long mediaId = -1;
      long thumbnailMediaId = -1;

      // -----------------------------------------------
      // VideoService::getUploadUrl
      // -----------------------------------------------
      // request
      List<UploadVideo> uploadVideoList = createVideoSampleUploadVideoListRequest();

      // call API
      List<UploadUrlValues> uploadUrlValues = getUploadUrl(accountId, uploadVideoList);

      // -----------------------------------------------
      // VideoService::upload
      // -----------------------------------------------
      // request
      String uploadUrl = uploadUrlValues.get(0).getUploadUrlValue().getUploadUrl();

      // call API
      mediaId = upload(uploadUrl);

      // -----------------------------------------------
      // VideoService::get
      // -----------------------------------------------
      // request
      VideoSelector videoSelector = createVideoSelector(accountId, mediaId);

      // call API
      List<VideoValues> videoValuesList = getVideo(videoSelector);

      // -----------------------------------------------
      // VideoService::mutate(SET)
      // -----------------------------------------------
      // request
      VideoOperation setVideoOperation = createVideoOperation(accountId, Operator.SET, videoValuesList);

      // call API
      setVideo(setVideoOperation);

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
      // MediaService::mutate(ADD)
      // -----------------------------------------------
      // request
      MediaOperation addMediaOperation = createMediaSampleAddRequest(accountId);

      // call API
      List<MediaValues> addMediaValues = MediaSample.addMedia(addMediaOperation);
      for (MediaValues values : addMediaValues) {
        if (values.isOperationSucceeded()) {
          MediaRecord mediaRecord = values.getMediaRecord();
          thumbnailMediaId = mediaRecord.getMediaId();
        }
      }

      // -----------------------------------------------
      // AdGroupAdService::mutate(ADD)
      // -----------------------------------------------
      // request
      AdGroupAdOperation addAdGroupAdOperation = createAdGroupAdSampleAddRequest(accountId, campaignId, adGroupId, mediaId, thumbnailMediaId);

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
      AdGroupAdOperation setAdGroupAdOperation = createAdGroupAdSampleSetRequest(accountId, adGroupAdValues);

      // call API
      AdGroupAdServiceSample.set(setAdGroupAdOperation);

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
      // VideoService::mutate(REMOVE)
      // -----------------------------------------------
      // request
      VideoOperation removeVideoOperation = createVideoOperation(accountId, Operator.REMOVE, videoValuesList);

      // call API
      removeVideo(removeVideoOperation);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private static List<UploadVideo> createVideoSampleUploadVideoListRequest() {
    UploadVideo uploadVideo = new UploadVideo();
    uploadVideo.setVideoName("SampleVideo_CreateOn_" + SoapUtils.getCurrentTimestamp() + ".mp4");
    uploadVideo.setVideoTitle("SampleVideo_CreateOn_" + SoapUtils.getCurrentTimestamp());
    uploadVideo.setUserStatus(UserStatus.ACTIVE);

    List<UploadVideo> uploadVideoList = new LinkedList<>();
    uploadVideoList.add(uploadVideo);

    return uploadVideoList;
  }

  private static VideoSelector createVideoSelector(long accountId, long mediaId) {
    VideoSelector videoSelector = new VideoSelector();
    videoSelector.setAccountId(accountId);
    videoSelector.getMediaIds().add(mediaId);

    return videoSelector;
  }

  private static VideoOperation createVideoOperation(long accountId, Operator operator, List<VideoValues> videoValues) {
    VideoOperation videoOperation = new VideoOperation();
    videoOperation.setAccountId(accountId);
    videoOperation.setOperator(operator);

    for (VideoValues videoValue : videoValues) {
      Video videoOperand = new Video();
      videoOperand.setAccountId(accountId);
      videoOperand.setMediaId(videoValue.getVideo().getMediaId());
      if (Objects.equals(operator, Operator.SET)) {
        videoOperand.setVideoTitle("SampleVideo_UpdateOn_" + SoapUtils.getCurrentTimestamp());
        videoOperand.setUserStatus(UserStatus.PAUSED);
      }
      videoOperation.getOperand().add(videoOperand);
    }

    return videoOperation;
  }

  /**
   * create sample campaign request.
   *
   * @param accountId long
   * @return CampaignOperation
   */
  public static CampaignOperation createCampaignSampleAddRequest(long accountId) {
    Campaign addCampaignOperand = new Campaign();
    addCampaignOperand.setAccountId(accountId);
    addCampaignOperand.setCampaignName("SampleCampaign_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addCampaignOperand.setUserStatus(jp.yahooapis.im.v201812.campaign.UserStatus.ACTIVE);
    addCampaignOperand.setStartDate("20300101");
    addCampaignOperand.setEndDate("20301231");

    Budget addCampaignBudget = new Budget();
    addCampaignBudget.setAmount((long) 3000);
    addCampaignBudget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);
    addCampaignOperand.setBudget(addCampaignBudget);

    ManualCPV addCampaignManualCpv = new ManualCPV();
    addCampaignManualCpv.setType(BiddingStrategyType.MANUAL_CPV);
    addCampaignOperand.setBiddingStrategy(addCampaignManualCpv);
    addCampaignOperand.setAdProductType("VIDEO_AD");

    CampaignOperation addCampaignOperation = new CampaignOperation();
    addCampaignOperation.setOperator(jp.yahooapis.im.v201812.campaign.Operator.ADD);
    addCampaignOperation.setAccountId(accountId);
    addCampaignOperation.getOperand().add(addCampaignOperand);

    return addCampaignOperation;
  }

  /**
   * create sample campaign request.
   *
   * @param accountId      long
   * @param campaignValues CampaignValues
   * @return CampaignOperation
   */
  public static CampaignOperation createCampaignSampleSetRequest(long accountId, List<CampaignValues> campaignValues) {
    CampaignOperation setCampaignOperation = new CampaignOperation();
    setCampaignOperation.setOperator(jp.yahooapis.im.v201812.campaign.Operator.SET);
    setCampaignOperation.setAccountId(accountId);

    for (CampaignValues campaignValue : campaignValues) {
      Campaign setCampaignOperand = new Campaign();
      setCampaignOperand.setAccountId(accountId);
      setCampaignOperand.setCampaignId(campaignValue.getCampaign().getCampaignId());
      setCampaignOperand.setCampaignName("SampleCampaign_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setCampaignOperand.setUserStatus(jp.yahooapis.im.v201812.campaign.UserStatus.PAUSED);
      setCampaignOperand.setStartDate("20300101");
      setCampaignOperand.setEndDate("20301231");

      Budget setCampaignBudget = new Budget();
      setCampaignBudget.setAmount((long) 3000);
      setCampaignBudget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);

      ManualCPV setCampaignManualCpv = new ManualCPV();
      setCampaignManualCpv.setType(BiddingStrategyType.MANUAL_CPV);
      setCampaignOperand.setBiddingStrategy(setCampaignManualCpv);

      setCampaignOperation.getOperand().add(setCampaignOperand);
    }

    return setCampaignOperation;
  }

  /**
   * create sample adGroup request.
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
    addAdGroupOperand.setUserStatus(jp.yahooapis.im.v201812.adgroup.UserStatus.ACTIVE);
    ManualCPVAdGroupBid addAdGroupManualCpv = new ManualCPVAdGroupBid();
    addAdGroupManualCpv.setType(jp.yahooapis.im.v201812.adgroup.BiddingStrategyType.MANUAL_CPV);
    addAdGroupManualCpv.setMaxCpv((long) 1000);
    addAdGroupOperand.setBid(addAdGroupManualCpv);
    addAdGroupOperand.getDevice().add(DeviceType.SMARTPHONE);
    addAdGroupOperand.getDeviceOs().add(DeviceOsType.IOS);
    addAdGroupOperand.getDeviceApp().add(DeviceAppType.APP);

    AdGroupOperation addAdGroupOperation = new AdGroupOperation();
    addAdGroupOperation.setOperator(jp.yahooapis.im.v201812.adgroup.Operator.ADD);
    addAdGroupOperation.setAccountId(accountId);
    addAdGroupOperation.getOperand().add(addAdGroupOperand);

    return addAdGroupOperation;
  }

  /**
   * create sample adGroup request.
   *
   * @param accountId     long
   * @param adGroupValues AdGroupValues
   * @return AdGroupOperation
   */
  public static AdGroupOperation createAdGroupSampleSetRequest(long accountId, List<AdGroupValues> adGroupValues) {
    // Set Operation
    AdGroupOperation setAdGroupOperation = new AdGroupOperation();
    setAdGroupOperation.setOperator(jp.yahooapis.im.v201812.adgroup.Operator.SET);
    setAdGroupOperation.setAccountId(accountId);

    // Set Operand
    for (AdGroupValues adGroupValue : adGroupValues) {
      AdGroup setAdGroupOperand = new AdGroup();
      setAdGroupOperand.setAccountId(accountId);
      setAdGroupOperand.setCampaignId(adGroupValue.getAdGroup().getCampaignId());
      setAdGroupOperand.setAdGroupId(adGroupValue.getAdGroup().getAdGroupId());
      setAdGroupOperand.setAdGroupName("SampleAdGroup_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setAdGroupOperand.setUserStatus(jp.yahooapis.im.v201812.adgroup.UserStatus.PAUSED);
      ManualCPVAdGroupBid setAdGroupManualCpv = new ManualCPVAdGroupBid();
      setAdGroupManualCpv.setMaxCpv((long) 1100);
      setAdGroupManualCpv.setType(jp.yahooapis.im.v201812.adgroup.BiddingStrategyType.MANUAL_CPV);
      setAdGroupOperand.setBid(setAdGroupManualCpv);
      setAdGroupOperand.getDevice().add(DeviceType.SMARTPHONE);
      setAdGroupOperand.getDeviceOs().add(DeviceOsType.IOS);
      setAdGroupOperand.getDeviceApp().add(DeviceAppType.APP);

      setAdGroupOperation.getOperand().add(setAdGroupOperand);
    }

    return setAdGroupOperation;
  }

  /**
   * create AdGroupTarget ADD sample request.
   *
   * @param accountId long
   * @return MediaOperation
   */
  public static MediaOperation createMediaSampleAddRequest(long accountId) throws Exception {
    ImageMedia imageMedia = new ImageMedia();
    imageMedia.setData(MediaSample.getMediaData("thumbnail.jpg"));

    MediaRecord addMediaOperand = new MediaRecord();
    addMediaOperand.setAccountId(accountId);
    addMediaOperand.setMediaName("SampleMedia_CreateOn_" + SoapUtils.getCurrentTimestamp() + ".jpg");
    addMediaOperand.setMediaTitle("SampleMedia_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addMediaOperand.setUserStatus(jp.yahooapis.im.v201812.media.UserStatus.ACTIVE);
    addMediaOperand.setMedia(imageMedia);
    addMediaOperand.setThumbnailFlg(ThumbnailFlg.TRUE);

    MediaOperation addMediaOperation = new MediaOperation();
    addMediaOperation.setOperator(jp.yahooapis.im.v201812.media.Operator.ADD);
    addMediaOperation.setAccountId(accountId);
    addMediaOperation.getOperand().add(addMediaOperand);

    return addMediaOperation;
  }

  /**
   * create sample adGroupAd request.
   *
   * @param accountId        long
   * @param campaignId       long
   * @param adGroupId        long
   * @param mediaId          long
   * @param thumbnailMediaId long
   * @return AdGroupAdOperation
   */
  public static AdGroupAdOperation createAdGroupAdSampleAddRequest(long accountId, long campaignId, long adGroupId, long mediaId, long thumbnailMediaId) {
    // request
    VideoAd addVideoAd = new VideoAd();
    addVideoAd.setType(AdType.VIDEO_AD);
    addVideoAd.setThumbnailMediaId(thumbnailMediaId);
    addVideoAd.setHeadline("sample headline");
    addVideoAd.setDescription("sample ad desc");
    addVideoAd.setUrl("http://www.yahoo.co.jp/");
    addVideoAd.setDisplayUrl("www.yahoo.co.jp");
    addVideoAd.setPrincipal("sample principal");

    AdGroupAd addAdGroupAdOperand = new AdGroupAd();
    addAdGroupAdOperand.setAccountId(accountId);
    addAdGroupAdOperand.setCampaignId(campaignId);
    addAdGroupAdOperand.setAdGroupId(adGroupId);
    addAdGroupAdOperand.setAdName("SampleAdGroupAd_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addAdGroupAdOperand.setAdStyle(AdStyle.VIDEO);
    addAdGroupAdOperand.setMediaId(mediaId);
    addAdGroupAdOperand.setUserStatus(jp.yahooapis.im.v201812.adgroupad.UserStatus.ACTIVE);
    ManualCPVAdGroupAdBid addAdGroupAd = new ManualCPVAdGroupAdBid();
    addAdGroupAd.setMaxCpv((long) 50);
    addAdGroupAd.setType(jp.yahooapis.im.v201812.adgroupad.BiddingStrategyType.MANUAL_CPV);
    addAdGroupAdOperand.setAd(addVideoAd);

    AdGroupAdOperation addAdGroupAdOperation = new AdGroupAdOperation();
    addAdGroupAdOperation.setOperator(jp.yahooapis.im.v201812.adgroupad.Operator.ADD);
    addAdGroupAdOperation.setAccountId(accountId);
    addAdGroupAdOperation.getOperand().add(addAdGroupAdOperand);

    return addAdGroupAdOperation;
  }

  /**
   * create sample adGroupAd request.
   *
   * @param accountId       long
   * @param adGroupAdValues AdGroupAdValues
   * @return AdGroupAdOperation
   */
  public static AdGroupAdOperation createAdGroupAdSampleSetRequest(long accountId, List<AdGroupAdValues> adGroupAdValues) {
    // Set Operation
    AdGroupAdOperation setAdGroupAdOperation = new AdGroupAdOperation();
    setAdGroupAdOperation.setOperator(jp.yahooapis.im.v201812.adgroupad.Operator.SET);
    setAdGroupAdOperation.setAccountId(accountId);

    VideoAd setVideoAd = new VideoAd();
    setVideoAd.setType(AdType.VIDEO_AD);
    setVideoAd.setHeadline("sample headline");
    setVideoAd.setDescription("sample ad desc");
    setVideoAd.setUrl("http://www.yahoo.co.jp/");
    setVideoAd.setDisplayUrl("www.yahoo.co.jp");
    setVideoAd.setPrincipal("sample principal");

    // Set Operand
    for (AdGroupAdValues adGroupAdValue : adGroupAdValues) {
      AdGroupAd setAdGroupAdOperand = new AdGroupAd();
      setAdGroupAdOperand.setAccountId(accountId);
      setAdGroupAdOperand.setCampaignId(adGroupAdValue.getAdGroupAd().getCampaignId());
      setAdGroupAdOperand.setAdGroupId(adGroupAdValue.getAdGroupAd().getAdGroupId());
      setAdGroupAdOperand.setAdId(adGroupAdValue.getAdGroupAd().getAdId());
      setAdGroupAdOperand.setAdName("SampleAdGroupAd_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setAdGroupAdOperand.setUserStatus(jp.yahooapis.im.v201812.adgroupad.UserStatus.PAUSED);
      ManualCPVAdGroupAdBid setAdGroupAdManualCpv = new ManualCPVAdGroupAdBid();
      setAdGroupAdManualCpv.setType(jp.yahooapis.im.v201812.adgroupad.BiddingStrategyType.MANUAL_CPC);
      setAdGroupAdManualCpv.setMaxCpv((long) 60);
      setAdGroupAdOperand.setAd(setVideoAd);

      setAdGroupAdOperation.getOperand().add(setAdGroupAdOperand);
    }

    return setAdGroupAdOperation;
  }

  public static List<UploadUrlValues> getUploadUrl(long accountId, List<UploadVideo> uploadVideoList) throws Exception {
    // =================================================================
    // VideoService
    // =================================================================
    VideoServiceInterface videoService = SoapUtils.createServiceInterface(VideoServiceInterface.class, VideoService.class);

    System.out.println("############################################");
    System.out.println("VideoService::getUploadUrl");
    System.out.println("############################################");

    Holder<UploadUrlPage> uploadUrlPageHolder = new Holder<>();
    Holder<List<Error>> getUploadUrlError = new Holder<>();
    videoService.getUploadUrl(accountId, uploadVideoList, uploadUrlPageHolder, getUploadUrlError);

    // if error
    if (getUploadUrlError.value != null && getUploadUrlError.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(getUploadUrlError.value), true);
    }

    // response
    if (uploadUrlPageHolder.value != null) {
      UploadUrlPage uploadUrlPage = uploadUrlPageHolder.value;
      if (uploadUrlPage.getValues() != null && uploadUrlPage.getValues().size() > 0) {
        for (UploadUrlValues uploadUrlValues : uploadUrlPage.getValues()) {
          if (uploadUrlValues.isOperationSucceeded()) {
            displayUploadUrl(uploadUrlValues.getUploadUrlValue());
          } else {
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(uploadUrlValues.getError()), true);
          }
        }
      }
    }

    return uploadUrlPageHolder.value != null ? uploadUrlPageHolder.value.getValues() : null;
  }

  /**
   * Sample Program for VideoUploadService Upload.
   *
   * @param uploadUrl String
   * @return uploadMediaId long
   */
  public static long upload(String uploadUrl) throws Exception {
    // file upload
    System.out.println("############################################");
    System.out.println("VideoService::upload");
    System.out.println("############################################");
    String response = SoapUtils.upload(uploadUrl, "SampleVideoUpload.mp4", "video/mpeg");

    // get upload video media ID
    long uploadMediaId = -1;
    ObjectMapper objectMapper = new ObjectMapper();
    Map<String, Map<String, ArrayList<Map<String, Map<String, String>>>>> object = objectMapper.readValue(response, Map.class);
    if (object != null) {
      Object mediaId = object.get("ResultSet").get("Result").get(0).get("uploadVideoData").get("mediaId");
      uploadMediaId = (Integer) mediaId;
    } else {
      throw new RuntimeException("Fail to upload to Video. response=" + response);
    }

    // return
    return uploadMediaId;
  }

  public static List<VideoValues> getVideo(VideoSelector videoSelector) throws Exception {
    // =================================================================
    // VideoService
    // =================================================================
    VideoServiceInterface videoService = SoapUtils.createServiceInterface(VideoServiceInterface.class, VideoService.class);

    System.out.println("############################################");
    System.out.println("VideoService::get");
    System.out.println("############################################");

    Holder<VideoPage> videoPageHolder = new Holder<>();
    Holder<List<Error>> getVideoErrorHolder = new Holder<>();
    videoService.get(videoSelector, videoPageHolder, getVideoErrorHolder);

    // if error
    if (getVideoErrorHolder.value != null && getVideoErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(getVideoErrorHolder.value), true);
    }

    // response
    if (videoPageHolder.value != null) {
      VideoPage videoPage = videoPageHolder.value;
      if (videoPage.getValues() != null && videoPage.getValues().size() > 0) {
        List<VideoValues> values = videoPage.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            displayVideo(values.get(i).getVideo());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }

    return videoPageHolder.value != null ? videoPageHolder.value.getValues() : null;
  }

  public static List<VideoValues> setVideo(VideoOperation videoOperation) throws Exception {
    // =================================================================
    // VideoService
    // =================================================================
    VideoServiceInterface videoService = SoapUtils.createServiceInterface(VideoServiceInterface.class, VideoService.class);

    System.out.println("############################################");
    System.out.println("VideoService::set");
    System.out.println("############################################");

    Holder<VideoReturnValue> videoReturnValueHolder = new Holder<>();
    Holder<List<Error>> setVideoErrorHolder = new Holder<>();
    videoService.mutate(videoOperation, videoReturnValueHolder, setVideoErrorHolder);

    // if error
    if (setVideoErrorHolder.value != null && setVideoErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(setVideoErrorHolder.value), true);
    }

    // response
    if (videoReturnValueHolder.value != null) {
      VideoReturnValue videoReturnValue = videoReturnValueHolder.value;
      if (videoReturnValue.getValues() != null && videoReturnValue.getValues().size() > 0) {
        List<VideoValues> values = videoReturnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            displayVideo(values.get(i).getVideo());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }

    return videoReturnValueHolder.value.getValues();
  }

  public static List<VideoValues> removeVideo(VideoOperation videoOperation) throws Exception {
    // =================================================================
    // VideoService
    // =================================================================
    VideoServiceInterface videoService = SoapUtils.createServiceInterface(VideoServiceInterface.class, VideoService.class);

    System.out.println("############################################");
    System.out.println("VideoService::remove");
    System.out.println("############################################");

    Holder<VideoReturnValue> videoReturnValueHolder = new Holder<>();
    Holder<List<Error>> setVideoErrorHolder = new Holder<>();
    videoService.mutate(videoOperation, videoReturnValueHolder, setVideoErrorHolder);

    // if error
    if (setVideoErrorHolder.value != null && setVideoErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(setVideoErrorHolder.value), true);
    }

    // response
    if (videoReturnValueHolder.value != null) {
      VideoReturnValue videoReturnValue = videoReturnValueHolder.value;
      if (videoReturnValue.getValues() != null && videoReturnValue.getValues().size() > 0) {
        List<VideoValues> values = videoReturnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            displayVideo(values.get(i).getVideo());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }

    return videoReturnValueHolder.value.getValues();
  }

  private static void displayUploadUrl(UploadUrlValue uploadUrlValue) {
    System.out.println("accountId = " + uploadUrlValue.getAccountId());
    System.out.println("uploadUrl = " + uploadUrlValue.getUploadUrl());
    System.out.println("acceptableUploadStatus = " + uploadUrlValue.isAcceptableUploadStatus().toString());
    System.out.println("---------");
  }

  private static void displayVideo(Video video) {
    System.out.println("accountId = " + video.getAccountId());
    System.out.println("mediaId = " + video.getMediaId());
    System.out.println("videoName = " + video.getVideoName());
    System.out.println("videoTitle = " + video.getVideoTitle());
    System.out.println("approvalStatus = " + video.getApprovalStatus());
    System.out.println("processStatus = " + video.getProcessStatus());
    System.out.println("userStatus = " + video.getUserStatus());
    System.out.println("---------");
  }
}
