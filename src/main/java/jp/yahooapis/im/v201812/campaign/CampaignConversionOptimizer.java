
package jp.yahooapis.im.v201812.campaign;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampaignConversionOptimizer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignConversionOptimizer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="optimizerType" type="{http://im.yahooapis.jp/V201812/Campaign}CampaignConversionOptimizerType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampaignConversionOptimizer", propOrder = {
    "optimizerType"
})
@XmlSeeAlso({
    ManualCampaignConversionOptimizer.class,
    AutoCampaignConversionOptimizer.class
})
public class CampaignConversionOptimizer {

    @XmlSchemaType(name = "string")
    protected CampaignConversionOptimizerType optimizerType;

    /**
     * Gets the value of the optimizerType property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignConversionOptimizerType }
     *     
     */
    public CampaignConversionOptimizerType getOptimizerType() {
        return optimizerType;
    }

    /**
     * Sets the value of the optimizerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignConversionOptimizerType }
     *     
     */
    public void setOptimizerType(CampaignConversionOptimizerType value) {
        this.optimizerType = value;
    }

}
