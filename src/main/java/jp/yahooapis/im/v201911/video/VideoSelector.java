
package jp.yahooapis.im.v201911.video;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201911.Paging;


/**
 * <p>Java class for VideoSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VideoSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="mediaIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="userStatuses" type="{http://im.yahooapis.jp/V201911/Video}UserStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="approvalStatuses" type="{http://im.yahooapis.jp/V201911/Video}ApprovalStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="processStatuses" type="{http://im.yahooapis.jp/V201911/Video}VideoProcessStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="paging" type="{http://im.yahooapis.jp/V201911}Paging" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VideoSelector", propOrder = {
    "accountId",
    "mediaIds",
    "userStatuses",
    "approvalStatuses",
    "processStatuses",
    "paging"
})
public class VideoSelector {

    protected long accountId;
    @XmlElement(type = Long.class)
    protected List<Long> mediaIds;
    @XmlSchemaType(name = "string")
    protected List<UserStatus> userStatuses;
    @XmlSchemaType(name = "string")
    protected List<ApprovalStatus> approvalStatuses;
    @XmlSchemaType(name = "string")
    protected List<VideoProcessStatus> processStatuses;
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
     * Gets the value of the mediaIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mediaIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMediaIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getMediaIds() {
        if (mediaIds == null) {
            mediaIds = new ArrayList<Long>();
        }
        return this.mediaIds;
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
     * Gets the value of the approvalStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the approvalStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApprovalStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApprovalStatus }
     * 
     * 
     */
    public List<ApprovalStatus> getApprovalStatuses() {
        if (approvalStatuses == null) {
            approvalStatuses = new ArrayList<ApprovalStatus>();
        }
        return this.approvalStatuses;
    }

    /**
     * Gets the value of the processStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the processStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcessStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VideoProcessStatus }
     * 
     * 
     */
    public List<VideoProcessStatus> getProcessStatuses() {
        if (processStatuses == null) {
            processStatuses = new ArrayList<VideoProcessStatus>();
        }
        return this.processStatuses;
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
