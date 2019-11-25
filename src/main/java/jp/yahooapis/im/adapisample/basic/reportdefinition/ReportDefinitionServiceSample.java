/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.reportdefinition;

import jp.yahooapis.im.v201911.Error;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201911.Paging;
import jp.yahooapis.im.v201911.reportdefinition.Operator;
import jp.yahooapis.im.v201911.reportdefinition.ReportClosedDateRecord;
import jp.yahooapis.im.v201911.reportdefinition.ReportClosedDateSelector;
import jp.yahooapis.im.v201911.reportdefinition.ReportClosedDateValue;
import jp.yahooapis.im.v201911.reportdefinition.ReportDateRangeType;
import jp.yahooapis.im.v201911.reportdefinition.ReportDefinition;
import jp.yahooapis.im.v201911.reportdefinition.ReportDefinitionFieldValue;
import jp.yahooapis.im.v201911.reportdefinition.ReportDefinitionOperation;
import jp.yahooapis.im.v201911.reportdefinition.ReportDefinitionPage;
import jp.yahooapis.im.v201911.reportdefinition.ReportDefinitionReturnValue;
import jp.yahooapis.im.v201911.reportdefinition.ReportDefinitionSelector;
import jp.yahooapis.im.v201911.reportdefinition.ReportDefinitionService;
import jp.yahooapis.im.v201911.reportdefinition.ReportDefinitionServiceInterface;
import jp.yahooapis.im.v201911.reportdefinition.ReportDefinitionValues;
import jp.yahooapis.im.v201911.reportdefinition.ReportDownloadEncode;
import jp.yahooapis.im.v201911.reportdefinition.ReportDownloadFormat;
import jp.yahooapis.im.v201911.reportdefinition.ReportFieldAttribute;
import jp.yahooapis.im.v201911.reportdefinition.ReportFrequencyRange;
import jp.yahooapis.im.v201911.reportdefinition.ReportJobStatus;
import jp.yahooapis.im.v201911.reportdefinition.ReportLang;
import jp.yahooapis.im.v201911.reportdefinition.ReportType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example ReportDefinitionService operation and Utility method collection.
 */
public class ReportDefinitionServiceSample {

  /**
   * example ReportDefinitionService operation.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      ValuesHolder valuesHolder = new ValuesHolder();
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      long accountId = SoapUtils.getAccountId();

      // =================================================================
      // ReportDefinitionService getReportFields
      // =================================================================
      // run
      getReportFields(ReportType.AD);

      // =================================================================
      // ReportService getClosedDate
      // =================================================================
      // create request.
      ReportClosedDateSelector getClosedDateRequest = buildExampleGetClosedDateRequest(accountId);

      // run
      getClosedDate(getClosedDateRequest);

      // =================================================================
      // ReportDefinitionService ADD
      // =================================================================
      // create request.
      ReportDefinitionOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, Collections.singletonList(createExampleReportDefinition()));

      // run
      List<ReportDefinitionValues> addResponse = mutate(addRequest);
      valuesHolder.setReportDefinitionValuesList(addResponse);

      // =================================================================
      // ReportDefinitionService GET
      // =================================================================
      // check job status
      checkStatus(valuesRepositoryFacade.getReportDefinitionValuesRepository().getReportJobIds());

      // create request.
      ReportDefinitionSelector getRequest = buildExampleGetRequest(accountId, valuesRepositoryFacade.getReportDefinitionValuesRepository().getReportJobIds());

      // run
      List<ReportDefinitionValues> getResponse = get(getRequest);

      String downloadUrl = null;
      for (ReportDefinitionValues reportValues : getResponse) {
        downloadUrl = reportValues.getReportDefinition().getReportDownloadUrl();
      }

      // =================================================================
      // ReportService download (http request)
      // =================================================================
      SoapUtils.download(downloadUrl, "reportDownloadSample.csv");

      // =================================================================
      // ReportDefinitionService REMOVE
      // =================================================================
      // create request.
      ReportDefinitionOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getReportDefinitionValuesRepository().getReportDefinitions());

      // run
      mutate(removeRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example get ReportDefinitions.
   *
   * @param selector ReportDefinitionSelector
   * @return ReportDefinitionValues
   */
  public static List<ReportDefinitionValues> get(ReportDefinitionSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ReportDefinitionService::get");
    System.out.println("############################################");

    Holder<ReportDefinitionPage> reportDefinitionPageHolder = new Holder<ReportDefinitionPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    ReportDefinitionServiceInterface reportDefinitionService = SoapUtils.createServiceInterface(ReportDefinitionServiceInterface.class, ReportDefinitionService.class);
    reportDefinitionService.get(selector, reportDefinitionPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, reportDefinitionPageHolder.value.getValues());

    // Response
    return reportDefinitionPageHolder.value.getValues();
  }

