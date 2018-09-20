
package jp.yahooapis.im.v201809.conversiontracker;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExcludeFromBidding.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExcludeFromBidding">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FALSE"/>
 *     &lt;enumeration value="TRUE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExcludeFromBidding")
@XmlEnum
public enum ExcludeFromBidding {

    FALSE,
    TRUE;

    public String value() {
        return name();
    }

    public static ExcludeFromBidding fromValue(String v) {
        return valueOf(v);
    }

}
