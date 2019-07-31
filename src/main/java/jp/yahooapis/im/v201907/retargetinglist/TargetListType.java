
package jp.yahooapis.im.v201907.retargetinglist;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetListType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TargetListType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DEFAULT_LIST"/>
 *     &lt;enumeration value="RULE"/>
 *     &lt;enumeration value="COMBINATION"/>
 *     &lt;enumeration value="SIMILARITY"/>
 *     &lt;enumeration value="CUSTOM_AUDIENCE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TargetListType")
@XmlEnum
public enum TargetListType {

    DEFAULT_LIST,
    RULE,
    COMBINATION,
    SIMILARITY,
    CUSTOM_AUDIENCE;

    public String value() {
        return name();
    }

    public static TargetListType fromValue(String v) {
        return valueOf(v);
    }

}
