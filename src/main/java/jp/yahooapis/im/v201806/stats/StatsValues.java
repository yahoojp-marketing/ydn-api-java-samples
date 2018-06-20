
package jp.yahooapis.im.v201806.stats;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201806.ReturnValue;


/**
 * <p>Java class for StatsValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatsValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201806}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="campaignId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adGroupId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="mediaId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="statsPeriod" type="{http://im.yahooapis.jp/V201806/Stats}StatsPeriod" minOccurs="0"/>
 *         &lt;element name="statsType" type="{http://im.yahooapis.jp/V201806/Stats}StatsType" minOccurs="0"/>
 *         &lt;element name="stats" type="{http://im.yahooapis.jp/V201806/Stats}Stats" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatsValues", propOrder = {
    "accountId",
    "campaignId",
    "adGroupId",
    "adId",
    "mediaId",
    "statsPeriod",
    "statsType",
    "stats"
})
public class StatsValues
    extends ReturnValue
{

    protected Long accountId;
    protected Long campaignId;
    protected Long adGroupId;
    protected Long adId;
    protected Long mediaId;
    @XmlSchemaType(name = "string")
    protected StatsPeriod statsPeriod;
    @XmlSchemaType(name = "string")
    protected StatsType statsType;
    protected Stats stats;

    /**
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccountId(Long value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the campaignId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCampaignId() {
        return campaignId;
    }

    /**
     * Sets the value of the campaignId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCampaignId(Long value) {
        this.campaignId = value;
    }

    /**
     * Gets the value of the adGroupId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdGroupId() {
        return adGroupId;
    }

    /**
     * Sets the value of the adGroupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdGroupId(Long value) {
        this.adGroupId = value;
    }

    /**
     * Gets the value of the adId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdId() {
        return adId;
    }

    /**
     * Sets the value of the adId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdId(Long value) {
        this.adId = value;
    }

    /**
     * Gets the value of the mediaId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMediaId() {
        return mediaId;
    }

    /**
     * Sets the value of the mediaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMediaId(Long value) {
        this.mediaId = value;
    }

    /**
     * Gets the value of the statsPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link StatsPeriod }
     *     
     */
    public StatsPeriod getStatsPeriod() {
        return statsPeriod;
    }

    /**
     * Sets the value of the statsPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatsPeriod }
     *     
     */
    public void setStatsPeriod(StatsPeriod value) {
        this.statsPeriod = value;
    }

    /**
     * Gets the value of the statsType property.
     * 
     * @return
     *     possible object is
     *     {@link StatsType }
     *     
     */
    public StatsType getStatsType() {
        return statsType;
    }

    /**
     * Sets the value of the statsType property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatsType }
     *     
     */
    public void setStatsType(StatsType value) {
        this.statsType = value;
    }

    /**
     * Gets the value of the stats property.
     * 
     * @return
     *     possible object is
     *     {@link Stats }
     *     
     */
    public Stats getStats() {
        return stats;
    }

    /**
     * Sets the value of the stats property.
     * 
     * @param value
     *     allowed object is
     *     {@link Stats }
     *     
     */
    public void setStats(Stats value) {
        this.stats = value;
    }

}
