--------------------------------
ご注意：　Yahoo!プロモーション広告API - サンプルコードの利用に関して
--------------------------------

Yahoo! JAPANの提供するAPIに関するサンプルコードは、別途Yahoo! JAPANとの間で締結いただいた当該APIの提供に関する契約に基づき、APIユーザー様に提供されるものであり、Yahoo! JAPANとの間で当該契約を締結いただいていない場合は、サンプルコードをご利用いただけません。 
また、APIユーザー様に予め通知することなく、サンプルコードの内容や仕様の変更または提供の停止もしくは中止をする場合がありますので、予めご了承のうえご利用ください。


--------------------------------
【バージョン】
--------------------------------
Ver.6.0.0

■変更履歴
-----------
2017/05/24:
- V6.0 VideoSampleを追加しました。
- V6.0 Yahoo! DMPに対応しました。

2016/08/31:
- V5.4 検索リーセンシー・フリークエンシー(サーチターゲティング)に対応しました。
- V5.4 AdSampleにてAdGroupAdServiceのキャンペーン、広告グループ複数指定に対応しました。

2016/04/20:
- V5.3 AuditLogDownloadSample、StatsSampleを追加しました。

2015/11/18:
- V5.2 キャリアターゲティングに対応しました。
- V5.2 RetargetingSampleを追加しました。

2015/08/05:
- V5.1 レポート機能を刷新致しました。

2015/04/15:
- V5.0 インフィード広告に対応しました。

2014/09/04:
- V4.7 クリエイティブ最適化オプションに対応しました。
- V4.7 コンバージョントラッカーに対応しました。

2014/03/26:
- V4.6 プレイスメントターゲティングに対応しました。

2014/02/07：
- V4.6 類似ユーザターゲティングを追加しました。
- V4.6 セグメントターゲティングを追加しました。
- V4.6 フリークエンシ・コントロールを追加しました。
- V4.6 リーチフリークエンシレポートを追加しました。

2013/09/04:
- AccountAdProductSample, DictionarySample, SearchKeywordSampleを追加しました。
- Soap APIライブラリをJAX-WSに変更しました。

2013/05/28:
- V4 サイトリターゲティングに対応しました。

2013/02/27:
- V4 AdSample / MediaSampleのAdGroupAdServiceにbidを追加しました。
- V4 BulkDownloadSampleのgetBulkDownloadに画像の抽出条件を追加しました。
- V4 BulkUploadSampleのgetBulkUploadStatusのレスポンスに画像の処理件数を追加しました。
- V4 ReportDownloadSampleについて定期レポートに対応しました。

2012/12/03:
- V4 画像配信に対応しました。

2012/10/09:
- V4 BulkServiceのアップロードに対応しました。

2012/09/19:
- V4 BulkServiceのダウンロードに対応しました。

2012/09/05:
- V4 APIに対応しました。

2012/04/17:
- conf/api_config.propertiesファイルのproduction環境用LOCATIONの設定値をlocation.im.yahooapis.jpに変更しました。


--------------------------------
【概要】
--------------------------------
このサンプルプログラムは、Javaを使用して各APIを呼び出す処理サンプルです。
JAX-WSを使用してAPIを呼び出す形になっています。


--------------------------------
【内容物】
--------------------------------
■binディレクトリ
コンパイルされたサンプルプログラムの実行ファイルと、Windows上で実行するためのバッチファイルが格納されています。

- run_sample.bat                   ：Windows上でサンプルプログラムを実行するためのバッチファイルです。
- ad-api-sample-IM-API-V6.0.jar    ：コンパイルされたサンプルプログラムがまとめたjarファイルです。

■src/main/javaディレクトリ
以下の各プログラムが格納されています。

・以下は直接実行できるサンプルプログラムです。

