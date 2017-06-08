package jp.co.yahoo.ad_api_sample.retargetingSample;

import jp.co.yahoo.ad_api_sample.error.impl.RetargetingListServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.error.impl.RetargetingTagServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.V6.RetargetingListService.Combination;
import jp.yahooapis.im.V6.RetargetingListService.CombinationTargetList;
import jp.yahooapis.im.V6.RetargetingListService.CompareOperator;
import jp.yahooapis.im.V6.RetargetingListService.CustomAudienceTargetList;
import jp.yahooapis.im.V6.RetargetingListService.IsOpen;
import jp.yahooapis.im.V6.RetargetingListService.IsPreset;
import jp.yahooapis.im.V6.RetargetingListService.LogicalOperator;
import jp.yahooapis.im.V6.RetargetingListService.Operator;
import jp.yahooapis.im.V6.RetargetingListService.Paging;
import jp.yahooapis.im.V6.RetargetingListService.RetargetingList;
import jp.yahooapis.im.V6.RetargetingListService.RetargetingListOperation;
import jp.yahooapis.im.V6.RetargetingListService.RetargetingListPage;
import jp.yahooapis.im.V6.RetargetingListService.RetargetingListReturnValue;
import jp.yahooapis.im.V6.RetargetingListService.RetargetingListSelector;
import jp.yahooapis.im.V6.RetargetingListService.RetargetingListServiceInterface;
import jp.yahooapis.im.V6.RetargetingListService.RetargetingListServiceService;
import jp.yahooapis.im.V6.RetargetingListService.RetargetingListValues;
import jp.yahooapis.im.V6.RetargetingListService.Rule;
import jp.yahooapis.im.V6.RetargetingListService.RuleCondition;
import jp.yahooapis.im.V6.RetargetingListService.RuleTargetList;
import jp.yahooapis.im.V6.RetargetingListService.RuleType;
import jp.yahooapis.im.V6.RetargetingListService.SimilarityTargetList;
import jp.yahooapis.im.V6.RetargetingListService.TargetListData;
import jp.yahooapis.im.V6.RetargetingListService.TargetListType;
import jp.yahooapis.im.V6.RetargetingTagService.Error;
import jp.yahooapis.im.V6.RetargetingTagService.RetargetingTag;
import jp.yahooapis.im.V6.RetargetingTagService.RetargetingTagOperation;
import jp.yahooapis.im.V6.RetargetingTagService.RetargetingTagPage;
import jp.yahooapis.im.V6.RetargetingTagService.RetargetingTagReturnValue;
import jp.yahooapis.im.V6.RetargetingTagService.RetargetingTagSelector;
import jp.yahooapis.im.V6.RetargetingTagService.RetargetingTagService;
import jp.yahooapis.im.V6.RetargetingTagService.RetargetingTagServiceInterface;
import jp.yahooapis.im.V6.RetargetingTagService.RetargetingTagValues;

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
      RetargetingListOperation addCustomAudienceRetargetingListOperation = createRetargetingListSampleAddCustomAudienceRequest(accountId, addRetargetingListRuleValues);

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
          createRetargetingListSampleRemoveRequest(accountId, addRetargetingListRuleValues, addRetargetingListCombinationValues, addRetargetingListSimilarityValues);

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
    Holder<List<jp.yahooapis.im.V6.RetargetingTagService.Error>> addRetargetingTagErrorHolder = new Holder<List<jp.yahooapis.im.V6.RetargetingTagService.Error>>();
    retargetingTagService.mutate(operation, addRetargetingTagReturnValueHolder, addRetargetingTagErrorHolder);

    // if error
    if (addRetargetingTagErrorHolder.value != null && addRetargetingTagErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new RetargetingTagServiceErrorEntityFactory(addRetargetingTagErrorHolder.value), false);
    }

    if (addRetargetingTagReturnValueHolder.value != null) {
      RetargetingTagReturnValue returnValue = addRetargetingTagReturnValueHolder.value;
      if (returnValue.getValues() != null) {
        for (RetargetingTagValues values : returnValue.getValues()) {
          if (values.isOperationSucceeded()) {
            displayRetargetingTag(values.getRetargetingTag());
          } else {
            // if error
            SoapUtils.displayErrors(new RetargetingTagServiceErrorEntityFactory(values.getError()), false);
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
      SoapUtils.displayErrors(new RetargetingTagServiceErrorEntityFactory(getRetargetingTagErrorHolder.value), true);
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
            SoapUtils.displayErrors(new RetargetingTagServiceErrorEntityFactory(value.getError()), true);
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
    Holder<List<jp.yahooapis.im.V6.RetargetingListService.Error>> addRuleRetargetingListErrorHolder = new Holder<List<jp.yahooapis.im.V6.RetargetingListService.Error>>();
    retargetingListService.mutate(operation, addRuleRetargetingListReturnValueHolder, addRuleRetargetingListErrorHolder);

    // if error
    if (addRuleRetargetingListErrorHolder.value != null && addRuleRetargetingListErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(addRuleRetargetingListErrorHolder.value), true);
    }

    if (addRuleRetargetingListReturnValueHolder.value != null) {
      RetargetingListReturnValue returnValue = addRuleRetargetingListReturnValueHolder.value;
      if (returnValue.getValues() != null) {
        for (RetargetingListValues values : returnValue.getValues()) {
          if (values.isOperationSucceeded()) {
            displayRetargetingList(values.getRetargetingList());
          } else {
            // if error
            SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(values.getError()), true);
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
    Holder<List<jp.yahooapis.im.V6.RetargetingListService.Error>> getDefaultRetargetingListErrorHolder = new Holder<List<jp.yahooapis.im.V6.RetargetingListService.Error>>();
    retargetingListService.get(selector, getDefaultRetargetingListPageHolder, getDefaultRetargetingListErrorHolder);

    // if error
    if (getDefaultRetargetingListErrorHolder.value != null && getDefaultRetargetingListErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(getDefaultRetargetingListErrorHolder.value), true);
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
            SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(values.getError()), true);
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
    Holder<List<jp.yahooapis.im.V6.RetargetingListService.Error>> setRuleRetargetingListErrorHolder = new Holder<List<jp.yahooapis.im.V6.RetargetingListService.Error>>();
    retargetingListService.mutate(operation, setRuleRetargetingListReturnValueHolder, setRuleRetargetingListErrorHolder);

    // if error
    if (setRuleRetargetingListErrorHolder.value != null && setRuleRetargetingListErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(setRuleRetargetingListErrorHolder.value), true);
    }

    // response
    if (setRuleRetargetingListReturnValueHolder.value != null) {
      RetargetingListReturnValue returnValue = setRuleRetargetingListReturnValueHolder.value;
      if (returnValue != null) {
        for (RetargetingListValues values : returnValue.getValues()) {
          if (values.isOperationSucceeded()) {
            displayRetargetingList(values.getRetargetingList());
          } else {
            SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(values.getError()), true);
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
    Holder<List<jp.yahooapis.im.V6.RetargetingListService.Error>> removeRetargetingListErrorHolder = new Holder<List<jp.yahooapis.im.V6.RetargetingListService.Error>>();
    retargetingListService.mutate(operation, removeRetargetingListReturnValueHolder, removeRetargetingListErrorHolder);

    // if error
    if (removeRetargetingListErrorHolder.value != null && removeRetargetingListErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(removeRetargetingListErrorHolder.value), true);
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
            SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(values.getError()), true);
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
    addRetargetingTagOperation.setOperator(jp.yahooapis.im.V6.RetargetingTagService.Operator.ADD);
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

    RetargetingListOperation addRuleRetargetingListOperation = new RetargetingListOperation();
    addRuleRetargetingListOperation.setOperator(Operator.ADD);
    addRuleRetargetingListOperation.setAccountId(accountId);
    List<RetargetingList> ruleTargetListOperand = addRuleRetargetingListOperation.getOperand();
    ruleTargetListOperand.add(addRuleRetargetingListOperand);

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

    for (RetargetingListValues retargetingListValue : retargetingListValues) {
      Combination addCombination = new Combination();
      addCombination.setLogicalOperator(LogicalOperator.AND);
      TargetListData targetListData = new TargetListData();
      targetListData.setTargetListId(retargetingListValue.getRetargetingList().getTargetListId());
      addCombination.getTargetLists().add(targetListData);

      CombinationTargetList addCombinationTargetList = new CombinationTargetList();
      addCombinationTargetList.setTargetListType(TargetListType.COMBINATION);
      addCombinationTargetList.getCombinations().addAll(Arrays.asList(addCombination));

      RetargetingList addCombinationRetargetingListOperand = new RetargetingList();
      addCombinationRetargetingListOperand.setAccountId(accountId);
      addCombinationRetargetingListOperand.setTargetListName("SampleCombination_CreateOn_" + SoapUtils.getCurrentTimestamp());
      addCombinationRetargetingListOperand.setDescription("SampleCombination_CreateOn_" + SoapUtils.getCurrentTimestamp());
      addCombinationRetargetingListOperand.setTargetList(addCombinationTargetList);

      addCombinationRetargetingListOperation.getOperand().add(addCombinationRetargetingListOperand);
    }

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
   * @param retargetingListValues RetargetingListValues
   * @return RetargetingListOperation
   */
  public static RetargetingListOperation createRetargetingListSampleAddCustomAudienceRequest(long accountId, List<RetargetingListValues> retargetingListValues) {
    RetargetingListOperation addSimilarityRetargetingListOperation = new RetargetingListOperation();
    addSimilarityRetargetingListOperation.setOperator(Operator.ADD);
    addSimilarityRetargetingListOperation.setAccountId(accountId);

    for (RetargetingListValues retargetingListValue : retargetingListValues) {
      CustomAudienceTargetList addCustomAudienceTargetList = new CustomAudienceTargetList();
      addCustomAudienceTargetList.setTargetListType(TargetListType.CUSTOM_AUDIENCE);
      addCustomAudienceTargetList.setReachPeriod(60);

      RetargetingList addSimilarityRetargetingListOperand = new RetargetingList();
      addSimilarityRetargetingListOperand.setAccountId(accountId);
      addSimilarityRetargetingListOperand.setTargetListName("SampleCustomAudience_CreateOn_" + SoapUtils.getCurrentTimestamp());
      addSimilarityRetargetingListOperand.setDescription("SampleCustomAudience_CreateOn_" + SoapUtils.getCurrentTimestamp());
      addSimilarityRetargetingListOperand.setTargetList(addCustomAudienceTargetList);
      addSimilarityRetargetingListOperation.getOperand().add(addSimilarityRetargetingListOperand);
    }

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

    for (RetargetingListValues retargetingListValue : retargetingListValues) {
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
      setRuleRetargetingListOperand.setTargetListId(retargetingListValue.getRetargetingList().getTargetListId());
      setRuleRetargetingListOperand.setTargetListName("SampleRule_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setRuleRetargetingListOperand.setDescription("SampleRulet_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setRuleRetargetingListOperand.setTargetList(setRuleTargetList);

      setRuleRetargetingListOperation.getOperand().add(setRuleRetargetingListOperand);
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

    for (RetargetingListValues retargetingListRuleValue : retargetingListRuleValues) {
      TargetListData setTargetListData = new TargetListData();
      setTargetListData.setTargetListId(retargetingListRuleValue.getRetargetingList().getTargetListId());

      for (RetargetingListValues retargetingListCombinationValue : retargetingListCombinationValues) {
        Combination setCombination = new Combination();
        setCombination.setLogicalOperator(LogicalOperator.OR);

        setCombination.getTargetLists().add(setTargetListData);

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
    }
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

    for (RetargetingListValues retargetingListValue : retargetingListValues) {
      RetargetingList setSimilarityRetargetingListOperand = new RetargetingList();
      setSimilarityRetargetingListOperand.setAccountId(accountId);
      setSimilarityRetargetingListOperand.setTargetListId(retargetingListValue.getRetargetingList().getTargetListId());
      setSimilarityRetargetingListOperand.setTargetListName("SampleSimilarity_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setSimilarityRetargetingListOperand.setDescription("SampleSimilarity_UpdateOn_" + SoapUtils.getCurrentTimestamp());

      setSimilaritRetargetingListOperation.getOperand().add(setSimilarityRetargetingListOperand);
    }
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
      RetargetingList setCustomAudienceRetargetingListOperand = new RetargetingList();
      setCustomAudienceRetargetingListOperand.setAccountId(accountId);
      setCustomAudienceRetargetingListOperand.setTargetListId(retargetingListValue.getRetargetingList().getTargetListId());
      setCustomAudienceRetargetingListOperand.setTargetListName("SampleCustomAudience_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setCustomAudienceRetargetingListOperand.setDescription("SampleCustomAudience" + SoapUtils.getCurrentTimestamp());

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
                                                                                  List<RetargetingListValues> addRetargetingListSimilarityValues) {
    RetargetingListOperation removeRetargetingListOperation = new RetargetingListOperation();
    removeRetargetingListOperation.setOperator(Operator.REMOVE);
    removeRetargetingListOperation.setAccountId(accountId);

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
