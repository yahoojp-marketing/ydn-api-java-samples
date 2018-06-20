
package jp.yahooapis.im.v201806.media;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LogoFlg.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LogoFlg">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FALSE"/>
 *     &lt;enumeration value="TRUE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LogoFlg")
@XmlEnum
public enum LogoFlg {

    FALSE,
    TRUE;

    public String value() {
        return name();
    }

    public static LogoFlg fromValue(String v) {
        return valueOf(v);
    }

}
