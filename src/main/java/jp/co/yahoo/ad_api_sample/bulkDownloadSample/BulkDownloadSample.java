package jp.co.yahoo.ad_api_sample.bulkDownloadSample;

import jp.co.yahoo.ad_api_sample.error.impl.BulkServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.V6.BulkService.ApprovalStatus;
import jp.yahooapis.im.V6.BulkService.BulkDownloadReturnValue;
import jp.yahooapis.im.V6.BulkService.BulkDownloadSelector;
import jp.yahooapis.im.V6.BulkService.BulkDownloadStatusPage;
import jp.yahooapis.im.V6.BulkService.BulkDownloadStatusSelector;
import jp.yahooapis.im.V6.BulkService.BulkDownloadType;
import jp.yahooapis.im.V6.BulkService.BulkDownloadValues;
import jp.yahooapis.im.V6.BulkService.BulkEncoding;
import jp.yahooapis.im.V6.BulkService.BulkLang;
import jp.yahooapis.im.V6.BulkService.BulkOutput;
import jp.yahooapis.im.V6.BulkService.BulkServiceInterface;
import jp.yahooapis.im.V6.BulkService.BulkServiceService;
import jp.yahooapis.im.V6.BulkService.DownloadBulkJob;
import jp.yahooapis.im.V6.BulkService.DownloadBulkJobStatus;
import jp.yahooapis.im.V6.BulkService.EntityType;
import jp.yahooapis.im.V6.BulkService.Error;
import jp.yahooapis.im.V6.BulkService.MediaApprovalStatus;
import jp.yahooapis.im.V6.BulkService.UserStatus;

