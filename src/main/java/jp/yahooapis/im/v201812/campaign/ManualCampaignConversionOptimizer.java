
package jp.yahooapis.im.v201812.campaign;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ManualCampaignConversionOptimizer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ManualCampaignConversionOptimizer">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201812/Campaign}CampaignConversionOptimizer">
 *       &lt;sequence>
 *         &lt;element name="eligibilityFlg" type="{http://im.yahooapis.jp/V201812/Campaign}ConversionOptimizerEligibilityFlg" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManualCampaignConversionOptimizer", propOrder = {
    "eligibilityFlg"
})
public class ManualCampaignConversionOptimizer
    extends CampaignConversionOptimizer
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
