--------------------------------
NOTICE：　Yahoo! Promotional Ads API - For use of sample code
--------------------------------

The sample code of Yahoo! Promotional Ads API is provided to API users only who concluded the contract of "Application to Use Yahoo! Promotional Ads API" with Yahoo Japan Corporation. 

Additionally, please note before using it that Yahoo Japan Corporation may change the contents and the specification of the sample code, and may discontinue providing the sample code without any notice.


--------------------------------
<<Version>>
--------------------------------
Ver.201806

[Update history]
-----------
2018/06/20:
- V201806 Add

2017/10/25
 - V6.1 Correspond to Mobile App campaign.
 - V6.1 Correspond to specification of bid multiplier of AdGroupTargetService on AdSample.
 - V6.1 Added report download url to response of ADD of ReportDownloadSample.
 - V6.1 Added Get operation for OS version data, image format data for ads via DictionaryService on DictionarySample.

2017/05/24:
- V6.0 Added VideoSample.
- V6.0 Correspond to Yahoo! DMP.

2016/08/31:
- V5.4 Correspond to Search Targeting (Search Recency/Frequency).
- V5.4 Correspond to specification of multiple campaigns/ad groups of AdGroupAdService on AdSample.

2016/04/20:
- Added V5.3 AuditLogDownloadSample and StatsSample.

2015/11/18:
- V5.2 Correspond to Carrier Targeting.
- V5.2 Added RetargetingSample.

2015/08/05:
- V5.1 Renew the Report API.

2015/04/15:
- V5.0 Correspond to Infeed Ad.

2014/09/04:
- V4.7 Correspond to Dynamic Image Extensions.
- V4.7 Correspond to Converison tracker.

2014/03/26:
- V4.6 Correspond to Placement Targeting.

2014/02/07
- V4.6 Added Similar User Targeting.
- V4.6 Added Segment Targeting.
- V4.6 Added Frequency Control.
- V4.6 Added Frequency Report.

2013/09/04
- V4 Added AccountAdProductSample, DictionarySample, SearchKeywordSample.
- Changed to JAX-WS for Soap api library.

2013/05/28:
- V4 Correspond to Site Retargeting.

2013/02/27:
- V4 Added bid to AdSample / MediaSample of AdGroupAdService.
- V4 Added Image condition to getBulkDownload of BulkDownloadSample.
- V4 Added Image transactions to response of getBulkUploadStatus of BulkUploadSample.
- V4 Correspond to ReportDownloadSample as scheduled Report.

2012/12/03:
- V4 Correspond to Image (media) display.

2012/10/09:
- V4 Correspond to BulkService upload.

2012/09/19:
- V4 Correspond to BulkService download.

2012/09/05:
- V4 Correspond to API.

2012/04/17:
- Changed the Production LOCATION setting of conf/api_config.php as: "location.im.yahooapis.jp".


--------------------------------
<<Overview>>
--------------------------------
This sample program uses Java to call each services in API.
API is called by using JAX-WS.


--------------------------------
<<Contents>>
--------------------------------
[bin directory]
The compiled execute file of sample program and the batch file to excecute on Windows are stored.

- run_sample.bat                 : It is the batch file in order to execute the Sample program on Windows.
- ad-api-Sample-IM-api-V6.0.jar  : It is the jar files that packed the compiled Sample program.

[src/main/java directory]
The following programs are stored.

* Sample programs can be executed directly.

- Under jp/co/yahoo/ad_api_sample directory
- AccountAdProductSample/AccountAdProductSample.java   : Sample of Get operation for account ad product via AccountAdProductService.
- accountSample/AccountSample.java                     : Sample of account browse and update via AccountService.
- AdSample/AdGroupAdServiceSample.java                 : Sample of Get and Mutate operation for account information via AdGroupAdService.
- AdSample/AdGroupServiceSample.java                   : Sample of Get and Mutate operation for account information via AdGroupService.
- AdSample/AdSample.java                               : Sample of ad creation via CampaignService/AdGroupService/AdGroupAdService/AdGroupTargetService.
- AdSample/CampaignServiceSample.java                  : Sample of Get and Mutate operation via CampaignService.
- AuditLogDownloadSample/AuditLogDownloadSample.java   : Sample of download operation history log via AuditLogService.
- balanceSample/BalanceSample.java                     : Sample of Get operation for account balance via BalanceService.
- bulkDownloadSample/BulkDownloadSample.java           : Sample of download process via BulkService.
- bulkUploadSample/BulkUploadSample.java               : Sample of upload process via BulkService.
- conversionTrackerSample/ConversionTrackerSample.java : Sample of Get and Mutate operation for conversion information via ConversionTrackerService.
- dictionarySample.DictionarySample.java               : Sample of Get operation for LOCATION data, rejected reasons, target setting data, OS version data, image format data for ads via DictionaryService.
- MediaSample/MediaSample.java                         : Sample of ad creation of Image ads, which MediaService Added to AdSample.java
- placementUrlSample/PlacementUrlSample.java           : Sample of Placement Targeting via PlacementUrlIdeaService and PlacementUrlListService.
- ReportDownloadSample/ReportDownloadSample.java       : Sample of Report download via ReportDefinitionService and ReportService.
- retargetingSample/RetargetingSample.java             : Sample of Retargeting via RetargetingTagService and RetargetingListService.
- searchKeywordSample/SearchKeywordSample.java         : Sample of Search Targeting via SearchKeywordIdeaService and SearchKeywordListService.
- statsSample/StatsSample.java                         : Sample of Get operation for Analytics data via StatsService.
- videoSample/VideoSample.java                         : Sample of ad creation of Video ads, which VideoService Added to AdSample.java

* Class is called from sample programs.

