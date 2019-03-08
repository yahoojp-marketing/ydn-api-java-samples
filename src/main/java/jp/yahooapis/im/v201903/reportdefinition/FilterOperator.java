
package jp.yahooapis.im.v201903.reportdefinition;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FilterOperator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FilterOperator">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EQUALS"/>
 *     &lt;enumeration value="NOT_EQUALS"/>
 *     &lt;enumeration value="GREATER_THAN"/>
 *     &lt;enumeration value="GREATER_THAN_EQUALS"/>
 *     &lt;enumeration value="LESS_THAN"/>
 *     &lt;enumeration value="LESS_THAN_EQUALS"/>
 *     &lt;enumeration value="CONTAINS"/>
 *     &lt;enumeration value="IN"/>
 *     &lt;enumeration value="CONTAINS_ALL"/>
 *     &lt;enumeration value="CONTAINS_ANY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FilterOperator")
@XmlEnum
public enum FilterOperator {

    EQUALS,
    NOT_EQUALS,
    GREATER_THAN,
    GREATER_THAN_EQUALS,
    LESS_THAN,
    LESS_THAN_EQUALS,
    CONTAINS,
    IN,
    CONTAINS_ALL,
    CONTAINS_ANY;

    public String value() {
        return name();
    }

    public static FilterOperator fromValue(String v) {
        return valueOf(v);
    }

}
