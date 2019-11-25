
package jp.yahooapis.im.v201911.feedftp;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ScheduleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ScheduleType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HOURLY"/>
 *     &lt;enumeration value="DAILY"/>
 *     &lt;enumeration value="WEEKLY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ScheduleType")
@XmlEnum
public enum ScheduleType {

    HOURLY,
    DAILY,
    WEEKLY;

    public String value() {
        return name();
    }

    public static ScheduleType fromValue(String v) {
        return valueOf(v);
    }

}
