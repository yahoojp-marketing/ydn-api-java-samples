package jp.co.yahoo.ad_api_sample.balanceSample;

import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Sample TestCase for BalanceSampleTest.<br>
 * Copyright (C) 2016 Yahoo Japan Corporation. All Rights Reserved.
 */
public class BalanceSampleTest {

  /**
   * Sample TestCase of main method for BalanceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      BalanceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }
}
