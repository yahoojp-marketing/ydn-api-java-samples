
package jp.yahooapis.im.V5.PromotionalAccountService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UrlType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UrlType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PC"/>
 *     &lt;enumeration value="DOCOMO"/>
 *     &lt;enumeration value="KDDI"/>
 *     &lt;enumeration value="SOFTBANK"/>
 *     &lt;enumeration value="SMART_PHONE"/>
 *     &lt;enumeration value="OTHER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UrlType")
@XmlEnum
public enum UrlType {

    PC,
    DOCOMO,
    KDDI,
    SOFTBANK,
    SMART_PHONE,
    OTHER;

    public String value() {
        return name();
    }

    public static UrlType fromValue(String v) {
        return valueOf(v);
    }

}
