/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.retargetingtag;

import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201911.Error;
import jp.yahooapis.im.v201911.retargetingtag.Operator;
import jp.yahooapis.im.v201911.retargetingtag.RetargetingTagOperation;
import jp.yahooapis.im.v201911.retargetingtag.RetargetingTagPage;
import jp.yahooapis.im.v201911.retargetingtag.RetargetingTagReturnValue;
import jp.yahooapis.im.v201911.retargetingtag.RetargetingTagSelector;
import jp.yahooapis.im.v201911.retargetingtag.RetargetingTagService;
import jp.yahooapis.im.v201911.retargetingtag.RetargetingTagServiceInterface;
import jp.yahooapis.im.v201911.retargetingtag.RetargetingTagValues;

import java.util.List;

import javax.xml.ws.Holder;

/**
 * example RetargetingTagService operation and Utility method collection.
 */
public class RetargetingTagServiceSample {

  /**
   * example RetargetingTagService operation.
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
      // RetargetingTagService ADD
      // =================================================================
      // create request.
      RetargetingTagOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId);

      // run
      mutate(addRequest);

      // =================================================================
      // RetargetingTagService::get
      // =================================================================
      // create request.
      RetargetingTagSelector getRequest = buildExampleGetRequest(accountId);

      // run
      get(getRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example get Retargeting Tags.
   *
   * @param selector RetargetingTagSelector
   * @return RetargetingTagValues
   */
  public static List<RetargetingTagValues> get(RetargetingTagSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("RetargetingTagService::get");
    System.out.println("############################################");

    Holder<RetargetingTagPage> retargetingTagPageHolder = new Holder<RetargetingTagPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    RetargetingTagServiceInterface retargetingTagService = SoapUtils.createServiceInterface(RetargetingTagServiceInterface.class, RetargetingTagService.class);
    retargetingTagService.get(selector, retargetingTagPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, retargetingTagPageHolder.value.getValues());

    // Response
    return retargetingTagPageHolder.value.getValues();
  }

  /**
   * example mutate Retargeting Tags.
   *
   * @param operation RetargetingTagOperation
   * @return RetargetingTagValues
   */
  public static List<RetargetingTagValues> mutate(RetargetingTagOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("RetargetingTagService::mutate(" + operation.getOperator().toString() + ")");
    System.out.println("############################################");

    Holder<RetargetingTagReturnValue> retargetingTagReturnValueHolder = new Holder<RetargetingTagReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    RetargetingTagServiceInterface retargetingTagService = SoapUtils.createServiceInterface(RetargetingTagServiceInterface.class, RetargetingTagService.class);
    retargetingTagService.mutate(operation, retargetingTagReturnValueHolder, errorHolder);

    if (retargetingTagReturnValueHolder.value.getValues().size() != 0 && errorHolder.value.size() == 0) {
      for (RetargetingTagValues retargetingTagValues : retargetingTagReturnValueHolder.value.getValues()) {
        if(retargetingTagValues.getError().size() != 0) {
          for (Error error: retargetingTagValues.getError()) {
            if (!error.getCode().equals("D0001")) {
              SoapUtils.checkSoapError(errorHolder, retargetingTagReturnValueHolder.value.getValues());
            }
          }
        }
      }
    } else {
      SoapUtils.checkSoapError(errorHolder, retargetingTagReturnValueHolder.value.getValues());
    }

    // Response
    return retargetingTagReturnValueHolder.value.getValues();
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @return RetargetingTagSelector
   */
  public static RetargetingTagSelector buildExampleGetRequest(long accountId) {
    RetargetingTagSelector selector = new RetargetingTagSelector();
    selector.setAccountId(accountId);
    return selector;
  }

  /**
   * example mutate request.
   *
   * @param operator  Operator
   * @param accountId long
   * @return RetargetingTagOperation
   */
  public static RetargetingTagOperation buildExampleMutateRequest(Operator operator, long accountId) {
    RetargetingTagOperation operation = new RetargetingTagOperation();
    operation.setAccountId(accountId);
    operation.setOperator(operator);
    return operation;
  }

  /**
   * create basic retargeting tag.
   *
   * @return ValuesHolder
   */
  public static ValuesHolder create() throws Exception {
    long accountId = SoapUtils.getAccountId();
    ValuesHolder valuesHolder = new ValuesHolder();

    mutate(buildExampleMutateRequest(Operator.ADD, accountId));

    RetargetingTagSelector request = buildExampleGetRequest(accountId);
    List<RetargetingTagValues> response = get(request);

    valuesHolder.setRetargetingTagValuesList(response);
    return valuesHolder;
  }
}
