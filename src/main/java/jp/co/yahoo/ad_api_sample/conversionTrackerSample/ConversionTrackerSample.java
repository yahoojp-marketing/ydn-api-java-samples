package jp.co.yahoo.ad_api_sample.conversionTrackerSample;

import jp.co.yahoo.ad_api_sample.error.impl.ErrorEntityFactoryImpl;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201812.Error;
import jp.yahooapis.im.v201812.Paging;
import jp.yahooapis.im.v201812.conversiontracker.AppConversion;
import jp.yahooapis.im.v201812.conversiontracker.AppConversionPlatform;
import jp.yahooapis.im.v201812.conversiontracker.AppConversionType;
import jp.yahooapis.im.v201812.conversiontracker.ConversionCountingType;
import jp.yahooapis.im.v201812.conversiontracker.ConversionTracker;
import jp.yahooapis.im.v201812.conversiontracker.ConversionTrackerCategory;
import jp.yahooapis.im.v201812.conversiontracker.ConversionTrackerOperation;
import jp.yahooapis.im.v201812.conversiontracker.ConversionTrackerPage;
import jp.yahooapis.im.v201812.conversiontracker.ConversionTrackerReturnValue;
import jp.yahooapis.im.v201812.conversiontracker.ConversionTrackerSelector;
import jp.yahooapis.im.v201812.conversiontracker.ConversionTrackerService;
import jp.yahooapis.im.v201812.conversiontracker.ConversionTrackerServiceInterface;
import jp.yahooapis.im.v201812.conversiontracker.ConversionTrackerStatus;
import jp.yahooapis.im.v201812.conversiontracker.ConversionTrackerType;
import jp.yahooapis.im.v201812.conversiontracker.ConversionTrackerValues;
import jp.yahooapis.im.v201812.conversiontracker.ExcludeFromBidding;
import jp.yahooapis.im.v201812.conversiontracker.Operator;
import jp.yahooapis.im.v201812.conversiontracker.Period;
import jp.yahooapis.im.v201812.conversiontracker.StatsPeriod;
import jp.yahooapis.im.v201812.conversiontracker.StatsPeriodCustomDate;
import jp.yahooapis.im.v201812.conversiontracker.WebConversion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.xml.ws.Holder;


/**
 * Sample Program for ConversionTrackerService.<br>
 * Copyright (C) 2014 Yahoo Japan Corporation. All Rights Reserved.
 */
public class ConversionTrackerSample {

  /**
   * main method for ConversionTracker
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    try {
      long accountId = SoapUtils.getAccountId();
      // -----------------------------------------------
      // ConversionTrackerService::mutate(ADD)
      // -----------------------------------------------
      // request
      ConversionTrackerOperation addConversionTrackerOperation = createSampleAddRequest(accountId);

      // call API
      List<ConversionTrackerValues> addResponse = add(addConversionTrackerOperation);

      // -----------------------------------------------
      // ConversionTrackerService::get
      // -----------------------------------------------
      // request
      ConversionTrackerSelector conversionTrackerSelector = createSampleGetRequest(accountId, addResponse);

      // call API
      get(conversionTrackerSelector);

      // -----------------------------------------------
      // ConversionTrackerService::get
      // use CustomDate
      // -----------------------------------------------
      // request
      ConversionTrackerSelector conversionTrackerCustomDateSelector = createSampleGetCustomDateRequest(accountId, addResponse);

      // call API
      get(conversionTrackerCustomDateSelector);

      // -----------------------------------------------
      // ConversionTrackerService::mutate(SET)
      // -----------------------------------------------
      // request
      ConversionTrackerOperation setConversionTrackerOperation = createSampleSetRequest(accountId, addResponse);

      // call API
      set(setConversionTrackerOperation);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Sample Program for ConversionTrackerService ADD.
   *
   * @param operation ConversionTrackerOperation
   * @return ConversionTrackerValues
   */
  public static List<ConversionTrackerValues> add(ConversionTrackerOperation operation) throws Exception {
    // =================================================================
    // ConversionTrackerService
    // =================================================================
    ConversionTrackerServiceInterface conversionTrackerService = SoapUtils.createServiceInterface(ConversionTrackerServiceInterface.class, ConversionTrackerService.class);

    System.out.println("############################################");
    System.out.println("ConversionTrackerService::mutate(ADD)");
    System.out.println("############################################");
    Holder<ConversionTrackerReturnValue> addConversionTrackerReturnValueHolder = new Holder<ConversionTrackerReturnValue>();
    Holder<List<Error>> addConversionTrackerErrorHolder = new Holder<List<Error>>();
    conversionTrackerService.mutate(operation, addConversionTrackerReturnValueHolder, addConversionTrackerErrorHolder);

    // if error
    if (addConversionTrackerErrorHolder.value != null && addConversionTrackerErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(addConversionTrackerErrorHolder.value), true);
    }

