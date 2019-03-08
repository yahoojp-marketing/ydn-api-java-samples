
package jp.yahooapis.im.v201903.searchkeywordidea;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SortField.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SortField">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="KEYWORD"/>
 *     &lt;enumeration value="KEYWORD_ID"/>
 *     &lt;enumeration value="DESKTOP_SEARCH_VOLUME"/>
 *     &lt;enumeration value="SMART_PHONE_SEARCH_VOLUME"/>
 *     &lt;enumeration value="TABLET_SEARCH_VOLUME"/>
 *     &lt;enumeration value="RELEASE_DATE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SortField")
@XmlEnum
public enum SortField {

    KEYWORD,
    KEYWORD_ID,
    DESKTOP_SEARCH_VOLUME,
    SMART_PHONE_SEARCH_VOLUME,
    TABLET_SEARCH_VOLUME,
    RELEASE_DATE;

    public String value() {
        return name();
    }

    public static SortField fromValue(String v) {
        return valueOf(v);
    }

}
