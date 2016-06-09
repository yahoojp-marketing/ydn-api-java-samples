
package jp.yahooapis.im.V5.StatsService;

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
 *     &lt;enumeration value="REALTIME_TODAY"/>
 *     &lt;enumeration value="DEFINITE_VALUE_YESTERDAY"/>
 *     &lt;enumeration value="DEFINITE_VALUE_LASTWEEK"/>
 *     &lt;enumeration value="DEFINITE_VALUE_LASTBSDAY"/>
 *     &lt;enumeration value="DEFINITE_VALUE_WEEK"/>
 *     &lt;enumeration value="DEFINITE_VALUE_TWOWEEK"/>
 *     &lt;enumeration value="DEFINITE_VALUE_THIRTYDAY"/>
 *     &lt;enumeration value="REALTIME_MONTH"/>
 *     &lt;enumeration value="DEFINITE_VALUE_LASTMONTH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StatsPeriod")
@XmlEnum
public enum StatsPeriod {

    REALTIME_TODAY,
    DEFINITE_VALUE_YESTERDAY,
    DEFINITE_VALUE_LASTWEEK,
    DEFINITE_VALUE_LASTBSDAY,
    DEFINITE_VALUE_WEEK,
    DEFINITE_VALUE_TWOWEEK,
    DEFINITE_VALUE_THIRTYDAY,
    REALTIME_MONTH,
    DEFINITE_VALUE_LASTMONTH;

    public String value() {
        return name();
    }

    public static StatsPeriod fromValue(String v) {
        return valueOf(v);
    }

}
