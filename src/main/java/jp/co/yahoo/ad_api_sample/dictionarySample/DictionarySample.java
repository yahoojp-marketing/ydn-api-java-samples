package jp.co.yahoo.ad_api_sample.dictionarySample;

import jp.co.yahoo.ad_api_sample.error.impl.ErrorEntityFactoryImpl;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201806.Error;
import jp.yahooapis.im.v201806.dictionary.Category;
import jp.yahooapis.im.v201806.dictionary.CategoryChildValues;
import jp.yahooapis.im.v201806.dictionary.CategoryPage;
import jp.yahooapis.im.v201806.dictionary.CategorySelector;
import jp.yahooapis.im.v201806.dictionary.CategoryValues;
import jp.yahooapis.im.v201806.dictionary.ColorSet;
import jp.yahooapis.im.v201806.dictionary.ColorSetPage;
import jp.yahooapis.im.v201806.dictionary.ColorSetSelector;
import jp.yahooapis.im.v201806.dictionary.ColorSetValues;
import jp.yahooapis.im.v201806.dictionary.DeviceOsType;
import jp.yahooapis.im.v201806.dictionary.DictionaryLang;
import jp.yahooapis.im.v201806.dictionary.DictionaryService;
import jp.yahooapis.im.v201806.dictionary.DictionaryServiceInterface;
import jp.yahooapis.im.v201806.dictionary.DisapprovalReason;
import jp.yahooapis.im.v201806.dictionary.DisapprovalReasonPage;
import jp.yahooapis.im.v201806.dictionary.DisapprovalReasonSelector;
import jp.yahooapis.im.v201806.dictionary.DisapprovalReasonValues;
import jp.yahooapis.im.v201806.dictionary.GeographicLocation;
import jp.yahooapis.im.v201806.dictionary.GeographicLocationPage;
import jp.yahooapis.im.v201806.dictionary.GeographicLocationSelector;
import jp.yahooapis.im.v201806.dictionary.GeographicLocationValues;
import jp.yahooapis.im.v201806.dictionary.MediaAdFormat;
import jp.yahooapis.im.v201806.dictionary.MediaAdFormatPage;
import jp.yahooapis.im.v201806.dictionary.MediaAdFormatValues;
import jp.yahooapis.im.v201806.dictionary.OsVersion;
import jp.yahooapis.im.v201806.dictionary.OsVersionPage;
import jp.yahooapis.im.v201806.dictionary.OsVersionSelector;
import jp.yahooapis.im.v201806.dictionary.OsVersionValues;

