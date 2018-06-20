package jp.co.yahoo.ad_api_sample.reportDownloadSample;

import jp.co.yahoo.ad_api_sample.error.impl.ErrorEntityFactoryImpl;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201806.Error;
import jp.yahooapis.im.v201806.report.ReportClosedDateRecord;
import jp.yahooapis.im.v201806.report.ReportClosedDateSelector;
import jp.yahooapis.im.v201806.report.ReportClosedDateValue;
import jp.yahooapis.im.v201806.report.ReportJobOperation;
import jp.yahooapis.im.v201806.report.ReportJobStatus;
import jp.yahooapis.im.v201806.report.ReportPage;
import jp.yahooapis.im.v201806.report.ReportRecord;
import jp.yahooapis.im.v201806.report.ReportReturnValue;
import jp.yahooapis.im.v201806.report.ReportSelector;
import jp.yahooapis.im.v201806.report.ReportServiceInterface;
import jp.yahooapis.im.v201806.report.ReportServiceService;
import jp.yahooapis.im.v201806.report.ReportValues;
import jp.yahooapis.im.v201806.reportdefinition.Operator;
import jp.yahooapis.im.v201806.reportdefinition.ReportAddTemplate;
import jp.yahooapis.im.v201806.reportdefinition.ReportCategory;
import jp.yahooapis.im.v201806.reportdefinition.ReportDateRangeType;
import jp.yahooapis.im.v201806.reportdefinition.ReportDefinition;
import jp.yahooapis.im.v201806.reportdefinition.ReportDefinitionField;
import jp.yahooapis.im.v201806.reportdefinition.ReportDefinitionFieldValue;
import jp.yahooapis.im.v201806.reportdefinition.ReportDefinitionOperation;
import jp.yahooapis.im.v201806.reportdefinition.ReportDefinitionReturnValue;
import jp.yahooapis.im.v201806.reportdefinition.ReportDefinitionServiceInterface;
import jp.yahooapis.im.v201806.reportdefinition.ReportDefinitionServiceService;
import jp.yahooapis.im.v201806.reportdefinition.ReportDefinitionValues;
import jp.yahooapis.im.v201806.reportdefinition.ReportDownloadEncode;
import jp.yahooapis.im.v201806.reportdefinition.ReportDownloadFormat;
import jp.yahooapis.im.v201806.reportdefinition.ReportFrequencyRange;
import jp.yahooapis.im.v201806.reportdefinition.ReportLang;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for Report Download.<br>
 * Copyright (C) 2013 Yahoo Japan Corporation. All Rights Reserved.
 */
public class ReportDownloadSample {

