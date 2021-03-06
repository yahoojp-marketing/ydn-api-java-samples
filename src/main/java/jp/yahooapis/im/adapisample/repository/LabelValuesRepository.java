/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.repository;

import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201911.label.Label;
import jp.yahooapis.im.v201911.label.LabelValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class LabelValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * LabelValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public LabelValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return Labels
   */
  public List<Label> getLabels() {
    List<Label> labels = new ArrayList<>();
    if (this.valuesHolder.getLabelValuesList().size() == 0) {
      return labels;
    }
    for (LabelValues labelValues : this.valuesHolder.getLabelValuesList()) {
      labels.add(labelValues.getLabel());
    }
    return labels;
  }

  /**
   * @return LabelIds
   */
  public List<Long> getLabelIds() {
    List<Long> labelIds = new ArrayList<>();
    if (this.valuesHolder.getLabelValuesList().size() == 0) {
      return labelIds;
    }
    for (LabelValues labelValues : this.valuesHolder.getLabelValuesList()) {
      labelIds.add(labelValues.getLabel().getLabelId());
    }
    return labelIds;
  }
}
