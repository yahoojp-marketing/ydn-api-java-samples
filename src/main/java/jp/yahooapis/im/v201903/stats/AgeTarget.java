
package jp.yahooapis.im.v201903.stats;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AgeTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AgeTarget">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201903/Stats}Target">
 *       &lt;sequence>
 *         &lt;element name="age" type="{http://im.yahooapis.jp/V201903/Stats}Age" minOccurs="0"/>
 *         &lt;element name="estimateFlg" type="{http://im.yahooapis.jp/V201903/Stats}EstimateFlg" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AgeTarget", propOrder = {
    "age",
    "estimateFlg"
})
public class AgeTarget
    extends Target
{

    @XmlSchemaType(name = "string")
    protected Age age;
    @XmlSchemaType(name = "string")
    protected EstimateFlg estimateFlg;

    /**
     * Gets the value of the age property.
     * 
     * @return
     *     possible object is
     *     {@link Age }
     *     
     */
    public Age getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     * @param value
     *     allowed object is
     *     {@link Age }
     *     
     */
    public void setAge(Age value) {
        this.age = value;
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
