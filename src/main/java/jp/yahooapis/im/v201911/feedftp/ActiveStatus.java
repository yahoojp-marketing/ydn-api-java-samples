
package jp.yahooapis.im.v201911.feedftp;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActiveStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActiveStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INACTIVE"/>
 *     &lt;enumeration value="ACTIVE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActiveStatus")
@XmlEnum
public enum ActiveStatus {

    INACTIVE,
    ACTIVE;

    public String value() {
        return name();
    }

    public static ActiveStatus fromValue(String v) {
        return valueOf(v);
    }

}