- jp/co/yahoo/ad_api_sample配下
- accountAdProductSample/AccountAdProductSample.java   ：AccountAdProductServiceによるアカウント商品一覧の参照処理のサンプルです。
- accountSample/AccountSample.java                     ：AccountServiceによるアカウント参照、更新処理のサンプルです。
- adSample/AdGroupAdServiceSample.java                 ：AdGroupAdServiceによる広告の登録、参照、更新、削除処理のサンプルです。
- adSample/AdGroupServiceSample.java                   ：AdGroupServiceによる広告グループの登録、参照、更新、削除処理のサンプルです。
- adSample/AdSample.java                               ：CampaignService/AdGroupService/AdGroupAdService/AdGroupTargetServiceによる入稿処理のサンプルです。
- adSample/CampaignServiceSample.java                  ：CampaignServiceによるキャンペーンの登録、参照、更新、削除処理のサンプルです。
- auditLogDownloadSample/AuditLogDownloadSample.java   ：AuditLogServiceを使用した操作履歴ログダウンロード処理のサンプルです。
- balanceSample/BalanceSample.java                     ：BalanceServiceによるアカウント残高参照処理のサンプルです。
- bulkDownloadSample/BulkDownloadSample.java           ：BulkServiceによるダウンロード処理のサンプルです。
- bulkUploadSample/BulkUploadSample.java               ：BulkServiceによるアップロード処理のサンプルです。
- conversionTrackerSample/ConversionTrackerSample.java ：ConversionTrackerServiceによるコンバージョン情報の登録、更新処理のサンプルです。
- dictionarySample.DictionarySample.java               ：DictionaryServiceによる地域データ、審査否認理由、ターゲット設定用マスタデータ参照処理のサンプルです。
- mediaSample/MediaSample.java                         ：AdSample.javaにMediaServiceを加えた画像広告の入稿処理のサンプルです。
- placementUrlSample/PlacementUrlSample.java           ：PlacementUrlIdeaService,PlacementUrlListServiceを使用したプレイスメントターゲティング処理のサンプルです。
- reportDownloadSample/ReportDownloadSample.java       ：ReportDefinitionService, ReportServiceを使用したレポートダウンロード処理のサンプルです。
- retargetingSample/RetargetingSample.java             ：RetargetingTagService, RetargetingListServiceを使用したリターゲティング処理のサンプルです。
- searchKeywordSample/SearchKeywordSample.java         ：SearchKeywordIdeaService,SearchKeywordListServiceを使用したサーチターゲティング処理のサンプルです。
- statsSample/StatsSample.java                         ：StatsServiceを使用した統計情報処理のサンプルです。
- videoSample/VideoSample.java                         ：AdSample.javaにVideoServiceを加えた画像広告の入稿処理のサンプルです。

・以下は各サンプルプログラムから利用されるクラスです。

- SoapUtils.java                 ：LocationServiceを使用したリクエスト先の取得処理のサンプル及びその他共通処理です。
- jp/yahooapis/im/V6配下         ：JAX-WSを使用してWSDLから生成したスタブ、スケルトンクラス群です。

■src/main/resourceディレクトリ
以下の内容物が格納されています。
- api_config.properties：各種IDを記述する設定ファイルです。

■src/test/javaディレクトリ
以下の各プログラムが格納されています。

・以下は直接実行できるサンプルプログラムです。

