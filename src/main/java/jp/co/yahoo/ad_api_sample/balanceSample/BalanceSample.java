package jp.co.yahoo.ad_api_sample.balanceSample;

import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.BalanceServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.V5.BalanceService.Balance;
import jp.yahooapis.im.V5.BalanceService.BalancePage;
import jp.yahooapis.im.V5.BalanceService.BalanceSelector;
import jp.yahooapis.im.V5.BalanceService.BalanceServiceInterface;
import jp.yahooapis.im.V5.BalanceService.BalanceServiceService;
import jp.yahooapis.im.V5.BalanceService.BalanceValues;
import jp.yahooapis.im.V5.BalanceService.Error;



/**
 * Sample Program for BalanceService.<br>
 * Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class BalanceSample {
  /**
   * main method for BalanceSample
   * 
   * @param args command line arguments
   */
  public static void main(String[] args) {

    try {
      long accountId = SoapUtils.getAccountId();

      // =================================================================
      // BalanceService
      // =================================================================
      BalanceServiceInterface balanceService = SoapUtils.createServiceInterface(BalanceServiceInterface.class, BalanceServiceService.class);

      // -----------------------------------------------
      // BalanceService::get
      // -----------------------------------------------
      // request
      BalanceSelector balanceSelector = new BalanceSelector();
      balanceSelector.setAccountId(accountId);

      // call API
      System.out.println("############################################");
      System.out.println("BalanceService::get");
      System.out.println("############################################");

      Holder<BalancePage> balancePageHolder = new Holder<BalancePage>();
      Holder<List<Error>> balanceErrorHolder = new Holder<List<Error>>();
      balanceService.get(balanceSelector, balancePageHolder, balanceErrorHolder);

      // if error
      if (balanceErrorHolder.value != null && balanceErrorHolder.value.size() > 0) {
        SoapUtils.displayErrors(new BalanceServiceErrorEntityFactory(balanceErrorHolder.value), true);
      }

      // response
      if (balancePageHolder.value != null) {
        BalancePage balancePage = balancePageHolder.value;
        if (balancePage.getValues() != null) {
          BalanceValues balanceValues = balancePage.getValues();
          // display response
          if (balanceValues.isOperationSucceeded()) {
            Balance balance = balanceValues.getBalance();
            System.out.println("accountId = " + balance.getAccountId());
            System.out.println("balance = " + balance.getBalance());
          } else {
            SoapUtils.displayErrors(new BalanceServiceErrorEntityFactory(balanceValues.getError()), true);
          }
        }
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}

