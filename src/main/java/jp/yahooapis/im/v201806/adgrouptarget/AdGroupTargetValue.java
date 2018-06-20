
package jp.yahooapis.im.v201806.adgrouptarget;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201806.ReturnValue;


/**
 * <p>Java class for AdGroupTargetValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupTargetValue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201806}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="adGroupTargetList" type="{http://im.yahooapis.jp/V201806/AdGroupTarget}AdGroupTarget" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupTargetValue", propOrder = {
    "adGroupTargetList"
})
public class AdGroupTargetValue
    extends ReturnValue
{

    protected AdGroupTarget adGroupTargetList;

    /**
     * Gets the value of the adGroupTargetList property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroupTarget }
     *     
     */
    public AdGroupTarget getAdGroupTargetList() {
        return adGroupTargetList;
    }

    /**
     * Sets the value of the adGroupTargetList property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroupTarget }
     *     
     */
    public void setAdGroupTargetList(AdGroupTarget value) {
        this.adGroupTargetList = value;
    }

}
