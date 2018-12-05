package jp.co.yahoo.ad_api_sample.retargetingSample;

import jp.co.yahoo.ad_api_sample.error.impl.ErrorEntityFactoryImpl;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201812.Error;
import jp.yahooapis.im.v201812.Paging;
import jp.yahooapis.im.v201812.retargetinglist.Combination;
import jp.yahooapis.im.v201812.retargetinglist.CombinationTargetList;
import jp.yahooapis.im.v201812.retargetinglist.CompareOperator;
import jp.yahooapis.im.v201812.retargetinglist.CustomAudienceTargetList;
import jp.yahooapis.im.v201812.retargetinglist.IsOpen;
import jp.yahooapis.im.v201812.retargetinglist.IsPreset;
import jp.yahooapis.im.v201812.retargetinglist.LogicalOperator;
import jp.yahooapis.im.v201812.retargetinglist.Operator;
import jp.yahooapis.im.v201812.retargetinglist.RetargetingList;
import jp.yahooapis.im.v201812.retargetinglist.RetargetingListOperation;
import jp.yahooapis.im.v201812.retargetinglist.RetargetingListPage;
import jp.yahooapis.im.v201812.retargetinglist.RetargetingListReturnValue;
import jp.yahooapis.im.v201812.retargetinglist.RetargetingListSelector;
import jp.yahooapis.im.v201812.retargetinglist.RetargetingListServiceInterface;
import jp.yahooapis.im.v201812.retargetinglist.RetargetingListServiceService;
import jp.yahooapis.im.v201812.retargetinglist.RetargetingListValues;
import jp.yahooapis.im.v201812.retargetinglist.Rule;
import jp.yahooapis.im.v201812.retargetinglist.RuleCondition;
import jp.yahooapis.im.v201812.retargetinglist.RuleTargetList;
import jp.yahooapis.im.v201812.retargetinglist.RuleType;
import jp.yahooapis.im.v201812.retargetinglist.SimilarityTargetList;
import jp.yahooapis.im.v201812.retargetinglist.TargetListData;
import jp.yahooapis.im.v201812.retargetinglist.TargetListSize;
import jp.yahooapis.im.v201812.retargetinglist.TargetListSizeReaches;
import jp.yahooapis.im.v201812.retargetinglist.TargetListType;
import jp.yahooapis.im.v201812.retargetingtag.RetargetingTag;
import jp.yahooapis.im.v201812.retargetingtag.RetargetingTagOperation;
import jp.yahooapis.im.v201812.retargetingtag.RetargetingTagPage;
import jp.yahooapis.im.v201812.retargetingtag.RetargetingTagReturnValue;
import jp.yahooapis.im.v201812.retargetingtag.RetargetingTagSelector;
import jp.yahooapis.im.v201812.retargetingtag.RetargetingTagService;
import jp.yahooapis.im.v201812.retargetingtag.RetargetingTagServiceInterface;
import jp.yahooapis.im.v201812.retargetingtag.RetargetingTagValues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for RetargetingTagService,RetargetingListService.<br>
 * Copyright (C) 2013 Yahoo Japan Corporation. All Rights Reserved.
 */
public class RetargetingSample {

