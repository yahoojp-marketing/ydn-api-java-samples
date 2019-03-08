/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.basic.feeddata;

import jp.yahooapis.im.adapisample.basic.feedholder.FeedHolderServiceSample;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201903.Error;
import jp.yahooapis.im.v201903.Paging;
import jp.yahooapis.im.v201903.feeddata.FeedDataPage;
import jp.yahooapis.im.v201903.feeddata.FeedDataSelector;
import jp.yahooapis.im.v201903.feeddata.FeedDataService;
import jp.yahooapis.im.v201903.feeddata.FeedDataServiceInterface;
import jp.yahooapis.im.v201903.feeddata.FeedDataValues;
import jp.yahooapis.im.v201903.feeddata.FileUploadDateRange;
import jp.yahooapis.im.v201903.feeddata.FileUploadStatus;
import jp.yahooapis.im.v201903.feeddata.ItemListUploadType;
import jp.yahooapis.im.v201903.feeddata.UploadUrlValue;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.ws.Holder;

/**
 * example FeedDataService operation and Utility method collection.
 */
public class FeedDataServiceSample {

  /**
   * example FeedDataService operation.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    // =================================================================
    // Setting
    // =================================================================
    ValuesHolder valuesHolder = new ValuesHolder();
    long accountId = SoapUtils.getAccountId();

    try {
      // =================================================================
      // check & create upper service object.
      // =================================================================
      valuesHolder = setup();
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      Long feedHolderId = valuesRepositoryFacade.getFeedHolderValuesRepository().getFeedHolderIds().get(0);

      String fileName = "feedDataUploadSample.zip";

      // =================================================================
      // FeedDataService getUploadUrl
      // =================================================================
      UploadUrlValue getUploadUrlResponse = getUploadUrl(accountId, feedHolderId);
      String uploadUrl = getUploadUrlResponse.getUploadUrl();

      //=================================================================
      // FeedDataService upload (http request)
      //=================================================================
      // run
      String uploadResponse = SoapUtils.upload(uploadUrl, fileName, "application/zip");
      long itemListUploadId = -1;
      Document responseDOM = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(uploadResponse)));
      NodeList nodeList = responseDOM.getElementsByTagName("itemListUploadId");
      if (nodeList.getLength() > 0) {
        itemListUploadId = Long.parseLong(nodeList.item(0).getFirstChild().getNodeValue());
      } else {
        throw new RuntimeException("Fail to upload to FeedData. response=" + uploadResponse);
      }

      // =================================================================
      // FeedDataService getUploadStatus
      // =================================================================
      // create request.
      FeedDataSelector getUploadStatusRequest = buildExampleGetUploadStatusRequest(accountId, Collections.singletonList(feedHolderId), Collections.singletonList(itemListUploadId));

      // run
      getUploadStatus(getUploadStatusRequest);

      // check job status
      checkUploadStatus(Collections.singletonList(feedHolderId), Collections.singletonList(itemListUploadId));

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
   * example getUploadUrl FeedData.
   *
   * @param accountId    long
   * @param feedHolderId long
   * @return UploadUrlValue
   */
  public static UploadUrlValue getUploadUrl(long accountId, long feedHolderId) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("FeedDataService::getUploadUrl");
    System.out.println("############################################");

    Holder<UploadUrlValue> getUploadUrlValueHolder = new Holder<UploadUrlValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedDataServiceInterface feedDataService = SoapUtils.createServiceInterface(FeedDataServiceInterface.class, FeedDataService.class);
    feedDataService.getUploadUrl(accountId, ItemListUploadType.UPDATE_ALL, feedHolderId, getUploadUrlValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder);

    return getUploadUrlValueHolder.value;
  }

  /**
   * Sample Program for FeedDataService GetUploadStatus.
   *
   * @param selector FeedDataSelector
   * @return FeedDataValues
   */
  public static List<FeedDataValues> getUploadStatus(FeedDataSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("FeedDataService::getUploadStatus");
    System.out.println("############################################");

    Holder<FeedDataPage> feedDataPageHolder = new Holder<FeedDataPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedDataServiceInterface feedDataService = SoapUtils.createServiceInterface(FeedDataServiceInterface.class, FeedDataService.class);
    feedDataService.getUploadStatus(selector, feedDataPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, feedDataPageHolder.value.getValues());

    // Response
    return feedDataPageHolder.value.getValues();
  }

  /**
   * example check Bulk Upload job status.
   *
   * @param feedHolderIds     List<Long>
   * @param itemListUploadIds List<Long>
   */
  public static void checkUploadStatus(List<Long> feedHolderIds, List<Long> itemListUploadIds) throws Exception {

    // call 30sec sleep * 30 = 15minute
    for (int i = 0; i < 30; i++) {

      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds for FeedData Upload Job *****\n");
      Thread.sleep(30000);

      // get
      FeedDataSelector getRequest = buildExampleGetUploadStatusRequest(SoapUtils.getAccountId(), feedHolderIds, itemListUploadIds);
      List<FeedDataValues> getResponse = getUploadStatus(getRequest);

      int completedCount = 0;

      // upload job check.
      for (FeedDataValues feedDataValues : getResponse) {
        FileUploadStatus fileUploadStatus = feedDataValues.getFeedData().getItemListUploadStatus();
        if (fileUploadStatus == null) {
          throw new Exception("Fail to getUploadStatus FeedDataService.");
        }

        // error file download.
        if (feedDataValues.getFeedData().getErrorListDownloadUrl() != null) {
          SoapUtils.download(feedDataValues.getFeedData().getErrorListDownloadUrl(), "SampleFeedDataUploadErrorFile.zip");
        }

        switch (feedDataValues.getFeedData().getItemListUploadStatus()) {
          default:
          case FILE_FORMAT_ERROR:
          case SYSTEM_ERROR:
            throw new Exception("check upload Status failed.");
          case UPLOADED:
            continue;
          case COMPLETED:
            completedCount++;
            continue;
        }
      }

      if (getResponse.size() == completedCount) {
        return;
      }
    }

    throw new Exception("Fail to getUploadStatus FeedDataService.");
  }

  /**
   * example getUploadStatus request.
   *
   * @param accountId         long
   * @param feedHolderIds     List<Long>
   * @param itemListUploadIds List<Long>
   * @return getUploadStatus
   */
  public static FeedDataSelector buildExampleGetUploadStatusRequest(long accountId, List<Long> feedHolderIds, List<Long> itemListUploadIds) {
    FeedDataSelector selector = new FeedDataSelector();
    selector.setAccountId(accountId);
    selector.getFeedHolderIds().addAll(feedHolderIds);
    selector.getItemListUploadIds().addAll(itemListUploadIds);

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

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   */
  private static ValuesHolder setup() throws Exception {
    return FeedHolderServiceSample.create();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    FeedHolderServiceSample.cleanup(valuesHolder);
  }
}
