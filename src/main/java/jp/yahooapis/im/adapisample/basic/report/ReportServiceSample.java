/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.report;

import jp.yahooapis.im.adapisample.basic.reportdefinition.ReportDefinitionServiceSample;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201903.Error;
import jp.yahooapis.im.v201903.report.Operator;
import jp.yahooapis.im.v201903.report.ReportClosedDateRecord;
import jp.yahooapis.im.v201903.report.ReportClosedDateSelector;
import jp.yahooapis.im.v201903.report.ReportClosedDateValue;
import jp.yahooapis.im.v201903.report.ReportJobOperation;
import jp.yahooapis.im.v201903.report.ReportJobStatus;
import jp.yahooapis.im.v201903.report.ReportPage;
import jp.yahooapis.im.v201903.report.ReportRecord;
import jp.yahooapis.im.v201903.report.ReportReturnValue;
import jp.yahooapis.im.v201903.report.ReportSelector;
import jp.yahooapis.im.v201903.report.ReportService;
import jp.yahooapis.im.v201903.report.ReportServiceInterface;
import jp.yahooapis.im.v201903.report.ReportValues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example ReportService operation and Utility method collection.
 */
public class ReportServiceSample {

  /**
   * example ReportService operation.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    // =================================================================
    // Setting
    // =================================================================
    ValuesHolder valuesHolder = setup();
    long accountId = SoapUtils.getAccountId();

    try {

      // =================================================================
      // check & create upper service object.
      // =================================================================
      valuesHolder = setup();
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      Long reportId = valuesRepositoryFacade.getReportDefinitionValuesRepository().getReportIds().get(0);

      // =================================================================
      // ReportService getClosedDate
      // =================================================================
      // create request.
      ReportClosedDateSelector getClosedDateRequest = buildExampleGetClosedDateRequest(accountId);

      // run
      getClosedDate(getClosedDateRequest);

      // =================================================================
      // ReportService ADD
      // =================================================================
      // create request.
      ReportJobOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, Collections.singletonList(createReportRecord(reportId)));

      // run
      List<ReportValues> addResponse = mutate(addRequest);

      List<ReportRecord> reportRecords = new ArrayList<>();
      List<Long> jobIds = new ArrayList<>();
      for (ReportValues reportValues : addResponse) {
        reportRecords.add(reportValues.getReportRecord());
        jobIds.add(reportValues.getReportRecord().getReportJobId());
      }

      // =================================================================
      // ReportService GET
      // =================================================================
      // check job status
      checkStatus(jobIds);

      // create request.
      ReportSelector getRequest = buildExampleGetRequest(accountId, jobIds);

      // run
      List<ReportValues> getResponse = get(getRequest);

      String downloadUrl = null;
      for (ReportValues reportValues : getResponse) {
        downloadUrl = reportValues.getReportRecord().getReportDownloadUrl();
      }

      // =================================================================
      // ReportService download (http request)
      // =================================================================
      SoapUtils.download(downloadUrl, "reportDownloadSample.csv");

      // =================================================================
      // ReportService REMOVE
      // =================================================================
      // create request.
      ReportJobOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, reportRecords);

      // run
      mutate(removeRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;

    } finally {
      // =================================================================
      // Cleanup
      // =================================================================
      ReportDefinitionServiceSample.cleanup(valuesHolder);
    }
  }

  /**
   * example get Reports.
   *
   * @param selector ReportSelector
   * @return ReportValues
   */
  public static List<ReportValues> get(ReportSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ReportService::get");
    System.out.println("############################################");

    Holder<ReportPage> reportPageHolder = new Holder<ReportPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    ReportServiceInterface reportService = SoapUtils.createServiceInterface(ReportServiceInterface.class, ReportService.class);
    reportService.get(selector, reportPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, reportPageHolder.value.getValues());

    // Response
    return reportPageHolder.value.getValues();
  }

