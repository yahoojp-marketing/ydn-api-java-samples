/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.feedholder;

import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201911.Error;
import jp.yahooapis.im.v201911.Paging;
import jp.yahooapis.im.v201911.feedholder.FeedHolderOperation;
import jp.yahooapis.im.v201911.feedholder.FeedHolderPage;
import jp.yahooapis.im.v201911.feedholder.FeedHolderRecord;
import jp.yahooapis.im.v201911.feedholder.FeedHolderReturnValue;
import jp.yahooapis.im.v201911.feedholder.FeedHolderSelector;
import jp.yahooapis.im.v201911.feedholder.FeedHolderService;
import jp.yahooapis.im.v201911.feedholder.FeedHolderServiceInterface;
import jp.yahooapis.im.v201911.feedholder.FeedHolderValues;
import jp.yahooapis.im.v201911.feedholder.Operator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example FeedHolderService operation and Utility method collection.
 */
public class FeedHolderServiceSample {

  /**
   * example FeedHolderService operation.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      ValuesHolder valuesHolder = new ValuesHolder();
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      long accountId = SoapUtils.getAccountId();

      // =================================================================
      // FeedHolderService ADD
      // =================================================================
      // create request.
      FeedHolderOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, Collections.singletonList(createExampleFeedHolderRecordRequest(accountId)));

      // run
      List<FeedHolderValues> addResponse = mutate(addRequest);
      valuesHolder.setFeedHolderValuesList(addResponse);

      // =================================================================
      // FeedHolderService get
      // =================================================================
      // create request.
      FeedHolderSelector getRequest = buildExampleGetRequest(accountId, valuesRepositoryFacade.getFeedHolderValuesRepository().getFeedHolderIds());

      // run
      get(getRequest);

      // =================================================================
      // FeedHolderService SET
      // =================================================================
      // create request.
      FeedHolderOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId, createExampleSetRequest(valuesRepositoryFacade.getFeedHolderValuesRepository().getFeedHolderRecords()));

      // run
      mutate(setRequest);

      // =================================================================
      // FeedHolderService REMOVE
      // =================================================================
      // create request.
      FeedHolderOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getFeedHolderValuesRepository().getFeedHolderRecords());

      // run
      mutate(removeRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example get FeedHolder.
   *
   * @param feedHolderSelector FeedHolderSelector
   * @return FeedHolderValues
   */
  public static List<FeedHolderValues> get(FeedHolderSelector feedHolderSelector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedHolderService::get");
    System.out.println("############################################");

    Holder<FeedHolderPage> feedHolderPage = new Holder<FeedHolderPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedHolderServiceInterface feedHolderService = SoapUtils.createServiceInterface(FeedHolderServiceInterface.class, FeedHolderService.class);
    feedHolderService.get(feedHolderSelector, feedHolderPage, errorHolder);

    SoapUtils.checkSoapError(errorHolder, feedHolderPage.value.getValues());

    // Response
    return feedHolderPage.value.getValues();
  }

  /**
   * example mutate FeedHolder.
   *
   * @param operation FeedHolderOperation
   * @return FeedHolderValues
   */
  public static List<FeedHolderValues> mutate(FeedHolderOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedHolderService::mutate(" + operation.getOperator().toString() + ")");
    System.out.println("############################################");

    Holder<FeedHolderReturnValue> feedHolderReturnValueHolder = new Holder<FeedHolderReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedHolderServiceInterface feedHolderService = SoapUtils.createServiceInterface(FeedHolderServiceInterface.class, FeedHolderService.class);
    feedHolderService.mutate(operation, feedHolderReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, feedHolderReturnValueHolder.value.getValues());

    // Response
    return feedHolderReturnValueHolder.value.getValues();
  }

  /**
   * example get request.
   *
   * @param accountId     long
   * @param feedHolderIds List<Long>
   * @return FeedHolderSelector
   */
  public static FeedHolderSelector buildExampleGetRequest(long accountId, List<Long> feedHolderIds) {
    FeedHolderSelector selector = new FeedHolderSelector();
    selector.setAccountId(accountId);
    selector.getFeedHolderIds().addAll(feedHolderIds);
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);
    return selector;
  }

  /**
   * example mutate request.
   *
   * @param operator  Operator
   * @param accountId long
   * @param operand   List<FeedHolderRecord>
   * @return FeedHolderOperation
   */
  public static FeedHolderOperation buildExampleMutateRequest(Operator operator, long accountId, List<FeedHolderRecord> operand) {
    FeedHolderOperation operation = new FeedHolderOperation();
    operation.setAccountId(accountId);
    operation.setOperator(operator);
    operation.getOperand().addAll(operand);
    return operation;
  }

  /**
   * example FeedHolderRecord request.
   *
   * @param accountId long
   * @return FeedHolderRecord
   */
  public static FeedHolderRecord createExampleFeedHolderRecordRequest(long accountId) {
    FeedHolderRecord operand = new FeedHolderRecord();
    operand.setAccountId(accountId);
    operand.setFeedHolderName("Sample_CreateOn_" + SoapUtils.getCurrentTimestamp());
    return operand;
  }

  /**
   * example FeedHolderRecord set request.
   *
   * @param feedHolderRecords List<FeedHolderRecord>
   * @return List<FeedHolderRecord>
   */
  public static List<FeedHolderRecord> createExampleSetRequest(List<FeedHolderRecord> feedHolderRecords) {
    // create operands
    List<FeedHolderRecord> operands = new ArrayList<>();

    for (FeedHolderRecord holderRecord : feedHolderRecords) {
      FeedHolderRecord operand = new FeedHolderRecord();
      operand.setAccountId(holderRecord.getAccountId());
      operand.setFeedHolderId(holderRecord.getFeedHolderId());
      operand.setFeedHolderName("Sample_UpdateOn_" + holderRecord.getFeedHolderId() + "_" + SoapUtils.getCurrentTimestamp());
      operands.add(operand);
    }

    return operands;
  }

  /**
   * create basic FeedHolder.
   *
   * @return ValuesHolder
   */
  public static ValuesHolder create() throws Exception {
    FeedHolderOperation request = buildExampleMutateRequest(Operator.ADD, SoapUtils.getAccountId(), Collections.singletonList(createExampleFeedHolderRecordRequest(SoapUtils.getAccountId())));
    List<FeedHolderValues> response = mutate(request);
    ValuesHolder valuesHolder = new ValuesHolder();
    valuesHolder.setFeedHolderValuesList(response);
    return valuesHolder;
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    if (valuesHolder.getFeedHolderValuesList().size() > 0) {
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      mutate(buildExampleMutateRequest(Operator.REMOVE, SoapUtils.getAccountId(), valuesRepositoryFacade.getFeedHolderValuesRepository().getFeedHolderRecords()));
    }
  }
}
