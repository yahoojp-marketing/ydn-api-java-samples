package jp.co.yahoo.ad_api_sample.conversionTrackerSample;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201812.Paging;
import jp.yahooapis.im.v201812.conversiontracker.ConversionTrackerCategory;
import jp.yahooapis.im.v201812.conversiontracker.ConversionTrackerOperation;
import jp.yahooapis.im.v201812.conversiontracker.ConversionTrackerSelector;
import jp.yahooapis.im.v201812.conversiontracker.ConversionTrackerStatus;
import jp.yahooapis.im.v201812.conversiontracker.ConversionTrackerType;
import jp.yahooapis.im.v201812.conversiontracker.ConversionTrackerValues;
import jp.yahooapis.im.v201812.conversiontracker.Operator;
import jp.yahooapis.im.v201812.conversiontracker.WebConversion;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Sample TestCase for ConversionTrackerSampleTest.<br>
 * Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class ConversionTrackerSampleTest {

  /**
   * Setting
   */
  private long accountId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
  }

  /**
   * Sample TestCase of main method for ConversionTrackerSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      ConversionTrackerSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for ConversionTrackerSample.
   */
  @Test
  public void testAdd() throws Exception {
    // Set Operation
    WebConversion addConversionTracker = new WebConversion();
    addConversionTracker.setAccountId(accountId);
    addConversionTracker.setConversionTrackerName("SampleConversionTracker_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addConversionTracker.setStatus(ConversionTrackerStatus.ENABLED);
    addConversionTracker.setCategory(ConversionTrackerCategory.PURCHASE);
    addConversionTracker.setConversionTrackerType(ConversionTrackerType.WEB_CONVERSION);

    ConversionTrackerOperation addConversionTrackerOperation = new ConversionTrackerOperation();
    addConversionTrackerOperation.setAccountId(accountId);
    addConversionTrackerOperation.setOperator(Operator.ADD);
    addConversionTrackerOperation.getOperand().add(addConversionTracker);

    // Run
    List<ConversionTrackerValues> conversionTrackerValues = null;
    try {
      conversionTrackerValues = ConversionTrackerSample.add(addConversionTrackerOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (ConversionTrackerValues conversionTrackerValue : conversionTrackerValues) {
      assertThat(conversionTrackerValue.isOperationSucceeded(), is(true));
      assertThat(conversionTrackerValue.getConversionTracker().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of set method for ConversionTrackerSample.
   */
  @Test
  public void testSet() throws Exception {
    // =================================================================
    // ConversionTrackerService::mutate(ADD)
    // =================================================================
    // Set Operation
    WebConversion addConversionTracker = new WebConversion();
    addConversionTracker.setAccountId(accountId);
    addConversionTracker.setConversionTrackerName("SampleConversionTracker_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addConversionTracker.setStatus(ConversionTrackerStatus.ENABLED);
    addConversionTracker.setCategory(ConversionTrackerCategory.PURCHASE);
    addConversionTracker.setConversionTrackerType(ConversionTrackerType.WEB_CONVERSION);

    ConversionTrackerOperation addConversionTrackerOperation = new ConversionTrackerOperation();
    addConversionTrackerOperation.setAccountId(accountId);
    addConversionTrackerOperation.setOperator(Operator.ADD);
    addConversionTrackerOperation.getOperand().add(addConversionTracker);

    // Run
    List<ConversionTrackerValues> addResponse = null;
    try {
      addResponse = ConversionTrackerSample.add(addConversionTrackerOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // ConversionTrackerService::mutate(SET)
    // =================================================================
    // Set Operation
    ConversionTrackerOperation setConversionTrackerOperation = new ConversionTrackerOperation();
    setConversionTrackerOperation.setAccountId(accountId);
    setConversionTrackerOperation.setOperator(Operator.SET);

    WebConversion setConversionTracker = new WebConversion();
    setConversionTracker.setAccountId(accountId);
    setConversionTracker.setConversionTrackerId(addResponse.get(0).getConversionTracker().getConversionTrackerId());
    setConversionTracker.setConversionTrackerName("SampleConversionTracker_UpdateOn_" + SoapUtils.getCurrentTimestamp());
    setConversionTracker.setStatus(ConversionTrackerStatus.DISABLED);
    setConversionTracker.setCategory(ConversionTrackerCategory.PAGE_VIEW);
    setConversionTracker.setUserRevenueValue((long) 300);
    setConversionTracker.setConversionTrackerType(ConversionTrackerType.WEB_CONVERSION);
    setConversionTrackerOperation.getOperand().add(setConversionTracker);

    // Run
    List<ConversionTrackerValues> setResponse = null;
    try {
      setResponse = ConversionTrackerSample.add(setConversionTrackerOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (ConversionTrackerValues conversionTrackerValue : setResponse) {
      assertThat(conversionTrackerValue.isOperationSucceeded(), is(true));
      assertThat(conversionTrackerValue.getConversionTracker().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of get method for ConversionTrackerSample.
   */
  @Test
  public void testGet() throws Exception {
    // =================================================================
    // ConversionTrackerService::mutate(ADD)
    // =================================================================
    // Set Operation
    WebConversion addConversionTracker = new WebConversion();
    addConversionTracker.setAccountId(accountId);
    addConversionTracker.setConversionTrackerName("SampleConversionTracker_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addConversionTracker.setStatus(ConversionTrackerStatus.ENABLED);
    addConversionTracker.setCategory(ConversionTrackerCategory.PURCHASE);
    addConversionTracker.setConversionTrackerType(ConversionTrackerType.WEB_CONVERSION);

    ConversionTrackerOperation addConversionTrackerOperation = new ConversionTrackerOperation();
    addConversionTrackerOperation.setAccountId(accountId);
    addConversionTrackerOperation.setOperator(Operator.ADD);
    addConversionTrackerOperation.getOperand().add(addConversionTracker);

    // Run
    List<ConversionTrackerValues> addResponse = null;
    try {
      addResponse = ConversionTrackerSample.add(addConversionTrackerOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // ConversionTrackerService::get
    // =================================================================
    // Set Selector
    ConversionTrackerSelector conversionTrackerSelector = new ConversionTrackerSelector();
    conversionTrackerSelector.setAccountId(accountId);
    conversionTrackerSelector.getConversionTrackerIds().add(addResponse.get(0).getConversionTracker().getConversionTrackerId());

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    conversionTrackerSelector.setPaging(paging);

    // Run
    List<ConversionTrackerValues> getResponse = null;
    try {
      getResponse = ConversionTrackerSample.get(conversionTrackerSelector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (ConversionTrackerValues conversionTrackerValue : getResponse) {
      assertThat(conversionTrackerValue.isOperationSucceeded(), is(true));
      assertThat(conversionTrackerValue.getConversionTracker().getAccountId(), is(notNullValue()));
    }
  }
}
