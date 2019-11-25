/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.repository;

import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201911.retargetingtag.RetargetingTag;
import jp.yahooapis.im.v201911.retargetingtag.RetargetingTagValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class RetargetingTagValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * RetargetingTagValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public RetargetingTagValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return RetargetingTags
   */
  public List<RetargetingTag> getRetargetingTags() {
    List<RetargetingTag> retargetingTags = new ArrayList<>();
    if (this.valuesHolder.getRetargetingTagValuesList().size() == 0) {
      return retargetingTags;
    }
    for (RetargetingTagValues retargetingTagValues : this.valuesHolder.getRetargetingTagValuesList()) {
      retargetingTags.add(retargetingTagValues.getRetargetingTag());
    }
    return retargetingTags;
  }

  /**
   * @return RetargetingTagIds
   */
  public List<String> getRetargetingTagIds() {
    List<String> retargetingTagIds = new ArrayList<>();
    if (this.valuesHolder.getRetargetingTagValuesList().size() == 0) {
      return retargetingTagIds;
    }
    for (RetargetingTagValues retargetingTagValues : this.valuesHolder.getRetargetingTagValuesList()) {
      retargetingTagIds.add(retargetingTagValues.getRetargetingTag().getRetargetingTagId());
    }
    return retargetingTagIds;
  }
}
