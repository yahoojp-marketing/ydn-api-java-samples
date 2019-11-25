
package jp.yahooapis.im.v201911.campaignmigration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MigrationJobStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MigrationJobStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NOT_STARTED"/>
 *     &lt;enumeration value="IN_PROGRESS"/>
 *     &lt;enumeration value="COMPLETED"/>
 *     &lt;enumeration value="FILE_FORMAT_ERROR"/>
 *     &lt;enumeration value="INVALID_CSV_VALUE_ERROR"/>
 *     &lt;enumeration value="UNKNOWN_CSV_FIELD_ERROR"/>
 *     &lt;enumeration value="SYSTEM_ERROR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MigrationJobStatus")
@XmlEnum
public enum MigrationJobStatus {

    NOT_STARTED,
    IN_PROGRESS,
    COMPLETED,
    FILE_FORMAT_ERROR,
    INVALID_CSV_VALUE_ERROR,
    UNKNOWN_CSV_FIELD_ERROR,
    SYSTEM_ERROR;

    public String value() {
        return name();
    }

    public static MigrationJobStatus fromValue(String v) {
        return valueOf(v);
    }

}
