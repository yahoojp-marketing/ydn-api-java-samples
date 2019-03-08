
package jp.yahooapis.im.v201903.auditlog;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuditLogDownloadJobStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AuditLogDownloadJobStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IN_PROGRESS"/>
 *     &lt;enumeration value="COMPLETED"/>
 *     &lt;enumeration value="SYSTEM_ERROR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AuditLogDownloadJobStatus")
@XmlEnum
public enum AuditLogDownloadJobStatus {

    IN_PROGRESS,
    COMPLETED,
    SYSTEM_ERROR;

    public String value() {
        return name();
    }

    public static AuditLogDownloadJobStatus fromValue(String v) {
        return valueOf(v);
    }

}
