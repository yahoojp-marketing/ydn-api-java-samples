
package jp.yahooapis.im.v201907.adgroup;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroupConversionOptimizerType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdGroupConversionOptimizerType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="MANUAL"/>
 *     &lt;enumeration value="AUTO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AdGroupConversionOptimizerType")
@XmlEnum
public enum AdGroupConversionOptimizerType {

    NONE,
    MANUAL,
    AUTO;

    public String value() {
        return name();
    }

    public static AdGroupConversionOptimizerType fromValue(String v) {
        return valueOf(v);
    }

}
