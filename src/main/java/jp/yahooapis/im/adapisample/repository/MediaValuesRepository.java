/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.im.adapisample.repository;

import jp.yahooapis.im.adapisample.util.ValuesHolder;
import jp.yahooapis.im.v201903.media.MediaRecord;
import jp.yahooapis.im.v201903.media.MediaValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class MediaValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * MediaValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public MediaValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return MediaRecords
   */
  public List<MediaRecord> getMediaRecord() {
    List<MediaRecord> mediaRecords = new ArrayList<>();
    if (this.valuesHolder.getMediaValuesList().size() == 0) {
      return mediaRecords;
    }
    for (MediaValues mediaValues : this.valuesHolder.getMediaValuesList()) {
      mediaRecords.add(mediaValues.getMediaRecord());
    }
    return mediaRecords;
  }

  /**
   * @return MediaIds
   */
  public List<Long> getMediaIds() {
    List<Long> mediaIds = new ArrayList<>();
    if (this.valuesHolder.getMediaValuesList().size() == 0) {
      return mediaIds;
    }
    for (MediaValues mediaValues : this.valuesHolder.getMediaValuesList()) {
      mediaIds.add(mediaValues.getMediaRecord().getMediaId());
    }
    return mediaIds;
  }
}
