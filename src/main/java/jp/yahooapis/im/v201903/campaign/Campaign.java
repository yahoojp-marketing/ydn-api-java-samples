
package jp.yahooapis.im.v201903.campaign;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Campaign complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Campaign">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="campaignName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userStatus" type="{http://im.yahooapis.jp/V201903/Campaign}UserStatus" minOccurs="0"/>
 *         &lt;element name="servingStatus" type="{http://im.yahooapis.jp/V201903/Campaign}CampaignServingStatus" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="budget" type="{http://im.yahooapis.jp/V201903/Campaign}Budget" minOccurs="0"/>
 *         &lt;element name="biddingStrategy" type="{http://im.yahooapis.jp/V201903/Campaign}BiddingStrategy" minOccurs="0"/>
 *         &lt;element name="adProductType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="frequencyCap" type="{http://im.yahooapis.jp/V201903/Campaign}FrequencyCap" minOccurs="0"/>
 *         &lt;element name="conversionOptimizer" type="{http://im.yahooapis.jp/V201903/Campaign}CampaignConversionOptimizer" minOccurs="0"/>
 *         &lt;element name="campaignType" type="{http://im.yahooapis.jp/V201903/Campaign}CampaignType" minOccurs="0"/>
 *         &lt;element name="appName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appOs" type="{http://im.yahooapis.jp/V201903/Campaign}DeviceOsType" minOccurs="0"/>
 *         &lt;element name="labels" type="{http://im.yahooapis.jp/V201903/Campaign}Label" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="feedHolderId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Campaign", propOrder = {
    "accountId",
    "campaignId",
    "campaignName",
    "userStatus",
    "servingStatus",
    "startDate",
    "endDate",
    "budget",
    "biddingStrategy",
    "adProductType",
    "frequencyCap",
    "conversionOptimizer",
    "campaignType",
    "appName",
    "appId",
    "appOs",
    "labels",
    "feedHolderId"
})
public class Campaign {

    protected long accountId;
    protected Long campaignId;
    protected String campaignName;
    @XmlSchemaType(name = "string")
    protected UserStatus userStatus;
    @XmlSchemaType(name = "string")
    protected CampaignServingStatus servingStatus;
    protected String startDate;
    protected String endDate;
    protected Budget budget;
    protected BiddingStrategy biddingStrategy;
    protected String adProductType;
    protected FrequencyCap frequencyCap;
    protected CampaignConversionOptimizer conversionOptimizer;
    @XmlSchemaType(name = "string")
    protected CampaignType campaignType;
    protected String appName;
    protected String appId;
    @XmlSchemaType(name = "string")
    protected DeviceOsType appOs;
    protected List<Label> labels;
    protected Long feedHolderId;

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
     * Gets the value of the campaignName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampaignName() {
        return campaignName;
    }

    /**
     * Sets the value of the campaignName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampaignName(String value) {
        this.campaignName = value;
    }

    /**
     * Gets the value of the userStatus property.
     * 
     * @return
     *     possible object is
     *     {@link UserStatus }
     *     
     */
    public UserStatus getUserStatus() {
        return userStatus;
    }

    /**
     * Sets the value of the userStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserStatus }
     *     
     */
    public void setUserStatus(UserStatus value) {
        this.userStatus = value;
    }

    /**
     * Gets the value of the servingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignServingStatus }
     *     
     */
    public CampaignServingStatus getServingStatus() {
        return servingStatus;
    }

    /**
     * Sets the value of the servingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignServingStatus }
     *     
     */
    public void setServingStatus(CampaignServingStatus value) {
        this.servingStatus = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the budget property.
     * 
     * @return
     *     possible object is
     *     {@link Budget }
     *     
     */
    public Budget getBudget() {
        return budget;
    }

    /**
     * Sets the value of the budget property.
     * 
     * @param value
     *     allowed object is
     *     {@link Budget }
     *     
     */
    public void setBudget(Budget value) {
        this.budget = value;
    }

    /**
     * Gets the value of the biddingStrategy property.
     * 
     * @return
     *     possible object is
     *     {@link BiddingStrategy }
     *     
     */
    public BiddingStrategy getBiddingStrategy() {
        return biddingStrategy;
    }

    /**
     * Sets the value of the biddingStrategy property.
     * 
     * @param value
     *     allowed object is
     *     {@link BiddingStrategy }
     *     
     */
    public void setBiddingStrategy(BiddingStrategy value) {
        this.biddingStrategy = value;
    }

    /**
     * Gets the value of the adProductType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdProductType() {
        return adProductType;
    }

    /**
     * Sets the value of the adProductType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdProductType(String value) {
        this.adProductType = value;
    }

    /**
     * Gets the value of the frequencyCap property.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyCap }
     *     
     */
    public FrequencyCap getFrequencyCap() {
        return frequencyCap;
    }

    /**
     * Sets the value of the frequencyCap property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyCap }
     *     
     */
    public void setFrequencyCap(FrequencyCap value) {
        this.frequencyCap = value;
    }

    /**
     * Gets the value of the conversionOptimizer property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignConversionOptimizer }
     *     
     */
    public CampaignConversionOptimizer getConversionOptimizer() {
        return conversionOptimizer;
    }

    /**
     * Sets the value of the conversionOptimizer property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignConversionOptimizer }
     *     
     */
    public void setConversionOptimizer(CampaignConversionOptimizer value) {
        this.conversionOptimizer = value;
    }

    /**
     * Gets the value of the campaignType property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignType }
     *     
     */
    public CampaignType getCampaignType() {
        return campaignType;
    }

    /**
     * Sets the value of the campaignType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignType }
     *     
     */
    public void setCampaignType(CampaignType value) {
        this.campaignType = value;
    }

    /**
     * Gets the value of the appName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppName() {
        return appName;
    }

    /**
     * Sets the value of the appName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppName(String value) {
        this.appName = value;
    }

    /**
     * Gets the value of the appId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppId() {
        return appId;
    }

    /**
     * Sets the value of the appId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppId(String value) {
        this.appId = value;
    }

    /**
     * Gets the value of the appOs property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceOsType }
     *     
     */
    public DeviceOsType getAppOs() {
        return appOs;
    }

    /**
     * Sets the value of the appOs property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceOsType }
     *     
     */
    public void setAppOs(DeviceOsType value) {
        this.appOs = value;
    }

    /**
     * Gets the value of the labels property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the labels property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLabels().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Label }
     * 
     * 
     */
    public List<Label> getLabels() {
        if (labels == null) {
            labels = new ArrayList<Label>();
        }
        return this.labels;
    }

    /**
     * Gets the value of the feedHolderId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFeedHolderId() {
        return feedHolderId;
    }

    /**
     * Sets the value of the feedHolderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFeedHolderId(Long value) {
        this.feedHolderId = value;
    }

}
