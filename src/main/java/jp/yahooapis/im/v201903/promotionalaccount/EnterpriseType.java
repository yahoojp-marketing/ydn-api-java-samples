
package jp.yahooapis.im.v201903.promotionalaccount;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EnterpriseType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EnterpriseType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="KABUSHIKI"/>
 *     &lt;enumeration value="YUGEN"/>
 *     &lt;enumeration value="GOSI"/>
 *     &lt;enumeration value="ZAIDAN"/>
 *     &lt;enumeration value="SYADAN"/>
 *     &lt;enumeration value="SYUKYO"/>
 *     &lt;enumeration value="GAKKO"/>
 *     &lt;enumeration value="KOJIN"/>
 *     &lt;enumeration value="OTHER"/>
 *     &lt;enumeration value="GOMEI"/>
 *     &lt;enumeration value="HIEIRI"/>
 *     &lt;enumeration value="GODO"/>
 *     &lt;enumeration value="KYODO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EnterpriseType")
@XmlEnum
public enum EnterpriseType {

    KABUSHIKI,
    YUGEN,
    GOSI,
    ZAIDAN,
    SYADAN,
    SYUKYO,
    GAKKO,
    KOJIN,
    OTHER,
    GOMEI,
    HIEIRI,
    GODO,
    KYODO;

    public String value() {
        return name();
    }

    public static EnterpriseType fromValue(String v) {
        return valueOf(v);
    }

}
