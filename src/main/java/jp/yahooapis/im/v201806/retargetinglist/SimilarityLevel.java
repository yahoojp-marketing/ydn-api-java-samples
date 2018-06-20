
package jp.yahooapis.im.v201806.retargetinglist;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SimilarityLevel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SimilarityLevel">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LOW"/>
 *     &lt;enumeration value="MID"/>
 *     &lt;enumeration value="HIGH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SimilarityLevel")
@XmlEnum
public enum SimilarityLevel {

    LOW,
    MID,
    HIGH;

    public String value() {
        return name();
    }

    public static SimilarityLevel fromValue(String v) {
        return valueOf(v);
    }

}
