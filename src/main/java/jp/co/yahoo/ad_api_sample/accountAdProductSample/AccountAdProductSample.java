package jp.co.yahoo.ad_api_sample.accountAdProductSample;

import jp.co.yahoo.ad_api_sample.error.impl.ErrorEntityFactoryImpl;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201812.accountadproduct.AccountAdProduct;
import jp.yahooapis.im.v201812.accountadproduct.AccountAdProductPage;
import jp.yahooapis.im.v201812.accountadproduct.AccountAdProductSelector;
import jp.yahooapis.im.v201812.accountadproduct.AccountAdProductService;
import jp.yahooapis.im.v201812.accountadproduct.AccountAdProductServiceInterface;
import jp.yahooapis.im.v201812.accountadproduct.AccountAdProductValues;
import jp.yahooapis.im.v201812.accountadproduct.AdProduct;
import jp.yahooapis.im.v201812.Error;

import java.util.List;

import javax.xml.ws.Holder;


/**
 * Sample Program for AccountAdProductService.<br>
 * Copyright (C) 2016 Yahoo Japan Corporation. All Rights Reserved.
 */
public class AccountAdProductSample {

  /**
   * main method for AccountAdProductService
   * 
   * @param args command line arguments
   */
  public static void main(String[] args) {

    try {
      long accountId = SoapUtils.getAccountId();
      // -----------------------------------------------
      // AccountAdProductService::get
      // -----------------------------------------------
      // request
      AccountAdProductSelector accountAdProductSelector = new AccountAdProductSelector();
      accountAdProductSelector.getAccountIds().add(accountId);

      // call GET API
      get(accountAdProductSelector);


    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Sample Program for AccountAdProductService GET.
   * 
   * @param selector AccountAdProductSelector
   * @return AccountAdProductValues
   * @throws Exception
   */
  public static List<AccountAdProductValues> get(AccountAdProductSelector selector) throws Exception {
    System.out.println("############################################");
    System.out.println("AccountAdProductService::get");
    System.out.println("############################################");

    // =================================================================
    // AccountAdProductService
    // =================================================================
    AccountAdProductServiceInterface accountService = SoapUtils.createServiceInterface(AccountAdProductServiceInterface.class, AccountAdProductService.class);
    Holder<AccountAdProductPage> accountAdProductPageHolder = new Holder<AccountAdProductPage>();
    Holder<List<Error>> accountAdProductErrorHolder = new Holder<List<Error>>();
    accountService.get(selector, accountAdProductPageHolder, accountAdProductErrorHolder);

    // if error
    if (accountAdProductErrorHolder.value != null && accountAdProductErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(accountAdProductErrorHolder.value), true);
    }

    // response
    if (accountAdProductPageHolder.value != null) {
      AccountAdProductPage accountAdProductPage = accountAdProductPageHolder.value;
      if (accountAdProductPage.getValues() != null && accountAdProductPage.getValues().size() > 0) {
        for (int i = 0; i < accountAdProductPage.getValues().size(); i++) {
          List<AccountAdProductValues> values = accountAdProductPage.getValues();
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayAccountAdProduct(values.get(i).getAccountAdProduct());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }

    return accountAdProductPageHolder.value.getValues();
  }

  /**
   * display accountAdProduct entity to stdout.
   * 
   * @param accountAdProduct accountAdProduct entity for display.
   */
  private static void displayAccountAdProduct(AccountAdProduct accountAdProduct) {
    System.out.println("accountId = " + accountAdProduct.getAccountId());

    List<AdProduct> adProducts = accountAdProduct.getAdProduct();
    for (AdProduct adProduct : adProducts) {
      System.out.println("  adProduct code = " + adProduct.getAdProductType());
      System.out.println("  =========");
    }
    System.out.println("---------");
  }

}
