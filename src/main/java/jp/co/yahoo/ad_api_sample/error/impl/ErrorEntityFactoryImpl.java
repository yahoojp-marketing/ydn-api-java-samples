package jp.co.yahoo.ad_api_sample.error.impl;

import jp.co.yahoo.ad_api_sample.error.ErrorDetailEntity;
import jp.co.yahoo.ad_api_sample.error.ErrorEntity;
import jp.co.yahoo.ad_api_sample.error.ErrorEntityFactory;
import jp.yahooapis.im.v201812.Error;
import jp.yahooapis.im.v201812.ErrorDetail;

import java.util.ArrayList;
import java.util.List;

public class ErrorEntityFactoryImpl implements ErrorEntityFactory {

  private final List<Error> errors;

  public ErrorEntityFactoryImpl(List<Error> errors) {
    this.errors = errors;
  }

  @Override
  public List<ErrorEntity> create() {
    ArrayList<ErrorEntity> list = new ArrayList<ErrorEntity>();
    if (errors != null) {
      for (final Error error : errors) {
        list.add(new ErrorEntity() {

          @Override
          public List<ErrorDetailEntity> getErrorDetail() {
            List<ErrorDetailEntity> details = new ArrayList<ErrorDetailEntity>();
            if (error.getDetail() != null) {
              for (final ErrorDetail errorDetail : error.getDetail()) {
                details.add(new ErrorDetailEntity() {

                  @Override
                  public List<String> getRequestValues() {
                    return errorDetail.getRequestValue();
                  }

                  @Override
                  public String getRequestKey() {
                    return errorDetail.getRequestKey();
                  }
                });
              }
            }
            return details;
          }

          @Override
          public String getMessage() {
            return error.getMessage();
          }

          @Override
          public String getCode() {
            return error.getCode();
          }
        });
      }
    }
    return list;
  }
}
