/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.balance;

import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.v201903.Error;
import jp.yahooapis.im.v201903.balance.BalancePage;
import jp.yahooapis.im.v201903.balance.BalanceSelector;
import jp.yahooapis.im.v201903.balance.BalanceService;
import jp.yahooapis.im.v201903.balance.BalanceServiceInterface;
import jp.yahooapis.im.v201903.balance.BalanceValues;

import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example BalanceService operation and Utility method collection.
 */
public class BalanceServiceSample {

  /**
   * example BalanceService operation.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();

      // =================================================================
      // BalanceService GET
      // =================================================================
      // create request.
      BalanceSelector getRequest = buildExampleGetRequest(accountId);

      // run
      get(getRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @return BalanceSelector
   */
  public static BalanceSelector buildExampleGetRequest(long accountId) {
    BalanceSelector selector = new BalanceSelector();
    selector.setAccountId(accountId);
    return selector;
  }

  /**
   * example get balance.
   *
   * @param selector BalanceSelector
   * @return AccountValues
   */
  public static List<BalanceValues> get(BalanceSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("BalanceService::get");
    System.out.println("############################################");

    Holder<BalancePage> balancePageHolder = new Holder<BalancePage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    BalanceServiceInterface balanceService = SoapUtils.createServiceInterface(BalanceServiceInterface.class, BalanceService.class);
    balanceService.get(selector, balancePageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, Collections.singletonList(balancePageHolder.value.getValues()));

    // Response
    return Collections.singletonList(balancePageHolder.value.getValues());
  }
}
