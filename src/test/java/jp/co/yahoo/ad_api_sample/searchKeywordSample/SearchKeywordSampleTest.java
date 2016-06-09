package jp.co.yahoo.ad_api_sample.searchKeywordSample;

import static org.junit.Assert.fail;

import org.junit.Test;
/**
 * Sample TestCase for SearchKeywordSampleTest.<br>
 * Copyright (C) 2016 Yahoo Japan Corporation. All Rights Reserved.
 */
public class SearchKeywordSampleTest {
  /**
   * Sample TestCase of main method for SearchKeywordSampleTest.
   */
  @Test
  public void testMain() throws Exception {
    try {
      SearchKeywordSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }
}
