
package jp.yahooapis.im.v201911.bulk;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BulkOutput.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BulkOutput">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TSV"/>
 *     &lt;enumeration value="CSV"/>
 *     &lt;enumeration value="ZIPPED_TSV"/>
 *     &lt;enumeration value="ZIPPED_CSV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BulkOutput")
@XmlEnum
public enum BulkOutput {

    TSV,
    CSV,
    ZIPPED_TSV,
    ZIPPED_CSV;

    public String value() {
        return name();
    }

    public static BulkOutput fromValue(String v) {
        return valueOf(v);
    }

}
