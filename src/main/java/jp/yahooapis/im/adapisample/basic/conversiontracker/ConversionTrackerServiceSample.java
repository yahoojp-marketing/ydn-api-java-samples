/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.conversiontracker;

import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.v201911.Error;
import jp.yahooapis.im.v201911.Paging;
import jp.yahooapis.im.v201911.conversiontracker.AppConversion;
import jp.yahooapis.im.v201911.conversiontracker.AppConversionPlatform;
import jp.yahooapis.im.v201911.conversiontracker.AppConversionType;
import jp.yahooapis.im.v201911.conversiontracker.ConversionCountingType;
import jp.yahooapis.im.v201911.conversiontracker.ConversionTracker;
import jp.yahooapis.im.v201911.conversiontracker.ConversionTrackerCategory;
import jp.yahooapis.im.v201911.conversiontracker.ConversionTrackerOperation;
import jp.yahooapis.im.v201911.conversiontracker.ConversionTrackerPage;
import jp.yahooapis.im.v201911.conversiontracker.ConversionTrackerReturnValue;
import jp.yahooapis.im.v201911.conversiontracker.ConversionTrackerSelector;
import jp.yahooapis.im.v201911.conversiontracker.ConversionTrackerService;
import jp.yahooapis.im.v201911.conversiontracker.ConversionTrackerServiceInterface;
import jp.yahooapis.im.v201911.conversiontracker.ConversionTrackerStatus;
import jp.yahooapis.im.v201911.conversiontracker.ConversionTrackerType;
import jp.yahooapis.im.v201911.conversiontracker.ConversionTrackerValues;
import jp.yahooapis.im.v201911.conversiontracker.ExcludeFromBidding;
import jp.yahooapis.im.v201911.conversiontracker.Operator;
import jp.yahooapis.im.v201911.conversiontracker.WebConversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example ConversionTrackerService operation and Utility method collection.
 */
public class ConversionTrackerServiceSample {

  /**
   * example ConversionTrackerService operation.
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
      // ConversionTrackerService ADD
      // =================================================================
      // create request.
      ConversionTrackerOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, Arrays.asList(createWebConversionRequest(), createAppConversionRequest()));

      // run
      List<ConversionTrackerValues> addResponse = mutate(addRequest);

      List<ConversionTracker> conversionTrackers = new ArrayList<>();
      List<Long> conversionTrackerIds = new ArrayList<>();
      for (ConversionTrackerValues conversionTrackerValues : addResponse) {
        conversionTrackers.add(conversionTrackerValues.getConversionTracker());
        conversionTrackerIds.add(conversionTrackerValues.getConversionTracker().getConversionTrackerId());
      }

      // =================================================================
      // ConversionTrackerService GET
      // =================================================================
      // create request.
      ConversionTrackerSelector getRequest = buildExampleGetRequest(accountId, conversionTrackerIds);

      // run
      get(getRequest);

      //waiting
      Thread.sleep(180000);

      // =================================================================
      // ConversionTrackerService SET
      // =================================================================
      // create request.
      ConversionTrackerOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId, createExampleSetRequest(conversionTrackers));

      // run
      mutate(setRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example mutate conversions.
   *
   * @param operation ConversionTrackerOperation
   * @return ConversionTrackerValues
   */
  public static List<ConversionTrackerValues> mutate(ConversionTrackerOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ConversionTrackerService::mutate(" + operation.getOperator().toString() + ")");
    System.out.println("############################################");

    Holder<ConversionTrackerReturnValue> conversionTrackerReturnValueHolder = new Holder<ConversionTrackerReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    ConversionTrackerServiceInterface conversionTrackerService = SoapUtils.createServiceInterface(ConversionTrackerServiceInterface.class, ConversionTrackerService.class);
    conversionTrackerService.mutate(operation, conversionTrackerReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, conversionTrackerReturnValueHolder.value.getValues());

    // Response
    return conversionTrackerReturnValueHolder.value.getValues();
  }

  /**
   * example get conversions.
   *
   * @param selector ConversionTrackerSelector
   * @return ConversionTrackerValues
   */
  public static List<ConversionTrackerValues> get(ConversionTrackerSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ConversionTrackerService::get");
    System.out.println("############################################");

    Holder<ConversionTrackerPage> conversionTrackerPageHolder = new Holder<ConversionTrackerPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    ConversionTrackerServiceInterface conversionTrackerService = SoapUtils.createServiceInterface(ConversionTrackerServiceInterface.class, ConversionTrackerService.class);
    conversionTrackerService.get(selector, conversionTrackerPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, conversionTrackerPageHolder.value.getValues());

    // Response
    return conversionTrackerPageHolder.value.getValues();
  }

