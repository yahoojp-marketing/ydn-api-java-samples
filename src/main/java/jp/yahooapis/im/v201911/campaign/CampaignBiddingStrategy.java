
package jp.yahooapis.im.v201911.campaign;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampaignBiddingStrategy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignBiddingStrategy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://im.yahooapis.jp/V201911/Campaign}CampaignBiddingStrategyType"/>
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
@XmlType(name = "CampaignBiddingStrategy", propOrder = {
    "type",
    "maxVcpmBidValue",
    "maxCpcBidValue",
    "maxCpvBidValue",
    "targetCpaBidValue"
})
public class CampaignBiddingStrategy {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CampaignBiddingStrategyType type;
    protected Long maxVcpmBidValue;
    protected Long maxCpcBidValue;
    protected Long maxCpvBidValue;
    protected Long targetCpaBidValue;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignBiddingStrategyType }
     *     
     */
    public CampaignBiddingStrategyType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignBiddingStrategyType }
     *     
     */
    public void setType(CampaignBiddingStrategyType value) {
        this.type = value;
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
