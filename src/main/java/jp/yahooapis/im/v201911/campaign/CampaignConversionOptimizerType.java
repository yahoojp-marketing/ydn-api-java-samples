
package jp.yahooapis.im.v201911.campaign;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampaignConversionOptimizerType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CampaignConversionOptimizerType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MANUAL"/>
 *     &lt;enumeration value="AUTO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CampaignConversionOptimizerType")
@XmlEnum
public enum CampaignConversionOptimizerType {

    MANUAL,
    AUTO;

    public String value() {
        return name();
    }

    public static CampaignConversionOptimizerType fromValue(String v) {
        return valueOf(v);
    }

}
