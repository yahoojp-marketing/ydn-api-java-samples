
package jp.yahooapis.im.v201911.reportdefinition;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RunReportJob.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RunReportJob">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRUE"/>
 *     &lt;enumeration value="FALSE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RunReportJob")
@XmlEnum
public enum RunReportJob {

    TRUE,
    FALSE;

    public String value() {
        return name();
    }

    public static RunReportJob fromValue(String v) {
        return valueOf(v);
    }

}