- jp/co/yahoo/ad_api_sample配下
- accountAdProductSample/AccountAdProductSampleTest.java   ：AccountAdProductServiceによるアカウント商品一覧の参照処理のテストケースです。
- accountSample/AccountSampleTest.java                     ：AccountServiceによるアカウント参照、更新処理のテストケースです。
- adSample/AdGroupAdServiceSampleTest.java                 ：AdGroupAdServiceによる広告の登録、参照、更新、削除処理のテストケースです。
- adSample/AdGroupServiceSampleTest.java                   ：AdGroupServiceによる広告グループの登録、参照、更新、削除処理のテストケースです。
- adSample/AdSampleTest.java                               ：CampaignService/AdGroupService/AdGroupAdService/AdGroupTargetServiceによる入稿処理のテストケースです。
- adSample/CampaignServiceSampleTest.java                  ：CampaignServiceによるキャンペーンの登録、参照、更新、削除処理のテストケースです。
- auditLogDownloadSample/AuditLogDownloadSampleTest.java   ：AuditLogServiceを使用した操作履歴ログダウンロード処理のテストケースです。
- balanceSample/BalanceSampleTest.java                     ：BalanceServiceによるアカウント残高参照処理のテストケースです。
- bulkDownloadSample/BulkDownloadSampleTest.java           ：BulkServiceによるダウンロード処理のテストケースです。
- bulkUploadSample/BulkUploadSampleTest.java               ：BulkServiceによるアップロード処理のテストケースです。
- conversionTrackerSample/ConversionTrackerSampleTest.java ：ConversionTrackerServiceによるコンバージョン情報の登録、更新処理のテストケースです。
- dictionarySample.DictionarySampleTest.java               ：DictionaryServiceによる地域データ、審査否認理由、ターゲット設定用マスタデータ参照処理のテストケースです。
- mediaSample/MediaSampleTest.java                         ：AdSampleTest.javaにMediaServiceを加えた画像広告の入稿処理のテストケースです。
- placementUrlSample/PlacementUrlSampleTest.java           ：PlacementUrlIdeaService,PlacementUrlListServiceを使用したプレイスメントターゲティング処理のテストケースです。
- reportDownloadSample/ReportDownloadSampleTest.java       ：ReportDefinitionService, ReportServiceを使用したレポートダウンロード処理のテストケースです。
- retargetingSample/RetargetingSampleTest.java             ：RetargetingTagService, RetargetingListServiceを使用したリターゲティング処理のテストケースです。
- searchKeywordSample/SearchKeywordSampleTest.java         ：SearchKeywordIdeaService,SearchKeywordListServiceを使用したサーチターゲティング処理のテストケースです。
- statsSample/StatsSampleTest.java                         ：StatsServiceを使用した統計情報処理のテストケースです。
- videoSample/VideoSampleTest.java                         ：AdSample.javaにVideoServiceを加えた画像広告の入稿処理のサンプルです。

■downloadディレクトリ
ReportDownloadSample、BulkDownloadSample、BulkUploadSample、AuditLogDownloadSampleを実行した際に、ダウンロードしたデータがファイルとして格納されるディレクトリです。

■uploadディレクトリ
MediaSample, BulkUploadSample, VideoSampleでアップロードするファイルをあらかじめ格納しておくディレクトリです。


--------------------------------
【環境設定】
--------------------------------
Java環境を構築するために、以下をインストールしてください。

[Java 1.8(Java SE Development Kit 8)]
http://www.oracle.com/technetwork/java/javase/downloads/index.html

Maven環境を構築するために、以下をインストールしてください。

[Apache Maven 3.1.1]
https://maven.apache.org/download.cgi


confディレクトリ配下にあるapi_config.propertiesに各IDを記述します。
LOCATION            : リクエスト先毎にコメントアウトを外してください。
LICENSE             : APIライセンスを記述(必須)
APIACCOUNTID        : APIアカウントIDを記述(必須)
APIACCOUNTPASSWORD  : APIアカウントパスワードを記述(必須)
ONBEHALFOFACCOUNTID : 代行アカウントを記述(任意)
ONBEHALFOFPASSWORD  : 代行アカウントパスワードを記述(任意)
ACCOUNTID           : アカウントIDを記述(必須)

以下、IDはAdGroupAdSample、StatsSampleを動作させる際に必要となります。
CAMPAIGNID          : キャンペーンIDを記述（必須）
ADGROUPID           : 広告グループIDを記述（必須）

以下、IDはStatsSampleを動作させる際に必要となります。
ADID                : 広告IDを記述（必須）
MEDIAID             : 画像IDを記述（必須）


--------------------------------
【実行】
--------------------------------
set SAMPLE_HOME={ad-api-sample}
set PACKAGE_NAME=jp.co.yahoo.ad_api_sample
set CLASS_PATH=%SAMPLE_HOME%\bin\ad-api-sample-IM-API-V6.0.jar;%SAMPLE_HOME%;%SAMPLE_HOME%\src\main\resources

■実行例：
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

データをダウンロードする処理を実行した場合には、downloadディレクトリにファイルが格納されます。

データをアップロードする処理を実行する場合には、あらかじめuploadディレクトリ配下にアップロードしたいファイルを格納しておく必要があります。
サンプルプログラムごとにファイル名は固定です。

・MediaSampleの場合　　　　：SampleMedia.jpg
・BulkUploadSampleの場合　 ：SampleBulkUpload.csv
・VideoSampleの場合　　　　：SampleVideoUpload.mp4
