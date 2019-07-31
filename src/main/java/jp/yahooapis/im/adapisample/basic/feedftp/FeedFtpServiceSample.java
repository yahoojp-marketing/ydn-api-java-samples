/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.feedftp;

import jp.yahooapis.im.adapisample.basic.feedholder.FeedHolderServiceSample;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201907.Error;
import jp.yahooapis.im.v201907.feedftp.ActiveStatus;
import jp.yahooapis.im.v201907.feedftp.FeedFtp;
import jp.yahooapis.im.v201907.feedftp.FeedFtpOperation;
import jp.yahooapis.im.v201907.feedftp.FeedFtpPage;
import jp.yahooapis.im.v201907.feedftp.FeedFtpReturnValue;
import jp.yahooapis.im.v201907.feedftp.FeedFtpSelector;
import jp.yahooapis.im.v201907.feedftp.FeedFtpService;
import jp.yahooapis.im.v201907.feedftp.FeedFtpServiceInterface;
import jp.yahooapis.im.v201907.feedftp.FeedFtpValues;
import jp.yahooapis.im.v201907.feedftp.ItemListUploadType;
import jp.yahooapis.im.v201907.feedftp.Operator;
import jp.yahooapis.im.v201907.feedftp.ScheduleHourly;
import jp.yahooapis.im.v201907.feedftp.ScheduleType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example FeedFtpService operation and Utility method collection.
 */
public class FeedFtpServiceSample {

  /**
   * example FeedFtpService operation.
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
      FeedFtpOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, Collections.singletonList( //
          createExampleFeedFtp(feedHolderId)) //
      );

      // run
      List<FeedFtp> feedFtps = new ArrayList<>();
      List<FeedFtpValues> addResponse = mutate(addRequest);
      for (FeedFtpValues feedFtpValues : addResponse) {
        feedFtps.add(feedFtpValues.getFeedFtp());
      }

      // =================================================================
      // FeedFtpService GET
      // =================================================================
      // create request.
      FeedFtpSelector getRequest = buildExampleGetRequest(accountId, Collections.singletonList(feedHolderId));

      // run
      get(getRequest);

      // =================================================================
      // FeedFtpService SET
      // =================================================================
      // create request.
      FeedFtpOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId, //
          createExampleSetRequest(feedFtps) //
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
   * Sample Program for FeedFtpService GET.
   *
   * @param selector FeedFtpSelector
   * @return FeedFtpValues
   */
  public static List<FeedFtpValues> get(FeedFtpSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedFtpService::get");
    System.out.println("############################################");

    Holder<FeedFtpPage> feedFtpPageHolder = new Holder<FeedFtpPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedFtpServiceInterface feedFtpService = SoapUtils.createServiceInterface(FeedFtpServiceInterface.class, FeedFtpService.class);
    feedFtpService.get(selector, feedFtpPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, feedFtpPageHolder.value.getValues());

    // Response
    return feedFtpPageHolder.value.getValues();
  }

  /**
   * example mutate FeedFtps.
   *
   * @param operation FeedFtpOperation
   * @return FeedFtpValues
   */
  public static List<FeedFtpValues> mutate(FeedFtpOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedFtpService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<FeedFtpReturnValue> feedFtpReturnValueHolder = new Holder<FeedFtpReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedFtpServiceInterface feedFtpService = SoapUtils.createServiceInterface(FeedFtpServiceInterface.class, FeedFtpService.class);
    feedFtpService.mutate(operation, feedFtpReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, feedFtpReturnValueHolder.value.getValues());

    // Response
    return feedFtpReturnValueHolder.value.getValues();
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
   * @param operand   List<FeedFtp>
   * @return FeedFtpOperation
   */
  public static FeedFtpOperation buildExampleMutateRequest(Operator operator, long accountId, List<FeedFtp> operand) {
    FeedFtpOperation operation = new FeedFtpOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example FeedFtp request.
   *
   * @return FeedFtp
   */
  public static FeedFtp createExampleFeedFtp(long feedHolderId) {
    FeedFtp feedFtp = new FeedFtp();
    feedFtp.setFeedHolderId(feedHolderId);
    feedFtp.setItemListUploadType(ItemListUploadType.UPDATE_ALL);

    ScheduleHourly schedule = new ScheduleHourly();
    schedule.setType(ScheduleType.HOURLY);
    schedule.setInterval(1);
    feedFtp.setSchedule(schedule);

    feedFtp.setFeedUrl("ftp://test.com/test1.tsv");
    feedFtp.setUserName("user_name_1");
    feedFtp.setUserPassword("user_password_1");
    feedFtp.setActiveStatus(ActiveStatus.ACTIVE);
    return feedFtp;
  }

  /**
   * create sample request.
   *
   * @param accountId     long
   * @param feedHolderIds List<Long>
   * @return FeedFtpSelector
   */
  public static FeedFtpSelector buildExampleGetRequest(long accountId, List<Long> feedHolderIds) {
    // Set Selector
    FeedFtpSelector selector = new FeedFtpSelector();
    selector.setAccountId(accountId);
    selector.getFeedHolderIds().addAll(feedHolderIds);

    return selector;
  }

  /**
   * example FeedFtps set request.
   *
   * @param feedFtps List<FeedFtp>
   * @return List<FeedFtp>
   */
  public static List<FeedFtp> createExampleSetRequest(List<FeedFtp> feedFtps)
  {
    // create operands
    List<FeedFtp> operands = new ArrayList<>();

    for (FeedFtp feedFtp : feedFtps) {
      FeedFtp operand = new FeedFtp();
      operand.setFeedHolderId(feedFtp.getFeedHolderId());
      operand.setItemListUploadType(ItemListUploadType.UPDATE_ALL);

      ScheduleHourly schedule = new ScheduleHourly();
      schedule.setType(ScheduleType.HOURLY);
      schedule.setInterval(1);
      operand.setSchedule(schedule);

      operand.setFeedUrl("ftp://test.com/test1.tsv");
      operand.setUserName("user_name_1");
      operand.setUserPassword("user_password_1");
      operand.setActiveStatus(ActiveStatus.ACTIVE);
      operands.add(operand);
    }
    return operands;
  }
}
