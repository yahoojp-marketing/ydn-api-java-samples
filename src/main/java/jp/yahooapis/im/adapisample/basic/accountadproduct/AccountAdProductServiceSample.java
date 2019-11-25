/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.accountadproduct;

import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.v201911.Error;
import jp.yahooapis.im.v201911.accountadproduct.AccountAdProductPage;
import jp.yahooapis.im.v201911.accountadproduct.AccountAdProductSelector;
import jp.yahooapis.im.v201911.accountadproduct.AccountAdProductService;
import jp.yahooapis.im.v201911.accountadproduct.AccountAdProductServiceInterface;
import jp.yahooapis.im.v201911.accountadproduct.AccountAdProductValues;

import java.util.List;

import javax.xml.ws.Holder;

/**
 * example AccountAdProductService operation and Utility method collection.
 */
public class AccountAdProductServiceSample {

  /**
   * example AccountAdProductService operation.
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
      // AccountAdProductService GET
      // =================================================================
      // create request.
      AccountAdProductSelector selector = new AccountAdProductSelector();
      selector.getAccountIds().add(accountId);

      // run
      get(selector);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example get account ad products.
   *
   * @param selector AccountAdProductSelector
   * @return AccountAdProductValues
   */
  public static List<AccountAdProductValues> get(AccountAdProductSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("AccountAdProductService::get");
    System.out.println("############################################");

    Holder<AccountAdProductPage> accountAdProductPageHolder = new Holder<AccountAdProductPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AccountAdProductServiceInterface accountAdProductService = SoapUtils.createServiceInterface(AccountAdProductServiceInterface.class, AccountAdProductService.class);
    accountAdProductService.get(selector, accountAdProductPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, accountAdProductPageHolder.value.getValues());

    // Response
    return accountAdProductPageHolder.value.getValues();
  }
}
