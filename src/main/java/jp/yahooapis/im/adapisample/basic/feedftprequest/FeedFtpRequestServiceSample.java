/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.feedftprequest;

import jp.yahooapis.im.adapisample.basic.feedholder.FeedHolderServiceSample;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201907.Error;
import jp.yahooapis.im.v201907.feedftprequest.FeedFtpRequest;
import jp.yahooapis.im.v201907.feedftprequest.FeedFtpRequestOperation;
import jp.yahooapis.im.v201907.feedftprequest.FeedFtpRequestReturnValue;
import jp.yahooapis.im.v201907.feedftprequest.FeedFtpRequestService;
import jp.yahooapis.im.v201907.feedftprequest.FeedFtpRequestServiceInterface;
import jp.yahooapis.im.v201907.feedftprequest.FeedFtpRequestValues;
import jp.yahooapis.im.v201907.feedftprequest.Operator;

import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example FeedFtpRequestService operation and Utility method collection.
 */
public class FeedFtpRequestServiceSample {

  /**
   * example FeedFtpRequestService operation.
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
      Long feedHolderId = valuesRepositoryFacade.getFeedHolderValuesRepository().getFeedHolderIds().get(0);

      // =================================================================
      // FeedFtpService ADD
      // =================================================================
      // create request.
      FeedFtpRequestOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, Collections.singletonList( //
          createExampleFeedFtpRequest(feedHolderId)) //
      );

      // run
      mutate(addRequest);

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
   * example mutate FeedFtpRequest.
   *
   * @param operation FeedFtpRequestOperation
   * @return FeedFtpRequestValues
   */
  public static List<FeedFtpRequestValues> mutate(FeedFtpRequestOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedFtpRequestService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<FeedFtpRequestReturnValue> feedFtpRequestReturnValueHolder = new Holder<FeedFtpRequestReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedFtpRequestServiceInterface feedFtpService = SoapUtils.createServiceInterface(FeedFtpRequestServiceInterface.class, FeedFtpRequestService.class);
    feedFtpService.mutate(operation, feedFtpRequestReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, feedFtpRequestReturnValueHolder.value.getValues());

    // Response
    return feedFtpRequestReturnValueHolder.value.getValues();
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
   * @param operand   List<FeedFtpRequest>
   * @return FeedFtpRequestOperation
   */
  public static FeedFtpRequestOperation buildExampleMutateRequest(Operator operator, long accountId, List<FeedFtpRequest> operand) {
    FeedFtpRequestOperation operation = new FeedFtpRequestOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example FeedFtpRequest request.
   *
   * @return FeedFtpRequest
   */
  public static FeedFtpRequest createExampleFeedFtpRequest(long feedHolderId) {
    FeedFtpRequest feedFtp = new FeedFtpRequest();
    feedFtp.setFeedHolderId(feedHolderId);
    return feedFtp;
  }
}
