
package jp.yahooapis.im.v201911.video;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Video complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Video">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="mediaId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="videoName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="videoTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userStatus" type="{http://im.yahooapis.jp/V201911/Video}UserStatus" minOccurs="0"/>
 *         &lt;element name="creationTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="approvalStatus" type="{http://im.yahooapis.jp/V201911/Video}ApprovalStatus" minOccurs="0"/>
 *         &lt;element name="disapprovalReasonCodes" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="processStatus" type="{http://im.yahooapis.jp/V201911/Video}VideoProcessStatus" minOccurs="0"/>
 *         &lt;element name="videoSetting" type="{http://im.yahooapis.jp/V201911/Video}VideoSetting" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Video", propOrder = {
    "accountId",
    "mediaId",
    "videoName",
    "videoTitle",
    "userStatus",
    "creationTime",
    "approvalStatus",
    "disapprovalReasonCodes",
    "processStatus",
    "videoSetting"
})
public class Video {

    protected long accountId;
    protected Long mediaId;
    protected String videoName;
    protected String videoTitle;
    @XmlSchemaType(name = "string")
    protected UserStatus userStatus;
    protected String creationTime;
    @XmlSchemaType(name = "string")
    protected ApprovalStatus approvalStatus;
    protected List<String> disapprovalReasonCodes;
    @XmlSchemaType(name = "string")
    protected VideoProcessStatus processStatus;
    protected VideoSetting videoSetting;

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
     * Gets the value of the mediaId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMediaId() {
        return mediaId;
    }

    /**
     * Sets the value of the mediaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMediaId(Long value) {
        this.mediaId = value;
    }

    /**
     * Gets the value of the videoName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVideoName() {
        return videoName;
    }

    /**
     * Sets the value of the videoName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVideoName(String value) {
        this.videoName = value;
    }

    /**
     * Gets the value of the videoTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVideoTitle() {
        return videoTitle;
    }

    /**
     * Sets the value of the videoTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVideoTitle(String value) {
        this.videoTitle = value;
    }

    /**
     * Gets the value of the userStatus property.
     * 
     * @return
     *     possible object is
     *     {@link UserStatus }
     *     
     */
    public UserStatus getUserStatus() {
        return userStatus;
    }

    /**
     * Sets the value of the userStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserStatus }
     *     
     */
    public void setUserStatus(UserStatus value) {
        this.userStatus = value;
    }

    /**
     * Gets the value of the creationTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationTime() {
        return creationTime;
    }

    /**
     * Sets the value of the creationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationTime(String value) {
        this.creationTime = value;
    }

    /**
     * Gets the value of the approvalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ApprovalStatus }
     *     
     */
    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * Sets the value of the approvalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApprovalStatus }
     *     
     */
    public void setApprovalStatus(ApprovalStatus value) {
        this.approvalStatus = value;
    }

    /**
     * Gets the value of the disapprovalReasonCodes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disapprovalReasonCodes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisapprovalReasonCodes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDisapprovalReasonCodes() {
        if (disapprovalReasonCodes == null) {
            disapprovalReasonCodes = new ArrayList<String>();
        }
        return this.disapprovalReasonCodes;
    }

    /**
     * Gets the value of the processStatus property.
     * 
     * @return
     *     possible object is
     *     {@link VideoProcessStatus }
     *     
     */
    public VideoProcessStatus getProcessStatus() {
        return processStatus;
    }

    /**
     * Sets the value of the processStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link VideoProcessStatus }
     *     
     */
    public void setProcessStatus(VideoProcessStatus value) {
        this.processStatus = value;
    }

    /**
     * Gets the value of the videoSetting property.
     * 
     * @return
     *     possible object is
     *     {@link VideoSetting }
     *     
     */
    public VideoSetting getVideoSetting() {
        return videoSetting;
    }

    /**
     * Sets the value of the videoSetting property.
     * 
     * @param value
     *     allowed object is
     *     {@link VideoSetting }
     *     
     */
    public void setVideoSetting(VideoSetting value) {
        this.videoSetting = value;
    }

}
