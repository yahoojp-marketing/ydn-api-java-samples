
package jp.yahooapis.im.v201907.adgroupad;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TEXT_LONG_AD1"/>
 *     &lt;enumeration value="TEXT_LONG_AD2"/>
 *     &lt;enumeration value="TEXT_SHORT_AD1"/>
 *     &lt;enumeration value="TEXT_SHORT_AD2"/>
 *     &lt;enumeration value="POS_AD"/>
 *     &lt;enumeration value="RESPONSIVE_IMAGE_AD"/>
 *     &lt;enumeration value="STATIC_FRAME_AD"/>
 *     &lt;enumeration value="RESPONSIVE_VIDEO_AD"/>
 *     &lt;enumeration value="DYNAMIC_AD"/>
 *     &lt;enumeration value="BANNER_IMAGE_AD"/>
 *     &lt;enumeration value="BANNER_VIDEO_AD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AdType")
@XmlEnum
public enum AdType {

    @XmlEnumValue("TEXT_LONG_AD1")
    TEXT_LONG_AD_1("TEXT_LONG_AD1"),
    @XmlEnumValue("TEXT_LONG_AD2")
    TEXT_LONG_AD_2("TEXT_LONG_AD2"),
    @XmlEnumValue("TEXT_SHORT_AD1")
    TEXT_SHORT_AD_1("TEXT_SHORT_AD1"),
    @XmlEnumValue("TEXT_SHORT_AD2")
    TEXT_SHORT_AD_2("TEXT_SHORT_AD2"),
    POS_AD("POS_AD"),
    RESPONSIVE_IMAGE_AD("RESPONSIVE_IMAGE_AD"),
    STATIC_FRAME_AD("STATIC_FRAME_AD"),
    RESPONSIVE_VIDEO_AD("RESPONSIVE_VIDEO_AD"),
    DYNAMIC_AD("DYNAMIC_AD"),
    BANNER_IMAGE_AD("BANNER_IMAGE_AD"),
    BANNER_VIDEO_AD("BANNER_VIDEO_AD");
    private final String value;

    AdType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AdType fromValue(String v) {
        for (AdType c: AdType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