- SoapUtils.java              : Sample and other common process of Get operation request via LocationService.
- Under jp/yahooapis/IM/V6    : Stubs and the skelton classes generated by WSDL using JAX-WS.

[src/main/resource directory]
The following contents are stored.
- api_config.properties: Config file describes each ID.

[src/test/java directory]
The following programs are stored.

* Sample programs can be executed directly.

- Under jp/co/yahoo/ad_api_sample
- AccountAdProductSample/AccountAdProductSampleTest.java   : Test case of Get operation for account ad product via AccountAdProductService.
- accountSample/AccountSampleTest.java                     : Test case of account browse and update via AccountService.
- AdSample/AdGroupAdServiceSampleTest.java                 : Test case of Get and Mutate operation for account information via AdGroupAdService.
- AdSample/AdGroupServiceSampleTest.java                   : Test case of Get and Mutate operation for account information via AdGroupService.
- AdSample/AdSampleTest.java                               : Test case of ad creation via CampaignService/AdGroupService/AdGroupAdService/AdGroupTargetService.
- AdSample/CampaignServiceSampleTest.java                  : Test case of Get and Mutate operation for campaign information via CampaignService.
- AuditLogDownloadSample/AuditLogDownloadSampleTest.java   : Test case of download operation history log via AuditLogService.
- balanceSample/BalanceSampleTest.java                     : Test case of Get operation for account balance via BalanceService.
- bulkDownloadSample/BulkDownloadSampleTest.java           : Test case of download process via BulkService.
- bulkUploadSample/BulkUploadSampleTest.java               : Test case of upload process via BulkService.
- conversionTrackerSample/ConversionTrackerSampleTest.java : Test case of Get and Mutate operation for conversion information via ConversionTrackerService.
- dictionarySample.DictionarySampleTest.java               : Test case of Get operation for LOCATION data, rejected reasons, target setting data, OS version data, image format data for ads via DictionaryService.
- MediaSample/MediaSampleTest.java                         : Test case of ad creation of Image ads, which MediaService Added to AdSample.java.
- placementUrlSample/PlacementUrlSampleTest.java           : Test case of Placement Targeting via PlacementUrlIdeaService and PlacementUrlListService.
- ReportDownloadSample/ReportDownloadSampleTest.java       : Test case of Report download via ReportDefinitionService and ReportService.
- retargetingSample/RetargetingSampleTest.java             : Test case of Retargeting via RetargetingTagService and RetargetingListService.
- searchKeywordSample/SearchKeywordSampleTest.java         : Test case of Search Targeting via SearchKeywordIdeaService and SearchKeywordListService.
- statsSample/StatsSampleTest.java                         : Test case of Get operation for Analytics data via StatsService.
- statsSample/StatsSampleTest.java                         : Test case of ad creation of Video ads, which VideoService Added to AdSample.java.

[download directory]
It stores the downloded file when you execute ReportDownloadSample, BulkDownloadSample, BulkUploadSample or AuditLogDownloadSample.

[upload directory]
It stores the upload file when you execute MediaSample, BulkUploadSample or VideoSample.


--------------------------------
<<Preparation>>
--------------------------------
Please install the following to build operation environment for Java.

[Java 1.8(Java SE Development Kit 8)]
http://www.oracle.com/technetwork/java/javase/downloads/index.html

Please install the following to build operation environment for Maven.

[Apache Maven 3.1.1]
https://maven.apache.org/download.cgi


Describe the authentication information of api_config.properties under the conf directory.
LOCATION            : Comment out the unnecessary line.
LICENSE             : Enter API license (Required)
APIACCOUNTID        : Enter API Account ID (Required)
APIACCOUNTPASSWORD  : Enter API Account password (Required)
ONBEHALFOFACCOUNTID : Enter Application Account ID (Optional)
ONBEHALFOFPASSWORD  : Enter Application Account password (Optional)
ACCOUNTID           : Enter Account ID (Required)

The following IDs are required for AdGroupAdSample and StatsSample.
CAMPAIGNID          : Enter Campaign ID (Required)
ADGROUPID           : Enter Ad Group ID (Required)

The following IDs are required for StatsSample.
ADID                : Enter Ad ID (Required)
MEDIAID             : Enter Media ID (Required)


--------------------------------
<<Execution>>
--------------------------------
set SAMPLE_HOME={ad-api-sample}
set PACKAGE_NAME=jp.co.yahoo.ad_api_sample
set CLASS_PATH=%SAMPLE_HOME%\bin\ad-api-sample-IM-API-V201806.jar;%SAMPLE_HOME%;%SAMPLE_HOME%\src\main\resources

[e.g.]
---------------------------------------
java -classpath %CLASS_PATH% %PACKAGE_NAME%.accountAdProductSample/AccountAdProductSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.accountSample/AccountSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adSample/AdGroupAdServiceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adSample/AdGroupServiceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adSample/AdSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adSample/CampaignServiceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.auditLogDownloadSample/AuditLogDownloadSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.balanceSample/BalanceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.bulkDownloadSample/BulkDownloadSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.bulkUploadSample/BulkUploadSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.conversionTrackerSample/ConversionTrackerSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.dictionarySample.DictionarySample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.mediaSample/MediaSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.placementUrlSample/PlacementUrlSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.reportDownloadSample/ReportDownloadSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.retargetingSample/RetargetingSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.searchKeywordSample/SearchKeywordSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.statsSample/StatsSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.videoSample/VideoSample
---------------------------------------

When data download is executed, the file will be stored to the download directory.

When uploading the data is executed, please store the file you want to upload under the upload directory.
File name is fixed in each sample program.

 - In case of MediaSample       : SampleMedia.jpg
 - In case of BulkUploadSample  : SampleBulkUpload.csv
 - In case of VideoSample       : SampleVideoUpload.mp4
