
package jp.yahooapis.im.v201812.adgroupad;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CarrierName.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CarrierName">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DOCOMO"/>
 *     &lt;enumeration value="KDDI"/>
 *     &lt;enumeration value="SOFTBANK"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CarrierName")
@XmlEnum
public enum CarrierName {

    DOCOMO,
    KDDI,
    SOFTBANK,
    NONE;

    public String value() {
        return name();
    }

    public static CarrierName fromValue(String v) {
        return valueOf(v);
    }

}
