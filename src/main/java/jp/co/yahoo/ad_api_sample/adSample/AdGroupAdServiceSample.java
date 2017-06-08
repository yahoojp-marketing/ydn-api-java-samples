package jp.co.yahoo.ad_api_sample.adSample;

import jp.co.yahoo.ad_api_sample.error.impl.AdGroupAdServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.V6.AdGroupAdService.Ad;
import jp.yahooapis.im.V6.AdGroupAdService.AdGroupAd;
import jp.yahooapis.im.V6.AdGroupAdService.AdGroupAdOperation;
import jp.yahooapis.im.V6.AdGroupAdService.AdGroupAdPage;
import jp.yahooapis.im.V6.AdGroupAdService.AdGroupAdReturnValue;
import jp.yahooapis.im.V6.AdGroupAdService.AdGroupAdSelector;
import jp.yahooapis.im.V6.AdGroupAdService.AdGroupAdServiceInterface;
import jp.yahooapis.im.V6.AdGroupAdService.AdGroupAdServiceService;
import jp.yahooapis.im.V6.AdGroupAdService.AdGroupAdValues;
import jp.yahooapis.im.V6.AdGroupAdService.AdStyle;
import jp.yahooapis.im.V6.AdGroupAdService.AdType;
import jp.yahooapis.im.V6.AdGroupAdService.BiddingStrategyType;
import jp.yahooapis.im.V6.AdGroupAdService.ManualCPCAdGroupAdBid;
import jp.yahooapis.im.V6.AdGroupAdService.ManualCPVAdGroupAdBid;
import jp.yahooapis.im.V6.AdGroupAdService.MobileAd;
import jp.yahooapis.im.V6.AdGroupAdService.PosAd;
import jp.yahooapis.im.V6.AdGroupAdService.TextAd;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.xml.ws.Holder;

