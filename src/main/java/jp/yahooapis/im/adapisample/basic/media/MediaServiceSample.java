/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.media;

import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201903.Error;
import jp.yahooapis.im.v201903.Paging;
import jp.yahooapis.im.v201903.media.ImageMedia;
import jp.yahooapis.im.v201903.media.LogoFlg;
import jp.yahooapis.im.v201903.media.MediaOperation;
import jp.yahooapis.im.v201903.media.MediaPage;
import jp.yahooapis.im.v201903.media.MediaRecord;
import jp.yahooapis.im.v201903.media.MediaReturnValue;
import jp.yahooapis.im.v201903.media.MediaSelector;
import jp.yahooapis.im.v201903.media.MediaService;
import jp.yahooapis.im.v201903.media.MediaServiceInterface;
import jp.yahooapis.im.v201903.media.MediaValues;
import jp.yahooapis.im.v201903.media.Operator;
import jp.yahooapis.im.v201903.media.UserStatus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example MediaService operation and Utility method collection.
 */
public class MediaServiceSample {

  /**
   * example MediaService operation.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    // =================================================================
    // Setting
    // =================================================================
    ValuesHolder valuesHolder = new ValuesHolder();
    ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
    long accountId = SoapUtils.getAccountId();

    try {
      // =================================================================
      // MediaService ADD
      // =================================================================
      // create request.
      MediaOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, Collections.singletonList(createExampleMedia(accountId, "SampleMedia.jpg", LogoFlg.FALSE)));

      // run
      List<MediaValues> addResponse = mutate(addRequest);
      valuesHolder.setMediaValuesList(addResponse);

      // =================================================================
      // MediaService GET
      // =================================================================
      // create request.
      MediaSelector getRequest = buildExampleGetRequest(accountId, valuesRepositoryFacade.getMediaValuesRepository().getMediaIds());

      // run
      get(getRequest);

      // =================================================================
      // MediaService SET
      // =================================================================
      // create request.
      MediaOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId, createExampleSetRequest(valuesRepositoryFacade.getMediaValuesRepository().getMediaRecord()));

      // run
      mutate(setRequest);

      // =================================================================
      // MediaService REMOVE
      // =================================================================
      // create request.
      MediaOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getMediaValuesRepository().getMediaRecord());

      // run
      mutate(removeRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example get media.
   *
   * @param selector MediaSelector
   * @return MediaValues
   */
  public static List<MediaValues> get(MediaSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("MediaService::get");
    System.out.println("############################################");

    Holder<MediaPage> mediaPageHolder = new Holder<MediaPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    MediaServiceInterface mediaService = SoapUtils.createServiceInterface(MediaServiceInterface.class, MediaService.class);
    mediaService.get(selector, mediaPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, mediaPageHolder.value.getValues());

    // Response
    return mediaPageHolder.value.getValues();
  }

  /**
   * example mutate media.
   *
   * @param operation MediaOperation
   * @return MediaValues
   */
  public static List<MediaValues> mutate(MediaOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("MediaService::mutate(" + operation.getOperator().toString() + ")");
    System.out.println("############################################");

    Holder<MediaReturnValue> mediaReturnValueHolder = new Holder<MediaReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    MediaServiceInterface mediaService = SoapUtils.createServiceInterface(MediaServiceInterface.class, MediaService.class);
    mediaService.mutate(operation, mediaReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, mediaReturnValueHolder.value.getValues());

    // Response
    return mediaReturnValueHolder.value.getValues();
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @param mediaIds  List<Long>
   * @return MediaSelector
   */
  public static MediaSelector buildExampleGetRequest(long accountId, List<Long> mediaIds) {
    MediaSelector selector = new MediaSelector();
    selector.setAccountId(accountId);
    selector.getUserStatuses().addAll(Arrays.asList(UserStatus.ACTIVE, UserStatus.PAUSED));
    selector.getMediaIds().addAll(mediaIds);
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);
    return selector;
  }

  /**
   * example mutate request.
   *
   * @param operator  Operator
   * @param accountId long
   * @param operand   List<MediaRecord>
   * @return mutate
   */
  public static MediaOperation buildExampleMutateRequest(Operator operator, long accountId, List<MediaRecord> operand) {
    MediaOperation operation = new MediaOperation();
    operation.setAccountId(accountId);
    operation.setOperator(operator);
    operation.getOperand().addAll(operand);
    return operation;
  }

  /**
   * example Media add request.
   *
   * @param accountId long
   * @return MediaRecord
   */
  public static MediaRecord createExampleMedia(long accountId, String imageFile, LogoFlg logoFlg) throws Exception {
    // imageMedia
    ImageMedia imageMedia = new ImageMedia();
    imageMedia.setData(getMediaData(imageFile));

    // media
    MediaRecord media = new MediaRecord();
    media.setAccountId(accountId);
    media.setMediaName("SampleMedia_CreateOn_" + SoapUtils.getCurrentTimestamp() + ".jpg");
    media.setMediaTitle("SampleMedia_CreateOn_" + SoapUtils.getCurrentTimestamp());
    media.setUserStatus(UserStatus.ACTIVE);
    media.setMedia(imageMedia);
    media.setLogoFlg(logoFlg);

    return media;
  }

  /**
   * example media set request.
   *
   * @param mediaRecord List<MediaRecord>
   * @return List<MediaRecord>
   */
  public static List<MediaRecord> createExampleSetRequest(List<MediaRecord> mediaRecord) {
    // create operands
    List<MediaRecord> operands = new ArrayList<>();

    for (MediaRecord media : mediaRecord) {
      MediaRecord operand = new MediaRecord();
      operand.setAccountId(media.getAccountId());
      operand.setMediaId(media.getMediaId());
      operand.setMediaTitle("SampleMedia_UpdatedOn_" + SoapUtils.getCurrentTimestamp());
      operand.setUserStatus(UserStatus.PAUSED);
      operands.add(operand);
    }

    return operands;
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
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    if (valuesHolder.getMediaValuesList().size() > 0) {
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      MediaOperation removeRequest = MediaServiceSample.buildExampleMutateRequest(Operator.REMOVE, SoapUtils.getAccountId(), valuesRepositoryFacade.getMediaValuesRepository().getMediaRecord());
      MediaServiceSample.mutate(removeRequest);
    }
  }
}
