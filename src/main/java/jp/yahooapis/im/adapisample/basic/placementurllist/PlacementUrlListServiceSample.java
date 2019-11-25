/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.placementurllist;

import jp.yahooapis.im.adapisample.basic.placementurlidea.PlacementUrlIdeaServiceSample;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201911.Error;
import jp.yahooapis.im.v201911.Paging;
import jp.yahooapis.im.v201911.placementurlidea.PlacementUrlIdeaValues;
import jp.yahooapis.im.v201911.placementurllist.PlacementUrlList;
import jp.yahooapis.im.v201911.placementurllist.PlacementUrlListOperation;
import jp.yahooapis.im.v201911.placementurllist.PlacementUrlListPage;
import jp.yahooapis.im.v201911.placementurllist.PlacementUrlListReturnValue;
import jp.yahooapis.im.v201911.placementurllist.PlacementUrlListSelector;
import jp.yahooapis.im.v201911.placementurllist.PlacementUrlListService;
import jp.yahooapis.im.v201911.placementurllist.PlacementUrlListServiceInterface;
import jp.yahooapis.im.v201911.placementurllist.Operator;
import jp.yahooapis.im.v201911.placementurllist.PlacementUrlListValues;
import jp.yahooapis.im.v201911.placementurllist.UrlActiveFlg;
import jp.yahooapis.im.v201911.placementurllist.UrlList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example PlacementUrlListService operation and Utility method collection.
 */
public class PlacementUrlListServiceSample {

