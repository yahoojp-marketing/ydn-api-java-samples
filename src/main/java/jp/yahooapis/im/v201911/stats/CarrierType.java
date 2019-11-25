
package jp.yahooapis.im.v201911.stats;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CarrierType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CarrierType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DOCOMO"/>
 *     &lt;enumeration value="KDDI"/>
 *     &lt;enumeration value="SOFTBANK"/>
 *     &lt;enumeration value="YMOBILE"/>
 *     &lt;enumeration value="OTHERS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CarrierType")
@XmlEnum
public enum CarrierType {

    DOCOMO,
    KDDI,
    SOFTBANK,
    YMOBILE,
    OTHERS;

    public String value() {
        return name();
    }

    public static CarrierType fromValue(String v) {
        return valueOf(v);
    }

}
