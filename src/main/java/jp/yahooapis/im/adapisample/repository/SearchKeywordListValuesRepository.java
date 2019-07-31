/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.repository;

import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201907.searchkeywordlist.SearchKeywordList;
import jp.yahooapis.im.v201907.searchkeywordlist.SearchKeywordListValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class SearchKeywordListValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * SearchKeywordListValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public SearchKeywordListValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return SearchKeywordLists
   */
  public List<SearchKeywordList> getSearchKeywordLists() {
    List<SearchKeywordList> keywordList = new ArrayList<>();
    if (this.valuesHolder.getSearchKeywordListValuesList().size() == 0) {
      return keywordList;
    }
    for (SearchKeywordListValues searchKeywordListValues : this.valuesHolder.getSearchKeywordListValuesList()) {
      keywordList.add(searchKeywordListValues.getSearchKeywordList());
    }
    return keywordList;
  }

  /**
   * @return KeywordIdLists
   */
  public List<Long> getSearchKeywordIdLists() {
    List<Long> keywordIdList = new ArrayList<>();
    if (this.valuesHolder.getSearchKeywordListValuesList().size() == 0) {
      return keywordIdList;
    }
    for (SearchKeywordListValues searchKeywordListValues : this.valuesHolder.getSearchKeywordListValuesList()) {
      keywordIdList.add(searchKeywordListValues.getSearchKeywordList().getSearchKeywordListId());
    }
    return keywordIdList;
  }
}
