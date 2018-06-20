
package jp.yahooapis.im.v201806.conversiontracker;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StatsPeriod.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StatsPeriod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DEFINITE_VALUE_DAY"/>
 *     &lt;enumeration value="DEFINITE_VALUE_LASTBSDAY"/>
 *     &lt;enumeration value="DEFINITE_VALUE_LASTWEEK"/>
 *     &lt;enumeration value="DEFINITE_VALUE_WEEK"/>
 *     &lt;enumeration value="DEFINITE_VALUE_TWOWEEK"/>
 *     &lt;enumeration value="DEFINITE_VALUE_THIRTYDAY"/>
 *     &lt;enumeration value="DEFINITE_VALUE_LASTMONTH"/>
 *     &lt;enumeration value="REALTIME_TODAY"/>
 *     &lt;enumeration value="REALTIME_MONTH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StatsPeriod")
@XmlEnum
public enum StatsPeriod {

    DEFINITE_VALUE_DAY,
    DEFINITE_VALUE_LASTBSDAY,
    DEFINITE_VALUE_LASTWEEK,
    DEFINITE_VALUE_WEEK,
    DEFINITE_VALUE_TWOWEEK,
    DEFINITE_VALUE_THIRTYDAY,
    DEFINITE_VALUE_LASTMONTH,
    REALTIME_TODAY,
    REALTIME_MONTH;

    public String value() {
        return name();
    }

    public static StatsPeriod fromValue(String v) {
        return valueOf(v);
    }

}
