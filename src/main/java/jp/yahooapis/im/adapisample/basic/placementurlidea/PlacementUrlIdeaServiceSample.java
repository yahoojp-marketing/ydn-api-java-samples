/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.placementurlidea;

import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201907.Error;
import jp.yahooapis.im.v201907.Paging;
import jp.yahooapis.im.v201907.placementurlidea.AdFormatConditions;
import jp.yahooapis.im.v201907.placementurlidea.PlacementUrlIdeaPage;
import jp.yahooapis.im.v201907.placementurlidea.PlacementUrlIdeaSelector;
import jp.yahooapis.im.v201907.placementurlidea.PlacementUrlIdeaService;
import jp.yahooapis.im.v201907.placementurlidea.PlacementUrlIdeaServiceInterface;
import jp.yahooapis.im.v201907.placementurlidea.PlacementUrlIdeaValues;

import java.util.List;

import javax.xml.ws.Holder;

/**
 * example PlacementUrlIdeaService operation and Utility method collection.
 */
public class PlacementUrlIdeaServiceSample {

  /**
   * example PlacementUrlIdeaService operation.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {

    try {
      // =================================================================
      // PlacementUrlIdeaService GET
      // =================================================================
      // create request.
      PlacementUrlIdeaSelector getRequest = buildExampleGetRequest();

      // run
      get(getRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for PlacementUrlIdeaService GET.
   *
   * @param selector PlacementUrlIdeaSelector
   * @return PlacementUrlIdeaValues
   */
  public static List<PlacementUrlIdeaValues> get(PlacementUrlIdeaSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("PlacementUrlIdeaService::get");
    System.out.println("############################################");

    Holder<PlacementUrlIdeaPage> placementUrlIdeaPageHolder = new Holder<PlacementUrlIdeaPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    PlacementUrlIdeaServiceInterface placementUrlIdeaService = SoapUtils.createServiceInterface(PlacementUrlIdeaServiceInterface.class, PlacementUrlIdeaService.class);
    placementUrlIdeaService.get(selector, placementUrlIdeaPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, placementUrlIdeaPageHolder.value.getValues());

    // Response
    return placementUrlIdeaPageHolder.value.getValues();
  }

  /**
   * example get request.
   *
   * @return PlacementUrlIdeaSelector
   */
  public static PlacementUrlIdeaSelector buildExampleGetRequest()
  {
    PlacementUrlIdeaSelector selector = new PlacementUrlIdeaSelector();
    selector.setKeyword("jugem");
    selector.getSiteCategories().add("TC-SC-20110120100100");

    AdFormatConditions adFormat = new AdFormatConditions();
    adFormat.setAdStyle("IMAGE");
    adFormat.setMediaAdFormat("SQUARE_300");
    selector.getAdFormats().add(adFormat);

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
  
  /**
   * create PlacementUrlIdeaValuesList.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  public static ValuesHolder create() throws Exception {

    PlacementUrlIdeaSelector request = buildExampleGetRequest();
    List<PlacementUrlIdeaValues> response = get(request);

    ValuesHolder selfValuesHolder = new ValuesHolder();
    selfValuesHolder.setPlacementUrlIdeaValuesList(response);
    return selfValuesHolder;
  }
}
