package jp.co.yahoo.ad_api_sample.searchKeywordSample;

import jp.co.yahoo.ad_api_sample.error.impl.ErrorEntityFactoryImpl;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201812.Error;
import jp.yahooapis.im.v201812.Paging;
import jp.yahooapis.im.v201812.searchkeywordidea.KeywordFrequency;
import jp.yahooapis.im.v201812.searchkeywordidea.KeywordRecency;
import jp.yahooapis.im.v201812.searchkeywordidea.MatchType;
import jp.yahooapis.im.v201812.searchkeywordidea.SearchKeywordIdea;
import jp.yahooapis.im.v201812.searchkeywordidea.SearchKeywordIdeaPage;
import jp.yahooapis.im.v201812.searchkeywordidea.SearchKeywordIdeaSelector;
import jp.yahooapis.im.v201812.searchkeywordidea.SearchKeywordIdeaService;
import jp.yahooapis.im.v201812.searchkeywordidea.SearchKeywordIdeaServiceInterface;
import jp.yahooapis.im.v201812.searchkeywordidea.SearchKeywordIdeaValues;
import jp.yahooapis.im.v201812.searchkeywordidea.SortField;
import jp.yahooapis.im.v201812.searchkeywordidea.SortType;
import jp.yahooapis.im.v201812.searchkeywordlist.Operator;
import jp.yahooapis.im.v201812.searchkeywordlist.SearchKeyword;
import jp.yahooapis.im.v201812.searchkeywordlist.SearchKeywordList;
import jp.yahooapis.im.v201812.searchkeywordlist.SearchKeywordListOperation;
import jp.yahooapis.im.v201812.searchkeywordlist.SearchKeywordListPage;
import jp.yahooapis.im.v201812.searchkeywordlist.SearchKeywordListReturnValue;
import jp.yahooapis.im.v201812.searchkeywordlist.SearchKeywordListSelector;
import jp.yahooapis.im.v201812.searchkeywordlist.SearchKeywordListService;
import jp.yahooapis.im.v201812.searchkeywordlist.SearchKeywordListServiceInterface;
import jp.yahooapis.im.v201812.searchkeywordlist.SearchKeywordListValues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for SearchKeywordIdeaService,SearchKeywordListService.<br>
 * Copyright (C) 2013 Yahoo Japan Corporation. All Rights Reserved.
 */
public class SearchKeywordSample {

  /**
   * main method for SearchKeywordSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    try {
      long accountId = SoapUtils.getAccountId();

      // -----------------------------------------------
      // SearchKeywordIdeaService::get
      // -----------------------------------------------
      // request
      SearchKeywordIdeaSelector selector = createSearchKeywordIdeaSampleGetRequest();

      // call API
      List<SearchKeywordIdeaValues> searchKeywordIdeaValues = getSearchKeywordIdea(selector);

      // -----------------------------------------------
      // SearchKeywordListService::mutate(ADD)
      // -----------------------------------------------
      SearchKeywordListOperation addSearchKeywordListOperation = createSearchKeywordListSampleAddRequest(accountId, searchKeywordIdeaValues);

      // call API
      List<SearchKeywordListValues> searchKeywordListValues = addSearchKeywordList(addSearchKeywordListOperation);

      // -----------------------------------------------
      // SearchKeywordListService::get
      // -----------------------------------------------
      // request
      SearchKeywordListSelector searchKeywordListSelector = createSearchKeywordListSampleGetRequest(accountId, searchKeywordListValues);
      // call API
      getSearchKeywordList(searchKeywordListSelector);

      // -----------------------------------------------
      // SearchKeywordListService::mutate(SET)
      // -----------------------------------------------
      // request
      SearchKeywordListOperation setSearchKeywordListOperation = createSearchKeywordListSampleSetRequest(accountId, searchKeywordIdeaValues, searchKeywordListValues);
      // call API
      setSearchKeywordList(setSearchKeywordListOperation);

      // -----------------------------------------------
      // SearchKeywordListService::mutate(REMOVE)
      // -----------------------------------------------
      // request
      SearchKeywordListOperation removeSearchKeywordListOperation = createSearchKeywordListSampleRemoveRequest(accountId, searchKeywordListValues);

      // call API
      removeSearchKeywordList(removeSearchKeywordListOperation);


    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Sample Program for SearchKeywordIdeaService GET.
   *
   * @param selector SearchKeywordIdeaSelector
   * @return SearchKeywordIdeaValues
   */
  public static List<SearchKeywordIdeaValues> getSearchKeywordIdea(SearchKeywordIdeaSelector selector) throws Exception {

    // =================================================================
    // SearchKeywordIdeaService
    // =================================================================
    SearchKeywordIdeaServiceInterface searchKeywordIdeaService = SoapUtils.createServiceInterface(SearchKeywordIdeaServiceInterface.class, SearchKeywordIdeaService.class);

    System.out.println("############################################");
    System.out.println("SearchKeywordIdeaService::get");
    System.out.println("############################################");
    Holder<SearchKeywordIdeaPage> searchKeywordIdeaValueHolder = new Holder<SearchKeywordIdeaPage>();
    Holder<List<Error>> searchKeywordIdeaErrorHolder = new Holder<List<Error>>();
    searchKeywordIdeaService.get(selector, searchKeywordIdeaValueHolder, searchKeywordIdeaErrorHolder);

    // if error
    if (searchKeywordIdeaErrorHolder.value != null && searchKeywordIdeaErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(searchKeywordIdeaErrorHolder.value), true);
    }

