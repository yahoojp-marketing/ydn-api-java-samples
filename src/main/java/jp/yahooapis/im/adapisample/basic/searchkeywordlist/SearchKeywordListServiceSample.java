/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.searchkeywordlist;

import jp.yahooapis.im.adapisample.basic.searchkeywordidea.SearchKeywordIdeaServiceSample;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201903.Error;
import jp.yahooapis.im.v201903.Paging;
import jp.yahooapis.im.v201903.searchkeywordidea.SearchKeywordIdeaValues;
import jp.yahooapis.im.v201903.searchkeywordlist.Operator;
import jp.yahooapis.im.v201903.searchkeywordlist.SearchKeyword;
import jp.yahooapis.im.v201903.searchkeywordlist.SearchKeywordList;
import jp.yahooapis.im.v201903.searchkeywordlist.SearchKeywordListOperation;
import jp.yahooapis.im.v201903.searchkeywordlist.SearchKeywordListPage;
import jp.yahooapis.im.v201903.searchkeywordlist.SearchKeywordListReturnValue;
import jp.yahooapis.im.v201903.searchkeywordlist.SearchKeywordListSelector;
import jp.yahooapis.im.v201903.searchkeywordlist.SearchKeywordListService;
import jp.yahooapis.im.v201903.searchkeywordlist.SearchKeywordListServiceInterface;
import jp.yahooapis.im.v201903.searchkeywordlist.SearchKeywordListValues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example SearchKeywordListService operation and Utility method collection.
 */
public class SearchKeywordListServiceSample {

  /**
   * example SearchKeywordListService operation.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    // =================================================================
    // Setting
    // =================================================================
    ValuesHolder valuesHolder = new ValuesHolder();
    ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
    long accountId = SoapUtils.getAccountId();

    try {
      // =================================================================
      // check & create upper service object.
      // =================================================================
      valuesHolder = setup();
      List<SearchKeyword> keywordList = getKeywordList(valuesHolder);

      // =================================================================
      // SearchKeywordListService ADD
      // =================================================================
      // create request.
      SearchKeywordListOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, //
          Collections.singletonList(createExampleSearchKeywordList(accountId, valuesHolder.getSearchKeywordIdeaValuesList())) //
      );

      // run
      List<SearchKeywordListValues> addResponse = mutate(addRequest);
      valuesHolder.setSearchKeywordListValuesList(addResponse);

      // =================================================================
      // SearchKeywordListService GET
      // =================================================================
      // create request.
      SearchKeywordListSelector getRequest = buildExampleGetRequest(accountId, valuesRepositoryFacade.getSearchKeywordListValuesRepository().getSearchKeywordIdLists());

      // run
      get(getRequest);

      // =================================================================
      // SearchKeywordListService SET
      // =================================================================
      // create request.
      SearchKeywordListOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId, //
          createExampleSetRequest(accountId, valuesRepositoryFacade.getSearchKeywordListValuesRepository().getSearchKeywordLists(), keywordList) //
      );

      // run
      mutate(setRequest);

      // =================================================================
      // SearchKeywordListService REMOVE
      // =================================================================
      // create request.
      SearchKeywordListOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getSearchKeywordListValuesRepository().getSearchKeywordLists());

      // run
      mutate(removeRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example get searchKeywordList.
   *
   * @param selector SearchKeywordListSelector
   * @return SearchKeywordListValues
   */
  public static List<SearchKeywordListValues> get(SearchKeywordListSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("SearchKeywordListService::get");
    System.out.println("############################################");

    Holder<SearchKeywordListPage> searchKeywordListPageHolder = new Holder<SearchKeywordListPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    SearchKeywordListServiceInterface searchKeywordListService = SoapUtils.createServiceInterface(SearchKeywordListServiceInterface.class, SearchKeywordListService.class);
    searchKeywordListService.get(selector, searchKeywordListPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, searchKeywordListPageHolder.value.getValues());

    // Response
    return searchKeywordListPageHolder.value.getValues();
  }

  /**
   * example mutate searchKeywordList.
   *
   * @param operation SearchKeywordListOperation
   * @return SearchKeywordListValues
   */
  public static List<SearchKeywordListValues> mutate(SearchKeywordListOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("SearchKeywordListService::mutate(" + operation.getOperator().toString() + ")");
    System.out.println("############################################");

    Holder<SearchKeywordListReturnValue> searchKeywordListReturnValueHolder = new Holder<SearchKeywordListReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    SearchKeywordListServiceInterface searchKeywordListService = SoapUtils.createServiceInterface(SearchKeywordListServiceInterface.class, SearchKeywordListService.class);
    searchKeywordListService.mutate(operation, searchKeywordListReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, searchKeywordListReturnValueHolder.value.getValues());

    // Response
    return searchKeywordListReturnValueHolder.value.getValues();
  }

