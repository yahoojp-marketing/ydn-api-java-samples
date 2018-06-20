
package jp.yahooapis.im.v201806.dictionary;

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
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="transparent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="animation" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="logo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="thumbnail" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="adFormat" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "id",
    "width",
    "height",
    "size",
    "transparent",
    "animation",
    "logo",
    "thumbnail",
    "adFormat"
})
public class MediaAdFormat {

    protected int id;
    protected long width;
    protected long height;
    protected long size;
    protected boolean transparent;
    protected boolean animation;
    protected boolean logo;
    protected boolean thumbnail;
    @XmlElement(required = true)
    protected String adFormat;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
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
     * Gets the value of the animation property.
     * 
     */
    public boolean isAnimation() {
        return animation;
    }

    /**
     * Sets the value of the animation property.
     * 
     */
    public void setAnimation(boolean value) {
        this.animation = value;
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

}
