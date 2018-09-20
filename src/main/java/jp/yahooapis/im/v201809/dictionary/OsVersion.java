
package jp.yahooapis.im.v201809.dictionary;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OsVersion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OsVersion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="osType" type="{http://im.yahooapis.jp/V201809/Dictionary}DeviceOsType"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OsVersion", propOrder = {
    "osType",
    "version"
})
public class OsVersion {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected DeviceOsType osType;
    @XmlElement(required = true)
    protected String version;

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

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
