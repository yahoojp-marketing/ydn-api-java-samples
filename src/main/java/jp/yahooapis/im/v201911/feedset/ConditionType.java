
package jp.yahooapis.im.v201911.feedset;

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
 *     &lt;enumeration value="AGE_GROUP"/>
 *     &lt;enumeration value="AVAILABILITY_DATE"/>
 *     &lt;enumeration value="GENDER_GROUP"/>
 *     &lt;enumeration value="GOOGLE_PRODUCT_CATEGORY"/>
 *     &lt;enumeration value="LOCATION"/>
 *     &lt;enumeration value="SALES_RANK"/>
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
    BADGE,
    AGE_GROUP,
    AVAILABILITY_DATE,
    GENDER_GROUP,
    GOOGLE_PRODUCT_CATEGORY,
    LOCATION,
    SALES_RANK;

    public String value() {
        return name();
    }

    public static ConditionType fromValue(String v) {
        return valueOf(v);
    }

}
