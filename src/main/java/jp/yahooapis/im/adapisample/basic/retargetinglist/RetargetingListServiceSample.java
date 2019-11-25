/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.retargetinglist;

import jp.yahooapis.im.adapisample.basic.retargetingtag.RetargetingTagServiceSample;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201911.Error;
import jp.yahooapis.im.v201911.Paging;
import jp.yahooapis.im.v201911.retargetinglist.Combination;
import jp.yahooapis.im.v201911.retargetinglist.CombinationTargetList;
import jp.yahooapis.im.v201911.retargetinglist.CompareOperator;
import jp.yahooapis.im.v201911.retargetinglist.CustomAudienceTargetList;
import jp.yahooapis.im.v201911.retargetinglist.IsOpen;
import jp.yahooapis.im.v201911.retargetinglist.IsPreset;
import jp.yahooapis.im.v201911.retargetinglist.LogicalOperator;
import jp.yahooapis.im.v201911.retargetinglist.Operator;
import jp.yahooapis.im.v201911.retargetinglist.RetargetingList;
import jp.yahooapis.im.v201911.retargetinglist.RetargetingListOperation;
import jp.yahooapis.im.v201911.retargetinglist.RetargetingListPage;
import jp.yahooapis.im.v201911.retargetinglist.RetargetingListReturnValue;
import jp.yahooapis.im.v201911.retargetinglist.RetargetingListSelector;
import jp.yahooapis.im.v201911.retargetinglist.RetargetingListService;
import jp.yahooapis.im.v201911.retargetinglist.RetargetingListServiceInterface;
import jp.yahooapis.im.v201911.retargetinglist.RetargetingListValues;
import jp.yahooapis.im.v201911.retargetinglist.Rule;
import jp.yahooapis.im.v201911.retargetinglist.RuleCondition;
import jp.yahooapis.im.v201911.retargetinglist.RuleTargetList;
import jp.yahooapis.im.v201911.retargetinglist.RuleType;
import jp.yahooapis.im.v201911.retargetinglist.SimilarityTargetList;
import jp.yahooapis.im.v201911.retargetinglist.TargetListData;
import jp.yahooapis.im.v201911.retargetinglist.TargetListSize;
import jp.yahooapis.im.v201911.retargetinglist.TargetListType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example RetargetingListService operation and Utility method collection.
 */
public class RetargetingListServiceSample {

