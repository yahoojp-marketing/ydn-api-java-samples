
package jp.yahooapis.im.v201903.promotionalaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201903.ReturnValue;


/**
 * <p>Java class for AccountValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201903}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="account" type="{http://im.yahooapis.jp/V201903/PromotionalAccount}Account" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountValues", propOrder = {
    "account"
})
public class AccountValues
    extends ReturnValue
{

    protected Account account;

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setAccount(Account value) {
        this.account = value;
    }

}
