/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.campaignlabel;

import jp.yahooapis.im.adapisample.basic.campaign.CampaignServiceSample;
import jp.yahooapis.im.adapisample.basic.label.LabelServiceSample;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201907.Error;
import jp.yahooapis.im.v201907.campaign.CampaignType;
import jp.yahooapis.im.v201907.campaignlabel.CampaignLabel;
import jp.yahooapis.im.v201907.campaignlabel.CampaignLabelOperation;
import jp.yahooapis.im.v201907.campaignlabel.CampaignLabelReturnValue;
import jp.yahooapis.im.v201907.campaignlabel.CampaignLabelService;
import jp.yahooapis.im.v201907.campaignlabel.CampaignLabelServiceInterface;
import jp.yahooapis.im.v201907.campaignlabel.CampaignLabelValues;
import jp.yahooapis.im.v201907.campaignlabel.Operator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example CampaignLabelService operation and Utility method collection.
 */
public class CampaignLabelServiceSample {

  /**
   * example CampaignLabelService operation.
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
      Long labelId = valuesRepositoryFacade.getLabelValuesRepository().getLabelIds().get(0);

      // =================================================================
      // CampaignCampaignLabelService ADD
      // =================================================================
      // create request.
      CampaignLabelOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<CampaignLabel>() {{
        add(createExampleCampaignLabel(campaignId, labelId));
      }} );

      // run
      mutate(addRequest);

      // =================================================================
      // CampaignCampaignLabelService REMOVE
      // =================================================================
      // create request.
      CampaignLabelOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, new ArrayList<CampaignLabel>() {{
        add(createExampleCampaignLabel(campaignId, labelId));
      }} );

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
   * example mutate CampaignLabels.
   *
   * @param operation CampaignLabelOperation
   * @return CampaignLabelValues
   */
  public static List<CampaignLabelValues> mutate(CampaignLabelOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignLabelService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<CampaignLabelReturnValue> campaignLabelReturnValueHolder = new Holder<CampaignLabelReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignLabelServiceInterface CampaignLabelService = SoapUtils.createServiceInterface(CampaignLabelServiceInterface.class, CampaignLabelService.class);
    CampaignLabelService.mutate(operation, campaignLabelReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, campaignLabelReturnValueHolder.value.getValues());

    // Response
    return campaignLabelReturnValueHolder.value.getValues();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    LabelServiceSample.cleanup(valuesHolder);
    CampaignServiceSample.cleanup(valuesHolder);
  }

  /**
   * example mutate request.
   *
   * @param operator Operator
   * @param accountId long
   * @param operand List<CampaignLabel>
   * @return CampaignLabelOperation
   */
  public static CampaignLabelOperation buildExampleMutateRequest(Operator operator, long accountId, List<CampaignLabel> operand)
  {
    CampaignLabelOperation operation = new CampaignLabelOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }
  
  /**
   * example CampaignLabel request.
   *
   * @param campaignId
   * @param labelId
   * @return
   */
  public static CampaignLabel createExampleCampaignLabel(Long campaignId, Long labelId)
  {
    CampaignLabel operand = new CampaignLabel();
    operand.setCampaignId(campaignId);
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

    ValuesHolder campaignValuesHolder = CampaignServiceSample.create();
    ValuesHolder labelValuesHolder = LabelServiceSample.create();

    ValuesHolder selfValuesHolder = new ValuesHolder();
    selfValuesHolder.setCampaignValuesList(campaignValuesHolder.getCampaignValuesList());
    selfValuesHolder.setLabelValuesList(labelValuesHolder.getLabelValuesList());

    return selfValuesHolder;
  }
}
