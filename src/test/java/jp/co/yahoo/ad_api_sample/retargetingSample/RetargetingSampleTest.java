package jp.co.yahoo.ad_api_sample.retargetingSample;

import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Sample TestCase for RetargetingSampleTest.<br>
 * Copyright (C) 2016 Yahoo Japan Corporation. All Rights Reserved.
 */
public class RetargetingSampleTest {
  /**
   * Sample TestCase of main method for RetargetingSampleTest.
   */
  @Test
  public void testMain() throws Exception {
    try {
      RetargetingSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }
}
