/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.adgrouplabel;

import jp.yahooapis.im.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.im.adapisample.basic.label.LabelServiceSample;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201903.Error;
import jp.yahooapis.im.v201903.adgrouplabel.AdGroupLabel;
import jp.yahooapis.im.v201903.adgrouplabel.AdGroupLabelOperation;
import jp.yahooapis.im.v201903.campaign.CampaignType;
import jp.yahooapis.im.v201903.adgrouplabel.AdGroupLabelReturnValue;
import jp.yahooapis.im.v201903.adgrouplabel.AdGroupLabelService;
import jp.yahooapis.im.v201903.adgrouplabel.AdGroupLabelServiceInterface;
import jp.yahooapis.im.v201903.adgrouplabel.AdGroupLabelValues;
import jp.yahooapis.im.v201903.adgrouplabel.Operator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example AdGroupLabelService operation and Utility method collection.
 */
public class AdGroupLabelServiceSample {

  /**
   * example AdGroupLabelService operation.
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
      Long labelId = valuesRepositoryFacade.getLabelValuesRepository().getLabelIds().get(0);

      // =================================================================
      // AdGroupLabelService ADD
      // =================================================================
      // create request.
      AdGroupLabelOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<AdGroupLabel>() {{
        add(createExampleAdGroupLabel(campaignId, adGroupId, labelId));
      }});

      // run
      mutate(addRequest);

      // =================================================================
      // AdGroupLabelService REMOVE
      // =================================================================
      // create request.
      AdGroupLabelOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, new ArrayList<AdGroupLabel>() {{
          add(createExampleAdGroupLabel(campaignId, adGroupId, labelId));
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
   * example mutate AdGroupLabels.
   *
   * @param operation AdGroupLabelOperation
   * @return AdGroupLabelValues
   */
  public static List<AdGroupLabelValues> mutate(AdGroupLabelOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupLabelService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<AdGroupLabelReturnValue> adGroupLabelReturnValueHolder = new Holder<AdGroupLabelReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupLabelServiceInterface adGroupLabelService = SoapUtils.createServiceInterface(AdGroupLabelServiceInterface.class, AdGroupLabelService.class);
    adGroupLabelService.mutate(operation, adGroupLabelReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, adGroupLabelReturnValueHolder.value.getValues());

    // Response
    return adGroupLabelReturnValueHolder.value.getValues();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    LabelServiceSample.cleanup(valuesHolder);
    AdGroupServiceSample.cleanup(valuesHolder);
  }

  /**
   * example mutate request.
   *
   * @param operator Operator
   * @param accountId long
   * @param operand List<AdGroupLabel>
   * @return AdGroupLabelOperation
   */
  public static AdGroupLabelOperation buildExampleMutateRequest(Operator operator, long accountId, List<AdGroupLabel> operand)
  {
    AdGroupLabelOperation operation = new AdGroupLabelOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }
  
  /**
   * example AdGroupLabel request.
   *
   * @param campaignId
   * @param adGroupId
   * @param labelId
   * @return
   */
  public static AdGroupLabel createExampleAdGroupLabel(Long campaignId, Long adGroupId, Long labelId)
  {
    AdGroupLabel operand = new AdGroupLabel();
    operand.setCampaignId(campaignId);
    operand.setAdGroupId(adGroupId);
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

    ValuesHolder adGroupValuesHolder = AdGroupServiceSample.create();
    ValuesHolder labelValuesHolder = LabelServiceSample.create();

    ValuesHolder selfValuesHolder = new ValuesHolder();
    selfValuesHolder.setCampaignValuesList(adGroupValuesHolder.getCampaignValuesList());
    selfValuesHolder.setAdGroupValuesList(adGroupValuesHolder.getAdGroupValuesList());
    selfValuesHolder.setLabelValuesList(labelValuesHolder.getLabelValuesList());

    return selfValuesHolder;
  }
}
