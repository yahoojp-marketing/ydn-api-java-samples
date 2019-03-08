/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.bulk;

import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.v201903.Error;
import jp.yahooapis.im.v201903.Paging;
import jp.yahooapis.im.v201903.bulk.ApprovalStatus;
import jp.yahooapis.im.v201903.bulk.BulkDownloadReturnValue;
import jp.yahooapis.im.v201903.bulk.BulkDownloadSelector;
import jp.yahooapis.im.v201903.bulk.BulkDownloadStatusPage;
import jp.yahooapis.im.v201903.bulk.BulkDownloadStatusSelector;
import jp.yahooapis.im.v201903.bulk.BulkDownloadType;
import jp.yahooapis.im.v201903.bulk.BulkDownloadValues;
import jp.yahooapis.im.v201903.bulk.BulkEncoding;
import jp.yahooapis.im.v201903.bulk.BulkLang;
import jp.yahooapis.im.v201903.bulk.BulkOutput;
import jp.yahooapis.im.v201903.bulk.BulkService;
import jp.yahooapis.im.v201903.bulk.BulkServiceInterface;
import jp.yahooapis.im.v201903.bulk.BulkUploadStatusPage;
import jp.yahooapis.im.v201903.bulk.BulkUploadStatusSelector;
import jp.yahooapis.im.v201903.bulk.BulkUploadValues;
import jp.yahooapis.im.v201903.bulk.DownloadBulkJobStatus;
import jp.yahooapis.im.v201903.bulk.EntityType;
import jp.yahooapis.im.v201903.bulk.MediaApprovalStatus;
import jp.yahooapis.im.v201903.bulk.UploadBulkJobStatus;
import jp.yahooapis.im.v201903.bulk.UploadUrlValue;
import jp.yahooapis.im.v201903.bulk.UserStatus;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.ws.Holder;

/**
 * example BulkService operation and Utility method collection.
 */
public class BulkServiceSample {

  /**
   * example BulkService operation.
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
      // BulkService getUploadUrl
      // =================================================================
      // run
      UploadUrlValue getUploadUrlResponse = getUploadUrl(accountId);
      String uploadUrl = getUploadUrlResponse.getUploadUrl();

      // =================================================================
      // BulkService upload (http request)
      // =================================================================
      // run
      String uploadResponse = SoapUtils.upload(uploadUrl, "bulkUploadSample.csv", "text/csv");
      Document responseDOM = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(uploadResponse)));
      NodeList nodeList = responseDOM.getElementsByTagName("uploadBulkJobId");
      List<Long> uploadBulkJobIds = new ArrayList<>();
      if (nodeList.getLength() > 0) {
        uploadBulkJobIds.add(Long.parseLong(nodeList.item(0).getFirstChild().getNodeValue()));
      } else {
        throw new RuntimeException("Fail to upload to Bulk. response=" + uploadResponse);
      }

      // =================================================================
      // BulkService getBulkUploadStatus
      // =================================================================
      // check job status
      checkBulkUploadStatus(uploadBulkJobIds);

      // create request.
      BulkUploadStatusSelector getBulkUploadStatusRequest = buildExampleGetBulkUploadStatusRequest(accountId, uploadBulkJobIds);

      // run
      List<BulkUploadValues> getBulkUploadStatusResponse = getBulkUploadStatus(getBulkUploadStatusRequest);
      String downloadUrl = null;
      for (BulkUploadValues bulkDownloadValues : getBulkUploadStatusResponse) {
        downloadUrl = bulkDownloadValues.getUploadBulkJob().getDownloadBulkUploadFileUrl();
      }

      // =================================================================
      // BulkService download for upload result (http request)
      // =================================================================
      SoapUtils.download(downloadUrl, "bulkUploadFileDownloadSample.csv");

      // =================================================================
      // BulkService getBulkDownload
      // =================================================================
      // create request.
      BulkDownloadSelector getBulkDownloadRequest = buildExampleGetBulkDownloadRequest(accountId);

      // run
      List<BulkDownloadValues> getBulkDownloadResponse = getBulkDownload(getBulkDownloadRequest);
      List<Long> downloadBulkJobIds = new ArrayList<>();
      for (BulkDownloadValues bulkDownloadValues : getBulkDownloadResponse) {
        downloadBulkJobIds.add(bulkDownloadValues.getDownloadBulkJob().getDownloadBulkJobId());
      }

      // =================================================================
      // BulkService getBulkDownloadStatus
      // =================================================================
      // check job status
      checkBulkDownloadStatus(downloadBulkJobIds);

      // create request.
      BulkDownloadStatusSelector getDownloadStatusRequest = buildExampleGetBulkDownloadStatusRequest(accountId, downloadBulkJobIds);

      // run
      List<BulkDownloadValues> getBulkDownloadStatusResponse = getBulkDownloadStatus(getDownloadStatusRequest);
      downloadUrl = null;
      for(BulkDownloadValues bulkDownloadValues : getBulkDownloadStatusResponse) {
        downloadUrl = bulkDownloadValues.getDownloadBulkJob().getDownloadBulkDownloadUrl();
      }

      // =================================================================
      // BulkService download (http request)
      // =================================================================
      SoapUtils.download(downloadUrl, "bulkDownloadSample.csv");

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example getUploadUrl Bulk.
   *
   * @param accountId long
   * @return UploadUrlValue
   */
  public static UploadUrlValue getUploadUrl(long accountId) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("BulkService::getUploadUrl");
    System.out.println("############################################");

