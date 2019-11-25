/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.stats;

import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.v201911.Error;
import jp.yahooapis.im.v201911.Paging;
import jp.yahooapis.im.v201911.stats.StatsPage;
import jp.yahooapis.im.v201911.stats.StatsPeriod;
import jp.yahooapis.im.v201911.stats.StatsPeriodCustomDate;
import jp.yahooapis.im.v201911.stats.StatsSelector;
import jp.yahooapis.im.v201911.stats.StatsService;
import jp.yahooapis.im.v201911.stats.StatsServiceInterface;
import jp.yahooapis.im.v201911.stats.StatsType;
import jp.yahooapis.im.v201911.stats.StatsValues;
import jp.yahooapis.im.v201911.stats.TargetType;

import java.util.List;

import javax.xml.ws.Holder;

/**
 * example StatsService operation and Utility method collection.
 */
public class StatsServiceSample {

  /**
   * example StatsService operation.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();

      // =================================================================
      // StatsService GET (Target)
      // =================================================================
      // create request.
      StatsSelector getRequestTarget = buildExampleGetRequest(accountId, StatsType.TARGET, null);

      // run
      get(getRequestTarget);

      // =================================================================
      // StatsService GET (Campaign)
      // =================================================================
      // create request.
      StatsSelector getRequestCampaign = buildExampleGetRequest(accountId, StatsType.CAMPAIGN, null);

      // run
      get(getRequestCampaign);

      // =================================================================
      // StatsService GET (AdGroup)
      // =================================================================
      // create request.
      StatsSelector getRequestAdGroup = buildExampleGetRequest(accountId, StatsType.ADGROUP, null);

      // run
      get(getRequestAdGroup);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example get stats.
   *
   * @param selector StatsSelector
   * @return StatsValues
   */
  public static List<StatsValues> get(StatsSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("StatsService::get");
    System.out.println("############################################");

    Holder<StatsPage> statsPageHolder = new Holder<StatsPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    StatsServiceInterface statsListService = SoapUtils.createServiceInterface(StatsServiceInterface.class, StatsService.class);
    statsListService.get(selector, statsPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, statsPageHolder.value.getValues());

    // Response
    return statsPageHolder.value.getValues();
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @param statsType StatsType
   * @param targetId  long
   * @return StatsSelector
   */
  public static StatsSelector buildExampleGetRequest(long accountId, StatsType statsType, Long targetId) {
    StatsSelector selector = new StatsSelector();
    selector.setAccountId(accountId);
    selector.setStatsType(statsType);

    switch (statsType) {
      case CAMPAIGN:
        if (targetId != null) {
          selector.getCampaignIds().add(targetId);
        }
        break;
      case ADGROUP:
        if (targetId != null) {
          selector.getAdGroupIds().add(targetId);
        }
        break;
      case TARGET:
        selector.setStatsPeriod(StatsPeriod.CUSTOM_DATE);
        StatsPeriodCustomDate statsPeriodCustomDate = new StatsPeriodCustomDate();
        statsPeriodCustomDate.setStatsStartDate("20201231");
        statsPeriodCustomDate.setStatsEndDate("20301231");
        selector.setStatsPeriodCustomDate(statsPeriodCustomDate);
        selector.getTargetTypes().add(TargetType.AD_SCHEDULE_TARGET);
        break;
    }

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
}