/**
 * Sample Program for AdGroupAdService.<br>
 * Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class AdGroupAdServiceSample {

  /**
   * main method for AdGroupAdServiceSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      long campaignId = SoapUtils.getCampaignId();
      long adGroupId = SoapUtils.getAdGroupId();

      // =================================================================
      // AdGroupAdService ADD
      // =================================================================
      // Set Operation
      AdGroupAdOperation addAdGroupAdOperation = createSampleAddRequest(accountId, campaignId, adGroupId);

      // Run
      List<AdGroupAdValues> adGroupAdValues = add(addAdGroupAdOperation);

      // =================================================================
      // AdGroupAdService GET
      // =================================================================
      // Set Selector
      AdGroupAdSelector adGroupAdSelector = createSampleGetRequest(accountId, adGroupAdValues);

      // Run
      get(adGroupAdSelector);

      // =================================================================
      // AdGroupAdService SET
      // =================================================================
      // Set Operation
      AdGroupAdOperation setAdGroupAdOperation = createSampleSetRequest(accountId, adGroupAdValues);

      // Run
      set(setAdGroupAdOperation);

      // =================================================================
      // AdGroupAdService REMOVE
      // =================================================================
      // Set Operation
      AdGroupAdOperation removeAdGroupAdOperation = createSampleRemoveRequest(accountId, adGroupAdValues);

      // Run
      remove(removeAdGroupAdOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for AdGroupAdService ADD.
   *
   * @param operation AdGroupAdOperation
   * @return AdGroupAdValues
   */
  public static List<AdGroupAdValues> add(AdGroupAdOperation operation) throws Exception {

    // =================================================================
    // AdGroupAdService
    // =================================================================
    AdGroupAdServiceInterface adGroupAdService = SoapUtils.createServiceInterface(AdGroupAdServiceInterface.class, AdGroupAdServiceService.class);

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupAdService::mutate(ADD)");
    System.out.println("############################################");

    Holder<AdGroupAdReturnValue> addAdGroupAdReturnValueHolder = new Holder<AdGroupAdReturnValue>();
    Holder<List<jp.yahooapis.im.V6.AdGroupAdService.Error>> addAdGroupAdErrorHolder = new Holder<List<jp.yahooapis.im.V6.AdGroupAdService.Error>>();
    adGroupAdService.mutate(operation, addAdGroupAdReturnValueHolder, addAdGroupAdErrorHolder);

    // if error
    if (addAdGroupAdErrorHolder.value != null && addAdGroupAdErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(addAdGroupAdErrorHolder.value), true);
    }

    // response
    if (addAdGroupAdReturnValueHolder.value != null) {
      AdGroupAdReturnValue returnValue = addAdGroupAdReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<AdGroupAdValues> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            AdGroupAd adGroupAd = values.get(i).getAdGroupAd();

            displayAdGroupAd(adGroupAd);
          } else {
            // if error
            SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(values.get(i).getError()), true);
          }
        }
      }
    }

    // Response
    return addAdGroupAdReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupAdService SET.
   *
   * @param operation AdGroupAdOperation
   * @return AdGroupAdValues
   */
  public static List<AdGroupAdValues> set(AdGroupAdOperation operation) throws Exception {

    // =================================================================
    // AdGroupAdService
    // =================================================================
    AdGroupAdServiceInterface adGroupAdService = SoapUtils.createServiceInterface(AdGroupAdServiceInterface.class, AdGroupAdServiceService.class);

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupAdService::mutate(SET)");
    System.out.println("############################################");
    Holder<AdGroupAdReturnValue> setAdGroupAdReturnValueHolder = new Holder<AdGroupAdReturnValue>();
    Holder<List<jp.yahooapis.im.V6.AdGroupAdService.Error>> setAdGroupAdErrorHolder = new Holder<List<jp.yahooapis.im.V6.AdGroupAdService.Error>>();
    adGroupAdService.mutate(operation, setAdGroupAdReturnValueHolder, setAdGroupAdErrorHolder);

    // if error
    if (setAdGroupAdErrorHolder.value != null && setAdGroupAdErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(setAdGroupAdErrorHolder.value), true);
    }

    // response
    if (setAdGroupAdReturnValueHolder.value != null) {
      AdGroupAdReturnValue returnValue = setAdGroupAdReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<AdGroupAdValues> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayAdGroupAd(values.get(i).getAdGroupAd());
          } else {
            // if error
            SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(values.get(i).getError()), true);
          }
        }
      }
    }

    // Response
    return setAdGroupAdReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupAdService REMOVE.
   *
   * @param operation AdGroupAdOperation
   * @return AdGroupAdValues
   */
  public static List<AdGroupAdValues> remove(AdGroupAdOperation operation) throws Exception {

    // AdGroupAdService
    // =================================================================
    AdGroupAdServiceInterface adGroupAdService = SoapUtils.createServiceInterface(AdGroupAdServiceInterface.class, AdGroupAdServiceService.class);

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupAdService::mutate(REMOVE)");
    System.out.println("############################################");
    Holder<AdGroupAdReturnValue> removeAdGroupAdReturnValueHolder = new Holder<AdGroupAdReturnValue>();
    Holder<List<jp.yahooapis.im.V6.AdGroupAdService.Error>> removeAdGroupAdErrorHolder = new Holder<List<jp.yahooapis.im.V6.AdGroupAdService.Error>>();
    adGroupAdService.mutate(operation, removeAdGroupAdReturnValueHolder, removeAdGroupAdErrorHolder);

    // if error
    if (removeAdGroupAdErrorHolder.value != null && removeAdGroupAdErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(removeAdGroupAdErrorHolder.value), true);
    }

    // response
    if (removeAdGroupAdReturnValueHolder.value != null) {
      AdGroupAdReturnValue returnValue = removeAdGroupAdReturnValueHolder.value;
      if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
        List<AdGroupAdValues> values = returnValue.getValues();
        for (int i = 0; i < values.size(); i++) {
          if (values.get(i).isOperationSucceeded()) {
            // display response
            displayAdGroupAd(values.get(i).getAdGroupAd());
          } else {
            // if error
            SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(values.get(i).getError()), true);
          }
        }
      }
    }

    // Response
    return removeAdGroupAdReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupAdService GET.
   *
   * @param adGroupAdSelector AdGroupAdSelector
   * @return AdGroupAdValues
   */
  public static List<AdGroupAdValues> get(AdGroupAdSelector adGroupAdSelector) throws Exception {

    // AdGroupAdService
    // =================================================================
    AdGroupAdServiceInterface adGroupAdService = SoapUtils.createServiceInterface(AdGroupAdServiceInterface.class, AdGroupAdServiceService.class);

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupAdService::get");
    System.out.println("############################################");

    Holder<AdGroupAdPage> adGroupAdPage = new Holder<AdGroupAdPage>();
    Holder<List<jp.yahooapis.im.V6.AdGroupAdService.Error>> errorHolder = new Holder<List<jp.yahooapis.im.V6.AdGroupAdService.Error>>();

    adGroupAdService.get(adGroupAdSelector, adGroupAdPage, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupAdPage.value == null) {
      throw new Exception("NoDataResponse:AdGroupAdService Get");
    }

    // Display
    for (AdGroupAdValues adGroupAdValues : adGroupAdPage.value.getValues()) {
      if (adGroupAdValues.isOperationSucceeded()) {
        displayAdGroupAd(adGroupAdValues.getAdGroupAd());
      } else {
        SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(adGroupAdValues.getError()), true);
      }
    }

    // Response
    return adGroupAdPage.value.getValues();
  }


  /**
   * create sample request.
   *
   * @param accountId  long
   * @param campaignId long
   * @param adGroupId  long
   * @return AdGroupAdOperation
   */
  public static AdGroupAdOperation createSampleAddRequest(long accountId, long campaignId, long adGroupId) {

    // Set Operation
    // -----------------------------------------------
    // AdGroupAdService::mutate(ADD)
    // -----------------------------------------------
    // request
    TextAd addTextAd = new TextAd();
    addTextAd.setType(AdType.TEXT_LONG_AD_1);
    addTextAd.setUrl("http://www.yahoo.co.jp/");
    addTextAd.setDisplayUrl("www.yahoo.co.jp");
    addTextAd.setHeadline("sample headline");
    addTextAd.setDescription("sample ad desc");
    addTextAd.setDescription2("sample ad desc2");

    AdGroupAd addAdGroupAdOperand = new AdGroupAd();
    addAdGroupAdOperand.setAccountId(accountId);
    addAdGroupAdOperand.setCampaignId(campaignId);
    addAdGroupAdOperand.setAdGroupId(adGroupId);
    addAdGroupAdOperand.setAdStyle(AdStyle.TEXT);
    addAdGroupAdOperand.setAdName("SampleAdGroupAd_CreateOn_" + SoapUtils.getCurrentTimestamp());
    addAdGroupAdOperand.setUserStatus(jp.yahooapis.im.V6.AdGroupAdService.UserStatus.ACTIVE);
    ManualCPCAdGroupAdBid addAdBid = new ManualCPCAdGroupAdBid();
    addAdBid.setMaxCpc((long) 50);
    addAdBid.setType(jp.yahooapis.im.V6.AdGroupAdService.BiddingStrategyType.MANUAL_CPC);
    addAdGroupAdOperand.setBid(addAdBid);
    addAdGroupAdOperand.setAd(addTextAd);

    AdGroupAdOperation addAdGroupAdOperation = new AdGroupAdOperation();
    addAdGroupAdOperation.setOperator(jp.yahooapis.im.V6.AdGroupAdService.Operator.ADD);
    addAdGroupAdOperation.setAccountId(accountId);
    addAdGroupAdOperation.getOperand().add(addAdGroupAdOperand);

    return addAdGroupAdOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId       long
   * @param adGroupAdValues AdGroupAdValues
   * @return AdGroupAdOperation
   */
  public static AdGroupAdOperation createSampleSetRequest(long accountId, List<AdGroupAdValues> adGroupAdValues) {
    // Set Operation
    AdGroupAdOperation setAdGroupAdOperation = new AdGroupAdOperation();
    setAdGroupAdOperation.setOperator(jp.yahooapis.im.V6.AdGroupAdService.Operator.SET);
    setAdGroupAdOperation.setAccountId(accountId);

    TextAd setTextAd = new TextAd();
    setTextAd.setType(AdType.TEXT_LONG_AD_1);
    setTextAd.setUrl("http://www.yahoo.co.jp/");
    setTextAd.setDisplayUrl("www.yahoo.co.jp");
    setTextAd.setHeadline("sample headline");
    setTextAd.setDescription("sample ad desc");
    setTextAd.setDescription2("sample ad desc2");

    // Set Operand
    for (AdGroupAdValues adGroupAdValue : adGroupAdValues) {
      AdGroupAd setAdGroupAdOperand = new AdGroupAd();
      setAdGroupAdOperand.setAccountId(accountId);
      setAdGroupAdOperand.setCampaignId(adGroupAdValue.getAdGroupAd().getCampaignId());
      setAdGroupAdOperand.setAdGroupId(adGroupAdValue.getAdGroupAd().getAdGroupId());
      setAdGroupAdOperand.setAdId(adGroupAdValue.getAdGroupAd().getAdId());
      setAdGroupAdOperand.setAdName("SampleAdGroupAd_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setAdGroupAdOperand.setUserStatus(jp.yahooapis.im.V6.AdGroupAdService.UserStatus.PAUSED);
      setAdGroupAdOperand.setAd(setTextAd);

      ManualCPCAdGroupAdBid setAdBid = new ManualCPCAdGroupAdBid();
      setAdBid.setMaxCpc((long) 60);
      setAdBid.setType(jp.yahooapis.im.V6.AdGroupAdService.BiddingStrategyType.MANUAL_CPC);
      setAdGroupAdOperand.setBid(setAdBid);

      setAdGroupAdOperation.getOperand().add(setAdGroupAdOperand);

    }

    return setAdGroupAdOperation;

  }

  /**
   * create sample request.
   *
   * @param accountId       long
   * @param adGroupAdValues AdGroupAdValues
   * @return AdGroupAdOperation
   */
  public static AdGroupAdOperation createSampleRemoveRequest(long accountId, List<AdGroupAdValues> adGroupAdValues) {
    // Set Operation
    AdGroupAdOperation removeAdGroupAdOperation = new AdGroupAdOperation();
    removeAdGroupAdOperation.setOperator(jp.yahooapis.im.V6.AdGroupAdService.Operator.REMOVE);
    removeAdGroupAdOperation.setAccountId(accountId);

    // Set Operand
    for (AdGroupAdValues adGroupAdValue : adGroupAdValues) {

      AdGroupAd removeAdGroupAdOperand = new AdGroupAd();
      removeAdGroupAdOperand.setAccountId(adGroupAdValue.getAdGroupAd().getAccountId());
      removeAdGroupAdOperand.setCampaignId(adGroupAdValue.getAdGroupAd().getCampaignId());
      removeAdGroupAdOperand.setAdGroupId(adGroupAdValue.getAdGroupAd().getAdGroupId());
      removeAdGroupAdOperand.setAdId(adGroupAdValue.getAdGroupAd().getAdId());

      removeAdGroupAdOperation.getOperand().add(removeAdGroupAdOperand);
    }

    return removeAdGroupAdOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId       long
   * @param adGroupAdValues AdGroupAdValues
   * @return AdGroupAdSelector
   */
  public static AdGroupAdSelector createSampleGetRequest(long accountId, List<AdGroupAdValues> adGroupAdValues) {
    // Set Selector
    AdGroupAdSelector adGroupAdSelector = new AdGroupAdSelector();
    adGroupAdSelector.setAccountId(accountId);
    adGroupAdSelector.getUserStatuses().addAll(Arrays.asList(jp.yahooapis.im.V6.AdGroupAdService.UserStatus.ACTIVE, jp.yahooapis.im.V6.AdGroupAdService.UserStatus.PAUSED));

    for (AdGroupAdValues adGroupAdValue : adGroupAdValues) {
      adGroupAdSelector.getCampaignIds().add((adGroupAdValue.getAdGroupAd().getCampaignId()));
      adGroupAdSelector.getAdGroupIds().add((adGroupAdValue.getAdGroupAd().getAdGroupId()));
      adGroupAdSelector.getAdIds().add((adGroupAdValue.getAdGroupAd().getAdId()));
    }

    jp.yahooapis.im.V6.AdGroupAdService.Paging adPaging = new jp.yahooapis.im.V6.AdGroupAdService.Paging();
    adPaging.setStartIndex(1);
    adPaging.setNumberResults(20);
    adGroupAdSelector.setPaging(adPaging);

    return adGroupAdSelector;
  }

  /**
   * display AdGroupAd entity to stdout.
   *
   * @param adGroupAd AdGroupAd entity for display.
   */
  private static void displayAdGroupAd(AdGroupAd adGroupAd) {
    System.out.println("accountId = " + adGroupAd.getAccountId());
    System.out.println("campaignId = " + adGroupAd.getCampaignId());
    System.out.println("campaignName = " + adGroupAd.getCampaignName());
    System.out.println("adGroupId = " + adGroupAd.getAdGroupId());
    System.out.println("adGreoupName = " + adGroupAd.getAdGroupName());
    System.out.println("adId = " + adGroupAd.getAdId());
    System.out.println("adName = " + adGroupAd.getAdName());
    System.out.println("adStyle = " + adGroupAd.getAdStyle().toString());
    System.out.println("mediaId = " + adGroupAd.getMediaId());
    System.out.println("userStatus = " + adGroupAd.getUserStatus().toString());
    System.out.println("approvalStatus = " + adGroupAd.getApprovalStatus().toString());
    if (adGroupAd.getBid() != null) {
      System.out.println("bid/type = " + (adGroupAd.getBid()).getType().toString());
      if (Objects.equals(adGroupAd.getBid().getType(), BiddingStrategyType.MANUAL_CPC)) {
        System.out.println("bid/maxCpc = " + ((ManualCPCAdGroupAdBid) adGroupAd.getBid()).getMaxCpc().toString());
      } else {
        System.out.println("bid/maxCpv = " + ((ManualCPVAdGroupAdBid) adGroupAd.getBid()).getMaxCpv().toString());
      }
    }
    if (adGroupAd.getAd() != null) {
      Ad ad = adGroupAd.getAd();
      if (ad instanceof TextAd) {
        TextAd textAd = (TextAd) ad;
        System.out.println("ad/type = " + textAd.getType().toString());
        System.out.println("ad/url = " + textAd.getUrl());
        System.out.println("ad/displayUrl = " + textAd.getDisplayUrl());
        System.out.println("ad/headline = " + textAd.getHeadline());
        System.out.println("ad/description = " + textAd.getDescription());
        System.out.println("ad/description2 = " + textAd.getDescription2());
      } else if (ad instanceof MobileAd) {
        MobileAd mobileAd = (MobileAd) ad;
        System.out.println("ad/type = " + mobileAd.getType().toString());
        System.out.println("ad/url = " + mobileAd.getUrl());
        System.out.println("ad/displayUrl = " + mobileAd.getDisplayUrl());
        System.out.println("ad/headline = " + mobileAd.getHeadline());
        System.out.println("ad/description = " + mobileAd.getDescription());
        System.out.println("ad/description2 = " + mobileAd.getDescription2());
        System.out.println("ad/mobileCarerrir = " + SoapUtils.arrayToLine(mobileAd.getMobileCarriers().toArray()));
      } else if (ad instanceof PosAd) {
        PosAd posAd = (PosAd) ad;
        System.out.println("ad/type = " + posAd.getType().toString());
        System.out.println("ad/url = " + posAd.getUrl());
        System.out.println("ad/description = " + posAd.getDescription());
      }
    }
    System.out.println("ad/impressionBeaconUrls = " + adGroupAd.getImpressionBeaconUrls());
    System.out.println("ad/isRemoveBeaconUrls = " + adGroupAd.getIsRemoveBeaconUrls());
    System.out.println("---------");
  }
}
