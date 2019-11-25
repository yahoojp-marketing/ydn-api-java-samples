
package jp.yahooapis.im.v201911.stats;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201911.ReturnValue;


/**
 * <p>Java class for StatsValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatsValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201911}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="statsPeriod" type="{http://im.yahooapis.jp/V201911/Stats}StatsPeriod" minOccurs="0"/>
 *         &lt;element name="statsPeriodCustomDate" type="{http://im.yahooapis.jp/V201911/Stats}StatsPeriodCustomDate" minOccurs="0"/>
 *         &lt;element name="statsType" type="{http://im.yahooapis.jp/V201911/Stats}StatsType" minOccurs="0"/>
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
    "statsPeriod",
    "statsPeriodCustomDate",
    "statsType"
})
@XmlSeeAlso({
    TargetStatsValues.class,
    ImageStatsValues.class,
    CampaignStatsValues.class,
    AdStatsValues.class,
    AdGroupStatsValues.class,
    VideoStatsValues.class
})
public class StatsValues
    extends ReturnValue
{

    protected Long accountId;
    @XmlSchemaType(name = "string")
    protected StatsPeriod statsPeriod;
    protected StatsPeriodCustomDate statsPeriodCustomDate;
    @XmlSchemaType(name = "string")
    protected StatsType statsType;

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
     * Gets the value of the statsPeriodCustomDate property.
     * 
     * @return
     *     possible object is
     *     {@link StatsPeriodCustomDate }
     *     
     */
    public StatsPeriodCustomDate getStatsPeriodCustomDate() {
        return statsPeriodCustomDate;
    }

    /**
     * Sets the value of the statsPeriodCustomDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatsPeriodCustomDate }
     *     
     */
    public void setStatsPeriodCustomDate(StatsPeriodCustomDate value) {
        this.statsPeriodCustomDate = value;
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

}
