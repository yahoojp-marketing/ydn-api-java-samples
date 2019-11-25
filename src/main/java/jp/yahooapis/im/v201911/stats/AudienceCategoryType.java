
package jp.yahooapis.im.v201911.stats;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AudienceCategoryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AudienceCategoryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AFFINITY"/>
 *     &lt;enumeration value="IN_MARKET"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AudienceCategoryType")
@XmlEnum
public enum AudienceCategoryType {

    AFFINITY,
    IN_MARKET;

    public String value() {
        return name();
    }

    public static AudienceCategoryType fromValue(String v) {
        return valueOf(v);
    }

}
