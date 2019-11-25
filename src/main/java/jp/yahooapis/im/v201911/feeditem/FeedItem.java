
package jp.yahooapis.im.v201911.feeditem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="feedHolderId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="itemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inStock" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="capacity" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isRemoveCapacity" type="{http://im.yahooapis.jp/V201911/FeedItem}isRemoveFlg" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isRemovePrice" type="{http://im.yahooapis.jp/V201911/FeedItem}isRemoveFlg" minOccurs="0"/>
 *         &lt;element name="salePrice" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isRemoveSalePrice" type="{http://im.yahooapis.jp/V201911/FeedItem}isRemoveFlg" minOccurs="0"/>
 *         &lt;element name="formattedPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isRemoveFormattedPrice" type="{http://im.yahooapis.jp/V201911/FeedItem}isRemoveFlg" minOccurs="0"/>
 *         &lt;element name="formattedSalePrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isRemoveFormattedSalePrice" type="{http://im.yahooapis.jp/V201911/FeedItem}isRemoveFlg" minOccurs="0"/>
 *         &lt;element name="displaySettings" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="availability" type="{http://im.yahooapis.jp/V201911/FeedItem}Availability" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedItem", propOrder = {
    "feedHolderId",
    "itemId",
    "inStock",
    "capacity",
    "isRemoveCapacity",
    "price",
    "isRemovePrice",
    "salePrice",
    "isRemoveSalePrice",
    "formattedPrice",
    "isRemoveFormattedPrice",
    "formattedSalePrice",
    "isRemoveFormattedSalePrice",
    "displaySettings",
    "availability"
})
public class FeedItem {

    protected long feedHolderId;
    protected String itemId;
    protected Long inStock;
    protected Long capacity;
    @XmlSchemaType(name = "string")
    protected IsRemoveFlg isRemoveCapacity;
    protected Long price;
    @XmlSchemaType(name = "string")
    protected IsRemoveFlg isRemovePrice;
    protected Long salePrice;
    @XmlSchemaType(name = "string")
    protected IsRemoveFlg isRemoveSalePrice;
    protected String formattedPrice;
    @XmlSchemaType(name = "string")
    protected IsRemoveFlg isRemoveFormattedPrice;
    protected String formattedSalePrice;
    @XmlSchemaType(name = "string")
    protected IsRemoveFlg isRemoveFormattedSalePrice;
    protected Long displaySettings;
    @XmlSchemaType(name = "string")
    protected Availability availability;

    /**
     * Gets the value of the feedHolderId property.
     * 
     */
    public long getFeedHolderId() {
        return feedHolderId;
    }

    /**
     * Sets the value of the feedHolderId property.
     * 
     */
    public void setFeedHolderId(long value) {
        this.feedHolderId = value;
    }

    /**
     * Gets the value of the itemId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * Sets the value of the itemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemId(String value) {
        this.itemId = value;
    }

    /**
     * Gets the value of the inStock property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInStock() {
        return inStock;
    }

    /**
     * Sets the value of the inStock property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInStock(Long value) {
        this.inStock = value;
    }

    /**
     * Gets the value of the capacity property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCapacity() {
        return capacity;
    }

    /**
     * Sets the value of the capacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCapacity(Long value) {
        this.capacity = value;
    }

    /**
     * Gets the value of the isRemoveCapacity property.
     * 
     * @return
     *     possible object is
     *     {@link IsRemoveFlg }
     *     
     */
    public IsRemoveFlg getIsRemoveCapacity() {
        return isRemoveCapacity;
    }

    /**
     * Sets the value of the isRemoveCapacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsRemoveFlg }
     *     
     */
    public void setIsRemoveCapacity(IsRemoveFlg value) {
        this.isRemoveCapacity = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrice(Long value) {
        this.price = value;
    }

    /**
     * Gets the value of the isRemovePrice property.
     * 
     * @return
     *     possible object is
     *     {@link IsRemoveFlg }
     *     
     */
    public IsRemoveFlg getIsRemovePrice() {
        return isRemovePrice;
    }

    /**
     * Sets the value of the isRemovePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsRemoveFlg }
     *     
     */
    public void setIsRemovePrice(IsRemoveFlg value) {
        this.isRemovePrice = value;
    }

    /**
     * Gets the value of the salePrice property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSalePrice() {
        return salePrice;
    }

    /**
     * Sets the value of the salePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSalePrice(Long value) {
        this.salePrice = value;
    }

    /**
     * Gets the value of the isRemoveSalePrice property.
     * 
     * @return
     *     possible object is
     *     {@link IsRemoveFlg }
     *     
     */
    public IsRemoveFlg getIsRemoveSalePrice() {
        return isRemoveSalePrice;
    }

    /**
     * Sets the value of the isRemoveSalePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsRemoveFlg }
     *     
     */
    public void setIsRemoveSalePrice(IsRemoveFlg value) {
        this.isRemoveSalePrice = value;
    }

    /**
     * Gets the value of the formattedPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormattedPrice() {
        return formattedPrice;
    }

    /**
     * Sets the value of the formattedPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormattedPrice(String value) {
        this.formattedPrice = value;
    }

    /**
     * Gets the value of the isRemoveFormattedPrice property.
     * 
     * @return
     *     possible object is
     *     {@link IsRemoveFlg }
     *     
     */
    public IsRemoveFlg getIsRemoveFormattedPrice() {
        return isRemoveFormattedPrice;
    }

    /**
     * Sets the value of the isRemoveFormattedPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsRemoveFlg }
     *     
     */
    public void setIsRemoveFormattedPrice(IsRemoveFlg value) {
        this.isRemoveFormattedPrice = value;
    }

    /**
     * Gets the value of the formattedSalePrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormattedSalePrice() {
        return formattedSalePrice;
    }

    /**
     * Sets the value of the formattedSalePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormattedSalePrice(String value) {
        this.formattedSalePrice = value;
    }

    /**
     * Gets the value of the isRemoveFormattedSalePrice property.
     * 
     * @return
     *     possible object is
     *     {@link IsRemoveFlg }
     *     
     */
    public IsRemoveFlg getIsRemoveFormattedSalePrice() {
        return isRemoveFormattedSalePrice;
    }

    /**
     * Sets the value of the isRemoveFormattedSalePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsRemoveFlg }
     *     
     */
    public void setIsRemoveFormattedSalePrice(IsRemoveFlg value) {
        this.isRemoveFormattedSalePrice = value;
    }

    /**
     * Gets the value of the displaySettings property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDisplaySettings() {
        return displaySettings;
    }

    /**
     * Sets the value of the displaySettings property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDisplaySettings(Long value) {
        this.displaySettings = value;
    }

    /**
     * Gets the value of the availability property.
     * 
     * @return
     *     possible object is
     *     {@link Availability }
     *     
     */
    public Availability getAvailability() {
        return availability;
    }

    /**
     * Sets the value of the availability property.
     * 
     * @param value
     *     allowed object is
     *     {@link Availability }
     *     
     */
    public void setAvailability(Availability value) {
        this.availability = value;
    }

}
