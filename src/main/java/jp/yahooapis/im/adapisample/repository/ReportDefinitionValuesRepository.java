/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.repository;

import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201907.reportdefinition.ReportDefinition;
import jp.yahooapis.im.v201907.reportdefinition.ReportDefinitionValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class ReportDefinitionValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * ReportDefinitionValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public ReportDefinitionValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return ReportDefinitions
   */
  public List<ReportDefinition> getReportDefinitions() {
    List<ReportDefinition> reportDefinitions = new ArrayList<>();
    if (this.valuesHolder.getReportDefinitionValuesList().size() == 0) {
      return reportDefinitions;
    }
    for (ReportDefinitionValues reportDefinitionValues : this.valuesHolder.getReportDefinitionValuesList()) {
      reportDefinitions.add(reportDefinitionValues.getReportDefinition());
    }
    return reportDefinitions;
  }

  /**
   * @return ReportIds
   */
  public List<Long> getReportJobIds() {
    List<Long> reportJobIds = new ArrayList<>();
    if (this.valuesHolder.getReportDefinitionValuesList().size() == 0) {
      return reportJobIds;
    }
    for (ReportDefinitionValues reportDefinitionValues : this.valuesHolder.getReportDefinitionValuesList()) {
      reportJobIds.add(reportDefinitionValues.getReportDefinition().getReportJobId());
    }
    return reportJobIds;
  }
}