    // response
    if (addConversionTrackerReturnValueHolder.value != null) {
      for (ConversionTrackerValues values : addConversionTrackerReturnValueHolder.value.getValues()) {
        if (values.isOperationSucceeded()) {
          // display response
          displayConversionTracker(values.getConversionTracker());
        } else {
          // if error
          SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
        }
      }
    }

    // Response
    return addConversionTrackerReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for ConversionTrackerService GET.
   *
   * @param selector ConversionTrackerSelector
   * @return ConversionTrackerValues
   */
  public static List<ConversionTrackerValues> get(ConversionTrackerSelector selector) throws Exception {
    // =================================================================
    // ConversionTrackerService
    // =================================================================
    ConversionTrackerServiceInterface conversionTrackerService = SoapUtils.createServiceInterface(ConversionTrackerServiceInterface.class, ConversionTrackerService.class);

    // call API
    System.out.println("############################################");
    System.out.println("ConversionTrackerService::get");
    System.out.println("############################################");
    Holder<ConversionTrackerPage> getConversionTrackerPageHolder = new Holder<ConversionTrackerPage>();
    Holder<List<Error>> getConversionTrackerErrorHolder = new Holder<List<Error>>();
    conversionTrackerService.get(selector, getConversionTrackerPageHolder, getConversionTrackerErrorHolder);

    // if error
    if (getConversionTrackerErrorHolder.value != null && getConversionTrackerErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(getConversionTrackerErrorHolder.value), true);
    }

    // response
    if (getConversionTrackerErrorHolder.value != null) {
      displayConversionTrackerPage(getConversionTrackerPageHolder.value);
      if(null != getConversionTrackerPageHolder.value.getPeriod()){
        displayPeriod(getConversionTrackerPageHolder.value.getPeriod());
      }
      for (ConversionTrackerValues values : getConversionTrackerPageHolder.value.getValues()) {
        if (values.isOperationSucceeded()) {
          displayConversionTracker(values.getConversionTracker());
        } else {
          SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
        }
      }
    }

