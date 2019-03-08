
package jp.yahooapis.im.v201903.campaign;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConversionOptimizerEligibilityFlg.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConversionOptimizerEligibilityFlg">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ENABLE"/>
 *     &lt;enumeration value="DISABLE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConversionOptimizerEligibilityFlg")
@XmlEnum
public enum ConversionOptimizerEligibilityFlg {

    ENABLE,
    DISABLE;

    public String value() {
        return name();
    }

    public static ConversionOptimizerEligibilityFlg fromValue(String v) {
        return valueOf(v);
    }

}
