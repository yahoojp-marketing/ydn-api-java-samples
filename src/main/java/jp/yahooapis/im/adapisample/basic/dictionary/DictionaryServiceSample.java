/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.dictionary;

import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.v201911.Error;
import jp.yahooapis.im.v201911.dictionary.AudienceCategoryPage;
import jp.yahooapis.im.v201911.dictionary.AudienceCategoryValues;
import jp.yahooapis.im.v201911.dictionary.CategoryPage;
import jp.yahooapis.im.v201911.dictionary.CategorySelector;
import jp.yahooapis.im.v201911.dictionary.CategoryValues;
import jp.yahooapis.im.v201911.dictionary.DeviceOsType;
import jp.yahooapis.im.v201911.dictionary.DictionaryLang;
import jp.yahooapis.im.v201911.dictionary.DictionaryService;
import jp.yahooapis.im.v201911.dictionary.DictionaryServiceInterface;
import jp.yahooapis.im.v201911.dictionary.DisapprovalReasonPage;
import jp.yahooapis.im.v201911.dictionary.DisapprovalReasonSelector;
import jp.yahooapis.im.v201911.dictionary.DisapprovalReasonValues;
import jp.yahooapis.im.v201911.dictionary.FeedItemGoogleProductCategoryPage;
import jp.yahooapis.im.v201911.dictionary.FeedItemGoogleProductCategorySelector;
import jp.yahooapis.im.v201911.dictionary.FeedItemGoogleProductCategoryValues;
import jp.yahooapis.im.v201911.dictionary.GeographicLocationPage;
import jp.yahooapis.im.v201911.dictionary.GeographicLocationSelector;
import jp.yahooapis.im.v201911.dictionary.GeographicLocationValues;
import jp.yahooapis.im.v201911.dictionary.MediaAdFormatPage;
import jp.yahooapis.im.v201911.dictionary.MediaAdFormatValues;
import jp.yahooapis.im.v201911.dictionary.OsVersionPage;
import jp.yahooapis.im.v201911.dictionary.OsVersionSelector;
import jp.yahooapis.im.v201911.dictionary.OsVersionValues;
import jp.yahooapis.im.v201911.dictionary.ThirdPartyTrackingDomainPage;
import jp.yahooapis.im.v201911.dictionary.ThirdPartyTrackingDomainValues;

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

      // =================================================================
      // DictionaryService getAudienceCategory
      // =================================================================
      // create request.
      CategorySelector getAudienceCategoryRequest = buildExampleGetAudienceCategoryRequest();

      // run
      getAudienceCategory(getAudienceCategoryRequest);

      // =================================================================
      // DictionaryService getThirdPartyTrackingDomain
      // =================================================================
      // run
      getThirdPartyTrackingDomain();

      // =================================================================
      // DictionaryService getFeedItemGoogleProductCategory
      // =================================================================
      // create request.
      FeedItemGoogleProductCategorySelector getFeedItemGoogleProductCategoryRequest = buildExampleGetFeedItemGoogleProductCategoryRequest();

      // run
      getFeedItemGoogleProductCategory(getFeedItemGoogleProductCategoryRequest);

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
  public static DisapprovalReasonSelector buildExampleGetDisapprovalReasonRequest() {
    DisapprovalReasonSelector selector = new DisapprovalReasonSelector();
    selector.setLang(DictionaryLang.EN);
    return selector;
  }

  /**
   * example getGeographicLocation request.
   *
   * @return GeographicLocationSelector
   */
  public static GeographicLocationSelector buildExampleGetGeographicLocationRequest() {
    GeographicLocationSelector selector = new GeographicLocationSelector();
    selector.setLang(DictionaryLang.EN);
    return selector;
  }

  /**
   * example getInterestCategory request.
   *
   * @return CategorySelector
   */
  public static CategorySelector buildExampleGetInterestCategoryRequest() {
    CategorySelector selector = new CategorySelector();
    selector.setLang(DictionaryLang.EN);
    return selector;
  }

  /**
   * example getSiteCategory request.
   *
   * @return CategorySelector
   */
  public static CategorySelector buildExampleGetSiteCategoryRequest() {
    CategorySelector selector = new CategorySelector();
    selector.setLang(DictionaryLang.EN);
    return selector;
  }

  /**
   * example getOsVersion request.
   *
   * @return OsVersionSelector
   */
  public static OsVersionSelector buildExampleGetOsVersionRequest() {
    OsVersionSelector selector = new OsVersionSelector();
    selector.setOsType(DeviceOsType.ANDROID);
    return selector;
  }

  /**
   * example getAudienceCategory request.
   *
   * @return CategorySelector
   */
  public static CategorySelector buildExampleGetAudienceCategoryRequest() {
    CategorySelector selector = new CategorySelector();
    selector.setLang(DictionaryLang.EN);
    return selector;
  }

  /**
   * example getFeedItemGoogleProductCategory request.
   *
   * @return FeedItemGoogleProductCategorySelector
   */
  public static FeedItemGoogleProductCategorySelector buildExampleGetFeedItemGoogleProductCategoryRequest() {
    FeedItemGoogleProductCategorySelector selector = new FeedItemGoogleProductCategorySelector();
    selector.setLang(DictionaryLang.EN);
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

  /**
   * example get GetAudienceCategory.
   *
   * @return AudienceCategoryValues
   */
  public static List<AudienceCategoryValues> getAudienceCategory(CategorySelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getAudienceCategory");
    System.out.println("############################################");

    Holder<AudienceCategoryPage> audienceCategoryPageHolder = new Holder<AudienceCategoryPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);
    dictionaryService.getAudienceCategory(selector, audienceCategoryPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, audienceCategoryPageHolder.value.getValues());

    // Response
    return audienceCategoryPageHolder.value.getValues();
  }

  /**
   * example get GetThirdPartyTrackingDomain.
   *
   * @return ThirdPartyTrackingDomainValues
   */
  public static List<ThirdPartyTrackingDomainValues> getThirdPartyTrackingDomain() throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getGetThirdPartyTrackingDomain");
    System.out.println("############################################");

    Holder<ThirdPartyTrackingDomainPage> thirdPartyTrackingDomainPageHolder = new Holder<ThirdPartyTrackingDomainPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);
    dictionaryService.getThirdPartyTrackingDomain(thirdPartyTrackingDomainPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, thirdPartyTrackingDomainPageHolder.value.getValues());

    // Response
    return thirdPartyTrackingDomainPageHolder.value.getValues();
  }

  /**
   * example get GetFeedItemGoogleProductCategory.
   *
   * @return FeedItemGoogleProductCategoryValues
   */
  public static List<FeedItemGoogleProductCategoryValues> getFeedItemGoogleProductCategory(FeedItemGoogleProductCategorySelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getFeedItemGoogleProductCategory");
    System.out.println("############################################");

    Holder<FeedItemGoogleProductCategoryPage> feedItemGoogleProductCategoryPageHolder = new Holder<FeedItemGoogleProductCategoryPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);
    dictionaryService.getFeedItemGoogleProductCategory(selector, feedItemGoogleProductCategoryPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, feedItemGoogleProductCategoryPageHolder.value.getValues());

    // Response
    return feedItemGoogleProductCategoryPageHolder.value.getValues();
  }
}
