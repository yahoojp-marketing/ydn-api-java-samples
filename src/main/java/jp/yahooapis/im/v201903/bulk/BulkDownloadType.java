
package jp.yahooapis.im.v201903.bulk;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BulkDownloadType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BulkDownloadType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CAMPAIGN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BulkDownloadType")
@XmlEnum
public enum BulkDownloadType {

    CAMPAIGN;

    public String value() {
        return name();
    }

    public static BulkDownloadType fromValue(String v) {
        return valueOf(v);
    }

}
