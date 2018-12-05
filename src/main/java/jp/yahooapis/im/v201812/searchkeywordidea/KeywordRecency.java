
package jp.yahooapis.im.v201812.searchkeywordidea;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KeywordRecency.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="KeywordRecency">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="WITHIN_1DAY"/>
 *     &lt;enumeration value="WITHIN_3DAYS"/>
 *     &lt;enumeration value="WITHIN_7DAYS"/>
 *     &lt;enumeration value="WITHIN_14DAYS"/>
 *     &lt;enumeration value="WITHIN_30DAYS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "KeywordRecency")
@XmlEnum
public enum KeywordRecency {

    @XmlEnumValue("WITHIN_1DAY")
    WITHIN_1_DAY("WITHIN_1DAY"),
    @XmlEnumValue("WITHIN_3DAYS")
    WITHIN_3_DAYS("WITHIN_3DAYS"),
    @XmlEnumValue("WITHIN_7DAYS")
    WITHIN_7_DAYS("WITHIN_7DAYS"),
    @XmlEnumValue("WITHIN_14DAYS")
    WITHIN_14_DAYS("WITHIN_14DAYS"),
    @XmlEnumValue("WITHIN_30DAYS")
    WITHIN_30_DAYS("WITHIN_30DAYS");
    private final String value;

    KeywordRecency(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static KeywordRecency fromValue(String v) {
        for (KeywordRecency c: KeywordRecency.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
