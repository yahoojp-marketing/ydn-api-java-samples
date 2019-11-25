
package jp.yahooapis.im.v201911.feeditem;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Availability.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Availability">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OUT_OF_STOCK"/>
 *     &lt;enumeration value="IN_STOCK"/>
 *     &lt;enumeration value="PREORDER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Availability")
@XmlEnum
public enum Availability {

    OUT_OF_STOCK,
    IN_STOCK,
    PREORDER;

    public String value() {
        return name();
    }

    public static Availability fromValue(String v) {
        return valueOf(v);
    }

}
