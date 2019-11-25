
package jp.yahooapis.im.v201911.feeddata;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FileUploadStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FileUploadStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UPLOADED"/>
 *     &lt;enumeration value="COMPLETED"/>
 *     &lt;enumeration value="FILE_FORMAT_ERROR"/>
 *     &lt;enumeration value="SYSTEM_ERROR"/>
 *     &lt;enumeration value="NETWORK_ERROR"/>
 *     &lt;enumeration value="FILE_NOT_FOUND_ERROR"/>
 *     &lt;enumeration value="FILE_SIZE_OVER_ERROR"/>
 *     &lt;enumeration value="AUTH_ERROR"/>
 *     &lt;enumeration value="UPLOAD_COUNT_OVER_ERROR"/>
 *     &lt;enumeration value="NOT_MODIFIED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FileUploadStatus")
@XmlEnum
public enum FileUploadStatus {

    UPLOADED,
    COMPLETED,
    FILE_FORMAT_ERROR,
    SYSTEM_ERROR,
    NETWORK_ERROR,
    FILE_NOT_FOUND_ERROR,
    FILE_SIZE_OVER_ERROR,
    AUTH_ERROR,
    UPLOAD_COUNT_OVER_ERROR,
    NOT_MODIFIED;

    public String value() {
        return name();
    }

    public static FileUploadStatus fromValue(String v) {
        return valueOf(v);
    }

}
