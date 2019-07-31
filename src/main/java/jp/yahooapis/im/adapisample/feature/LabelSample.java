/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.feature;

import jp.yahooapis.im.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.im.adapisample.basic.adgroupad.AdGroupAdServiceSample;
import jp.yahooapis.im.adapisample.basic.adgroupadlabel.AdGroupAdLabelServiceSample;
import jp.yahooapis.im.adapisample.basic.adgrouplabel.AdGroupLabelServiceSample;
import jp.yahooapis.im.adapisample.basic.campaign.CampaignServiceSample;
import jp.yahooapis.im.adapisample.basic.campaignlabel.CampaignLabelServiceSample;
import jp.yahooapis.im.adapisample.basic.label.LabelServiceSample;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201907.adgroup.AdGroupOperation;
import jp.yahooapis.im.v201907.adgroup.AdGroupSelector;
import jp.yahooapis.im.v201907.adgroup.AdGroupValues;
import jp.yahooapis.im.v201907.adgroupad.AdGroupAdOperation;
import jp.yahooapis.im.v201907.adgroupad.AdGroupAdSelector;
import jp.yahooapis.im.v201907.adgroupad.AdGroupAdValues;
import jp.yahooapis.im.v201907.adgroupad.AdType;
import jp.yahooapis.im.v201907.adgroupadlabel.AdGroupAdLabelOperation;
import jp.yahooapis.im.v201907.adgrouplabel.AdGroupLabelOperation;
import jp.yahooapis.im.v201907.campaign.CampaignOperation;
import jp.yahooapis.im.v201907.campaign.CampaignSelector;
import jp.yahooapis.im.v201907.campaign.CampaignType;
import jp.yahooapis.im.v201907.campaign.CampaignValues;
import jp.yahooapis.im.v201907.campaignlabel.CampaignLabelOperation;
import jp.yahooapis.im.v201907.label.LabelOperation;
import jp.yahooapis.im.v201907.label.LabelSelector;
import jp.yahooapis.im.v201907.label.LabelValues;
import jp.yahooapis.im.v201907.label.Operator;

import java.util.Arrays;
import java.util.List;

/**
 * example Label operation and Utility method collection.
 */
public class LabelSample {

