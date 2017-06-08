package jp.co.yahoo.ad_api_sample.videoSample;

import org.junit.Test;

import static junit.framework.TestCase.fail;

/**
 * Sample TestCase for VideoSampleTest.<br>
 * Copyright (C) 2017 Yahoo Japan Corporation. All Rights Reserved.
 */
public class VideoSampleTest {

  /**
   * Sample TestCase of main method for VideoSampleTest.
   */
  @Test
  public void testMain() throws Exception {
    try {
      VideoSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }
}