import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for DictionaryService.<br>
 * Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class DictionarySample {

  /**
   * main method for AccountSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {

    try {

      // -----------------------------------------------
      // DictionaryService::getDisapprovalReason
      // -----------------------------------------------
      // request
      DisapprovalReasonSelector disapprovalReasonSelector = new DisapprovalReasonSelector();
      disapprovalReasonSelector.setLang(DictionaryLang.JA);

      // call API
      getDisapprovalReason(disapprovalReasonSelector);

      // -----------------------------------------------
      // DictionaryService::getGeographicLocation
      // -----------------------------------------------
      // request
      GeographicLocationSelector geographicLocationSelector = new GeographicLocationSelector();
      geographicLocationSelector.setLang(DictionaryLang.JA);

      // call API
      getGeographicLocation(geographicLocationSelector);

      // -----------------------------------------------
      // DictionaryService::getInterestCategory
      // -----------------------------------------------
      // request
      CategorySelector categorySelector = new CategorySelector();
      categorySelector.setLang(DictionaryLang.JA);

      // call API
      getInterestCategory(categorySelector);

      // -----------------------------------------------
      // DictionaryService::getSiteCategory
      // -----------------------------------------------
      // request
      categorySelector.setLang(DictionaryLang.JA);

      // call API
      getSiteCategory(categorySelector);

      // -----------------------------------------------
      // DictionaryService::getColorSet
      // -----------------------------------------------
      // request
      ColorSetSelector colorSetSelector = new ColorSetSelector();
      colorSetSelector.setLang(DictionaryLang.JA);

      // call API
      getColorSet(colorSetSelector);

      // -----------------------------------------------
      // DictionaryService::getInterestCategory
      // -----------------------------------------------
      // request
      OsVersionSelector osVersionSelector = new OsVersionSelector();
      osVersionSelector.setOsType(DeviceOsType.ANDROID);

      // call API
      getOsVersion(osVersionSelector);

      // -----------------------------------------------
      // DictionaryService::getMediaAdFormat
      // -----------------------------------------------
      // call API
      getMediaAdFormat();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Sample Program for DictionaryService GetColorSet.
   *
   * @param selector ColorSetSelector
   * @return ColorSetValues
   */
  public static List<ColorSetValues> getColorSet(ColorSetSelector selector) throws Exception {

    // =================================================================
    // DictionaryService
    // =================================================================
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getColorSet");
    System.out.println("############################################");

    Holder<ColorSetPage> colorSetPageHolder = new Holder<ColorSetPage>();
    Holder<List<Error>> dictionaryErrorHolder = new Holder<List<Error>>();
    dictionaryService.getColorSet(selector, colorSetPageHolder, dictionaryErrorHolder);

    // if error
    if (dictionaryErrorHolder.value != null && dictionaryErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(dictionaryErrorHolder.value), true);
    }

    // response
    if (colorSetPageHolder.value != null) {
      ColorSetPage colorSetPage = colorSetPageHolder.value;
      if (colorSetPage.getValues() != null && colorSetPage.getValues().size() > 0) {
        for (int i = 0; i < colorSetPage.getValues().size(); i++) {
          List<ColorSetValues> values = colorSetPage.getValues();
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayColorSet(values.get(i));
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }

    // Response
    return colorSetPageHolder.value.getValues();
  }

  /**
   * Sample Program for DictionaryService GetSiteCategory.
   *
   * @param selector CategorySelector
   * @return CategoryValues
   */
  public static List<CategoryValues> getSiteCategory(CategorySelector selector) throws Exception {

    // =================================================================
    // DictionaryService
    // =================================================================
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getSiteCategory");
    System.out.println("############################################");

    Holder<CategoryPage> categoryPageHolder = new Holder<CategoryPage>();
    Holder<List<Error>> dictionaryErrorHolder = new Holder<List<Error>>();
    dictionaryService.getSiteCategory(selector, categoryPageHolder, dictionaryErrorHolder);

    // if error
    if (dictionaryErrorHolder.value != null && dictionaryErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(dictionaryErrorHolder.value), true);
    }

    // response
    if (categoryPageHolder.value != null) {
      CategoryPage categoryPage = categoryPageHolder.value;
      if (categoryPage.getValues() != null && categoryPage.getValues().size() > 0) {
        for (int i = 0; i < categoryPage.getValues().size(); i++) {
          List<CategoryValues> values = categoryPage.getValues();
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayCategory(values.get(i).getCategory());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }

    // Response
    return categoryPageHolder.value.getValues();
  }

  /**
   * Sample Program for DictionaryService GetInterestCategory.
   *
   * @param selector CategorySelector
   * @return CategoryValues
   */
  public static List<CategoryValues> getInterestCategory(CategorySelector selector) throws Exception {

    // =================================================================
    // DictionaryService
    // =================================================================
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getInterestCategory");
    System.out.println("############################################");

    Holder<CategoryPage> categoryPageHolder = new Holder<CategoryPage>();
    Holder<List<Error>> dictionaryErrorHolder = new Holder<List<Error>>();
    dictionaryService.getInterestCategory(selector, categoryPageHolder, dictionaryErrorHolder);

    // if error
    if (dictionaryErrorHolder.value != null && dictionaryErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(dictionaryErrorHolder.value), true);
    }

    // response
    if (categoryPageHolder.value != null) {
      CategoryPage categoryPage = categoryPageHolder.value;
      if (categoryPage.getValues() != null && categoryPage.getValues().size() > 0) {
        for (int i = 0; i < categoryPage.getValues().size(); i++) {
          List<CategoryValues> values = categoryPage.getValues();
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayCategory(values.get(i).getCategory());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }

    // Response
    return categoryPageHolder.value.getValues();
  }

  /**
   * Sample Program for DictionaryService GetGeographicLocation.
   *
   * @param selector GeographicLocationSelector
   * @return GeographicLocationValues
   */
  public static List<GeographicLocationValues> getGeographicLocation(GeographicLocationSelector selector) throws Exception {

    // =================================================================
    // DictionaryService
    // =================================================================
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getGeographicLocation");
    System.out.println("############################################");

    Holder<GeographicLocationPage> geographicLocationPageHolder = new Holder<GeographicLocationPage>();
    Holder<List<Error>> dictionaryErrorHolder = new Holder<List<Error>>();
    dictionaryService.getGeographicLocation(selector, geographicLocationPageHolder, dictionaryErrorHolder);

    // if error
    if (dictionaryErrorHolder.value != null && dictionaryErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(dictionaryErrorHolder.value), true);
    }

    // response
    if (geographicLocationPageHolder.value != null) {
      GeographicLocationPage geographicLocationPage = geographicLocationPageHolder.value;
      if (geographicLocationPage.getValues() != null && geographicLocationPage.getValues().size() > 0) {
        for (int i = 0; i < geographicLocationPage.getValues().size(); i++) {
          List<GeographicLocationValues> values = geographicLocationPage.getValues();
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayGeographicLocation(values.get(i).getGeographicLocation());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }

    // Response
    return geographicLocationPageHolder.value.getValues();
  }

  /**
   * Sample Program for DictionaryService DisapprovalReason.
   *
   * @param selector DisapprovalReasonSelector
   * @return DisapprovalReasonValues
   */
  public static List<DisapprovalReasonValues> getDisapprovalReason(DisapprovalReasonSelector selector) throws Exception {

    // =================================================================
    // DictionaryService
    // =================================================================
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getDisapprovalReason");
    System.out.println("############################################");

    Holder<DisapprovalReasonPage> disapprovalReasonPageHolder = new Holder<DisapprovalReasonPage>();
    Holder<List<Error>> dictionaryErrorHolder = new Holder<List<Error>>();
    dictionaryService.getDisapprovalReason(selector, disapprovalReasonPageHolder, dictionaryErrorHolder);

    // if error
    if (dictionaryErrorHolder.value != null && dictionaryErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(dictionaryErrorHolder.value), true);
    }

    // response
    if (disapprovalReasonPageHolder.value != null) {
      DisapprovalReasonPage disapprovalReasonPage = disapprovalReasonPageHolder.value;
      if (disapprovalReasonPage.getValues() != null && disapprovalReasonPage.getValues().size() > 0) {
        for (int i = 0; i < disapprovalReasonPage.getValues().size(); i++) {
          List<DisapprovalReasonValues> values = disapprovalReasonPage.getValues();
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayDisapprovalReason(values.get(i).getDisapprovalReason());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }

    // Response
    return disapprovalReasonPageHolder.value.getValues();
  }

  /**
   * Sample Program for DictionaryService OsVersion.
   *
   * @return OsVersionValues
   */
  public static List<OsVersionValues> getOsVersion(OsVersionSelector selector) throws Exception {

    // =================================================================
    // DictionaryService
    // =================================================================
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getOsVersion");
    System.out.println("############################################");

    Holder<OsVersionPage> osVersionPageHolder = new Holder<OsVersionPage>();
    Holder<List<Error>> dictionaryErrorHolder = new Holder<List<Error>>();
    dictionaryService.getOsVersion(selector, osVersionPageHolder, dictionaryErrorHolder);

    // if error
    if (dictionaryErrorHolder.value != null && dictionaryErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(dictionaryErrorHolder.value), true);
    }

    // response
    if (osVersionPageHolder.value != null) {
      OsVersionPage OsVersionPage = osVersionPageHolder.value;
      if (OsVersionPage.getValues() != null && OsVersionPage.getValues().size() > 0) {
        for (int i = 0; i < OsVersionPage.getValues().size(); i++) {
          List<OsVersionValues> values = OsVersionPage.getValues();
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayOsVersion(values.get(i).getOsVersion());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }

    // Response
    return osVersionPageHolder.value.getValues();
  }

  /**
   * Sample Program for DictionaryService MediaAdFormat.
   *
   * @return MediaAdFormatValues
   */
  public static List<MediaAdFormatValues> getMediaAdFormat() throws Exception {

    // =================================================================
    // DictionaryService
    // =================================================================
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getMediaAdFormat");
    System.out.println("############################################");

    Holder<MediaAdFormatPage> mediaAdFormatPageHolder = new Holder<MediaAdFormatPage>();
    Holder<List<Error>> dictionaryErrorHolder = new Holder<List<Error>>();
    dictionaryService.getMediaAdFormat(mediaAdFormatPageHolder, dictionaryErrorHolder);

    // if error
    if (dictionaryErrorHolder.value != null && dictionaryErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(dictionaryErrorHolder.value), true);
    }

    // response
    if (mediaAdFormatPageHolder.value != null) {
      MediaAdFormatPage MediaAdFormatPage = mediaAdFormatPageHolder.value;
      if (MediaAdFormatPage.getValues() != null && MediaAdFormatPage.getValues().size() > 0) {
        for (int i = 0; i < MediaAdFormatPage.getValues().size(); i++) {
          List<MediaAdFormatValues> values = MediaAdFormatPage.getValues();
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayMediaAdFormat(values.get(i).getMediaAdFormat());
          } else {
            // if error
            SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
          }
        }
      }
    }

    // Response
    return mediaAdFormatPageHolder.value.getValues();
  }

  /**
   * display disapproval reason entity to stdout.
   *
   * @param disapprovalReason disapproval reason entity for display.
   */
  private static void displayDisapprovalReason(DisapprovalReason disapprovalReason) {
    if (null != disapprovalReason.getDisapprovalReasonCode()) {
      System.out.println("disapprovalReasonCode = " + disapprovalReason.getDisapprovalReasonCode());
    }
    if (null != disapprovalReason.getLang()) {
      System.out.println("lang = " + disapprovalReason.getLang());
    }
    if (null != disapprovalReason.getTitle()) {
      System.out.println("title = " + disapprovalReason.getTitle().toString());
    }
    if (null != disapprovalReason.getDescription()) {
      System.out.println("description = " + disapprovalReason.getDescription().toString());
    }
    if (null != disapprovalReason.getRecommendation()) {
      System.out.println("recommendation = " + disapprovalReason.getRecommendation().toString());
    }
    System.out.println("---------");
  }

  /**
   * display geographic location entity to stdout.
   *
   * @param geographicLocation account geographic location for display.
   */
  private static void displayGeographicLocation(GeographicLocation geographicLocation) {
    System.out.println("code = " + geographicLocation.getCode());
    System.out.println("fullName = " + geographicLocation.getFullName());
    System.out.println("name = " + geographicLocation.getName());
    System.out.println("order = " + geographicLocation.getOrder());

    List<GeographicLocation> childValues = geographicLocation.getChild();
    for (GeographicLocation childValue : childValues) {
      System.out.println("  child code = " + childValue.getCode());
      System.out.println("  child fullName = " + childValue.getFullName());
      System.out.println("  child name = " + childValue.getName());
      System.out.println("  child order = " + childValue.getOrder());
      System.out.println("  child parent = " + childValue.getParent());
      System.out.println("  =========");
    }
    System.out.println("---------");
  }

  /**
   * display geographic location entity to stdout.
   *
   * @param category account geographic location for display.
   */
  private static void displayCategory(Category category) {

    System.out.println("name = " + category.getName());

    List<CategoryChildValues> childValues = category.getChild();
    for (CategoryChildValues childValue : childValues) {
      System.out.println("  child code = " + childValue.getCode());
      System.out.println("  child fullName = " + childValue.getFullName());
      System.out.println("  child name = " + childValue.getName());
      System.out.println("  =========");
    }
    System.out.println("---------");
  }

  /**
   * element colorSet entity to stdout.
   *
   * @param colorSetValues ad element color for staticFrameAd.
   */
  private static void displayColorSet(ColorSetValues colorSetValues) {
    System.out.println("colorSetId = " + colorSetValues.getColorSetId());
    System.out.println("name = " + colorSetValues.getName());
    for (ColorSet colorSet : colorSetValues.getColorSet()) {
      System.out.println("  element = " + colorSet.getElement());
      System.out.println("  color = " + colorSet.getColor());
      System.out.println("  =========");
    }
    System.out.println("---------");
  }

  /**
   * element osVersion entity to stdout.
   *
   * @param osVersions os version entities for display.
   */
  private static void displayOsVersion(List<OsVersion> osVersions) {
    for (OsVersion osVersion : osVersions) {
      System.out.println("osType = " + osVersion.getOsType());
      System.out.println("version = " + osVersion.getVersion());
    }
    System.out.println("---------");
  }

  /**
   * element mediaAdFormat entity to stdout.
   *
   * @param mediaAdFormats Media ad format entity for display.
   */
  private static void displayMediaAdFormat(List<MediaAdFormat> mediaAdFormats) {
    for (MediaAdFormat mediaAdFormat : mediaAdFormats) {
      System.out.println("id = " + mediaAdFormat.getId());
      System.out.println("width = " + mediaAdFormat.getWidth());
      System.out.println("height = " + mediaAdFormat.getHeight());
      System.out.println("size = " + mediaAdFormat.getSize());
      System.out.println("transparent = " + mediaAdFormat.isTransparent());
      System.out.println("animation = " + mediaAdFormat.isAnimation());
      System.out.println("logo = " + mediaAdFormat.isLogo());
      System.out.println("thumbnail = " + mediaAdFormat.isThumbnail());
      System.out.println("adFormat = " + mediaAdFormat.getAdFormat());
    }
    System.out.println("---------");
  }

}
