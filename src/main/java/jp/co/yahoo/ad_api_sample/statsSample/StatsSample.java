package jp.co.yahoo.ad_api_sample.statsSample;

import jp.co.yahoo.ad_api_sample.error.impl.StatsServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.V6.StatsService.Paging;
import jp.yahooapis.im.V6.StatsService.Stats;
import jp.yahooapis.im.V6.StatsService.StatsPage;
import jp.yahooapis.im.V6.StatsService.StatsSelector;
import jp.yahooapis.im.V6.StatsService.StatsService;
import jp.yahooapis.im.V6.StatsService.StatsServiceInterface;
import jp.yahooapis.im.V6.StatsService.StatsType;
import jp.yahooapis.im.V6.StatsService.StatsValues;

import java.util.List;
import java.util.Objects;

import javax.xml.ws.Holder;

/**
 * Sample Program for StatsService.<br>
 * Copyright (C) 2013 Yahoo Japan Corporation. All Rights Reserved.
 */
public class StatsSample {

  /**
   * main method for StatsSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    try {
      long accountId = SoapUtils.getAccountId();
      long campaignId = SoapUtils.getCampaignId();

      // -----------------------------------------------
      // StatsService::get Campaign Stats
      // -----------------------------------------------
      // request
      StatsSelector statsListSelector = createSampleGetCampaginStatsRequest(accountId, campaignId);
      // call API
      get(statsListSelector);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Sample Program for StatsService GET.
   *
   * @param selector StatsSelector
   * @return StatsValues
   */
  public static List<StatsValues> get(StatsSelector selector) throws Exception {

    // =================================================================
    // StatsService
    // =================================================================
    StatsServiceInterface statsListService = SoapUtils.createServiceInterface(StatsServiceInterface.class, StatsService.class);

    System.out.println("############################################");
    System.out.println("StatsService::get");
    System.out.println("############################################");
    Holder<StatsPage> getStatsPageHolder = new Holder<StatsPage>();
    Holder<List<jp.yahooapis.im.V6.StatsService.Error>> getStatsErrorHolder = new Holder<List<jp.yahooapis.im.V6.StatsService.Error>>();
    statsListService.get(selector, getStatsPageHolder, getStatsErrorHolder);

    // if error
    if (getStatsErrorHolder.value != null && getStatsErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new StatsServiceErrorEntityFactory(getStatsErrorHolder.value), true);
    }

    // response
    if (getStatsPageHolder.value != null) {
      for (StatsValues values : getStatsPageHolder.value.getValues()) {
        if (values.isOperationSucceeded()) {
          displayStatsValues(values);
        } else {
          SoapUtils.displayErrors(new StatsServiceErrorEntityFactory(values.getError()), true);
        }
      }
    }

    // Response
    return getStatsPageHolder.value.getValues();
  }


  /**
   * create sample request.
   *
   * @param accountId  long
   * @param campaignId long
   * @return StatsSelector
   */
  public static StatsSelector createSampleGetCampaginStatsRequest(long accountId, long campaignId) {
    // Set Selector
    StatsSelector selector = new StatsSelector();
    selector.setAccountId(accountId);
    selector.getCampaignIds().add(campaignId);

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;

  }

  /**
   * display Stats entity to stdout.
   *
   * @param statsValues Stats entity for display.
   */
  private static void displayStatsValues(StatsValues statsValues) {

    System.out.println("accountId = " + statsValues.getAccountId());
    System.out.println("campaignId = " + statsValues.getCampaignId());
    System.out.println("adGroupId = " + statsValues.getAdGroupId());
    System.out.println("adId = " + statsValues.getAdId());
    System.out.println("mediald = " + statsValues.getMediaId());
    System.out.println("statsPeriod = " + statsValues.getStatsPeriod());
    System.out.println("statsType = " + statsValues.getStatsType());
    if (null != statsValues.getStats()) {
      Stats stats = statsValues.getStats();
      System.out.println("stats / imps = " + stats.getImps());
      System.out.println("stats / clickRate = " + stats.getClickRate());
      System.out.println("stats / totalClickCost = " + stats.getTotalClickCost());
      System.out.println("stats / clickCnt = " + stats.getClickCnt());
      System.out.println("stats / avgClickCost = " + stats.getAvgClickCost());
      System.out.println("stats / convCnt = " + stats.getConvCnt());
      System.out.println("stats / convRate = " + stats.getConvRate());
      System.out.println("stats / cpa = " + stats.getCpa());
      System.out.println("stats / avgDeliverRank = " + stats.getAvgDeliverRank());
      System.out.println("stats / totalVimps = " + stats.getTotalVimps());
      System.out.println("stats / vImps = " + stats.getVImps());
      System.out.println("stats / inViewClickCnt = " + stats.getInViewClickCnt());
      System.out.println("stats / inViewRate = " + stats.getInViewRate());
      System.out.println("stats / inViewClickRate = " + stats.getInViewClickRate());
      if (Objects.equals(statsValues.getStatsType(), StatsType.VIDEO)) {
        System.out.println("stats / autoVideoPlays = " + stats.getAutoVideoPlays());
        System.out.println("stats / clickVideoPlays = " + stats.getClickVideoPlays());
        System.out.println("stats / videoViewedRate = " + stats.getVideoViewedRate());
        System.out.println("stats / averageCpv = " + stats.getAverageCpv());
        System.out.println("stats / videoPlays = " + stats.getVideoPlays());
        System.out.println("stats / videoViewsTo25 = " + stats.getVideoViewsTo25());
        System.out.println("stats / videoViewsTo50 = " + stats.getVideoViewsTo50());
        System.out.println("stats / videoViewsTo75 = " + stats.getVideoViewsTo75());
        System.out.println("stats / videoViewsTo95 = " + stats.getVideoViewsTo95());
        System.out.println("stats / videoViewsTo100 = " + stats.getVideoViewsTo100());
        System.out.println("stats / averageRateVideoViewed = " + stats.getAverageRateVideoViewed());
        System.out.println("stats / averageDurationVideoViewe = " + stats.getAverageDurationVideoViewed());
      }
    }
    System.out.println("---------");
  }
}
