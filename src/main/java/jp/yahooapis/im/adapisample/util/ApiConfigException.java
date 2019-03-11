/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.util;

/**
 * Utility method collection for Java Sample Program.
 */
public class ApiConfigException extends RuntimeException {

  public ApiConfigException(String message) {
    super(message);
  }

  public ApiConfigException(String message, Throwable cause) {
    super(message, cause);
  }
}
