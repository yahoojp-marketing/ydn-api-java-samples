package jp.co.yahoo.ad_api_sample.placementUrlSample;

import jp.co.yahoo.ad_api_sample.error.impl.PlacementUrlIdeaServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.error.impl.PlacementUrlListServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.V6.PlacementUrlIdeaService.AdFormat;
import jp.yahooapis.im.V6.PlacementUrlIdeaService.AdFormatConditions;
import jp.yahooapis.im.V6.PlacementUrlIdeaService.Error;
import jp.yahooapis.im.V6.PlacementUrlIdeaService.PlacementUrlIdea;
import jp.yahooapis.im.V6.PlacementUrlIdeaService.PlacementUrlIdeaPage;
import jp.yahooapis.im.V6.PlacementUrlIdeaService.PlacementUrlIdeaSelector;
import jp.yahooapis.im.V6.PlacementUrlIdeaService.PlacementUrlIdeaService;
import jp.yahooapis.im.V6.PlacementUrlIdeaService.PlacementUrlIdeaServiceInterface;
import jp.yahooapis.im.V6.PlacementUrlIdeaService.PlacementUrlIdeaValues;
import jp.yahooapis.im.V6.PlacementUrlListService.Operator;
import jp.yahooapis.im.V6.PlacementUrlListService.Paging;
import jp.yahooapis.im.V6.PlacementUrlListService.PlacementUrlList;
import jp.yahooapis.im.V6.PlacementUrlListService.PlacementUrlListOperation;
import jp.yahooapis.im.V6.PlacementUrlListService.PlacementUrlListPage;
import jp.yahooapis.im.V6.PlacementUrlListService.PlacementUrlListReturnValue;
import jp.yahooapis.im.V6.PlacementUrlListService.PlacementUrlListSelector;
import jp.yahooapis.im.V6.PlacementUrlListService.PlacementUrlListService;
import jp.yahooapis.im.V6.PlacementUrlListService.PlacementUrlListServiceInterface;
import jp.yahooapis.im.V6.PlacementUrlListService.PlacementUrlListValues;
import jp.yahooapis.im.V6.PlacementUrlListService.UrlActiveFlg;
import jp.yahooapis.im.V6.PlacementUrlListService.UrlList;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;


/**
 * Sample Program for PlacementUrlIdeaService,PlacementUrlListService.<br>
 * Copyright (C) 2014 Yahoo
 * Japan Corporation. All Rights Reserved.
 */
public class PlacementUrlSample {

