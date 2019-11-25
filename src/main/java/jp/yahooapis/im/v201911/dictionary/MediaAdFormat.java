
package jp.yahooapis.im.v201911.dictionary;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MediaAdFormat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MediaAdFormat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adFormat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="transparent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="logo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="thumbnail" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sizeTo" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="maxWidth" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="maxHeight" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="aspectWidth" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="aspectHeight" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="staticImage" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="aspect" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="aspectRatio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="campaignBanner" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MediaAdFormat", propOrder = {
    "adFormat",
    "width",
    "height",
    "size",
    "transparent",
    "logo",
    "thumbnail",
    "sizeTo",
    "maxWidth",
    "maxHeight",
    "aspectWidth",
    "aspectHeight",
    "staticImage",
    "aspect",
    "aspectRatio",
    "campaignBanner"
})
public class MediaAdFormat {

    @XmlElement(required = true)
    protected String adFormat;
    protected long width;
    protected long height;
    protected long size;
    protected boolean transparent;
    protected boolean logo;
    protected boolean thumbnail;
    protected long sizeTo;
    protected long maxWidth;
    protected long maxHeight;
    protected long aspectWidth;
    protected long aspectHeight;
    protected boolean staticImage;
    protected boolean aspect;
    @XmlElement(required = true)
    protected String aspectRatio;
    protected boolean campaignBanner;

    /**
     * Gets the value of the adFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdFormat() {
        return adFormat;
    }

    /**
     * Sets the value of the adFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdFormat(String value) {
        this.adFormat = value;
    }

    /**
     * Gets the value of the width property.
     * 
     */
    public long getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     */
    public void setWidth(long value) {
        this.width = value;
    }

    /**
     * Gets the value of the height property.
     * 
     */
    public long getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     */
    public void setHeight(long value) {
        this.height = value;
    }

    /**
     * Gets the value of the size property.
     * 
     */
    public long getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     */
    public void setSize(long value) {
        this.size = value;
    }

    /**
     * Gets the value of the transparent property.
     * 
     */
    public boolean isTransparent() {
        return transparent;
    }

    /**
     * Sets the value of the transparent property.
     * 
     */
    public void setTransparent(boolean value) {
        this.transparent = value;
    }

    /**
     * Gets the value of the logo property.
     * 
     */
    public boolean isLogo() {
        return logo;
    }

    /**
     * Sets the value of the logo property.
     * 
     */
    public void setLogo(boolean value) {
        this.logo = value;
    }

    /**
     * Gets the value of the thumbnail property.
     * 
     */
    public boolean isThumbnail() {
        return thumbnail;
    }

    /**
     * Sets the value of the thumbnail property.
     * 
     */
    public void setThumbnail(boolean value) {
        this.thumbnail = value;
    }

    /**
     * Gets the value of the sizeTo property.
     * 
     */
    public long getSizeTo() {
        return sizeTo;
    }

    /**
     * Sets the value of the sizeTo property.
     * 
     */
    public void setSizeTo(long value) {
        this.sizeTo = value;
    }

    /**
     * Gets the value of the maxWidth property.
     * 
     */
    public long getMaxWidth() {
        return maxWidth;
    }

    /**
     * Sets the value of the maxWidth property.
     * 
     */
    public void setMaxWidth(long value) {
        this.maxWidth = value;
    }

    /**
     * Gets the value of the maxHeight property.
     * 
     */
    public long getMaxHeight() {
        return maxHeight;
    }

    /**
     * Sets the value of the maxHeight property.
     * 
     */
    public void setMaxHeight(long value) {
        this.maxHeight = value;
    }

    /**
     * Gets the value of the aspectWidth property.
     * 
     */
    public long getAspectWidth() {
        return aspectWidth;
    }

    /**
     * Sets the value of the aspectWidth property.
     * 
     */
    public void setAspectWidth(long value) {
        this.aspectWidth = value;
    }

    /**
     * Gets the value of the aspectHeight property.
     * 
     */
    public long getAspectHeight() {
        return aspectHeight;
    }

    /**
     * Sets the value of the aspectHeight property.
     * 
     */
    public void setAspectHeight(long value) {
        this.aspectHeight = value;
    }

    /**
     * Gets the value of the staticImage property.
     * 
     */
    public boolean isStaticImage() {
        return staticImage;
    }

    /**
     * Sets the value of the staticImage property.
     * 
     */
    public void setStaticImage(boolean value) {
        this.staticImage = value;
    }

    /**
     * Gets the value of the aspect property.
     * 
     */
    public boolean isAspect() {
        return aspect;
    }

    /**
     * Sets the value of the aspect property.
     * 
     */
    public void setAspect(boolean value) {
        this.aspect = value;
    }

    /**
     * Gets the value of the aspectRatio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAspectRatio() {
        return aspectRatio;
    }

    /**
     * Sets the value of the aspectRatio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAspectRatio(String value) {
        this.aspectRatio = value;
    }

    /**
     * Gets the value of the campaignBanner property.
     * 
     */
    public boolean isCampaignBanner() {
        return campaignBanner;
    }

    /**
     * Sets the value of the campaignBanner property.
     * 
     */
    public void setCampaignBanner(boolean value) {
        this.campaignBanner = value;
    }

}