  /**
   * main method for RetargetingSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    try {
      long accountId = SoapUtils.getAccountId();
      String retargetingTagId = null;

      // -----------------------------------------------
      // RetargetingTagService::mutate(ADD)
      // -----------------------------------------------
      // request
      RetargetingTagOperation addRetargetingTagOperation = createRetargetingTagSampleAddRequest(accountId);

      // call API
      addRetargetingTag(addRetargetingTagOperation);

      // -----------------------------------------------
      // RetargetingTagService::get
      // -----------------------------------------------
      // request
      RetargetingTagSelector retargetingTagSelector = createRetargetingTagSampleGetRequest(accountId);

      // call API
      List<RetargetingTagValues> getRetargetingTagValues = getRetargetingTag(retargetingTagSelector);

      for (RetargetingTagValues value : getRetargetingTagValues) {
        if (value.isOperationSucceeded()) {
          retargetingTagId = value.getRetargetingTag().getRetargetingTagId();
        }
      }

      // -----------------------------------------------
      // RetargetingListService::mutate(ADD) - Rule
      // -----------------------------------------------
      // request
      RetargetingListOperation addRuleRetargetingListOperation = createRetargetingListSampleAddRuleRequest(accountId, retargetingTagId);

      // call API
      System.out.println("############################################");
      System.out.println("RetargetingListService::mutate(ADD) - Rule");
      System.out.println("############################################");
      List<RetargetingListValues> addRetargetingListRuleValues = addRetargetingList(addRuleRetargetingListOperation);

      // -----------------------------------------------
      // RetargetingListService::mutate(ADD) - Combination
      // -----------------------------------------------
      // request
      RetargetingListOperation addCombinationRetargetingListOperation = createRetargetingListSampleAddCombinationRequest(accountId, addRetargetingListRuleValues);
      // call API
      System.out.println("############################################");
      System.out.println("RetargetingListService::mutate(ADD) - Combination");
      System.out.println("############################################");
      List<RetargetingListValues> addRetargetingListCombinationValues = addRetargetingList(addCombinationRetargetingListOperation);

      // -----------------------------------------------
      // RetargetingListService::mutate(ADD) - Similarity
      // -----------------------------------------------
      // get targetingListId of DefaultTargetList
      // request
      RetargetingListSelector getDefaultRetargetingListSelector = createRetargetingListSampleGetDefaultTargetListRequest(accountId);

      // call API
      System.out.println("############################################");
      System.out.println("RetargetingListService::get DefaultTargetList");
      System.out.println("############################################");
      List<RetargetingListValues> getRetargetingListDefaultListValues = getRetargetingList(getDefaultRetargetingListSelector);

      // request
      RetargetingListOperation addSimilarityRetargetingListOperation = createRetargetingListSampleAddSimilarityRequest(accountId, getRetargetingListDefaultListValues);

      // call API
      System.out.println("############################################");
      System.out.println("RetargetingListService::mutate(ADD) - Similarity");
      System.out.println("############################################");
      List<RetargetingListValues> addRetargetingListSimilarityValues = addRetargetingList(addSimilarityRetargetingListOperation);

      // -----------------------------------------------
      // RetargetingListService::mutate(ADD) - Custom Audience
      // -----------------------------------------------
      // request
      RetargetingListOperation addCustomAudienceRetargetingListOperation = createRetargetingListSampleAddCustomAudienceRequest(accountId);

      // call API
      System.out.println("############################################");
      System.out.println("RetargetingListService::mutate(ADD) - Custom Audience");
      System.out.println("############################################");
      List<RetargetingListValues> addRetargetingListCustomAudienceValues = addRetargetingList(addCustomAudienceRetargetingListOperation);

      // -----------------------------------------------
      // RetargetingListService::get
      // -----------------------------------------------
      // request
      RetargetingListSelector
          retargetingListSelector =
          createRetargetingListSampleGetRequest(accountId, addRetargetingListRuleValues, addRetargetingListCombinationValues, addRetargetingListSimilarityValues);

      // call API
      System.out.println("############################################");
      System.out.println("RetargetingListService::get");
      System.out.println("############################################");
      getRetargetingList(retargetingListSelector);

      // -----------------------------------------------
      // RetargetingListService::mutate(SET) - Rule
      // -----------------------------------------------
      // request
      RetargetingListOperation setRuleRetargetingListOperation = createRetargetingListSampleSetRuleRequest(accountId, addRetargetingListRuleValues);

      // call API
      System.out.println("############################################");
      System.out.println("RetargetingListService::mutate(SET) - Rule");
      System.out.println("############################################");
      setRetargetingList(setRuleRetargetingListOperation);

      // -----------------------------------------------
      // RetargetingListService::mutate(SET) - Combination
      // -----------------------------------------------
      // request
      RetargetingListOperation setCombinationRetargetingListOperation = createRetargetingListSampleSetCombinationRequest(accountId, addRetargetingListRuleValues, addRetargetingListCombinationValues);

      // call API
      System.out.println("############################################");
      System.out.println("RetargetingListService::mutate(SET) - Combination");
      System.out.println("############################################");
      setRetargetingList(setCombinationRetargetingListOperation);

      // -----------------------------------------------
      // RetargetingListService::mutate(SET) - Similarity
      // -----------------------------------------------
      // request
      RetargetingListOperation setSimilaritRetargetingListOperation = createRetargetingListSampleSetSimilarityRequest(accountId, addRetargetingListSimilarityValues);

      // call API
      System.out.println("############################################");
      System.out.println("RetargetingListService::mutate(SET) - Similarity");
      System.out.println("############################################");
      setRetargetingList(setSimilaritRetargetingListOperation);

      // -----------------------------------------------
      // RetargetingListService::mutate(SET) - Custom Audience
      // -----------------------------------------------
      // request
      RetargetingListOperation setCustomAudienceRetargetingListOperation = createRetargetingListSampleSetCustomAudienceRequest(accountId, addRetargetingListCustomAudienceValues);

      // call API
      System.out.println("############################################");
      System.out.println("RetargetingListService::mutate(SET) - Custom Audience");
      System.out.println("############################################");
      setRetargetingList(setCustomAudienceRetargetingListOperation);

      // -----------------------------------------------
      // RetargetingListService::mutate(REMOVE)
      // -----------------------------------------------
      RetargetingListOperation
          removeRetargetingListOperation =
          createRetargetingListSampleRemoveRequest(accountId, addRetargetingListRuleValues, addRetargetingListCombinationValues, addRetargetingListSimilarityValues,addRetargetingListCustomAudienceValues);

      // call API
      removeRetargetingList(removeRetargetingListOperation);

    } catch (Exception ex) {
      ex.printStackTrace();
      System.exit(-1);
    }
  }

  /**
   * Sample Program for RetargetingTagService ADD.
   *
   * @param operation RetargetingTagOperation
   * @return RetargetingTagValues
   */
  public static List<RetargetingTagValues> addRetargetingTag(RetargetingTagOperation operation) throws Exception {
    // =================================================================
    // RetargetingTagService
    // =================================================================
    RetargetingTagServiceInterface retargetingTagService = SoapUtils.createServiceInterface(RetargetingTagServiceInterface.class, RetargetingTagService.class);

    // call API
    Holder<RetargetingTagReturnValue> addRetargetingTagReturnValueHolder = new Holder<RetargetingTagReturnValue>();
    Holder<List<jp.yahooapis.im.v201812.Error>> addRetargetingTagErrorHolder = new Holder<List<jp.yahooapis.im.v201812.Error>>();
    retargetingTagService.mutate(operation, addRetargetingTagReturnValueHolder, addRetargetingTagErrorHolder);

    // if error
    if (addRetargetingTagErrorHolder.value != null && addRetargetingTagErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(addRetargetingTagErrorHolder.value), false);
    }