  /**
   * example Label operation.
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

    try {
      // =================================================================
      // CampaignService
      // =================================================================
      // ADD
      CampaignOperation addRequestCampaign = CampaignServiceSample.buildExampleMutateRequest(
          jp.yahooapis.im.v201907.campaign.Operator.ADD,
          accountId,
          Arrays.asList(CampaignServiceSample.createExampleStandardCampaign())
      );
      List<CampaignValues> addResponseCampaign = CampaignServiceSample.mutate(addRequestCampaign);
      valuesRepositoryFacade.getValuesHolder().setCampaignValuesList(addResponseCampaign);
      Long campaignId = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);

      // GET
      CampaignSelector getRequestCampaign = CampaignServiceSample.buildExampleGetRequest(accountId, Arrays.asList(campaignId));
      getRequestCampaign.setContainsLabelIdFlg(true);
      CampaignServiceSample.get(getRequestCampaign);

      // =================================================================
      // AdGroupService
      // =================================================================
      // ADD
      AdGroupOperation addRequestAdGroup = AdGroupServiceSample.buildExampleMutateRequest(
          jp.yahooapis.im.v201907.adgroup.Operator.ADD,
          accountId,
          Arrays.asList(AdGroupServiceSample.createExampleStandardAdGroup(campaignId))
      );
      List<AdGroupValues> addResponseAdGroup = AdGroupServiceSample.mutate(addRequestAdGroup);
      valuesRepositoryFacade.getValuesHolder().setAdGroupValuesList(addResponseAdGroup);
      Long adGroupId = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignId);

      // GET
      AdGroupSelector getRequestAdGroup = AdGroupServiceSample.buildExampleGetRequest(accountId, valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroups());
      getRequestAdGroup.setContainsLabelIdFlg(true);
      AdGroupServiceSample.get(getRequestAdGroup);

      // =================================================================
      // AdGroupAdService
      // =================================================================
      // ADD
      AdGroupAdOperation addRequestAdGroupAd = AdGroupAdServiceSample.buildExampleMutateRequest(
          jp.yahooapis.im.v201907.adgroupad.Operator.ADD,
          accountId,
          Arrays.asList(AdGroupAdServiceSample.createExampleExtendedTextAd(campaignId, adGroupId))
      );
      List<AdGroupAdValues> addResponseAdGroupAd = AdGroupAdServiceSample.mutate(addRequestAdGroupAd);
      valuesRepositoryFacade.getValuesHolder().setAdGroupAdValuesList(addResponseAdGroupAd);
      Long adId = valuesRepositoryFacade.getAdGroupAdValuesRepository().findAdId(campaignId, adGroupId, AdType.TEXT_LONG_AD_1);

      // GET
      AdGroupAdSelector getRequestAdGroupAd = AdGroupAdServiceSample.buildExampleGetRequest(accountId, valuesRepositoryFacade.getAdGroupAdValuesRepository().getAdGroupAds());
      getRequestAdGroupAd.setContainsLabelIdFlg(true);
      AdGroupAdServiceSample.get(getRequestAdGroupAd);

      // =================================================================
      // LabelService
      // =================================================================
      // ADD
      LabelOperation addRequestLabel = LabelServiceSample.buildExampleMutateRequest(
          Operator.ADD,
          accountId,
          Arrays.asList(LabelServiceSample.createExampleLabel())
      );
      List<LabelValues> addResponseLabel = LabelServiceSample.mutate(addRequestLabel);
      valuesRepositoryFacade.getValuesHolder().setLabelValuesList(addResponseLabel);
      Long labelId = valuesRepositoryFacade.getLabelValuesRepository().getLabelIds().get(0);

      // SET
      LabelOperation setRequestLabel = LabelServiceSample.buildExampleMutateRequest(
          Operator.SET,
          accountId,
          LabelServiceSample.createExampleSetRequest(valuesRepositoryFacade.getLabelValuesRepository().getLabels())
      );
      LabelServiceSample.mutate(setRequestLabel);

      // GET
      LabelSelector getRequestLabel = LabelServiceSample.buildExampleGetRequest(accountId, valuesRepositoryFacade.getLabelValuesRepository().getLabelIds());
      LabelServiceSample.get(getRequestLabel);

      // =================================================================
      // CampaignLabelService
      // =================================================================
      // ADD
      CampaignLabelOperation addRequestCampaignLabel = CampaignLabelServiceSample.buildExampleMutateRequest(
          jp.yahooapis.im.v201907.campaignlabel.Operator.ADD,
          accountId,
          Arrays.asList(CampaignLabelServiceSample.createExampleCampaignLabel(campaignId, labelId))
      );
      CampaignLabelServiceSample.mutate(addRequestCampaignLabel);

      // =================================================================
      // CampaignService
      // =================================================================
      // GET
      CampaignServiceSample.get(getRequestCampaign);

      // =================================================================
      // AdGroupLabelService
      // =================================================================
      // ADD
      AdGroupLabelOperation addRequestAdGroupLabel = AdGroupLabelServiceSample.buildExampleMutateRequest(
          jp.yahooapis.im.v201907.adgrouplabel.Operator.ADD,
          accountId,
          Arrays.asList(AdGroupLabelServiceSample.createExampleAdGroupLabel(campaignId, adGroupId, labelId))
      );
      AdGroupLabelServiceSample.mutate(addRequestAdGroupLabel);

      // =================================================================
      // AdGroupService
      // =================================================================
      // GET
      AdGroupServiceSample.get(getRequestAdGroup);

      // =================================================================
      // AdGroupAdLabelService
      // =================================================================
      // ADD
      AdGroupAdLabelOperation addRequestAdGroupAdLabel = AdGroupAdLabelServiceSample.buildExampleMutateRequest(
          jp.yahooapis.im.v201907.adgroupadlabel.Operator.ADD,
          accountId,
          Arrays.asList(AdGroupAdLabelServiceSample.createExampleAdGroupAdLabel(campaignId, adGroupId, adId, labelId))
      );
      AdGroupAdLabelServiceSample.mutate(addRequestAdGroupAdLabel);

      // =================================================================
      // AdGroupAdService
      // =================================================================
      // GET
      AdGroupAdServiceSample.get(getRequestAdGroupAd);

      // =================================================================
      // LabelService
      // =================================================================
      // GET
      LabelServiceSample.get(getRequestLabel);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;

    } finally {
      LabelServiceSample.cleanup(valuesHolder);
      AdGroupAdServiceSample.cleanup(valuesHolder);
    }
  }

}
