package jp.co.yahoo.ad_api_sample.statsSample;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.V6.StatsService.Paging;
import jp.yahooapis.im.V6.StatsService.StatsSelector;
import jp.yahooapis.im.V6.StatsService.StatsType;
import jp.yahooapis.im.V6.StatsService.StatsValues;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Sample TestCase for StatsSampleTest.<br>
 * Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class StatsSampleTest {

  /**
   * Setting
   */
  private long accountId;
  private long campaignId;
  private long adGroupId;
  private long adId;
  private long mediaId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
    campaignId = SoapUtils.getCampaignId();
    adGroupId = SoapUtils.getAdGroupId();
    adId = SoapUtils.getAdId();
    mediaId = SoapUtils.getMediaId();
  }


  /**
   * Sample TestCase of main method for StatsSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
    } catch (Exception e) {
      StatsSample.main(null);
      fail();
    }
  }

  /**
   * Sample TestCase of get method for CampaignStatsSample .
   */
  @Test
  public void testGetCampaignStats() throws Exception {
    // Set Selector
    StatsSelector selector = new StatsSelector();
    selector.setAccountId(accountId);
    selector.getCampaignIds().add(campaignId);
    selector.setStatsType(StatsType.CAMPAIGN);

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    System.out.println("############################################");
    System.out.println("StatsService::get CampaignStats");
    System.out.println("############################################");

    // Run
    List<StatsValues> statsValues = null;
    try {
      statsValues = StatsSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (StatsValues statsValue : statsValues) {
      assertThat(statsValue.isOperationSucceeded(), is(true));
    }
  }

  /**
   * Sample TestCase of get method for AdGroupStatsSample .
   */
  @Test
  public void testGetAdGroupStats() throws Exception {
    // Set Selector
    StatsSelector selector = new StatsSelector();
    selector.setAccountId(accountId);
    selector.getCampaignIds().add(campaignId);
    selector.getAdGroupIds().add(adGroupId);
    selector.setStatsType(StatsType.ADGROUP);

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    System.out.println("############################################");
    System.out.println("StatsService::get AdGroupStats");
    System.out.println("############################################");

    // Run
    List<StatsValues> statsValues = null;
    try {
      statsValues = StatsSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (StatsValues statsValue : statsValues) {
      assertThat(statsValue.isOperationSucceeded(), is(true));
    }
  }

  /**
   * Sample TestCase of get method for AdGroupAdStatsSample .
   */
  @Test
  public void testGetAdGroupAdStats() throws Exception {
    // Set Selector
    StatsSelector selector = new StatsSelector();
    selector.setAccountId(accountId);
    selector.getCampaignIds().add(campaignId);
    selector.getAdGroupIds().add(adGroupId);
    selector.getAdIds().add(adId);
    selector.setStatsType(StatsType.AD);

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    System.out.println("############################################");
    System.out.println("StatsService::get AdGroupAdStats");
    System.out.println("############################################");

    // Run
    List<StatsValues> statsValues = null;
    try {
      statsValues = StatsSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (StatsValues statsValue : statsValues) {
      assertThat(statsValue.isOperationSucceeded(), is(true));
    }
  }


  /**
   * Sample TestCase of get method for ImageStatsSample .
   */
  @Test
  public void testGetImageStats() throws Exception {
    // Set Selector
    StatsSelector selector = new StatsSelector();
    selector.setAccountId(accountId);
    selector.getCampaignIds().add(campaignId);
    selector.getAdGroupIds().add(adGroupId);
    selector.getAdIds().add(adId);
    selector.getMediaIds().add(mediaId);
    selector.setStatsType(StatsType.IMAGE);

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    System.out.println("############################################");
    System.out.println("StatsService::get ImageStats");
    System.out.println("############################################");

    // Run
    List<StatsValues> statsValues = null;
    try {
      statsValues = StatsSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (StatsValues statsValue : statsValues) {
      assertThat(statsValue.isOperationSucceeded(), is(true));
    }
  }

  /**
   * Sample TestCase of get method for VideoStatsSample .
   */
  @Test
  public void testGetVideoStats() throws Exception {
    // Set Selector
    StatsSelector selector = new StatsSelector();
    selector.setAccountId(accountId);
    selector.getCampaignIds().add(campaignId);
    selector.getAdGroupIds().add(adGroupId);
    selector.getAdIds().add(adId);
    selector.getMediaIds().add(mediaId);
    selector.setStatsType(StatsType.VIDEO);

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    System.out.println("############################################");
    System.out.println("StatsService::get VideoStats");
    System.out.println("############################################");

    // Run
    List<StatsValues> statsValues = null;
    try {
      statsValues = StatsSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (StatsValues statsValue : statsValues) {
      assertThat(statsValue.isOperationSucceeded(), is(true));
    }
  }
}
