
package jp.yahooapis.im.v201907.feedset;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedSet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="feedHolderId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="feedSetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="feedSetName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isDefaultSet" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="itemCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="conditionSets" type="{http://im.yahooapis.jp/V201907/FeedSet}ConditionSet" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedSet", propOrder = {
    "accountId",
    "feedHolderId",
    "feedSetId",
    "feedSetName",
    "isDefaultSet",
    "itemCount",
    "conditionSets"
})
public class FeedSet {

    protected Long accountId;
    protected long feedHolderId;
    protected Long feedSetId;
    protected String feedSetName;
    protected Boolean isDefaultSet;
    protected Long itemCount;
    protected List<ConditionSet> conditionSets;

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
     * Gets the value of the feedSetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeedSetName() {
        return feedSetName;
    }

    /**
     * Sets the value of the feedSetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeedSetName(String value) {
        this.feedSetName = value;
    }

    /**
     * Gets the value of the isDefaultSet property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDefaultSet() {
        return isDefaultSet;
    }

    /**
     * Sets the value of the isDefaultSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDefaultSet(Boolean value) {
        this.isDefaultSet = value;
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
     * Gets the value of the conditionSets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conditionSets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConditionSets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConditionSet }
     * 
     * 
     */
    public List<ConditionSet> getConditionSets() {
        if (conditionSets == null) {
            conditionSets = new ArrayList<ConditionSet>();
        }
        return this.conditionSets;
    }

}
