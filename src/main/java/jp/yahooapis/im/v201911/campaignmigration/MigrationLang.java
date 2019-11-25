
package jp.yahooapis.im.v201911.campaignmigration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MigrationLang.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MigrationLang">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="JA"/>
 *     &lt;enumeration value="EN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MigrationLang")
@XmlEnum
public enum MigrationLang {

    JA,
    EN;

    public String value() {
        return name();
    }

    public static MigrationLang fromValue(String v) {
        return valueOf(v);
    }

}
