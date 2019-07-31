
package jp.yahooapis.im.v201907.stats;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CarrierTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CarrierTarget">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201907/Stats}Target">
 *       &lt;sequence>
 *         &lt;element name="mobileCarrier" type="{http://im.yahooapis.jp/V201907/Stats}CarrierType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CarrierTarget", propOrder = {
    "mobileCarrier"
})
public class CarrierTarget
    extends Target
{

    @XmlSchemaType(name = "string")
    protected CarrierType mobileCarrier;

    /**
     * Gets the value of the mobileCarrier property.
     * 
     * @return
     *     possible object is
     *     {@link CarrierType }
     *     
     */
    public CarrierType getMobileCarrier() {
        return mobileCarrier;
    }

    /**
     * Sets the value of the mobileCarrier property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarrierType }
     *     
     */
    public void setMobileCarrier(CarrierType value) {
        this.mobileCarrier = value;
    }

}
