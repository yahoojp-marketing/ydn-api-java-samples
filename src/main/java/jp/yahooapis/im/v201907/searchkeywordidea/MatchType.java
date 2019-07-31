
package jp.yahooapis.im.v201907.searchkeywordidea;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MatchType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MatchType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EXACT"/>
 *     &lt;enumeration value="BROAD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MatchType")
@XmlEnum
public enum MatchType {

    EXACT,
    BROAD;

    public String value() {
        return name();
    }

    public static MatchType fromValue(String v) {
        return valueOf(v);
    }

}
