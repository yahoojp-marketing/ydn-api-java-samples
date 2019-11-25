
package jp.yahooapis.im.v201911.accountadproduct;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201911.ReturnValue;


/**
 * <p>Java class for AccountAdProductValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountAdProductValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201911}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="accountAdProduct" type="{http://im.yahooapis.jp/V201911/AccountAdProduct}AccountAdProduct" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountAdProductValues", propOrder = {
    "accountAdProduct"
})
public class AccountAdProductValues
    extends ReturnValue
{

    protected AccountAdProduct accountAdProduct;

    /**
     * Gets the value of the accountAdProduct property.
     * 
     * @return
     *     possible object is
     *     {@link AccountAdProduct }
     *     
     */
    public AccountAdProduct getAccountAdProduct() {
        return accountAdProduct;
    }

    /**
     * Sets the value of the accountAdProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountAdProduct }
     *     
     */
    public void setAccountAdProduct(AccountAdProduct value) {
        this.accountAdProduct = value;
    }

}