import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for Bulk Download.<br>
 * Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class BulkDownloadSample {

  /**
   * main method for BulkDownloadSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {

    try {

      long accountId = SoapUtils.getAccountId();

      // -----------------------------------------------
      // BulkService::getBulkDownload
      // -----------------------------------------------
      // request
      BulkDownloadSelector bulkDownloadSelector = new BulkDownloadSelector();
      bulkDownloadSelector.setAccountId(accountId);
      bulkDownloadSelector.getCampaignUserStatuses().add(UserStatus.ACTIVE);
      bulkDownloadSelector.getAdGroupUserStatuses().add(UserStatus.ACTIVE);
      bulkDownloadSelector.getAdGroupAdUserStatuses().add(UserStatus.ACTIVE);
      bulkDownloadSelector.getMediaUserStatuses().add(UserStatus.ACTIVE);
      bulkDownloadSelector.getAdGroupAdApprovalStatuses().add(ApprovalStatus.APPROVED);
      bulkDownloadSelector.getMediaApprovalStatuses().add(MediaApprovalStatus.APPROVED);
      bulkDownloadSelector.setEntityTypes(EntityType.ALL);
      bulkDownloadSelector.setDownloadType(BulkDownloadType.CAMPAIGN);
      bulkDownloadSelector.setLang(BulkLang.JA);
      bulkDownloadSelector.setEncoding(BulkEncoding.SJIS);
      bulkDownloadSelector.setOutput(BulkOutput.CSV);

      // call API
      List<BulkDownloadValues> getBulkDownloadResponse = getBulkDownload(bulkDownloadSelector);

      // -----------------------------------------------
      // BulkService::getBulkDownloadStatus
      // -----------------------------------------------
      // request
      BulkDownloadStatusSelector bulkDownloadStatusSelector = new BulkDownloadStatusSelector();
      bulkDownloadStatusSelector.setAccountId(accountId);
      bulkDownloadStatusSelector.getDownloadBulkJobIds().add(Long.valueOf(getBulkDownloadResponse.get(0).getDownloadBulkJob().getDownloadBulkJobId()));

      // call API
      List<BulkDownloadValues> getBulkDownloadStatusResponse = getBulkDownloadStatus(bulkDownloadStatusSelector);

      // =================================================================
      // download bulk
      // =================================================================
      // filename
      String bulkDownloadFileName = null;
      if (bulkDownloadSelector.getOutput().equals(BulkOutput.ZIPPED_CSV)) {
        bulkDownloadFileName = "BulkDownload_" + "_" + bulkDownloadSelector.getDownloadType() + "_" + getBulkDownloadResponse.get(0).getDownloadBulkJob().getDownloadBulkJobId() + ".zip";
      } else {
        bulkDownloadFileName = "BulkDownload_" + "_" + bulkDownloadSelector.getDownloadType() + "_" + getBulkDownloadResponse.get(0).getDownloadBulkJob().getDownloadBulkJobId() + ".csv";
      }

      // execute
      downloadBulk(getBulkDownloadStatusResponse.get(0), bulkDownloadFileName);


    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * download bulk.
   *
   * @param getBulkDownloadStatusResponse BulkDownloadValues
   * @param bulkDownloadFileName          String
   */
  public static void downloadBulk(BulkDownloadValues getBulkDownloadStatusResponse, String bulkDownloadFileName) throws Exception {

    // check status
    if (getBulkDownloadStatusResponse.getDownloadBulkJob().getDownloadJobStatus() != null && bulkDownloadFileName != null) {
      SoapUtils.download(getBulkDownloadStatusResponse.getDownloadBulkJob().getDownloadBulkDownloadUrl(), bulkDownloadFileName);
    } else {
      System.out.println("BulkDownload job in process on long time. please wait.");
    }
  }

  /**
   * Sample Program for BulkDownloadService GetBulkDownload.
   *
   * @param selector BulkDownloadSelector
   * @return BulkDownloadValues
   */
  public static List<BulkDownloadValues> getBulkDownload(BulkDownloadSelector selector) throws Exception {

    // =================================================================
    // BulkService
    // =================================================================
    BulkServiceInterface bulkService = SoapUtils.createServiceInterface(BulkServiceInterface.class, BulkServiceService.class);

    // call API
    System.out.println("############################################");
    System.out.println("BulkService::getBulkDownload");
    System.out.println("############################################");

    Holder<BulkDownloadReturnValue> bulkDownloadReturnValueHolder = new Holder<BulkDownloadReturnValue>();
    Holder<List<Error>> bulkDownloadError = new Holder<List<Error>>();
    bulkService.getBulkDownload(selector, bulkDownloadReturnValueHolder, bulkDownloadError);

    // Error
    if (bulkDownloadError.value != null && bulkDownloadError.value.size() > 0) {
      SoapUtils.displayErrors(new BulkServiceErrorEntityFactory(bulkDownloadError.value), true);
    }
    if (bulkDownloadError.value == null) {
      throw new Exception("NoDataResponse:BulkDownloadService GetBulkDownload");
    }

    // Display
    for (BulkDownloadValues bulkDownloadValues : bulkDownloadReturnValueHolder.value.getValues()) {
      if (bulkDownloadValues.isOperationSucceeded()) {
        display(bulkDownloadValues.getDownloadBulkJob());
      } else {
        SoapUtils.displayErrors(new BulkServiceErrorEntityFactory(bulkDownloadError.value), true);
      }
    }

    // Response
    return bulkDownloadReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for BulkDownloadService GetBulkDownloadStatus.
   *
   * @param selector BulkDownloadStatusSelector
   * @return BulkDownloadValues
   */
  public static List<BulkDownloadValues> getBulkDownloadStatus(BulkDownloadStatusSelector selector) throws Exception {

    // =================================================================
    // BulkService
    // =================================================================
    BulkServiceInterface bulkService = SoapUtils.createServiceInterface(BulkServiceInterface.class, BulkServiceService.class);

    // call 30sec sleep * 30 = 15minute
    Holder<BulkDownloadStatusPage> bulkDownloadStatusPageHolder = null;
    DownloadBulkJobStatus jobStatus = null;
    for (int i = 0; i < 30; i++) {
      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds for Bulk Download Job *****\n");
      Thread.sleep(30000);
      // call API
      System.out.println("############################################");
      System.out.println("BulkService::getBulkDownloadStatus");
      System.out.println("############################################");
      bulkDownloadStatusPageHolder = new Holder<BulkDownloadStatusPage>();
      Holder<List<Error>> bulkDownloadStatusError = new Holder<List<Error>>();
      bulkService.getBulkDownloadStatus(selector, bulkDownloadStatusPageHolder, bulkDownloadStatusError);

      // if error
      if (bulkDownloadStatusError.value != null && bulkDownloadStatusError.value.size() > 0) {
        SoapUtils.displayErrors(new BulkServiceErrorEntityFactory(bulkDownloadStatusError.value), true);
      }

      // response
      List<BulkDownloadValues> bulkDownloadStatusValues = bulkDownloadStatusPageHolder.value.getValues();
      if (bulkDownloadStatusValues.get(0).isOperationSucceeded()) {
        DownloadBulkJob downloadBulkJob = bulkDownloadStatusValues.get(0).getDownloadBulkJob();

        // status
        jobStatus = downloadBulkJob.getDownloadJobStatus();
        // display response
        display(downloadBulkJob);

        if (jobStatus.equals(DownloadBulkJobStatus.COMPLETED)) {
          break;
        } else {
          if (jobStatus.equals(DownloadBulkJobStatus.IN_PROGRESS)) {
            continue;
          } else {
            System.out.println("Error : Job Status failed.");
            System.exit(0);
          }
        }

      } else {
        SoapUtils.displayErrors(new BulkServiceErrorEntityFactory(bulkDownloadStatusValues.get(0).getError()), true);
      }
    }

    // Response
    return bulkDownloadStatusPageHolder.value.getValues();
  }

  /**
   * display downloadBulkJob entity to stdout.
   *
   * @param downloadBulkJob DownloadBulkJob entity for display.
   */
  private static void display(DownloadBulkJob downloadBulkJob) {
    System.out.println("accountId = " + downloadBulkJob.getAccountId());
    System.out.println("downloadBulkJobId = " + downloadBulkJob.getDownloadBulkJobId());
    System.out.println("downloadBulkJobName = " + downloadBulkJob.getDownloadBulkJobName());
    System.out.println("downloadBulkUserName = " + downloadBulkJob.getDownloadBulkUserName());
    System.out.println("downloadBulkStartDate = " + downloadBulkJob.getDownloadBulkStartDate());
    System.out.println("downloadJobStatus = " + downloadBulkJob.getDownloadJobStatus());
    System.out.println("progress = " + downloadBulkJob.getProgress());
    System.out.println("---------");
  }
}