  /**
   * example RetargetingListService operation.
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
      // check & create upper service object.
      // =================================================================
      ValuesHolder valuesHolder = setup();
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      String retargetingTagId = valuesRepositoryFacade.getRetargetingTagValuesRepository().getRetargetingTagIds().get(0);

      // get DefaultTargetList.
      RetargetingListSelector getRequestDefaultTargetList = buildExampleGetRequest(accountId, new ArrayList<>());
      getRequestDefaultTargetList.getTargetListTypes().clear();
      getRequestDefaultTargetList.getTargetListTypes().add(TargetListType.DEFAULT_LIST);
      List<RetargetingListValues> getResponseDefaultTargetList = get(getRequestDefaultTargetList);
      Long defaultTargetListId = getResponseDefaultTargetList.get(0).getRetargetingList().getTargetListId();

      // =================================================================
      // RetargetingListService ADD
      // =================================================================
      // create request.
      RetargetingListOperation addRequestRuleTargetList;
      addRequestRuleTargetList = buildExampleMutateRequest(Operator.ADD, accountId, Arrays.asList( //
          createExampleRuleTargetList(accountId, retargetingTagId), //
          createExampleSimilarityTargetList(accountId, defaultTargetListId), // 
          createExampleCustomAudienceTargetList(accountId) //
      ));

      // run
      List<RetargetingListValues> addResponseTargetList = mutate(addRequestRuleTargetList);
      List<RetargetingList> retargetingList = new ArrayList<>();
      List<Long> targetListIds = new ArrayList<>();
      for (RetargetingListValues retargetingListValues : addResponseTargetList) {
        retargetingList.add(retargetingListValues.getRetargetingList());
        targetListIds.add(retargetingListValues.getRetargetingList().getTargetListId());
      }

      // =================================================================
      // RetargetingListService ADD(CombinationTargetList)
      // =================================================================
      // create request.
      RetargetingListOperation addRequestCombinationTargetList = buildExampleMutateRequest(Operator.ADD, accountId, Arrays.asList( //
          createExampleCombinationTargetList(accountId, targetListIds) //
      ));

      // run
      List<RetargetingListValues> addResponseCombinationTargetList = mutate(addRequestCombinationTargetList);
      List<RetargetingList> combinationTargetList = new ArrayList<>();
      for (RetargetingListValues retargetingListValues : addResponseCombinationTargetList) {
        combinationTargetList.add(retargetingListValues.getRetargetingList());
        targetListIds.add(retargetingListValues.getRetargetingList().getTargetListId());
      }

      // =================================================================
      // RetargetingTagService GET
      // =================================================================
      // create request.
      RetargetingListSelector getRequest = buildExampleGetRequest(accountId, targetListIds);

      // run
      get(getRequest);

      // =================================================================
      // RetargetingListService SET
      // =================================================================
      // create request.
      RetargetingListOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId, createExampleSetRequest(retargetingList));

      // run
      mutate(setRequest);

      // =================================================================
      // RetargetingListService REMOVE(CombinationTargetList)
      // =================================================================
      // create request.
      RetargetingListOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, combinationTargetList);

      // run
      mutate(removeRequest);

      // =================================================================
      // RetargetingListService REMOVE
      // =================================================================
      // create request.
      removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, retargetingList);

      // run
      mutate(removeRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example get Retargeting Lists.
   *
   * @param selector RetargetingListSelector
   * @return RetargetingListValues
   */
  public static List<RetargetingListValues> get(RetargetingListSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("RetargetingListService::get");
    System.out.println("############################################");

    Holder<RetargetingListPage> retargetingListPageHolder = new Holder<RetargetingListPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    RetargetingListServiceInterface retargetingListService = SoapUtils.createServiceInterface(RetargetingListServiceInterface.class, RetargetingListService.class);
    retargetingListService.get(selector, retargetingListPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, retargetingListPageHolder.value.getValues());

    // Response
    return retargetingListPageHolder.value.getValues();
  }

  /**
   * example mutate Retargeting Lists.
   *
   * @param operation RetargetingListOperation
   * @return RetargetingListValues
   */
  public static List<RetargetingListValues> mutate(RetargetingListOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("RetargetingTagService::mutate(" + operation.getOperator().toString() + ")");
    System.out.println("############################################");

    Holder<RetargetingListReturnValue> retargetingListReturnValueHolder = new Holder<RetargetingListReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    RetargetingListServiceInterface retargetingListService = SoapUtils.createServiceInterface(RetargetingListServiceInterface.class, RetargetingListService.class);
    retargetingListService.mutate(operation, retargetingListReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, retargetingListReturnValueHolder.value.getValues());

    // Response
    return retargetingListReturnValueHolder.value.getValues();
  }

