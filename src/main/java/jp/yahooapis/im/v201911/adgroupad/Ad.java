
package jp.yahooapis.im.v201911.adgroupad;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Ad complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Ad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://im.yahooapis.jp/V201911/AdGroupAd}AdType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ad", propOrder = {
    "type"
})
@XmlSeeAlso({
    MobileAd.class,
    TextAd.class,
    StaticFrameAd.class,
    DynamicAd.class,
    PosAd.class,
    ResponsiveVideoAd.class,
    BannerImageAd.class,
    BannerVideoAd.class,
    ResponsiveImageAd.class
})
public class Ad {

    @XmlSchemaType(name = "string")
    protected AdType type;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link AdType }
     *     
     */
    public AdType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdType }
     *     
     */
    public void setType(AdType value) {
        this.type = value;
    }

}
