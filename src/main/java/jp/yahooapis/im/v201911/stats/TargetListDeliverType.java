
package jp.yahooapis.im.v201911.stats;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetListDeliverType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TargetListDeliverType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INCLUDE"/>
 *     &lt;enumeration value="EXCLUDE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TargetListDeliverType")
@XmlEnum
public enum TargetListDeliverType {

    INCLUDE,
    EXCLUDE;

    public String value() {
        return name();
    }

    public static TargetListDeliverType fromValue(String v) {
        return valueOf(v);
    }

}
