
package jp.yahooapis.im.v201907.stats;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AppTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AppTarget">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201907/Stats}Target">
 *       &lt;sequence>
 *         &lt;element name="appType" type="{http://im.yahooapis.jp/V201907/Stats}DeviceAppType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppTarget", propOrder = {
    "appType"
})
public class AppTarget
    extends Target
{

    @XmlSchemaType(name = "string")
    protected DeviceAppType appType;

    /**
     * Gets the value of the appType property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceAppType }
     *     
     */
    public DeviceAppType getAppType() {
        return appType;
    }

    /**
     * Sets the value of the appType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceAppType }
     *     
     */
    public void setAppType(DeviceAppType value) {
        this.appType = value;
    }

}