  /**
   * example PlacementUrlListService operation.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {

    // =================================================================
    // Setup
    // =================================================================
    ValuesHolder valuesHolder = new ValuesHolder();
    long accountId = SoapUtils.getAccountId();
    
    try {
      // =================================================================
      // check & create upper service object.
      // =================================================================
      valuesHolder = setup();
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      List<UrlList> addUrlList = getUrlList(valuesHolder);

      // =================================================================
      // PlacementUrlListService ADD
      // =================================================================
      // create request.
      PlacementUrlListOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, Arrays.asList(
          createExamplePlacementUrlList(addUrlList)
      ));

      // run
      List<PlacementUrlListValues> addResponse = mutate(addRequest);
      valuesHolder.setPlacementUrlListValuesList(addResponse);

      // =================================================================
      // PlacementUrlListService GET
      // =================================================================
      // create request.
      PlacementUrlListSelector getRequest = buildExampleGetRequest(accountId, valuesRepositoryFacade.getPlacementUrlListValuesRepository().getPlacementUrlIdLists());

      // run
      get(getRequest);

      // =================================================================
      // PlacementUrlListService SET
      // =================================================================
      // create request.
      PlacementUrlListOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId,
          createExampleSetRequest(
              accountId,
              valuesRepositoryFacade.getPlacementUrlListValuesRepository().getPlacementUrlLists(),
              addUrlList
           )
      );

      // run
      mutate(setRequest);

      // =================================================================
      // PlacementUrlListService REMOVE
      // =================================================================
      // create request.
      PlacementUrlListOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId,
          valuesRepositoryFacade.getPlacementUrlListValuesRepository().getPlacementUrlLists()
      );

      // run
      mutate(removeRequest);
      valuesHolder.setPlacementUrlListValuesList(new ArrayList<>());

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
   * example mutate placementUrlLists.
   *
   * @param operation PlacementUrlListOperation
   * @return PlacementUrlListValues
   */
  public static List<PlacementUrlListValues> mutate(PlacementUrlListOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("PlacementUrlListService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<PlacementUrlListReturnValue> placementUrlListReturnValueHolder = new Holder<PlacementUrlListReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    PlacementUrlListServiceInterface placementUrlListService = SoapUtils.createServiceInterface(PlacementUrlListServiceInterface.class, PlacementUrlListService.class);
    placementUrlListService.mutate(operation, placementUrlListReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, placementUrlListReturnValueHolder.value.getValues());

    // Response
    return placementUrlListReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for PlacementUrlListService GET.
   *
   * @param selector PlacementUrlListSelector
   * @return PlacementUrlListValues
   */
  public static List<PlacementUrlListValues> get(PlacementUrlListSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("PlacementUrlListService::get");
    System.out.println("############################################");

    Holder<PlacementUrlListPage> placementUrlListPageHolder = new Holder<PlacementUrlListPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    PlacementUrlListServiceInterface placementUrlListService = SoapUtils.createServiceInterface(PlacementUrlListServiceInterface.class, PlacementUrlListService.class);
    placementUrlListService.get(selector, placementUrlListPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, placementUrlListPageHolder.value.getValues());

    // Response
    return placementUrlListPageHolder.value.getValues();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    long accountId = SoapUtils.getAccountId();

    if (valuesHolder.getPlacementUrlListValuesList().size() > 0) {
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      PlacementUrlListOperation removeOperation =
          buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getPlacementUrlListValuesRepository().getPlacementUrlLists());

      mutate(removeOperation);
    }
  }

  /**
   * example mutate request.
   *
   * @param operator Operator
   * @param accountId long
   * @param operand List<PlacementUrlList>
   * @return PlacementUrlListOperation
   */
  public static PlacementUrlListOperation buildExampleMutateRequest(Operator operator, long accountId, List<PlacementUrlList> operand)
  {
    PlacementUrlListOperation operation = new PlacementUrlListOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example PlacementUrlList request.
   *
   * @param urlList
   * @return PlacementUrlList
   */
  public static PlacementUrlList createExamplePlacementUrlList(List<UrlList> urlList)
  {
    PlacementUrlList placementUrlList = new PlacementUrlList();
    placementUrlList.setAccountId(SoapUtils.getAccountId());
    placementUrlList.setUrlListName("SamplePlacementUrlList_CreateOn_" + SoapUtils.getCurrentTimestamp());
    placementUrlList.setDescription("SamplePlacementUrlListDescription_CreateOn_" + SoapUtils.getCurrentTimestamp());
    placementUrlList.getUrls().addAll(urlList);

    return placementUrlList;
  }

  /**
   * example get request.
   *
   * @param accountId   long
   * @param placementUrlListIds List<Long>
   * @return PlacementUrlListSelector
   */
  public static PlacementUrlListSelector buildExampleGetRequest(long accountId, List<Long> placementUrlListIds)
  {
    PlacementUrlListSelector selector = new PlacementUrlListSelector();
    selector.setAccountId(accountId);
    selector.getUrlListIds().addAll(placementUrlListIds);

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
  
  /**
   * example placementUrlList set request.
   * 
   * @param accountId
   * @param placementUrlList
   * @param addUrlList
   * @return List<PlacementUrlList>
   */
  public static List<PlacementUrlList> createExampleSetRequest(long accountId, List<PlacementUrlList> placementUrlList, List<UrlList> addUrlList)
  {
    // create operands
    List<PlacementUrlList> operands = new ArrayList<>();

    for (PlacementUrlList list : placementUrlList) {
      PlacementUrlList operand = new PlacementUrlList();
      operand.setAccountId(accountId);
      operand.setUrlListId(list.getUrlListId());
      operand.setUrlListName("SamplePlacementUrlList_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      operand.setDescription("SamplePlacementUrlListDescription_UpdateOn_" + SoapUtils.getCurrentTimestamp());

      if (addUrlList.size() > 0) {
        operand.getUrls().addAll(addUrlList);
      }

      operands.add(operand);
    }

    return operands;
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  private static ValuesHolder setup() throws Exception {
    return PlacementUrlIdeaServiceSample.create();
  }
  
  /**
   * get url list.
   *
   * @param valuesHolder
   * @return UrlList
   */
  public static List<UrlList> getUrlList(ValuesHolder valuesHolder)
  {
    List<UrlList> addUrlList = new ArrayList<>();
    int i = 0;
    for (PlacementUrlIdeaValues values : valuesHolder.getPlacementUrlIdeaValuesList()) {
      if (i == 1000) {
        break;
      }
      if (values.isOperationSucceeded() && !values.getPlacementUrlIdea().getSearchUrl().equals("UNKNOWN_URL")) {
        UrlList urlList = new UrlList();
        urlList.setPlacementUrl(values.getPlacementUrlIdea().getSearchUrl());
        urlList.setActiveFlg(UrlActiveFlg.ACTIVE);
        addUrlList.add(urlList);
      }
      i++;
    }
    return addUrlList;
  }
}