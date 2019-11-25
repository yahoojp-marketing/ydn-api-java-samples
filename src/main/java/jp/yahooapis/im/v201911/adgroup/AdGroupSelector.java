
package jp.yahooapis.im.v201911.adgroup;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201911.Paging;


/**
 * <p>Java class for AdGroupSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adGroupIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="labelIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="containsLabelIdFlg" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="userStatuses" type="{http://im.yahooapis.jp/V201911/AdGroup}UserStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="feedSetIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="paging" type="{http://im.yahooapis.jp/V201911}Paging" minOccurs="0"/>
 *         &lt;element name="campaignGoalFilterType" type="{http://im.yahooapis.jp/V201911/AdGroup}CampaignGoalFilterType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupSelector", propOrder = {
    "accountId",
    "campaignIds",
    "adGroupIds",
    "labelIds",
    "containsLabelIdFlg",
    "userStatuses",
    "feedSetIds",
    "paging",
    "campaignGoalFilterType"
})
public class AdGroupSelector {

    protected long accountId;
    @XmlElement(type = Long.class)
    protected List<Long> campaignIds;
    @XmlElement(type = Long.class)
    protected List<Long> adGroupIds;
    @XmlElement(type = Long.class)
    protected List<Long> labelIds;
    protected Boolean containsLabelIdFlg;
    @XmlSchemaType(name = "string")
    protected List<UserStatus> userStatuses;
    @XmlElement(type = Long.class)
    protected List<Long> feedSetIds;
    protected Paging paging;
    @XmlSchemaType(name = "string")
    protected CampaignGoalFilterType campaignGoalFilterType;

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
     * Gets the value of the adGroupIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adGroupIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdGroupIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getAdGroupIds() {
        if (adGroupIds == null) {
            adGroupIds = new ArrayList<Long>();
        }
        return this.adGroupIds;
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
     * Gets the value of the userStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserStatus }
     * 
     * 
     */
    public List<UserStatus> getUserStatuses() {
        if (userStatuses == null) {
            userStatuses = new ArrayList<UserStatus>();
        }
        return this.userStatuses;
    }

    /**
     * Gets the value of the feedSetIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feedSetIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeedSetIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getFeedSetIds() {
        if (feedSetIds == null) {
            feedSetIds = new ArrayList<Long>();
        }
        return this.feedSetIds;
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
     * Gets the value of the campaignGoalFilterType property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignGoalFilterType }
     *     
     */
    public CampaignGoalFilterType getCampaignGoalFilterType() {
        return campaignGoalFilterType;
    }

    /**
     * Sets the value of the campaignGoalFilterType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignGoalFilterType }
     *     
     */
    public void setCampaignGoalFilterType(CampaignGoalFilterType value) {
        this.campaignGoalFilterType = value;
    }

}
