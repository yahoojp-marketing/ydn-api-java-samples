
package jp.yahooapis.im.v201907.adgrouptarget;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeviceOsType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DeviceOsType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IOS"/>
 *     &lt;enumeration value="ANDROID"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DeviceOsType")
@XmlEnum
public enum DeviceOsType {

    IOS,
    ANDROID;

    public String value() {
        return name();
    }

    public static DeviceOsType fromValue(String v) {
        return valueOf(v);
    }

}
