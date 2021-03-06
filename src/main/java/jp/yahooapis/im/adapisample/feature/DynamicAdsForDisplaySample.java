/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.feature;

import jp.yahooapis.im.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.im.adapisample.basic.adgroupad.AdGroupAdServiceSample;
import jp.yahooapis.im.adapisample.basic.campaign.CampaignServiceSample;
import jp.yahooapis.im.adapisample.basic.feeddata.FeedDataServiceSample;
import jp.yahooapis.im.adapisample.basic.feedholder.FeedHolderServiceSample;
import jp.yahooapis.im.adapisample.basic.feedset.FeedSetServiceSample;
import jp.yahooapis.im.adapisample.basic.media.MediaServiceSample;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201911.adgroup.AdGroupOperation;
import jp.yahooapis.im.v201911.adgroup.AdGroupValues;
import jp.yahooapis.im.v201911.adgroupad.AdGroupAdOperation;
import jp.yahooapis.im.v201911.adgroupad.AdGroupAdValues;
import jp.yahooapis.im.v201911.campaign.CampaignOperation;
import jp.yahooapis.im.v201911.campaign.CampaignType;
import jp.yahooapis.im.v201911.campaign.CampaignValues;
import jp.yahooapis.im.v201911.feeddata.UploadUrlValue;
import jp.yahooapis.im.v201911.feedholder.FeedHolderOperation;
import jp.yahooapis.im.v201911.feedholder.FeedHolderValues;
import jp.yahooapis.im.v201911.feedset.FeedSetOperation;
import jp.yahooapis.im.v201911.feedset.FeedSetValues;
import jp.yahooapis.im.v201911.media.LogoFlg;
import jp.yahooapis.im.v201911.media.MediaOperation;
import jp.yahooapis.im.v201911.media.MediaValues;
import jp.yahooapis.im.v201911.media.Operator;
import jp.yahooapis.im.v201911.media.ThumbnailFlg;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;


/**
 * example DynamicAdsForDisplay operation and Utility method collection.
 */
public class DynamicAdsForDisplaySample {

