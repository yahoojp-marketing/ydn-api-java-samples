package jp.co.yahoo.ad_api_sample.mediaSample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Sample TestCase for MediaSampleTest.<br>
 * Copyright (C) 2016 Yahoo Japan Corporation. All Rights Reserved.
 */
public class MediaSampleTest {

  @Before
  public void setup() {}

  /**
   * Sample TestCase of main method for MediaSampleTest.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      MediaSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }
}
