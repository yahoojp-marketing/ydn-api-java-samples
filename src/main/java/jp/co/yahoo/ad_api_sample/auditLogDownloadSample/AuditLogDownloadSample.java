package jp.co.yahoo.ad_api_sample.auditLogDownloadSample;

import jp.co.yahoo.ad_api_sample.error.impl.AuditLogServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.V6.AuditLogService.AuditLogDateRange;
import jp.yahooapis.im.V6.AuditLogService.AuditLogDownloadJobStatus;
import jp.yahooapis.im.V6.AuditLogService.AuditLogDownloadReturnValue;
import jp.yahooapis.im.V6.AuditLogService.AuditLogDownloadSelector;
import jp.yahooapis.im.V6.AuditLogService.AuditLogDownloadStatusPage;
import jp.yahooapis.im.V6.AuditLogService.AuditLogDownloadStatusSelector;
import jp.yahooapis.im.V6.AuditLogService.AuditLogDownloadValues;
import jp.yahooapis.im.V6.AuditLogService.AuditLogJob;
import jp.yahooapis.im.V6.AuditLogService.AuditLogServiceInterface;
import jp.yahooapis.im.V6.AuditLogService.AuditLogServiceService;
import jp.yahooapis.im.V6.AuditLogService.AuditLogUpdateSource;
import jp.yahooapis.im.V6.AuditLogService.Error;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for AuditLog Download.<br>
 * Copyright (C) 2016 Yahoo Japan Corporation. All Rights Reserved.
 */
public class AuditLogDownloadSample {

