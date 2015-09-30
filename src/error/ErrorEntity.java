package error;

import java.util.List;

public interface ErrorEntity {

  String getCode();

  String getMessage();

  List<ErrorDetailEntity> getErrorDetail();
}
