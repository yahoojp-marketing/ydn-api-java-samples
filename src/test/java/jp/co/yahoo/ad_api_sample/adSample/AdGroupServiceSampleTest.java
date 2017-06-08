package jp.co.yahoo.ad_api_sample.adSample;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.V6.AdGroupService.AdGroupOperation;
import jp.yahooapis.im.V6.AdGroupService.AdGroupSelector;
import jp.yahooapis.im.V6.AdGroupService.AdGroupValues;
import jp.yahooapis.im.V6.AdGroupService.Paging;
import jp.yahooapis.im.V6.AdGroupService.UserStatus;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Sample TestCase for AdGroupServiceSampleTest.<br>
 * Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class AdGroupServiceSampleTest {

  /**
   * Setting
   */
  private long accountId;
  private long campaignId;


  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
    campaignId = SoapUtils.getCampaignId();
  }

  /**
   * Sample TestCase of main method for AdGroupServiceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      AdGroupServiceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for AdGroupServiceSample.
   */
  @Test
  public void testAdd() throws Exception {
    // Set Operation
    AdGroupOperation addAdGroupOperation = AdGroupServiceSample.createSampleAddRequest(accountId, campaignId);

    // Run
    List<AdGroupValues> addAdGroupValues = null;
    try {
      addAdGroupValues = AdGroupServiceSample.add(addAdGroupOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupValues adGroupValues : addAdGroupValues) {
      assertThat(adGroupValues.isOperationSucceeded(), is(true));
      assertThat(adGroupValues.getAdGroup().getAccountId(), is(notNullValue()));
    }

    clean(addAdGroupValues);
  }

  /**
   * Sample TestCase of set method for AdGroupServiceSample.
   */
  @Test
  public void testSet() throws Exception {
    // =================================================================
    // AdGroupService ADD
    // =================================================================
    List<AdGroupValues> addAdGroupValues = null;
    try {
      AdGroupOperation addAdGroupOperation = AdGroupServiceSample.createSampleAddRequest(accountId, campaignId);
      addAdGroupValues = AdGroupServiceSample.add(addAdGroupOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // AdGroupService SET
    // =================================================================
    // Set Operation
    AdGroupOperation setAdGroupOperation = AdGroupServiceSample.createSampleSetRequest(accountId, addAdGroupValues);

    // Run
    List<AdGroupValues> setAdGroupValues = null;
    try {
      setAdGroupValues = AdGroupServiceSample.set(setAdGroupOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupValues adGroupValues : setAdGroupValues) {
      assertThat(adGroupValues.isOperationSucceeded(), is(true));
      assertThat(adGroupValues.getAdGroup().getAccountId(), is(notNullValue()));
    }

    clean(setAdGroupValues);
  }

  /**
   * Sample TestCase of remove method for AdGroupServiceSample.
   */
  @Test
  public void testRemove() throws Exception {
    // =================================================================
    // AdGroupService ADD
    // =================================================================
    List<AdGroupValues> addAdGroupValues = null;
    try {
      AdGroupOperation addAdGroupOperation = AdGroupServiceSample.createSampleAddRequest(accountId, campaignId);
      addAdGroupValues = AdGroupServiceSample.add(addAdGroupOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // AdGroupService REMOVE
    // =================================================================
    // Set Operation
    AdGroupOperation removeAdGroupOperation = AdGroupServiceSample.createSampleRemoveRequest(accountId, addAdGroupValues);

    // Run
    List<AdGroupValues> removeAdGroupValues = null;
    try {
      removeAdGroupValues = AdGroupServiceSample.set(removeAdGroupOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupValues adGroupValues : removeAdGroupValues) {
      assertThat(adGroupValues.isOperationSucceeded(), is(true));
      assertThat(adGroupValues.getAdGroup().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of get method for AdGroupServiceSample.
   */
  @Test
  public void testGet() throws Exception {
    // Set Selector
    AdGroupSelector adGroupSelector = new AdGroupSelector();
    adGroupSelector.setAccountId(accountId);
    adGroupSelector.getUserStatuses().addAll(Arrays.asList(UserStatus.ACTIVE, UserStatus.PAUSED));

    Paging adGroupPaging = new Paging();
    adGroupPaging.setStartIndex(1);
    adGroupPaging.setNumberResults(20);
    adGroupSelector.setPaging(adGroupPaging);

    // =================================================================
    // AdGroupService GET
    // =================================================================
    // Run
    List<AdGroupValues> getAdGroupValues = null;
    try {
      getAdGroupValues = AdGroupServiceSample.get(adGroupSelector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupValues getAdGroupValue : getAdGroupValues) {
      assertThat(getAdGroupValue.isOperationSucceeded(), is(true));
      assertThat(getAdGroupValue.getAdGroup().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * clean
   */
  public void clean(List<AdGroupValues> adGroupValues) {
    try {
      AdGroupOperation removeAdGroupOperation = AdGroupServiceSample.createSampleRemoveRequest(accountId, adGroupValues);
      AdGroupServiceSample.set(removeAdGroupOperation);
    } catch (Exception e) {
      fail();
    }
  }
}
