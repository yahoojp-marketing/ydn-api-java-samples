
package jp.yahooapis.im.v201907.auditlog;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuditLogUpdateSource.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AuditLogUpdateSource">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CAMPAIGN_MANAGEMENT_TOOL"/>
 *     &lt;enumeration value="API"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AuditLogUpdateSource")
@XmlEnum
public enum AuditLogUpdateSource {

    CAMPAIGN_MANAGEMENT_TOOL,
    API;

    public String value() {
        return name();
    }

    public static AuditLogUpdateSource fromValue(String v) {
        return valueOf(v);
    }

}