  /**
   * example get request.
   *
   * @param accountId     long
   * @param targetListIds List<Long>
   * @return RetargetingListSelector
   */
  public static RetargetingListSelector buildExampleGetRequest(long accountId, List<Long> targetListIds) {
    RetargetingListSelector selector = new RetargetingListSelector();
    selector.setAccountId(accountId);
    selector.getTargetListIds().addAll(targetListIds);
    selector.getTargetListTypes().add(TargetListType.COMBINATION);
    selector.getTargetListTypes().add(TargetListType.RULE);
    selector.getTargetListTypes().add(TargetListType.DEFAULT_LIST);
    selector.getTargetListTypes().add(TargetListType.SIMILARITY);
    selector.getTargetListTypes().add(TargetListType.CUSTOM_AUDIENCE);
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
   * @param operand   List<RetargetingList>
   * @return RetargetingListOperation
   */
  public static RetargetingListOperation buildExampleMutateRequest(Operator operator, long accountId, List<RetargetingList> operand) {
    RetargetingListOperation operation = new RetargetingListOperation();
    operation.setAccountId(accountId);
    operation.setOperator(operator);
    operation.getOperand().addAll(operand);
    return operation;
  }

  /**
   * example Rule TargetList request.
   *
   * @param accountId        long
   * @param retargetingTagId String
   * @return RetargetingList
   */
  public static RetargetingList createExampleRuleTargetList(long accountId, String retargetingTagId) {
    RetargetingList operand = new RetargetingList();
    operand.setAccountId(accountId);
    operand.setTargetListName("SampleRule_CreateOn_" + SoapUtils.getCurrentTimestamp());
    operand.setDescription("SampleRule_CreateOn_" + SoapUtils.getCurrentTimestamp());

    RuleCondition urlRuleCondition = new RuleCondition();
    urlRuleCondition.setType(RuleType.URL);
    urlRuleCondition.setCompareOperator(CompareOperator.EQUAL);
    urlRuleCondition.setValue("sampleurl.aaa");

    RuleCondition labelRuleCondition = new RuleCondition();
    labelRuleCondition.setType(RuleType.LABEL);
    labelRuleCondition.setCompareOperator(CompareOperator.END_WITH);
    labelRuleCondition.setValue("samplelabel");

    RuleCondition refererUrlRuleCondition = new RuleCondition();
    refererUrlRuleCondition.setType(RuleType.REFERER_URL);
    refererUrlRuleCondition.setCompareOperator(CompareOperator.INCLUDED);
    refererUrlRuleCondition.setValue("samplerefererurl.aaa");

    RuleCondition pageTypeRuleCondition = new RuleCondition();
    pageTypeRuleCondition.setType(RuleType.PAGE_TYPE);
    pageTypeRuleCondition.setCompareOperator(CompareOperator.EQUAL);
    pageTypeRuleCondition.setValue("search");

    RuleCondition itemIdRuleCondition = new RuleCondition();
    itemIdRuleCondition.setType(RuleType.ITEM_ID);
    itemIdRuleCondition.setCompareOperator(CompareOperator.EQUAL);
    itemIdRuleCondition.setValue("product001");

    RuleCondition itemCategoryIdRuleCondition = new RuleCondition();
    itemCategoryIdRuleCondition.setType(RuleType.ITEM_CATEGORY_ID);
    itemCategoryIdRuleCondition.setCompareOperator(CompareOperator.EQUAL);
    itemCategoryIdRuleCondition.setValue("category001");

    RuleCondition eventTypeRuleCondition = new RuleCondition();
    eventTypeRuleCondition.setType(RuleType.EVENT_TYPE);
    eventTypeRuleCondition.setCompareOperator(CompareOperator.EQUAL);
    eventTypeRuleCondition.setValue("app_install");

    Rule rule = new Rule();
    rule.getRuleConditions().addAll(Arrays.asList( //
        urlRuleCondition, //
        labelRuleCondition, //
        refererUrlRuleCondition, //
        pageTypeRuleCondition, //
        itemIdRuleCondition, //
        itemCategoryIdRuleCondition, //
        eventTypeRuleCondition //
    ));

    RuleTargetList ruleTargetList = new RuleTargetList();
    ruleTargetList.setTargetListType(TargetListType.RULE);
    ruleTargetList.setRetargetingTagId(retargetingTagId);
    ruleTargetList.setIsPreset(IsPreset.TRUE);
    ruleTargetList.setIsOpen(IsOpen.TRUE);
    ruleTargetList.setReachPeriod(7);
    ruleTargetList.getRules().add(rule);

    operand.setTargetList(ruleTargetList);

    return operand;
  }

  /**
   * example Combination TargetList request.
   *
   * @param accountId     long
   * @param targetListIds List<Long>
   * @return RetargetingList
   */
  public static RetargetingList createExampleCombinationTargetList(long accountId, List<Long> targetListIds) {
    RetargetingList operand = new RetargetingList();
    operand.setAccountId(accountId);
    operand.setTargetListName("SampleCombination_CreateOn_" + SoapUtils.getCurrentTimestamp());
    operand.setDescription("SampleCombination_CreateOn_" + SoapUtils.getCurrentTimestamp());

    Combination combination = new Combination();
    combination.setLogicalOperator(LogicalOperator.AND);

    List<TargetListData> targetListDatas = new ArrayList<>();
    for (long targetListId : targetListIds) {
      TargetListData targetListData = new TargetListData();
      targetListData.setTargetListId(targetListId);
      targetListDatas.add(targetListData);
    }

    combination.getTargetLists().addAll(targetListDatas);

    CombinationTargetList combinationTargetList = new CombinationTargetList();
    combinationTargetList.setTargetListType(TargetListType.COMBINATION);
    combinationTargetList.getCombinations().add(combination);

    operand.setTargetList(combinationTargetList);

    return operand;
  }

  /**
   * example Similarity TargetList request.
   *
   * @param accountId           long
   * @param defaultTargetListId long
   * @return RetargetingList
   */
  public static RetargetingList createExampleSimilarityTargetList(long accountId, long defaultTargetListId) {
    RetargetingList operand = new RetargetingList();
    operand.setAccountId(accountId);
    operand.setTargetListName("SampleSimilarity_CreateOn_" + SoapUtils.getCurrentTimestamp());
    operand.setDescription("SampleSimilarity_CreateOn_" + SoapUtils.getCurrentTimestamp());

    SimilarityTargetList similarityTargetList = new SimilarityTargetList();
    similarityTargetList.setTargetListType(TargetListType.SIMILARITY);
    similarityTargetList.setTargetListId(defaultTargetListId);
    similarityTargetList.setTargetListSize(TargetListSize.RATE_6);

    operand.setTargetList(similarityTargetList);

    return operand;
  }

  /**
   * example CustomAudience TargetList request.
   *
   * @param accountId long
   * @return RetargetingList
   */
  public static RetargetingList createExampleCustomAudienceTargetList(long accountId) {
    RetargetingList operand = new RetargetingList();
    operand.setAccountId(accountId);
    operand.setTargetListName("SampleCustomAudience_CreateOn_" + SoapUtils.getCurrentTimestamp());
    operand.setDescription("SampleCustomAudience_CreateOn_" + SoapUtils.getCurrentTimestamp());

    CustomAudienceTargetList customAudienceTargetList = new CustomAudienceTargetList();
    customAudienceTargetList.setTargetListType(TargetListType.CUSTOM_AUDIENCE);
    customAudienceTargetList.setReachPeriod(60);

    operand.setTargetList(customAudienceTargetList);

    return operand;
  }

  /**
   * example targetLists set request.
   *
   * @param retargetingLists List<RetargetingList>
   * @return List<RetargetingList>
   */
  public static List<RetargetingList> createExampleSetRequest(List<RetargetingList> retargetingLists) {
    // create operands
    List<RetargetingList> operands = new ArrayList<>();

    for (RetargetingList retargetingList : retargetingLists) {
      RetargetingList operand = new RetargetingList();
      operand.setAccountId(retargetingList.getAccountId());
      operand.setTargetListId(retargetingList.getTargetListId());
      operand.setTargetListName("Sample_UpdateOn_" + retargetingList.getTargetListId() + "_" + SoapUtils.getCurrentTimestamp());
      operand.setDescription("Sample_UpdateOn_" + retargetingList.getTargetListId() + "_" + SoapUtils.getCurrentTimestamp());
      operand.setTargetList(retargetingList.getTargetList());
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
    return RetargetingTagServiceSample.create();
  }
}
