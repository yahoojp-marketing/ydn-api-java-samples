
package jp.yahooapis.im.v201907.promotionalaccount;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountOperation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountOperation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201907/PromotionalAccount}Operation">
 *       &lt;sequence>
 *         &lt;element name="bizId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operand" type="{http://im.yahooapis.jp/V201907/PromotionalAccount}Account" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountOperation", propOrder = {
    "bizId",
    "operand"
})
public class AccountOperation
    extends Operation
{

    protected String bizId;
    @XmlElement(required = true)
    protected List<Account> operand;

    /**
     * Gets the value of the bizId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBizId() {
        return bizId;
    }

    /**
     * Sets the value of the bizId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBizId(String value) {
        this.bizId = value;
    }

    /**
     * Gets the value of the operand property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operand property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperand().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Account }
     * 
     * 
     */
    public List<Account> getOperand() {
        if (operand == null) {
            operand = new ArrayList<Account>();
        }
        return this.operand;
    }

}
