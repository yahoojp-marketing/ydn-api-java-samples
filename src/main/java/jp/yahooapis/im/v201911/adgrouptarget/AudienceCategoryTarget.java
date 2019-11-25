
package jp.yahooapis.im.v201911.adgrouptarget;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AudienceCategoryTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AudienceCategoryTarget">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201911/AdGroupTarget}Target">
 *       &lt;sequence>
 *         &lt;element name="categoryNameJa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="categoryNameEn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="categoryType" type="{http://im.yahooapis.jp/V201911/AdGroupTarget}AudienceCategoryType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AudienceCategoryTarget", propOrder = {
    "categoryNameJa",
    "categoryNameEn",
    "categoryType"
})
public class AudienceCategoryTarget
    extends Target
{

    protected String categoryNameJa;
    protected String categoryNameEn;
    @XmlSchemaType(name = "string")
    protected AudienceCategoryType categoryType;

    /**
     * Gets the value of the categoryNameJa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryNameJa() {
        return categoryNameJa;
    }

    /**
     * Sets the value of the categoryNameJa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryNameJa(String value) {
        this.categoryNameJa = value;
    }

    /**
     * Gets the value of the categoryNameEn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryNameEn() {
        return categoryNameEn;
    }

    /**
     * Sets the value of the categoryNameEn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryNameEn(String value) {
        this.categoryNameEn = value;
    }

    /**
     * Gets the value of the categoryType property.
     * 
     * @return
     *     possible object is
     *     {@link AudienceCategoryType }
     *     
     */
    public AudienceCategoryType getCategoryType() {
        return categoryType;
    }

    /**
     * Sets the value of the categoryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AudienceCategoryType }
     *     
     */
    public void setCategoryType(AudienceCategoryType value) {
        this.categoryType = value;
    }

}