    // Response
    return getConversionTrackerPageHolder.value.getValues();
  }

  /**
   * Sample Program for ConversionTrackerService SET.
   *
   * @param operation ConversionTrackerOperation
   * @return ConversionTrackerValues
   */
  public static List<ConversionTrackerValues> set(ConversionTrackerOperation operation) throws Exception {
    // =================================================================
    // ConversionTrackerService
    // =================================================================
    ConversionTrackerServiceInterface conversionTrackerService = SoapUtils.createServiceInterface(ConversionTrackerServiceInterface.class, ConversionTrackerService.class);

    // call API
    System.out.println("############################################");
    System.out.println("ConversionTrackerService::mutate(SET)");
    System.out.println("############################################");
    Holder<ConversionTrackerReturnValue> setConversionTrackerReturnValueHolder = new Holder<ConversionTrackerReturnValue>();
    Holder<List<Error>> setConversionTrackerErrorHolder = new Holder<List<Error>>();
    conversionTrackerService.mutate(operation, setConversionTrackerReturnValueHolder, setConversionTrackerErrorHolder);

    // if error
    if (setConversionTrackerErrorHolder.value != null && setConversionTrackerErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(setConversionTrackerErrorHolder.value), true);
    }

    // response
    if (setConversionTrackerReturnValueHolder.value != null) {
      for (ConversionTrackerValues values : setConversionTrackerReturnValueHolder.value.getValues()) {
        if (values.isOperationSucceeded()) {
          if(null != values.getStatsPeriodCustomDate()){
            displayStatsPeriodCustomDate(values.getStatsPeriodCustomDate());
          }
          displayConversionTracker(values.getConversionTracker());
        } else {
          SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
        }
      }
    }
    // Response
    return setConversionTrackerReturnValueHolder.value.getValues();
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @return ConversionTrackerOperation
   */
  public static ConversionTrackerOperation createSampleAddRequest(long accountId) {

    WebConversion webConversion = new WebConversion();
    webConversion.setAccountId(accountId);
    webConversion.setConversionTrackerName("SampleWebConversionTracker_CreateOn_" + SoapUtils.getCurrentTimestamp());
    webConversion.setStatus(ConversionTrackerStatus.ENABLED);
    webConversion.setCategory(ConversionTrackerCategory.PURCHASE);
    webConversion.setConversionTrackerType(ConversionTrackerType.WEB_CONVERSION);
    webConversion.setCountingType(ConversionCountingType.MANY_PER_CLICK);
    webConversion.setExcludeFromBidding(ExcludeFromBidding.FALSE);
    webConversion.setMeasurementPeriod(31);
    webConversion.setMeasurementPeriodView(15);

    AppConversion appConversion = new AppConversion();
    appConversion.setAccountId(accountId);
    appConversion.setConversionTrackerName("SampleAppConversionTracker_CreateOn_" + SoapUtils.getCurrentTimestamp());
    appConversion.setStatus(ConversionTrackerStatus.ENABLED);
    appConversion.setCategory(ConversionTrackerCategory.DOWNLOAD);
    appConversion.setConversionTrackerType(ConversionTrackerType.APP_CONVERSION);
    appConversion.setAppId("1234567893");
    appConversion.setAppPlatform(AppConversionPlatform.ITUNES);
    appConversion.setAppConversionType(AppConversionType.FIRST_OPEN);
    appConversion.setCountingType(ConversionCountingType.ONE_PER_CLICK);
    appConversion.setExcludeFromBidding(ExcludeFromBidding.FALSE);
    appConversion.setMeasurementPeriod(31);
    appConversion.setMeasurementPeriodView(15);

    ConversionTrackerOperation addConversionTrackerOperation = new ConversionTrackerOperation();
    addConversionTrackerOperation.setAccountId(accountId);
    addConversionTrackerOperation.setOperator(Operator.ADD);
    addConversionTrackerOperation.getOperand().add(webConversion);
    addConversionTrackerOperation.getOperand().add(appConversion);

    return addConversionTrackerOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId               long
   * @param conversionTrackerValues ConversionTrackerValues
   * @return ConversionTrackerSelector
   */
  public static ConversionTrackerSelector createSampleGetRequest(long accountId, List<ConversionTrackerValues> conversionTrackerValues) {
    // Set Selector
    ConversionTrackerSelector conversionTrackerSelector = new ConversionTrackerSelector();
    conversionTrackerSelector.setAccountId(accountId);

    for (ConversionTrackerValues values : conversionTrackerValues) {
      conversionTrackerSelector.getConversionTrackerIds().add(values.getConversionTracker().getConversionTrackerId());
    }

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    conversionTrackerSelector.setPaging(paging);

    return conversionTrackerSelector;
  }

  /**
   * create sample request.
   * use CustomDate.
   *
   * @param accountId               long
   * @param conversionTrackerValues ConversionTrackerValues
   * @return ConversionTrackerSelector
   */
  public static ConversionTrackerSelector createSampleGetCustomDateRequest(long accountId, List<ConversionTrackerValues> conversionTrackerValues) {
    // Set Selector
    ConversionTrackerSelector conversionTrackerSelector = new ConversionTrackerSelector();
    conversionTrackerSelector.setAccountId(accountId);
    conversionTrackerSelector.setStatsPeriod(StatsPeriod.CUSTOM_DATE);

    for (ConversionTrackerValues values : conversionTrackerValues) {
      conversionTrackerSelector.getConversionTrackerIds().add(values.getConversionTracker().getConversionTrackerId());
    }

    StatsPeriodCustomDate statsPeriodCustomDate = new StatsPeriodCustomDate();
    statsPeriodCustomDate.setStatsStartDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()));
    statsPeriodCustomDate.setStatsEndDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now().plusMonths(1L)));
    conversionTrackerSelector.setStatsPeriodCustomDate(statsPeriodCustomDate);

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    conversionTrackerSelector.setPaging(paging);

    return conversionTrackerSelector;
  }

  /**
   * create sample request.
   *
   * @param accountId               long
   * @param conversionTrackerValues CampaignValues
   * @return ConversionTrackerOperation
   */
  public static ConversionTrackerOperation createSampleSetRequest(long accountId, List<ConversionTrackerValues> conversionTrackerValues) {
    ConversionTrackerOperation setConversionTrackerOperation = new ConversionTrackerOperation();
    setConversionTrackerOperation.setAccountId(accountId);
    setConversionTrackerOperation.setOperator(Operator.SET);

    for (ConversionTrackerValues values : conversionTrackerValues) {
      if (values.getConversionTracker().getConversionTrackerType() == ConversionTrackerType.WEB_CONVERSION) {
        WebConversion webConversion = new WebConversion();
        webConversion.setAccountId(accountId);
        webConversion.setConversionTrackerId(values.getConversionTracker().getConversionTrackerId());
        webConversion.setConversionTrackerName("SampleWebConversionTracker_UpdateOn_" + SoapUtils.getCurrentTimestamp());
        webConversion.setStatus(ConversionTrackerStatus.DISABLED);
        webConversion.setCategory(ConversionTrackerCategory.PAGE_VIEW);
        webConversion.setUserRevenueValue((long) 300);
        webConversion.setConversionTrackerType(ConversionTrackerType.WEB_CONVERSION);
        webConversion.setMeasurementPeriod(32);
        webConversion.setMeasurementPeriodView(14);
        setConversionTrackerOperation.getOperand().add(webConversion);
      } else {
        AppConversion appConversion = new AppConversion();
        appConversion.setAccountId(accountId);
        appConversion.setConversionTrackerId(values.getConversionTracker().getConversionTrackerId());
        appConversion.setConversionTrackerName("SampleAppConversionTracker_UpdateOn_" + SoapUtils.getCurrentTimestamp());
        appConversion.setStatus(ConversionTrackerStatus.DISABLED);
        appConversion.setCategory(ConversionTrackerCategory.DOWNLOAD);
        appConversion.setUserRevenueValue((long) 300);
        appConversion.setConversionTrackerType(ConversionTrackerType.APP_CONVERSION);
        appConversion.setMeasurementPeriod(32);
        appConversion.setMeasurementPeriodView(14);
        setConversionTrackerOperation.getOperand().add(appConversion);
      }
    }

    return setConversionTrackerOperation;
  }

  /**
   * display Period entity to stdout.
   *
   * @param period Period entity for display.
   */
  private static void displayPeriod(Period period) {
    if(null != period.getPeriodStartDate()){
      System.out.println("periodStartDate/periodDate = " + period.getPeriodStartDate().getPeriodDate());
      System.out.println("periodStartDate/periodTime = " + period.getPeriodStartDate().getPeriodTime());
    }

    if(null != period.getPeriodEndDate()){
      System.out.println("periodEndDate/periodDate = " + period.getPeriodEndDate().getPeriodDate());
      System.out.println("periodEndDate/periodTime = " + period.getPeriodEndDate().getPeriodTime());
    }
  }

  private static void displayConversionTrackerPage(ConversionTrackerPage conversionTrackerPage) {
    System.out.println("totalConversions = " + conversionTrackerPage.getTotalConversions());
    System.out.println("totalConversionValue = " + conversionTrackerPage.getTotalConversionValue());
    System.out.println("totalConversionsViaAdClick = " + conversionTrackerPage.getTotalConversionsViaAdClick());
    System.out.println("totalConversionValueViaAdClick = " + conversionTrackerPage.getTotalConversionValueViaAdClick());
    System.out.println("totalAllConversions = " + conversionTrackerPage.getTotalAllConversions());
    System.out.println("totalAllConversionValue = " + conversionTrackerPage.getTotalAllConversionValue());
    System.out.println("totalCrossDeviceConversions = " + conversionTrackerPage.getTotalCrossDeviceConversions());

  }

  /**
   * display ConversionTracker entity to stdout.
   *
   * @param conversionTracker ConversionTracker entity for display.
   */
  private static void displayConversionTracker(ConversionTracker conversionTracker) {
    System.out.println("accountId = " + conversionTracker.getAccountId());
    System.out.println("conversionTrackerId = " + conversionTracker.getConversionTrackerId());
    System.out.println("conversionTrackerName = " + conversionTracker.getConversionTrackerName());
    System.out.println("status = " + conversionTracker.getStatus());
    System.out.println("category = " + conversionTracker.getCategory());
    System.out.println("conversions = " + conversionTracker.getConversions());
    System.out.println("conversionValue = " + conversionTracker.getConversionValue());
    System.out.println("conversionsViaAdClick = " + conversionTracker.getConversionsViaAdClick());
    System.out.println("conversionValueViaAdClick = " + conversionTracker.getConversionValueViaAdClick());
    System.out.println("userRevenueValue = " + conversionTracker.getUserRevenueValue());
    System.out.println("conversionTrackerType = " + conversionTracker.getConversionTrackerType());
    System.out.println("countingType = " + conversionTracker.getCountingType());
    System.out.println("measurementPeriod = " + conversionTracker.getMeasurementPeriod());
    System.out.println("measurementPeriodView = " + conversionTracker.getMeasurementPeriodView());
    System.out.println("excludeFromBidding = " + conversionTracker.getExcludeFromBidding());
    System.out.println("allConversions = " + conversionTracker.getAllConversions());
    System.out.println("allConversionValue = " + conversionTracker.getAllConversionValue());
    System.out.println("crossDeviceConversions = " + conversionTracker.getCrossDeviceConversions());
    System.out.println("mostRecentConversionDate = " + conversionTracker.getMostRecentConversionDate());
    if (conversionTracker.getConversionTrackerType() == ConversionTrackerType.WEB_CONVERSION) {
      WebConversion webConversion = (WebConversion) conversionTracker;
      System.out.println("snippet = " + webConversion.getSnippet());
    } else {
      AppConversion appConversion = (AppConversion) conversionTracker;
      System.out.println("appId = " + appConversion.getAppId());
      System.out.println("appPlatform = " + appConversion.getAppPlatform());
      System.out.println("appConversionType = " + appConversion.getAppConversionType());
    }
    System.out.println("---------");
  }


  /**
   * display StatsPeriodCustomDate entity to stdout.
   *
   * @param statsPeriodCustomDate StatsPeriodCustomDate entity for display.
   */
  private static void displayStatsPeriodCustomDate(StatsPeriodCustomDate statsPeriodCustomDate) {
    System.out.println("statsPeriodCustomDate/statsStartDate = " + statsPeriodCustomDate.getStatsStartDate());
    System.out.println("statsPeriodCustomDate/statsEndDate = " + statsPeriodCustomDate.getStatsEndDate());
    System.out.println("---------");
  }

}