  /**
   * example DynamicAdsForDisplay operation.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {

    // =================================================================
    // Setting
    // =================================================================
    ValuesHolder valuesHolder = new ValuesHolder();
    ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
    long accountId = SoapUtils.getAccountId();

    String fileName = "feedDataUploadSample.zip";

    try {
      // =================================================================
      // FeedHolderService
      // =================================================================
      // ADD
      FeedHolderOperation addRequestFeedHolder = FeedHolderServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.im.v201911.feedholder.Operator.ADD, accountId, //
          Collections.singletonList(FeedHolderServiceSample.createExampleFeedHolderRecordRequest(accountId)) //
      );
      List<FeedHolderValues> addResponseFeedHolder = FeedHolderServiceSample.mutate(addRequestFeedHolder);
      valuesHolder.setFeedHolderValuesList(addResponseFeedHolder);
      Long feedHolderId = valuesRepositoryFacade.getFeedHolderValuesRepository().getFeedHolderIds().get(0);

      // =================================================================
      // FeedDataService
      // =================================================================
      // getUploadUrl
      UploadUrlValue getUploadUrlResponse = FeedDataServiceSample.getUploadUrl(accountId, feedHolderId);
      String uploadUrl = getUploadUrlResponse.getUploadUrl();

      // upload
      String uploadResponse = SoapUtils.upload(uploadUrl, fileName, "application/zip");
      long itemListUploadId = -1;
      Document responseDOM = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(uploadResponse)));
      NodeList nodeList = responseDOM.getElementsByTagName("itemListUploadId");
      if (nodeList.getLength() > 0) {
        itemListUploadId = Long.parseLong(nodeList.item(0).getFirstChild().getNodeValue());
      } else {
        throw new RuntimeException("Fail to upload to FeedData. response=" + uploadResponse);
      }

      // check job status
      FeedDataServiceSample.checkUploadStatus(Collections.singletonList(feedHolderId), Collections.singletonList(itemListUploadId));

      // =================================================================
      // FeedSetService
      // =================================================================
      // ADD
      FeedSetOperation addRequest = FeedSetServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.im.v201911.feedset.Operator.ADD, accountId, //
          Collections.singletonList(FeedSetServiceSample.createExampleFeedSet(feedHolderId)) //
      );
      List<FeedSetValues> addResponse = FeedSetServiceSample.mutate(addRequest);
      Long feedSetId = addResponse.get(0).getFeedSet().getFeedSetId();

      // =================================================================
      // MediaService
      // =================================================================
      List<Long> mediaIds = new ArrayList<>();

      // ADD(Logo1)
      MediaOperation addRequestMedia1 = MediaServiceSample.buildExampleMutateRequest( //
          Operator.ADD, accountId, //
          Collections.singletonList(MediaServiceSample.createExampleMedia(accountId, "LogoMedia1.jpg", LogoFlg.TRUE, ThumbnailFlg.FALSE)) //
      );
      List<MediaValues> addResponseMedia1 = MediaServiceSample.mutate(addRequestMedia1);
      valuesHolder.setMediaValuesList(addResponseMedia1);
      mediaIds.add(addResponseMedia1.get(0).getMediaRecord().getMediaId());

      // ADD(Logo2)
      MediaOperation addRequestMedia2 = MediaServiceSample.buildExampleMutateRequest( //
          Operator.ADD, accountId, //
          Collections.singletonList(MediaServiceSample.createExampleMedia(accountId, "LogoMedia2.jpg", LogoFlg.TRUE, ThumbnailFlg.FALSE)) //
      );
      List<MediaValues> addResponseMedia2 = MediaServiceSample.mutate(addRequestMedia2);
      valuesHolder.setMediaValuesList(addResponseMedia2);
      mediaIds.add(addResponseMedia2.get(0).getMediaRecord().getMediaId());

      // ADD(Logo3)
      MediaOperation addRequestMedia3 = MediaServiceSample.buildExampleMutateRequest( //
          Operator.ADD, accountId, //
          Collections.singletonList(MediaServiceSample.createExampleMedia(accountId, "LogoMedia3.jpg", LogoFlg.TRUE, ThumbnailFlg.FALSE)) //
      );
      List<MediaValues> addResponseMedia3 = MediaServiceSample.mutate(addRequestMedia3);
      valuesHolder.setMediaValuesList(addResponseMedia3);
      mediaIds.add(addResponseMedia3.get(0).getMediaRecord().getMediaId());

      // sleep 60 second.
      System.out.println("\n***** sleep 60 seconds *****\n");
      Thread.sleep(60000);

      // =================================================================
      // CampaignService
      // =================================================================
      // ADD
      CampaignOperation addRequestCampaign = CampaignServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.im.v201911.campaign.Operator.ADD, accountId, //
          Collections.singletonList(CampaignServiceSample.createExampleDynamicAdsForDisplayCampaign(feedHolderId)) //
      );
      List<CampaignValues> addResponseCampaign = CampaignServiceSample.mutate(addRequestCampaign);
      valuesRepositoryFacade.getValuesHolder().setCampaignValuesList(addResponseCampaign);
      Long campaignId = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);

      // =================================================================
      // AdGroupService
      // =================================================================
      // ADD
      AdGroupOperation addRequestAdGroup = AdGroupServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.im.v201911.adgroup.Operator.ADD, accountId, //
          Collections.singletonList(AdGroupServiceSample.createExampleStandardAdGroup(campaignId)) //
      );
      addRequestAdGroup.getOperand().get(0).setFeedSetId(feedSetId);
      List<AdGroupValues> addResponseAdGroup = AdGroupServiceSample.mutate(addRequestAdGroup);
      valuesRepositoryFacade.getValuesHolder().setAdGroupValuesList(addResponseAdGroup);
      Long adGroupId = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignId);

      // =================================================================
      // AdGroupAdService
      // =================================================================
      // ADD
      AdGroupAdOperation addRequestAdGroupAd = AdGroupAdServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.im.v201911.adgroupad.Operator.ADD, accountId, //
          Collections.singletonList(AdGroupAdServiceSample.createExampleDynamicAd(campaignId, adGroupId, mediaIds)) //
      );
      List<AdGroupAdValues> addResponseAdGroupAd = AdGroupAdServiceSample.mutate(addRequestAdGroupAd);
      valuesRepositoryFacade.getValuesHolder().setAdGroupAdValuesList(addResponseAdGroupAd);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;

    } finally {
      MediaServiceSample.cleanup(valuesHolder);
      CampaignServiceSample.cleanup(valuesHolder);
      FeedHolderServiceSample.cleanup(valuesHolder);
    }
  }
}
