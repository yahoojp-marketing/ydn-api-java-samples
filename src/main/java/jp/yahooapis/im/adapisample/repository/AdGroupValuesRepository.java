/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.repository;

import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201903.adgroup.AdGroup;
import jp.yahooapis.im.v201903.adgroup.AdGroupValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class AdGroupValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * AdGroupValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public AdGroupValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return AdGroups
   */
  public List<AdGroup> getAdGroups() {
    List<AdGroup> adGroups = new ArrayList<>();
    if (this.valuesHolder.getAdGroupValuesList().size() == 0) {
      return adGroups;
    }
    for (AdGroupValues adGroupValues : this.valuesHolder.getAdGroupValuesList()) {
      adGroups.add(adGroupValues.getAdGroup());
    }
    return adGroups;
  }

  /**
   * @return AdGroupIds
   */
  public List<Long> getAdGroupIds() {
    List<Long> adGroupIds = new ArrayList<>();
    if (this.valuesHolder.getAdGroupValuesList().size() == 0) {
      return adGroupIds;
    }
    for (AdGroupValues adGroupValues : this.valuesHolder.getAdGroupValuesList()) {
      adGroupIds.add(adGroupValues.getAdGroup().getAdGroupId());
    }
    return adGroupIds;
  }

  /**
   * @param campaignId Long
   * @return Long|null
   */
  public Long findAdGroupId(Long campaignId) {
    if (this.valuesHolder.getAdGroupValuesList().size() == 0) {
      return null;
    }
    for (AdGroupValues adGroupValues : this.valuesHolder.getAdGroupValuesList()) {
      if (adGroupValues.getAdGroup().getCampaignId() == campaignId) {
        return adGroupValues.getAdGroup().getAdGroupId();
      }
    }
    return null;
  }
}
