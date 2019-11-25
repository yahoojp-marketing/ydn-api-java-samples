/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.label;

import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201911.Error;
import jp.yahooapis.im.v201911.Paging;
import jp.yahooapis.im.v201911.label.Label;
import jp.yahooapis.im.v201911.label.LabelOperation;
import jp.yahooapis.im.v201911.label.LabelPage;
import jp.yahooapis.im.v201911.label.LabelReturnValue;
import jp.yahooapis.im.v201911.label.LabelSelector;
import jp.yahooapis.im.v201911.label.LabelService;
import jp.yahooapis.im.v201911.label.LabelServiceInterface;
import jp.yahooapis.im.v201911.label.LabelValues;
import jp.yahooapis.im.v201911.label.Operator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example LabelService operation and Utility method collection.
 */
public class LabelServiceSample {

  /**
   * example LabelService operation.
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
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);

      // =================================================================
      // LabelService ADD
      // =================================================================
      // create request.
      LabelOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<Label>() {{
        add(createExampleLabel());
      }});

      // run
      List<LabelValues> addResponse = mutate(addRequest);
      valuesHolder.setLabelValuesList(addResponse);

      // =================================================================
      // LabelService GET
      // =================================================================
      // create request.
      LabelSelector getRequest = buildExampleGetRequest(accountId, valuesRepositoryFacade.getLabelValuesRepository().getLabelIds());

      // run
      get(getRequest);

      // =================================================================
      // LabelService SET
      // =================================================================
      // create request.
      LabelOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId,
          createExampleSetRequest(valuesRepositoryFacade.getLabelValuesRepository().getLabels())
      );

      // run
      mutate(setRequest);

      // =================================================================
      // LabelService REMOVE
      // =================================================================
      // create request.
      LabelOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId,
          valuesRepositoryFacade.getLabelValuesRepository().getLabels()
      );

      // run
      mutate(removeRequest);
      valuesHolder.setLabelValuesList(new ArrayList<>());

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
   * example mutate Labels.
   *
   * @param operation LabelOperation
   * @return LabelValues
   */
  public static List<LabelValues> mutate(LabelOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("LabelService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<LabelReturnValue> labelReturnValueHolder = new Holder<LabelReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    LabelServiceInterface labelService = SoapUtils.createServiceInterface(LabelServiceInterface.class, LabelService.class);
    labelService.mutate(operation, labelReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, labelReturnValueHolder.value.getValues());

    // Response
    return labelReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for LabelService GET.
   *
   * @param selector LabelSelector
   * @return LabelValues
   */
  public static List<LabelValues> get(LabelSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("LabelService::get");
    System.out.println("############################################");

    Holder<LabelPage> labelPageHolder = new Holder<LabelPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    LabelServiceInterface labelService = SoapUtils.createServiceInterface(LabelServiceInterface.class, LabelService.class);
    labelService.get(selector, labelPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, labelPageHolder.value.getValues());

    // Response
    return labelPageHolder.value.getValues();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    if (valuesHolder.getLabelValuesList().size() > 0) {
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      mutate(
          buildExampleMutateRequest(Operator.REMOVE, SoapUtils.getAccountId(),
            valuesRepositoryFacade.getLabelValuesRepository().getLabels()
          )
      );
    }
  }

  /**
   * example mutate request.
   *
   * @param operator Operator
   * @param accountId long
   * @param operand List<Label>
   * @return LabelOperation
   */
  public static LabelOperation buildExampleMutateRequest(Operator operator, long accountId, List<Label> operand)
  {
    LabelOperation operation = new LabelOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }
  
  /**
   * example Label request.
   *
   * @return Label
   */
  public static Label createExampleLabel()
  {
    Label operand = new Label();
    operand.setLabelName("Sample_Label_" + SoapUtils.getCurrentTimestamp());
    operand.setDescription("sample label");
    operand.setColor("#000000");
    return operand;
  }

  /**
   * create sample request.
   *
   * @param accountId
   * @param labelIds
   * @return LabelSelector
   */
  public static LabelSelector buildExampleGetRequest(long accountId, List<Long> labelIds)
  {
    LabelSelector selector = new LabelSelector();
    selector.setAccountId(accountId);

    if (labelIds.size() > 0) {
      selector.getLabelIds().addAll(labelIds);
    }

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
  
  /**
   * example Labels set request.
   *
   * @param Labels List<Label>
   * @return List<Label>
   */
  public static List<Label> createExampleSetRequest(List<Label> Labels)
  {
    // create operands
    List<Label> operands = new ArrayList<>();

    for (Label label: Labels) {
      Label operand = new Label();
      operand.setLabelId(label.getLabelId());
      operand.setLabelName("Sample_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      operand.setDescription("sample label update");
      operand.setColor("#0000FF");
      operands.add(operand);
    }

    return operands;
  }
  
  /**
   * create basic Label.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  public static ValuesHolder create() throws Exception
  {
    ValuesHolder valuesHolder = new ValuesHolder();
    LabelOperation addRequest = buildExampleMutateRequest(Operator.ADD, SoapUtils.getAccountId(), new ArrayList<Label>() {{
      add(createExampleLabel());
    }});
    List<LabelValues> addResponse = mutate(addRequest);
    valuesHolder.setLabelValuesList(addResponse);
    return valuesHolder;
  }
}
