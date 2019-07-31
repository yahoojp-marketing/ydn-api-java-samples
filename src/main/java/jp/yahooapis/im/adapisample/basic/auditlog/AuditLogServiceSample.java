/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.auditlog;

import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.v201907.Error;
import jp.yahooapis.im.v201907.auditlog.AuditLogDateRange;
import jp.yahooapis.im.v201907.auditlog.AuditLogDownloadJobStatus;
import jp.yahooapis.im.v201907.auditlog.AuditLogDownloadReturnValue;
import jp.yahooapis.im.v201907.auditlog.AuditLogDownloadSelector;
import jp.yahooapis.im.v201907.auditlog.AuditLogDownloadStatusPage;
import jp.yahooapis.im.v201907.auditlog.AuditLogDownloadStatusSelector;
import jp.yahooapis.im.v201907.auditlog.AuditLogDownloadValues;
import jp.yahooapis.im.v201907.auditlog.AuditLogJob;
import jp.yahooapis.im.v201907.auditlog.AuditLogLang;
import jp.yahooapis.im.v201907.auditlog.AuditLogService;
import jp.yahooapis.im.v201907.auditlog.AuditLogServiceInterface;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example AuditLogService operation and Utility method collection.
 */
public class AuditLogServiceSample {

  /**
   * example AuditLogService operation.
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
      // AuditLogService getDownload
      // =================================================================
      // create request.
      AuditLogDownloadSelector getDownloadRequest = buildExampleGetDownloadRequest(accountId);

      // run
      List<AuditLogDownloadValues> getDownloadResponse = getDownload(getDownloadRequest);

      Long jobId = null;
      for (AuditLogDownloadValues auditLogDownloadValues : getDownloadResponse) {
        jobId = auditLogDownloadValues.getAuditLogJob().getAuditLogJobId();
      }

      // =================================================================
      // AuditLogService getDownloadStatus
      // =================================================================
      // check job status
      checkStatus(Collections.singletonList(jobId));

      // create request.
      AuditLogDownloadStatusSelector getDownloadStatusRequest = buildExampleGetDownloadStatusRequest(accountId, Collections.singletonList(jobId));

      // run
      List<AuditLogDownloadValues> getDownloadStatusResponse = getDownloadStatus(getDownloadStatusRequest);

      String downloadUrl = null;
      for (AuditLogDownloadValues auditLogDownloadValues : getDownloadStatusResponse) {
        downloadUrl = auditLogDownloadValues.getAuditLogJob().getDownloadAuditLogDownloadUrl();
      }

      // =================================================================
      // AuditLogService download (http request)
      // =================================================================
      SoapUtils.download(downloadUrl, "auditLogDownloadSample.csv");

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example getDownload request.
   *
   * @param accountId long
   * @return AuditLogDownloadSelector
   */
  public static AuditLogDownloadSelector buildExampleGetDownloadRequest(long accountId) {
    AuditLogDownloadSelector selector = new AuditLogDownloadSelector();
    selector.setAccountId(accountId);
    selector.setLang(AuditLogLang.EN);

    AuditLogDateRange auditLogDateRange = new AuditLogDateRange();

    // It specifies the current month
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    Calendar cal = new GregorianCalendar();
    Date now = cal.getTime();
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    int date = 1;
    cal.set(year, month, date, 0, 0, 0);

    auditLogDateRange.setStartDate(format.format(cal.getTime()));
    auditLogDateRange.setEndDate(format.format(now));
    selector.setDateRange(auditLogDateRange);

    AuditLogJob auditLogJob = new AuditLogJob();
    auditLogJob.setAuditLogJobName("sample_job_name");
    selector.setAuditLogJob(auditLogJob);

    return selector;
  }

  /**
   * example getDownloadStatus request.
   *
   * @param accountId      long
   * @param auditLogJobIds List<Long>
   * @return AuditLogDownloadStatusSelector
   */
  public static AuditLogDownloadStatusSelector buildExampleGetDownloadStatusRequest(long accountId, List<Long> auditLogJobIds) {
    AuditLogDownloadStatusSelector selector = new AuditLogDownloadStatusSelector();
    selector.setAccountId(accountId);
    selector.getAuditLogJobIds().addAll(auditLogJobIds);
    return selector;
  }

  /**
   * example check AuditLog job status.
   *
   * @param jobIds List<Long>
   */
  public static void checkStatus(List<Long> jobIds) throws Exception {

    // call 30sec sleep * 30 = 15minute
    for (int i = 0; i < 30; i++) {

      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds for AuditLog Download Job *****\n");
      Thread.sleep(30000);

      // get
      AuditLogDownloadStatusSelector getRequest = buildExampleGetDownloadStatusRequest(SoapUtils.getAccountId(), jobIds);
      List<AuditLogDownloadValues> getResponse = getDownloadStatus(getRequest);

      int completedCount = 0;

      // check status
      for (AuditLogDownloadValues auditLogDownloadValues : getResponse) {
        AuditLogDownloadJobStatus status = auditLogDownloadValues.getAuditLogJob().getAuditLogJobStatus();
        if (status == null) {
          throw new Exception("Fail to get AuditLog.");
        }
        switch (status) {
          default:
          case IN_PROGRESS:
            continue;
          case SYSTEM_ERROR:
            throw new Exception("AuditLog Job Status failed.");
          case COMPLETED:
            completedCount++;
            continue;
        }
      }

      if (getResponse.size() == completedCount) {
        return;
      }
    }

    throw new Exception("Fail to get AuditLog.");
  }

  /**
   * example getDownload request.
   *
   * @param selector AuditLogDownloadSelector
   * @return AuditLogDownloadValues
   */
  public static List<AuditLogDownloadValues> getDownload(AuditLogDownloadSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("AuditLogService::getDownload");
    System.out.println("############################################");

    Holder<AuditLogDownloadReturnValue> auditLogDownloadReturnValueHolder = new Holder<AuditLogDownloadReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AuditLogServiceInterface auditLogService = SoapUtils.createServiceInterface(AuditLogServiceInterface.class, AuditLogService.class);

    auditLogService.getDownload(selector, auditLogDownloadReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, auditLogDownloadReturnValueHolder.value.getValues());

    // Response
    return auditLogDownloadReturnValueHolder.value.getValues();
  }

  /**
   * example getDownloadStatus request.
   *
   * @param selector AuditLogDownloadStatusSelector
   * @return AuditLogDownloadValues
   */
  public static List<AuditLogDownloadValues> getDownloadStatus(AuditLogDownloadStatusSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("AuditLogService::getDownloadStatus");
    System.out.println("############################################");

    Holder<AuditLogDownloadStatusPage> auditLogDownloadStatusPageHolder = new Holder<AuditLogDownloadStatusPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AuditLogServiceInterface auditLogService = SoapUtils.createServiceInterface(AuditLogServiceInterface.class, AuditLogService.class);
    auditLogService.getDownloadStatus(selector, auditLogDownloadStatusPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, auditLogDownloadStatusPageHolder.value.getValues());

    // Response
    return auditLogDownloadStatusPageHolder.value.getValues();
  }
}
