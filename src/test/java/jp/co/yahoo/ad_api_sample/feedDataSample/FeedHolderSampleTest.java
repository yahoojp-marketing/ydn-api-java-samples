package jp.co.yahoo.ad_api_sample.feedDataSample;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201812.Paging;
import jp.yahooapis.im.v201812.feedholder.FeedHolderOperation;
import jp.yahooapis.im.v201812.feedholder.FeedHolderSelector;
import jp.yahooapis.im.v201812.feedholder.FeedHolderValues;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;


/**
 * Sample TestCase for FeedHolderSampleTest.<br>
 * Copyright (C) 2016 Yahoo Japan Corporation. All Rights Reserved.
 */
public class FeedHolderSampleTest {

  /**
   * Setting
   */
  private long accountId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
  }

  /**
   * Sample TestCase of main method for FeedHolderSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      FeedHolderSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for FeedHolderSample.
   */
  @Test
  public void testAdd() throws Exception {
    // Set Operation
    FeedHolderOperation feedHolderOperation = FeedHolderSample.createSampleAddRequest(accountId);

    // Run
    List<FeedHolderValues> addFeedHolderValues = null;
    try {
      addFeedHolderValues = FeedHolderSample.add(feedHolderOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (FeedHolderValues addFeedHolderValue : addFeedHolderValues) {
      assertThat(addFeedHolderValue.isOperationSucceeded(), is(true));
      assertThat(addFeedHolderValue.getFeedHolder().getAccountId(), is(notNullValue()));
    }

    clean(addFeedHolderValues);
  }

  /**
   * Sample TestCase of set method for FeedHolderSample.
   */
  @Test
  public void testSet() throws Exception {
    // =================================================================
    // FeedHolderService::ADD
    // =================================================================
    List<FeedHolderValues> addFeedHolderValues = null;
    try {
      FeedHolderOperation addFeedHolderOperation = FeedHolderSample.createSampleAddRequest(accountId);
      addFeedHolderValues = FeedHolderSample.add(addFeedHolderOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // FeedHolderService::SET
    // =================================================================
    // Set Operation
    FeedHolderOperation setFeedHolderOperation = FeedHolderSample.createSampleSetRequest(accountId, addFeedHolderValues);

    // Run
    List<FeedHolderValues> setFeedHolderValues = null;
    try {
      setFeedHolderValues = FeedHolderSample.set(setFeedHolderOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (FeedHolderValues setFeedHolderValue : setFeedHolderValues) {
      assertThat(setFeedHolderValue.isOperationSucceeded(), is(true));
      assertThat(setFeedHolderValue.getFeedHolder().getAccountId(), is(notNullValue()));
    }

    clean(setFeedHolderValues);
  }

  /**
   * Sample TestCase of remove method for FeedHolderSample.
   */
  @Test
  public void testRemove() throws Exception {
    // =================================================================
    // FeedHolderService::ADD
    // =================================================================
    // Run
    List<FeedHolderValues> addFeedHolderValues = null;
    try {
      FeedHolderOperation addFeedHolderOperation = FeedHolderSample.createSampleAddRequest(accountId);
      addFeedHolderValues = FeedHolderSample.add(addFeedHolderOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // FeedHolderService::REMOVE
    // =================================================================
    // Set Operation
    FeedHolderOperation removeFeedHolderOperation = FeedHolderSample.createSampleRemoveRequest(accountId, addFeedHolderValues);

    // Run
    List<FeedHolderValues> removeFeedHolderValues = null;
    try {
      removeFeedHolderValues = FeedHolderSample.remove(removeFeedHolderOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (FeedHolderValues removeFeedHolderValue : removeFeedHolderValues) {
      assertThat(removeFeedHolderValue.isOperationSucceeded(), is(true));
      assertThat(removeFeedHolderValue.getFeedHolder().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of get method for FeedHolderSample.
   */
  @Test
  public void testGet() throws Exception {
    // Set Selector
    FeedHolderSelector feedHolderSelector = new FeedHolderSelector();
    feedHolderSelector.setAccountId(accountId);

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    feedHolderSelector.setPaging(paging);

    // Run
    List<FeedHolderValues> getFeedHolderValues = null;
    try {
      getFeedHolderValues = FeedHolderSample.get(feedHolderSelector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (FeedHolderValues getFeedHolderValue : getFeedHolderValues) {
      assertThat(getFeedHolderValue.isOperationSucceeded(), is(true));
      assertThat(getFeedHolderValue.getFeedHolder().getAccountId(), is(notNullValue()));
    }

  }

  /**
   * clean
   */
  public void clean(List<FeedHolderValues> feedHolderValues) {
    try {
      FeedHolderOperation removeFeedHolderOperation = FeedHolderSample.createSampleRemoveRequest(accountId, feedHolderValues);
      FeedHolderSample.remove(removeFeedHolderOperation);
    } catch (Exception e) {
      fail();
    }
  }
}
