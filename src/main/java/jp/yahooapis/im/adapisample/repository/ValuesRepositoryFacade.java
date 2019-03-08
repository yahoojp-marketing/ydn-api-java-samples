/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.repository;

import jp.yahooapis.im.adapisample.util.ValuesHolder;

/**
 * Utility method collection for Java Sample Program.
 */
public class ValuesRepositoryFacade {

  private ValuesHolder valuesHolder;
  private CampaignValuesRepository campaignValuesRepository;
  private AdGroupValuesRepository adGroupValuesRepository;
  private AdGroupAdValuesRepository adGroupAdValuesRepository;
  private PlacementUrlListValuesRepository placementUrlListValuesRepository;
  private SearchKeywordListValuesRepository searchKeywordListValuesRepository;
  private MediaValuesRepository mediaValuesRepository;
  private LabelValuesRepository labelValuesRepository;
  private ReportDefinitionValuesRepository reportDefinitionValuesRepository;
  private RetargetingTagValuesRepository retargetingTagValuesRepository;
  private FeedHolderValuesRepository feedHolderValuesRepository;

  /**
   * ValuesRepositoryFacade constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public ValuesRepositoryFacade(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
    this.campaignValuesRepository = new CampaignValuesRepository(this.valuesHolder);
    this.adGroupValuesRepository = new AdGroupValuesRepository(this.valuesHolder);
    this.adGroupAdValuesRepository = new AdGroupAdValuesRepository(this.valuesHolder);
    this.placementUrlListValuesRepository = new PlacementUrlListValuesRepository(this.valuesHolder);
    this.searchKeywordListValuesRepository = new SearchKeywordListValuesRepository(this.valuesHolder);
    this.mediaValuesRepository = new MediaValuesRepository(this.valuesHolder);
    this.labelValuesRepository = new LabelValuesRepository(this.valuesHolder);
    this.reportDefinitionValuesRepository = new ReportDefinitionValuesRepository(this.valuesHolder);
    this.retargetingTagValuesRepository = new RetargetingTagValuesRepository(this.valuesHolder);
    this.feedHolderValuesRepository = new FeedHolderValuesRepository(this.valuesHolder);
  }

  /**
   * @return ValuesHolder
   */
  public ValuesHolder getValuesHolder() {
    return valuesHolder;
  }

  /**
   * @return CampaignValuesRepository
   */
  public CampaignValuesRepository getCampaignValuesRepository() {
    return campaignValuesRepository;
  }

  /**
   * @return AdGroupValuesRepository
   */
  public AdGroupValuesRepository getAdGroupValuesRepository() {
    return adGroupValuesRepository;
  }

  /**
   * @return AdGroupAdValuesRepository
   */
  public AdGroupAdValuesRepository getAdGroupAdValuesRepository() {
    return adGroupAdValuesRepository;
  }

  /**
   * @return PlacementUrlListValuesRepository
   */
  public PlacementUrlListValuesRepository getPlacementUrlListValuesRepository() {
    return placementUrlListValuesRepository;
  }

  /**
   * @return SearchKeywordListValuesRepository
   */
  public SearchKeywordListValuesRepository getSearchKeywordListValuesRepository() {
    return searchKeywordListValuesRepository;
  }

  /**
   * @return MediaValuesRepository
   */
  public MediaValuesRepository getMediaValuesRepository() {
    return mediaValuesRepository;
  }

  /**
   * @return LabelValuesRepository
   */
  public LabelValuesRepository getLabelValuesRepository() {
    return labelValuesRepository;
  }

  /**
   * @return ReportDefinitionValuesRepository
   */
  public ReportDefinitionValuesRepository getReportDefinitionValuesRepository() {
    return reportDefinitionValuesRepository;
  }

  /**
   * @return RetargetingTagValuesRepository
   */
  public RetargetingTagValuesRepository getRetargetingTagValuesRepository() {
    return retargetingTagValuesRepository;
  }

  /**
   * @return FeedHolderValuesRepository
   */
  public FeedHolderValuesRepository getFeedHolderValuesRepository() {
    return feedHolderValuesRepository;
  }
}
