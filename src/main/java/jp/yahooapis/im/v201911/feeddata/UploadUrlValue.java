
package jp.yahooapis.im.v201911.feeddata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UploadUrlValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UploadUrlValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="itemListUploadType" type="{http://im.yahooapis.jp/V201911/FeedData}ItemListUploadType" minOccurs="0"/>
 *         &lt;element name="feedHolderId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="uploadUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isDebug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UploadUrlValue", propOrder = {
    "accountId",
    "itemListUploadType",
    "feedHolderId",
    "uploadUrl",
    "isDebug"
})
public class UploadUrlValue {

    protected Long accountId;
    @XmlSchemaType(name = "string")
    protected ItemListUploadType itemListUploadType;
    protected Long feedHolderId;
    protected String uploadUrl;
    protected Boolean isDebug;

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

    /**
     * Gets the value of the uploadUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUploadUrl() {
        return uploadUrl;
    }

    /**
     * Sets the value of the uploadUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUploadUrl(String value) {
        this.uploadUrl = value;
    }

    /**
     * Gets the value of the isDebug property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDebug() {
        return isDebug;
    }

    /**
     * Sets the value of the isDebug property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDebug(Boolean value) {
        this.isDebug = value;
    }

}
