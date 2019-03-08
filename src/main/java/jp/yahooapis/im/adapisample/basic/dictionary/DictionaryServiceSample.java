/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.dictionary;

import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.v201903.Error;
import jp.yahooapis.im.v201903.dictionary.CategoryPage;
import jp.yahooapis.im.v201903.dictionary.CategorySelector;
import jp.yahooapis.im.v201903.dictionary.CategoryValues;
import jp.yahooapis.im.v201903.dictionary.ColorSetPage;
import jp.yahooapis.im.v201903.dictionary.ColorSetSelector;
import jp.yahooapis.im.v201903.dictionary.ColorSetValues;
import jp.yahooapis.im.v201903.dictionary.DeviceOsType;
import jp.yahooapis.im.v201903.dictionary.DictionaryLang;
import jp.yahooapis.im.v201903.dictionary.DictionaryService;
import jp.yahooapis.im.v201903.dictionary.DictionaryServiceInterface;
import jp.yahooapis.im.v201903.dictionary.DisapprovalReasonPage;
import jp.yahooapis.im.v201903.dictionary.DisapprovalReasonSelector;
import jp.yahooapis.im.v201903.dictionary.DisapprovalReasonValues;
import jp.yahooapis.im.v201903.dictionary.GeographicLocationPage;
import jp.yahooapis.im.v201903.dictionary.GeographicLocationSelector;
import jp.yahooapis.im.v201903.dictionary.GeographicLocationValues;
import jp.yahooapis.im.v201903.dictionary.MediaAdFormatPage;
import jp.yahooapis.im.v201903.dictionary.MediaAdFormatValues;
import jp.yahooapis.im.v201903.dictionary.OsVersionPage;
import jp.yahooapis.im.v201903.dictionary.OsVersionSelector;
import jp.yahooapis.im.v201903.dictionary.OsVersionValues;

import java.util.List;

import javax.xml.ws.Holder;

/**
 * example DictionaryService operation and Utility method collection.
 */
public class DictionaryServiceSample {

  /**
   * example DictionaryService operation.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // DictionaryService getDisapprovalReason
      // =================================================================
      // create request.
      DisapprovalReasonSelector getDisapprovalReasonRequest = buildExampleGetDisapprovalReasonRequest();

      // run
      getDisapprovalReason(getDisapprovalReasonRequest);

      // =================================================================
      // DictionaryService getGeographicLocation
      // =================================================================
      // create request.
      GeographicLocationSelector getGeographicLocationRequest = buildExampleGetGeographicLocationRequest();

      // run
      getGeographicLocation(getGeographicLocationRequest);

      // =================================================================
      // DictionaryService getInterestCategory
      // =================================================================
      // create request.
      CategorySelector getInterestCategoryRequest = buildExampleGetInterestCategoryRequest();

      // run
      getInterestCategory(getInterestCategoryRequest);

      // =================================================================
      // DictionaryService getSiteCategory
      // =================================================================
      // create request.
      CategorySelector getSiteCategoryRequest = buildExampleGetSiteCategoryRequest();

      // run
      getSiteCategory(getSiteCategoryRequest);

      // =================================================================
      // DictionaryService getColorSet
      // =================================================================
      // create request.
      ColorSetSelector getColorSetRequest = buildExampleGetColorSetRequest();

      // run
      getColorSet(getColorSetRequest);

      // =================================================================
      // DictionaryService getOsVersion
      // =================================================================
      // create request.
      OsVersionSelector getOsVersionRequest = buildExampleGetOsVersionRequest();

      // run
      getOsVersion(getOsVersionRequest);

      // =================================================================
      // DictionaryService getMediaAdFormat
      // =================================================================
      // run
      getMediaAdFormat();

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example getDisapprovalReason request.
   *
   * @return DisapprovalReasonSelector
   */
  public static DisapprovalReasonSelector buildExampleGetDisapprovalReasonRequest()  {
    DisapprovalReasonSelector selector = new DisapprovalReasonSelector();
    selector.setLang(DictionaryLang.EN);
    return selector;
  }

  /**
   * example getGeographicLocation request.
   *
   * @return GeographicLocationSelector
   */
  public static GeographicLocationSelector buildExampleGetGeographicLocationRequest()  {
    GeographicLocationSelector selector = new GeographicLocationSelector();
    selector.setLang(DictionaryLang.EN);
    return selector;
  }

  /**
   * example getInterestCategory request.
   *
   * @return CategorySelector
   */
  public static CategorySelector buildExampleGetInterestCategoryRequest()  {
    CategorySelector selector = new CategorySelector();
    selector.setLang(DictionaryLang.EN);
    return selector;
  }

