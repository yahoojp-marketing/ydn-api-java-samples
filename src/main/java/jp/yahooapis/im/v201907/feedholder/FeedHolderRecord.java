
package jp.yahooapis.im.v201907.feedholder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedHolderRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedHolderRecord">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="feedHolderId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="feedHolderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="itemCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="approvedItemCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="disApprovedItemCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="disApprovalReasonListDownloadUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedHolderRecord", propOrder = {
    "accountId",
    "feedHolderId",
    "feedHolderName",
    "itemCount",
    "approvedItemCount",
    "disApprovedItemCount",
    "disApprovalReasonListDownloadUrl"
})
public class FeedHolderRecord {

    protected long accountId;
    protected Long feedHolderId;
    protected String feedHolderName;
    protected Long itemCount;
    protected Long approvedItemCount;
    protected Long disApprovedItemCount;
    protected String disApprovalReasonListDownloadUrl;

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
     * Gets the value of the feedHolderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeedHolderName() {
        return feedHolderName;
    }

    /**
     * Sets the value of the feedHolderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeedHolderName(String value) {
        this.feedHolderName = value;
    }

    /**
     * Gets the value of the itemCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getItemCount() {
        return itemCount;
    }

    /**
     * Sets the value of the itemCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setItemCount(Long value) {
        this.itemCount = value;
    }

    /**
     * Gets the value of the approvedItemCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getApprovedItemCount() {
        return approvedItemCount;
    }

    /**
     * Sets the value of the approvedItemCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setApprovedItemCount(Long value) {
        this.approvedItemCount = value;
    }

    /**
     * Gets the value of the disApprovedItemCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDisApprovedItemCount() {
        return disApprovedItemCount;
    }

    /**
     * Sets the value of the disApprovedItemCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDisApprovedItemCount(Long value) {
        this.disApprovedItemCount = value;
    }

    /**
     * Gets the value of the disApprovalReasonListDownloadUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisApprovalReasonListDownloadUrl() {
        return disApprovalReasonListDownloadUrl;
    }

    /**
     * Sets the value of the disApprovalReasonListDownloadUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisApprovalReasonListDownloadUrl(String value) {
        this.disApprovalReasonListDownloadUrl = value;
    }

}
