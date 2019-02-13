package jp.co.yahoo.ad_api_sample.feedDataSample;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201812.Paging;
import jp.yahooapis.im.v201812.feeddata.FeedDataSelector;
import jp.yahooapis.im.v201812.feeddata.FeedDataValues;
import jp.yahooapis.im.v201812.feeddata.UploadUrlValue;
import jp.yahooapis.im.v201812.feedholder.FeedHolderOperation;
import jp.yahooapis.im.v201812.feedholder.FeedHolderValues;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Sample TestCase for FeedDataSampleTest.<br>
 * Copyright (C) 2016 Yahoo Japan Corporation. All Rights Reserved.
 */
public class FeedDataSampleTest {

  /**
   * Setting
   */
  private long accountId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
  }

  /**
   * Sample TestCase of main method for FeedDataSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      FeedDataSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of main getUploadUrl for FeedDataSample.
   */
  @Test
  public void testGetUploadUrl() throws Exception {
    // Run
    UploadUrlValue uploadUrlValue = null;
    List<FeedHolderValues> addFeedHolderValues = null;
    long feedHolderId = -1;
    try {
      // add FeedHolder
      FeedHolderOperation addFeedHolderOperation = FeedHolderSample.createSampleAddRequest(accountId);
      addFeedHolderValues = FeedHolderSample.add(addFeedHolderOperation);

      for (FeedHolderValues feedHolderValue : addFeedHolderValues) {
        feedHolderId = feedHolderValue.getFeedHolder().getFeedHolderId();
      }

      uploadUrlValue = FeedDataSample.getUploadUrl(accountId, feedHolderId);
    } catch (Exception e) {
      fail();
    }

    // Assert
    assertThat(uploadUrlValue.getAccountId(), is(notNullValue()));
    assertThat(uploadUrlValue.getUploadUrl(), is(notNullValue()));

    // clean
    cleanFeedHolder(addFeedHolderValues);
  }

  /**
   * Sample TestCase of main upload for FeedDataSample.
   */
  @Test
  public void testUpload() throws Exception {
    // Run
    long itemListUploadId = -1;
    List<FeedHolderValues> addFeedHolderValues = null;
    long feedHolderId = -1;
    try {
      // add FeedHolder
      FeedHolderOperation addFeedHolderOperation = FeedHolderSample.createSampleAddRequest(accountId);
      addFeedHolderValues = FeedHolderSample.add(addFeedHolderOperation);

      for (FeedHolderValues feedHolderValue : addFeedHolderValues) {
        feedHolderId = feedHolderValue.getFeedHolder().getFeedHolderId();
      }

      UploadUrlValue uploadUrlValue = FeedDataSample.getUploadUrl(accountId, feedHolderId);
      itemListUploadId = FeedDataSample.upload(uploadUrlValue.getUploadUrl());
    } catch (Exception e) {
      fail();
    }

    // Assert
    assertThat(itemListUploadId, is(not(-1)));

    // clean
    cleanFeedHolder(addFeedHolderValues);
  }

  /**
   * Sample TestCase of main getFeedDataStatus for FeedDataSample.
   */
  @Test
  public void testGetFeedDataStatus() throws Exception {
    // setup
    long itemListUploadId = -1;
    long feedHolderId = -1;
    List<FeedHolderValues> addFeedHolderValues = null;
    try {
      // add FeedHolder
      FeedHolderOperation addFeedHolderOperation = FeedHolderSample.createSampleAddRequest(accountId);
      addFeedHolderValues = FeedHolderSample.add(addFeedHolderOperation);

      for (FeedHolderValues feedHolderValue : addFeedHolderValues) {
        feedHolderId = feedHolderValue.getFeedHolder().getFeedHolderId();
      }

      UploadUrlValue uploadUrlValue = FeedDataSample.getUploadUrl(accountId, feedHolderId);
      itemListUploadId = FeedDataSample.upload(uploadUrlValue.getUploadUrl());
    } catch (Exception e) {
      fail();
    }

    // Set Selector
    FeedDataSelector selector = new FeedDataSelector();
    selector.setAccountId(accountId);
    selector.getItemListUploadIds().add(itemListUploadId);
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    // Run
    List<FeedDataValues> getFeedDataResponse = null;
    try {
      getFeedDataResponse = FeedDataSample.getFeedDataUploadStatus(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (FeedDataValues bulkUploadValues : getFeedDataResponse) {
      assertThat(bulkUploadValues.isOperationSucceeded(), is(true));
      assertThat(bulkUploadValues.getFeedData().getAccountId(), is(notNullValue()));
    }

    // clean
    cleanFeedHolder(addFeedHolderValues);
  }

  /**
   * clean
   */
  public void cleanFeedHolder(List<FeedHolderValues> feedHolderValues) {
    try {
      FeedHolderOperation removeFeedHolderOperation = FeedHolderSample.createSampleRemoveRequest(accountId, feedHolderValues);
      FeedHolderSample.remove(removeFeedHolderOperation);
    } catch (Exception e) {
      fail();
    }
  }
}
