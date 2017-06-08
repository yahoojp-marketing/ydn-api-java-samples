package jp.co.yahoo.ad_api_sample.accountSample;

import jp.co.yahoo.ad_api_sample.error.impl.AccountServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.V6.AccountService.Account;
import jp.yahooapis.im.V6.AccountService.AccountOperation;
import jp.yahooapis.im.V6.AccountService.AccountPage;
import jp.yahooapis.im.V6.AccountService.AccountReturnValue;
import jp.yahooapis.im.V6.AccountService.AccountSelector;
import jp.yahooapis.im.V6.AccountService.AccountServiceInterface;
import jp.yahooapis.im.V6.AccountService.AccountServiceService;
import jp.yahooapis.im.V6.AccountService.AccountStatus;
import jp.yahooapis.im.V6.AccountService.AccountType;
import jp.yahooapis.im.V6.AccountService.AccountValues;
import jp.yahooapis.im.V6.AccountService.DeliveryStatus;
import jp.yahooapis.im.V6.AccountService.Error;
import jp.yahooapis.im.V6.AccountService.Operator;
import jp.yahooapis.im.V6.AccountService.Paging;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;



/**
 * Sample Program for AccountService.<BR>
 * Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class AccountSample {

  /**
   * Sample Program for AccountService GET.
   * 
   * @param selector AccountSelector
   * @return AccountValues
   * @throws Exception
   */
  public static List<AccountValues> get(AccountSelector selector) throws Exception {
    
    // =================================================================
    // AccountService
    // =================================================================
    AccountServiceInterface accountService = SoapUtils.createServiceInterface(AccountServiceInterface.class, AccountServiceService.class);
    
    // call API
    Holder<AccountPage> accountPageHolder = new Holder<AccountPage>();
    Holder<List<Error>> accountErrorHolder = new Holder<List<Error>>();
    accountService.get(selector, accountPageHolder, accountErrorHolder);

    // if error
    if (accountErrorHolder.value != null && accountErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AccountServiceErrorEntityFactory(accountErrorHolder.value), true);
    }

    // response
    if (accountPageHolder.value != null) {
      AccountPage accountPage = accountPageHolder.value;
      if (accountPage.getValues() != null && accountPage.getValues().size() > 0) {
        for (int i = 0; i < accountPage.getValues().size(); i++) {
          List<AccountValues> values = accountPage.getValues();
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayAccount(values.get(i).getAccount());
          } else {
            // if error
            SoapUtils.displayErrors(new AccountServiceErrorEntityFactory(values.get(i).getError()), true);
          }
        }
      }
    } 
    return accountPageHolder.value.getValues();
  }

  /**
   * Sample Program for AccountService SET.
   * 
   * @param operation AccountOperation
   * @return AccountValues
   * @throws Exception
   */
  public static AccountValues set(AccountOperation operation) throws Exception {
    
    // =================================================================
    // AccountService
    // =================================================================
    AccountServiceInterface accountService = SoapUtils.createServiceInterface(AccountServiceInterface.class, AccountServiceService.class);
    
    // call API
    System.out.println("############################################");
    System.out.println("AccountService::mutate(SET)");
    System.out.println("############################################");
    Holder<AccountReturnValue> accountReturnValueHolder = new Holder<AccountReturnValue>();
    Holder<List<Error>> accountSetErrorHolder = new Holder<List<Error>>();
    accountService.mutate(operation, accountReturnValueHolder, accountSetErrorHolder);

    // if error
    if (accountSetErrorHolder.value != null && accountSetErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AccountServiceErrorEntityFactory(accountSetErrorHolder.value), true);
    }

    // response
    if (accountReturnValueHolder.value != null) {
      AccountReturnValue returnValue = accountReturnValueHolder.value;
      if (returnValue.getValues() != null) {
        AccountValues accountValues = returnValue.getValues();
        if (accountValues.isOperationSucceeded()) {
          // display response
          displayAccount(accountValues.getAccount());
        } else {
          // if error
          SoapUtils.displayErrors(new AccountServiceErrorEntityFactory(accountValues.getError()), true);
        }
      }
    }
    return accountReturnValueHolder.value.getValues();
  }
  
  
  
  
  /**
   * main method for AccountSample
   * 
   * @param args command line arguments
   */
  public static void main(String[] args) {

    try {
      long accountId = SoapUtils.getAccountId();

      // -----------------------------------------------
      // AccountService::get(without accountIds)
      // -----------------------------------------------
      // request
      AccountSelector accountSelector = new AccountSelector();
      Paging accountPaging = new Paging();
      accountPaging.setStartIndex(1);
      accountPaging.setNumberResults(20);
      accountSelector.setPaging(accountPaging);
      
      System.out.println("############################################");
      System.out.println("AccountService::get(without accountIds)");
      System.out.println("############################################");
      
      get(accountSelector);



      // -----------------------------------------------
      // AccountService::get(with accountIds)
      // -----------------------------------------------
      // request
      accountSelector.getAccountIds().add(accountId);
      accountSelector.getAccountStatuses().addAll(Arrays.asList(AccountStatus.SERVING, AccountStatus.ENDED));
      accountSelector.getAccountTypes().addAll(Arrays.asList(AccountType.INVOICE, AccountType.PREPAY));
      Paging getAccoutPaging = new Paging();
      getAccoutPaging.setStartIndex(1);
      getAccoutPaging.setNumberResults(20);
      accountSelector.setPaging(getAccoutPaging);
      
      System.out.println("############################################");
      System.out.println("AccountService::get(with accountIds)");
      System.out.println("############################################");
      
      get(accountSelector);


      // -----------------------------------------------
      // AccountService::mutate(SET)
      // -----------------------------------------------
      // request
      AccountOperation accountOperation = new AccountOperation();
      accountOperation.setOperator(Operator.SET);

      Account accountOperand = new Account();
      accountOperand.setAccountId(accountId);
      accountOperand.setAccountName("SampleAccount_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      accountOperand.setDeliveryStatus(DeliveryStatus.PAUSED);
      accountOperation.setOperand(accountOperand);
      
//      set(accountOperation);

 
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * display account entity to stdout.
   * 
   * @param account account entity for display.
   */
  private static void displayAccount(Account account) {
    System.out.println("accountId = " + account.getAccountId());
    System.out.println("accountName = " + account.getAccountName());
    System.out.println("accountType = " + account.getAccountType().toString());
    System.out.println("accountStatus = " + account.getAccountStatus().toString());
    System.out.println("deliverStatus = " + account.getDeliveryStatus().toString());
    if (account.getBudget() != null) {
      System.out.println("budget/amount = " + account.getBudget().getAmount());
      System.out.println("budget/limitChargeType = " + account.getBudget().getLimitChargeType());
      System.out.println("budget/startDate = " + account.getBudget().getStartDate());
      System.out.println("budget/endDate = " + account.getBudget().getEndDate());
    }
    System.out.println("---------");
  }
}
