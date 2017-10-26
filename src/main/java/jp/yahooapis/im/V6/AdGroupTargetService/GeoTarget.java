
package jp.yahooapis.im.V6.AdGroupTargetService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GeoTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeoTarget">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V6}Target">
 *       &lt;sequence>
 *         &lt;element name="geoNameJa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="geoNameEn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeoTarget", propOrder = {
    "geoNameJa",
    "geoNameEn"
})
public class GeoTarget
    extends Target
{

    protected String geoNameJa;
    protected String geoNameEn;

    /**
     * Gets the value of the geoNameJa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeoNameJa() {
        return geoNameJa;
    }

    /**
     * Sets the value of the geoNameJa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeoNameJa(String value) {
        this.geoNameJa = value;
    }

    /**
     * Gets the value of the geoNameEn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeoNameEn() {
        return geoNameEn;
    }

    /**
     * Sets the value of the geoNameEn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeoNameEn(String value) {
        this.geoNameEn = value;
    }

}
