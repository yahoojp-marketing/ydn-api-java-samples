/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.video;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.v201907.Error;
import jp.yahooapis.im.v201907.Paging;
import jp.yahooapis.im.v201907.video.ApprovalStatus;
import jp.yahooapis.im.v201907.video.Operator;
import jp.yahooapis.im.v201907.video.UploadUrlPage;
import jp.yahooapis.im.v201907.video.UploadVideo;
import jp.yahooapis.im.v201907.video.UserStatus;
import jp.yahooapis.im.v201907.video.Video;
import jp.yahooapis.im.v201907.video.VideoOperation;
import jp.yahooapis.im.v201907.video.VideoPage;
import jp.yahooapis.im.v201907.video.VideoReturnValue;
import jp.yahooapis.im.v201907.video.VideoSelector;
import jp.yahooapis.im.v201907.video.VideoService;
import jp.yahooapis.im.v201907.video.VideoServiceInterface;
import jp.yahooapis.im.v201907.video.VideoValues;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example VideoService operation and Utility method collection.
 */
public class VideoServiceSample {

  /**
   * example VideoService operation.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      long mediaId;

      // =================================================================
      // VideoService UPLOAD
      // =================================================================
      // getUploadUrl
      String fileName = "videoUploadSample.mp4";
      List<UploadVideo> uploadVideo = new ArrayList<>();
      UploadVideo uploadVideoValue = new UploadVideo();
      uploadVideoValue.setVideoName("SampleName_CreatedOn_" + SoapUtils.getCurrentTimestamp());
      uploadVideoValue.setVideoTitle("SampleTitle_CreatedOn_" + SoapUtils.getCurrentTimestamp());
      uploadVideoValue.setUserStatus(UserStatus.ACTIVE);
      uploadVideo.add(uploadVideoValue);

      UploadUrlPage getUploadUrlResponse = getUploadUrl(accountId, uploadVideo);

      String uploadUrl = getUploadUrlResponse.getValues().get(0).getUploadUrlValue().getUploadUrl();

      // upload
      String uploadResponse = SoapUtils.upload(uploadUrl, fileName, "video/mp4");
      ObjectMapper mapper = new ObjectMapper();
      JsonNode objectMap =mapper.readTree(uploadResponse);
      mediaId = Long.valueOf(objectMap.get("ResultSet").get("Result").get(0).get("uploadVideoData").get("mediaId").toString());

      // =================================================================
      // VideoService GET
      // =================================================================
      // create request.
      VideoSelector getRequest = buildExampleGetRequest(accountId, mediaId);

      // run
      get(getRequest);

      // =================================================================
      // VideoService SET
      // =================================================================
      // create request.
      VideoOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId, new ArrayList<Video>() {{
        add(createExampleSetRequest(accountId, mediaId));
      }});

      // run
      mutate(setRequest);

      // =================================================================
      // VideoService REMOVE
      // =================================================================
      // create request.
      VideoOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId,new ArrayList<Video>() {{
        add(createExampleRemoveRequest(accountId, mediaId));
      }});

      // run
      mutate(removeRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example get Video.
   *
   * @param selector VideoSelector
   * @return VideoValues
   */
  public static List<VideoValues> get(VideoSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("VideoService::get");
    System.out.println("############################################");

    Holder<VideoPage> videoPageHolder = new Holder<VideoPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    VideoServiceInterface videoServiceInterface = SoapUtils.createServiceInterface(VideoServiceInterface.class, VideoService.class);
    videoServiceInterface.get(selector, videoPageHolder, errorHolder);

    // Response
    return videoPageHolder.value.getValues();
  }

  /**
   * example mutate Video.
   *
   * @return VideoValues
   */
  public static List<VideoValues> mutate(VideoOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("VideoService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<VideoReturnValue> videoReturnValueHolder = new Holder<VideoReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    VideoServiceInterface videoServiceInterface = SoapUtils.createServiceInterface(VideoServiceInterface.class, VideoService.class);
    videoServiceInterface.mutate(operation, videoReturnValueHolder, errorHolder);

    // Response
    return videoReturnValueHolder.value.getValues();
  }

  /**
   * example getUploadUrl video.
   *
   * @param uploadVideo UploadVideo
   * @return UploadUrlPage
   */
  public static UploadUrlPage getUploadUrl(long accountId, List<UploadVideo> uploadVideo) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("VideoService::getUploadUrl");
    System.out.println("############################################");

    Holder<UploadUrlPage> getUploadUrlHolder = new Holder<>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    VideoServiceInterface VideoService = SoapUtils.createServiceInterface(VideoServiceInterface.class, VideoService.class);
    VideoService.getUploadUrl(accountId, uploadVideo, getUploadUrlHolder, errorHolder);

    // Response
    return getUploadUrlHolder.value;
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @param mediaId long
   * @return VideoSelector
   */
  public static VideoSelector buildExampleGetRequest(long accountId, long mediaId) {
    VideoSelector selector = new VideoSelector();
    selector.setAccountId(accountId);
    selector.getMediaIds().add(mediaId);
    selector.getApprovalStatuses().add(ApprovalStatus.REVIEW);
    selector.getUserStatuses().add(UserStatus.ACTIVE);

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * example mutate request.
   */
  public static VideoOperation buildExampleMutateRequest(Operator operator, long accountId, List<Video> operand) {
    VideoOperation operation = new VideoOperation();
    operation.setAccountId(accountId);
    operation.setOperator(operator);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example Video set request.
   *
   * @param accountId long
   * @param mediaId long
   * @return Video
   */
  public static Video createExampleSetRequest(long accountId, long mediaId) {
    // create operand
    Video operand = new Video();

    operand.setAccountId(accountId);
    operand.setMediaId(mediaId);
    operand.setVideoTitle("SampleTitle_UpdatedOn_" + SoapUtils.getCurrentTimestamp());

    return operand;
  }

  /**
   * example Video remove request.
   *
   * @param accountId long
   * @param mediaId long
   * @return Video
   */
  public static Video createExampleRemoveRequest(long accountId, long mediaId) {
    // create operand
    Video operand = new Video();

    operand.setAccountId(accountId);
    operand.setMediaId(mediaId);

    return operand;
  }
}
