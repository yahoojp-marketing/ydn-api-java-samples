/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.reportdefinition;

import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201903.Error;
import jp.yahooapis.im.v201903.Paging;
import jp.yahooapis.im.v201903.reportdefinition.Operator;
import jp.yahooapis.im.v201903.reportdefinition.ReportAddTemplate;
import jp.yahooapis.im.v201903.reportdefinition.ReportCategory;
import jp.yahooapis.im.v201903.reportdefinition.ReportDateRangeType;
import jp.yahooapis.im.v201903.reportdefinition.ReportDefinition;
import jp.yahooapis.im.v201903.reportdefinition.ReportDefinitionField;
import jp.yahooapis.im.v201903.reportdefinition.ReportDefinitionFieldValue;
import jp.yahooapis.im.v201903.reportdefinition.ReportDefinitionOperation;
import jp.yahooapis.im.v201903.reportdefinition.ReportDefinitionPage;
import jp.yahooapis.im.v201903.reportdefinition.ReportDefinitionReturnValue;
import jp.yahooapis.im.v201903.reportdefinition.ReportDefinitionSelector;
import jp.yahooapis.im.v201903.reportdefinition.ReportDefinitionService;
import jp.yahooapis.im.v201903.reportdefinition.ReportDefinitionServiceInterface;
import jp.yahooapis.im.v201903.reportdefinition.ReportDefinitionValues;
import jp.yahooapis.im.v201903.reportdefinition.ReportDownloadEncode;
import jp.yahooapis.im.v201903.reportdefinition.ReportDownloadFormat;
import jp.yahooapis.im.v201903.reportdefinition.ReportFrequencyRange;
import jp.yahooapis.im.v201903.reportdefinition.ReportLang;

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
      getReportFields(ReportCategory.AD);

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
      // create request.
      ReportDefinitionSelector getRequest = buildExampleGetRequest(accountId, valuesRepositoryFacade.getReportDefinitionValuesRepository().getReportIds());

      // run
      get(getRequest);

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
   * @param reportCategory ReportCategory
   * @return ReportDefinitionField
   */
  public static List<ReportDefinitionField> getReportFields(ReportCategory reportCategory) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ReportDefinitionService::getReportFields");
    System.out.println("############################################");

    Holder<ReportDefinitionFieldValue> reportDefinitionFieldValueHolder = new Holder<ReportDefinitionFieldValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    ReportDefinitionServiceInterface reportDefinitionService = SoapUtils.createServiceInterface(ReportDefinitionServiceInterface.class, ReportDefinitionService.class);
    reportDefinitionService.getReportFields(reportCategory, reportDefinitionFieldValueHolder, errorHolder);

    // Response
    return reportDefinitionFieldValueHolder.value.getFields();
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
   * example get request.
   *
   * @param accountId long
   * @param reportIds List<Long>
   * @return ReportDefinitionSelector
   */
  public static ReportDefinitionSelector buildExampleGetRequest(long accountId, List<Long> reportIds) {
    ReportDefinitionSelector selector = new ReportDefinitionSelector();
    selector.setAccountId(accountId);
    selector.getReportIds().addAll(reportIds);
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
    operand.setLang(ReportLang.EN);
    operand.setAddTemplate(ReportAddTemplate.YES);
    return operand;
  }

  /**
   * create basic ReportDefinition.
   *
   * @return ValuesHolder
   */
  public static ValuesHolder create() throws Exception {
    ValuesHolder valuesHolder = new ValuesHolder();
    ReportDefinitionOperation addRequest = buildExampleMutateRequest(Operator.ADD, SoapUtils.getAccountId(), Collections.singletonList(createExampleReportDefinition()));
    List<ReportDefinitionValues> addResponse = mutate(addRequest);
    valuesHolder.setReportDefinitionValuesList(addResponse);
    return valuesHolder;
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    if (valuesHolder.getReportDefinitionValuesList().size() == 0) {
      return;
    }
    ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
    mutate(buildExampleMutateRequest(Operator.REMOVE, SoapUtils.getAccountId(), valuesRepositoryFacade.getReportDefinitionValuesRepository().getReportDefinitions()));
  }
}
