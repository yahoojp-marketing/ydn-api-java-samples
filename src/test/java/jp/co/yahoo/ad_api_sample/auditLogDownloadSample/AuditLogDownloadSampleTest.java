package jp.co.yahoo.ad_api_sample.auditLogDownloadSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.V5.AuditLogService.AuditLogDateRange;
import jp.yahooapis.im.V5.AuditLogService.AuditLogDownloadSelector;
import jp.yahooapis.im.V5.AuditLogService.AuditLogDownloadStatusSelector;
import jp.yahooapis.im.V5.AuditLogService.AuditLogDownloadValues;
import jp.yahooapis.im.V5.AuditLogService.AuditLogUpdateSource;

/**
 * Sample TestCase for AuditLogDownloadSampleTest.<br>
 * Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class AuditLogDownloadSampleTest {

  /**
   * Setting
   */
  private long accountId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
  }

  /**
   * Sample TestCase of main method for AuditLogDownloadSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      AuditLogDownloadSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of getAuditLogDownload method for AuditLogDownloadSample.
   */
  @Test
  public void testGetAuditLogDownload() throws Exception {
    // Set Selector
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


    // Run
    List<AuditLogDownloadValues> getAuditLogDownloadResponse = null;
    try {
      getAuditLogDownloadResponse = AuditLogDownloadSample.getAuditLogDownload(auditLogDownloadSelector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AuditLogDownloadValues AuditLogDownloadValues : getAuditLogDownloadResponse) {
      assertThat(AuditLogDownloadValues.isOperationSucceeded(), is(true));
      assertThat(AuditLogDownloadValues.getAuditLogJob().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of getAuditLogDownloadStatus method for AuditLogDownloadSample.
   */
  @Test
  public void testGetAuditLogDownloadStatus() throws Exception {
    // =================================================================
    // AuditLogService::getAuditLogDownload
    // =================================================================
    // Set Selector
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

    // Run
    List<AuditLogDownloadValues> getAuditLogDownloadResponse = null;
    try {
      getAuditLogDownloadResponse = AuditLogDownloadSample.getAuditLogDownload(auditLogDownloadSelector);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // AuditLogService::getAuditLogDownloadStatus
    // =================================================================
    // Set Selector
    AuditLogDownloadStatusSelector auditLogDownloadStatusSelector = new AuditLogDownloadStatusSelector();
    auditLogDownloadStatusSelector.setAccountId(accountId);
    auditLogDownloadStatusSelector.getAuditLogJobIds().add(Long.valueOf(getAuditLogDownloadResponse.get(0).getAuditLogJob().getAuditLogJobId()));

    // Run
    List<AuditLogDownloadValues> getAuditLogDownloadStatusResponse = null;
    try {
      getAuditLogDownloadStatusResponse = AuditLogDownloadSample.getAuditLogDownloadStatus(auditLogDownloadStatusSelector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AuditLogDownloadValues AuditLogDownloadValues : getAuditLogDownloadStatusResponse) {
      assertThat(AuditLogDownloadValues.isOperationSucceeded(), is(true));
      assertThat(AuditLogDownloadValues.getAuditLogJob().getAccountId(), is(notNullValue()));
    }
  }
}
