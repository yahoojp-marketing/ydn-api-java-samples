package jp.co.yahoo.ad_api_sample.adSample;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.CampaignServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.V5.CampaignService.BiddingStrategyType;
import jp.yahooapis.im.V5.CampaignService.Budget;
import jp.yahooapis.im.V5.CampaignService.BudgetDeliveryMethod;
import jp.yahooapis.im.V5.CampaignService.Campaign;
import jp.yahooapis.im.V5.CampaignService.CampaignOperation;
import jp.yahooapis.im.V5.CampaignService.CampaignPage;
import jp.yahooapis.im.V5.CampaignService.CampaignReturnValue;
import jp.yahooapis.im.V5.CampaignService.CampaignSelector;
import jp.yahooapis.im.V5.CampaignService.CampaignServiceInterface;
import jp.yahooapis.im.V5.CampaignService.CampaignServiceService;
import jp.yahooapis.im.V5.CampaignService.CampaignValues;
import jp.yahooapis.im.V5.CampaignService.Error;
import jp.yahooapis.im.V5.CampaignService.FrequencyCap;
import jp.yahooapis.im.V5.CampaignService.FrequencyLevel;
import jp.yahooapis.im.V5.CampaignService.FrequencyTimeUnit;
import jp.yahooapis.im.V5.CampaignService.ManualCPC;
import jp.yahooapis.im.V5.CampaignService.Operator;
import jp.yahooapis.im.V5.CampaignService.Paging;
import jp.yahooapis.im.V5.CampaignService.UserStatus;

/**
 * Sample Program for CampaignService.<br>
 * Copyright (C) 2016 Yahoo Japan Corporation. All Rights Reserved.
 */
public class CampaignServiceSample {
  /**
   * main method for CampaignServiceSample
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
      // CampaignService::ADD
      // =================================================================
      // Set Operation
      CampaignOperation addCampaignOperation = createSampleAddRequest(accountId);

      // Run
      List<CampaignValues> addCampaignValues = add(addCampaignOperation);

      // =================================================================
      // CampaignService::GET
      // =================================================================
      // Set Selector
      CampaignSelector campaignSelector = createSampleGetRequest(accountId, addCampaignValues);

      // Run
      get(campaignSelector);

      // =================================================================
      // CampaignService::SET
      // =================================================================
      // Set Operation
      CampaignOperation setCampaignOperation = createSampleSetRequest(accountId, addCampaignValues);

      // Run
      set(setCampaignOperation);

      // =================================================================
      // CampaignService::REMOVE
      // =================================================================
      // Set Operation
      CampaignOperation removeCampaignOperation = createSampleRemoveRequest(accountId, addCampaignValues);

      // Run
      remove(removeCampaignOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for CampaignService ADD.
   *
   * @param operation CampaignOperation
   * @return CampaignValues
   * @throws Exception
   */
  public static List<CampaignValues> add(CampaignOperation operation) throws Exception {
    // =================================================================
    // CampaignService
    // =================================================================
    CampaignServiceInterface campaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignServiceService.class);

    // call API
    System.out.println("############################################");
    System.out.println("CampaignService::mutate(ADD)");
    System.out.println("############################################");
    Holder<CampaignReturnValue> addCampaignReturnValueHolder = new Holder<CampaignReturnValue>();
    Holder<List<Error>> addCampaignErrorHolder = new Holder<List<Error>>();
    campaignService.mutate(operation, addCampaignReturnValueHolder, addCampaignErrorHolder);

