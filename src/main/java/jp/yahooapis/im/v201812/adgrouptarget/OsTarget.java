
package jp.yahooapis.im.v201812.adgrouptarget;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OsTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OsTarget">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201812/AdGroupTarget}Target">
 *       &lt;sequence>
 *         &lt;element name="osType" type="{http://im.yahooapis.jp/V201812/AdGroupTarget}DeviceOsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OsTarget", propOrder = {
    "osType"
})
public class OsTarget
    extends Target
{

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
