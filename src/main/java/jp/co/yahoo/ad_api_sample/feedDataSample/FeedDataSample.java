package jp.co.yahoo.ad_api_sample.feedDataSample;

import jp.co.yahoo.ad_api_sample.error.impl.ErrorEntityFactoryImpl;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.im.v201812.Error;
import jp.yahooapis.im.v201812.Paging;
import jp.yahooapis.im.v201812.feeddata.FeedDataPage;
import jp.yahooapis.im.v201812.feeddata.FeedDataRecord;
import jp.yahooapis.im.v201812.feeddata.FeedDataSelector;
import jp.yahooapis.im.v201812.feeddata.FeedDataServiceInterface;
import jp.yahooapis.im.v201812.feeddata.FeedDataServiceService;
import jp.yahooapis.im.v201812.feeddata.FeedDataValues;
import jp.yahooapis.im.v201812.feeddata.FileUploadDateRange;
import jp.yahooapis.im.v201812.feeddata.FileUploadStatus;
import jp.yahooapis.im.v201812.feeddata.ItemListUploadType;
import jp.yahooapis.im.v201812.feeddata.UploadUrlValue;
import jp.yahooapis.im.v201812.feedholder.FeedHolderOperation;
import jp.yahooapis.im.v201812.feedholder.FeedHolderSelector;
import jp.yahooapis.im.v201812.feedholder.FeedHolderValues;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.ws.Holder;


/**
 * Sample Program for FeedDataService,FeedHolderService.<br>
 * Copyright (C) 2016 Yahoo Japan Corporation. All Rights Reserved.
 */
public class FeedDataSample {

