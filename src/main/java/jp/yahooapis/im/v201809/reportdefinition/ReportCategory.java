
package jp.yahooapis.im.v201809.reportdefinition;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportCategory.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportCategory">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AD"/>
 *     &lt;enumeration value="INTEREST_CATEGORY"/>
 *     &lt;enumeration value="SITE_CATEGORY"/>
 *     &lt;enumeration value="URL"/>
 *     &lt;enumeration value="FREQUENCY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportCategory")
@XmlEnum
public enum ReportCategory {

    AD,
    INTEREST_CATEGORY,
    SITE_CATEGORY,
    URL,
    FREQUENCY;

    public String value() {
        return name();
    }

    public static ReportCategory fromValue(String v) {
        return valueOf(v);
    }

}
