
package jp.yahooapis.im.v201911.account;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="accountType" type="{http://im.yahooapis.jp/V201911/Account}AccountType" minOccurs="0"/>
 *         &lt;element name="accountStatus" type="{http://im.yahooapis.jp/V201911/Account}AccountStatus" minOccurs="0"/>
 *         &lt;element name="deliveryStatus" type="{http://im.yahooapis.jp/V201911/Account}DeliveryStatus" minOccurs="0"/>
 *         &lt;element name="budget" type="{http://im.yahooapis.jp/V201911/Account}AccountBudget" minOccurs="0"/>
 *         &lt;element name="autoTaggingEnabled" type="{http://im.yahooapis.jp/V201911/Account}AutoTaggingEnabled" minOccurs="0"/>
 *         &lt;element name="accountAuthorities" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
    "accountType",
    "accountStatus",
    "deliveryStatus",
    "budget",
    "autoTaggingEnabled",
    "accountAuthorities"
})
public class Account {

    protected Long accountId;
    protected String accountName;
    @XmlSchemaType(name = "string")
    protected AccountType accountType;
    @XmlSchemaType(name = "string")
    protected AccountStatus accountStatus;
    @XmlSchemaType(name = "string")
    protected DeliveryStatus deliveryStatus;
    protected AccountBudget budget;
    @XmlSchemaType(name = "string")
    protected AutoTaggingEnabled autoTaggingEnabled;
    protected List<String> accountAuthorities;

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
     * Gets the value of the accountType property.
     * 
     * @return
     *     possible object is
     *     {@link AccountType }
     *     
     */
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountType }
     *     
     */
    public void setAccountType(AccountType value) {
        this.accountType = value;
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
     * Gets the value of the budget property.
     * 
     * @return
     *     possible object is
     *     {@link AccountBudget }
     *     
     */
    public AccountBudget getBudget() {
        return budget;
    }

    /**
     * Sets the value of the budget property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountBudget }
     *     
     */
    public void setBudget(AccountBudget value) {
        this.budget = value;
    }

    /**
     * Gets the value of the autoTaggingEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link AutoTaggingEnabled }
     *     
     */
    public AutoTaggingEnabled getAutoTaggingEnabled() {
        return autoTaggingEnabled;
    }

    /**
     * Sets the value of the autoTaggingEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link AutoTaggingEnabled }
     *     
     */
    public void setAutoTaggingEnabled(AutoTaggingEnabled value) {
        this.autoTaggingEnabled = value;
    }

    /**
     * Gets the value of the accountAuthorities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accountAuthorities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountAuthorities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAccountAuthorities() {
        if (accountAuthorities == null) {
            accountAuthorities = new ArrayList<String>();
        }
        return this.accountAuthorities;
    }

}
