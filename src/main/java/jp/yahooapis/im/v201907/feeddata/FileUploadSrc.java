
package jp.yahooapis.im.v201907.feeddata;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FileUploadSrc.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FileUploadSrc">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CAMPAIGN_MANAGEMENT_TOOL"/>
 *     &lt;enumeration value="API"/>
 *     &lt;enumeration value="FTP_SCHEDULE"/>
 *     &lt;enumeration value="FTP_DIRECT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FileUploadSrc")
@XmlEnum
public enum FileUploadSrc {

    CAMPAIGN_MANAGEMENT_TOOL,
    API,
    FTP_SCHEDULE,
    FTP_DIRECT;

    public String value() {
        return name();
    }

    public static FileUploadSrc fromValue(String v) {
        return valueOf(v);
    }

}