    // if error
    if (addCampaignErrorHolder.value != null && addCampaignErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(addCampaignErrorHolder.value), true);
    }

    // response
    if (addCampaignReturnValueHolder.value != null) {
      CampaignReturnValue returnValue = addCampaignReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<CampaignValues> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            Campaign campaign = values.get(i).getCampaign();
            displayCampaign(campaign);
          } else {
            // if error
            SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(values.get(i).getError()), true);
          }
        }
      }
    }
    // Response
    return addCampaignReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignService SET.
   *
   * @param operation CampaignOperation
   * @return CampaignValues
   * @throws Exception
   */
  public static List<CampaignValues> set(CampaignOperation operation) throws Exception {
    // =================================================================
    // CampaignService
    // =================================================================
    CampaignServiceInterface campaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignServiceService.class);

    // call API
    System.out.println("############################################");
    System.out.println("CampaignService::mutate(SET)");
    System.out.println("############################################");
    Holder<CampaignReturnValue> setCampaignReturnValueHolder = new Holder<CampaignReturnValue>();
    Holder<List<Error>> setCampaignErrorHolder = new Holder<List<Error>>();
    campaignService.mutate(operation, setCampaignReturnValueHolder, setCampaignErrorHolder);

    // if error
    if (setCampaignErrorHolder.value != null && setCampaignErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(setCampaignErrorHolder.value), true);
    }

    // response
    if (setCampaignReturnValueHolder.value != null) {
      CampaignReturnValue returnValue = setCampaignReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<CampaignValues> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayCampaign(values.get(i).getCampaign());
          } else {
            // if error
            SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(values.get(i).getError()), true);
          }
        }
      }
    }


    // Response
    return setCampaignReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignService REMOVE.
   *
   * @param operation CampaignOperation
   * @return CampaignValues
   * @throws Exception
   */
  public static List<CampaignValues> remove(CampaignOperation operation) throws Exception {
    // =================================================================
    // CampaignService
    // =================================================================
    CampaignServiceInterface campaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignServiceService.class);

    System.out.println("############################################");
    System.out.println("CampaignService::mutate(REMOVE)");
    System.out.println("############################################");
    Holder<CampaignReturnValue> removeCampaignReturnValueHolder = new Holder<CampaignReturnValue>();
    Holder<List<Error>> removeCampaignErrorHolder = new Holder<List<Error>>();
    campaignService.mutate(operation, removeCampaignReturnValueHolder, removeCampaignErrorHolder);

    // if error
    if (removeCampaignErrorHolder.value != null && removeCampaignErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(removeCampaignErrorHolder.value), true);
    }

    // response
    if (removeCampaignReturnValueHolder.value != null) {
      CampaignReturnValue returnValue = removeCampaignReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<CampaignValues> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayCampaign(values.get(i).getCampaign());
          } else {
            // if error
            SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(values.get(i).getError()), true);
          }
        }
      }
    }
    return removeCampaignReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignService GET.
   *
   * @param selector CampaignSelector
   * @return CampaignValues
   * @throws Exception
   */
  public static List<CampaignValues> get(CampaignSelector selector) throws Exception {
    // =================================================================
    // CampaignService
    // =================================================================
    CampaignServiceInterface campaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignServiceService.class);


    System.out.println("############################################");
    System.out.println("CampaignService::get");
    System.out.println("############################################");
    Holder<CampaignPage> campaignPageHolder = new Holder<CampaignPage>();
    Holder<List<Error>> getCampaignErrorHolder = new Holder<List<Error>>();
    campaignService.get(selector, campaignPageHolder, getCampaignErrorHolder);

    // if error
    if (getCampaignErrorHolder.value != null && getCampaignErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(getCampaignErrorHolder.value), true);
    }

    // response
    if (campaignPageHolder.value != null) {
      CampaignPage campaignPage = campaignPageHolder.value;
      if (campaignPage.getValues() != null && campaignPage.getValues().size() > 0) {
        List<CampaignValues> values = campaignPage.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            displayCampaign(values.get(i).getCampaign());
          } else {
            // if error
            SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(values.get(i).getError()), true);
          }
        }
      }
    }

    // Response
    return campaignPageHolder.value.getValues();
  }


  /**
   * create sample request.
   *
   * @param accountId long
   * @return CampaignOperation
   */
  public static CampaignOperation createSampleAddRequest(long accountId) {
    Campaign addCampaignOperand = new Campaign();
    addCampaignOperand.setAccountId(accountId);
    addCampaignOperand.setCampaignName("SampleCampaign_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addCampaignOperand.setUserStatus(jp.yahooapis.im.V5.CampaignService.UserStatus.ACTIVE);
    addCampaignOperand.setStartDate("20300101");
    addCampaignOperand.setEndDate("20301231");
    Budget budget = new Budget();
    budget.setAmount((long) 1000);
    budget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);
    addCampaignOperand.setBudget(budget);
    ManualCPC manualCPC = new ManualCPC();
    manualCPC.setType(BiddingStrategyType.MANUAL_CPC);
    addCampaignOperand.setBiddingStrategy(manualCPC);
    addCampaignOperand.setAdProductType("TARGET_MATCH");
    FrequencyCap frequencyCap = new FrequencyCap();
    frequencyCap.setLevel(FrequencyLevel.CAMPAIGN);
    frequencyCap.setTimeUnit(FrequencyTimeUnit.WEEK);
    frequencyCap.setImpression((long) 10);
    addCampaignOperand.setFrequencyCap(frequencyCap);

    CampaignOperation addCampaignOperation = new CampaignOperation();
    addCampaignOperation.setOperator(jp.yahooapis.im.V5.CampaignService.Operator.ADD);
    addCampaignOperation.setAccountId(accountId);
    addCampaignOperation.getOperand().add(addCampaignOperand);

    return addCampaignOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignValues CampaignValues
   * @return CampaignOperation
   */
  public static CampaignOperation createSampleSetRequest(long accountId, List<CampaignValues> campaignValues) {
    CampaignOperation setCampaignOperation = new CampaignOperation();
    setCampaignOperation.setOperator(jp.yahooapis.im.V5.CampaignService.Operator.SET);
    setCampaignOperation.setAccountId(accountId);

    for (CampaignValues campaignValue : campaignValues) {
      Campaign setCampaignOperand = new Campaign();
      setCampaignOperand.setAccountId(campaignValue.getCampaign().getAccountId());
      setCampaignOperand.setCampaignId(campaignValue.getCampaign().getCampaignId());
      setCampaignOperand.setCampaignName("SampleCampaign_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setCampaignOperand.setUserStatus(jp.yahooapis.im.V5.CampaignService.UserStatus.PAUSED);
      setCampaignOperand.setStartDate("20300101");
      setCampaignOperand.setEndDate("20301231");
      Budget setCamapginBudget = new Budget();
      setCamapginBudget.setAmount((long) 1000);
      setCamapginBudget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);
      setCampaignOperand.setBudget(setCamapginBudget);
      ManualCPC setCampaignManualCpc = new ManualCPC();
      setCampaignManualCpc.setType(BiddingStrategyType.MANUAL_CPC);
      setCampaignOperand.setBiddingStrategy(setCampaignManualCpc);
      FrequencyCap setFrequencyCap = new FrequencyCap();
      setFrequencyCap.setLevel(FrequencyLevel.AD_GROUP);
      setFrequencyCap.setTimeUnit(FrequencyTimeUnit.DAY);
      setFrequencyCap.setImpression((long) 5);
      setCampaignOperand.setFrequencyCap(setFrequencyCap);
      setCampaignOperation.getOperand().add(setCampaignOperand);
    }


    return setCampaignOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignValues CampaignValues
   * @return CampaignOperation
   */
  public static CampaignOperation createSampleRemoveRequest(long accountId, List<CampaignValues> campaignValues) {
    // Set Operation
    CampaignOperation operation = new CampaignOperation();
    operation.setOperator(Operator.REMOVE);
    operation.setAccountId(accountId);

    // Set Operand
    for (CampaignValues campaignValue : campaignValues) {

      Campaign campaign = new Campaign();
      campaign.setAccountId(campaignValue.getCampaign().getAccountId());
      campaign.setCampaignId(campaignValue.getCampaign().getCampaignId());

      operation.getOperand().add(campaign);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignValues CampaignValues
   * @return CampaignSelector
   */
  public static CampaignSelector createSampleGetRequest(long accountId, List<CampaignValues> campaignValues) {
    // Set Selector
    CampaignSelector campaignSelector = new CampaignSelector();
    campaignSelector.setAccountId(accountId);
    campaignSelector.getUserStatus().addAll(Arrays.asList(UserStatus.ACTIVE, UserStatus.PAUSED));

    for (CampaignValues campaignValue : campaignValues) {
      campaignSelector.getCampaignIds().add((campaignValue.getCampaign().getCampaignId()));
    }

    Paging campaignPaging = new Paging();
    campaignPaging.setStartIndex(1);
    campaignPaging.setNumberResults(20);
    campaignSelector.setPaging(campaignPaging);

    return campaignSelector;
  }

  /**
   * display Campaign entity to stdout.
   * 
   * @param campaign Campaign entity for display.
   */
  private static void displayCampaign(Campaign campaign) {
    System.out.println("accountId = " + campaign.getAccountId());
    System.out.println("campaignId = " + campaign.getCampaignId());
    System.out.println("campaignName = " + campaign.getCampaignName());
    System.out.println("userStatus = " + campaign.getUserStatus().toString());
    System.out.println("startDate = " + campaign.getStartDate());
    System.out.println("endDate = " + campaign.getEndDate());
    if (campaign.getBudget() != null) {
      System.out.println("budget/amount = " + campaign.getBudget().getAmount());
      System.out.println("budget/deliveryMethod = " + campaign.getBudget().getDeliveryMethod().toString());
    }
    if (campaign.getBiddingStrategy() != null) {
      System.out.println("biddingStrategy = " + campaign.getBiddingStrategy().getType().toString());
    }
    System.out.println("adProductType = " + campaign.getAdProductType());
    if (campaign.getFrequencyCap() != null) {
      System.out.println("frequencyCap/level = " + campaign.getFrequencyCap().getLevel());
      System.out.println("frequencyCap/timeUnit = " + campaign.getFrequencyCap().getTimeUnit());
      System.out.println("frequencyCap/impression = " + campaign.getFrequencyCap().getImpression());
    }
    if (campaign.getConversionOptimizer() != null) {
      System.out.println("conversionOptimizer/targetCpa = " + campaign.getConversionOptimizer().getTargetCpa());
      System.out.println("conversionOptimizer/eligibilityFlg = " + campaign.getConversionOptimizer().getEligibilityFlg());
    }
    System.out.println("---------");
  }
}
