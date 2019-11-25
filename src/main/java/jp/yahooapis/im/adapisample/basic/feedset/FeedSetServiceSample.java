/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.feedset;

import jp.yahooapis.im.adapisample.basic.feedholder.FeedHolderServiceSample;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201911.Error;
import jp.yahooapis.im.v201911.feedset.CompareOperator;
import jp.yahooapis.im.v201911.feedset.Condition;
import jp.yahooapis.im.v201911.feedset.ConditionSet;
import jp.yahooapis.im.v201911.feedset.ConditionType;
import jp.yahooapis.im.v201911.feedset.FeedSet;
import jp.yahooapis.im.v201911.feedset.FeedSetOperation;
import jp.yahooapis.im.v201911.feedset.FeedSetPage;
import jp.yahooapis.im.v201911.feedset.FeedSetReturnValue;
import jp.yahooapis.im.v201911.feedset.FeedSetSelector;
import jp.yahooapis.im.v201911.feedset.FeedSetService;
import jp.yahooapis.im.v201911.feedset.FeedSetServiceInterface;
import jp.yahooapis.im.v201911.feedset.FeedSetValues;
import jp.yahooapis.im.v201911.feedset.Operator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example FeedSetService operation and Utility method collection.
 */
public class FeedSetServiceSample {

  /**
   * example FeedSetService operation.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    // =================================================================
    // Setting
    // =================================================================
    ValuesHolder valuesHolder = new ValuesHolder();
    long accountId = SoapUtils.getAccountId();

    try {
      // =================================================================
      // check & create upper service object.
      // =================================================================
      valuesHolder = setup();
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);

      // Actually, FeedHolderId that includes approved feed items is required.
      Long feedHolderId = valuesRepositoryFacade.getFeedHolderValuesRepository().getFeedHolderIds().get(0);

      // =================================================================
      // FeedSetService ADD
      // =================================================================
      // create request.
      FeedSetOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, Collections.singletonList( //
          createExampleFeedSet(feedHolderId)) //
      );

      // run
      List<FeedSet> feedSets = new ArrayList<>();
      List<FeedSetValues> addResponse = mutate(addRequest);
      for (FeedSetValues feedSetValues : addResponse) {
        feedSets.add(feedSetValues.getFeedSet());
      }

      // =================================================================
      // FeedSetService GET
      // =================================================================
      // create request.
      FeedSetSelector getRequest = buildExampleGetRequest(accountId, feedHolderId, Collections.singletonList(feedSets.get(0).getFeedSetId()));

      // run
      get(getRequest);

      // =================================================================
      // FeedSetService REMOVE
      // =================================================================
      // create request.
      FeedSetOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, feedSets);

      // run
      mutate(removeRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;

    } finally {
      // =================================================================
      // Cleanup
      // =================================================================
      cleanup(valuesHolder);
    }
  }

  /**
   * Sample Program for FeedSetService GET.
   *
   * @param selector FeedSetSelector
   * @return FeedFtpValues
   */
  public static List<FeedSetValues> get(FeedSetSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedSetService::get");
    System.out.println("############################################");

    Holder<FeedSetPage> feedSetPageHolder = new Holder<FeedSetPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedSetServiceInterface feedSetService = SoapUtils.createServiceInterface(FeedSetServiceInterface.class, FeedSetService.class);
    feedSetService.get(selector, feedSetPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, feedSetPageHolder.value.getValues());

    // Response
    return feedSetPageHolder.value.getValues();
  }

  /**
   * example mutate FeedSets.
   *
   * @param operation FeedSetOperation
   * @return FeedSetValues
   */
  public static List<FeedSetValues> mutate(FeedSetOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedSetService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<FeedSetReturnValue> feedSetReturnValueHolder = new Holder<FeedSetReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedSetServiceInterface feedSetService = SoapUtils.createServiceInterface(FeedSetServiceInterface.class, FeedSetService.class);
    feedSetService.mutate(operation, feedSetReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, feedSetReturnValueHolder.value.getValues());

    // Response
    return feedSetReturnValueHolder.value.getValues();
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   */
  private static ValuesHolder setup() throws Exception {
    return FeedHolderServiceSample.create();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    FeedHolderServiceSample.cleanup(valuesHolder);
  }

  /**
   * example mutate request.
   *
   * @param operator  Operator
   * @param accountId long
   * @param operand   List<FeedSet>
   * @return FeedSetOperation
   */
  public static FeedSetOperation buildExampleMutateRequest(Operator operator, long accountId, List<FeedSet> operand) {
    FeedSetOperation operation = new FeedSetOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example FeedSet request.
   *
   * @return FeedSet
   */
  public static FeedSet createExampleFeedSet(long feedHolderId) {
    FeedSet feedFtp = new FeedSet();
    feedFtp.setFeedHolderId(feedHolderId);
    feedFtp.setFeedSetName("sampleFeedSet");

    Condition condition = new Condition();
    condition.setOperator(CompareOperator.EQUAL);
    condition.setValue("2.2");

    ConditionSet conditionSet = new ConditionSet();
    conditionSet.setType(ConditionType.RATING);
    conditionSet.getOrConditions().add(condition);
    feedFtp.getConditionSets().add(conditionSet);

    return feedFtp;
  }

  /**
   * create sample request.
   *
   * @param accountId    long
   * @param feedHolderId long
   * @param feedSetIds   List<Long>
   * @return FeedSetSelector
   */
  public static FeedSetSelector buildExampleGetRequest(long accountId, long feedHolderId, List<Long> feedSetIds) {
    // Set Selector
    FeedSetSelector selector = new FeedSetSelector();
    selector.setAccountId(accountId);
    selector.setFeedHolderId(feedHolderId);
    selector.getFeedSetIds().addAll(feedSetIds);
    selector.setIncludeItemCount(true);
    return selector;
  }
}
