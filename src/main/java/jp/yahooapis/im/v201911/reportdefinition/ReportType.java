
package jp.yahooapis.im.v201911.reportdefinition;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AD"/>
 *     &lt;enumeration value="INTEREST_CATEGORY"/>
 *     &lt;enumeration value="SITE_CATEGORY"/>
 *     &lt;enumeration value="URL"/>
 *     &lt;enumeration value="FREQUENCY"/>
 *     &lt;enumeration value="LABEL"/>
 *     &lt;enumeration value="AUDIENCE_CATEGORY"/>
 *     &lt;enumeration value="REACH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportType")
@XmlEnum
public enum ReportType {

    AD,
    INTEREST_CATEGORY,
    SITE_CATEGORY,
    URL,
    FREQUENCY,
    LABEL,
    AUDIENCE_CATEGORY,
    REACH;

    public String value() {
        return name();
    }

    public static ReportType fromValue(String v) {
        return valueOf(v);
    }

}
