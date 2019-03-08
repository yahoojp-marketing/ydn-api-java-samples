/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.util;


import jp.yahooapis.im.v201903.adgroup.AdGroupValues;
import jp.yahooapis.im.v201903.adgroupad.AdGroupAdValues;
import jp.yahooapis.im.v201903.campaign.CampaignValues;
import jp.yahooapis.im.v201903.feedholder.FeedHolderValues;
import jp.yahooapis.im.v201903.label.LabelValues;
import jp.yahooapis.im.v201903.media.MediaValues;
import jp.yahooapis.im.v201903.placementurlidea.PlacementUrlIdeaValues;
import jp.yahooapis.im.v201903.placementurllist.PlacementUrlListValues;
import jp.yahooapis.im.v201903.reportdefinition.ReportDefinitionValues;
import jp.yahooapis.im.v201903.retargetingtag.RetargetingTagValues;
import jp.yahooapis.im.v201903.searchkeywordidea.SearchKeywordIdeaValues;
import jp.yahooapis.im.v201903.searchkeywordlist.SearchKeywordListValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class ValuesHolder {

  private List<CampaignValues> campaignValuesList = new ArrayList<>();

  /**
   * @return CampaignValueList
   */
  public List<CampaignValues> getCampaignValuesList()
  {
    return campaignValuesList;
  }

  /**
   * @param campaignValuesList CampaignValueList
   */
  public void setCampaignValuesList(List<CampaignValues> campaignValuesList)
  {
    if (this.campaignValuesList.size() == 0) {
      this.campaignValuesList = campaignValuesList;
    } else {
      if (campaignValuesList.size() > 0) {
        this.campaignValuesList.addAll(campaignValuesList);
      } else {
        this.campaignValuesList = campaignValuesList;
      }
    }
  }

  private List<AdGroupValues> adGroupValuesList = new ArrayList<>();

  /**
   * @return AdGroupValueList
   */
  public List<AdGroupValues> getAdGroupValuesList()
  {
    return this.adGroupValuesList;
  }

  /**
   * @param adGroupValuesList AdGroupValuesList
   */
  public void setAdGroupValuesList(List<AdGroupValues> adGroupValuesList)
  {
    this.adGroupValuesList.addAll(adGroupValuesList);
  }

  private List<AdGroupAdValues> adGroupAdValuesList = new ArrayList<>();

  /**
   * @return AdGroupAdValueList
   */
  public List<AdGroupAdValues> getAdGroupAdValuesList()
  {
    return this.adGroupAdValuesList;
  }

  /**
   * @param adGroupAdValuesList AdGroupAdValuesList
   */
  public void setAdGroupAdValuesList(List<AdGroupAdValues> adGroupAdValuesList)
  {
    this.adGroupAdValuesList.addAll(adGroupAdValuesList);
  }

  private List<PlacementUrlIdeaValues> placementUrlIdeaValuesList = new ArrayList<>();

  /**
   * @return PlacementUrlIdeaValueList
   */
  public List<PlacementUrlIdeaValues> getPlacementUrlIdeaValuesList()
  {
    return this.placementUrlIdeaValuesList;
  }

  /**
   * @param placementUrlIdeaValuesList PlacementUrlIdeaValuesList
   */
  public void setPlacementUrlIdeaValuesList(List<PlacementUrlIdeaValues> placementUrlIdeaValuesList)
  {
    this.placementUrlIdeaValuesList.addAll(placementUrlIdeaValuesList);
  }

  private List<PlacementUrlListValues> placementUrlListValuesList = new ArrayList<>();

  /**
   * @return PlacementUrlListValueList
   */
  public List<PlacementUrlListValues> getPlacementUrlListValuesList()
  {
    return this.placementUrlListValuesList;
  }

  /**
   * @param placementUrlListValuesList PlacementUrlListValuesList
   */
  public void setPlacementUrlListValuesList(List<PlacementUrlListValues> placementUrlListValuesList)
  {
    if (placementUrlListValuesList.size() > 0) {
      this.placementUrlListValuesList.addAll(placementUrlListValuesList);
    } else {
      this.placementUrlListValuesList = placementUrlListValuesList;
    }
  }

  private List<SearchKeywordIdeaValues> searchKeywordIdeaValuesList = new ArrayList<>();

  /**
   * @return SearchKeywordIdeaValueList
   */
  public List<SearchKeywordIdeaValues> getSearchKeywordIdeaValuesList()
  {
    return this.searchKeywordIdeaValuesList;
  }

  /**
   * @param searchKeywordIdeaValuesList SearchKeywordIdeaValuesList
   */
  public void setSearchKeywordIdeaValuesList(List<SearchKeywordIdeaValues> searchKeywordIdeaValuesList)
  {
    this.searchKeywordIdeaValuesList.addAll(searchKeywordIdeaValuesList);
  }

  private List<SearchKeywordListValues> searchKeywordListValuesList = new ArrayList<>();

  /**
   * @return SearchKeywordListValueList
   */
  public List<SearchKeywordListValues> getSearchKeywordListValuesList()
  {
    return this.searchKeywordListValuesList;
  }

  /**
   * @param searchKeywordListValuesList SearchKeywordListValuesList
   */
  public void setSearchKeywordListValuesList(List<SearchKeywordListValues> searchKeywordListValuesList)
  {
    if (searchKeywordListValuesList.size() > 0) {
      this.searchKeywordListValuesList.addAll(searchKeywordListValuesList);
    } else {
      this.searchKeywordListValuesList = searchKeywordListValuesList;
    }
  }

  private List<MediaValues> mediaValuesList = new ArrayList<>();

  /**
   * @return MediaValueList
   */
  public List<MediaValues> getMediaValuesList()
  {
    return this.mediaValuesList;
  }

  /**
   * @param mediaValuesList MediaValuesList
   */
  public void setMediaValuesList(List<MediaValues> mediaValuesList)
  {
    if (mediaValuesList.size() > 0) {
      this.mediaValuesList.addAll(mediaValuesList);
    } else {
      this.mediaValuesList = mediaValuesList;
    }
  }

  private List<LabelValues> labelValuesList = new ArrayList<>();

  /**
   * @return LabelValueList
   */
  public List<LabelValues> getLabelValuesList()
  {
    return this.labelValuesList;
  }

  /**
   * @param labelValuesList LabelValuesList
   */
  public void setLabelValuesList(List<LabelValues> labelValuesList)
  {
    if (labelValuesList.size() > 0) {
      this.labelValuesList.addAll(labelValuesList);
    } else {
      this.labelValuesList = labelValuesList;
    }
  }

  private List<ReportDefinitionValues> reportDefinitionValuesList = new ArrayList<>();

  /**
   * @return ReportDefinitionValueList
   */
  public List<ReportDefinitionValues> getReportDefinitionValuesList()
  {
    return this.reportDefinitionValuesList;
  }

  /**
   * @param reportDefinitionValuesList ReportDefinitionValuesList
   */
  public void setReportDefinitionValuesList(List<ReportDefinitionValues> reportDefinitionValuesList)
  {
    this.reportDefinitionValuesList.addAll(reportDefinitionValuesList);
  }

  private List<RetargetingTagValues> retargetingTagValuesList = new ArrayList<>();

  /**
   * @return RetargetingTagValueList
   */
  public List<RetargetingTagValues> getRetargetingTagValuesList()
  {
    return this.retargetingTagValuesList;
  }

  /**
   * @param retargetingTagValuesList RetargetingTagValuesList
   */
  public void setRetargetingTagValuesList(List<RetargetingTagValues> retargetingTagValuesList)
  {
    this.retargetingTagValuesList.addAll(retargetingTagValuesList);
  }

  private List<FeedHolderValues> feedHolderValuesList = new ArrayList<>();

  /**
   * @return FeedHolderValuesList
   */
  public List<FeedHolderValues> getFeedHolderValuesList()
  {
    return this.feedHolderValuesList;
  }

  /**
   * @param feedHolderValuesList FeedHolderValuesList
   */
  public void setFeedHolderValuesList(List<FeedHolderValues> feedHolderValuesList)
  {
    this.feedHolderValuesList.addAll(feedHolderValuesList);
  }

}
