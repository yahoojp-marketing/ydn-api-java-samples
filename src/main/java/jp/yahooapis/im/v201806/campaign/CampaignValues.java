
package jp.yahooapis.im.v201806.campaign;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201806.ReturnValue;


/**
 * <p>Java class for CampaignValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201806}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="campaign" type="{http://im.yahooapis.jp/V201806/Campaign}Campaign" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampaignValues", propOrder = {
    "campaign"
})
public class CampaignValues
    extends ReturnValue
{

    protected Campaign campaign;

    /**
     * Gets the value of the campaign property.
     * 
     * @return
     *     possible object is
     *     {@link Campaign }
     *     
     */
    public Campaign getCampaign() {
        return campaign;
    }

    /**
     * Sets the value of the campaign property.
     * 
     * @param value
     *     allowed object is
     *     {@link Campaign }
     *     
     */
    public void setCampaign(Campaign value) {
        this.campaign = value;
    }

}