  /**
   * example get Reports.
   *
   * @param selector ReportClosedDateSelector
   * @return ReportClosedDateRecord
   */
  public static List<ReportClosedDateRecord> getClosedDate(ReportClosedDateSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ReportService::getClosedDate");
    System.out.println("############################################");

    Holder<ReportClosedDateValue> reportClosedDateValueHolder = new Holder<ReportClosedDateValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    ReportServiceInterface reportService = SoapUtils.createServiceInterface(ReportServiceInterface.class, ReportService.class);
    reportService.getClosedDate(selector, reportClosedDateValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, reportClosedDateValueHolder.value.getValues());

    // Response
    return reportClosedDateValueHolder.value.getValues();
  }

  /**
   * example mutate Reports.
   *
   * @param operation ReportJobOperation
   * @return ReportValues
   */
  public static List<ReportValues> mutate(ReportJobOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ReportService::mutate(" + operation.getOperator().toString() + ")");
    System.out.println("############################################");

    Holder<ReportReturnValue> reportReturnValueHolder = new Holder<ReportReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    ReportServiceInterface reportService = SoapUtils.createServiceInterface(ReportServiceInterface.class, ReportService.class);
    reportService.mutate(operation, reportReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, reportReturnValueHolder.value.getValues());

    // Response
    return reportReturnValueHolder.value.getValues();
  }

  /**
   * example check Report job status.
   *
   * @param jobIds List<Long>
   */
  public static void checkStatus(List<Long> jobIds) throws Exception {

    // call 30sec sleep * 30 = 15minute
    for (int i = 0; i < 30; i++) {

      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds for Report Download Job *****\n");
      Thread.sleep(30000);

      // get
      ReportSelector getRequest = buildExampleGetRequest(SoapUtils.getAccountId(), jobIds);
      List<ReportValues> getResponse = get(getRequest);

      int completedCount = 0;

      // check status
      for (ReportValues reportValues : getResponse) {
        ReportJobStatus status = reportValues.getReportRecord().getStatus();
        if (status == null) {
          throw new Exception("Fail to get Report.");
        }
        switch (status) {
          default:
          case ACCEPTED:
          case IN_PROGRESS:
            continue;
          case CANCELED:
          case FAILED:
            throw new Exception("Report Job Status failed.");
          case COMPLETED:
            completedCount++;
            continue;
        }
      }

      if (getResponse.size() == completedCount) {
        return;
      }
    }

    throw new Exception("Fail to get Report.");
  }

  /**
   * example get request.
   *
   * @param accountId    long
   * @param reportJobIds List<Long>
   * @return ReportSelector
   */
  public static ReportSelector buildExampleGetRequest(long accountId, List<Long> reportJobIds) {
    ReportSelector selector = new ReportSelector();
    selector.setAccountId(accountId);
    selector.getReportJobIds().addAll(reportJobIds);
    return selector;
  }

  /**
   * example mutate request.
   *
   * @param operator  Operator
   * @param accountId long
   * @param operand   List<ReportRecord>
   * @return ReportJobOperation
   */
  public static ReportJobOperation buildExampleMutateRequest(Operator operator, long accountId, List<ReportRecord> operand) {
    ReportJobOperation operation = new ReportJobOperation();
    operation.setAccountId(accountId);
    operation.setOperator(operator);
    operation.getOperand().addAll(operand);
    return operation;
  }

  /**
   * example getClosedDate request.
   *
   * @param accountId long
   * @return ReportClosedDateSelector
   */
  public static ReportClosedDateSelector buildExampleGetClosedDateRequest(long accountId) {
    ReportClosedDateSelector selector = new ReportClosedDateSelector();
    selector.setAccountId(accountId);
    return selector;
  }

  /**
   * example ReportRecord request.
   *
   * @param reportId long
   * @return ReportRecord
   */
  public static ReportRecord createReportRecord(long reportId)
  {
    ReportRecord operand = new ReportRecord();
    operand.setReportId(reportId);
    return operand;
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   */
  private static ValuesHolder setup() throws Exception {
    return ReportDefinitionServiceSample.create();
  }
}
