
package jp.yahooapis.im.v201812.feeddata;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201812.Paging;


/**
 * <p>Java class for FeedDataSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedDataSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="feedHolderIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="itemListUploadIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="uploadStatuses" type="{http://im.yahooapis.jp/V201812/FeedData}FileUploadStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dateRange" type="{http://im.yahooapis.jp/V201812/FeedData}FileUploadDateRange" minOccurs="0"/>
 *         &lt;element name="paging" type="{http://im.yahooapis.jp/V201812}Paging" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedDataSelector", propOrder = {
    "accountId",
    "feedHolderIds",
    "itemListUploadIds",
    "uploadStatuses",
    "dateRange",
    "paging"
})
public class FeedDataSelector {

    protected long accountId;
    @XmlElement(type = Long.class)
    protected List<Long> feedHolderIds;
    @XmlElement(type = Long.class)
    protected List<Long> itemListUploadIds;
    @XmlSchemaType(name = "string")
    protected List<FileUploadStatus> uploadStatuses;
    protected FileUploadDateRange dateRange;
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
     * Gets the value of the feedHolderIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feedHolderIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeedHolderIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getFeedHolderIds() {
        if (feedHolderIds == null) {
            feedHolderIds = new ArrayList<Long>();
        }
        return this.feedHolderIds;
    }

    /**
     * Gets the value of the itemListUploadIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemListUploadIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemListUploadIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getItemListUploadIds() {
        if (itemListUploadIds == null) {
            itemListUploadIds = new ArrayList<Long>();
        }
        return this.itemListUploadIds;
    }

    /**
     * Gets the value of the uploadStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uploadStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUploadStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FileUploadStatus }
     * 
     * 
     */
    public List<FileUploadStatus> getUploadStatuses() {
        if (uploadStatuses == null) {
            uploadStatuses = new ArrayList<FileUploadStatus>();
        }
        return this.uploadStatuses;
    }

    /**
     * Gets the value of the dateRange property.
     * 
     * @return
     *     possible object is
     *     {@link FileUploadDateRange }
     *     
     */
    public FileUploadDateRange getDateRange() {
        return dateRange;
    }

    /**
     * Sets the value of the dateRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileUploadDateRange }
     *     
     */
    public void setDateRange(FileUploadDateRange value) {
        this.dateRange = value;
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
