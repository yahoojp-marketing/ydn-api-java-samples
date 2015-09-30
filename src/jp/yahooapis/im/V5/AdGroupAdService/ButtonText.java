
package jp.yahooapis.im.V5.AdGroupAdService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ButtonText.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ButtonText">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FOR_MORE_INFO"/>
 *     &lt;enumeration value="CONFIRM_NOW"/>
 *     &lt;enumeration value="APPLY_HERE"/>
 *     &lt;enumeration value="PURCHASE"/>
 *     &lt;enumeration value="EXPERIENCE"/>
 *     &lt;enumeration value="CONFIRM_PROPERTY"/>
 *     &lt;enumeration value="REQUEST_INFO"/>
 *     &lt;enumeration value="DOWNLOAD"/>
 *     &lt;enumeration value="INSTALL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ButtonText")
@XmlEnum
public enum ButtonText {

    FOR_MORE_INFO,
    CONFIRM_NOW,
    APPLY_HERE,
    PURCHASE,
    EXPERIENCE,
    CONFIRM_PROPERTY,
    REQUEST_INFO,
    DOWNLOAD,
    INSTALL;

    public String value() {
        return name();
    }

    public static ButtonText fromValue(String v) {
        return valueOf(v);
    }

}
