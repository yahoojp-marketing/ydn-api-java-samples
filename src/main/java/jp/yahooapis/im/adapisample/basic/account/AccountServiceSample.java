/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.account;

import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.v201911.Error;
import jp.yahooapis.im.v201911.Paging;
import jp.yahooapis.im.v201911.account.Account;
import jp.yahooapis.im.v201911.account.AccountOperation;
import jp.yahooapis.im.v201911.account.AccountPage;
import jp.yahooapis.im.v201911.account.AccountReturnValue;
import jp.yahooapis.im.v201911.account.AccountSelector;
import jp.yahooapis.im.v201911.account.AccountService;
import jp.yahooapis.im.v201911.account.AccountServiceInterface;
import jp.yahooapis.im.v201911.account.AccountStatus;
import jp.yahooapis.im.v201911.account.AccountType;
import jp.yahooapis.im.v201911.account.AccountValues;
import jp.yahooapis.im.v201911.account.AutoTaggingEnabled;
import jp.yahooapis.im.v201911.account.DeliveryStatus;
import jp.yahooapis.im.v201911.account.Operator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example AccountService operation and Utility method collection.
 */
public class AccountServiceSample {

  /**
   * example AccountService operation.
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
      // AccountService GET
      // =================================================================
      // create request.
      AccountSelector selector = new AccountSelector();
      selector.getAccountStatuses().addAll(Arrays.asList(AccountStatus.SERVING, AccountStatus.ENDED));
      selector.getAccountTypes().addAll(Arrays.asList(AccountType.INVOICE, AccountType.PREPAY));
      Paging paging = new Paging();
      paging.setStartIndex(1);
      paging.setNumberResults(20);
      selector.setPaging(paging);

      // run
      get(selector);

      // =================================================================
      // AccountService SET
      // =================================================================
      // create request.
      Account operand = new Account();
      operand.setAccountId(accountId);
      operand.setAccountName("SampleAccount_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      operand.setDeliveryStatus(DeliveryStatus.PAUSED);
      operand.setAutoTaggingEnabled(AutoTaggingEnabled.TRUE);

      AccountOperation operation = new AccountOperation();
      operation.setOperator(Operator.SET);
      operation.setOperand(operand);

      // run
      mutate(operation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example mutate accounts.
   *
   * @param operation AccountOperation
   * @return List<AccountValues>
   */
  public static List<AccountValues> mutate(AccountOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("AccountService::mutate(" + operation.getOperator().toString() + ")");
    System.out.println("############################################");

    Holder<AccountReturnValue> accountReturnValueHolder = new Holder<AccountReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AccountServiceInterface accountService = SoapUtils.createServiceInterface(AccountServiceInterface.class, AccountService.class);
    accountService.mutate(operation, accountReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, Collections.singletonList(accountReturnValueHolder.value.getValues()));

    // Response
    return Collections.singletonList(accountReturnValueHolder.value.getValues());
  }

  /**
   * example get accounts.
   *
   * @param selector AccountSelector
   * @return AccountValues
   */
  public static List<AccountValues> get(AccountSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("AccountService::get");
    System.out.println("############################################");

    Holder<AccountPage> accountPageHolder = new Holder<AccountPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AccountServiceInterface accountService = SoapUtils.createServiceInterface(AccountServiceInterface.class, AccountService.class);
    accountService.get(selector, accountPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, accountPageHolder.value.getValues());

    // Response
    return accountPageHolder.value.getValues();
  }
}
