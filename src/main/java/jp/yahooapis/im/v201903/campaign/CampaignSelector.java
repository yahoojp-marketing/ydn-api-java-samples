
package jp.yahooapis.im.v201903.campaign;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201903.Paging;


/**
 * <p>Java class for CampaignSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="labelIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="containsLabelIdFlg" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="userStatus" type="{http://im.yahooapis.jp/V201903/Campaign}UserStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="feedHolderIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="paging" type="{http://im.yahooapis.jp/V201903}Paging" minOccurs="0"/>
 *         &lt;element name="campaignType" type="{http://im.yahooapis.jp/V201903/Campaign}CampaignType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampaignSelector", propOrder = {
    "accountId",
    "campaignIds",
    "labelIds",
    "containsLabelIdFlg",
    "userStatus",
    "feedHolderIds",
    "paging",
    "campaignType"
})
public class CampaignSelector {

    protected long accountId;
    @XmlElement(type = Long.class)
    protected List<Long> campaignIds;
    @XmlElement(type = Long.class)
    protected List<Long> labelIds;
    protected Boolean containsLabelIdFlg;
    @XmlSchemaType(name = "string")
    protected List<UserStatus> userStatus;
    @XmlElement(type = Long.class)
    protected List<Long> feedHolderIds;
    protected Paging paging;
    @XmlSchemaType(name = "string")
    protected CampaignType campaignType;

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
     * Gets the value of the campaignIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the campaignIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCampaignIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getCampaignIds() {
        if (campaignIds == null) {
            campaignIds = new ArrayList<Long>();
        }
        return this.campaignIds;
    }

    /**
     * Gets the value of the labelIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the labelIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLabelIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getLabelIds() {
        if (labelIds == null) {
            labelIds = new ArrayList<Long>();
        }
        return this.labelIds;
    }

    /**
     * Gets the value of the containsLabelIdFlg property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isContainsLabelIdFlg() {
        return containsLabelIdFlg;
    }

    /**
     * Sets the value of the containsLabelIdFlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContainsLabelIdFlg(Boolean value) {
        this.containsLabelIdFlg = value;
    }

    /**
     * Gets the value of the userStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserStatus }
     * 
     * 
     */
    public List<UserStatus> getUserStatus() {
        if (userStatus == null) {
            userStatus = new ArrayList<UserStatus>();
        }
        return this.userStatus;
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

}
