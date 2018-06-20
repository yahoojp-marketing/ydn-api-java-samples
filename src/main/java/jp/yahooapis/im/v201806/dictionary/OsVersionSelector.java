
package jp.yahooapis.im.v201806.dictionary;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OsVersionSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OsVersionSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="osType" type="{http://im.yahooapis.jp/V201806/Dictionary}DeviceOsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OsVersionSelector", propOrder = {
    "osType"
})
public class OsVersionSelector {

    @XmlSchemaType(name = "string")
    protected DeviceOsType osType;

    /**
     * Gets the value of the osType property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceOsType }
     *     
     */
    public DeviceOsType getOsType() {
        return osType;
    }

    /**
     * Sets the value of the osType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceOsType }
     *     
     */
    public void setOsType(DeviceOsType value) {
        this.osType = value;
    }

}
