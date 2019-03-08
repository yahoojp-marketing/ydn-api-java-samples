
package jp.yahooapis.im.v201903.retargetinglist;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetListSize.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TargetListSize">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RATE_1"/>
 *     &lt;enumeration value="RATE_2"/>
 *     &lt;enumeration value="RATE_3"/>
 *     &lt;enumeration value="RATE_4"/>
 *     &lt;enumeration value="RATE_5"/>
 *     &lt;enumeration value="RATE_6"/>
 *     &lt;enumeration value="RATE_7"/>
 *     &lt;enumeration value="RATE_8"/>
 *     &lt;enumeration value="RATE_9"/>
 *     &lt;enumeration value="RATE_10"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TargetListSize")
@XmlEnum
public enum TargetListSize {

    RATE_1,
    RATE_2,
    RATE_3,
    RATE_4,
    RATE_5,
    RATE_6,
    RATE_7,
    RATE_8,
    RATE_9,
    RATE_10;

    public String value() {
        return name();
    }

    public static TargetListSize fromValue(String v) {
        return valueOf(v);
    }

}
