
package jp.yahooapis.im.v201806.adgroup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AutoAdGroupConversionOptimizer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AutoAdGroupConversionOptimizer">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201806/AdGroup}AdGroupConversionOptimizer">
 *       &lt;sequence>
 *         &lt;element name="targetCpa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="eligibilityFlg" type="{http://im.yahooapis.jp/V201806/AdGroup}ConversionOptimizerEligibilityFlg" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AutoAdGroupConversionOptimizer", propOrder = {
    "targetCpa",
    "eligibilityFlg"
})
public class AutoAdGroupConversionOptimizer
    extends AdGroupConversionOptimizer
{

    protected Long targetCpa;
    @XmlSchemaType(name = "string")
    protected ConversionOptimizerEligibilityFlg eligibilityFlg;

    /**
     * Gets the value of the targetCpa property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTargetCpa() {
        return targetCpa;
    }

    /**
     * Sets the value of the targetCpa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTargetCpa(Long value) {
        this.targetCpa = value;
    }

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
