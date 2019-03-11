
package jp.yahooapis.im.v201903.conversiontracker;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201903.Paging;


/**
 * <p>Java class for ConversionTrackerSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConversionTrackerSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="conversionTrackerIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="conversionTrackerTypes" type="{http://im.yahooapis.jp/V201903/ConversionTracker}ConversionTrackerType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="statuses" type="{http://im.yahooapis.jp/V201903/ConversionTracker}ConversionTrackerStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="categories" type="{http://im.yahooapis.jp/V201903/ConversionTracker}ConversionTrackerCategory" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="appIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="countingType" type="{http://im.yahooapis.jp/V201903/ConversionTracker}ConversionCountingType" minOccurs="0"/>
 *         &lt;element name="excludeFromBidding" type="{http://im.yahooapis.jp/V201903/ConversionTracker}ExcludeFromBidding" minOccurs="0"/>
 *         &lt;element name="appPlatform" type="{http://im.yahooapis.jp/V201903/ConversionTracker}AppConversionPlatform" minOccurs="0"/>
 *         &lt;element name="statsPeriod" type="{http://im.yahooapis.jp/V201903/ConversionTracker}StatsPeriod" minOccurs="0"/>
 *         &lt;element name="statsPeriodCustomDate" type="{http://im.yahooapis.jp/V201903/ConversionTracker}StatsPeriodCustomDate" minOccurs="0"/>
 *         &lt;element name="paging" type="{http://im.yahooapis.jp/V201903}Paging" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConversionTrackerSelector", propOrder = {
    "accountId",
    "conversionTrackerIds",
    "conversionTrackerTypes",
    "statuses",
    "categories",
    "appIds",
    "countingType",
    "excludeFromBidding",
    "appPlatform",
    "statsPeriod",
    "statsPeriodCustomDate",
    "paging"
})
public class ConversionTrackerSelector {

    protected long accountId;
    @XmlElement(type = Long.class)
    protected List<Long> conversionTrackerIds;
    @XmlSchemaType(name = "string")
    protected List<ConversionTrackerType> conversionTrackerTypes;
    @XmlSchemaType(name = "string")
    protected List<ConversionTrackerStatus> statuses;
    @XmlSchemaType(name = "string")
    protected List<ConversionTrackerCategory> categories;
    protected List<String> appIds;
    @XmlSchemaType(name = "string")
    protected ConversionCountingType countingType;
    @XmlSchemaType(name = "string")
    protected ExcludeFromBidding excludeFromBidding;
    @XmlSchemaType(name = "string")
    protected AppConversionPlatform appPlatform;
    @XmlSchemaType(name = "string")
    protected StatsPeriod statsPeriod;
    protected StatsPeriodCustomDate statsPeriodCustomDate;
    protected Paging paging;

    /**
     * Gets the value of the accountId property.
     * 
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     */
    public void setAccountId(long value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the conversionTrackerIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conversionTrackerIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConversionTrackerIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getConversionTrackerIds() {
        if (conversionTrackerIds == null) {
            conversionTrackerIds = new ArrayList<Long>();
        }
        return this.conversionTrackerIds;
    }

    /**
     * Gets the value of the conversionTrackerTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conversionTrackerTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConversionTrackerTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConversionTrackerType }
     * 
     * 
     */
    public List<ConversionTrackerType> getConversionTrackerTypes() {
        if (conversionTrackerTypes == null) {
            conversionTrackerTypes = new ArrayList<ConversionTrackerType>();
        }
        return this.conversionTrackerTypes;
    }

    /**
     * Gets the value of the statuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConversionTrackerStatus }
     * 
     * 
     */
    public List<ConversionTrackerStatus> getStatuses() {
        if (statuses == null) {
            statuses = new ArrayList<ConversionTrackerStatus>();
        }
        return this.statuses;
    }

    /**
     * Gets the value of the categories property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categories property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategories().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConversionTrackerCategory }
     * 
     * 
     */
    public List<ConversionTrackerCategory> getCategories() {
        if (categories == null) {
            categories = new ArrayList<ConversionTrackerCategory>();
        }
        return this.categories;
    }

    /**
     * Gets the value of the appIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAppIds() {
        if (appIds == null) {
            appIds = new ArrayList<String>();
        }
        return this.appIds;
    }

    /**
     * Gets the value of the countingType property.
     * 
     * @return
     *     possible object is
     *     {@link ConversionCountingType }
     *     
     */
    public ConversionCountingType getCountingType() {
        return countingType;
    }

    /**
     * Sets the value of the countingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConversionCountingType }
     *     
     */
    public void setCountingType(ConversionCountingType value) {
        this.countingType = value;
    }

    /**
     * Gets the value of the excludeFromBidding property.
     * 
     * @return
     *     possible object is
     *     {@link ExcludeFromBidding }
     *     
     */
    public ExcludeFromBidding getExcludeFromBidding() {
        return excludeFromBidding;
    }

    /**
     * Sets the value of the excludeFromBidding property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcludeFromBidding }
     *     
     */
    public void setExcludeFromBidding(ExcludeFromBidding value) {
        this.excludeFromBidding = value;
    }

    /**
     * Gets the value of the appPlatform property.
     * 
     * @return
     *     possible object is
     *     {@link AppConversionPlatform }
     *     
     */
    public AppConversionPlatform getAppPlatform() {
        return appPlatform;
    }

    /**
     * Sets the value of the appPlatform property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppConversionPlatform }
     *     
     */
    public void setAppPlatform(AppConversionPlatform value) {
        this.appPlatform = value;
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
     * Gets the value of the paging property.
     * 
     * @return
     *     possible object is
     *     {@link Paging }
     *     
     */
    public Paging getPaging() {
        return paging;
    }

    /**
     * Sets the value of the paging property.
     * 
     * @param value
     *     allowed object is
     *     {@link Paging }
     *     
     */
    public void setPaging(Paging value) {
        this.paging = value;
    }

}
