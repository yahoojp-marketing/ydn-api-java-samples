
package jp.yahooapis.im.v201911.campaign;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampaignBiddingStrategyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CampaignBiddingStrategyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AUTO"/>
 *     &lt;enumeration value="MAX_VCPM"/>
 *     &lt;enumeration value="MAX_CPC"/>
 *     &lt;enumeration value="MAX_CPV"/>
 *     &lt;enumeration value="TARGET_CPA"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CampaignBiddingStrategyType")
@XmlEnum
public enum CampaignBiddingStrategyType {

    AUTO,
    MAX_VCPM,
    MAX_CPC,
    MAX_CPV,
    TARGET_CPA,
    NONE;

    public String value() {
        return name();
    }

    public static CampaignBiddingStrategyType fromValue(String v) {
        return valueOf(v);
    }

}
