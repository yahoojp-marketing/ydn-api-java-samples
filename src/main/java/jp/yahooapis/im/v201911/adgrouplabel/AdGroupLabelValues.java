
package jp.yahooapis.im.v201911.adgrouplabel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201911.ReturnValue;


/**
 * <p>Java class for AdGroupLabelValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupLabelValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201911}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="adGroupLabel" type="{http://im.yahooapis.jp/V201911/AdGroupLabel}AdGroupLabel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupLabelValues", propOrder = {
    "adGroupLabel"
})
public class AdGroupLabelValues
    extends ReturnValue
{

    protected AdGroupLabel adGroupLabel;

    /**
     * Gets the value of the adGroupLabel property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroupLabel }
     *     
     */
    public AdGroupLabel getAdGroupLabel() {
        return adGroupLabel;
    }

    /**
     * Sets the value of the adGroupLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroupLabel }
     *     
     */
    public void setAdGroupLabel(AdGroupLabel value) {
        this.adGroupLabel = value;
    }

}
