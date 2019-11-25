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
import jp.yahooapis.im.v201911.adgroup.AdGroupOperation;
import jp.yahooapis.im.v201911.adgroup.AdGroupValues;
import jp.yahooapis.im.v201911.adgroupad.AdGroupAdOperation;
import jp.yahooapis.im.v201911.adgrouptarget.AdGroupTargetMutateOperation;
import jp.yahooapis.im.v201911.campaign.CampaignOperation;
import jp.yahooapis.im.v201911.campaign.CampaignType;
import jp.yahooapis.im.v201911.campaign.CampaignValues;
import jp.yahooapis.im.v201911.campaign.Operator;
import jp.yahooapis.im.v201911.dictionary.AudienceCategoryValues;
import jp.yahooapis.im.v201911.dictionary.CategorySelector;
import jp.yahooapis.im.v201911.dictionary.CategoryValues;
import jp.yahooapis.im.v201911.placementurlidea.PlacementUrlIdeaSelector;
import jp.yahooapis.im.v201911.placementurlidea.PlacementUrlIdeaValues;
import jp.yahooapis.im.v201911.placementurllist.PlacementUrlListOperation;
import jp.yahooapis.im.v201911.placementurllist.PlacementUrlListValues;
import jp.yahooapis.im.v201911.placementurllist.UrlList;

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
          Operator.ADD, accountId, Arrays.asList(CampaignServiceSample.createExampleStandardCampaign(), CampaignServiceSample.createExampleCampaignByCampaignGoal())
      );
      List<CampaignValues> addResponseCampaign = CampaignServiceSample.mutate(addRequestCampaign);

      valuesHolder.setCampaignValuesList(addResponseCampaign);
      List<Long> campaignIds = valuesRepositoryFacade.getCampaignValuesRepository().getCampaignIds();

      // =================================================================
      // AdGroupService
      // =================================================================
      // ADD
      AdGroupOperation addRequestAdGroup = AdGroupServiceSample.buildExampleMutateRequest(
          jp.yahooapis.im.v201911.adgroup.Operator.ADD, accountId, Arrays.asList(AdGroupServiceSample.createExampleStandardAdGroup(campaignIds.get(0)), AdGroupServiceSample.createExampleAdGroupByCampaignGoal(campaignIds.get(1)))
      );
      List<AdGroupValues> addResponseAdGroup = AdGroupServiceSample.mutate(addRequestAdGroup);

      valuesHolder.setAdGroupValuesList(addResponseAdGroup);
      List<Long> adGroupIds = valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroupIds();

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
          jp.yahooapis.im.v201911.placementurllist.Operator.ADD, accountId, Arrays.asList(PlacementUrlListServiceSample.createExamplePlacementUrlList(urlList))
      );
      List<PlacementUrlListValues> addResponsePlacementUrlList = PlacementUrlListServiceSample.mutate(addRequestPlacementUrlList);

      valuesHolder.setPlacementUrlListValuesList(addResponsePlacementUrlList);

      // =================================================================
      // DictionaryService
      // =================================================================
      // GET
      CategorySelector getRequestDictionary = DictionaryServiceSample.buildExampleGetInterestCategoryRequest();
      List<CategoryValues> getResponseDictionary = DictionaryServiceSample.getInterestCategory(getRequestDictionary);
      List<AudienceCategoryValues> getResponseDictionary2 = DictionaryServiceSample.getAudienceCategory(getRequestDictionary);

      // =================================================================
      // AdGroupTargetService
      // =================================================================
      // ADD
      AdGroupTargetMutateOperation addRequestAdGroupTarget = AdGroupTargetServiceSample.buildExampleMutateRequest(jp.yahooapis.im.v201911.adgrouptarget.Operator.ADD, accountId,
          Arrays.asList(
              AdGroupTargetServiceSample.createExamplePlacementTarget(campaignIds.get(0), adGroupIds.get(0), valuesRepositoryFacade.getPlacementUrlListValuesRepository().getPlacementUrlIdLists().get(0)),
              AdGroupTargetServiceSample.createExampleInterestCategoryTarget(campaignIds.get(0), adGroupIds.get(0), getResponseDictionary.get(0).getCategory().getChild().get(0).getCode()),
              AdGroupTargetServiceSample.createExampleAgeTarget(campaignIds.get(0), adGroupIds.get(0)),
              AdGroupTargetServiceSample.createExampleAudienceCategoryTarget(campaignIds.get(1), adGroupIds.get(1), getResponseDictionary2.get(0).getCategory().getCode())
          )
      );
      AdGroupTargetServiceSample.mutate(addRequestAdGroupTarget);

      // =================================================================
      // AdGroupAdService
      // =================================================================
      // ADD
      AdGroupAdOperation addRequestAdGroupAd = AdGroupAdServiceSample.buildExampleMutateRequest(jp.yahooapis.im.v201911.adgroupad.Operator.ADD, accountId, Arrays.asList(
          AdGroupAdServiceSample.createExampleExtendedTextAd(campaignIds.get(0), adGroupIds.get(0))
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
