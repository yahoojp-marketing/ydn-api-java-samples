
package jp.yahooapis.im.V5.StatsService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComparisionResult.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ComparisionResult">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DOWN"/>
 *     &lt;enumeration value="UP"/>
 *     &lt;enumeration value="KEEP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ComparisionResult")
@XmlEnum
public enum ComparisionResult {

    DOWN,
    UP,
    KEEP;

    public String value() {
        return name();
    }

    public static ComparisionResult fromValue(String v) {
        return valueOf(v);
    }

}
