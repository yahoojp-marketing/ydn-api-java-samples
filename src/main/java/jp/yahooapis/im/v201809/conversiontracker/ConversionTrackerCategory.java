
package jp.yahooapis.im.v201809.conversiontracker;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConversionTrackerCategory.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConversionTrackerCategory">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="DEFAULT"/>
 *     &lt;enumeration value="PAGE_VIEW"/>
 *     &lt;enumeration value="PURCHASE"/>
 *     &lt;enumeration value="SIGNUP"/>
 *     &lt;enumeration value="LEAD"/>
 *     &lt;enumeration value="DOWNLOAD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConversionTrackerCategory")
@XmlEnum
public enum ConversionTrackerCategory {

    NONE,
    DEFAULT,
    PAGE_VIEW,
    PURCHASE,
    SIGNUP,
    LEAD,
    DOWNLOAD;

    public String value() {
        return name();
    }

    public static ConversionTrackerCategory fromValue(String v) {
        return valueOf(v);
    }

}
