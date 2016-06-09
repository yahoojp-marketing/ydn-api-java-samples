package jp.co.yahoo.ad_api_sample.placementUrlSample;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for PlacementUrlSampleTest.<br>
 * Copyright (C) 2016 Yahoo Japan Corporation. All Rights Reserved.
 */
public class PlacementUrlSampleTest {

  @Before
  public void setup() {}

  /**
   * Sample TestCase of main method for MediaSampleTest.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      PlacementUrlSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }
}
