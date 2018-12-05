package jp.co.yahoo.ad_api_sample.statsSample;

import jp.co.yahoo.ad_api_sample.error.impl.ErrorEntityFactoryImpl;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201812.Paging;
import jp.yahooapis.im.v201812.stats.Period;
import jp.yahooapis.im.v201812.stats.Stats;
import jp.yahooapis.im.v201812.stats.StatsPage;
import jp.yahooapis.im.v201812.stats.StatsPeriod;
import jp.yahooapis.im.v201812.stats.StatsPeriodCustomDate;
import jp.yahooapis.im.v201812.stats.StatsSelector;
import jp.yahooapis.im.v201812.stats.StatsService;
import jp.yahooapis.im.v201812.stats.StatsServiceInterface;
import jp.yahooapis.im.v201812.stats.StatsType;
import jp.yahooapis.im.v201812.stats.StatsValues;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

      // request
      StatsSelector statsListSelector = createSampleGetCampaignStatsRequest(accountId, campaignId);
      // call API
      get(statsListSelector);

      // request use CustomDate
      StatsSelector statsListSelectorCustomDate = createSampleGetCampaignStatsCustomDateRequest(accountId, campaignId);
      // call API
      get(statsListSelectorCustomDate);

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
    Holder<List<jp.yahooapis.im.v201812.Error>> getStatsErrorHolder = new Holder<List<jp.yahooapis.im.v201812.Error>>();
    statsListService.get(selector, getStatsPageHolder, getStatsErrorHolder);

    // if error
    if (getStatsErrorHolder.value != null && getStatsErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(getStatsErrorHolder.value), true);
    }

    // response
    if (getStatsPageHolder.value != null) {
      if (null != getStatsPageHolder.value.getPeriod()) {
        displayPeriod(getStatsPageHolder.value.getPeriod());
      }
      for (StatsValues values : getStatsPageHolder.value.getValues()) {
        if (values.isOperationSucceeded()) {
          displayStatsValues(values);
        } else {
          SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
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
  public static StatsSelector createSampleGetCampaignStatsRequest(long accountId, long campaignId) {
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
   * create sample request.
   * use CustomDate
   *
   * @param accountId  long
   * @param campaignId long
   * @return StatsSelector
   */
  public static StatsSelector createSampleGetCampaignStatsCustomDateRequest(long accountId, long campaignId) {
    // Set Selector
    StatsSelector selector = new StatsSelector();
    selector.setAccountId(accountId);
    selector.getCampaignIds().add(campaignId);
    selector.setStatsPeriod(StatsPeriod.CUSTOM_DATE);

    StatsPeriodCustomDate statsPeriodCustomDate = new StatsPeriodCustomDate();
    statsPeriodCustomDate.setStatsStartDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()));
    statsPeriodCustomDate.setStatsEndDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now().plusMonths(1L)));
    selector.setStatsPeriodCustomDate(statsPeriodCustomDate);

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;

  }


  /**
   * display Period entity to stdout.
   *
   * @param period Period entity for display.
   */
  private static void displayPeriod(Period period) {
    if(null != period.getPeriodStartDate()){
      System.out.println("periodStartDate/periodDate = " + period.getPeriodStartDate().getPeriodDate());
      System.out.println("periodStartDate/periodTime = " + period.getPeriodStartDate().getPeriodTime());
    }

    if(null != period.getPeriodEndDate()){
      System.out.println("periodEndDate/periodDate = " + period.getPeriodEndDate().getPeriodDate());
      System.out.println("periodEndDate/periodTime = " + period.getPeriodEndDate().getPeriodTime());
    }
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
      System.out.println("stats / conversions = " + stats.getConversions());
      System.out.println("stats / conversionRate = " + stats.getConversionRate());
      System.out.println("stats / cpa = " + stats.getCpa());
      System.out.println("stats / conversionValue = " + stats.getConversionValue());
      System.out.println("stats / valuePerConversions = " + stats.getValuePerConversions());
      System.out.println("stats / conversionsViaAdClick = " + stats.getConversionsViaAdClick());
      System.out.println("stats / conversionRateViaAdClick = " + stats.getConversionRateViaAdClick());
      System.out.println("stats / cpaViaAdClick = " + stats.getCpaViaAdClick());
      System.out.println("stats / conversionValueViaAdClick = " + stats.getConversionValueViaAdClick());
      System.out.println("stats / valuePerConversionsViaAdClick = " + stats.getValuePerConversionsViaAdClick());
      System.out.println("stats / allConversions = " + stats.getAllConversions());
      System.out.println("stats / allConversionRate = " + stats.getAllConversionRate());
      System.out.println("stats / allCpa = " + stats.getAllCpa());
      System.out.println("stats / allConversionValue = " + stats.getAllConversionValue());
      System.out.println("stats / valuePerAllConversions = " + stats.getValuePerAllConversions());
      System.out.println("stats / crossDeviceConversions = " + stats.getCrossDeviceConversions());
      System.out.println("stats / avgDeliverRank = " + stats.getAvgDeliverRank());
      System.out.println("stats / totalVimps = " + stats.getTotalVimps());
      System.out.println("stats / vImps = " + stats.getVImps());
      System.out.println("stats / inViewClickCnt = " + stats.getInViewClickCnt());
      System.out.println("stats / inViewRate = " + stats.getInViewRate());
      System.out.println("stats / inViewClickRate = " + stats.getInViewClickRate());
      if (Objects.equals(statsValues.getStatsType(), StatsType.VIDEO)) {
        System.out.println("stats / paidVideoViews = " + stats.getPaidVideoViews());
        System.out.println("stats / paidVideoViewRate = " + stats.getPaidVideoViewRate());
        System.out.println("stats / averageCpv = " + stats.getAverageCpv());
        System.out.println("stats / videoViewsTo25 = " + stats.getVideoViewsTo25());
        System.out.println("stats / videoViewsTo50 = " + stats.getVideoViewsTo50());
        System.out.println("stats / videoViewsTo75 = " + stats.getVideoViewsTo75());
        System.out.println("stats / videoViewsTo95 = " + stats.getVideoViewsTo95());
        System.out.println("stats / videoViewsTo100 = " + stats.getVideoViewsTo100());
        System.out.println("stats / videoViewsTo3Sec = " + stats.getVideoViewsTo3Sec());
        System.out.println("stats / averageRateVideoViewed = " + stats.getAverageRateVideoViewed());
        System.out.println("stats / averageDurationVideoViewe = " + stats.getAverageDurationVideoViewed());
      }
    }
    System.out.println("---------");
  }
}
