
package jp.yahooapis.im.v201812.feeddata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="itemListUploadType" type="{http://im.yahooapis.jp/V201812/FeedData}ItemListUploadType"/>
 *         &lt;element name="feedHolderId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "accountId",
    "itemListUploadType",
    "feedHolderId"
})
@XmlRootElement(name = "getUploadUrl")
public class GetUploadUrl {

    protected long accountId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ItemListUploadType itemListUploadType;
    protected long feedHolderId;

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

}