  /**
   * main method for AdSample
   * 
   * @param args command line arguments
   */
  public static void main(String[] args) {
    try {
      long accountId = SoapUtils.getAccountId();

      // -----------------------------------------------
      // PlacementUrlIdeaService::get
      // -----------------------------------------------
      // request
      PlacementUrlIdeaSelector selector = createPlacementUrlIdeaSampleGetRequest(accountId);

      // call API
      List<PlacementUrlIdeaValues> getPlacementUrlIdeaValues = getPlacementUrlIdea(selector);

      List<UrlList> addUrlList = new ArrayList<UrlList>();
      int index = 0;
      for (PlacementUrlIdeaValues values : getPlacementUrlIdeaValues) {
        if (index == 1000) {
          break;
        }
        if (values.isOperationSucceeded() && !"UNKNOWN_URL".equals(values.getPlacementUrlIdea().getSearchUrl())) {
          UrlList urlList = new UrlList();
          urlList.setPlacementUrl(values.getPlacementUrlIdea().getSearchUrl());
          urlList.setActiveFlg(UrlActiveFlg.ACTIVE);
          addUrlList.add(urlList);
          index++;
        }
      }
      // -----------------------------------------------
      // PlacementUrlListService::mutate(ADD)
      // -----------------------------------------------
      PlacementUrlListOperation addSearchKeywordListOperation = createPlacementUrlListSampleAddRequest(accountId, getPlacementUrlIdeaValues, addUrlList);

      // call API
      List<PlacementUrlListValues> addPlacementUrlListValues = addPlacementUrlList(addSearchKeywordListOperation);

      // -----------------------------------------------
      // PlacementUrlListService::get
      // -----------------------------------------------
      PlacementUrlListSelector placementUrlListSelector = createPlacementUrlListSampleGetRequest(accountId, addPlacementUrlListValues);

      // call API
      getPlacementUrlList(placementUrlListSelector);

      // -----------------------------------------------
      // PlacementUrlListService::mutate(SET)
      // -----------------------------------------------
      PlacementUrlListOperation setPlacementUrlListOperation = createPlacementUrlListSampleSetRequest(accountId, addPlacementUrlListValues, addUrlList);
      // call API
      setPlacementUrlList(setPlacementUrlListOperation);


      // -----------------------------------------------
      // PlacementUrlListService::mutate(REMOVE)
      // -----------------------------------------------
      // request
      PlacementUrlListOperation removePlacementUrlListOperation = createPlacementUrlListSampleRemoveRequest(accountId, addPlacementUrlListValues);
      // call API
      removePlacementUrlList(removePlacementUrlListOperation);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Sample Program for PlacementUrlLisService ADD.
   *
   * @param operation PlacementUrlListOperation
   * @return PlacementUrlListValues
   * @throws Exception
   */
  public static List<PlacementUrlListValues> addPlacementUrlList(PlacementUrlListOperation operation) throws Exception {
    // =================================================================
    // PlacementUrlListService
    // =================================================================
    PlacementUrlListServiceInterface placementUrlListService = SoapUtils.createServiceInterface(PlacementUrlListServiceInterface.class, PlacementUrlListService.class);

    // call API
    System.out.println("############################################");
    System.out.println("PlacementUrlListService::mutate(ADD)");
    System.out.println("############################################");
    Holder<PlacementUrlListReturnValue> addPlacementUrlListReturnValueHolder = new Holder<PlacementUrlListReturnValue>();
    Holder<List<jp.yahooapis.im.V6.PlacementUrlListService.Error>> addPlacementUrlListErrorHolder = new Holder<List<jp.yahooapis.im.V6.PlacementUrlListService.Error>>();
    placementUrlListService.mutate(operation, addPlacementUrlListReturnValueHolder, addPlacementUrlListErrorHolder);

    // if error
    if (addPlacementUrlListErrorHolder.value != null && addPlacementUrlListErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new PlacementUrlListServiceErrorEntityFactory(addPlacementUrlListErrorHolder.value), true);
    }

    // response
    if (addPlacementUrlListReturnValueHolder.value != null) {
      PlacementUrlListReturnValue returnValue = addPlacementUrlListReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<PlacementUrlListValues> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            PlacementUrlList urlList = values.get(i).getUrlList();
            displayPlacementUrlList(urlList);
          } else {
            // if error
            SoapUtils.displayErrors(new PlacementUrlListServiceErrorEntityFactory(values.get(i).getError()), true);
          }
        }
      }
    }
    // Response
    return addPlacementUrlListReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for PlacementUrlListService GET.
   *
   * @param selector PlacementUrlListSelector
   * @return PlacementUrlListValues
   * @throws Exception
   */
  public static List<PlacementUrlListValues> getPlacementUrlList(PlacementUrlListSelector selector) throws Exception {
    // =================================================================
    // PlacementUrlListService
    // =================================================================
    PlacementUrlListServiceInterface placementUrlListService = SoapUtils.createServiceInterface(PlacementUrlListServiceInterface.class, PlacementUrlListService.class);

    System.out.println("############################################");
    System.out.println("PlacementUrlListService::get");
    System.out.println("############################################");
    Holder<PlacementUrlListPage> getPlacementUrlListPageHolder = new Holder<PlacementUrlListPage>();
    Holder<List<jp.yahooapis.im.V6.PlacementUrlListService.Error>> getPlacementUrlListErrorHolder = new Holder<List<jp.yahooapis.im.V6.PlacementUrlListService.Error>>();
    placementUrlListService.get(selector, getPlacementUrlListPageHolder, getPlacementUrlListErrorHolder);

    // if error
    if (getPlacementUrlListErrorHolder.value != null && getPlacementUrlListErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new PlacementUrlListServiceErrorEntityFactory(getPlacementUrlListErrorHolder.value), true);
    }

    // response
    if (getPlacementUrlListErrorHolder.value != null) {
      for (PlacementUrlListValues values : getPlacementUrlListPageHolder.value.getValues()) {
        if (values.isOperationSucceeded()) {
          displayPlacementUrlList(values.getUrlList());
        } else {
          SoapUtils.displayErrors(new PlacementUrlListServiceErrorEntityFactory(values.getError()), true);
        }
      }
    }

    // Response
    return getPlacementUrlListPageHolder.value.getValues();
  }

  /**
   * Sample Program for PlacementUrlListService SET.
   *
   * @param operation PlacementUrlListOperation
   * @return PlacementUrlListValues
   * @throws Exception
   */
  public static List<PlacementUrlListValues> setPlacementUrlList(PlacementUrlListOperation operation) throws Exception {
    // =================================================================
    // PlacementUrlListService
    // =================================================================
    PlacementUrlListServiceInterface placementUrlListService = SoapUtils.createServiceInterface(PlacementUrlListServiceInterface.class, PlacementUrlListService.class);

    // call API
    System.out.println("############################################");
    System.out.println("PlacementUrlListService::mutate(SET)");
    System.out.println("############################################");
    Holder<PlacementUrlListReturnValue> setPlacementUrlListReturnValueHolder = new Holder<PlacementUrlListReturnValue>();
    Holder<List<jp.yahooapis.im.V6.PlacementUrlListService.Error>> setPlacementUrlListErrorHolder = new Holder<List<jp.yahooapis.im.V6.PlacementUrlListService.Error>>();
    placementUrlListService.mutate(operation, setPlacementUrlListReturnValueHolder, setPlacementUrlListErrorHolder);

    // if error
    if (setPlacementUrlListErrorHolder.value != null && setPlacementUrlListErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new PlacementUrlListServiceErrorEntityFactory(setPlacementUrlListErrorHolder.value), true);
    }

    // response
    if (setPlacementUrlListReturnValueHolder.value != null) {
      for (PlacementUrlListValues values : setPlacementUrlListReturnValueHolder.value.getValues()) {
        if (values.isOperationSucceeded()) {
          displayPlacementUrlList(values.getUrlList());
        } else {
          SoapUtils.displayErrors(new PlacementUrlListServiceErrorEntityFactory(values.getError()), true);
        }
      }
    }

    // Response
    return setPlacementUrlListReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for PlacementUrlListService REMOVE.
   *
   * @param operation PlacementUrlListOperation
   * @return PlacementUrlListValues
   * @throws Exception
   */
  public static List<PlacementUrlListValues> removePlacementUrlList(PlacementUrlListOperation operation) throws Exception {
    // =================================================================
    // PlacementUrlListService
    // =================================================================
    PlacementUrlListServiceInterface placementUrlListService = SoapUtils.createServiceInterface(PlacementUrlListServiceInterface.class, PlacementUrlListService.class);

    System.out.println("############################################");
    System.out.println("PlacementUrlListService::mutate(REMOVE)");
    System.out.println("############################################");
    Holder<PlacementUrlListReturnValue> removePlacementUrlListReturnValueHolder = new Holder<PlacementUrlListReturnValue>();
    Holder<List<jp.yahooapis.im.V6.PlacementUrlListService.Error>> removePlacementUrlListErrorHolder = new Holder<List<jp.yahooapis.im.V6.PlacementUrlListService.Error>>();
    placementUrlListService.mutate(operation, removePlacementUrlListReturnValueHolder, removePlacementUrlListErrorHolder);

    // if error
    if (removePlacementUrlListErrorHolder.value != null && removePlacementUrlListErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new PlacementUrlListServiceErrorEntityFactory(removePlacementUrlListErrorHolder.value), true);
    }

    // response
    if (removePlacementUrlListReturnValueHolder.value != null) {
      for (PlacementUrlListValues values : removePlacementUrlListReturnValueHolder.value.getValues()) {
        if (values.isOperationSucceeded()) {
          displayPlacementUrlList(values.getUrlList());
        } else {
          SoapUtils.displayErrors(new PlacementUrlListServiceErrorEntityFactory(values.getError()), true);
        }
      }
    }

    return removePlacementUrlListReturnValueHolder.value.getValues();
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param getPlacementUrlIdeaValues PlacementUrlIdeaValues
   * @return CampaignOperation
   */
  public static PlacementUrlListOperation createPlacementUrlListSampleAddRequest(long accountId, List<PlacementUrlIdeaValues> getPlacementUrlIdeaValues, List<UrlList> addUrlList) {

    PlacementUrlList addPlacementUrlList = new PlacementUrlList();
    addPlacementUrlList.setAccountId(accountId);
    addPlacementUrlList.setUrlListName("SamplePlacementUrlList_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addPlacementUrlList.setDescription("SamplePlacementUrlListDescription_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addPlacementUrlList.getUrls().addAll(addUrlList);

    PlacementUrlListOperation addSearchKeywordListOperation = new PlacementUrlListOperation();
    addSearchKeywordListOperation.setAccountId(accountId);
    addSearchKeywordListOperation.setOperator(Operator.ADD);
    addSearchKeywordListOperation.getOperand().add(addPlacementUrlList);

    return addSearchKeywordListOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param placementUrlListValues PlacementUrlListValues
   * @return PlacementUrlListSelector
   */
  public static PlacementUrlListSelector createPlacementUrlListSampleGetRequest(long accountId, List<PlacementUrlListValues> placementUrlListValues) {
    // Set Selector
    PlacementUrlListSelector placementUrlListSelector = new PlacementUrlListSelector();
    placementUrlListSelector.setAccountId(accountId);

    for (PlacementUrlListValues values : placementUrlListValues) {
      placementUrlListSelector.getUrlListIds().add((values.getUrlList().getUrlListId()));
    }

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    placementUrlListSelector.setPaging(paging);

    return placementUrlListSelector;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param placementUrlListValues PlacementUrlListValues
   * @param addUrlList UrlList
   * @return PlacementUrlListOperation
   */
  public static PlacementUrlListOperation createPlacementUrlListSampleSetRequest(long accountId, List<PlacementUrlListValues> placementUrlListValues, List<UrlList> addUrlList) {

    PlacementUrlListOperation setPlacementUrlListOperation = new PlacementUrlListOperation();
    setPlacementUrlListOperation.setAccountId(accountId);
    setPlacementUrlListOperation.setOperator(Operator.SET);


    for (PlacementUrlListValues placementUrlListValue : placementUrlListValues) {
      PlacementUrlList setPlacementUrlList = new PlacementUrlList();
      setPlacementUrlList.setAccountId(accountId);
      setPlacementUrlList.setUrlListId(placementUrlListValue.getUrlList().getUrlListId());
      setPlacementUrlList.setUrlListName("SamplePlacementUrlList_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setPlacementUrlList.setDescription("SamplePlacementUrlListDescription_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      if (addUrlList.size() > 0) {
        UrlList urlList = new UrlList();
        urlList.setPlacementUrl(addUrlList.get(0).getPlacementUrl());
        setPlacementUrlList.getUrls().add(urlList);
      }
      setPlacementUrlListOperation.getOperand().add(setPlacementUrlList);
    }


    return setPlacementUrlListOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param placementUrlListValues PlacementUrlListValues
   * @return PlacementUrlListOperation
   */
  public static PlacementUrlListOperation createPlacementUrlListSampleRemoveRequest(long accountId, List<PlacementUrlListValues> placementUrlListValues) {
    // Set Operation
    PlacementUrlListOperation removePlacementUrlListOperation = new PlacementUrlListOperation();
    removePlacementUrlListOperation.setAccountId(accountId);
    removePlacementUrlListOperation.setOperator(Operator.REMOVE);

    // Set Operand
    for (PlacementUrlListValues placementUrlListValue : placementUrlListValues) {
      PlacementUrlList removePlacementUrlList = new PlacementUrlList();
      removePlacementUrlList.setAccountId(accountId);
      removePlacementUrlList.setUrlListId(placementUrlListValue.getUrlList().getUrlListId());

      removePlacementUrlListOperation.getOperand().add(removePlacementUrlList);
    }

    return removePlacementUrlListOperation;
  }


  /**
   * Sample Program for PlacementUrlIdeaService GET.
   *
   * @param selector PlacementUrlIdeaSelector
   * @return PlacementUrlIdeaValues
   * @throws Exception
   */
  public static List<PlacementUrlIdeaValues> getPlacementUrlIdea(PlacementUrlIdeaSelector selector) throws Exception {
    // =================================================================
    // PlacementUrlIdeaService
    // =================================================================
    PlacementUrlIdeaServiceInterface placementUrlIdeaService = SoapUtils.createServiceInterface(PlacementUrlIdeaServiceInterface.class, PlacementUrlIdeaService.class);

    // call API
    System.out.println("############################################");
    System.out.println("PlacementUrlIdeaService::get");
    System.out.println("############################################");
    Holder<PlacementUrlIdeaPage> placementUrlIdeaValueHolder = new Holder<PlacementUrlIdeaPage>();
    Holder<List<Error>> placementUrlIdeaErrorHolder = new Holder<List<Error>>();
    placementUrlIdeaService.get(selector, placementUrlIdeaValueHolder, placementUrlIdeaErrorHolder);

    // if error
    if (placementUrlIdeaErrorHolder.value != null && placementUrlIdeaErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new PlacementUrlIdeaServiceErrorEntityFactory(placementUrlIdeaErrorHolder.value), true);
    }

    // response
    if (placementUrlIdeaValueHolder.value != null) {
      for (PlacementUrlIdeaValues values : placementUrlIdeaValueHolder.value.getValues()) {
        if (values.isOperationSucceeded()) {
          // display response
          displayPlacementUrlIdea(values.getPlacementUrlIdea());
        } else {
          // if error
          SoapUtils.displayErrors(new PlacementUrlIdeaServiceErrorEntityFactory(values.getError()), true);
        }
      }
    }

    // Response
    return placementUrlIdeaValueHolder.value.getValues();
  }

  /**
   * create PlacementUrlIdea GET sample request.
   *
   * @param accountId long
   * @return PlacementUrlIdeaSelector
   */
  public static PlacementUrlIdeaSelector createPlacementUrlIdeaSampleGetRequest(long accountId) {
    // Set Selector
    PlacementUrlIdeaSelector selector = new PlacementUrlIdeaSelector();
    selector.setKeyword("jugem");
    selector.getSiteCategories().add("TC-SC-20110120100100");

    AdFormatConditions adFormatCondition = new AdFormatConditions();
    adFormatCondition.setAdStyle("IMAGE");
    adFormatCondition.setMediaAdFormat("SQUARE_300");
    selector.getAdFormats().add(adFormatCondition);

    return selector;
  }

  /**
   * display PlacementUrlList entity to stdout.
   * 
   * @param placementUrlList PlacementUrlList entity for display.
   */
  private static void displayPlacementUrlList(PlacementUrlList placementUrlList) {
    System.out.println("accountId = " + placementUrlList.getAccountId());
    System.out.println("urlListId = " + placementUrlList.getUrlListId());
    System.out.println("urlListName = " + placementUrlList.getUrlListName());
    System.out.println("description = " + placementUrlList.getDescription());
    System.out.println("isUnknownDomain = " + placementUrlList.getIsUnknownDomain().toString());
    for (UrlList urlList : placementUrlList.getUrls()) {
      System.out.println("urlList / placementUrl = " + urlList.getPlacementUrl());
      System.out.println("urlList / activeFlg = " + urlList.getActiveFlg());
    }

    System.out.println("---------");
  }

  /**
   * display PlacementUrlIdea entity to stdout.
   * 
   * @param placementUrlIdea PlacementUrlIdea entity for display.
   */
  private static void displayPlacementUrlIdea(PlacementUrlIdea placementUrlIdea) {
    System.out.println("searchUrl = " + placementUrlIdea.getSearchUrl());
    System.out.println("keyword = " + placementUrlIdea.getKeyword());
    for (String siteCategory : placementUrlIdea.getSiteCategory()) {
      System.out.println("siteCategory = " + siteCategory);
    }

    System.out.println("adFormat");
    for (AdFormat adFormat : placementUrlIdea.getAdFormat()) {
      System.out.println("  adStyle = " + adFormat.getAdStyle());
      System.out.println("  adType = " + adFormat.getAdType());
      System.out.println("  width = " + adFormat.getWidth());
      System.out.println("  height = " + adFormat.getHeight());
      System.out.println("  ==========");
    }

    System.out.println("desktopAdRequests = " + placementUrlIdea.getDesktopAdRequests());
    System.out.println("desktopReaches = " + placementUrlIdea.getDesktopReaches());
    System.out.println("smartPhoneAdRequests = " + placementUrlIdea.getSmartPhoneAdRequests());
    System.out.println("smartPhoneReaches = " + placementUrlIdea.getSmartPhoneReaches());
    System.out.println("tabletAdRequests = " + placementUrlIdea.getTabletAdRequests());
    System.out.println("tabletReaches = " + placementUrlIdea.getTabletReaches());
    System.out.println("---------");
  }
}
