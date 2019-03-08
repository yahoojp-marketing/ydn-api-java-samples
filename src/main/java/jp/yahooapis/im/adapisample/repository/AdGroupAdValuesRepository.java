/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.repository;

import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201903.adgroupad.AdGroupAd;
import jp.yahooapis.im.v201903.adgroupad.AdGroupAdValues;
import jp.yahooapis.im.v201903.adgroupad.AdType;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class AdGroupAdValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * AdGroupAdValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public AdGroupAdValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return AdGroupAds
   */
  public List<AdGroupAd> getAdGroupAds() {
    List<AdGroupAd> adGroupAds = new ArrayList<>();
    if (this.valuesHolder.getAdGroupAdValuesList().size() == 0) {
      return adGroupAds;
    }
    for (AdGroupAdValues adGroupAdValues : this.valuesHolder.getAdGroupAdValuesList()) {
      adGroupAds.add(adGroupAdValues.getAdGroupAd());
    }
    return adGroupAds;
  }

  /**
   * @return AdIds
   */
  public List<Long> getAdIds() {
    List<Long> adIds = new ArrayList<>();
    if (this.valuesHolder.getAdGroupAdValuesList().size() == 0) {
      return adIds;
    }
    for (AdGroupAdValues adGroupAdValues : this.valuesHolder.getAdGroupAdValuesList()) {
      adIds.add(adGroupAdValues.getAdGroupAd().getAdId());
    }
    return adIds;
  }

  /**
   * @param campaignId Long
   * @param adGroupId  Long
   * @param adType     AdType
   * @return Long|null
   */
  public Long findAdId(Long campaignId, Long adGroupId, AdType adType) {
    if (this.valuesHolder.getAdGroupAdValuesList().size() == 0) {
      return null;
    }
    for (AdGroupAdValues adGroupAdValues : this.valuesHolder.getAdGroupAdValuesList()) {
      if (adGroupAdValues.getAdGroupAd().getCampaignId() == campaignId && adGroupAdValues.getAdGroupAd().getAdGroupId() == adGroupId && adGroupAdValues.getAdGroupAd().getAd().getType()
          .equals(adType)) {
        return adGroupAdValues.getAdGroupAd().getAdId();
      }
    }
    return null;
  }
}