  /**
   * main method for AuditLogDownloadSample
   * 
   * @param args command line arguments
   */
  public static void main(String[] args) {

    try {

      long accountId = SoapUtils.getAccountId();


      // -----------------------------------------------
      // AuditLogService::getAuditLogDownload
      // -----------------------------------------------
      // request
      AuditLogDateRange dateRange = new AuditLogDateRange();
      // It specifies the current month
      SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
      Calendar cal = new GregorianCalendar();
      Date now = cal.getTime();
      int year = cal.get(Calendar.YEAR);
      int month = cal.get(Calendar.MONTH);
      int date = 1;
      cal.set(year, month, date, 0, 0, 0);

      dateRange.setStartDate(format.format(cal.getTime()));
      dateRange.setEndDate(format.format(now));

      AuditLogDownloadSelector auditLogDownloadSelector = new AuditLogDownloadSelector();
      auditLogDownloadSelector.setAccountId(accountId);
      auditLogDownloadSelector.setDateRange(dateRange);;
      auditLogDownloadSelector.getUpdateSources().add(AuditLogUpdateSource.API);
      auditLogDownloadSelector.getUpdateSources().add(AuditLogUpdateSource.CAMPAIGN_MANAGEMENT_TOOL);

      // call API
      List<AuditLogDownloadValues> getAuditLogDownloadResponse = getAuditLogDownload(auditLogDownloadSelector);

      // -----------------------------------------------
      // AuditLogService::getAuditLogDownloadStatus
      // -----------------------------------------------
      // request
      AuditLogDownloadStatusSelector auditLogDownloadStatusSelector = new AuditLogDownloadStatusSelector();
      auditLogDownloadStatusSelector.setAccountId(accountId);
      auditLogDownloadStatusSelector.getAuditLogJobIds().add(Long.valueOf(getAuditLogDownloadResponse.get(0).getAuditLogJob().getAuditLogJobId()));

      // call API
      List<AuditLogDownloadValues> getAuditLogDownloadStatusResponse = getAuditLogDownloadStatus(auditLogDownloadStatusSelector);

      // =================================================================
      // download auditLog
      // =================================================================
      // filename
      String auditLogDownloadFileName = null;
      auditLogDownloadFileName = "AuditLogDownload_" + getAuditLogDownloadResponse.get(0).getAuditLogJob().getAuditLogJobId() + ".csv";

      // execute
      downloadAuditLog(getAuditLogDownloadStatusResponse.get(0), auditLogDownloadFileName);


    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * download auditLog.
   * 
   * @param getAuditLogDownloadStatusResponse AuditLogDownloadValues
   * @param auditLogDownloadFileName String
   * @throws Exception
   */
  public static void downloadAuditLog(AuditLogDownloadValues getAuditLogDownloadStatusResponse, String auditLogDownloadFileName) throws Exception {

    // check status
    if (getAuditLogDownloadStatusResponse.getAuditLogJob().getAuditLogJobStatus() != null && auditLogDownloadFileName != null) {
      SoapUtils.download(getAuditLogDownloadStatusResponse.getAuditLogJob().getDownloadAuditLogDownloadUrl(), auditLogDownloadFileName);
    } else {
      System.out.println("AuditLogDownload job in process on long time. please wait.");
    }
  }

  /**
   * Sample Program for AuditLogDownloadService GetAuditLogDownload.
   * 
   * @param selector AuditLogDownloadSelector
   * @return AuditLogDownloadValues
   * @throws Exception
   */
  public static List<AuditLogDownloadValues> getAuditLogDownload(AuditLogDownloadSelector selector) throws Exception {

    // =================================================================
    // AuditLogService
    // =================================================================
    AuditLogServiceInterface auditLogService = SoapUtils.createServiceInterface(AuditLogServiceInterface.class, AuditLogServiceService.class);

    // call API
    System.out.println("############################################");
    System.out.println("AuditLogService::getDownload");
    System.out.println("############################################");

    Holder<AuditLogDownloadReturnValue> auditLogDownloadReturnValueHolder = new Holder<AuditLogDownloadReturnValue>();
    Holder<List<Error>> auditLogDownloadError = new Holder<List<Error>>();
    auditLogService.getDownload(selector, auditLogDownloadReturnValueHolder, auditLogDownloadError);

    // Error
    if (auditLogDownloadError.value != null && auditLogDownloadError.value.size() > 0) {
      SoapUtils.displayErrors(new AuditLogServiceErrorEntityFactory(auditLogDownloadError.value), true);
    }
    if (auditLogDownloadError.value == null) {
      throw new Exception("NoDataResponse:AuditLogDownloadService GetAuditLogDownload");
    }

    // Display
    for (AuditLogDownloadValues auditLogDownloadValues : auditLogDownloadReturnValueHolder.value.getValues()) {
      if (auditLogDownloadValues.isOperationSucceeded()) {
        display(auditLogDownloadValues.getAuditLogJob());
      } else {
        SoapUtils.displayErrors(new AuditLogServiceErrorEntityFactory(auditLogDownloadError.value), true);
      }
    }

    // Response
    return auditLogDownloadReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AuditLogDownloadService GetAuditLogDownloadStatus.
   * 
   * @param selector AuditLogDownloadStatusSelector
   * @return AuditLogDownloadValues
   * @throws Exception
   */
  public static List<AuditLogDownloadValues> getAuditLogDownloadStatus(AuditLogDownloadStatusSelector selector) throws Exception {

    // =================================================================
    // AuditLogService
    // =================================================================
    AuditLogServiceInterface auditLogService = SoapUtils.createServiceInterface(AuditLogServiceInterface.class, AuditLogServiceService.class);

    // call 30sec sleep * 30 = 15minute
    Holder<AuditLogDownloadStatusPage> auditLogDownloadStatusPageHolder = null;
    AuditLogDownloadJobStatus jobStatus = null;
    for (int i = 0; i < 30; i++) {
      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds for AuditLog Download Job *****\n");
      Thread.sleep(30000);
      // call API
      System.out.println("############################################");
      System.out.println("AuditLogService::getAuditLogDownloadStatus");
      System.out.println("############################################");
      auditLogDownloadStatusPageHolder = new Holder<AuditLogDownloadStatusPage>();
      Holder<List<Error>> auditLogDownloadStatusError = new Holder<List<Error>>();
      auditLogService.getDownloadStatus(selector, auditLogDownloadStatusPageHolder, auditLogDownloadStatusError);

      // if error
      if (auditLogDownloadStatusError.value != null && auditLogDownloadStatusError.value.size() > 0) {
        SoapUtils.displayErrors(new AuditLogServiceErrorEntityFactory(auditLogDownloadStatusError.value), true);
      }

      // response
      List<AuditLogDownloadValues> auditLogDownloadStatusValues = auditLogDownloadStatusPageHolder.value.getValues();
      if (auditLogDownloadStatusValues.get(0).isOperationSucceeded()) {
        AuditLogJob auditLogJob = auditLogDownloadStatusValues.get(0).getAuditLogJob();

        // status
        jobStatus = auditLogJob.getAuditLogJobStatus();

        // display response
        display(auditLogJob);

        if (jobStatus.equals(AuditLogDownloadJobStatus.COMPLETED)) {
          break;
        } else {
          if (jobStatus.equals(AuditLogDownloadJobStatus.IN_PROGRESS)) {
            continue;
          } else {
            System.out.println("Error : Job Status failed.");
            System.exit(0);
          }
        }

      } else {
        SoapUtils.displayErrors(new AuditLogServiceErrorEntityFactory(auditLogDownloadStatusValues.get(0).getError()), true);
      }
    }

    // Response
    return auditLogDownloadStatusPageHolder.value.getValues();
  }

  /**
   * display AuditLogJob entity to stdout.
   *
   * @param auditLogJob AuditLogJob entity for display.
   */
  private static void display(AuditLogJob auditLogJob) {
    System.out.println("accountId = " + auditLogJob.getAccountId());
    System.out.println("auditLogJobId = " + auditLogJob.getAuditLogJobId());
    System.out.println("auditLogJobName = " + auditLogJob.getAuditLogJobName());
    System.out.println("auditLogJobUserName = " + auditLogJob.getAuditLogJobUserName());
    System.out.println("auditLogJobStartDate = " + auditLogJob.getAuditLogJobStartDate());
    System.out.println("auditLogJobEndDate = " + auditLogJob.getAuditLogJobEndDate());
    System.out.println("auditLogJobStatus = " + auditLogJob.getAuditLogJobStatus());
    System.out.println("progress = " + auditLogJob.getProgress());
    System.out.println("downloadAuditLogDownloadUrl = " + auditLogJob.getDownloadAuditLogDownloadUrl());

    System.out.println("---------");
  }

}
