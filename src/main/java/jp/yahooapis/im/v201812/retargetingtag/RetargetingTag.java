
package jp.yahooapis.im.v201812.retargetingtag;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetargetingTag complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetargetingTag">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="retargetingTagId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="approvalStatus" type="{http://im.yahooapis.jp/V201812/RetargetingTag}RetargetingTagApprovalStatus" minOccurs="0"/>
 *         &lt;element name="tag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetargetingTag", propOrder = {
    "retargetingTagId",
    "accountId",
    "approvalStatus",
    "tag"
})
public class RetargetingTag {

    @XmlElement(required = true)
    protected String retargetingTagId;
    protected long accountId;
    @XmlSchemaType(name = "string")
    protected RetargetingTagApprovalStatus approvalStatus;
    protected String tag;

    /**
     * Gets the value of the retargetingTagId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRetargetingTagId() {
        return retargetingTagId;
    }

    /**
     * Sets the value of the retargetingTagId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRetargetingTagId(String value) {
        this.retargetingTagId = value;
    }

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
     * Gets the value of the approvalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link RetargetingTagApprovalStatus }
     *     
     */
    public RetargetingTagApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * Sets the value of the approvalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetargetingTagApprovalStatus }
     *     
     */
    public void setApprovalStatus(RetargetingTagApprovalStatus value) {
        this.approvalStatus = value;
    }

    /**
     * Gets the value of the tag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTag() {
        return tag;
    }

    /**
     * Sets the value of the tag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTag(String value) {
        this.tag = value;
    }

}
