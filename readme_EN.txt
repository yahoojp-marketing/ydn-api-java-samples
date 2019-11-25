--------------------------------
[Version]
--------------------------------
Version 201911

- Change logs
-----------
2019/11/27:
- 201911 is now available.
2019/08/01:
- 201907 is now available.
2019/03/11:
- 201903 is now available.

--------------------------------
[Overview]
--------------------------------
These code samples show how to use APIs through Java.
We utilize SoapClient Library to call APIs.

--------------------------------
[Contents]
--------------------------------
src/main/
  - resources/
    - api_config.properties.dist    : Config files to specify Ids. Rename this file to "api_config.properties"
  - java/jp/yahooapis/im/
    - v201911/                      : Java Entity classes for written versions(V201911).
    - adapisample/
      - basic/                      : Examples of each services of Yahoo! JAPAN Promotional Ads (YDN).
      - feature/                    : Examples of how to create ads, set targeting on Yahoo! JAPAN Promotional Ads (YDN).
      - repository/                 : Utilities which help you use the code samples of Yahoo! JAPAN Promotional Ads (YDN).
      - util/                       : Utilities which help you use the code samples of Yahoo! JAPAN Promotional Ads (YDN).
download/                           : Directory where downloaded files stored when using download feature.
upload/                             : Directory where uploaded files stored when using upload feature.

--------------------------------
[Feature]
--------------------------------
src/main/java/jp/yahooapis/im/adapisample/feature/
  - LabelSample.java                    : Examples of Label features.
  - DynamicAdsForDisplaySample.java     : Examples of DynamicAdsForDisplay features.
  - AdGroupTargetSample.java            : Examples of targeting features.


--------------------------------
[Development environment]
--------------------------------
Install software mentioned below.

1. Java 1.8(Java SE Development Kit 8 or above
2. Apache Maven 3.1.1 or above
3.  Write Ids in  src/main/resources/api_config.properties.
  - LOCATION            : choose either sandbox or production environment by removing comment out.
  - LICENSE             : API license
  - APIACCOUNTID        : API account id
  - APIACCOUNTPASSWORD  : API pccount password
  - ONBEHALFOFACCOUNTID : On Behalf Of Account Id(optional)
  - ONBEHALFOFPASSWORD  : On Behalf Of Password(optional)
  - ACCOUNTID           : Account Id(required)

--------------------------------
[How to execute Sample Code]
--------------------------------
Move into directory which you cloned and execute command below.
$ mvn clean install

- Example
$ java -classpath ./target/classes jp.yahooapis.im.adapisample.basic.account.AccountServiceSample
$ java -classpath ./target/classes jp.yahooapis.im.adapisample.feature.LabelSample


