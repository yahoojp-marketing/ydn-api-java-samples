
package jp.yahooapis.im.v201903.feeddata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedDataRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedDataRecord">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="feedHolderId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="itemListUploadId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="itemListUploadType" type="{http://im.yahooapis.jp/V201903/FeedData}ItemListUploadType" minOccurs="0"/>
 *         &lt;element name="itemListUploadStatus" type="{http://im.yahooapis.jp/V201903/FeedData}FileUploadStatus" minOccurs="0"/>
 *         &lt;element name="uploadDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="errorCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="errorListDownloadUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedDataRecord", propOrder = {
    "accountId",
    "feedHolderId",
    "itemListUploadId",
    "itemListUploadType",
    "itemListUploadStatus",
    "uploadDate",
    "errorCount",
    "errorListDownloadUrl"
})
public class FeedDataRecord {

    protected Long accountId;
    protected Long feedHolderId;
    protected Long itemListUploadId;
    @XmlSchemaType(name = "string")
    protected ItemListUploadType itemListUploadType;
    @XmlSchemaType(name = "string")
    protected FileUploadStatus itemListUploadStatus;
    protected String uploadDate;
    protected Long errorCount;
    protected String errorListDownloadUrl;

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
     * Gets the value of the itemListUploadId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getItemListUploadId() {
        return itemListUploadId;
    }

    /**
     * Sets the value of the itemListUploadId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setItemListUploadId(Long value) {
        this.itemListUploadId = value;
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
     * Gets the value of the itemListUploadStatus property.
     * 
     * @return
     *     possible object is
     *     {@link FileUploadStatus }
     *     
     */
    public FileUploadStatus getItemListUploadStatus() {
        return itemListUploadStatus;
    }

    /**
     * Sets the value of the itemListUploadStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileUploadStatus }
     *     
     */
    public void setItemListUploadStatus(FileUploadStatus value) {
        this.itemListUploadStatus = value;
    }

    /**
     * Gets the value of the uploadDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUploadDate() {
        return uploadDate;
    }

    /**
     * Sets the value of the uploadDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUploadDate(String value) {
        this.uploadDate = value;
    }

    /**
     * Gets the value of the errorCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getErrorCount() {
        return errorCount;
    }

    /**
     * Sets the value of the errorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setErrorCount(Long value) {
        this.errorCount = value;
    }

    /**
     * Gets the value of the errorListDownloadUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorListDownloadUrl() {
        return errorListDownloadUrl;
    }

    /**
     * Sets the value of the errorListDownloadUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorListDownloadUrl(String value) {
        this.errorListDownloadUrl = value;
    }

}