  /**
   * example get request.
   *
   * @param accountId      long
   * @param keywordListIds List<Long>
   * @return SearchKeywordListSelector
   */
  public static SearchKeywordListSelector buildExampleGetRequest(long accountId, List<Long> keywordListIds) {
    SearchKeywordListSelector selector = new SearchKeywordListSelector();
    selector.setAccountId(accountId);
    selector.getSearchKeywordListIds().addAll(keywordListIds);
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
   * @param operand   List<SearchKeywordList>
   * @return mutate
   */
  public static SearchKeywordListOperation buildExampleMutateRequest(Operator operator, long accountId, List<SearchKeywordList> operand) {
    SearchKeywordListOperation operation = new SearchKeywordListOperation();
    operation.setAccountId(accountId);
    operation.setOperator(operator);
    operation.getOperand().addAll(operand);
    return operation;
  }

  /**
   * example searchKeywordList request.
   *
   * @param accountId               long
   * @param searchKeywordIdeaValues List<SearchKeywordIdeaValues>
   * @return SearchKeywordList
   */
  public static SearchKeywordList createExampleSearchKeywordList(long accountId, List<SearchKeywordIdeaValues> searchKeywordIdeaValues) {
    List<SearchKeyword> searchKeywords = new ArrayList<>();
    for (SearchKeywordIdeaValues value : searchKeywordIdeaValues) {
      SearchKeyword searchKeyword = new SearchKeyword();
      searchKeyword.setSearchKeywordId(value.getSearchKeywordIdea().getSearchKeywordId());
      searchKeywords.add(searchKeyword);
    }

    SearchKeywordList searchKeywordList = new SearchKeywordList();
    searchKeywordList.setAccountId(accountId);
    searchKeywordList.setSearchKeywordListName("SampleSearchKeywordList_CreateOn_" + SoapUtils.getCurrentTimestamp());
    searchKeywordList.setSearchKeywordListDescription("SampleSearchKeywordListDescription_CreateOn_" + SoapUtils.getCurrentTimestamp());
    searchKeywordList.getSearchKeyword().addAll(searchKeywords);

    return searchKeywordList;
  }

  /**
   * example searchKeywordList set request.
   *
   * @param accountId         long
   * @param searchKeywordList List<SearchKeywordList>
   * @param addKeywordList    List<SearchKeyword>
   * @return array
   */
  public static List<SearchKeywordList> createExampleSetRequest(long accountId, List<SearchKeywordList> searchKeywordList, List<SearchKeyword> addKeywordList) {
    // create operands
    List<SearchKeywordList> operands = new ArrayList<>();

    for (SearchKeywordList list : searchKeywordList) {
      SearchKeywordList operand = new SearchKeywordList();
      operand.setAccountId(accountId);
      operand.setSearchKeywordListId(list.getSearchKeywordListId());
      operand.setSearchKeywordListName("SampleSearchKeywordList_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      operand.setSearchKeywordListDescription("SampleSearchKeywordListDescription_UpdateOn_" + SoapUtils.getCurrentTimestamp());

      if (addKeywordList.size() > 0) {
        operand.getSearchKeyword().addAll(addKeywordList);
      }
      operands.add(operand);
    }

    return operands;
  }


  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   */
  private static ValuesHolder setup() throws Exception {
    return SearchKeywordIdeaServiceSample.create();
  }

  /**
   * get keyword list.
   *
   * @param valuesHolder ValuesHolder
   * @return List<SearchKeyword>
   */
  private static List<SearchKeyword> getKeywordList(ValuesHolder valuesHolder) {
    List<SearchKeyword> keywords = new ArrayList<>();

    for (SearchKeywordIdeaValues values : valuesHolder.getSearchKeywordIdeaValuesList()) {
      SearchKeyword searchKeyword = new SearchKeyword();
      searchKeyword.setSearchKeywordId(values.getSearchKeywordIdea().getSearchKeywordId());
      keywords.add(searchKeyword);
    }
    return keywords;
  }
}
