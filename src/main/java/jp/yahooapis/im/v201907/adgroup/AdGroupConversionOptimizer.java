
package jp.yahooapis.im.v201907.adgroup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroupConversionOptimizer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupConversionOptimizer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="optimizerType" type="{http://im.yahooapis.jp/V201907/AdGroup}AdGroupConversionOptimizerType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupConversionOptimizer", propOrder = {
    "optimizerType"
})
@XmlSeeAlso({
    NoneAdGroupConversionOptimizer.class,
    ManualAdGroupConversionOptimizer.class,
    AutoAdGroupConversionOptimizer.class
})
public class AdGroupConversionOptimizer {

    @XmlSchemaType(name = "string")
    protected AdGroupConversionOptimizerType optimizerType;

    /**
     * Gets the value of the optimizerType property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroupConversionOptimizerType }
     *     
     */
    public AdGroupConversionOptimizerType getOptimizerType() {
        return optimizerType;
    }

    /**
     * Sets the value of the optimizerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroupConversionOptimizerType }
     *     
     */
    public void setOptimizerType(AdGroupConversionOptimizerType value) {
        this.optimizerType = value;
    }

}
