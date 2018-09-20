
package jp.yahooapis.im.v201809.retargetinglist;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RuleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RuleType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="URL"/>
 *     &lt;enumeration value="LABEL"/>
 *     &lt;enumeration value="REFERER_URL"/>
 *     &lt;enumeration value="PAGE_TYPE"/>
 *     &lt;enumeration value="ITEM_ID"/>
 *     &lt;enumeration value="ITEM_CATEGORY_ID"/>
 *     &lt;enumeration value="EVENT_TYPE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RuleType")
@XmlEnum
public enum RuleType {

    URL,
    LABEL,
    REFERER_URL,
    PAGE_TYPE,
    ITEM_ID,
    ITEM_CATEGORY_ID,
    EVENT_TYPE;

    public String value() {
        return name();
    }

    public static RuleType fromValue(String v) {
        return valueOf(v);
    }

}
