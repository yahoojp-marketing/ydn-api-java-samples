
package jp.yahooapis.im.v201903.adgroupad;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdStyle.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdStyle">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TEXT"/>
 *     &lt;enumeration value="IMAGE"/>
 *     &lt;enumeration value="ANIMATION_IMAGE"/>
 *     &lt;enumeration value="VIDEO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AdStyle")
@XmlEnum
public enum AdStyle {

    TEXT,
    IMAGE,
    ANIMATION_IMAGE,
    VIDEO;

    public String value() {
        return name();
    }

    public static AdStyle fromValue(String v) {
        return valueOf(v);
    }

}
