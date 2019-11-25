
package jp.yahooapis.im.v201911.adgroup;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampaignGoalFilterType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CampaignGoalFilterType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALL"/>
 *     &lt;enumeration value="NON_GOAL"/>
 *     &lt;enumeration value="GOAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CampaignGoalFilterType")
@XmlEnum
public enum CampaignGoalFilterType {

    ALL,
    NON_GOAL,
    GOAL;

    public String value() {
        return name();
    }

    public static CampaignGoalFilterType fromValue(String v) {
        return valueOf(v);
    }

}
