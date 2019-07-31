/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.feature;

import jp.yahooapis.im.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.im.adapisample.basic.adgroupad.AdGroupAdServiceSample;
import jp.yahooapis.im.adapisample.basic.adgrouptarget.AdGroupTargetServiceSample;
import jp.yahooapis.im.adapisample.basic.campaign.CampaignServiceSample;
import jp.yahooapis.im.adapisample.basic.dictionary.DictionaryServiceSample;
import jp.yahooapis.im.adapisample.basic.placementurlidea.PlacementUrlIdeaServiceSample;
import jp.yahooapis.im.adapisample.basic.placementurllist.PlacementUrlListServiceSample;
import jp.yahooapis.im.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.im.adapisample.util.SoapUtils;
import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201907.adgroup.AdGroupOperation;
import jp.yahooapis.im.v201907.adgroup.AdGroupValues;
import jp.yahooapis.im.v201907.adgroupad.AdGroupAdOperation;
import jp.yahooapis.im.v201907.adgrouptarget.AdGroupTargetMutateOperation;
import jp.yahooapis.im.v201907.campaign.CampaignOperation;
import jp.yahooapis.im.v201907.campaign.CampaignType;
import jp.yahooapis.im.v201907.campaign.CampaignValues;
import jp.yahooapis.im.v201907.campaign.Operator;
import jp.yahooapis.im.v201907.dictionary.CategorySelector;
import jp.yahooapis.im.v201907.dictionary.CategoryValues;
import jp.yahooapis.im.v201907.placementurlidea.PlacementUrlIdeaSelector;
import jp.yahooapis.im.v201907.placementurlidea.PlacementUrlIdeaValues;
import jp.yahooapis.im.v201907.placementurllist.PlacementUrlListOperation;
import jp.yahooapis.im.v201907.placementurllist.PlacementUrlListValues;
import jp.yahooapis.im.v201907.placementurllist.UrlList;

import java.util.Arrays;
import java.util.List;

/**
 * example AdGroupTarget operation and Utility method collection.
 */
public class AdGroupTargetSample {

  /**
   * example AdGroupTarget operation.
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
          Operator.ADD, accountId, Arrays.asList(CampaignServiceSample.createExampleStandardCampaign())
      );
      List<CampaignValues> addResponseCampaign = CampaignServiceSample.mutate(addRequestCampaign);

      valuesHolder.setCampaignValuesList(addResponseCampaign);
      Long campaignId = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);

      // =================================================================
      // AdGroupService
      // =================================================================
      // ADD
      AdGroupOperation addRequestAdGroup = AdGroupServiceSample.buildExampleMutateRequest(
          jp.yahooapis.im.v201907.adgroup.Operator.ADD, accountId, Arrays.asList(AdGroupServiceSample.createExampleStandardAdGroup(campaignId))
      );
      List<AdGroupValues> addResponseAdGroup = AdGroupServiceSample.mutate(addRequestAdGroup);

      valuesHolder.setAdGroupValuesList(addResponseAdGroup);
      Long adGroupId = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignId);

      // =================================================================
      // PlacementUrlIdeaService
      // =================================================================
      // GET
      PlacementUrlIdeaSelector getRequestPlacementUrlIdea = PlacementUrlIdeaServiceSample.buildExampleGetRequest();
      List<PlacementUrlIdeaValues> getResponsePlacementUrlIdea = PlacementUrlIdeaServiceSample.get(getRequestPlacementUrlIdea);

      valuesHolder.setPlacementUrlIdeaValuesList(getResponsePlacementUrlIdea);
      List<UrlList> urlList = PlacementUrlListServiceSample.getUrlList(valuesHolder);

      // =================================================================
      // PlacementUrlListService
      // =================================================================
      // ADD
      PlacementUrlListOperation addRequestPlacementUrlList = PlacementUrlListServiceSample.buildExampleMutateRequest(
          jp.yahooapis.im.v201907.placementurllist.Operator.ADD, accountId, Arrays.asList(PlacementUrlListServiceSample.createExamplePlacementUrlList(urlList))
      );
      List<PlacementUrlListValues> addResponsePlacementUrlList = PlacementUrlListServiceSample.mutate(addRequestPlacementUrlList);

      valuesHolder.setPlacementUrlListValuesList(addResponsePlacementUrlList);

      // =================================================================
      // DictionaryService
      // =================================================================
      // GET
      CategorySelector getRequestDictionary = DictionaryServiceSample.buildExampleGetInterestCategoryRequest();
      List<CategoryValues> getResponseDictionary = DictionaryServiceSample.getInterestCategory(getRequestDictionary);

      // =================================================================
      // AdGroupTargetService
      // =================================================================
      // ADD
      AdGroupTargetMutateOperation addRequestAdGroupTarget = AdGroupTargetServiceSample.buildExampleMutateRequest(jp.yahooapis.im.v201907.adgrouptarget.Operator.ADD, accountId,
          Arrays.asList(
              AdGroupTargetServiceSample.createExamplePlacementTarget(campaignId, adGroupId, valuesRepositoryFacade.getPlacementUrlListValuesRepository().getPlacementUrlIdLists().get(0)),
              AdGroupTargetServiceSample.createExampleInterestCategoryTarget(campaignId, adGroupId, getResponseDictionary.get(0).getCategory().getChild().get(0).getCode()),
              AdGroupTargetServiceSample.createExampleAgeTarget(campaignId, adGroupId)
          )
      );
      AdGroupTargetServiceSample.mutate(addRequestAdGroupTarget);

      // =================================================================
      // AdGroupAdService
      // =================================================================
      // ADD
      AdGroupAdOperation addRequestAdGroupAd = AdGroupAdServiceSample.buildExampleMutateRequest(jp.yahooapis.im.v201907.adgroupad.Operator.ADD, accountId, Arrays.asList(
          AdGroupAdServiceSample.createExampleExtendedTextAd(campaignId, adGroupId)
      ));
      AdGroupAdServiceSample.mutate(addRequestAdGroupAd);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;

    } finally {
      // =================================================================
      // Cleanup
      // =================================================================
      PlacementUrlListServiceSample.cleanup(valuesHolder);
      AdGroupAdServiceSample.cleanup(valuesHolder);
    }
  }

}
