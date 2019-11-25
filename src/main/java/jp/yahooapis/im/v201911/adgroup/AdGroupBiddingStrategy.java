
package jp.yahooapis.im.v201911.adgroup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroupBiddingStrategy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupBiddingStrategy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="campaignBiddingStrategyType" type="{http://im.yahooapis.jp/V201911/AdGroup}CampaignBiddingStrategyType" minOccurs="0"/>
 *         &lt;element name="maxVcpmBidValue" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="maxCpcBidValue" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="maxCpvBidValue" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="targetCpaBidValue" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupBiddingStrategy", propOrder = {
    "campaignBiddingStrategyType",
    "maxVcpmBidValue",
    "maxCpcBidValue",
    "maxCpvBidValue",
    "targetCpaBidValue"
})
public class AdGroupBiddingStrategy {

    @XmlSchemaType(name = "string")
    protected CampaignBiddingStrategyType campaignBiddingStrategyType;
    protected Long maxVcpmBidValue;
    protected Long maxCpcBidValue;
    protected Long maxCpvBidValue;
    protected Long targetCpaBidValue;

    /**
     * Gets the value of the campaignBiddingStrategyType property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignBiddingStrategyType }
     *     
     */
    public CampaignBiddingStrategyType getCampaignBiddingStrategyType() {
        return campaignBiddingStrategyType;
    }

    /**
     * Sets the value of the campaignBiddingStrategyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignBiddingStrategyType }
     *     
     */
    public void setCampaignBiddingStrategyType(CampaignBiddingStrategyType value) {
        this.campaignBiddingStrategyType = value;
    }

    /**
     * Gets the value of the maxVcpmBidValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxVcpmBidValue() {
        return maxVcpmBidValue;
    }

    /**
     * Sets the value of the maxVcpmBidValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxVcpmBidValue(Long value) {
        this.maxVcpmBidValue = value;
    }

    /**
     * Gets the value of the maxCpcBidValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxCpcBidValue() {
        return maxCpcBidValue;
    }

    /**
     * Sets the value of the maxCpcBidValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxCpcBidValue(Long value) {
        this.maxCpcBidValue = value;
    }

    /**
     * Gets the value of the maxCpvBidValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxCpvBidValue() {
        return maxCpvBidValue;
    }

    /**
     * Sets the value of the maxCpvBidValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxCpvBidValue(Long value) {
        this.maxCpvBidValue = value;
    }

    /**
     * Gets the value of the targetCpaBidValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTargetCpaBidValue() {
        return targetCpaBidValue;
    }

    /**
     * Sets the value of the targetCpaBidValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTargetCpaBidValue(Long value) {
        this.targetCpaBidValue = value;
    }

}
