
package jp.yahooapis.im.v201812.adgrouptarget;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GenderTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GenderTarget">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201812/AdGroupTarget}Target">
 *       &lt;sequence>
 *         &lt;element name="gender" type="{http://im.yahooapis.jp/V201812/AdGroupTarget}Gender" minOccurs="0"/>
 *         &lt;element name="estimateFlg" type="{http://im.yahooapis.jp/V201812/AdGroupTarget}EstimateFlg" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenderTarget", propOrder = {
    "gender",
    "estimateFlg"
})
public class GenderTarget
    extends Target
{

    @XmlSchemaType(name = "string")
    protected Gender gender;
    @XmlSchemaType(name = "string")
    protected EstimateFlg estimateFlg;

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link Gender }
     *     
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link Gender }
     *     
     */
    public void setGender(Gender value) {
        this.gender = value;
    }

    /**
     * Gets the value of the estimateFlg property.
     * 
     * @return
     *     possible object is
     *     {@link EstimateFlg }
     *     
     */
    public EstimateFlg getEstimateFlg() {
        return estimateFlg;
    }

    /**
     * Sets the value of the estimateFlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstimateFlg }
     *     
     */
    public void setEstimateFlg(EstimateFlg value) {
        this.estimateFlg = value;
    }

}
