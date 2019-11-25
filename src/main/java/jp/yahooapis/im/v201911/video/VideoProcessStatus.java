
package jp.yahooapis.im.v201911.video;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VideoProcessStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VideoProcessStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PROCESSING"/>
 *     &lt;enumeration value="FINISHED"/>
 *     &lt;enumeration value="FAILED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VideoProcessStatus")
@XmlEnum
public enum VideoProcessStatus {

    PROCESSING,
    FINISHED,
    FAILED;

    public String value() {
        return name();
    }

    public static VideoProcessStatus fromValue(String v) {
        return valueOf(v);
    }

}
