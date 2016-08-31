
package jp.yahooapis.im.V5.AdGroupTargetService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroupTargetValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupTargetValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V5}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="targetList" type="{http://im.yahooapis.jp/V5}AdGroupTargets" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupTargetValues", propOrder = {
    "targetList"
})
public class AdGroupTargetValues
    extends ReturnValue
{

    protected AdGroupTargets targetList;

    /**
     * Gets the value of the targetList property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroupTargets }
     *     
     */
    public AdGroupTargets getTargetList() {
        return targetList;
    }

    /**
     * Sets the value of the targetList property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroupTargets }
     *     
     */
    public void setTargetList(AdGroupTargets value) {
        this.targetList = value;
    }

}
