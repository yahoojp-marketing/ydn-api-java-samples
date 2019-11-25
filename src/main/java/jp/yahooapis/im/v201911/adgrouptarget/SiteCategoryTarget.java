
package jp.yahooapis.im.v201911.adgrouptarget;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SiteCategoryTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SiteCategoryTarget">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201911/AdGroupTarget}Target">
 *       &lt;sequence>
 *         &lt;element name="categoryFullNameJa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="categoryFullNameEn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SiteCategoryTarget", propOrder = {
    "categoryFullNameJa",
    "categoryFullNameEn"
})
public class SiteCategoryTarget
    extends Target
{

    protected String categoryFullNameJa;
    protected String categoryFullNameEn;

    /**
     * Gets the value of the categoryFullNameJa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryFullNameJa() {
        return categoryFullNameJa;
    }

    /**
     * Sets the value of the categoryFullNameJa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryFullNameJa(String value) {
        this.categoryFullNameJa = value;
    }

    /**
     * Gets the value of the categoryFullNameEn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryFullNameEn() {
        return categoryFullNameEn;
    }

    /**
     * Sets the value of the categoryFullNameEn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryFullNameEn(String value) {
        this.categoryFullNameEn = value;
    }

}
