
package jp.yahooapis.im.V6.VideoService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VideoFileType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VideoFileType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MP4"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VideoFileType")
@XmlEnum
public enum VideoFileType {

    @XmlEnumValue("MP4")
    MP_4("MP4");
    private final String value;

    VideoFileType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VideoFileType fromValue(String v) {
        for (VideoFileType c: VideoFileType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
