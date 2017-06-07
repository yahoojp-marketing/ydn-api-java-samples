package jp.co.yahoo.ad_api_sample.adSample;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.V6.CampaignService.CampaignOperation;
import jp.yahooapis.im.V6.CampaignService.CampaignSelector;
import jp.yahooapis.im.V6.CampaignService.CampaignValues;
import jp.yahooapis.im.V6.CampaignService.Paging;
import jp.yahooapis.im.V6.CampaignService.UserStatus;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Sample TestCase for CampaignServiceSampleTest.<br>
 * Copyright (C) 2016 Yahoo Japan Corporation. All Rights Reserved.
 */
public class CampaignServiceSampleTest {

  /**
   * Setting
   */
  private long accountId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
  }

  /**
   * Sample TestCase of main method for CampaignServiceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      CampaignServiceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for CampaignServiceSample.
   */
  @Test
  public void testAdd() throws Exception {
    // Set Operation
    CampaignOperation campaignOperation = CampaignServiceSample.createSampleAddRequest(accountId);

    // Run
    List<CampaignValues> addCampaignValues = null;
    try {
      addCampaignValues = CampaignServiceSample.add(campaignOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignValues addCampaignValue : addCampaignValues) {
      assertThat(addCampaignValue.isOperationSucceeded(), is(true));
      assertThat(addCampaignValue.getCampaign().getAccountId(), is(notNullValue()));
    }

    clean(addCampaignValues);
  }

  /**
   * Sample TestCase of set method for CampaignServiceSample.
   */
  @Test
  public void testSet() throws Exception {
    // =================================================================
    // CampaignService::ADD
    // =================================================================
    List<CampaignValues> addCampaignValues = null;
    try {
      CampaignOperation addCampaignOperation = CampaignServiceSample.createSampleAddRequest(accountId);
      addCampaignValues = CampaignServiceSample.add(addCampaignOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // CampaignService::SET
    // =================================================================
    // Set Operation
    CampaignOperation setCampaignOperation = CampaignServiceSample.createSampleSetRequest(accountId, addCampaignValues);

    // Run
    List<CampaignValues> setCampaignValues = null;
    try {
      setCampaignValues = CampaignServiceSample.set(setCampaignOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignValues setCampaignValue : setCampaignValues) {
      assertThat(setCampaignValue.isOperationSucceeded(), is(true));
      assertThat(setCampaignValue.getCampaign().getAccountId(), is(notNullValue()));
    }

    clean(setCampaignValues);
  }

  /**
   * Sample TestCase of remove method for CampaignServiceSample.
   */
  @Test
  public void testRemove() throws Exception {
    // =================================================================
    // CampaignService::ADD
    // =================================================================
    // Run
    List<CampaignValues> addCampaignValues = null;
    try {
      CampaignOperation addCampaignOperation = CampaignServiceSample.createSampleAddRequest(accountId);
      addCampaignValues = CampaignServiceSample.add(addCampaignOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // CampaignService::REMOVE
    // =================================================================
    // Set Operation
    CampaignOperation removeCampaignOperation = CampaignServiceSample.createSampleRemoveRequest(accountId, addCampaignValues);

    // Run
    List<CampaignValues> removeCampaignValues = null;
    try {
      removeCampaignValues = CampaignServiceSample.remove(removeCampaignOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignValues removeCampaignValue : removeCampaignValues) {
      assertThat(removeCampaignValue.isOperationSucceeded(), is(true));
      assertThat(removeCampaignValue.getCampaign().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of get method for CampaignServiceSample.
   */
  @Test
  public void testGet() throws Exception {
    // Set Selector
    CampaignSelector campaignSelector = new CampaignSelector();
    campaignSelector.setAccountId(accountId);
    campaignSelector.getUserStatus().addAll(Arrays.asList(UserStatus.ACTIVE, UserStatus.PAUSED));

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    campaignSelector.setPaging(paging);

    // Run
    List<CampaignValues> getCampaignValues = null;
    try {
      getCampaignValues = CampaignServiceSample.get(campaignSelector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignValues getCampaignValue : getCampaignValues) {
      assertThat(getCampaignValue.isOperationSucceeded(), is(true));
      assertThat(getCampaignValue.getCampaign().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * clean
   */
  public void clean(List<CampaignValues> campaignValues) {
    try {
      CampaignOperation removeCampaignOperation = CampaignServiceSample.createSampleRemoveRequest(accountId, campaignValues);
      CampaignServiceSample.remove(removeCampaignOperation);
    } catch (Exception e) {
      fail();
    }
  }
}
