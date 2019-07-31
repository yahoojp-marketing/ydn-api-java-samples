
package jp.yahooapis.im.v201907.feedftp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedFtp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedFtp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="feedHolderId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="itemListUploadType" type="{http://im.yahooapis.jp/V201907/FeedFtp}ItemListUploadType" minOccurs="0"/>
 *         &lt;element name="schedule" type="{http://im.yahooapis.jp/V201907/FeedFtp}Schedule" minOccurs="0"/>
 *         &lt;element name="feedUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activeStatus" type="{http://im.yahooapis.jp/V201907/FeedFtp}ActiveStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedFtp", propOrder = {
    "accountId",
    "feedHolderId",
    "itemListUploadType",
    "schedule",
    "feedUrl",
    "userName",
    "userPassword",
    "activeStatus"
})
public class FeedFtp {

    protected Long accountId;
    protected long feedHolderId;
    @XmlSchemaType(name = "string")
    protected ItemListUploadType itemListUploadType;
    protected Schedule schedule;
    protected String feedUrl;
    protected String userName;
    protected String userPassword;
    @XmlSchemaType(name = "string")
    protected ActiveStatus activeStatus;

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
     * Gets the value of the feedHolderId property.
     * 
     */
    public long getFeedHolderId() {
        return feedHolderId;
    }

    /**
     * Sets the value of the feedHolderId property.
     * 
     */
    public void setFeedHolderId(long value) {
        this.feedHolderId = value;
    }

    /**
     * Gets the value of the itemListUploadType property.
     * 
     * @return
     *     possible object is
     *     {@link ItemListUploadType }
     *     
     */
    public ItemListUploadType getItemListUploadType() {
        return itemListUploadType;
    }

    /**
     * Sets the value of the itemListUploadType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemListUploadType }
     *     
     */
    public void setItemListUploadType(ItemListUploadType value) {
        this.itemListUploadType = value;
    }

    /**
     * Gets the value of the schedule property.
     * 
     * @return
     *     possible object is
     *     {@link Schedule }
     *     
     */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * Sets the value of the schedule property.
     * 
     * @param value
     *     allowed object is
     *     {@link Schedule }
     *     
     */
    public void setSchedule(Schedule value) {
        this.schedule = value;
    }

    /**
     * Gets the value of the feedUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeedUrl() {
        return feedUrl;
    }

    /**
     * Sets the value of the feedUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeedUrl(String value) {
        this.feedUrl = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the userPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets the value of the userPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserPassword(String value) {
        this.userPassword = value;
    }

    /**
     * Gets the value of the activeStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ActiveStatus }
     *     
     */
    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }

    /**
     * Sets the value of the activeStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveStatus }
     *     
     */
    public void setActiveStatus(ActiveStatus value) {
        this.activeStatus = value;
    }

}
