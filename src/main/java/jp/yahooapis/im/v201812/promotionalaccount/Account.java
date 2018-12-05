
package jp.yahooapis.im.v201812.promotionalaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Account complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Account">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="accountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountStatus" type="{http://im.yahooapis.jp/V201812/PromotionalAccount}AccountStatus" minOccurs="0"/>
 *         &lt;element name="deliveryStatus" type="{http://im.yahooapis.jp/V201812/PromotionalAccount}DeliveryStatus" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountPayment" type="{http://im.yahooapis.jp/V201812/PromotionalAccount}AccountPayment" minOccurs="0"/>
 *         &lt;element name="contactBizId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="agencyPersonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="agencyPrefectureCode" type="{http://im.yahooapis.jp/V201812/PromotionalAccount}PrefectureCode" minOccurs="0"/>
 *         &lt;element name="client" type="{http://im.yahooapis.jp/V201812/PromotionalAccount}Client" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Account", propOrder = {
    "accountId",
    "accountName",
    "accountStatus",
    "deliveryStatus",
    "startDate",
    "endDate",
    "accountPayment",
    "contactBizId",
    "agencyPersonName",
    "agencyPrefectureCode",
    "client"
})
public class Account {

    protected Long accountId;
    protected String accountName;
    @XmlSchemaType(name = "string")
    protected AccountStatus accountStatus;
    @XmlSchemaType(name = "string")
    protected DeliveryStatus deliveryStatus;
    protected String startDate;
    protected String endDate;
    protected AccountPayment accountPayment;
    protected String contactBizId;
    protected String agencyPersonName;
    @XmlSchemaType(name = "string")
    protected PrefectureCode agencyPrefectureCode;
    protected Client client;

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
     * Gets the value of the accountName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets the value of the accountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountName(String value) {
        this.accountName = value;
    }

    /**
     * Gets the value of the accountStatus property.
     * 
     * @return
     *     possible object is
     *     {@link AccountStatus }
     *     
     */
    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    /**
     * Sets the value of the accountStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountStatus }
     *     
     */
    public void setAccountStatus(AccountStatus value) {
        this.accountStatus = value;
    }

    /**
     * Gets the value of the deliveryStatus property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryStatus }
     *     
     */
    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    /**
     * Sets the value of the deliveryStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryStatus }
     *     
     */
    public void setDeliveryStatus(DeliveryStatus value) {
        this.deliveryStatus = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the accountPayment property.
     * 
     * @return
     *     possible object is
     *     {@link AccountPayment }
     *     
     */
    public AccountPayment getAccountPayment() {
        return accountPayment;
    }

    /**
     * Sets the value of the accountPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountPayment }
     *     
     */
    public void setAccountPayment(AccountPayment value) {
        this.accountPayment = value;
    }

    /**
     * Gets the value of the contactBizId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactBizId() {
        return contactBizId;
    }

    /**
     * Sets the value of the contactBizId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactBizId(String value) {
        this.contactBizId = value;
    }

    /**
     * Gets the value of the agencyPersonName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencyPersonName() {
        return agencyPersonName;
    }

    /**
     * Sets the value of the agencyPersonName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencyPersonName(String value) {
        this.agencyPersonName = value;
    }

    /**
     * Gets the value of the agencyPrefectureCode property.
     * 
     * @return
     *     possible object is
     *     {@link PrefectureCode }
     *     
     */
    public PrefectureCode getAgencyPrefectureCode() {
        return agencyPrefectureCode;
    }

    /**
     * Sets the value of the agencyPrefectureCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrefectureCode }
     *     
     */
    public void setAgencyPrefectureCode(PrefectureCode value) {
        this.agencyPrefectureCode = value;
    }

    /**
     * Gets the value of the client property.
     * 
     * @return
     *     possible object is
     *     {@link Client }
     *     
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets the value of the client property.
     * 
     * @param value
     *     allowed object is
     *     {@link Client }
     *     
     */
    public void setClient(Client value) {
        this.client = value;
    }

}