  /**
   * main method for FeedDataServiceServiceSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {

    try {

      long accountId = SoapUtils.getAccountId();
      long feedHolderId = -1;

      // -----------------------------------------------
      // FeedHolderService::add
      // -----------------------------------------------
      // request
      FeedHolderOperation addFeedHolderRequest = FeedHolderSample.createSampleAddRequest(accountId);

      // call API
      List<FeedHolderValues> addFeedHolderResponse = FeedHolderSample.add(addFeedHolderRequest);

      for (FeedHolderValues feedHolderValue : addFeedHolderResponse) {
        feedHolderId = feedHolderValue.getFeedHolder().getFeedHolderId();
      }

      // -----------------------------------------------
      // FeedHolderService::get
      // -----------------------------------------------
      // request
      FeedHolderSelector feedHolderSelector = FeedHolderSample.createSampleGetRequest(accountId, addFeedHolderResponse);

      // call API
      FeedHolderSample.get(feedHolderSelector);

      // -----------------------------------------------
      // FeedHolderService::set
      // -----------------------------------------------
      // request
      FeedHolderOperation setFeedHolderRequest = FeedHolderSample.createSampleSetRequest(accountId, addFeedHolderResponse);

      // call API
      FeedHolderSample.set(setFeedHolderRequest);

      // -----------------------------------------------
      // FeedDataService::getUploadUrl
      // -----------------------------------------------
      // call API
      UploadUrlValue uploadUrlValue = getUploadUrl(accountId, feedHolderId);

      // -----------------------------------------------
      // FeedDataService::upload
      // -----------------------------------------------
      // call API
      long itemListUploadId = upload(uploadUrlValue.getUploadUrl());

      // -----------------------------------------------
      // FeedDataService::getUploadStatus
      // -----------------------------------------------
      // request
      FileUploadDateRange dateRange = new FileUploadDateRange();

      // It specifies the current month
      SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
      Calendar cal = new GregorianCalendar();
      Date now = cal.getTime();
      int year = cal.get(Calendar.YEAR);
      int month = cal.get(Calendar.MONTH);
      int date = 1;
      cal.set(year, month, date, 0, 0, 0);

      dateRange.setStartDate(format.format(cal.getTime()));
      dateRange.setEndDate(format.format(now));

      FeedDataSelector feedDataSelector = new FeedDataSelector();
      feedDataSelector.setAccountId(accountId);
      feedDataSelector.getFeedHolderIds().add(feedHolderId);
      feedDataSelector.setDateRange(dateRange);
      feedDataSelector.getItemListUploadIds().add(itemListUploadId);

      Paging paging = new Paging();
      paging.setStartIndex(1);
      paging.setNumberResults(20);
      feedDataSelector.setPaging(paging);

      // call API
      List<FeedDataValues> getFeedDataResponse = getFeedDataUploadStatus(feedDataSelector);


      // =================================================================
      // download feedData
      // =================================================================
      // execute
      downloadFeedData(getFeedDataResponse.get(0));

      // -----------------------------------------------
      // FeedHolderService::remove
      // -----------------------------------------------
      // request
      FeedHolderOperation removeFeedHolderRequest = FeedHolderSample.createSampleRemoveRequest(accountId, addFeedHolderResponse);

      // call API
      FeedHolderSample.remove(removeFeedHolderRequest);


    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Sample Program for FeedDataUploadService Upload.
   *
   * @param uploadUrl String
   * @return itemListUploadId long
   */
  public static long upload(String uploadUrl) throws Exception {

    // file upload
    System.out.println("############################################");
    System.out.println("FeedDataService::upload");
    System.out.println("############################################");
    String response = SoapUtils.upload(uploadUrl, "SampleFeedUpload.zip", "application/zip");

    // get upload feedData itemListUploadId
    long itemListUploadId = -1;
    Document responseDOM = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response)));
    NodeList nodeList = responseDOM.getElementsByTagName("itemListUploadId");
    if (nodeList.getLength() > 0) {
      itemListUploadId = Long.parseLong(nodeList.item(0).getFirstChild().getNodeValue());
    } else {
      throw new RuntimeException("Fail to upload to FeedData. response=" + response);
    }

    // return
    return itemListUploadId;
  }

  /**
   * Sample Program for FeedDataUploadService GetUploadUrl.
   *
   * @param accountId    long
   * @param feedHolderId long
   * @return UploadUrlValue
   */
  public static UploadUrlValue getUploadUrl(long accountId, long feedHolderId) throws Exception {

    // =================================================================
    // FeedDataService
    // =================================================================
    FeedDataServiceInterface feedDataService = SoapUtils.createServiceInterface(FeedDataServiceInterface.class, FeedDataServiceService.class);

    // -----------------------------------------------
    // FeedDataService::getUploadUrl
    // -----------------------------------------------
    // call API
    System.out.println("############################################");
    System.out.println("FeedDataService::getUploadUrl");
    System.out.println("############################################");

    Holder<UploadUrlValue> getUploadUrlValueHolder = new Holder<UploadUrlValue>();
    Holder<List<Error>> getUploadUrlErrorHolder = new Holder<List<Error>>();
    feedDataService.getUploadUrl(accountId, ItemListUploadType.UPDATE_ALL, feedHolderId, getUploadUrlValueHolder, getUploadUrlErrorHolder);

    // if error
    if (getUploadUrlErrorHolder.value != null && getUploadUrlErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ErrorEntityFactoryImpl(getUploadUrlErrorHolder.value), true);
    }

    // response
    if (getUploadUrlValueHolder.value != null) {
      UploadUrlValue uploadUrlValue = getUploadUrlValueHolder.value;
      displayGetUploadUrlResponse(uploadUrlValue);
    }

    return getUploadUrlValueHolder.value;
  }

  /**
   * Sample Program for FeedDataService GetUploadStatus.
   *
   * @param selector FeedDataSelector
   * @return FeedDataValues
   */
  public static List<FeedDataValues> getFeedDataUploadStatus(FeedDataSelector selector) throws Exception {

    // =================================================================
    // FeedDataService
    // =================================================================
    FeedDataServiceInterface feedDataService = SoapUtils.createServiceInterface(FeedDataServiceInterface.class, FeedDataServiceService.class);

    // call 30sec sleep * 30 = 15minute
    Holder<FeedDataPage> getFeedDataPageHolder = null;
    Holder<List<Error>> getFeedDataErrorHolder = null;

    // UploadFeedDataJobStatus jobStatus = null;

    for (int wait_count = 0; wait_count < 30; wait_count++) {
      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds for FeedData Upload Job *****\n");
      Thread.sleep(30000);

      // call API
      System.out.println("############################################");
      System.out.println("FeedDataService::getUploadStatus");
      System.out.println("############################################");
      getFeedDataPageHolder = new Holder<FeedDataPage>();
      getFeedDataErrorHolder = new Holder<List<Error>>();
      feedDataService.getUploadStatus(selector, getFeedDataPageHolder, getFeedDataErrorHolder);

      // if error
      if (getFeedDataErrorHolder.value != null && getFeedDataErrorHolder.value.size() > 0) {
        SoapUtils.displayErrors(new ErrorEntityFactoryImpl(getFeedDataErrorHolder.value), true);
      }

      FileUploadStatus fileUploadStatus = FileUploadStatus.UPLOADED;

      // response
      if (getFeedDataPageHolder.value != null) {
        FeedDataPage page = getFeedDataPageHolder.value;
        if (page.getValues() != null && page.getValues().size() > 0) {
          List<FeedDataValues> values = page.getValues();
          for (int i = 0; i < values.size(); i++) {
            if (values.get(i).isOperationSucceeded()) {
              FeedDataRecord feedDataRecord = values.get(i).getFeedData();
              fileUploadStatus = feedDataRecord.getItemListUploadStatus();
              display(feedDataRecord);

              if (feedDataRecord.getErrorListDownloadUrl() != null) {
                System.out.println("errorListDownloadUrl = " + feedDataRecord.getErrorListDownloadUrl());
              }

            } else {
              SoapUtils.displayErrors(new ErrorEntityFactoryImpl(values.get(i).getError()), true);
            }
          }
        }
      }

      if (fileUploadStatus.equals(FileUploadStatus.COMPLETED)) {
        break;
      } else {
        if (fileUploadStatus.equals(FileUploadStatus.UPLOADED)) {
          continue;
        } else {
          System.out.println("\nError : Job Status failed.");
          System.exit(0);
        }
      }
    }

    // Response
    return getFeedDataPageHolder.value.getValues();
  }

  /**
   * download feedData.
   *
   * @param getFeedDataResponse FeedDataUploadValues
   */
  public static void downloadFeedData(FeedDataValues getFeedDataResponse) throws Exception {

    // check status
    if (getFeedDataResponse.getFeedData().getItemListUploadStatus() != null) {
      // -----------------------------------------------
      // FeedDataService::downloadFeedDataUploadErrorFile
      // -----------------------------------------------
      if (getFeedDataResponse.getFeedData().getErrorListDownloadUrl() != null) {
        System.out.println("\n############################################");
        System.out.println("FeedDataService::downloadFeedDataUploadErrorFile");
        System.out.println("############################################");
        SoapUtils.download(getFeedDataResponse.getFeedData().getErrorListDownloadUrl(), "SampleFeedDataUploadErrorFile.zip");
      }

    } else {
      System.out.println("FeedDataUpload job in process on long time. please wait.");
    }
  }

  /**
   * display uploadUrlValue entity to stdout.
   *
   * @param uploadUrlValue UploadUrlValue entity for display.
   */
  private static void displayGetUploadUrlResponse(UploadUrlValue uploadUrlValue) {
    System.out.println("accountId = " + uploadUrlValue.getAccountId());
    System.out.println("itemListUploadType = " + uploadUrlValue.getItemListUploadType());
    System.out.println("feedHolderId = " + uploadUrlValue.getFeedHolderId());
    System.out.println("uploadUrl = " + uploadUrlValue.getUploadUrl());

    System.out.println("----------");
  }

  /**
   * display FeedDataRecord entity to stdout.
   *
   * @param feedDataRecord FeedDataRecord entity for display.
   */
  private static void display(FeedDataRecord feedDataRecord) {
    System.out.println("----------");
    System.out.println("accountId = " + feedDataRecord.getAccountId());
    System.out.println("feedHolderId = " + feedDataRecord.getFeedHolderId());
    System.out.println("itemListUploadId = " + feedDataRecord.getItemListUploadId());
    System.out.println("itemListUploadType = " + feedDataRecord.getItemListUploadType());
    System.out.println("itemListUploadStatus = " + feedDataRecord.getItemListUploadStatus());
    System.out.println("uploadDate = " + feedDataRecord.getUploadDate());
    System.out.println("errorCount = " + feedDataRecord.getErrorCount());
    System.out.println("errorListDownloadUrl = " + feedDataRecord.getErrorListDownloadUrl());

    System.out.println("----------");
  }
}