  /**
   * example getReportFields ReportDefinitions.
   *
   * @param reportType ReportType
   * @return ReportFieldAttribute
   */
  public static List<ReportFieldAttribute> getReportFields(ReportType reportType) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ReportDefinitionService::getReportFields");
    System.out.println("############################################");

    Holder<ReportDefinitionFieldValue> reportDefinitionFieldValueHolder = new Holder<ReportDefinitionFieldValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    ReportDefinitionServiceInterface reportDefinitionService = SoapUtils.createServiceInterface(ReportDefinitionServiceInterface.class, ReportDefinitionService.class);

    reportDefinitionService.getReportFields(reportType, reportDefinitionFieldValueHolder, errorHolder);

    // Response
    return reportDefinitionFieldValueHolder.value.getFields();
  }

  /**
   * example get ReportDefinitions.
   *
   * @param selector ReportClosedDateSelector
   * @return ReportClosedDateRecord
   */
  public static List<ReportClosedDateRecord> getClosedDate(ReportClosedDateSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ReportDefinitionService::getClosedDate");
    System.out.println("############################################");

    Holder<ReportClosedDateValue> reportClosedDateValueHolder = new Holder<ReportClosedDateValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    ReportDefinitionServiceInterface reportService = SoapUtils.createServiceInterface(ReportDefinitionServiceInterface.class, ReportDefinitionService.class);
    reportService.getClosedDate(selector, reportClosedDateValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, reportClosedDateValueHolder.value.getValues());

    // Response
    return reportClosedDateValueHolder.value.getValues();
  }

  /**
   * example mutate ReportDefinitions.
   *
   * @param operation ReportDefinitionOperation
   * @return ReportDefinitionValues
   */
  public static List<ReportDefinitionValues> mutate(ReportDefinitionOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ReportDefinitionService::mutate(" + operation.getOperator().toString() + ")");
    System.out.println("############################################");

    Holder<ReportDefinitionReturnValue> reportDefinitionReturnValueHolder = new Holder<ReportDefinitionReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    ReportDefinitionServiceInterface reportDefinitionService = SoapUtils.createServiceInterface(ReportDefinitionServiceInterface.class, ReportDefinitionService.class);
    reportDefinitionService.mutate(operation, reportDefinitionReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, reportDefinitionReturnValueHolder.value.getValues());

    // Response
    return reportDefinitionReturnValueHolder.value.getValues();
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
   * example get request.
   *
   * @param accountId long
   * @param reportJobIds List<Long>
   * @return ReportDefinitionSelector
   */
  public static ReportDefinitionSelector buildExampleGetRequest(long accountId, List<Long> reportJobIds) {
    ReportDefinitionSelector selector = new ReportDefinitionSelector();
    selector.setAccountId(accountId);
    selector.getReportJobIds().addAll(reportJobIds);
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
   * @param operand   List<ReportDefinition>
   * @return ReportDefinitionOperation
   */
  public static ReportDefinitionOperation buildExampleMutateRequest(Operator operator, long accountId, List<ReportDefinition> operand) {
    ReportDefinitionOperation operation = new ReportDefinitionOperation();
    operation.setAccountId(accountId);
    operation.setOperator(operator);
    operation.getOperand().addAll(operand);
    return operation;
  }

  /**
   * example ReportDefinition request.
   *
   * @return ReportDefinition
   */
  public static ReportDefinition createExampleReportDefinition() {
    ReportDefinition operand = new ReportDefinition();
    operand.setReportName("REACH-FREQUENCY-REPORT");
    operand.setDateRangeType(ReportDateRangeType.YESTERDAY);
    operand.getSortFields().add("+FREQUENCY");
    operand.getFields().addAll(Arrays.asList( //
        "ACCOUNT_ID", //
        "ACCOUNT_NAME", //
        "CAMPAIGN_NAME", //
        "DAY", //
        "FREQUENCY", //
        "IMPS", //
        "CLICK", //
        "UNIQUE_USERS" //
    ));
    operand.setFrequencyRange(ReportFrequencyRange.DAILY);
    operand.setFormat(ReportDownloadFormat.CSV);
    operand.setEncode(ReportDownloadEncode.UTF_8);
    operand.setLanguage(ReportLang.EN);
    return operand;
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
      ReportDefinitionSelector getRequest = buildExampleGetRequest(SoapUtils.getAccountId(), jobIds);
      List<ReportDefinitionValues> getResponse = get(getRequest);

      int completedCount = 0;

      // check status
      for (ReportDefinitionValues reportValues : getResponse) {
        ReportJobStatus status = reportValues.getReportDefinition().getReportJobStatus();
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
}