  /**
   * main method for ReportDownloadSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    try {
      // =================================================================
      // ReportDefinitionService
      // =================================================================
      ReportDefinitionServiceInterface reportDefinitionService = SoapUtils.createServiceInterface(ReportDefinitionServiceInterface.class, ReportDefinitionServiceService.class);
      // -----------------------------------------------
      // call ReportDefinitionService::getReportFields
      // -----------------------------------------------
      // call API
      System.out.println("############################################");
      System.out.println("ReportDefinitionService::getReportFields");
      System.out.println("############################################");
      Holder<ReportDefinitionFieldValue> fieldsValueHolder = new Holder<ReportDefinitionFieldValue>();
      Holder<List<Error>> fieldsErrorHolder = new Holder<List<Error>>();
      reportDefinitionService.getReportFields(ReportCategory.AD, fieldsValueHolder, fieldsErrorHolder);

      // if error
      if (fieldsErrorHolder.value != null && fieldsErrorHolder.value.size() > 0) {
        SoapUtils.displayErrors(new ErrorEntityFactoryImpl(fieldsErrorHolder.value), true);
      }

      // response
      if (fieldsValueHolder.value != null) {
        List<ReportDefinitionField> fields = fieldsValueHolder.value.getFields();
        for (ReportDefinitionField reportDefinitionField : fields) {
          System.out.println("fieldName        = " + reportDefinitionField.getFieldName());
          System.out.println("displayFieldName = " + reportDefinitionField.getDisplayFieldNameJA());
          System.out.println("xmlAttributeName = " + reportDefinitionField.getXmlAttributeName());
          System.out.println("---------");
        }
      }

      // -----------------------------------------------
      // call ReportDefinitionService::mutate(ADD)
      // -----------------------------------------------
      // request
      ReportDefinitionOperation reportDefinitionOperation = new ReportDefinitionOperation();
      reportDefinitionOperation.setAccountId(SoapUtils.getAccountId());
      reportDefinitionOperation.setOperator(Operator.ADD);

      ReportDefinition reportDefinition = new ReportDefinition();
      reportDefinition.setAccountId(SoapUtils.getAccountId());
      reportDefinition.setReportName("TEST_ACCOUNT_REPORT");
      reportDefinition.setDateRangeType(ReportDateRangeType.YESTERDAY);
      // fileds
      reportDefinition.getFields()
          .addAll(Arrays.asList("ACCOUNT_NAME", "ACCOUNT_ID", "DAY", "DEVICE", "IMPS", "CLICK", "CLICK_RATE", "AVG_DELIVER_RANK", "COST", "AVG_CPC"));
      // reportDefinition.getFields().addAll(Arrays.asList("ACCOUNT_ID", "AD_ID"));

      reportDefinition.setFormat(ReportDownloadFormat.CSV);
      reportDefinition.setEncode(ReportDownloadEncode.SJIS);
      reportDefinition.setLang(ReportLang.JA);

      reportDefinitionOperation.getOperand().add(reportDefinition);

      // call API
      System.out.println("############################################");
      System.out.println("ReportDefinitionService::mutate(ADD)");
      System.out.println("############################################");
      Holder<ReportDefinitionReturnValue> reportDefinitinonReturnValue = new Holder<ReportDefinitionReturnValue>();
      Holder<List<Error>> reportDefinitionError = new Holder<List<Error>>();
      reportDefinitionService.mutate(reportDefinitionOperation, reportDefinitinonReturnValue, reportDefinitionError);

      // if error
      if (reportDefinitionError.value != null && reportDefinitionError.value.size() > 0) {
        SoapUtils.displayErrors(new ErrorEntityFactoryImpl(reportDefinitionError.value), true);
      }

      // response
      long reportId = 0;
      String downloadFileName = null;
      if (reportDefinitinonReturnValue.value != null) {
        ReportDefinitionReturnValue returnValue = reportDefinitinonReturnValue.value;
        for (ReportDefinitionValues values : returnValue.getValues()) {
          if (values.isOperationSucceeded()) {
            ReportDefinition addReportDefinition = values.getReportDefinition();
            // reportId
            reportId = addReportDefinition.getReportId();
            // filename
            downloadFileName = "Report_" + reportId + "." + addReportDefinition.getFormat().toString().toLowerCase();

            displayReportDefintion(addReportDefinition);

          } else {
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
          }
        }
      }

      // -----------------------------------------------
      // call ReportDefinitionService::mutate(ADD) REACH_FREQUENCY
      // -----------------------------------------------
      // request
      ReportDefinitionOperation addFrequencyReportDefinitionOperation = new ReportDefinitionOperation();
      addFrequencyReportDefinitionOperation.setAccountId(SoapUtils.getAccountId());
      addFrequencyReportDefinitionOperation.setOperator(Operator.ADD);

      ReportDefinition addFrequencyReportDefinition = new ReportDefinition();
      addFrequencyReportDefinition.setAccountId(SoapUtils.getAccountId());
      addFrequencyReportDefinition.setReportName("TEST_REACH_FREQUENCY_REPORT");
      addFrequencyReportDefinition.setDateRangeType(ReportDateRangeType.YESTERDAY);
      // fields
      addFrequencyReportDefinition.getFields().addAll(Arrays.asList("ACCOUNT_ID", "ACCOUNT_NAME", "FREQUENCY", "IMPS", "CLICK", "UNIQUE_USERS", "CAMPAIGN_NAME", "DAY"));

      addFrequencyReportDefinition.getSortFields().add("+FREQUENCY");
      addFrequencyReportDefinition.setFrequencyRange(ReportFrequencyRange.DAILY);
      addFrequencyReportDefinition.setFormat(ReportDownloadFormat.CSV);
      addFrequencyReportDefinition.setEncode(ReportDownloadEncode.SJIS);
      addFrequencyReportDefinition.setLang(ReportLang.EN);
      addFrequencyReportDefinition.setAddTemplate(ReportAddTemplate.YES);

      addFrequencyReportDefinitionOperation.getOperand().add(addFrequencyReportDefinition);

      // call API
      System.out.println("############################################");
      System.out.println("ReportDefinitionService::mutate(ADD) REACH_FREQUENCY");
      System.out.println("############################################");
      Holder<ReportDefinitionReturnValue> addFrequencyReportDefinitinonReturnValue = new Holder<ReportDefinitionReturnValue>();
      Holder<List<Error>> addFrequencyReportDefinitionError = new Holder<List<Error>>();
      reportDefinitionService.mutate(addFrequencyReportDefinitionOperation, addFrequencyReportDefinitinonReturnValue, addFrequencyReportDefinitionError);

      // if error
      if (addFrequencyReportDefinitionError.value != null && addFrequencyReportDefinitionError.value.size() > 0) {
        SoapUtils.displayErrors(new ErrorEntityFactoryImpl(addFrequencyReportDefinitionError.value), true);
      }

      // response
      long frequencyReportId = 0;
      String downloadFrequencyFileName = null;
      if (addFrequencyReportDefinitinonReturnValue.value != null) {
        ReportDefinitionReturnValue returnValue = addFrequencyReportDefinitinonReturnValue.value;
        for (ReportDefinitionValues values : returnValue.getValues()) {
          if (values.isOperationSucceeded()) {
            ReportDefinition addReportDefinition = values.getReportDefinition();
            // reportId
            frequencyReportId = addReportDefinition.getReportId();
            // filename
            downloadFrequencyFileName = "Report_" + frequencyReportId + "." + addReportDefinition.getFormat().toString().toLowerCase();
            displayReportDefintion(addReportDefinition);
          } else {
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
          }
        }
      }

      // =================================================================
      // ReportService
      // =================================================================
      ReportServiceInterface reportService = SoapUtils.createServiceInterface(ReportServiceInterface.class, ReportServiceService.class);
      // -----------------------------------------------
      // call ReportService::getClosedDate;
      // -----------------------------------------------
      ReportClosedDateSelector getClosedDateSelector = new ReportClosedDateSelector();
      getClosedDateSelector.setAccountId(SoapUtils.getAccountId());

      // call API
      System.out.println("############################################");
      System.out.println("ReportService::getClosedDate");
      System.out.println("############################################");
      Holder<ReportClosedDateValue> getClosedDateValueHolder = new Holder<ReportClosedDateValue>();
      Holder<List<jp.yahooapis.im.v201806.Error>> getClosedDateErrorHolder = new Holder<List<jp.yahooapis.im.v201806.Error>>();
      reportService.getClosedDate(getClosedDateSelector, getClosedDateValueHolder, getClosedDateErrorHolder);

      // if error
      if (getClosedDateErrorHolder.value != null && getClosedDateErrorHolder.value.size() > 0) {
        SoapUtils.displayErrors(new ErrorEntityFactoryImpl(getClosedDateErrorHolder.value), true);
      }

      // response
      if (getClosedDateValueHolder.value != null) {
        ReportClosedDateValue getReportClosedDateValue = getClosedDateValueHolder.value;
        for (ReportClosedDateRecord values : getReportClosedDateValue.getValues()) {
          if (values.isOperationSucceeded()) {
            System.out.println("key = " + values.getKey());
            System.out.println("closedDate = " + values.getClosedDate());
            System.out.println("-----------------");
          } else {
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
          }
        }
      }

      // -----------------------------------------------
      // call ReportService::mutate(ADD)
      // -----------------------------------------------
      // request
      ReportRecord addReportRecord = new ReportRecord();
      addReportRecord.setAccountId(SoapUtils.getAccountId());
      addReportRecord.setReportId(reportId);
      ReportJobOperation addReportOperation = new ReportJobOperation();
      addReportOperation.setOperator(jp.yahooapis.im.v201806.report.Operator.ADD);
      addReportOperation.setAccountId(SoapUtils.getAccountId());
      addReportOperation.getOperand().add(addReportRecord);

      // call API
      System.out.println("############################################");
      System.out.println("ReportService::mutate(ADD)");
      System.out.println("############################################");
      Holder<ReportReturnValue> addReportReturnValueHolder = new Holder<ReportReturnValue>();
      Holder<List<jp.yahooapis.im.v201806.Error>> addReportError = new Holder<List<jp.yahooapis.im.v201806.Error>>();
      reportService.mutate(addReportOperation, addReportReturnValueHolder, addReportError);

      // if error
      if (addReportError.value != null && addReportError.value.size() > 0) {
        SoapUtils.displayErrors(new ErrorEntityFactoryImpl(addReportError.value), true);
      }

      // response
      long reportJobId = 0;
      if (addReportReturnValueHolder.value != null) {
        ReportReturnValue returnValue = addReportReturnValueHolder.value;
        for (ReportValues values : returnValue.getValues()) {
          if (values.isOperationSucceeded()) {
            reportJobId = values.getReportRecord().getReportJobId();
            displayReportRecord(values.getReportRecord());
          } else {
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
          }
        }
      }

      // -----------------------------------------------
      // call ReportService::get
      // -----------------------------------------------
      // request
      ReportSelector reportSelector = new ReportSelector();
      reportSelector.setAccountId(SoapUtils.getAccountId());
      reportSelector.getReportJobIds().add(reportJobId);
      String downloadURLStr = null;

      // call 30sec sleep * 30 = 15minute
      for (int i = 0; i < 30; i++) {
        // sleep 30 second.
        System.out.println("\n***** sleep 30 seconds for Report Download Job *****\n");
        Thread.sleep(30000);

        // call API
        System.out.println("############################################");
        System.out.println("ReportService::get");
        System.out.println("############################################");
        Holder<ReportPage> getReportPageHolder = new Holder<ReportPage>();
        Holder<List<jp.yahooapis.im.v201806.Error>> getReportError = new Holder<List<jp.yahooapis.im.v201806.Error>>();
        reportService.get(reportSelector, getReportPageHolder, getReportError);

        // if error
        if (getReportError.value != null && getReportError.value.size() > 0) {
          SoapUtils.displayErrors(new ErrorEntityFactoryImpl(getReportError.value), true);
        }

        // response
        if (getReportPageHolder.value != null) {
          ReportPage reportPage = getReportPageHolder.value;
          if (reportPage.getValues().size() > 0) {
            ReportValues values = reportPage.getValues().get(0);
            if (values.isOperationSucceeded()) {
              displayReportRecord(values.getReportRecord());
            } else {
              SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
              System.exit(0);
            }

            if (values.getReportRecord().getStatus() == ReportJobStatus.COMPLETED) {
              downloadURLStr = values.getReportRecord().getReportDownloadUrl();
              break;
            } else {
              if (values.getReportRecord().getStatus() == ReportJobStatus.ACCEPTED || values.getReportRecord().getStatus() == ReportJobStatus.IN_PROGRESS) {
                continue;
              } else {
                System.out.println("Error : Job Status failed.");
                System.exit(0);

              }
            }
          } else {
            System.out.println("Report job in process on long time. please wait.");
            System.exit(0);
          }

        }
      }

      // -----------------------------------------------
      // download report
      // -----------------------------------------------
      SoapUtils.download(downloadURLStr, downloadFileName);

      // -----------------------------------------------
      // call ReportService::mutate(ADD) REACH_FREQUENCY
      // -----------------------------------------------
      // request
      ReportRecord addFrequencyReportRecord = new ReportRecord();
      addFrequencyReportRecord.setAccountId(SoapUtils.getAccountId());
      addFrequencyReportRecord.setReportId(frequencyReportId);
      ReportJobOperation addFrequencyReportOperation = new ReportJobOperation();
      addFrequencyReportOperation.setOperator(jp.yahooapis.im.v201806.report.Operator.ADD);
      addFrequencyReportOperation.setAccountId(SoapUtils.getAccountId());
      addFrequencyReportOperation.getOperand().add(addFrequencyReportRecord);

      // call API
      System.out.println("############################################");
      System.out.println("ReportService::mutate(ADD) REACH_FREQUENCY");
      System.out.println("############################################");
      Holder<ReportReturnValue> addFrequencyReportReturnValueHolder = new Holder<ReportReturnValue>();
      Holder<List<jp.yahooapis.im.v201806.Error>> addFrequencyReportError = new Holder<List<jp.yahooapis.im.v201806.Error>>();
      reportService.mutate(addFrequencyReportOperation, addFrequencyReportReturnValueHolder, addFrequencyReportError);

      // if error
      if (addFrequencyReportError.value != null && addFrequencyReportError.value.size() > 0) {
        SoapUtils.displayErrors(new ErrorEntityFactoryImpl(addFrequencyReportError.value), true);
      }

      // response
      long frequencyReportJobId = 0;
      if (addFrequencyReportReturnValueHolder.value != null) {
        ReportReturnValue returnValue = addFrequencyReportReturnValueHolder.value;
        for (ReportValues values : returnValue.getValues()) {
          if (values.isOperationSucceeded()) {
            frequencyReportJobId = values.getReportRecord().getReportJobId();
            displayReportRecord(values.getReportRecord());
          } else {
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
          }
        }
      }

      // -----------------------------------------------
      // call ReportService::get REACH_FREQUENCY
      // -----------------------------------------------
      // request
      ReportSelector frequencyReportSelector = new ReportSelector();
      frequencyReportSelector.setAccountId(SoapUtils.getAccountId());
      frequencyReportSelector.getReportJobIds().add(frequencyReportJobId);
      String downloadFrequencyURLStr = null;
      // call 30sec sleep * 30 = 15minute
      for (int i = 0; i < 30; i++) {
        // sleep 30 second.
        System.out.println("\n***** sleep 30 seconds for Report Download Job *****\n");
        Thread.sleep(30000);

        // call API
        System.out.println("############################################");
        System.out.println("ReportService::get REACH_FREQUENCY REACH_FREQUENCY");
        System.out.println("############################################");
        Holder<ReportPage> getReportPageHolder = new Holder<ReportPage>();
        Holder<List<jp.yahooapis.im.v201806.Error>> getReportError = new Holder<List<jp.yahooapis.im.v201806.Error>>();
        reportService.get(frequencyReportSelector, getReportPageHolder, getReportError);

        // if error
        if (getReportError.value != null && getReportError.value.size() > 0) {
          SoapUtils.displayErrors(new ErrorEntityFactoryImpl(getReportError.value), true);
        }

        // response
        if (getReportPageHolder.value != null) {
          ReportPage reportPage = getReportPageHolder.value;
          if (reportPage.getValues().size() > 0) {
            ReportValues values = reportPage.getValues().get(0);
            if (values.isOperationSucceeded()) {
              displayReportRecord(values.getReportRecord());
            } else {
              SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
              System.exit(0);
            }

            if (values.getReportRecord().getStatus() == ReportJobStatus.COMPLETED) {
              downloadFrequencyURLStr = values.getReportRecord().getReportDownloadUrl();
              break;
            } else {
              if (values.getReportRecord().getStatus() == ReportJobStatus.ACCEPTED || values.getReportRecord().getStatus() == ReportJobStatus.IN_PROGRESS) {
                continue;
              } else {
                System.out.println("Error : Job Status failed.");
                System.exit(0);

              }
            }
          } else {
            System.out.println("Report job in process on long time. please wait.");
            System.exit(0);
          }

        }
      }

      // -----------------------------------------------
      // download report
      // -----------------------------------------------
      SoapUtils.download(downloadFrequencyURLStr, downloadFrequencyFileName);

      // -----------------------------------------------
      // call ReportService::mutate(REMOVE)
      // -----------------------------------------------
      // request
      ReportRecord removeReportRecord = new ReportRecord();
      removeReportRecord.setAccountId(SoapUtils.getAccountId());
      removeReportRecord.setReportJobId(reportJobId);
      ReportJobOperation removeReportOperation = new ReportJobOperation();
      removeReportOperation.setOperator(jp.yahooapis.im.v201806.report.Operator.REMOVE);
      removeReportOperation.setAccountId(SoapUtils.getAccountId());
      removeReportOperation.getOperand().add(removeReportRecord);

      // call API
      System.out.println("############################################");
      System.out.println("ReportService::mutate(REMOVE)");
      System.out.println("############################################");
      Holder<ReportReturnValue> removeReportReturnValueHolder = new Holder<ReportReturnValue>();
      Holder<List<jp.yahooapis.im.v201806.Error>> removeReportError = new Holder<List<jp.yahooapis.im.v201806.Error>>();
      reportService.mutate(removeReportOperation, removeReportReturnValueHolder, removeReportError);

      // if error
      if (removeReportError.value != null && removeReportError.value.size() > 0) {
        SoapUtils.displayErrors(new ErrorEntityFactoryImpl(removeReportError.value), true);
      }

      // response
      if (removeReportReturnValueHolder.value != null) {
        ReportReturnValue returnValue = removeReportReturnValueHolder.value;
        for (ReportValues values : returnValue.getValues()) {
          if (values.isOperationSucceeded()) {
            displayReportRecord(values.getReportRecord());
          } else {
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
          }
        }
      }

      // -----------------------------------------------
      // call ReportDefinitionService::mutate(REMOVE)
      // -----------------------------------------------
      // request
      ReportDefinition removeReportDefinition = new ReportDefinition();
      removeReportDefinition.setAccountId(SoapUtils.getAccountId());
      removeReportDefinition.setReportId(reportId);

      ReportDefinitionOperation removeReportDefinitionOperation = new ReportDefinitionOperation();
      removeReportDefinitionOperation.setAccountId(SoapUtils.getAccountId());
      removeReportDefinitionOperation.setOperator(Operator.REMOVE);
      removeReportDefinitionOperation.getOperand().add(removeReportDefinition);

      // call API
      System.out.println("############################################");
      System.out.println("ReportDefinitionService::mutate(REMOVE)");
      System.out.println("############################################");
      Holder<ReportDefinitionReturnValue> removeReportDefintionReturnValueHolder = new Holder<ReportDefinitionReturnValue>();
      Holder<List<Error>> removeReportDefintionErrorHolder = new Holder<List<Error>>();
      reportDefinitionService.mutate(removeReportDefinitionOperation, removeReportDefintionReturnValueHolder, removeReportDefintionErrorHolder);

      // if error
      if (removeReportDefintionErrorHolder.value != null && removeReportDefintionErrorHolder.value.size() > 0) {
        SoapUtils.displayErrors(new ErrorEntityFactoryImpl(removeReportDefintionErrorHolder.value), true);
      }

      // reponse
      if (removeReportDefintionReturnValueHolder.value != null) {
        List<ReportDefinitionValues> values = removeReportDefintionReturnValueHolder.value.getValues();
        if (values.get(0).isOperationSucceeded()) {
          displayReportDefintion(values.get(0).getReportDefinition());
        } else {
          SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(0).getError()), true);
        }
      }

      // -----------------------------------------------
      // call ReportService::mutate(REMOVE) REACH_FREQUENCY
      // -----------------------------------------------
      // request
      ReportRecord removeFrequencyReportRecord = new ReportRecord();
      removeFrequencyReportRecord.setAccountId(SoapUtils.getAccountId());
      removeFrequencyReportRecord.setReportJobId(frequencyReportJobId);
      ReportJobOperation removeFrequencyReportOperation = new ReportJobOperation();
      removeFrequencyReportOperation.setOperator(jp.yahooapis.im.v201806.report.Operator.REMOVE);
      removeFrequencyReportOperation.setAccountId(SoapUtils.getAccountId());
      removeFrequencyReportOperation.getOperand().add(removeFrequencyReportRecord);

      // call API
      System.out.println("############################################");
      System.out.println("ReportService::mutate(REMOVE) REACH_FREQUENCY");
      System.out.println("############################################");
      Holder<ReportReturnValue> removeFrequencyReportReturnValueHolder = new Holder<ReportReturnValue>();
      Holder<List<jp.yahooapis.im.v201806.Error>> removeFrequencyReportError = new Holder<List<jp.yahooapis.im.v201806.Error>>();
      reportService.mutate(removeFrequencyReportOperation, removeFrequencyReportReturnValueHolder, removeFrequencyReportError);

      // if error
      if (removeFrequencyReportError.value != null && removeFrequencyReportError.value.size() > 0) {
        SoapUtils.displayErrors(new ErrorEntityFactoryImpl(removeFrequencyReportError.value), true);
      }

      // response
      if (removeFrequencyReportReturnValueHolder.value != null) {
        ReportReturnValue returnValue = removeFrequencyReportReturnValueHolder.value;
        for (ReportValues values : returnValue.getValues()) {
          if (values.isOperationSucceeded()) {
            displayReportRecord(values.getReportRecord());
          } else {
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
          }
        }
      }

      // -----------------------------------------------
      // call ReportDefinitionService::mutate(REMOVE) REACH_FREQUENCY
      // -----------------------------------------------
      // request
      ReportDefinition removeFrequencyReportDefinition = new ReportDefinition();
      removeFrequencyReportDefinition.setAccountId(SoapUtils.getAccountId());
      removeFrequencyReportDefinition.setReportId(frequencyReportId);

      ReportDefinitionOperation removeFrequencyReportDefinitionOperation = new ReportDefinitionOperation();
      removeFrequencyReportDefinitionOperation.setAccountId(SoapUtils.getAccountId());
      removeFrequencyReportDefinitionOperation.setOperator(Operator.REMOVE);
      removeFrequencyReportDefinitionOperation.getOperand().add(removeFrequencyReportDefinition);

      // call API
      System.out.println("############################################");
      System.out.println("ReportDefinitionService::mutate(REMOVE) REACH_FREQUENCY");
      System.out.println("############################################");
      Holder<ReportDefinitionReturnValue> removeFrequencyReportDefintionReturnValueHolder = new Holder<ReportDefinitionReturnValue>();
      Holder<List<Error>> removeFrequencyReportDefintionErrorHolder = new Holder<List<Error>>();
      reportDefinitionService.mutate(removeFrequencyReportDefinitionOperation, removeFrequencyReportDefintionReturnValueHolder, removeFrequencyReportDefintionErrorHolder);

      // if error
      if (removeFrequencyReportDefintionErrorHolder.value != null && removeFrequencyReportDefintionErrorHolder.value.size() > 0) {
        SoapUtils.displayErrors(new ErrorEntityFactoryImpl(removeFrequencyReportDefintionErrorHolder.value), true);
      }

      // reponse
      if (removeFrequencyReportDefintionReturnValueHolder.value != null) {
        List<ReportDefinitionValues> values = removeFrequencyReportDefintionReturnValueHolder.value.getValues();
        if (values.get(0).isOperationSucceeded()) {
          displayReportDefintion(values.get(0).getReportDefinition());
        } else {
          SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(0).getError()), true);
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
      System.exit(-1);
    }
  }

  /**
   * display ReportRecord entity to stdout.
   *
   * @param reportRecord ReportRecord entity for display.
   */
  private static void displayReportRecord(ReportRecord reportRecord) {
    System.out.println("accountId = " + reportRecord.getAccountId());
    System.out.println("reportId = " + reportRecord.getReportId());
    System.out.println("reportJobId = " + reportRecord.getReportJobId());
    System.out.println("reportName = " + reportRecord.getReportName());
    System.out.println("requestTime = " + reportRecord.getRequestTime());
    System.out.println("status = " + reportRecord.getStatus());
    System.out.println("reportDownloadURL = " + reportRecord.getReportDownloadUrl());
    System.out.println("---------");

  }

  /**
   * display ReportDefintion entity to stdout.
   *
   * @param reportDefinition ReportDefintion entity for display.
   */
  private static void displayReportDefintion(ReportDefinition reportDefinition) {
    // display response
    System.out.println("accountId = " + reportDefinition.getAccountId());
    System.out.println("reportId = " + reportDefinition.getReportId());
    System.out.println("reportName = " + reportDefinition.getReportName());
    System.out.println("dateRangeType = " + reportDefinition.getDateRangeType());
    System.out.println("fields = " + SoapUtils.arrayToLine(reportDefinition.getFields().toArray()));
    System.out.println("sort = " + SoapUtils.arrayToLine(reportDefinition.getSortFields().toArray()));
    System.out.println("format = " + reportDefinition.getFormat());
    System.out.println("encode = " + reportDefinition.getEncode());
    System.out.println("lang = " + reportDefinition.getLang());
    System.out.println("---------");
  }
}
