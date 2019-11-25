/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.searchkeywordidea;

import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201911.Error;
import jp.yahooapis.im.v201911.Paging;
import jp.yahooapis.im.v201911.searchkeywordidea.KeywordFrequency;
import jp.yahooapis.im.v201911.searchkeywordidea.KeywordRecency;
import jp.yahooapis.im.v201911.searchkeywordidea.MatchType;
import jp.yahooapis.im.v201911.searchkeywordidea.SearchKeywordIdeaPage;
import jp.yahooapis.im.v201911.searchkeywordidea.SearchKeywordIdeaSelector;
import jp.yahooapis.im.v201911.searchkeywordidea.SearchKeywordIdeaService;
import jp.yahooapis.im.v201911.searchkeywordidea.SearchKeywordIdeaServiceInterface;
import jp.yahooapis.im.v201911.searchkeywordidea.SearchKeywordIdeaValues;
import jp.yahooapis.im.v201911.searchkeywordidea.SortField;
import jp.yahooapis.im.v201911.searchkeywordidea.SortType;

import java.util.List;

import javax.xml.ws.Holder;

/**
 * example SearchKeywordIdeaService operation and Utility method collection.
 */
public class SearchKeywordIdeaServiceSample {

  /**
   * example SearchKeywordIdeaService operation.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // SearchKeywordIdeaService GET
      // =================================================================
      // create request.
      SearchKeywordIdeaSelector getRequest = buildExampleGetRequest();

      // run
      get(getRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example get SearchKeywordIdea.
   *
   * @param searchKeywordIdeaSelector SearchKeywordIdeaSelector
   * @return SearchKeywordIdeaValues
   */
  public static List<SearchKeywordIdeaValues> get(SearchKeywordIdeaSelector searchKeywordIdeaSelector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("SearchKeywordIdeaService::get");
    System.out.println("############################################");

    Holder<SearchKeywordIdeaPage> searchKeywordIdeaPageHolder = new Holder<SearchKeywordIdeaPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    SearchKeywordIdeaServiceInterface searchKeywordIdeaService = SoapUtils.createServiceInterface(SearchKeywordIdeaServiceInterface.class, SearchKeywordIdeaService.class);
    searchKeywordIdeaService.get(searchKeywordIdeaSelector, searchKeywordIdeaPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, searchKeywordIdeaPageHolder.value.getValues());

    // Response
    return searchKeywordIdeaPageHolder.value.getValues();
  }

  /**
   * example get request.
   *
   * @return SearchKeywordIdeaSelector
   */
  public static SearchKeywordIdeaSelector buildExampleGetRequest()
  {
    SearchKeywordIdeaSelector selector = new SearchKeywordIdeaSelector();
    selector.setSearchKeywordRecency(KeywordRecency.WITHIN_30_DAYS);
    selector.setSearchKeywordFrequency(KeywordFrequency.ONCE_OR_MORE);
    selector.setSortField(SortField.KEYWORD_ID);
    selector.setSortType(SortType.ASC);
    selector.setMatchType(MatchType.EXACT);
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);
    return selector;
  }

  /**
   * create SearchKeywordIdeaValuesList.
   *
   * @return ValuesHolder
   */
  public static ValuesHolder create()throws Exception
  {
    SearchKeywordIdeaSelector request = buildExampleGetRequest();
    List<SearchKeywordIdeaValues> response = get(request);

    ValuesHolder valuesHolder = new ValuesHolder();
    valuesHolder.setSearchKeywordIdeaValuesList(response);
    return valuesHolder;
  }
}
