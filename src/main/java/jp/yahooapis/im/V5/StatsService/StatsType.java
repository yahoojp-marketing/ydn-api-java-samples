
package jp.yahooapis.im.V5.StatsService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StatsType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StatsType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CAMPAIGN"/>
 *     &lt;enumeration value="ADGROUP"/>
 *     &lt;enumeration value="AD"/>
 *     &lt;enumeration value="MEDIA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StatsType")
@XmlEnum
public enum StatsType {

    CAMPAIGN,
    ADGROUP,
    AD,
    MEDIA;

    public String value() {
        return name();
    }

    public static StatsType fromValue(String v) {
        return valueOf(v);
    }

}
