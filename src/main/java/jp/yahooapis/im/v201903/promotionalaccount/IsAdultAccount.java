
package jp.yahooapis.im.v201903.promotionalaccount;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IsAdultAccount.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IsAdultAccount">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRUE"/>
 *     &lt;enumeration value="FALSE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IsAdultAccount")
@XmlEnum
public enum IsAdultAccount {

    TRUE,
    FALSE;

    public String value() {
        return name();
    }

    public static IsAdultAccount fromValue(String v) {
        return valueOf(v);
    }

}
