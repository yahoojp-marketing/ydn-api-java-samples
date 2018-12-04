package jp.co.yahoo.ad_api_sample.bulkUploadSample;

import jp.co.yahoo.ad_api_sample.error.impl.ErrorEntityFactoryImpl;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201812.Error;
import jp.yahooapis.im.v201812.Paging;
import jp.yahooapis.im.v201812.bulk.BulkOutput;
import jp.yahooapis.im.v201812.bulk.BulkServiceInterface;
import jp.yahooapis.im.v201812.bulk.BulkServiceService;
import jp.yahooapis.im.v201812.bulk.BulkUploadStatusPage;
import jp.yahooapis.im.v201812.bulk.BulkUploadStatusSelector;
import jp.yahooapis.im.v201812.bulk.BulkUploadValues;
import jp.yahooapis.im.v201812.bulk.UploadBulkJob;
import jp.yahooapis.im.v201812.bulk.UploadBulkJobStatus;
import jp.yahooapis.im.v201812.bulk.UploadUrlValue;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.ws.Holder;


/**
 * Sample Program for Bulk Upload.<br>
 * Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class BulkUploadSample {

  /**
   * main method for BulkUploadSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {

    try {

      long accountId = SoapUtils.getAccountId();

      // -----------------------------------------------
      // BulkService::getUploadUrl
      // -----------------------------------------------
      // call API
      UploadUrlValue uploadUrlValue = getUploadUrl(accountId);

      // -----------------------------------------------
      // BulkService::upload
      // -----------------------------------------------
      // call API
      long uploadJobId = upload(uploadUrlValue.getUploadUrl());

      // -----------------------------------------------
      // BulkService::getBulkUploadStatus
      // -----------------------------------------------
      // request
      BulkUploadStatusSelector bulkUploadStatusSelector = new BulkUploadStatusSelector();
      bulkUploadStatusSelector.setAccountId(accountId);
      bulkUploadStatusSelector.getUploadBulkJobIds().add(uploadJobId);
      Paging paging = new Paging();
      paging.setStartIndex(1);
      paging.setNumberResults(20);
      bulkUploadStatusSelector.setPaging(paging);

      // call API
      List<BulkUploadValues> getBulkUploadStatusResponse = getBulkUploadStatus(bulkUploadStatusSelector);


      // =================================================================
      // download bulk
      // =================================================================
      // execute
      downloadBulk(getBulkUploadStatusResponse.get(0));


    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Sample Program for BulkUploadService Upload.
   *
   * @param uploadUrl String
   * @return uploadJobId long
   */
  public static long upload(String uploadUrl) throws Exception {

    // file upload
    System.out.println("############################################");
    System.out.println("BulkService::upload");
    System.out.println("############################################");
    String response = SoapUtils.upload(uploadUrl, "SampleBulkUpload.csv", "text/csv");

    // get upload bulk job ID
    long uploadJobId = -1;
    Document responseDOM = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response)));
    NodeList nodeList = responseDOM.getElementsByTagName("uploadBulkJobId");
    if (nodeList.getLength() > 0) {
      uploadJobId = Long.parseLong(nodeList.item(0).getFirstChild().getNodeValue());
    } else {
      throw new RuntimeException("Fail to upload to Bulk. response=" + response);
    }

    // return
    return uploadJobId;
  }

  /**
   * Sample Program for BulkUploadService GetUploadUrl.
   *
   * @param accountId long
   * @return UploadUrlValue
   */
  public static UploadUrlValue getUploadUrl(long accountId) throws Exception {

    // =================================================================
    // BulkService
    // =================================================================
    BulkServiceInterface bulkService = SoapUtils.createServiceInterface(BulkServiceInterface.class, BulkServiceService.class);

    // -----------------------------------------------
    // BulkService::getUploadUrl
    // -----------------------------------------------
    // call API
    System.out.println("############################################");
    System.out.println("BulkService::getUploadUrl");
    System.out.println("############################################");

    Holder<UploadUrlValue> getUploadUrlValueHolder = new Holder<UploadUrlValue>();
    Holder<List<Error>> getUploadUrlErrorHolder = new Holder<List<Error>>();
    bulkService.getUploadUrl(accountId, "bulk-sample-name", getUploadUrlValueHolder, getUploadUrlErrorHolder);

    // if error
    if (getUploadUrlErrorHolder.value != null && getUploadUrlErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(getUploadUrlErrorHolder.value), true);
    }

    // response
    if (getUploadUrlValueHolder.value != null) {
      UploadUrlValue uploadUrlValue = getUploadUrlValueHolder.value;
      displayGetUploadUrlResponse(uploadUrlValue);
      if (!uploadUrlValue.isAcceptableUploadStatus()) {
        System.out.println("AcceptableUploadStatus is false at this accountId. Please wait a minute.");
        System.exit(0);
      }
    }

    return getUploadUrlValueHolder.value;
  }

  /**
   * Sample Program for BulkUploadService GetBulkUploadStatus.
   *
   * @param selector BulkUploadStatusSelector
   * @return BulkUploadValues
   */
  public static List<BulkUploadValues> getBulkUploadStatus(BulkUploadStatusSelector selector) throws Exception {

    // =================================================================
    // BulkService
    // =================================================================
    BulkServiceInterface bulkService = SoapUtils.createServiceInterface(BulkServiceInterface.class, BulkServiceService.class);


    // call 30sec sleep * 30 = 15minute
    Holder<BulkUploadStatusPage> getBulkUploadStatusPageHolder = null;
    Holder<List<Error>> getBulkUploadStatusErrorHolder = null;

    UploadBulkJobStatus jobStatus = null;

    for (int wait_count = 0; wait_count < 30; wait_count++) {
      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds for Bulk Upload Job *****\n");
      Thread.sleep(30000);

      // call API
      System.out.println("############################################");
      System.out.println("BulkService::getBulkUploadStatus");
      System.out.println("############################################");
      getBulkUploadStatusPageHolder = new Holder<BulkUploadStatusPage>();
      getBulkUploadStatusErrorHolder = new Holder<List<Error>>();
      bulkService.getBulkUploadStatus(selector, getBulkUploadStatusPageHolder, getBulkUploadStatusErrorHolder);

      // if error
      if (getBulkUploadStatusErrorHolder.value != null && getBulkUploadStatusErrorHolder.value.size() > 0) {
        SoapUtils.displayErrors(new ErrorEntityFactoryImpl(getBulkUploadStatusErrorHolder.value), true);
      }

      // response
      if (getBulkUploadStatusPageHolder.value != null) {
        BulkUploadStatusPage page = getBulkUploadStatusPageHolder.value;
        if (page.getValues() != null && page.getValues().size() > 0) {
          List<BulkUploadValues> values = page.getValues();
          for (int i = 0; i < values.size(); i++) {
            if (values.get(i).isOperationSucceeded()) {
              UploadBulkJob uploadBulkJob = values.get(i).getUploadBulkJob();
              jobStatus = uploadBulkJob.getUploadBulkJobStatus();
              display(uploadBulkJob);

              if (uploadBulkJob.getDownloadBulkUploadFileUrl() != null) {
                System.out.println("downloadBulkUploadFileUrl = " + uploadBulkJob.getDownloadBulkUploadFileUrl());
              }
            } else {
              SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
            }
          }
        }
      }

      if (jobStatus.equals(UploadBulkJobStatus.COMPLETED)) {
        break;
      } else {
        if (jobStatus.equals(UploadBulkJobStatus.IN_PROGRESS)) {
          continue;
        } else {
          System.out.println("\nError : Job Status failed.");
          System.exit(0);
        }
      }
    }

    // Response
    return getBulkUploadStatusPageHolder.value.getValues();
  }

  /**
   * download bulk.
   *
   * @param getBulkUploadStatusResponse BulkUploadValues
   */
  public static void downloadBulk(BulkUploadValues getBulkUploadStatusResponse) throws Exception {

    // check status
    if (getBulkUploadStatusResponse.getUploadBulkJob().getUploadBulkJobStatus() != null) {

      // -----------------------------------------------
      // BulkService::downloadBulkUploadFile
      // -----------------------------------------------
      if (getBulkUploadStatusResponse.getUploadBulkJob().getDownloadBulkUploadFileUrl() != null) {
        System.out.println("\n############################################");
        System.out.println("BulkService::downloadBulkUploadFile");
        System.out.println("############################################");
        SoapUtils.download(getBulkUploadStatusResponse.getUploadBulkJob().getDownloadBulkUploadFileUrl(), "SampleBulkUploadFile.csv");
      }

    } else {
      System.out.println("BulkUpload job in process on long time. please wait.");
    }
  }

  /**
   * display uploadUrlValue entity to stdout.
   *
   * @param uploadUrlValue UploadUrlValue entity for display.
   */
  private static void displayGetUploadUrlResponse(UploadUrlValue uploadUrlValue) {
    System.out.println("accountId = " + uploadUrlValue.getAccountId());
    System.out.println("uploadUrl = " + uploadUrlValue.getUploadUrl());
    System.out.println("acceptableUploadStatus = " + uploadUrlValue.isAcceptableUploadStatus());
    if (!uploadUrlValue.isAcceptableUploadStatus()) {
      System.out.println("AcceptableUploadStatus is false at this accountId. Please wait a minute.");
      System.exit(0);
    }
    System.out.println("----------");
  }

  /**
   * display uploadBulkJob entity to stdout.
   *
   * @param uploadBulkJob UploadBulkJob entity for display.
   */
  private static void display(UploadBulkJob uploadBulkJob) {
    System.out.println("----------");
    System.out.println("accountId = " + uploadBulkJob.getAccountId());
    System.out.println("uploadBulkJobId = " + uploadBulkJob.getUploadBulkJobId());
    System.out.println("uploadBulkJobName = " + uploadBulkJob.getUploadBulkJobName());
    System.out.println("uploadBulkUserName = " + uploadBulkJob.getUploadBulkUserName());
    System.out.println("uploadBulkStartDate = " + uploadBulkJob.getUploadBulkStartDate());
    System.out.println("uploadBulkEndDate = " + uploadBulkJob.getUploadBulkEndDate());
    System.out.println("uploadBulkJobStatus = " + uploadBulkJob.getUploadBulkJobStatus().toString());
    System.out.println("progress = " + uploadBulkJob.getProgress());
    if (uploadBulkJob.getProcessingItemsCount() != null) {
      System.out.println("processingItemsCount/campaignCount = " + uploadBulkJob.getProcessingItemsCount().getCampaignCount());
      System.out.println("processingItemsCount/campaignErrorCount = " + uploadBulkJob.getProcessingItemsCount().getCampaignErrorCount());
      System.out.println("processingItemsCount/adGroupCount = " + uploadBulkJob.getProcessingItemsCount().getAdGroupCount());
      System.out.println("processingItemsCount/adGroupErrorCount = " + uploadBulkJob.getProcessingItemsCount().getAdGroupErrorCount());
      System.out.println("processingItemsCount/adGroupAdCount = " + uploadBulkJob.getProcessingItemsCount().getAdGroupAdCount());
      System.out.println("processingItemsCount/adGroupAdErrorCount = " + uploadBulkJob.getProcessingItemsCount().getAdGroupAdErrorCount());
      System.out.println("processingItemsCount/adGroupTargetCount = " + uploadBulkJob.getProcessingItemsCount().getAdGroupTargetCount());
      System.out.println("processingItemsCount/adGroupTargetErrorCount = " + uploadBulkJob.getProcessingItemsCount().getAdGroupTargetErrorCount());
      System.out.println("processingItemsCount/mediaCount = " + uploadBulkJob.getProcessingItemsCount().getMediaCount());
      System.out.println("processingItemsCount/mediaErrorCount = " + uploadBulkJob.getProcessingItemsCount().getMediaErrorCount());
      System.out.println("processingItemsCount/videoCount = " + uploadBulkJob.getProcessingItemsCount().getVideoCount());
      System.out.println("processingItemsCount/videoErrorCount = " + uploadBulkJob.getProcessingItemsCount().getVideoErrorCount());
    }
    if (uploadBulkJob.getDownloadBulkUploadFileUrl() != null) {
      System.out.println("downloadBulkUploadFileUrl = " + uploadBulkJob.getDownloadBulkUploadFileUrl());
    }
    System.out.println("----------");
  }
}
