
package jp.yahooapis.im.v201809.promotionalaccount;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AutoChargeStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AutoChargeStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="ACTIVE"/>
 *     &lt;enumeration value="PAUSED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AutoChargeStatus")
@XmlEnum
public enum AutoChargeStatus {

    NONE,
    ACTIVE,
    PAUSED;

    public String value() {
        return name();
    }

    public static AutoChargeStatus fromValue(String v) {
        return valueOf(v);
    }

}
