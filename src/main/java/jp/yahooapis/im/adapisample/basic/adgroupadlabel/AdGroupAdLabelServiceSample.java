/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.adgroupadlabel;

import jp.yahooapis.im.adapisample.basic.adgroupad.AdGroupAdServiceSample;
import jp.yahooapis.im.adapisample.basic.label.LabelServiceSample;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201903.Error;
import jp.yahooapis.im.v201903.adgroupad.AdType;
import jp.yahooapis.im.v201903.adgroupadlabel.AdGroupAdLabel;
import jp.yahooapis.im.v201903.adgroupadlabel.AdGroupAdLabelOperation;
import jp.yahooapis.im.v201903.adgroupadlabel.AdGroupAdLabelReturnValue;
import jp.yahooapis.im.v201903.adgroupadlabel.AdGroupAdLabelService;
import jp.yahooapis.im.v201903.adgroupadlabel.AdGroupAdLabelServiceInterface;
import jp.yahooapis.im.v201903.adgroupadlabel.AdGroupAdLabelValues;
import jp.yahooapis.im.v201903.adgroupadlabel.Operator;
import jp.yahooapis.im.v201903.campaign.CampaignType;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example AdGroupAdLabelService operation and Utility method collection.
 */
public class AdGroupAdLabelServiceSample {

  /**
   * example AdGroupAdLabelService operation.
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
      Long campaignId = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);
      Long adGroupId = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignId);
      Long adId = valuesRepositoryFacade.getAdGroupAdValuesRepository().findAdId(campaignId, adGroupId, AdType.TEXT_LONG_AD_1);
      Long labelId = valuesRepositoryFacade.getLabelValuesRepository().getLabelIds().get(0);

      // =================================================================
      // AdGroupAdLabelService ADD
      // =================================================================
      // create request.
      AdGroupAdLabelOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<AdGroupAdLabel>() {{
        add(createExampleAdGroupAdLabel(campaignId, adGroupId, adId, labelId));
      }});

      // run
      mutate(addRequest);

      // =================================================================
      // AdGroupAdLabelService REMOVE
      // =================================================================
      // create request.
      AdGroupAdLabelOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, new ArrayList<AdGroupAdLabel>() {{
          add(createExampleAdGroupAdLabel(campaignId, adGroupId, adId, labelId));
      }});

      // run
      mutate(removeRequest);

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
   * example mutate AdGroupAdLabels.
   *
   * @param operation AdGroupAdLabelOperation
   * @return AdGroupAdLabelValues
   */
  public static List<AdGroupAdLabelValues> mutate(AdGroupAdLabelOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupAdLabelService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<AdGroupAdLabelReturnValue> adGroupAdLabelReturnValueHolder = new Holder<AdGroupAdLabelReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupAdLabelServiceInterface adGroupAdLabelService = SoapUtils.createServiceInterface(AdGroupAdLabelServiceInterface.class, AdGroupAdLabelService.class);
    adGroupAdLabelService.mutate(operation, adGroupAdLabelReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, adGroupAdLabelReturnValueHolder.value.getValues());

    // Response
    return adGroupAdLabelReturnValueHolder.value.getValues();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    LabelServiceSample.cleanup(valuesHolder);
    AdGroupAdServiceSample.cleanup(valuesHolder);
  }

  /**
   * example mutate request.
   *
   * @param operator Operator
   * @param accountId long
   * @param operand List<AdGroupAdLabel>
   * @return AdGroupAdLabelOperation
   */
  public static AdGroupAdLabelOperation buildExampleMutateRequest(Operator operator, long accountId, List<AdGroupAdLabel> operand)
  {
    AdGroupAdLabelOperation operation = new AdGroupAdLabelOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }
  
  /**
   * example AdGroupAdLabel request.
   *
   * @param campaignId
   * @param adGroupId
   * @param adId
   * @param labelId
   * @return
   */
  public static AdGroupAdLabel createExampleAdGroupAdLabel(Long campaignId, Long adGroupId, Long adId, Long labelId)
  {
    AdGroupAdLabel operand = new AdGroupAdLabel();
    operand.setCampaignId(campaignId);
    operand.setAdGroupId(adGroupId);
    operand.setAdId(adId);
    operand.setLabelId(labelId);
    return operand;
  }
  
  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  private static ValuesHolder setup() throws Exception {

    ValuesHolder adGroupAdValuesHolder = AdGroupAdServiceSample.create();
    ValuesHolder labelValuesHolder = LabelServiceSample.create();

    ValuesHolder selfValuesHolder = new ValuesHolder();
    selfValuesHolder.setCampaignValuesList(adGroupAdValuesHolder.getCampaignValuesList());
    selfValuesHolder.setAdGroupValuesList(adGroupAdValuesHolder.getAdGroupValuesList());
    selfValuesHolder.setAdGroupAdValuesList(adGroupAdValuesHolder.getAdGroupAdValuesList());
    selfValuesHolder.setLabelValuesList(labelValuesHolder.getLabelValuesList());

    return selfValuesHolder;
  }
}
