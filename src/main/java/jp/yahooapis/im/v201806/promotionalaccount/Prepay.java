
package jp.yahooapis.im.v201806.promotionalaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Prepay complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Prepay">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201806/PromotionalAccount}AccountPayment">
 *       &lt;sequence>
 *         &lt;element name="autoChargeStatus" type="{http://im.yahooapis.jp/V201806/PromotionalAccount}AutoChargeStatus" minOccurs="0"/>
 *         &lt;element name="autoCharge" type="{http://im.yahooapis.jp/V201806/PromotionalAccount}AutoCharge" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Prepay", propOrder = {
    "autoChargeStatus",
    "autoCharge"
})
public class Prepay
    extends AccountPayment
{

    @XmlSchemaType(name = "string")
    protected AutoChargeStatus autoChargeStatus;
    protected AutoCharge autoCharge;

    /**
     * Gets the value of the autoChargeStatus property.
     * 
     * @return
     *     possible object is
     *     {@link AutoChargeStatus }
     *     
     */
    public AutoChargeStatus getAutoChargeStatus() {
        return autoChargeStatus;
    }

    /**
     * Sets the value of the autoChargeStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link AutoChargeStatus }
     *     
     */
    public void setAutoChargeStatus(AutoChargeStatus value) {
        this.autoChargeStatus = value;
    }

    /**
     * Gets the value of the autoCharge property.
     * 
     * @return
     *     possible object is
     *     {@link AutoCharge }
     *     
     */
    public AutoCharge getAutoCharge() {
        return autoCharge;
    }

    /**
     * Sets the value of the autoCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link AutoCharge }
     *     
     */
    public void setAutoCharge(AutoCharge value) {
        this.autoCharge = value;
    }

}
