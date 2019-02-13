package jp.co.yahoo.ad_api_sample.feedDataSample;

import jp.co.yahoo.ad_api_sample.error.impl.ErrorEntityFactoryImpl;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201812.Error;
import jp.yahooapis.im.v201812.Paging;
import jp.yahooapis.im.v201812.feedholder.FeedHolderOperation;
import jp.yahooapis.im.v201812.feedholder.FeedHolderPage;
import jp.yahooapis.im.v201812.feedholder.FeedHolderRecord;
import jp.yahooapis.im.v201812.feedholder.FeedHolderReturnValue;
import jp.yahooapis.im.v201812.feedholder.FeedHolderSelector;
import jp.yahooapis.im.v201812.feedholder.FeedHolderServiceInterface;
import jp.yahooapis.im.v201812.feedholder.FeedHolderServiceService;
import jp.yahooapis.im.v201812.feedholder.FeedHolderValues;
import jp.yahooapis.im.v201812.feedholder.Operator;

import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for FeedHolderService.<br>
 * Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class FeedHolderSample {

  /**
   * main method for FeedHolderServiceSample
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
      // FeedHolderService ADD
      // =================================================================
      // Set Operation
      FeedHolderOperation addFeedHolderOperation = createSampleAddRequest(accountId);

      // Run
      List<FeedHolderValues> feedHolderValues = add(addFeedHolderOperation);

      // =================================================================
      // FeedHolderService GET
      // =================================================================
      // Set Selector
      FeedHolderSelector feedHolderSelector = createSampleGetRequest(accountId, feedHolderValues);

      // Run
      get(feedHolderSelector);

      // =================================================================
      // FeefHolderService SET
      // =================================================================
      // Set Operation
      FeedHolderOperation setFeedHolderOperation = createSampleSetRequest(accountId, feedHolderValues);

      // Run
      set(setFeedHolderOperation);

      // =================================================================
      // FeefHolderService REMOVE
      // =================================================================
      // Set Operation
      FeedHolderOperation removeFeedHolderOperation = createSampleRemoveRequest(accountId, feedHolderValues);

      // Run
      remove(removeFeedHolderOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for FeedHolderService ADD.
   *
   * @param operation FeedHolderOperation
   * @return FeedHolderValues
   */
  public static List<FeedHolderValues> add(FeedHolderOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedHolderService::mutate(ADD)");
    System.out.println("############################################");

    Holder<FeedHolderReturnValue> feedHolderReturnValueHolder = new Holder<FeedHolderReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedHolderServiceInterface feedHolderService = SoapUtils.createServiceInterface(FeedHolderServiceInterface.class, FeedHolderServiceService.class);
    feedHolderService.mutate(operation, feedHolderReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(errorHolder.value), true);
    }
    if (feedHolderReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:FeedHolderService Add");
    }

    // Display
    for (FeedHolderValues feedHolderValues : feedHolderReturnValueHolder.value.getValues()) {
      if (feedHolderValues.isOperationSucceeded()) {
        display(feedHolderValues.getFeedHolder());
      } else {
        SoapUtils.displayErrors(new ErrorEntityFactoryImpl(feedHolderValues.getError()), true);
      }
    }

    // Response
    return feedHolderReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for FeedHolderService SET.
   *
   * @param operation FeedHolderOperation
   * @return FeedHolderValues
   */
  public static List<FeedHolderValues> set(FeedHolderOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedHolderService::mutate(SET)");
    System.out.println("############################################");

    Holder<FeedHolderReturnValue> feedHolderReturnValueHolder = new Holder<FeedHolderReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedHolderServiceInterface feedHolderService = SoapUtils.createServiceInterface(FeedHolderServiceInterface.class, FeedHolderServiceService.class);
    feedHolderService.mutate(operation, feedHolderReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(errorHolder.value), true);
    }
    if (feedHolderReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:FeedHolderService Set");
    }

    // Display
    for (FeedHolderValues feedHolderValues : feedHolderReturnValueHolder.value.getValues()) {
      if (feedHolderValues.isOperationSucceeded()) {
        display(feedHolderValues.getFeedHolder());
      } else {
        SoapUtils.displayErrors(new ErrorEntityFactoryImpl(feedHolderValues.getError()), true);
      }
    }

    // Response
    return feedHolderReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for FeedHolderService REMOVE.
   *
   * @param operation FeedHolderOperation
   * @return FeedHolderValues
   */
  public static List<FeedHolderValues> remove(FeedHolderOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedHolderService::mutate(REMOVE)");
    System.out.println("############################################");

    Holder<FeedHolderReturnValue> feedHolderReturnValueHolder = new Holder<FeedHolderReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedHolderServiceInterface feedHolderService = SoapUtils.createServiceInterface(FeedHolderServiceInterface.class, FeedHolderServiceService.class);
    feedHolderService.mutate(operation, feedHolderReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(errorHolder.value), true);
    }
    if (feedHolderReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:FeedHolderService Remove");
    }

    // Display
    for (FeedHolderValues feedHolderValues : feedHolderReturnValueHolder.value.getValues()) {
      if (feedHolderValues.isOperationSucceeded()) {
        display(feedHolderValues.getFeedHolder());
      } else {
        SoapUtils.displayErrors(new ErrorEntityFactoryImpl(feedHolderValues.getError()), true);
      }
    }

    return feedHolderReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for FeedHolderService GET.
   *
   * @param feedHolderSelector FeedHolderSelector
   * @return FeedHolderValues
   */
  public static List<FeedHolderValues> get(FeedHolderSelector feedHolderSelector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedHolderService::mutate(GET)");
    System.out.println("############################################");

    Holder<FeedHolderPage> feedHolderPage = new Holder<FeedHolderPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedHolderServiceInterface feedHolderService = SoapUtils.createServiceInterface(FeedHolderServiceInterface.class, FeedHolderServiceService.class);
    feedHolderService.get(feedHolderSelector, feedHolderPage, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(errorHolder.value), true);
    }
    if (feedHolderPage.value == null) {
      throw new Exception("NoDataResponse:FeedHolderService Get");
    }

    // Display
    for (FeedHolderValues feedHolderValues : feedHolderPage.value.getValues()) {
      if (feedHolderValues.isOperationSucceeded()) {
        display(feedHolderValues.getFeedHolder());
      } else {
        SoapUtils.displayErrors(new ErrorEntityFactoryImpl(feedHolderValues.getError()), true);
      }
    }

    // Response
    return feedHolderPage.value.getValues();
  }

  /**
   * display FeedHolderRecord entity to stdout.
   *
   * @param feedHolderRecord FeedHolderRecord entity for display.
   */
  public static void display(FeedHolderRecord feedHolderRecord) {

    System.out.println("accountId = " + feedHolderRecord.getAccountId());
    System.out.println("feedHolderId = " + feedHolderRecord.getFeedHolderId());
    System.out.println("feedHolderName = " + feedHolderRecord.getFeedHolderName());
    System.out.println("itemCount = " + feedHolderRecord.getItemCount());
    System.out.println("approvedItemCount = " + feedHolderRecord.getApprovedItemCount());
    System.out.println("disApprovedItemCount = " + feedHolderRecord.getDisApprovedItemCount());

    System.out.println("---------");
  }

  /**
   * create sample request.
   *
   * @param accountId Account ID
   * @return FeedHolderOperation
   */
  public static FeedHolderOperation createSampleAddRequest(long accountId) {
    // Set Operation
    FeedHolderOperation operation = new FeedHolderOperation();
    operation.setOperator(Operator.ADD);
    operation.setAccountId(accountId);

    // Set Operand
    FeedHolderRecord feedHolder = new FeedHolderRecord();
    feedHolder.setAccountId(accountId);
    feedHolder.setFeedHolderName("SampleFeedHolder_" + SoapUtils.getCurrentTimestamp());

    operation.getOperand().add(feedHolder);

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId        Account ID
   * @param feedHolderValues FeedHolderValues entity for set.
   * @return FeedHolderOperation
   */
  public static FeedHolderOperation createSampleSetRequest(long accountId, List<FeedHolderValues> feedHolderValues) {
    // Set Operation
    FeedHolderOperation operation = new FeedHolderOperation();
    operation.setOperator(Operator.SET);
    operation.setAccountId(accountId);

    // Set Operand
    for (FeedHolderValues feedHolderValue : feedHolderValues) {

      FeedHolderRecord feedHolder = new FeedHolderRecord();
      feedHolder.setAccountId(feedHolderValue.getFeedHolder().getAccountId());
      feedHolder.setFeedHolderId(feedHolderValue.getFeedHolder().getFeedHolderId());
      feedHolder.setFeedHolderName("SampleFeedHolderMod_" + SoapUtils.getCurrentTimestamp());

      operation.getOperand().add(feedHolder);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId        Account ID
   * @param feedHolderValues FeedHolderValues entity for remove.
   * @return FeedHolderOperation
   */
  public static FeedHolderOperation createSampleRemoveRequest(long accountId, List<FeedHolderValues> feedHolderValues) {
    // Set Operation
    FeedHolderOperation operation = new FeedHolderOperation();
    operation.setOperator(Operator.REMOVE);
    operation.setAccountId(accountId);

    // Set Operand
    for (FeedHolderValues feedHolderValue : feedHolderValues) {

      FeedHolderRecord feedHolder = new FeedHolderRecord();
      feedHolder.setAccountId(feedHolderValue.getFeedHolder().getAccountId());
      feedHolder.setFeedHolderId(feedHolderValue.getFeedHolder().getFeedHolderId());

      operation.getOperand().add(feedHolder);
    }
    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId        Account ID
   * @param feedHolderValues FeedHolderValues entity for get.
   * @return FeedHolderSelector
   */
  public static FeedHolderSelector createSampleGetRequest(long accountId, List<FeedHolderValues> feedHolderValues) {
    // Set Selector
    FeedHolderSelector selector = new FeedHolderSelector();
    selector.setAccountId(accountId);
    for (FeedHolderValues feedHolderValue : feedHolderValues) {
      selector.getFeedHolderIds().add(feedHolderValue.getFeedHolder().getFeedHolderId());
    }

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
}
