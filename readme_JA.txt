--------------------------------
【バージョン】
--------------------------------
Version 201903

■変更履歴
-----------
2019/03/11:
- Version 201903に対応しました。

--------------------------------
【概要】
--------------------------------
このサンプルプログラムは、Javaを使用して各APIを呼び出す処理のサンプルです。
JAX-WSを使用してAPIを呼び出します。


--------------------------------
【内容物】
--------------------------------
src/main/
  - resources/
    - api_config.properties.dist    : 各種IDを記述する設定ファイルです。api_config.propertiesにリネームしてください。
  - java/jp/yahooapis/im/
    - v201903/                      : 対象のAPIバージョンのJava用EntityサンプルClassです。
    - adapisample/
      - basic/                      : Yahoo!プロモーション広告API（YDN）の各種Serviceサンプル集です。
      - feature/                    : Yahoo!プロモーション広告API（YDN）を利用した広告入稿、ターゲティングなどのサンプル集です。
      - repository/                 : Yahoo!プロモーション広告API（YDN）各種サンプルを利用するための補助ユーティリティです。
      - util/                       : Yahoo!プロモーション広告API（YDN）各種サンプルを利用するための補助ユーティリティです。
download/                           : 各種Downloadサービスを実行した際に、ダウンロードしたデータがファイルとして格納されるディレクトリです。
upload/                             : 各種Uploadサービスを実行する際に、利用するデータファイルを格納するディレクトリです。


--------------------------------
【Feature説明】
--------------------------------
src/main/java/jp/yahooapis/im/adapisample/feature/
  - LabelSample.java                    : ラベル機能を利用した処理のサンプルです。
  - DynamicAdsForDisplaySample.java     : 動的ディスプレイ広告を利用した入稿処理のサンプルです。
  - AdGroupTargetSample.java            : ターゲティング機能を利用した処理のサンプルです。


--------------------------------
【環境設定】
--------------------------------
Java環境を構築するために、以下をインストールしてください。

1. Java 1.8（Java SE Development Kit 8）、またはそれ以上のバージョン
2. Apache Maven 3.1.1、またはそれ以上のバージョン
3. resourcesディレクトリ配下にあるapi_config.propertiesに各IDを記述します。
  - LOCATION            : リクエスト先ごとにコメントアウトを外してください。
  - LICENSE             : APIライセンスを記述してください。
  - APIACCOUNTID        : APIアカウントIDを記述してください。
  - APIACCOUNTPASSWORD  : APIアカウントパスワードを記述してください。
  - ONBEHALFOFACCOUNTID : 代行アカウントを記述してください（任意）。
  - ONBEHALFOFPASSWORD  : 代行アカウントパスワードを記述してください（任意）。
  - ACCOUNTID           : アカウントIDを記述してください（必須）。


--------------------------------
【実行】
--------------------------------
cloneしたサンプルプログラムのディレクトリに移動し、以下のコマンドを実行します。
$ mvn clean install

各サンプルプログラムを実行します。

■実行例
$ java -classpath ./target/classes jp.yahooapis.im.adapisample.basic.account.AccountServiceSample
$ java -classpath ./target/classes jp.yahooapis.im.adapisample.feature.LabelSample