    if (addRetargetingTagReturnValueHolder.value != null) {
      RetargetingTagReturnValue returnValue = addRetargetingTagReturnValueHolder.value;
      if (returnValue.getValues() != null) {
        for (RetargetingTagValues values : returnValue.getValues()) {
          if (values.isOperationSucceeded()) {
            displayRetargetingTag(values.getRetargetingTag());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), false);
          }
        }
      }
    }

    // Response
    return addRetargetingTagReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for RetargetingTagService GET.
   *
   * @param selector RetargetingTagSelector
   * @return RetargetingTagValues
   */
  public static List<RetargetingTagValues> getRetargetingTag(RetargetingTagSelector selector) throws Exception {
    // =================================================================
    // RetargetingTagService
    // =================================================================
    RetargetingTagServiceInterface retargetingTagService = SoapUtils.createServiceInterface(RetargetingTagServiceInterface.class, RetargetingTagService.class);

    System.out.println("############################################");
    System.out.println("RetargetingTagService::get");
    System.out.println("############################################");
    Holder<RetargetingTagPage> retargetingTagPageHolder = new Holder<RetargetingTagPage>();
    Holder<List<Error>> getRetargetingTagErrorHolder = new Holder<List<Error>>();
    retargetingTagService.get(selector, retargetingTagPageHolder, getRetargetingTagErrorHolder);

    // if error
    if (getRetargetingTagErrorHolder.value != null && getRetargetingTagErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(getRetargetingTagErrorHolder.value), true);
    }

    // response
    if (retargetingTagPageHolder.value != null) {
      RetargetingTagPage retargetingTagPage = retargetingTagPageHolder.value;
      if (retargetingTagPage.getValues() != null && retargetingTagPage.getValues().size() > 0) {
        for (RetargetingTagValues value : retargetingTagPage.getValues()) {
          if (value.isOperationSucceeded()) {
            displayRetargetingTag(value.getRetargetingTag());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(value.getError()), true);
          }
        }
      }
    }
    // Response
    return retargetingTagPageHolder.value.getValues();
  }

  /**
   * Sample Program for RetargetingListService ADD.
   *
   * @param operation RetargetingListOperation
   * @return RetargetingListValues
   */
  public static List<RetargetingListValues> addRetargetingList(RetargetingListOperation operation) throws Exception {

    // =================================================================
    // RetargetingListService
    // =================================================================
    RetargetingListServiceInterface retargetingListService = SoapUtils.createServiceInterface(RetargetingListServiceInterface.class, RetargetingListServiceService.class);

    Holder<RetargetingListReturnValue> addRuleRetargetingListReturnValueHolder = new Holder<RetargetingListReturnValue>();
    Holder<List<jp.yahooapis.im.v201812.Error>> addRuleRetargetingListErrorHolder = new Holder<List<jp.yahooapis.im.v201812.Error>>();
    retargetingListService.mutate(operation, addRuleRetargetingListReturnValueHolder, addRuleRetargetingListErrorHolder);

    // if error
    if (addRuleRetargetingListErrorHolder.value != null && addRuleRetargetingListErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(addRuleRetargetingListErrorHolder.value), true);
    }

    if (addRuleRetargetingListReturnValueHolder.value != null) {
      RetargetingListReturnValue returnValue = addRuleRetargetingListReturnValueHolder.value;
      if (returnValue.getValues() != null) {
        for (RetargetingListValues values : returnValue.getValues()) {
          if (values.isOperationSucceeded()) {
            displayRetargetingList(values.getRetargetingList());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
          }
        }
      }
    }
    // Response
    return addRuleRetargetingListReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for RetargetingListService GET.
   *
   * @param selector RetargetingListSelector
   * @return RetargetingListValues
   */
  public static List<RetargetingListValues> getRetargetingList(RetargetingListSelector selector) throws Exception {

    // =================================================================
    // RetargetingListService
    // =================================================================
    RetargetingListServiceInterface retargetingListService = SoapUtils.createServiceInterface(RetargetingListServiceInterface.class, RetargetingListServiceService.class);

    Holder<RetargetingListPage> getDefaultRetargetingListPageHolder = new Holder<RetargetingListPage>();
    Holder<List<jp.yahooapis.im.v201812.Error>> getDefaultRetargetingListErrorHolder = new Holder<List<jp.yahooapis.im.v201812.Error>>();
    retargetingListService.get(selector, getDefaultRetargetingListPageHolder, getDefaultRetargetingListErrorHolder);

    // if error
    if (getDefaultRetargetingListErrorHolder.value != null && getDefaultRetargetingListErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(getDefaultRetargetingListErrorHolder.value), true);
    }

    // response
    if (getDefaultRetargetingListPageHolder.value != null) {
      RetargetingListPage getDefaultRetargetingListPage = getDefaultRetargetingListPageHolder.value;
      if (getDefaultRetargetingListPage.getValues() != null) {
        for (RetargetingListValues values : getDefaultRetargetingListPage.getValues()) {
          if (values.isOperationSucceeded()) {
            displayRetargetingList(values.getRetargetingList());
            // if error
          } else {
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
          }
        }
      }
    }

    // Response
    return getDefaultRetargetingListPageHolder.value.getValues();
  }

  /**
   * Sample Program for RetargetingListService SET.
   *
   * @param operation RetargetingListOperation
   * @return RetargetingListValues
   */
  public static List<RetargetingListValues> setRetargetingList(RetargetingListOperation operation) throws Exception {

    // =================================================================
    // RetargetingListService
    // =================================================================
    RetargetingListServiceInterface retargetingListService = SoapUtils.createServiceInterface(RetargetingListServiceInterface.class, RetargetingListServiceService.class);

    Holder<RetargetingListReturnValue> setRuleRetargetingListReturnValueHolder = new Holder<RetargetingListReturnValue>();
    Holder<List<jp.yahooapis.im.v201812.Error>> setRuleRetargetingListErrorHolder = new Holder<List<jp.yahooapis.im.v201812.Error>>();
    retargetingListService.mutate(operation, setRuleRetargetingListReturnValueHolder, setRuleRetargetingListErrorHolder);

    // if error
    if (setRuleRetargetingListErrorHolder.value != null && setRuleRetargetingListErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(setRuleRetargetingListErrorHolder.value), true);
    }

    // response
    if (setRuleRetargetingListReturnValueHolder.value != null) {
      RetargetingListReturnValue returnValue = setRuleRetargetingListReturnValueHolder.value;
      if (returnValue != null) {
        for (RetargetingListValues values : returnValue.getValues()) {
          if (values.isOperationSucceeded()) {
            displayRetargetingList(values.getRetargetingList());
          } else {
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
          }
        }
      }
    }

    // Response
    return setRuleRetargetingListReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for RetargetingListService REMOVE.
   *
   * @param operation RetargetingListOperation
   * @return RetargetingListValues
   */
  public static List<RetargetingListValues> removeRetargetingList(RetargetingListOperation operation) throws Exception {

    // =================================================================
    // RetargetingListService
    // =================================================================
    RetargetingListServiceInterface retargetingListService = SoapUtils.createServiceInterface(RetargetingListServiceInterface.class, RetargetingListServiceService.class);

    System.out.println("############################################");
    System.out.println("RetargetingListService::mutate(REMOVE)");
    System.out.println("############################################");
    Holder<RetargetingListReturnValue> removeRetargetingListReturnValueHolder = new Holder<RetargetingListReturnValue>();
    Holder<List<jp.yahooapis.im.v201812.Error>> removeRetargetingListErrorHolder = new Holder<List<jp.yahooapis.im.v201812.Error>>();
    retargetingListService.mutate(operation, removeRetargetingListReturnValueHolder, removeRetargetingListErrorHolder);

    // if error
    if (removeRetargetingListErrorHolder.value != null && removeRetargetingListErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(removeRetargetingListErrorHolder.value), true);
    }

    // response
    if (removeRetargetingListReturnValueHolder.value != null) {
      RetargetingListReturnValue returnValue = removeRetargetingListReturnValueHolder.value;
      if (returnValue.getValues() != null) {
        for (RetargetingListValues values : returnValue.getValues()) {
          if (values.isOperationSucceeded()) {
            displayRetargetingList(values.getRetargetingList());
            // if error
          } else {
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.getError()), true);
          }
        }
      }
    }

    // Response
    return removeRetargetingListReturnValueHolder.value.getValues();
  }


  /**
   * create RetargetingTag sample request.
   *
   * @param accountId long
   * @return RetargetingTagOperation
   */
  public static RetargetingTagOperation createRetargetingTagSampleAddRequest(long accountId) {
    RetargetingTagOperation addRetargetingTagOperation = new RetargetingTagOperation();
    addRetargetingTagOperation.setOperator(jp.yahooapis.im.v201812.retargetingtag.Operator.ADD);
    addRetargetingTagOperation.setAccountId(accountId);

    return addRetargetingTagOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @return RetargetingTagSelector
   */
  public static RetargetingTagSelector createRetargetingTagSampleGetRequest(long accountId) {
    // Set Selector
    RetargetingTagSelector retargetingTagSelector = new RetargetingTagSelector();
    retargetingTagSelector.setAccountId(accountId);
    return retargetingTagSelector;
  }

  /**
   * create RetargetingList sample request.
   *
   * @param accountId        long
   * @param retargetingTagId String
   * @return RetargetingListOperation
   */
  public static RetargetingListOperation createRetargetingListSampleAddRuleRequest(long accountId, String retargetingTagId) {
    RuleCondition addRuleCondition1_1 = new RuleCondition();
    addRuleCondition1_1.setType(RuleType.LABEL);
    addRuleCondition1_1.setCompareOperator(CompareOperator.END_WITH);
    addRuleCondition1_1.setValue("SampleLabel1");

    RuleCondition addRuleCondition1_2 = new RuleCondition();
    addRuleCondition1_2.setType(RuleType.URL);
    addRuleCondition1_2.setCompareOperator(CompareOperator.EQUAL);
    addRuleCondition1_2.setValue("sampleurl2.aaa");

    RuleCondition addRuleCondition1_3 = new RuleCondition();
    addRuleCondition1_3.setType(RuleType.REFERER_URL);
    addRuleCondition1_3.setCompareOperator(CompareOperator.INCLUDED);
    addRuleCondition1_3.setValue("sampleurl3.aaa");

    RuleCondition addRuleCondition1_4 = new RuleCondition();
    addRuleCondition1_4.setType(RuleType.LABEL);
    addRuleCondition1_4.setCompareOperator(CompareOperator.NOT_END_WITH);
    addRuleCondition1_4.setValue("SampleLabel4");

    RuleCondition addRuleCondition1_5 = new RuleCondition();
    addRuleCondition1_5.setType(RuleType.URL);
    addRuleCondition1_5.setCompareOperator(CompareOperator.NOT_INCLUDED);
    addRuleCondition1_5.setValue("sampleurl5.bbb");

    RuleCondition addRuleCondition1_6 = new RuleCondition();
    addRuleCondition1_6.setType(RuleType.REFERER_URL);
    addRuleCondition1_6.setCompareOperator(CompareOperator.NOT_START_WITH);
    addRuleCondition1_6.setValue("sampleurl6.ccc");

    RuleCondition addRuleCondition1_7 = new RuleCondition();
    addRuleCondition1_7.setType(RuleType.PAGE_TYPE);
    addRuleCondition1_7.setCompareOperator(CompareOperator.EQUAL);
    addRuleCondition1_7.setValue("search");

    RuleCondition addRuleCondition1_8 = new RuleCondition();
    addRuleCondition1_8.setType(RuleType.ITEM_ID);
    addRuleCondition1_8.setCompareOperator(CompareOperator.EQUAL);
    addRuleCondition1_8.setValue("product001");

    RuleCondition addRuleCondition1_9 = new RuleCondition();
    addRuleCondition1_9.setType(RuleType.ITEM_CATEGORY_ID);
    addRuleCondition1_9.setCompareOperator(CompareOperator.EQUAL);
    addRuleCondition1_9.setValue("category001");

    Rule addRule = new Rule();
    addRule.getRuleConditions().addAll(Arrays.asList(addRuleCondition1_1, addRuleCondition1_2, addRuleCondition1_3, addRuleCondition1_4, addRuleCondition1_5, addRuleCondition1_6, addRuleCondition1_7,
        addRuleCondition1_8, addRuleCondition1_9));

    RuleTargetList addRuleTargetList = new RuleTargetList();
    addRuleTargetList.setTargetListType(TargetListType.RULE);
    addRuleTargetList.setRetargetingTagId(retargetingTagId);
    addRuleTargetList.setIsPreset(IsPreset.TRUE);
    addRuleTargetList.setIsOpen(IsOpen.TRUE);
    addRuleTargetList.setReachPeriod(7);
    addRuleTargetList.getRules().add(addRule);

    RetargetingList addRuleRetargetingListOperand = new RetargetingList();
    addRuleRetargetingListOperand.setAccountId(accountId);
    addRuleRetargetingListOperand.setTargetListName("SampleRule_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addRuleRetargetingListOperand.setDescription("SampleRulet_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addRuleRetargetingListOperand.setTargetList(addRuleTargetList);

    RuleCondition addRuleCondition2 = new RuleCondition();
    addRuleCondition2.setType(RuleType.LABEL);
    addRuleCondition2.setCompareOperator(CompareOperator.END_WITH);
    addRuleCondition2.setValue("SampleLabe2");

    Rule addRule2 = new Rule();
    addRule2.getRuleConditions().add(addRuleCondition2);

    RuleTargetList addRuleTargetList2 = new RuleTargetList();
    addRuleTargetList2.setTargetListType(TargetListType.RULE);
    addRuleTargetList2.setRetargetingTagId(retargetingTagId);
    addRuleTargetList2.setIsPreset(IsPreset.TRUE);
    addRuleTargetList2.setIsOpen(IsOpen.TRUE);
    addRuleTargetList2.setReachPeriod(7);
    addRuleTargetList2.getRules().add(addRule2);

    RetargetingList addRuleRetargetingListOperand2 = new RetargetingList();
    addRuleRetargetingListOperand2.setAccountId(accountId);
    addRuleRetargetingListOperand2.setTargetListName("SampleRule2_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addRuleRetargetingListOperand2.setDescription("SampleRulet2_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addRuleRetargetingListOperand2.setTargetList(addRuleTargetList2);

    RuleCondition addRuleCondition3 = new RuleCondition();
    addRuleCondition3.setType(RuleType.EVENT_TYPE);
    addRuleCondition3.setCompareOperator(CompareOperator.EQUAL);
    addRuleCondition3.setValue("app_install");

    Rule addRule3 = new Rule();
    addRule3.getRuleConditions().add(addRuleCondition3);

    RuleTargetList addRuleTargetList3 = new RuleTargetList();
    addRuleTargetList3.setTargetListType(TargetListType.RULE);
    addRuleTargetList3.setRetargetingTagId(retargetingTagId);
    addRuleTargetList3.setIsPreset(IsPreset.TRUE);
    addRuleTargetList3.setIsOpen(IsOpen.TRUE);
    addRuleTargetList3.setReachPeriod(7);
    addRuleTargetList3.getRules().add(addRule3);

    RetargetingList addRuleRetargetingListOperand3 = new RetargetingList();
    addRuleRetargetingListOperand3.setAccountId(accountId);
    addRuleRetargetingListOperand3.setTargetListName("SampleRule3_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addRuleRetargetingListOperand3.setDescription("SampleRulet3_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addRuleRetargetingListOperand3.setTargetList(addRuleTargetList3);

    RetargetingListOperation addRuleRetargetingListOperation = new RetargetingListOperation();
    addRuleRetargetingListOperation.setOperator(Operator.ADD);
    addRuleRetargetingListOperation.setAccountId(accountId);
    List<RetargetingList> ruleTargetListOperand = addRuleRetargetingListOperation.getOperand();
    ruleTargetListOperand.add(addRuleRetargetingListOperand);
    ruleTargetListOperand.add(addRuleRetargetingListOperand2);
    ruleTargetListOperand.add(addRuleRetargetingListOperand3);

    return addRuleRetargetingListOperation;
  }

  /**
   * create RetargetingList Combination sample request.
   *
   * @param accountId             long
   * @param retargetingListValues RetargetingListValues
   * @return RetargetingListOperation
   */
  public static RetargetingListOperation createRetargetingListSampleAddCombinationRequest(long accountId, List<RetargetingListValues> retargetingListValues) {

    RetargetingListOperation addCombinationRetargetingListOperation = new RetargetingListOperation();
    addCombinationRetargetingListOperation.setOperator(Operator.ADD);
    addCombinationRetargetingListOperation.setAccountId(accountId);

//    for (RetargetingListValues retargetingListValue : retargetingListValues) {
      Combination addCombination = new Combination();
      addCombination.setLogicalOperator(LogicalOperator.AND);
      TargetListData targetListData = new TargetListData();
      targetListData.setTargetListId(retargetingListValues.get(0).getRetargetingList().getTargetListId());
      TargetListData targetListData2 = new TargetListData();
      targetListData2.setTargetListId(retargetingListValues.get(1).getRetargetingList().getTargetListId());
      addCombination.getTargetLists().add(targetListData);
      addCombination.getTargetLists().add(targetListData2);

      CombinationTargetList addCombinationTargetList = new CombinationTargetList();
      addCombinationTargetList.setTargetListType(TargetListType.COMBINATION);
      addCombinationTargetList.getCombinations().addAll(Arrays.asList(addCombination));

      RetargetingList addCombinationRetargetingListOperand = new RetargetingList();
      addCombinationRetargetingListOperand.setAccountId(accountId);
      addCombinationRetargetingListOperand.setTargetListName("SampleCombination_CreateOn_" + SoapUtils.getCurrentTimestamp());
      addCombinationRetargetingListOperand.setDescription("SampleCombination_CreateOn_" + SoapUtils.getCurrentTimestamp());
      addCombinationRetargetingListOperand.setTargetList(addCombinationTargetList);

      addCombinationRetargetingListOperation.getOperand().add(addCombinationRetargetingListOperand);
//    }

    return addCombinationRetargetingListOperation;
  }

  /**
   * create RetargetingList request.<br>
   * get targetingListId of DefaultTargetList
   *
   * @param accountId long
   * @return RetargetingListSelector
   */
  public static RetargetingListSelector createRetargetingListSampleGetDefaultTargetListRequest(long accountId) {
    // Set Selector
    RetargetingListSelector getDefaultRetargetingListSelector = new RetargetingListSelector();
    getDefaultRetargetingListSelector.setAccountId(accountId);
    getDefaultRetargetingListSelector.getTargetListTypes().add(TargetListType.DEFAULT_LIST);
    Paging getDefaultRetargetingListPaging = new Paging();
    getDefaultRetargetingListPaging.setStartIndex(1);
    getDefaultRetargetingListPaging.setNumberResults(20);
    getDefaultRetargetingListSelector.setPaging(getDefaultRetargetingListPaging);

    return getDefaultRetargetingListSelector;
  }

  /**
   * create RetargetingList Similarity sample request.
   *
   * @param accountId             long
   * @param retargetingListValues RetargetingListValues
   * @return RetargetingListOperation
   */
  public static RetargetingListOperation createRetargetingListSampleAddSimilarityRequest(long accountId, List<RetargetingListValues> retargetingListValues) {
    RetargetingListOperation addSimilarityRetargetingListOperation = new RetargetingListOperation();
    addSimilarityRetargetingListOperation.setOperator(Operator.ADD);
    addSimilarityRetargetingListOperation.setAccountId(accountId);

    for (RetargetingListValues retargetingListValue : retargetingListValues) {
      SimilarityTargetList addSimilarityTargetList = new SimilarityTargetList();
      addSimilarityTargetList.setTargetListType(TargetListType.SIMILARITY);
      addSimilarityTargetList.setTargetListId(retargetingListValue.getRetargetingList().getTargetListId());
      addSimilarityTargetList.setTargetListSize(TargetListSize.RATE_6);

      RetargetingList addSimilarityRetargetingListOperand = new RetargetingList();
      addSimilarityRetargetingListOperand.setAccountId(accountId);
      addSimilarityRetargetingListOperand.setTargetListName("SampleSimilarity_CreateOn_" + SoapUtils.getCurrentTimestamp());
      addSimilarityRetargetingListOperand.setDescription("SampleSimilarity_CreateOn_" + SoapUtils.getCurrentTimestamp());
      addSimilarityRetargetingListOperand.setTargetList(addSimilarityTargetList);
      addSimilarityRetargetingListOperation.getOperand().add(addSimilarityRetargetingListOperand);
    }

    return addSimilarityRetargetingListOperation;
  }

  /**
   * create RetargetingList Custom Audience sample request.
   *
   * @param accountId             long
   * @return RetargetingListOperation
   */
  public static RetargetingListOperation createRetargetingListSampleAddCustomAudienceRequest(long accountId) {
    RetargetingListOperation addSimilarityRetargetingListOperation = new RetargetingListOperation();
    addSimilarityRetargetingListOperation.setOperator(Operator.ADD);
    addSimilarityRetargetingListOperation.setAccountId(accountId);


    CustomAudienceTargetList addCustomAudienceTargetList = new CustomAudienceTargetList();
    addCustomAudienceTargetList.setTargetListType(TargetListType.CUSTOM_AUDIENCE);
    addCustomAudienceTargetList.setReachPeriod(60);

    RetargetingList addSimilarityRetargetingListOperand = new RetargetingList();
    addSimilarityRetargetingListOperand.setAccountId(accountId);
    addSimilarityRetargetingListOperand.setTargetListName("SampleCustomAudience_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addSimilarityRetargetingListOperand.setDescription("SampleCustomAudience_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addSimilarityRetargetingListOperand.setTargetList(addCustomAudienceTargetList);
    addSimilarityRetargetingListOperation.getOperand().add(addSimilarityRetargetingListOperand);


    return addSimilarityRetargetingListOperation;
  }

  /**
   * create RetargetingList request.
   *
   * @param accountId                           long
   * @param addRetargetingListRuleValues        RetargetingListRuleValues ForRules
   * @param addRetargetingListCombinationValues RetargetingListRuleValues ForCombination
   * @param addRetargetingListSimilarityValues  RetargetingListRuleValues ForSimilarity
   * @return RetargetingListSelector
   */
  public static RetargetingListSelector createRetargetingListSampleGetRequest(long accountId, List<RetargetingListValues> addRetargetingListRuleValues,
                                                                              List<RetargetingListValues> addRetargetingListCombinationValues,
                                                                              List<RetargetingListValues> addRetargetingListSimilarityValues) {
    // Set Selector
    RetargetingListSelector retargetingListSelector = new RetargetingListSelector();
    retargetingListSelector.setAccountId(accountId);
    retargetingListSelector.getTargetListTypes().addAll(Arrays.asList(TargetListType.COMBINATION, TargetListType.RULE, TargetListType.DEFAULT_LIST, TargetListType.SIMILARITY));

    List<Long> targetListIds = new ArrayList<Long>();
    for (RetargetingListValues retargetingListValue : addRetargetingListRuleValues) {
      targetListIds.add(retargetingListValue.getRetargetingList().getTargetListId());
    }
    for (RetargetingListValues retargetingListValue : addRetargetingListCombinationValues) {
      targetListIds.add(retargetingListValue.getRetargetingList().getTargetListId());
    }
    for (RetargetingListValues retargetingListValue : addRetargetingListSimilarityValues) {
      targetListIds.add(retargetingListValue.getRetargetingList().getTargetListId());
    }

    retargetingListSelector.getTargetListIds().addAll(targetListIds);
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    retargetingListSelector.setPaging(paging);

    return retargetingListSelector;
  }


  /**
   * create RetargetingList Rule sample request.
   *
   * @param accountId             long
   * @param retargetingListValues RetargetingListValues
   * @return RetargetingListOperation
   */
  public static RetargetingListOperation createRetargetingListSampleSetRuleRequest(long accountId, List<RetargetingListValues> retargetingListValues) {

    RetargetingListOperation setRuleRetargetingListOperation = new RetargetingListOperation();
    setRuleRetargetingListOperation.setOperator(Operator.SET);
    setRuleRetargetingListOperation.setAccountId(accountId);

    for (int i = 0;i < retargetingListValues.size();i++) {
      if(i == 0) {
        RuleCondition setRuleCondition1_1 = new RuleCondition();
        setRuleCondition1_1.setType(RuleType.LABEL);
        setRuleCondition1_1.setCompareOperator(CompareOperator.NOT_END_WITH);
        setRuleCondition1_1.setValue("SampleLabel7");

        RuleCondition setRuleCondition1_2 = new RuleCondition();
        setRuleCondition1_2.setType(RuleType.URL);
        setRuleCondition1_2.setCompareOperator(CompareOperator.NOT_START_WITH);
        setRuleCondition1_2.setValue("sampleurl8.aaa");

        RuleCondition setRuleCondition1_3 = new RuleCondition();
        setRuleCondition1_3.setType(RuleType.REFERER_URL);
        setRuleCondition1_3.setCompareOperator(CompareOperator.NOT_INCLUDED);
        setRuleCondition1_3.setValue("sampleurl9.aaa");

        RuleCondition setRuleCondition1_4 = new RuleCondition();
        setRuleCondition1_4.setType(RuleType.LABEL);
        setRuleCondition1_4.setCompareOperator(CompareOperator.NOT_EQUAL);
        setRuleCondition1_4.setValue("SampleLabel10");

        RuleCondition setRuleCondition1_5 = new RuleCondition();
        setRuleCondition1_5.setType(RuleType.URL);
        setRuleCondition1_5.setCompareOperator(CompareOperator.END_WITH);
        setRuleCondition1_5.setValue("sampleurl11.bbb");

        RuleCondition setRuleCondition1_6 = new RuleCondition();
        setRuleCondition1_6.setType(RuleType.REFERER_URL);
        setRuleCondition1_6.setCompareOperator(CompareOperator.START_WITH);
        setRuleCondition1_6.setValue("sampleurl12.ccc");

        RuleCondition setRuleCondition1_7 = new RuleCondition();
        setRuleCondition1_7.setType(RuleType.PAGE_TYPE);
        setRuleCondition1_7.setCompareOperator(CompareOperator.EQUAL);
        setRuleCondition1_7.setValue("search");

        RuleCondition setRuleCondition1_8 = new RuleCondition();
        setRuleCondition1_8.setType(RuleType.ITEM_ID);
        setRuleCondition1_8.setCompareOperator(CompareOperator.EQUAL);
        setRuleCondition1_8.setValue("product002");

        RuleCondition setRuleCondition1_9 = new RuleCondition();
        setRuleCondition1_9.setType(RuleType.ITEM_CATEGORY_ID);
        setRuleCondition1_9.setCompareOperator(CompareOperator.EQUAL);
        setRuleCondition1_9.setValue("category002");

        Rule setRule = new Rule();
        setRule.getRuleConditions().addAll(Arrays
            .asList(setRuleCondition1_1, setRuleCondition1_2, setRuleCondition1_3, setRuleCondition1_4, setRuleCondition1_5, setRuleCondition1_6, setRuleCondition1_7,
                setRuleCondition1_8, setRuleCondition1_9));

        RuleTargetList setRuleTargetList = new RuleTargetList();
        setRuleTargetList.setTargetListType(TargetListType.RULE);
        setRuleTargetList.getRules().add(setRule);

        RetargetingList setRuleRetargetingListOperand = new RetargetingList();
        setRuleRetargetingListOperand.setAccountId(accountId);
        setRuleRetargetingListOperand.setTargetListId(retargetingListValues.get(i).getRetargetingList().getTargetListId());
        setRuleRetargetingListOperand.setTargetListName("SampleRule_UpdateOn_" + SoapUtils.getCurrentTimestamp());
        setRuleRetargetingListOperand.setDescription("SampleRulet_UpdateOn_" + SoapUtils.getCurrentTimestamp());
        setRuleRetargetingListOperand.setTargetList(setRuleTargetList);

        setRuleRetargetingListOperation.getOperand().add(setRuleRetargetingListOperand);
      } else if(i ==1){
        RuleCondition setRuleCondition2 = new RuleCondition();
        setRuleCondition2.setType(RuleType.LABEL);
        setRuleCondition2.setCompareOperator(CompareOperator.END_WITH);
        setRuleCondition2.setValue("SampleLabe2");

        Rule setRule2 = new Rule();
        setRule2.getRuleConditions().add(setRuleCondition2);

        RuleTargetList setRuleTargetList2 = new RuleTargetList();
        setRuleTargetList2.setTargetListType(TargetListType.RULE);
        setRuleTargetList2.getRules().add(setRule2);

        RetargetingList setRuleRetargetingListOperand2 = new RetargetingList();
        setRuleRetargetingListOperand2.setAccountId(accountId);
        setRuleRetargetingListOperand2.setTargetListId(retargetingListValues.get(i).getRetargetingList().getTargetListId());
        setRuleRetargetingListOperand2.setTargetListName("SampleRule2_CreateOn_" + SoapUtils.getCurrentTimestamp());
        setRuleRetargetingListOperand2.setDescription("SampleRulet2_CreateOn_" + SoapUtils.getCurrentTimestamp());
        setRuleRetargetingListOperand2.setTargetList(setRuleTargetList2);
        setRuleRetargetingListOperation.getOperand().add(setRuleRetargetingListOperand2);
      }else if(i ==2){
        RuleCondition setRuleCondition3 = new RuleCondition();
        setRuleCondition3.setType(RuleType.EVENT_TYPE);
        setRuleCondition3.setCompareOperator(CompareOperator.EQUAL);
        setRuleCondition3.setValue("purchase");

        Rule setRule3 = new Rule();
        setRule3.getRuleConditions().add(setRuleCondition3);

        RuleTargetList setRuleTargetList3 = new RuleTargetList();
        setRuleTargetList3.setTargetListType(TargetListType.RULE);
        setRuleTargetList3.getRules().add(setRule3);

        RetargetingList setRuleRetargetingListOperand3 = new RetargetingList();
        setRuleRetargetingListOperand3.setAccountId(accountId);
        setRuleRetargetingListOperand3.setTargetListId(retargetingListValues.get(i).getRetargetingList().getTargetListId());
        setRuleRetargetingListOperand3.setTargetListName("SampleRule3_CreateOn_" + SoapUtils.getCurrentTimestamp());
        setRuleRetargetingListOperand3.setDescription("SampleRulet3_CreateOn_" + SoapUtils.getCurrentTimestamp());
        setRuleRetargetingListOperand3.setTargetList(setRuleTargetList3);
        setRuleRetargetingListOperation.getOperand().add(setRuleRetargetingListOperand3);
      }

    }

    return setRuleRetargetingListOperation;
  }

  /**
   * create RetargetingList Combination sample request.
   *
   * @param accountId                        long
   * @param retargetingListRuleValues        RetargetingListValues for Rule
   * @param retargetingListCombinationValues RetargetingListValues for Combination
   * @return RetargetingListOperation
   */
  public static RetargetingListOperation createRetargetingListSampleSetCombinationRequest(long accountId, List<RetargetingListValues> retargetingListRuleValues,
                                                                                          List<RetargetingListValues> retargetingListCombinationValues) {

    RetargetingListOperation setCombinationRetargetingListOperation = new RetargetingListOperation();
    setCombinationRetargetingListOperation.setOperator(Operator.SET);
    setCombinationRetargetingListOperation.setAccountId(accountId);

//    for (RetargetingListValues retargetingListRuleValue : retargetingListRuleValues) {
      TargetListData setTargetListData = new TargetListData();
      setTargetListData.setTargetListId(retargetingListRuleValues.get(0).getRetargetingList().getTargetListId());

      TargetListData setTargetListData2 = new TargetListData();
      setTargetListData2.setTargetListId(retargetingListRuleValues.get(1).getRetargetingList().getTargetListId());

      for (RetargetingListValues retargetingListCombinationValue : retargetingListCombinationValues) {
        Combination setCombination = new Combination();
        setCombination.setLogicalOperator(LogicalOperator.OR);

        setCombination.getTargetLists().addAll(Arrays.asList(setTargetListData,setTargetListData2));

        CombinationTargetList setCombinationTargetList = new CombinationTargetList();
        setCombinationTargetList.setTargetListType(TargetListType.COMBINATION);
        setCombinationTargetList.getCombinations().add(setCombination);

        RetargetingList setCombinationRetargetingListOperand = new RetargetingList();
        setCombinationRetargetingListOperand.setAccountId(accountId);
        setCombinationRetargetingListOperand.setTargetListId(retargetingListCombinationValue.getRetargetingList().getTargetListId());
        setCombinationRetargetingListOperand.setTargetListName("SampleCombination_UpdateOn_" + SoapUtils.getCurrentTimestamp());
        setCombinationRetargetingListOperand.setDescription("SampleCombination_UpdateOn_" + SoapUtils.getCurrentTimestamp());
        setCombinationRetargetingListOperand.setTargetList(setCombinationTargetList);

        setCombinationRetargetingListOperation.getOperand().add(setCombinationRetargetingListOperand);
      }
//    }
    return setCombinationRetargetingListOperation;
  }

  /**
   * create RetargetingList Similarity sample request.
   *
   * @param accountId             long
   * @param retargetingListValues RetargetingListValues
   * @return RetargetingListOperation
   */
  public static RetargetingListOperation createRetargetingListSampleSetSimilarityRequest(long accountId, List<RetargetingListValues> retargetingListValues) {

    RetargetingListOperation setSimilaritRetargetingListOperation = new RetargetingListOperation();
    setSimilaritRetargetingListOperation.setOperator(Operator.SET);
    setSimilaritRetargetingListOperation.setAccountId(accountId);

    SimilarityTargetList similarityTargetList = new SimilarityTargetList();
    similarityTargetList.setTargetListType(TargetListType.SIMILARITY);
    similarityTargetList.setTargetListSize(TargetListSize.RATE_3);
    RetargetingList setSimilarityRetargetingListOperand = new RetargetingList();
    setSimilarityRetargetingListOperand.setAccountId(accountId);
    setSimilarityRetargetingListOperand.setTargetListId(retargetingListValues.get(0).getRetargetingList().getTargetListId());
    setSimilarityRetargetingListOperand.setTargetListName("SampleSimilarity_UpdateOn_" + SoapUtils.getCurrentTimestamp());
    setSimilarityRetargetingListOperand.setDescription("SampleSimilarity_UpdateOn_" + SoapUtils.getCurrentTimestamp());

    setSimilarityRetargetingListOperand.setTargetList(similarityTargetList);

    setSimilaritRetargetingListOperation.getOperand().add(setSimilarityRetargetingListOperand);

    return setSimilaritRetargetingListOperation;
  }

  /**
   * create RetargetingList Custom Audience sample request.
   *
   * @param accountId             long
   * @param retargetingListValues RetargetingListValues
   * @return RetargetingListOperation
   */
  public static RetargetingListOperation createRetargetingListSampleSetCustomAudienceRequest(long accountId, List<RetargetingListValues> retargetingListValues) {

    RetargetingListOperation setCustomAudienceRetargetingListOperation = new RetargetingListOperation();
    setCustomAudienceRetargetingListOperation.setOperator(Operator.SET);
    setCustomAudienceRetargetingListOperation.setAccountId(accountId);

    for (RetargetingListValues retargetingListValue : retargetingListValues) {
      CustomAudienceTargetList targetList = new CustomAudienceTargetList();
      targetList.setTargetListType(TargetListType.CUSTOM_AUDIENCE);

      RetargetingList setCustomAudienceRetargetingListOperand = new RetargetingList();
      setCustomAudienceRetargetingListOperand.setAccountId(accountId);
      setCustomAudienceRetargetingListOperand.setTargetListId(retargetingListValue.getRetargetingList().getTargetListId());
      setCustomAudienceRetargetingListOperand.setTargetListName("SampleCustomAudience_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setCustomAudienceRetargetingListOperand.setDescription("SampleCustomAudience" + SoapUtils.getCurrentTimestamp());
      setCustomAudienceRetargetingListOperand.setTargetList(targetList);

      setCustomAudienceRetargetingListOperation.getOperand().add(setCustomAudienceRetargetingListOperand);
    }
    return setCustomAudienceRetargetingListOperation;
  }

  /**
   * create RetargetingList sample request.
   *
   * @param accountId                           long
   * @param addRetargetingListRuleValues        RetargetingListRuleValues ForRules
   * @param addRetargetingListCombinationValues RetargetingListRuleValues ForCombination
   * @param addRetargetingListSimilarityValues  RetargetingListRuleValues ForSimilarity
   * @return RetargetingListOperation
   */
  public static RetargetingListOperation createRetargetingListSampleRemoveRequest(long accountId, List<RetargetingListValues> addRetargetingListRuleValues,
                                                                                  List<RetargetingListValues> addRetargetingListCombinationValues,
                                                                                  List<RetargetingListValues> addRetargetingListSimilarityValues,
                                                                                  List<RetargetingListValues> addRetargetingListCustomAudienceValues) {
    RetargetingListOperation removeRetargetingListOperation = new RetargetingListOperation();
    removeRetargetingListOperation.setOperator(Operator.REMOVE);
    removeRetargetingListOperation.setAccountId(accountId);

    for (RetargetingListValues retargetingListValue : addRetargetingListCustomAudienceValues) {
      RetargetingList removeRetargetingListOperand = new RetargetingList();
      removeRetargetingListOperand.setAccountId(accountId);
      removeRetargetingListOperand.setTargetListId(retargetingListValue.getRetargetingList().getTargetListId());
      removeRetargetingListOperation.getOperand().add(removeRetargetingListOperand);
    }
    for (RetargetingListValues retargetingListValue : addRetargetingListCombinationValues) {
      RetargetingList removeRetargetingListOperand = new RetargetingList();
      removeRetargetingListOperand.setAccountId(accountId);
      removeRetargetingListOperand.setTargetListId(retargetingListValue.getRetargetingList().getTargetListId());
      removeRetargetingListOperation.getOperand().add(removeRetargetingListOperand);
    }

    for (RetargetingListValues retargetingListValue : addRetargetingListRuleValues) {
      RetargetingList removeRetargetingListOperand = new RetargetingList();
      removeRetargetingListOperand.setAccountId(accountId);
      removeRetargetingListOperand.setTargetListId(retargetingListValue.getRetargetingList().getTargetListId());
      removeRetargetingListOperation.getOperand().add(removeRetargetingListOperand);
    }

    for (RetargetingListValues retargetingListValue : addRetargetingListSimilarityValues) {
      RetargetingList removeRetargetingListOperand = new RetargetingList();
      removeRetargetingListOperand.setAccountId(accountId);
      removeRetargetingListOperand.setTargetListId(retargetingListValue.getRetargetingList().getTargetListId());
      removeRetargetingListOperation.getOperand().add(removeRetargetingListOperand);
    }

    return removeRetargetingListOperation;
  }

  /**
   * display RetargetingList entity to stdout.
   *
   * @param retargetingList RetargetingList entity for display.
   */
  private static void displayRetargetingList(RetargetingList retargetingList) {
    System.out.println("accountId = " + retargetingList.getAccountId());
    System.out.println("targetListId = " + retargetingList.getTargetListId());
    System.out.println("targetListName = " + retargetingList.getTargetListName());
    System.out.println("description = " + retargetingList.getDescription());
    System.out.println("reach = " + retargetingList.getReach());
    System.out.println("deliveryStatus = " + retargetingList.getDeliveryStatus());
    if (retargetingList.getTargetList() != null) {
      System.out.println("targetList---------");
      System.out.println("targetList/targetListType = " + retargetingList.getTargetList().getTargetListType());
      if (retargetingList.getTargetList() instanceof RuleTargetList) {
        RuleTargetList ruleTargetList = (RuleTargetList) retargetingList.getTargetList();
        System.out.println("targetList/retargetingTagId = " + ruleTargetList.getRetargetingTagId());
        System.out.println("targetList/isPreset = " + ruleTargetList.getIsPreset());
        if (ruleTargetList.getRules() != null && ruleTargetList.getRules().size() > 0) {
          for (int i = 0; i < ruleTargetList.getRules().size(); i++) {
            List<Rule> rules = ruleTargetList.getRules();
            for (int j = 0; j < rules.get(i).getRuleConditions().size(); j++) {
              RuleCondition condition = rules.get(i).getRuleConditions().get(j);
              System.out.println("targetList/rule" + i + "/ruleCondition" + j + "/type = " + condition.getType());
              System.out.println("targetList/rule" + i + "/ruleCondition" + j + "/compareOperator = " + condition.getCompareOperator());
              System.out.println("targetList/rule" + i + "/ruleCondition" + j + "/value = " + condition.getValue());
            }
          }
        }
      } else if (retargetingList.getTargetList() instanceof CombinationTargetList) {
        CombinationTargetList combinationTargetList = (CombinationTargetList) retargetingList.getTargetList();
        if (combinationTargetList.getCombinations() != null && combinationTargetList.getCombinations().size() > 0) {
          for (int i = 0; i < combinationTargetList.getCombinations().size(); i++) {
            Combination combination = combinationTargetList.getCombinations().get(i);
            System.out.println("targetList/combination" + i + "/logicalOperator = " + combination.getLogicalOperator());
            for (int j = 0; j < combination.getTargetLists().size(); j++) {
              TargetListData targetListData = combination.getTargetLists().get(j);
              System.out.println("targetList/combination" + i + "/targetLists" + j + "/targetListId = " + targetListData.getTargetListId());
              System.out.println("targetList/combination" + i + "/targetLists" + j + "/targetListName = " + targetListData.getTargetListName());
            }
          }
        }
      } else if (retargetingList.getTargetList() instanceof SimilarityTargetList) {
        SimilarityTargetList similarityTargetList = (SimilarityTargetList) retargetingList.getTargetList();
        System.out.println("targetList/targetListId = " + similarityTargetList.getTargetListId());
        System.out.println("targetList/targetListSize = " + similarityTargetList.getTargetListSize().name());
        if (null != similarityTargetList.getTargetListSizeReaches()) {
          for(int i = 0; i < similarityTargetList.getTargetListSizeReaches().size();i++) {
            TargetListSizeReaches sizeReaches = (TargetListSizeReaches)similarityTargetList.getTargetListSizeReaches().get(i);
            System.out.println("targetList/targetListSizeReaches/targetListSize = " + sizeReaches.getTargetListSize().name());
            System.out.println("targetList/targetListSizeReaches/reach = " + sizeReaches.getReach());
          }
        }

      }
    }

    System.out.println("---------");
  }

  /**
   * display RetargetingTag entity to stdout.
   *
   * @param retargetingTag RetargetingTag entity for display.
   */
  private static void displayRetargetingTag(RetargetingTag retargetingTag) {
    System.out.println("retargetingTagId = " + retargetingTag.getRetargetingTagId());
    System.out.println("accountId = " + retargetingTag.getAccountId());
    System.out.println("approvalStatus = " + retargetingTag.getApprovalStatus());

    System.out.println("---------");

  }
}
