
package jp.yahooapis.im.v201806.reportdefinition;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportFrequencyRange.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportFrequencyRange">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DAILY"/>
 *     &lt;enumeration value="WEEKLY"/>
 *     &lt;enumeration value="MONTHLY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportFrequencyRange")
@XmlEnum
public enum ReportFrequencyRange {

    DAILY,
    WEEKLY,
    MONTHLY;

    public String value() {
        return name();
    }

    public static ReportFrequencyRange fromValue(String v) {
        return valueOf(v);
    }

}
