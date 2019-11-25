
package jp.yahooapis.im.v201911.dictionary;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201911.ReturnValue;


/**
 * <p>Java class for AudienceCategoryValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AudienceCategoryValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201911}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="category" type="{http://im.yahooapis.jp/V201911/Dictionary}AudienceCategory" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AudienceCategoryValues", propOrder = {
    "category"
})
public class AudienceCategoryValues
    extends ReturnValue
{

    protected AudienceCategory category;

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link AudienceCategory }
     *     
     */
    public AudienceCategory getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link AudienceCategory }
     *     
     */
    public void setCategory(AudienceCategory value) {
        this.category = value;
    }

}
