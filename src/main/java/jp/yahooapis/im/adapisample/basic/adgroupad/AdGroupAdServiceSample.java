/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.adgroupad;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.yahooapis.im.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.im.adapisample.basic.media.MediaServiceSample;
import jp.yahooapis.im.adapisample.basic.video.VideoServiceSample;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201911.Error;
import jp.yahooapis.im.v201911.Paging;
import jp.yahooapis.im.v201911.adgroupad.AdGroupAd;
import jp.yahooapis.im.v201911.adgroupad.AdGroupAdOperation;
import jp.yahooapis.im.v201911.adgroupad.AdGroupAdPage;
import jp.yahooapis.im.v201911.adgroupad.AdGroupAdReturnValue;
import jp.yahooapis.im.v201911.adgroupad.AdGroupAdSelector;
import jp.yahooapis.im.v201911.adgroupad.AdGroupAdService;
import jp.yahooapis.im.v201911.adgroupad.AdGroupAdServiceInterface;
import jp.yahooapis.im.v201911.adgroupad.AdGroupAdValues;
import jp.yahooapis.im.v201911.adgroupad.AdStyle;
import jp.yahooapis.im.v201911.adgroupad.AdType;
import jp.yahooapis.im.v201911.adgroupad.BiddingStrategyType;
import jp.yahooapis.im.v201911.adgroupad.ButtonText;
import jp.yahooapis.im.v201911.adgroupad.DynamicAd;
import jp.yahooapis.im.v201911.adgroupad.ManualCPCAdGroupAdBid;
import jp.yahooapis.im.v201911.adgroupad.ManualCPVAdGroupAdBid;
import jp.yahooapis.im.v201911.adgroupad.Operator;
import jp.yahooapis.im.v201911.adgroupad.ResponsiveVideoAd;
import jp.yahooapis.im.v201911.adgroupad.TextAd;
import jp.yahooapis.im.v201911.adgroupad.UserStatus;
import jp.yahooapis.im.v201911.campaign.CampaignType;
import jp.yahooapis.im.v201911.media.LogoFlg;
import jp.yahooapis.im.v201911.media.MediaOperation;
import jp.yahooapis.im.v201911.media.MediaValues;
import jp.yahooapis.im.v201911.media.ThumbnailFlg;
import jp.yahooapis.im.v201911.video.UploadUrlPage;
import jp.yahooapis.im.v201911.video.Video;
import jp.yahooapis.im.v201911.video.VideoOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    long thumbnailId;
    long logoId;
    long videoId;

    try {
      // =================================================================
      // check & create upper service object.
      // =================================================================
      valuesHolder = setup();
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      Long campaignIdStandard = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(
          CampaignType.STANDARD
      );
      Long campaignIdVideoAd = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignIdAdProductType(
          "VIDEO_AD"
      );
      Long adGroupIdStandard = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignIdStandard);
      Long adGroupIdVideoAd = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignIdVideoAd);

      // =================================================================
      // VideoService Upload
      // =================================================================
      String videoFileName = "videoUploadSample2.mp4";
      UploadUrlPage getUploadUrlResponse = VideoServiceSample.getUploadUrl(accountId, VideoServiceSample.buildExampleUploadVideoList());
      String uploadUrl = getUploadUrlResponse.getValues().get(0).getUploadUrlValue().getUploadUrl();

      // upload
      String uploadResponse = SoapUtils.upload(uploadUrl, videoFileName, "video/mp4");
      ObjectMapper mapper = new ObjectMapper();
      JsonNode objectMap = mapper.readTree(uploadResponse);
      videoId = Long.valueOf(objectMap.get("ResultSet").get("Result").get(0).get("uploadVideoData").get("mediaId").toString());

      // =================================================================
      // MediaService ADD
      // =================================================================
      // thumbnail
      MediaOperation addMediaRequest1 = MediaServiceSample.buildExampleMutateRequest(
          jp.yahooapis.im.v201911.media.Operator.ADD,
          accountId,
          Collections.singletonList(MediaServiceSample.createExampleMedia(accountId, "ThumbnailMedia1.jpg", LogoFlg.FALSE, ThumbnailFlg.TRUE))
      );
      // run
      List<MediaValues> addMediaResponse1 = MediaServiceSample.mutate(addMediaRequest1);
      valuesHolder.setMediaValuesList(addMediaResponse1);
      thumbnailId = addMediaResponse1.get(0).getMediaRecord().getMediaId();

      // logo
      MediaOperation addMediaRequest2 = MediaServiceSample.buildExampleMutateRequest(
          jp.yahooapis.im.v201911.media.Operator.ADD,
          accountId,
          Collections.singletonList(MediaServiceSample.createExampleMedia(accountId, "LogoMedia1.jpg", LogoFlg.TRUE, ThumbnailFlg.FALSE))
      );
      // run
      List<MediaValues> addMediaResponse2 = MediaServiceSample.mutate(addMediaRequest2);
      valuesHolder.setMediaValuesList(addMediaResponse2);
      logoId = addMediaResponse2.get(0).getMediaRecord().getMediaId();

      // =================================================================
      // AdGroupAdService ADD
      // =================================================================
      // create request.
      AdGroupAdOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<AdGroupAd>() {{
        add(createExampleExtendedTextAd(campaignIdStandard, adGroupIdStandard));
        add(createExampleResponsiveVideoAd(campaignIdVideoAd, adGroupIdVideoAd, thumbnailId, videoId, logoId));
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
      Long adIdResponsiveVideoAd =  valuesRepositoryFacade.getAdGroupAdValuesRepository().findAdId(campaignIdVideoAd, adGroupIdVideoAd, AdType.RESPONSIVE_VIDEO_AD);
      // create request.
      AdGroupAdOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId,
          createExampleSetRequest(valuesRepositoryFacade.getAdGroupAdValuesRepository().getAdGroupAds(), adIdResponsiveVideoAd)
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

      // =================================================================
      // VideoService REMOVE
      // =================================================================
      VideoOperation removeRequestVideo = VideoServiceSample.buildExampleMutateRequest(jp.yahooapis.im.v201911.video.Operator.REMOVE, accountId,new ArrayList<Video>() {{
        add(VideoServiceSample.createExampleRemoveRequest(accountId, videoId));
      }});
      VideoServiceSample.mutate(removeRequestVideo);

      // =================================================================
      // MediaService REMOVE
      // =================================================================
      MediaOperation removeRequestMedia = MediaServiceSample.buildExampleMutateRequest(jp.yahooapis.im.v201911.media.Operator.REMOVE, accountId, valuesRepositoryFacade.getMediaValuesRepository().getMediaRecord());
      MediaServiceSample.mutate(removeRequestMedia);

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
  public static List<AdGroupAd> createExampleSetRequest(List<AdGroupAd> AdGroupAds, Long adIdResponsiveVideoAd)
  {
    // create operands
    List<AdGroupAd> operands = new ArrayList<>();

    // bid
    ManualCPCAdGroupAdBid bid = new ManualCPCAdGroupAdBid();
    bid.setMaxCpc((long)60);
    bid.setType(BiddingStrategyType.MANUAL_CPC);

    for (AdGroupAd adGroupAd : AdGroupAds) {
      if (adGroupAd.getAdId().equals(adIdResponsiveVideoAd)) {
        continue;
      }
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
   * example Banner Video Ad request.
   *
   * @param campaignId
   * @param adGroupId
   * @param thumbnailId
   * @param videoId
   * @param logoId
   * @return AdGroupAd
   */
  public static AdGroupAd createExampleResponsiveVideoAd(long campaignId, long adGroupId, long thumbnailId, long videoId, long logoId)
  {
    // ad
    ResponsiveVideoAd ad = new ResponsiveVideoAd();
    ad.setType(AdType.RESPONSIVE_VIDEO_AD);
    ad.setThumbnailMediaId(thumbnailId);
    ad.setHeadline("headline");
    ad.setDescription("description");
    ad.setDisplayUrl("www.yahoo.co.jp");
    ad.setUrl("http://www.yahoo.co.jp/");
    ad.setButtonText(ButtonText.APPLY_NOW);
    ad.setPrincipal("principal");
    ad.setLogoMediaId(logoId);

    // bid
    ManualCPVAdGroupAdBid bid = new ManualCPVAdGroupAdBid();
    bid.setType(BiddingStrategyType.MANUAL_CPV);
    bid.setMaxCpv((long)10000);

    // adGroupAd
    AdGroupAd adGroupAd = new AdGroupAd();
    adGroupAd.setAccountId(SoapUtils.getAccountId());
    adGroupAd.setCampaignId(campaignId);
    adGroupAd.setAdGroupId(adGroupId);
    adGroupAd.setAdName("SampleDynamicAd_CreateOn_" + SoapUtils.getCurrentTimestamp());
    adGroupAd.setUserStatus(UserStatus.ACTIVE);
    adGroupAd.setMediaId(videoId);
    adGroupAd.setBid(bid);
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
