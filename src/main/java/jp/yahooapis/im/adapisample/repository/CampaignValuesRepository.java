/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.repository;

import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201903.campaign.Campaign;
import jp.yahooapis.im.v201903.campaign.CampaignType;
import jp.yahooapis.im.v201903.campaign.CampaignValues;
import jp.yahooapis.im.v201903.campaign.DeviceOsType;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class CampaignValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * CampaignValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public CampaignValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return Campaigns
   */
  public List<Campaign> getCampaigns() {
    List<Campaign> campaigns = new ArrayList<>();
    if (this.valuesHolder.getCampaignValuesList().size() == 0) {
      return campaigns;
    }
    for (CampaignValues campaignValues : this.valuesHolder.getCampaignValuesList()) {
      campaigns.add(campaignValues.getCampaign());
    }
    return campaigns;
  }

  /**
   * @return CampaignIds
   */
  public List<Long> getCampaignIds() {
    List<Long> campaignIds = new ArrayList<>();
    if (this.valuesHolder.getCampaignValuesList().size() == 0) {
      return campaignIds;
    }
    for (CampaignValues campaignValues : this.valuesHolder.getCampaignValuesList()) {
      campaignIds.add(campaignValues.getCampaign().getCampaignId());
    }
    return campaignIds;
  }

  /**
   * @param campaignType CampaignType
   * @return Long|null
   */
  public Long findCampaignId(CampaignType campaignType) {
    if (this.valuesHolder.getCampaignValuesList().size() == 0) {
      return null;
    }
    for (CampaignValues campaignValues : this.valuesHolder.getCampaignValuesList()) {
      if (campaignValues.getCampaign().getCampaignType().equals(campaignType)) {
        return campaignValues.getCampaign().getCampaignId();
      }
    }
    return null;
  }

  /**
   * @param osType DeviceOsType
   * @return Long|null
   */
  public Long findCampaignId(DeviceOsType osType) {
    if (this.valuesHolder.getCampaignValuesList().size() == 0) {
      return null;
    }
    for (CampaignValues campaignValues : this.valuesHolder.getCampaignValuesList()) {
      if (campaignValues.getCampaign().getCampaignType().equals(CampaignType.APP) && campaignValues.getCampaign().getAppOs().equals(osType)) {
        return campaignValues.getCampaign().getCampaignId();
      }
    }
    return null;
  }

  /**
   * @param campaignId Long
   * @return String|null
   */
  public String findAppId(Long campaignId) {
    if (this.valuesHolder.getCampaignValuesList().size() == 0) {
      return null;
    }
    for (CampaignValues campaignValues : this.valuesHolder.getCampaignValuesList()) {
      if (campaignValues.getCampaign().getCampaignId().equals(campaignId)) {
        return campaignValues.getCampaign().getAppId();
      }
    }
    return null;
  }
}
