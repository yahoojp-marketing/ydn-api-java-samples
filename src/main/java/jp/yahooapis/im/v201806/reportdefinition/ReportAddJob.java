
package jp.yahooapis.im.v201806.reportdefinition;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportAddJob.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportAddJob">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="YES"/>
 *     &lt;enumeration value="NO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportAddJob")
@XmlEnum
public enum ReportAddJob {

    YES,
    NO;

    public String value() {
        return name();
    }

    public static ReportAddJob fromValue(String v) {
        return valueOf(v);
    }

}