    // response
    if (searchKeywordIdeaValueHolder.value != null) {
      for (SearchKeywordIdeaValues values : searchKeywordIdeaValueHolder.value.getValues()) {
        if (values.isOperationSucceeded()) {
          // display response
          displaySearchKeywordIdea(values.getSearchKeywordIdea());
        } else {
          // if error
          SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
        }
      }

    }

    // Response
    return searchKeywordIdeaValueHolder.value.getValues();
  }

  /**
   * Sample Program for SearchKeywordListService ADD.
   *
   * @param operation SearchKeywordListOperation
   * @return SearchKeywordListValues
   */
  public static List<SearchKeywordListValues> addSearchKeywordList(SearchKeywordListOperation operation) throws Exception {
    // =================================================================
    // SearchKeywordListService
    // =================================================================
    SearchKeywordListServiceInterface searchKeywordListService = SoapUtils.createServiceInterface(SearchKeywordListServiceInterface.class, SearchKeywordListService.class);

    System.out.println("############################################");
    System.out.println("SearchKeywordListService::mutate(ADD)");
    System.out.println("############################################");
    Holder<SearchKeywordListReturnValue> addSearchKeywordListReturnValueHolder = new Holder<SearchKeywordListReturnValue>();
    Holder<List<jp.yahooapis.im.v201812.Error>> addSearchKeywordListErrorHolder = new Holder<List<jp.yahooapis.im.v201812.Error>>();
    searchKeywordListService.mutate(operation, addSearchKeywordListReturnValueHolder, addSearchKeywordListErrorHolder);

    // if error
    if (addSearchKeywordListErrorHolder.value != null && addSearchKeywordListErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(addSearchKeywordListErrorHolder.value), true);
    }

    // response
    if (addSearchKeywordListReturnValueHolder.value != null) {
      for (SearchKeywordListValues values : addSearchKeywordListReturnValueHolder.value.getValues()) {
        if (values.isOperationSucceeded()) {
          // display response
          displaySearchKeywordList(values.getSearchKeywordList());
        } else {
          // if error
          SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
        }
      }
    }
    // Response
    return addSearchKeywordListReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for SearchKeywordListService GET.
   *
   * @param selector SearchKeywordListSelector
   * @return SearchKeywordListValues
   */
  public static List<SearchKeywordListValues> getSearchKeywordList(SearchKeywordListSelector selector) throws Exception {

    // =================================================================
    // SearchKeywordListService
    // =================================================================
    SearchKeywordListServiceInterface searchKeywordListService = SoapUtils.createServiceInterface(SearchKeywordListServiceInterface.class, SearchKeywordListService.class);

    System.out.println("############################################");
    System.out.println("SearchKeywordListService::get");
    System.out.println("############################################");
    Holder<SearchKeywordListPage> getSearchKeywordListPageHolder = new Holder<SearchKeywordListPage>();
    Holder<List<jp.yahooapis.im.v201812.Error>> getSearchKeywordListErrorHolder = new Holder<List<jp.yahooapis.im.v201812.Error>>();
    searchKeywordListService.get(selector, getSearchKeywordListPageHolder, getSearchKeywordListErrorHolder);

    // if error
    if (getSearchKeywordListErrorHolder.value != null && getSearchKeywordListErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(getSearchKeywordListErrorHolder.value), true);
    }

    // response
    if (getSearchKeywordListPageHolder.value != null) {
      for (SearchKeywordListValues values : getSearchKeywordListPageHolder.value.getValues()) {
        if (values.isOperationSucceeded()) {
          displaySearchKeywordList(values.getSearchKeywordList());
        } else {
          SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
        }
      }
    }

    // Response
    return getSearchKeywordListPageHolder.value.getValues();
  }

  /**
   * Sample Program for SearchKeywordListService SET.
   *
   * @param operation SearchKeywordListOperation
   * @return SearchKeywordListValues
   */
  public static List<SearchKeywordListValues> setSearchKeywordList(SearchKeywordListOperation operation) throws Exception {
    // =================================================================
    // SearchKeywordListService
    // =================================================================
    SearchKeywordListServiceInterface searchKeywordListService = SoapUtils.createServiceInterface(SearchKeywordListServiceInterface.class, SearchKeywordListService.class);

    System.out.println("############################################");
    System.out.println("SearchKeywordListService::mutate(SET)");
    System.out.println("############################################");
    Holder<SearchKeywordListReturnValue> setSearchKeywordListReturnValueHolder = new Holder<SearchKeywordListReturnValue>();
    Holder<List<jp.yahooapis.im.v201812.Error>> setSearchKeywordListErrorHolder = new Holder<List<jp.yahooapis.im.v201812.Error>>();
    searchKeywordListService.mutate(operation, setSearchKeywordListReturnValueHolder, setSearchKeywordListErrorHolder);

    // if error
    if (setSearchKeywordListErrorHolder.value != null && setSearchKeywordListErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(setSearchKeywordListErrorHolder.value), true);
    }

    // response
    if (setSearchKeywordListReturnValueHolder.value != null) {
      for (SearchKeywordListValues values : setSearchKeywordListReturnValueHolder.value.getValues()) {
        if (values.isOperationSucceeded()) {
          displaySearchKeywordList(values.getSearchKeywordList());
        } else {
          SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
        }
      }
    }

    // Response
    return setSearchKeywordListReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for SearchKeywordListService SET.
   *
   * @param operation SearchKeywordListOperation
   * @return SearchKeywordListValues
   */
  public static List<SearchKeywordListValues> removeSearchKeywordList(SearchKeywordListOperation operation) throws Exception {
    // =================================================================
    // SearchKeywordListService
    // =================================================================
    SearchKeywordListServiceInterface searchKeywordListService = SoapUtils.createServiceInterface(SearchKeywordListServiceInterface.class, SearchKeywordListService.class);

    System.out.println("############################################");
    System.out.println("SearchKeywordListService::mutate(REMOVE)");
    System.out.println("############################################");
    Holder<SearchKeywordListReturnValue> removeSearchKeywordListReturnValueHolder = new Holder<SearchKeywordListReturnValue>();
    Holder<List<jp.yahooapis.im.v201812.Error>> removeSearchKeywordListErrorHolder = new Holder<List<jp.yahooapis.im.v201812.Error>>();
    searchKeywordListService.mutate(operation, removeSearchKeywordListReturnValueHolder, removeSearchKeywordListErrorHolder);

    // if error
    if (removeSearchKeywordListErrorHolder.value != null && removeSearchKeywordListErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(removeSearchKeywordListErrorHolder.value), true);
    }

    // response
    if (removeSearchKeywordListReturnValueHolder.value != null) {
      for (SearchKeywordListValues values : removeSearchKeywordListReturnValueHolder.value.getValues()) {
        if (values.isOperationSucceeded()) {
          displaySearchKeywordList(values.getSearchKeywordList());
        } else {
          SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
        }
      }
    }
    // Response
    return removeSearchKeywordListReturnValueHolder.value.getValues();
  }

  /**
   * create sample request.
   *
   * @return SearchKeywordIdeaSelector
   */
  public static SearchKeywordIdeaSelector createSearchKeywordIdeaSampleGetRequest() {
    // Set Selector
    SearchKeywordIdeaSelector selector = new SearchKeywordIdeaSelector();
    selector.getKeywords().addAll(Arrays.asList("gizmo", "vlookup"));
    selector.setSearchKeywordRecency(KeywordRecency.WITHIN_30_DAYS);
    selector.setSearchKeywordFrequency(KeywordFrequency.ONCE_OR_MORE);
    selector.setSortField(SortField.KEYWORD_ID);
    selector.setSortType(SortType.ASC);
    selector.setMatchType(MatchType.BROAD);
    jp.yahooapis.im.v201812.Paging paging = new jp.yahooapis.im.v201812.Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(1000);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * create sample request.
   *
   * @param accountId               long
   * @param searchKeywordIdeaValues SearchKeywordIdeaValues
   * @return SearchKeywordListOperation
   */
  public static SearchKeywordListOperation createSearchKeywordListSampleAddRequest(long accountId, List<SearchKeywordIdeaValues> searchKeywordIdeaValues) {
    List<SearchKeyword> addSearchKeywords = new ArrayList<SearchKeyword>();
    for (SearchKeywordIdeaValues searchKeywordIdeaValue : searchKeywordIdeaValues) {

      SearchKeyword searchKeyword = new SearchKeyword();
      searchKeyword.setSearchKeywordId(searchKeywordIdeaValue.getSearchKeywordIdea().getSearchKeywordId());
      addSearchKeywords.add(searchKeyword);
    }

    SearchKeywordList addSearchKeywordList = new SearchKeywordList();
    addSearchKeywordList.setAccountId(accountId);
    addSearchKeywordList.setSearchKeywordListName("SampleSearchKeywordList_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addSearchKeywordList.setSearchKeywordListDescription("SampleSearchKeywordListDescription_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addSearchKeywordList.getSearchKeyword().addAll(addSearchKeywords);

    SearchKeywordListOperation addSearchKeywordListOperation = new SearchKeywordListOperation();
    addSearchKeywordListOperation.setAccountId(accountId);
    addSearchKeywordListOperation.setOperator(Operator.ADD);
    addSearchKeywordListOperation.getOperand().add(addSearchKeywordList);

    return addSearchKeywordListOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId               long
   * @param searchKeywordListValues SearchKeywordListValues
   * @return SearchKeywordListSelector
   */
  public static SearchKeywordListSelector createSearchKeywordListSampleGetRequest(long accountId, List<SearchKeywordListValues> searchKeywordListValues) {
    // Set Selector
    SearchKeywordListSelector searchKeywordListSelector = new SearchKeywordListSelector();
    searchKeywordListSelector.setAccountId(accountId);

    for (SearchKeywordListValues searchKeywordListValue : searchKeywordListValues) {

      searchKeywordListSelector.getSearchKeywordListIds().add(searchKeywordListValue.getSearchKeywordList().getSearchKeywordListId());
    }

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    searchKeywordListSelector.setPaging(paging);

    return searchKeywordListSelector;

  }

  /**
   * create sample request.
   *
   * @param accountId               long
   * @param searchKeywordIdeaValues SearchKeywordIdeaValues
   * @param searchKeywordListValues SearchKeywordListValues
   * @return SearchKeywordListOperation
   */
  public static SearchKeywordListOperation createSearchKeywordListSampleSetRequest(long accountId, List<SearchKeywordIdeaValues> searchKeywordIdeaValues,
                                                                                   List<SearchKeywordListValues> searchKeywordListValues) {

    SearchKeywordListOperation setSearchKeywordListOperation = new SearchKeywordListOperation();
    setSearchKeywordListOperation.setAccountId(accountId);
    setSearchKeywordListOperation.setOperator(Operator.SET);

    for (SearchKeywordListValues searchKeywordListValue : searchKeywordListValues) {
      SearchKeywordList setSearchKeywordList = new SearchKeywordList();
      setSearchKeywordList.setAccountId(accountId);
      setSearchKeywordList.setSearchKeywordListId(searchKeywordListValue.getSearchKeywordList().getSearchKeywordListId());
      setSearchKeywordList.setSearchKeywordListName("SampleSearchKeywordList_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setSearchKeywordList.setSearchKeywordListDescription("SampleSearchKeywordListDescription_UpdateOn_" + SoapUtils.getCurrentTimestamp());

      for (SearchKeywordIdeaValues searchKeywordIdeaValue : searchKeywordIdeaValues) {
        SearchKeyword searchKeyword = new SearchKeyword();
        searchKeyword.setSearchKeywordId(searchKeywordIdeaValue.getSearchKeywordIdea().getSearchKeywordId());
        setSearchKeywordList.getSearchKeyword().add(searchKeyword);
      }
      setSearchKeywordListOperation.getOperand().add(setSearchKeywordList);
    }

    return setSearchKeywordListOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId               long
   * @param searchKeywordListValues SearchKeywordListValues
   * @return SearchKeywordListOperation
   */
  public static SearchKeywordListOperation createSearchKeywordListSampleRemoveRequest(long accountId, List<SearchKeywordListValues> searchKeywordListValues) {
    SearchKeywordListOperation removeSearchKeywordListOperation = new SearchKeywordListOperation();
    removeSearchKeywordListOperation.setAccountId(accountId);
    removeSearchKeywordListOperation.setOperator(Operator.REMOVE);

    for (SearchKeywordListValues searchKeywordListValue : searchKeywordListValues) {
      SearchKeywordList removeSearchKeywordList = new SearchKeywordList();
      removeSearchKeywordList.setAccountId(accountId);
      removeSearchKeywordList.setSearchKeywordListId(searchKeywordListValue.getSearchKeywordList().getSearchKeywordListId());

      removeSearchKeywordListOperation.getOperand().add(removeSearchKeywordList);
    }

    return removeSearchKeywordListOperation;
  }

  /**
   * display SearchKeywordList entity to stdout.
   *
   * @param searchKeywordList SearchKeywordList entity for display.
   */
  private static void displaySearchKeywordList(SearchKeywordList searchKeywordList) {
    System.out.println("accountId = " + searchKeywordList.getAccountId());
    System.out.println("searchKeywordListId = " + searchKeywordList.getSearchKeywordListId());
    System.out.println("searchKeywordListName = " + searchKeywordList.getSearchKeywordListName());
    System.out.println("searchKeywordListDescription = " + searchKeywordList.getSearchKeywordListDescription());
    System.out.println("searchKeywordRecency = " + searchKeywordList.getSearchKeywordRecency());
    System.out.println("searchKeywordFrequency = " + searchKeywordList.getSearchKeywordFrequency());

    System.out.println("deliveryStatus = " + searchKeywordList.getDeliveryStatus());
    for (SearchKeyword searchKeyword : searchKeywordList.getSearchKeyword()) {
      System.out.println("searchKeyword / searchKeywordId = " + searchKeyword.getSearchKeywordId());

    }

    System.out.println("---------");
  }

  /**
   * display SearchKeywordIdea entity to stdout.
   *
   * @param searchKeywordIdea SearchKeywordIdea entity for display.
   */
  private static void displaySearchKeywordIdea(SearchKeywordIdea searchKeywordIdea) {
    System.out.println("searchKeywordId = " + searchKeywordIdea.getSearchKeywordId());
    System.out.println("searchKeyword = " + searchKeywordIdea.getSearchKeyword());
    System.out.println("desktopSearchVolume = " + searchKeywordIdea.getDesktopSearchVolume());
    System.out.println("smartPhoneSearchVolume = " + searchKeywordIdea.getSmartPhoneSearchVolume());
    System.out.println("tabletSearchVolume = " + searchKeywordIdea.getTabletSearchVolume());
    System.out.println("releaseDate = " + searchKeywordIdea.getReleaseDate());
    System.out.println("---------");
  }
}
