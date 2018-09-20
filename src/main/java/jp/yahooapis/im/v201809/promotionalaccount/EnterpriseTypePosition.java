
package jp.yahooapis.im.v201809.promotionalaccount;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EnterpriseTypePosition.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EnterpriseTypePosition">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FRONT"/>
 *     &lt;enumeration value="BACK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EnterpriseTypePosition")
@XmlEnum
public enum EnterpriseTypePosition {

    FRONT,
    BACK;

    public String value() {
        return name();
    }

    public static EnterpriseTypePosition fromValue(String v) {
        return valueOf(v);
    }

}
