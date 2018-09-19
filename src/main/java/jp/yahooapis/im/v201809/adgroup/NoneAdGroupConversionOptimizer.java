
package jp.yahooapis.im.v201809.adgroup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NoneAdGroupConversionOptimizer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NoneAdGroupConversionOptimizer">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201809/AdGroup}AdGroupConversionOptimizer">
 *       &lt;sequence>
 *         &lt;element name="eligibilityFlg" type="{http://im.yahooapis.jp/V201809/AdGroup}ConversionOptimizerEligibilityFlg" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NoneAdGroupConversionOptimizer", propOrder = {
    "eligibilityFlg"
})
public class NoneAdGroupConversionOptimizer
    extends AdGroupConversionOptimizer
{

    @XmlSchemaType(name = "string")
    protected ConversionOptimizerEligibilityFlg eligibilityFlg;

    /**
     * Gets the value of the eligibilityFlg property.
     * 
     * @return
     *     possible object is
     *     {@link ConversionOptimizerEligibilityFlg }
     *     
     */
    public ConversionOptimizerEligibilityFlg getEligibilityFlg() {
        return eligibilityFlg;
    }

    /**
     * Sets the value of the eligibilityFlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConversionOptimizerEligibilityFlg }
     *     
     */
    public void setEligibilityFlg(ConversionOptimizerEligibilityFlg value) {
        this.eligibilityFlg = value;
    }

}
