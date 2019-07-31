/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.repository;

import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201907.feedholder.FeedHolderRecord;
import jp.yahooapis.im.v201907.feedholder.FeedHolderValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class FeedHolderValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * FeedHolderValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public FeedHolderValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return FeedHolderRecords
   */
  public List<FeedHolderRecord> getFeedHolderRecords() {
    List<FeedHolderRecord> feedHolderRecords = new ArrayList<>();
    if (this.valuesHolder.getFeedHolderValuesList().size() == 0) {
      return feedHolderRecords;
    }
    for (FeedHolderValues feedHolderValues : this.valuesHolder.getFeedHolderValuesList()) {
      feedHolderRecords.add(feedHolderValues.getFeedHolder());
    }
    return feedHolderRecords;
  }

  /**
   * @return FeedHolderIds
   */
  public List<Long> getFeedHolderIds() {
    List<Long> feedHolderIds = new ArrayList<>();
    if (this.valuesHolder.getFeedHolderValuesList().size() == 0) {
      return feedHolderIds;
    }
    for (FeedHolderValues feedHolderValues : this.valuesHolder.getFeedHolderValuesList()) {
      feedHolderIds.add(feedHolderValues.getFeedHolder().getFeedHolderId());
    }
    return feedHolderIds;
  }
}
