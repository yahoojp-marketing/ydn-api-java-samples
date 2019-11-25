
package jp.yahooapis.im.v201911.campaignmigration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MigrationScope.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MigrationScope">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SINGLE_ACCOUNT"/>
 *     &lt;enumeration value="ALL_ACCOUNT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MigrationScope")
@XmlEnum
public enum MigrationScope {

    SINGLE_ACCOUNT,
    ALL_ACCOUNT;

    public String value() {
        return name();
    }

    public static MigrationScope fromValue(String v) {
        return valueOf(v);
    }

}
