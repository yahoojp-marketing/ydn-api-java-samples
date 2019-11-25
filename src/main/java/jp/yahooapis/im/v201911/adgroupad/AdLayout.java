
package jp.yahooapis.im.v201911.adgroupad;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdLayout.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdLayout">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SQUARE_BANNER_TOP"/>
 *     &lt;enumeration value="WIDE_BANNER_TOP"/>
 *     &lt;enumeration value="WIDE_BANNER_MIDDLE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AdLayout")
@XmlEnum
public enum AdLayout {

    SQUARE_BANNER_TOP,
    WIDE_BANNER_TOP,
    WIDE_BANNER_MIDDLE;

    public String value() {
        return name();
    }

    public static AdLayout fromValue(String v) {
        return valueOf(v);
    }

}
