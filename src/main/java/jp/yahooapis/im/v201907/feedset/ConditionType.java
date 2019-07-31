
package jp.yahooapis.im.v201907.feedset;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConditionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConditionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CATEGORY_ID"/>
 *     &lt;enumeration value="STOCK_QUANTITY"/>
 *     &lt;enumeration value="PRICE"/>
 *     &lt;enumeration value="SALE_PRICE"/>
 *     &lt;enumeration value="RATING"/>
 *     &lt;enumeration value="REVIEWS"/>
 *     &lt;enumeration value="BADGE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConditionType")
@XmlEnum
public enum ConditionType {

    CATEGORY_ID,
    STOCK_QUANTITY,
    PRICE,
    SALE_PRICE,
    RATING,
    REVIEWS,
    BADGE;

    public String value() {
        return name();
    }

    public static ConditionType fromValue(String v) {
        return valueOf(v);
    }

}
