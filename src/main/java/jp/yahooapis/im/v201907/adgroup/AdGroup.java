
package jp.yahooapis.im.v201907.adgroup;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adGroupId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adGroupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userStatus" type="{http://im.yahooapis.jp/V201907/AdGroup}UserStatus" minOccurs="0"/>
 *         &lt;element name="bid" type="{http://im.yahooapis.jp/V201907/AdGroup}AdGroupBid" minOccurs="0"/>
 *         &lt;element name="conversionOptimizer" type="{http://im.yahooapis.jp/V201907/AdGroup}AdGroupConversionOptimizer" minOccurs="0"/>
 *         &lt;element name="device" type="{http://im.yahooapis.jp/V201907/AdGroup}DeviceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deviceApp" type="{http://im.yahooapis.jp/V201907/AdGroup}DeviceAppType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deviceOs" type="{http://im.yahooapis.jp/V201907/AdGroup}DeviceOsType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="smartDeviceCarriers" type="{http://im.yahooapis.jp/V201907/AdGroup}SmartDeviceCarrier" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deviceOsVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dynamicImageExtensions" type="{http://im.yahooapis.jp/V201907/AdGroup}DynamicImageExtensions" minOccurs="0"/>
 *         &lt;element name="labels" type="{http://im.yahooapis.jp/V201907/AdGroup}Label" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="feedSetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isRemoveFeedSetId" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroup", propOrder = {
    "accountId",
    "campaignId",
    "campaignName",
    "adGroupId",
    "adGroupName",
    "userStatus",
    "bid",
    "conversionOptimizer",
    "device",
    "deviceApp",
    "deviceOs",
    "smartDeviceCarriers",
    "deviceOsVersion",
    "dynamicImageExtensions",
    "labels",
    "feedSetId",
    "isRemoveFeedSetId"
})
public class AdGroup {

    protected long accountId;
    protected long campaignId;
    protected String campaignName;
    protected Long adGroupId;
    protected String adGroupName;
    @XmlSchemaType(name = "string")
    protected UserStatus userStatus;
    protected AdGroupBid bid;
    protected AdGroupConversionOptimizer conversionOptimizer;
    @XmlSchemaType(name = "string")
    protected List<DeviceType> device;
    @XmlSchemaType(name = "string")
    protected List<DeviceAppType> deviceApp;
    @XmlSchemaType(name = "string")
    protected List<DeviceOsType> deviceOs;
    @XmlSchemaType(name = "string")
    protected List<SmartDeviceCarrier> smartDeviceCarriers;
    protected String deviceOsVersion;
    @XmlSchemaType(name = "string")
    protected DynamicImageExtensions dynamicImageExtensions;
    protected List<Label> labels;
    protected Long feedSetId;
    protected Boolean isRemoveFeedSetId;

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
     */
    public long getCampaignId() {
        return campaignId;
    }

    /**
     * Sets the value of the campaignId property.
     * 
     */
    public void setCampaignId(long value) {
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
     * Gets the value of the adGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdGroupName() {
        return adGroupName;
    }

    /**
     * Sets the value of the adGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdGroupName(String value) {
        this.adGroupName = value;
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
     * Gets the value of the bid property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroupBid }
     *     
     */
    public AdGroupBid getBid() {
        return bid;
    }

    /**
     * Sets the value of the bid property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroupBid }
     *     
     */
    public void setBid(AdGroupBid value) {
        this.bid = value;
    }

    /**
     * Gets the value of the conversionOptimizer property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroupConversionOptimizer }
     *     
     */
    public AdGroupConversionOptimizer getConversionOptimizer() {
        return conversionOptimizer;
    }

    /**
     * Sets the value of the conversionOptimizer property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroupConversionOptimizer }
     *     
     */
    public void setConversionOptimizer(AdGroupConversionOptimizer value) {
        this.conversionOptimizer = value;
    }

    /**
     * Gets the value of the device property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the device property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDevice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeviceType }
     * 
     * 
     */
    public List<DeviceType> getDevice() {
        if (device == null) {
            device = new ArrayList<DeviceType>();
        }
        return this.device;
    }

    /**
     * Gets the value of the deviceApp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deviceApp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeviceApp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeviceAppType }
     * 
     * 
     */
    public List<DeviceAppType> getDeviceApp() {
        if (deviceApp == null) {
            deviceApp = new ArrayList<DeviceAppType>();
        }
        return this.deviceApp;
    }

    /**
     * Gets the value of the deviceOs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deviceOs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeviceOs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeviceOsType }
     * 
     * 
     */
    public List<DeviceOsType> getDeviceOs() {
        if (deviceOs == null) {
            deviceOs = new ArrayList<DeviceOsType>();
        }
        return this.deviceOs;
    }

    /**
     * Gets the value of the smartDeviceCarriers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the smartDeviceCarriers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSmartDeviceCarriers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SmartDeviceCarrier }
     * 
     * 
     */
    public List<SmartDeviceCarrier> getSmartDeviceCarriers() {
        if (smartDeviceCarriers == null) {
            smartDeviceCarriers = new ArrayList<SmartDeviceCarrier>();
        }
        return this.smartDeviceCarriers;
    }

    /**
     * Gets the value of the deviceOsVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceOsVersion() {
        return deviceOsVersion;
    }

    /**
     * Sets the value of the deviceOsVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceOsVersion(String value) {
        this.deviceOsVersion = value;
    }

    /**
     * Gets the value of the dynamicImageExtensions property.
     * 
     * @return
     *     possible object is
     *     {@link DynamicImageExtensions }
     *     
     */
    public DynamicImageExtensions getDynamicImageExtensions() {
        return dynamicImageExtensions;
    }

    /**
     * Sets the value of the dynamicImageExtensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link DynamicImageExtensions }
     *     
     */
    public void setDynamicImageExtensions(DynamicImageExtensions value) {
        this.dynamicImageExtensions = value;
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
     * Gets the value of the feedSetId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFeedSetId() {
        return feedSetId;
    }

    /**
     * Sets the value of the feedSetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFeedSetId(Long value) {
        this.feedSetId = value;
    }

    /**
     * Gets the value of the isRemoveFeedSetId property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsRemoveFeedSetId() {
        return isRemoveFeedSetId;
    }

    /**
     * Sets the value of the isRemoveFeedSetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsRemoveFeedSetId(Boolean value) {
        this.isRemoveFeedSetId = value;
    }

}
