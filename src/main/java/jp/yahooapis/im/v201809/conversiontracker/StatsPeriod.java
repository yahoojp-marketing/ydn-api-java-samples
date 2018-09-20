
package jp.yahooapis.im.v201809.conversiontracker;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
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
 *     &lt;enumeration value="DEFINITE_VALUE_LAST13MONTH"/>
 *     &lt;enumeration value="CUSTOM_DATE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StatsPeriod")
@XmlEnum
public enum StatsPeriod {

    DEFINITE_VALUE_DAY("DEFINITE_VALUE_DAY"),
    DEFINITE_VALUE_LASTBSDAY("DEFINITE_VALUE_LASTBSDAY"),
    DEFINITE_VALUE_LASTWEEK("DEFINITE_VALUE_LASTWEEK"),
    DEFINITE_VALUE_WEEK("DEFINITE_VALUE_WEEK"),
    DEFINITE_VALUE_TWOWEEK("DEFINITE_VALUE_TWOWEEK"),
    DEFINITE_VALUE_THIRTYDAY("DEFINITE_VALUE_THIRTYDAY"),
    DEFINITE_VALUE_LASTMONTH("DEFINITE_VALUE_LASTMONTH"),
    REALTIME_TODAY("REALTIME_TODAY"),
    REALTIME_MONTH("REALTIME_MONTH"),
    @XmlEnumValue("DEFINITE_VALUE_LAST13MONTH")
    DEFINITE_VALUE_LAST_13_MONTH("DEFINITE_VALUE_LAST13MONTH"),
    CUSTOM_DATE("CUSTOM_DATE");
    private final String value;

    StatsPeriod(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StatsPeriod fromValue(String v) {
        for (StatsPeriod c: StatsPeriod.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