    Holder<UploadUrlValue> uploadUrlValueHolder = new Holder<UploadUrlValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    BulkServiceInterface bulkService = SoapUtils.createServiceInterface(BulkServiceInterface.class, BulkService.class);
    bulkService.getUploadUrl(accountId, "sample-job-name", uploadUrlValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder);

    if (uploadUrlValueHolder.value != null) {
      if (!uploadUrlValueHolder.value.isAcceptableUploadStatus()) {
        throw new Exception("Bulk Upload is unacceptable now.");
      }
    }

    // response
    return uploadUrlValueHolder.value;
  }

  /**
   * example getBulkUploadStatus Bulk.
   *
   * @param selector BulkUploadStatusSelector
   * @return BulkUploadValues
   */
  public static List<BulkUploadValues> getBulkUploadStatus(BulkUploadStatusSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("BulkService::getBulkUploadStatus");
    System.out.println("############################################");

    Holder<BulkUploadStatusPage> bulkUploadStatusPageHolder = new Holder<BulkUploadStatusPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    BulkServiceInterface bulkService = SoapUtils.createServiceInterface(BulkServiceInterface.class, BulkService.class);
    bulkService.getBulkUploadStatus(selector, bulkUploadStatusPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, bulkUploadStatusPageHolder.value.getValues());

    // Response
    return bulkUploadStatusPageHolder.value.getValues();
  }

  /**
   * example getBulkDownload Bulk.
   *
   * @param selector BulkDownloadSelector
   * @return BulkDownloadValues
   */
  public static List<BulkDownloadValues> getBulkDownload(BulkDownloadSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("BulkService::getBulkDownload");
    System.out.println("############################################");

    Holder<BulkDownloadReturnValue> bulkDownloadReturnValueHolder = new Holder<BulkDownloadReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    BulkServiceInterface bulkService = SoapUtils.createServiceInterface(BulkServiceInterface.class, BulkService.class);
    bulkService.getBulkDownload(selector, bulkDownloadReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, bulkDownloadReturnValueHolder.value.getValues());

    // Response
    return bulkDownloadReturnValueHolder.value.getValues();
  }

  /**
   * example getBulkDownloadStatus Bulk.
   *
   * @param selector BulkDownloadStatusSelector
   * @return BulkDownloadValues
   */
  public static List<BulkDownloadValues> getBulkDownloadStatus(BulkDownloadStatusSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("BulkService::getBulkDownloadStatus");
    System.out.println("############################################");

    Holder<BulkDownloadStatusPage> bulkDownloadStatusPageHolder = new Holder<BulkDownloadStatusPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    BulkServiceInterface bulkService = SoapUtils.createServiceInterface(BulkServiceInterface.class, BulkService.class);
    bulkService.getBulkDownloadStatus(selector, bulkDownloadStatusPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, bulkDownloadStatusPageHolder.value.getValues());

    // Response
    return bulkDownloadStatusPageHolder.value.getValues();
  }

  /**
   * example check Bulk Upload job status.
   *
   * @param jobIds List<Long>
   * @return void
   */
  public static void checkBulkUploadStatus(List<Long> jobIds) throws Exception {

    // call 30sec sleep * 30 = 15minute
    for (int i = 0; i < 30; i++) {

      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds for Bulk Upload Job *****\n");
      Thread.sleep(30000);

      // get
      BulkUploadStatusSelector getRequest = buildExampleGetBulkUploadStatusRequest(SoapUtils.getAccountId(), jobIds);
      List<BulkUploadValues> getResponse = getBulkUploadStatus(getRequest);

      int completedCount = 0;

      // upload job check.
      for (BulkUploadValues bulkUploadValues : getResponse) {
        UploadBulkJobStatus status = bulkUploadValues.getUploadBulkJob().getUploadBulkJobStatus();
        if (status == null) {
          throw new Exception("Fail to getBulkUploadStatus BulkService.");
        }
        switch (status) {
          default:
          case FILE_FORMAT_ERROR:
          case TIMEOUT:
          case SYSTEM_ERROR:
            throw new Exception("check upload Status failed.");
          case IN_PROGRESS:
            continue;
          case COMPLETED:
            completedCount++;
            continue;
        }
      }

      if (getResponse.size() == completedCount) {
        return;
      }
    }
    throw new Exception("Fail to getBulkUploadStatus BulkService.");
  }

  /**
   * example check Bulk Download job status.
   *
   * @param jobIds List<Long>
   * @return void
   */
  public static void checkBulkDownloadStatus(List<Long> jobIds) throws Exception {

    // call 30sec sleep * 30 = 15minute
    for (int i = 0; i < 30; i++) {

      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds for Bulk Download Job *****\n");
      Thread.sleep(30000);

      // get
      BulkDownloadStatusSelector getRequest = buildExampleGetBulkDownloadStatusRequest(SoapUtils.getAccountId(), jobIds);
      List<BulkDownloadValues> getResponse = getBulkDownloadStatus(getRequest);

      int completedCount = 0;

      // upload job check.
      for (BulkDownloadValues bulkDownloadValues : getResponse) {
        DownloadBulkJobStatus status = bulkDownloadValues.getDownloadBulkJob().getDownloadJobStatus();
        if (status == null) {
          throw new Exception("Fail to getBulkDownloadStatus BulkService.");
        }
        switch (status) {
          default:
          case TIMEOUT:
          case SYSTEM_ERROR:
            throw new Exception("check download Status failed.");
          case IN_PROGRESS:
            continue;
          case COMPLETED:
            completedCount++;
            continue;
        }
      }

      if (getResponse.size() == completedCount) {
        return;
      }
    }
    throw new Exception("Fail to getBulkDownloadStatus BulkService.");
  }

  /**
   * example getBulkUploadStatus request.
   *
   * @param accountId        long
   * @param uploadBulkJobIds List<Long>
   * @return BulkUploadStatusSelector
   */
  public static BulkUploadStatusSelector buildExampleGetBulkUploadStatusRequest(long accountId, List<Long> uploadBulkJobIds) {
    BulkUploadStatusSelector selector = new BulkUploadStatusSelector();
    selector.setAccountId(accountId);
    selector.getUploadBulkJobIds().addAll(uploadBulkJobIds);
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);
    return selector;
  }

  /**
   * example getBulkDownload request.
   *
   * @param accountId long
   * @return BulkDownloadSelector
   */
  public static BulkDownloadSelector buildExampleGetBulkDownloadRequest(long accountId) {
    BulkDownloadSelector selector = new BulkDownloadSelector();
    selector.setAccountId(accountId);
    selector.getCampaignUserStatuses().add(UserStatus.ACTIVE);
    selector.getAdGroupUserStatuses().add(UserStatus.ACTIVE);
    selector.getAdGroupAdUserStatuses().add(UserStatus.ACTIVE);
    selector.getMediaUserStatuses().add(UserStatus.ACTIVE);
    selector.getAdGroupAdApprovalStatuses().add(ApprovalStatus.APPROVED);
    selector.getMediaApprovalStatuses().add(MediaApprovalStatus.APPROVED);
    selector.setLang(BulkLang.JA);
    selector.setEntityTypes(EntityType.ALL);
    selector.setDownloadType(BulkDownloadType.CAMPAIGN);
    selector.setOutput(BulkOutput.CSV);
    selector.setEncoding(BulkEncoding.UTF_8);
    return selector;
  }

  /**
   * example getBulkUploadStatus request.
   *
   * @param accountId long
   * @param downloadBulkJobIds List<Long>
   * @return BulkDownloadStatusSelector
   */
  public static BulkDownloadStatusSelector buildExampleGetBulkDownloadStatusRequest(long accountId, List<Long> downloadBulkJobIds)  {
    BulkDownloadStatusSelector selector = new BulkDownloadStatusSelector();
    selector.setAccountId(accountId);
    selector.getDownloadBulkJobIds().addAll(downloadBulkJobIds);
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);
    return selector;
  }
}