  /**
   * example get request.
   *
   * @param accountId            long
   * @param conversionTrackerIds List<Long>
   * @return ConversionTrackerSelector
   */
  public static ConversionTrackerSelector buildExampleGetRequest(long accountId, List<Long> conversionTrackerIds) {
    ConversionTrackerSelector selector = new ConversionTrackerSelector();
    selector.setAccountId(accountId);
    selector.getConversionTrackerIds().addAll(conversionTrackerIds);
    selector.getConversionTrackerTypes().addAll(Arrays.asList(ConversionTrackerType.WEB_CONVERSION, ConversionTrackerType.APP_CONVERSION));
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
   * @param operand   List<ConversionTracker>
   * @return mutate
   */
  public static ConversionTrackerOperation buildExampleMutateRequest(Operator operator, long accountId, List<ConversionTracker> operand) {
    ConversionTrackerOperation operation = new ConversionTrackerOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);
    return operation;
  }

  /**
   * example WebConversion request.
   *
   * @return WebConversion
   */
  public static WebConversion createWebConversionRequest() {
    WebConversion operand = new WebConversion();
    operand.setConversionTrackerName("SampleWebConversionTracker_CreateOn_" + SoapUtils.getCurrentTimestamp());
    operand.setStatus(ConversionTrackerStatus.ENABLED);
    operand.setCategory(ConversionTrackerCategory.PURCHASE);
    operand.setConversionTrackerType(ConversionTrackerType.WEB_CONVERSION);
    operand.setCountingType(ConversionCountingType.MANY_PER_CLICK);
    operand.setExcludeFromBidding(ExcludeFromBidding.TRUE);
    return operand;
  }

  /**
   * example AppConversion request.
   *
   * @return AppConversion
   */
  public static AppConversion createAppConversionRequest() {
    AppConversion operand = new AppConversion();
    operand.setConversionTrackerName("SampleAppConversionTracker_CreateOn_" + SoapUtils.getCurrentTimestamp());
    operand.setStatus(ConversionTrackerStatus.ENABLED);
    operand.setCategory(ConversionTrackerCategory.DOWNLOAD);
    operand.setConversionTrackerType(ConversionTrackerType.APP_CONVERSION);
    operand.setAppId("sample123_" + SoapUtils.getCurrentTimestamp());
    operand.setAppPlatform(AppConversionPlatform.ANDROID_MARKET);
    operand.setAppConversionType(AppConversionType.FIRST_OPEN);
    operand.setCountingType(ConversionCountingType.ONE_PER_CLICK);
    operand.setExcludeFromBidding(ExcludeFromBidding.FALSE);
    return operand;
  }

  /**
   * example conversionTracker set request.
   *
   * @param conversionTrackers List<ConversionTracker>
   * @return array entity.
   */
  public static List<ConversionTracker> createExampleSetRequest(List<ConversionTracker> conversionTrackers) {
    // create operands
    List<ConversionTracker> operands = new ArrayList<>();

    for (ConversionTracker conversionTracker : conversionTrackers) {
      ConversionTracker operand = null;
      switch (conversionTracker.getConversionTrackerType()) {
        default:
        case WEB_CONVERSION:
          operand = new WebConversion();
          operand.setConversionTrackerId(conversionTracker.getConversionTrackerId());
          operand.setConversionTrackerType(conversionTracker.getConversionTrackerType());
          operand.setConversionTrackerName("SampleWebConversionTracker_UpdateOn_" + conversionTracker.getConversionTrackerId() + "_" + SoapUtils.getCurrentTimestamp());
          operand.setStatus(ConversionTrackerStatus.DISABLED);
          operand.setCategory(ConversionTrackerCategory.PAGE_VIEW);
          operand.setUserRevenueValue(300L);
          operands.add(operand);
          break;

        case APP_CONVERSION:
          operand = new AppConversion();
          operand.setConversionTrackerId(conversionTracker.getConversionTrackerId());
          operand.setConversionTrackerType(conversionTracker.getConversionTrackerType());
          operand.setConversionTrackerName("SampleAppConversionTracker_UpdateOn_" + conversionTracker.getConversionTrackerId() + "_" + SoapUtils.getCurrentTimestamp());
          operand.setStatus(ConversionTrackerStatus.DISABLED);
          operand.setCategory(ConversionTrackerCategory.DOWNLOAD);
          operand.setUserRevenueValue(300L);
          operands.add(operand);
          break;
      }
    }

    return operands;
  }
}
