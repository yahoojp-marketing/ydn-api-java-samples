/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.repository;

import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201903.placementurllist.PlacementUrlList;
import jp.yahooapis.im.v201903.placementurllist.PlacementUrlListValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class PlacementUrlListValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * PlacementUrlListValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public PlacementUrlListValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return PlacementUrlLists
   */
  public List<PlacementUrlList> getPlacementUrlLists() {
    List<PlacementUrlList> urlList = new ArrayList<>();
    if (this.valuesHolder.getPlacementUrlListValuesList().size() == 0) {
      return urlList;
    }
    for (PlacementUrlListValues placementUrlListValues : this.valuesHolder.getPlacementUrlListValuesList()) {
      urlList.add(placementUrlListValues.getUrlList());
    }
    return urlList;
  }

  /**
   * @return PlacementUrlIdLists
   */
  public List<Long> getPlacementUrlIdLists() {
    List<Long> urlIdList = new ArrayList<>();
    if (this.valuesHolder.getPlacementUrlListValuesList().size() == 0) {
      return urlIdList;
    }
    for (PlacementUrlListValues placementUrlListValues : this.valuesHolder.getPlacementUrlListValuesList()) {
      urlIdList.add(placementUrlListValues.getUrlList().getUrlListId());
    }
    return urlIdList;
  }
}
