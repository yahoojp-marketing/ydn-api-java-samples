
package jp.yahooapis.im.v201903.adgroup;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DynamicImageExtensions.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DynamicImageExtensions">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACTIVE"/>
 *     &lt;enumeration value="PAUSED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DynamicImageExtensions")
@XmlEnum
public enum DynamicImageExtensions {

    ACTIVE,
    PAUSED;

    public String value() {
        return name();
    }

    public static DynamicImageExtensions fromValue(String v) {
        return valueOf(v);
    }

}
