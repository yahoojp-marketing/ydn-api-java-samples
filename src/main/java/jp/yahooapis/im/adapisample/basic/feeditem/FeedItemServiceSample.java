/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.feeditem;

import jp.yahooapis.im.adapisample.basic.feedholder.FeedHolderServiceSample;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201911.Error;
import jp.yahooapis.im.v201911.feeditem.Availability;
import jp.yahooapis.im.v201911.feeditem.FeedItem;
import jp.yahooapis.im.v201911.feeditem.FeedItemOperation;
import jp.yahooapis.im.v201911.feeditem.FeedItemReturnValue;
import jp.yahooapis.im.v201911.feeditem.FeedItemService;
import jp.yahooapis.im.v201911.feeditem.FeedItemServiceInterface;
import jp.yahooapis.im.v201911.feeditem.FeedItemValues;
import jp.yahooapis.im.v201911.feeditem.Operator;

import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example FeedItemService operation and Utility method collection.
 */
public class FeedItemServiceSample {

  /**
   * example FeedItemService operation.
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
      // FeedItemService SET
      // =================================================================
      // create request.
      FeedItemOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId, Collections.singletonList( //
          createExampleFeedItem(feedHolderId)) //
      );

      // run
      mutate(setRequest);

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
   * example mutate FeedItem.
   *
   * @param operation FeedItemOperation
   * @return FeedItemValues
   */
  public static List<FeedItemValues> mutate(FeedItemOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedItemService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<FeedItemReturnValue> feedItemReturnValueHolder = new Holder<FeedItemReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedItemServiceInterface feedItemService = SoapUtils.createServiceInterface(FeedItemServiceInterface.class, FeedItemService.class);
    feedItemService.mutate(operation, feedItemReturnValueHolder, errorHolder);
    SoapUtils.checkSoapError(errorHolder, feedItemReturnValueHolder.value.getValues());

    // Response
    return feedItemReturnValueHolder.value.getValues();
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
   * @param operand   List<FeedItem>
   * @return FeedItemOperation
   */
  public static FeedItemOperation buildExampleMutateRequest(Operator operator, long accountId, List<FeedItem> operand) {
    FeedItemOperation operation = new FeedItemOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example FeedItem request.
   *
   * @return FeedItem
   */
  public static FeedItem createExampleFeedItem(long feedHolderId) {
    FeedItem feedItem = new FeedItem();
    feedItem.setFeedHolderId(feedHolderId);
    feedItem.setItemId("100");
    feedItem.setPrice((long)1000);
    feedItem.setSalePrice((long)2000);
    feedItem.setFormattedSalePrice("2,000");
    feedItem.setFormattedPrice("3,000");
    feedItem.setInStock((long)1);
    feedItem.setCapacity((long)300);
    feedItem.setDisplaySettings((long)1);
    feedItem.setAvailability(Availability.IN_STOCK);

    return feedItem;
  }
}