  /**
   * example getSiteCategory request.
   *
   * @return CategorySelector
   */
  public static CategorySelector buildExampleGetSiteCategoryRequest()  {
    CategorySelector selector = new CategorySelector();
    selector.setLang(DictionaryLang.EN);
    return selector;
  }

  /**
   * example ColorSetSelector request.
   *
   * @return getColorSet
   */
  public static ColorSetSelector buildExampleGetColorSetRequest()  {
    ColorSetSelector selector=new ColorSetSelector();
    selector.setLang(DictionaryLang.EN);
    return selector;
  }

  /**
   * example getOsVersion request.
   *
   * @return OsVersionSelector
   */
  public static OsVersionSelector buildExampleGetOsVersionRequest()  {
    OsVersionSelector selector=new OsVersionSelector();
    selector.setOsType(DeviceOsType.ANDROID);
    return selector;
  }

  /**
   * example get DisapprovalReason.
   *
   * @param selector DisapprovalReasonSelector
   * @return DisapprovalReasonValues
   */
  public static List<DisapprovalReasonValues> getDisapprovalReason(DisapprovalReasonSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getDisapprovalReason");
    System.out.println("############################################");

    Holder<DisapprovalReasonPage> disapprovalReasonPageHolder = new Holder<DisapprovalReasonPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);
    dictionaryService.getDisapprovalReason(selector, disapprovalReasonPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, disapprovalReasonPageHolder.value.getValues());

    // Response
    return disapprovalReasonPageHolder.value.getValues();
  }

  /**
   * example get GeographicLocation.
   *
   * @param selector GeographicLocationSelector
   * @return GeographicLocationValues
   */
  public static List<GeographicLocationValues> getGeographicLocation(GeographicLocationSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getGeographicLocation");
    System.out.println("############################################");

    Holder<GeographicLocationPage> geographicLocationPageHolder = new Holder<GeographicLocationPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);
    dictionaryService.getGeographicLocation(selector, geographicLocationPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, geographicLocationPageHolder.value.getValues());

    // Response
    return geographicLocationPageHolder.value.getValues();
  }

  /**
   * example get InterestCategory.
   *
   * @param selector CategorySelector
   * @return CategoryValues
   */
  public static List<CategoryValues> getInterestCategory(CategorySelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getInterestCategory");
    System.out.println("############################################");

    Holder<CategoryPage> categoryPageHolder = new Holder<CategoryPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);
    dictionaryService.getInterestCategory(selector, categoryPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, categoryPageHolder.value.getValues());

    // Response
    return categoryPageHolder.value.getValues();
  }

  /**
   * example get SiteCategory.
   *
   * @param selector CategorySelector
   * @return CategoryValues
   */
  public static List<CategoryValues> getSiteCategory(CategorySelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getSiteCategory");
    System.out.println("############################################");

    Holder<CategoryPage> categoryPageHolder = new Holder<CategoryPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);
    dictionaryService.getSiteCategory(selector, categoryPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, categoryPageHolder.value.getValues());

    // Response
    return categoryPageHolder.value.getValues();
  }

  /**
   * example get ColorSet.
   *
   * @param selector ColorSetSelector
   * @return ColorSetValues
   */
  public static List<ColorSetValues> getColorSet(ColorSetSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getColorSet");
    System.out.println("############################################");

    Holder<ColorSetPage> colorSetPageHolder = new Holder<ColorSetPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);
    dictionaryService.getColorSet(selector, colorSetPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, colorSetPageHolder.value.getValues());

    // Response
    return colorSetPageHolder.value.getValues();
  }

  /**
   * example get OsVersion.
   *
   * @return OsVersionValues
   */
  public static List<OsVersionValues> getOsVersion(OsVersionSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getOsVersion");
    System.out.println("############################################");

    Holder<OsVersionPage> osVersionPageHolder = new Holder<OsVersionPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);
    dictionaryService.getOsVersion(selector, osVersionPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, osVersionPageHolder.value.getValues());

    // Response
    return osVersionPageHolder.value.getValues();
  }

  /**
   * example get MediaAdFormat.
   *
   * @return MediaAdFormatValues
   */
  public static List<MediaAdFormatValues> getMediaAdFormat() throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getMediaAdFormat");
    System.out.println("############################################");

    Holder<MediaAdFormatPage> mediaAdFormatPageHolder = new Holder<MediaAdFormatPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);
    dictionaryService.getMediaAdFormat(mediaAdFormatPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, mediaAdFormatPageHolder.value.getValues());

    // Response
    return mediaAdFormatPageHolder.value.getValues();
  }
}
