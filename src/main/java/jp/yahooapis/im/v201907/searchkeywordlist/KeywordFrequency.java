
package jp.yahooapis.im.v201907.searchkeywordlist;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KeywordFrequency.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="KeywordFrequency">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ONCE_OR_MORE"/>
 *     &lt;enumeration value="TWICE_OR_MORE"/>
 *     &lt;enumeration value="THREE_TIMES_OR_MORE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "KeywordFrequency")
@XmlEnum
public enum KeywordFrequency {

    ONCE_OR_MORE,
    TWICE_OR_MORE,
    THREE_TIMES_OR_MORE;

    public String value() {
        return name();
    }

    public static KeywordFrequency fromValue(String v) {
        return valueOf(v);
    }

}
