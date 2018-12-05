
package jp.yahooapis.im.v201812.conversiontracker;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AppConversionPlatform.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AppConversionPlatform">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ITUNES"/>
 *     &lt;enumeration value="ANDROID_MARKET"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AppConversionPlatform")
@XmlEnum
public enum AppConversionPlatform {

    ITUNES,
    ANDROID_MARKET;

    public String value() {
        return name();
    }

    public static AppConversionPlatform fromValue(String v) {
        return valueOf(v);
    }

}
