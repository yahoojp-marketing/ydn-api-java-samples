
package jp.yahooapis.im.v201907.feeddata;

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
 *         &lt;element name="itemListUploadType" type="{http://im.yahooapis.jp/V201907/FeedData}ItemListUploadType" minOccurs="0"/>
 *         &lt;element name="itemListUploadStatus" type="{http://im.yahooapis.jp/V201907/FeedData}FileUploadStatus" minOccurs="0"/>
 *         &lt;element name="uploadDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="completeDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="errorCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="errorRate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="errorListDownloadUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="itemListUploadSrc" type="{http://im.yahooapis.jp/V201907/FeedData}FileUploadSrc" minOccurs="0"/>
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
@XmlType(name = "FeedDataRecord", propOrder = {
    "accountId",
    "feedHolderId",
    "itemListUploadId",
    "itemListUploadType",
    "itemListUploadStatus",
    "uploadDate",
    "completeDate",
    "errorCount",
    "errorRate",
    "errorListDownloadUrl",
    "itemListUploadSrc",
    "isDebug"
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
    protected String completeDate;
    protected Long errorCount;
    protected Double errorRate;
    protected String errorListDownloadUrl;
    @XmlSchemaType(name = "string")
    protected FileUploadSrc itemListUploadSrc;
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
     * Gets the value of the completeDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompleteDate() {
        return completeDate;
    }

    /**
     * Sets the value of the completeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompleteDate(String value) {
        this.completeDate = value;
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
     * Gets the value of the errorRate property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getErrorRate() {
        return errorRate;
    }

    /**
     * Sets the value of the errorRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setErrorRate(Double value) {
        this.errorRate = value;
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

    /**
     * Gets the value of the itemListUploadSrc property.
     * 
     * @return
     *     possible object is
     *     {@link FileUploadSrc }
     *     
     */
    public FileUploadSrc getItemListUploadSrc() {
        return itemListUploadSrc;
    }

    /**
     * Sets the value of the itemListUploadSrc property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileUploadSrc }
     *     
     */
    public void setItemListUploadSrc(FileUploadSrc value) {
        this.itemListUploadSrc = value;
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
