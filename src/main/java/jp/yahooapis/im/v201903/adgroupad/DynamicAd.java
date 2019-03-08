
package jp.yahooapis.im.v201903.adgroupad;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DynamicAd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DynamicAd">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201903/AdGroupAd}Ad">
 *       &lt;sequence>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="displayUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="buttonText" type="{http://im.yahooapis.jp/V201903/AdGroupAd}ButtonText" minOccurs="0"/>
 *         &lt;element name="principal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="logoMediaId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="logoMediaId2" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="logoMediaId3" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="prefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="suffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="brandColor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DynamicAd", propOrder = {
    "url",
    "displayUrl",
    "buttonText",
    "principal",
    "logoMediaId",
    "logoMediaId2",
    "logoMediaId3",
    "prefix",
    "suffix",
    "brandColor"
})
public class DynamicAd
    extends Ad
{

    protected String url;
    protected String displayUrl;
    @XmlSchemaType(name = "string")
    protected ButtonText buttonText;
    protected String principal;
    protected Long logoMediaId;
    protected Long logoMediaId2;
    protected Long logoMediaId3;
    protected String prefix;
    protected String suffix;
    protected String brandColor;

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the displayUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayUrl() {
        return displayUrl;
    }

    /**
     * Sets the value of the displayUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayUrl(String value) {
        this.displayUrl = value;
    }

    /**
     * Gets the value of the buttonText property.
     * 
     * @return
     *     possible object is
     *     {@link ButtonText }
     *     
     */
    public ButtonText getButtonText() {
        return buttonText;
    }

    /**
     * Sets the value of the buttonText property.
     * 
     * @param value
     *     allowed object is
     *     {@link ButtonText }
     *     
     */
    public void setButtonText(ButtonText value) {
        this.buttonText = value;
    }

    /**
     * Gets the value of the principal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrincipal() {
        return principal;
    }

    /**
     * Sets the value of the principal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrincipal(String value) {
        this.principal = value;
    }

    /**
     * Gets the value of the logoMediaId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLogoMediaId() {
        return logoMediaId;
    }

    /**
     * Sets the value of the logoMediaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLogoMediaId(Long value) {
        this.logoMediaId = value;
    }

    /**
     * Gets the value of the logoMediaId2 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLogoMediaId2() {
        return logoMediaId2;
    }

    /**
     * Sets the value of the logoMediaId2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLogoMediaId2(Long value) {
        this.logoMediaId2 = value;
    }

    /**
     * Gets the value of the logoMediaId3 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLogoMediaId3() {
        return logoMediaId3;
    }

    /**
     * Sets the value of the logoMediaId3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLogoMediaId3(Long value) {
        this.logoMediaId3 = value;
    }

    /**
     * Gets the value of the prefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Sets the value of the prefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefix(String value) {
        this.prefix = value;
    }

    /**
     * Gets the value of the suffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Sets the value of the suffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuffix(String value) {
        this.suffix = value;
    }

    /**
     * Gets the value of the brandColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrandColor() {
        return brandColor;
    }

    /**
     * Sets the value of the brandColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrandColor(String value) {
        this.brandColor = value;
    }

}
