
package jp.yahooapis.im.v201911.dictionary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GeographicLocationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GeographicLocationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TARGETING"/>
 *     &lt;enumeration value="FEED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GeographicLocationType")
@XmlEnum
public enum GeographicLocationType {

    TARGETING,
    FEED;

    public String value() {
        return name();
    }

    public static GeographicLocationType fromValue(String v) {
        return valueOf(v);
    }

}
