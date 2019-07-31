
package jp.yahooapis.im.v201907.placementurlidea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdFormatConditions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdFormatConditions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adStyle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mediaAdFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdFormatConditions", propOrder = {
    "adStyle",
    "mediaAdFormat"
})
public class AdFormatConditions {

    protected String adStyle;
    protected String mediaAdFormat;

    /**
     * Gets the value of the adStyle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdStyle() {
        return adStyle;
    }

    /**
     * Sets the value of the adStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdStyle(String value) {
        this.adStyle = value;
    }

    /**
     * Gets the value of the mediaAdFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMediaAdFormat() {
        return mediaAdFormat;
    }

    /**
     * Sets the value of the mediaAdFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMediaAdFormat(String value) {
        this.mediaAdFormat = value;
    }

}
