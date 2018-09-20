package jp.co.yahoo.ad_api_sample.accountSample;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201809.account.Account;
import jp.yahooapis.im.v201809.account.AccountOperation;
import jp.yahooapis.im.v201809.account.AccountSelector;
import jp.yahooapis.im.v201809.account.AccountValues;
import jp.yahooapis.im.v201809.account.DeliveryStatus;
import jp.yahooapis.im.v201809.account.Operator;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Sample TestCase for AccountSampleTest.<br>
 * Copyright (C) 2016 Yahoo Japan Corporation. All Rights Reserved.
 */
public class AccountSampleTest {

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
      AccountSample.main(null);
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
    AccountSelector selector = new AccountSelector();
    selector.getAccountIds().add(new Long(accountId));

    // Run
    List<AccountValues> accountValues = null;
    try {
      accountValues = AccountSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AccountValues accountValue : accountValues) {
      assertThat(accountValue.isOperationSucceeded(), is(true));
      assertThat(accountValue.getAccount().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of set method for AccountSample.
   */
  @Test
  public void testSet() throws Exception {
    // Set Operation
    AccountOperation operation = new AccountOperation();
    operation.setOperator(Operator.SET);
    Account operand = new Account();
    operand.setAccountId(accountId);
    operand.setAccountName("SampleAccount_UpdateOn_" + SoapUtils.getCurrentTimestamp());
    operand.setDeliveryStatus(DeliveryStatus.PAUSED);
    operation.setOperand(operand);

    // Run
    AccountValues accountValues = null;
    try {
      accountValues = AccountSample.set(operation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    assertThat(accountValues.isOperationSucceeded(), is(true));
    assertThat(accountValues.getAccount().getAccountId(), is(notNullValue()));

  }
}
