package jp.co.yahoo.ad_api_sample.accountAdProductSample;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201809.accountadproduct.AccountAdProductSelector;
import jp.yahooapis.im.v201809.accountadproduct.AccountAdProductValues;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Sample TestCase for AccountAdProductServiceSampleTest.<br>
 * Copyright (C) 2016 Yahoo Japan Corporation. All Rights Reserved.
 */
public class AccountAdProductSampleTest {

  /**
   * Setting
   */
  private long accountId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
  }

  /**
   * Sample TestCase of main method for AccountSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      AccountAdProductSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of get method for AccountSample.
   */
  @Test
  public void testGet() throws Exception {
    // Set Selector
    AccountAdProductSelector selector = new AccountAdProductSelector();
    selector.getAccountIds().add(new Long(accountId));

    // Run
    List<AccountAdProductValues> accountValues = null;
    try {
      accountValues = AccountAdProductSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AccountAdProductValues accountValue : accountValues) {
      assertThat(accountValue.isOperationSucceeded(), is(true));
      assertThat(accountValue.getAccountAdProduct().getAccountId(), is(notNullValue()));
    }
  }
}
