
package jp.yahooapis.im.V6.AdGroupAdService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ManualCPVAdGroupAdBid complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ManualCPVAdGroupAdBid">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V6}AdGroupAdBid">
 *       &lt;sequence>
 *         &lt;element name="maxCpv" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManualCPVAdGroupAdBid", propOrder = {
    "maxCpv"
})
public class ManualCPVAdGroupAdBid
    extends AdGroupAdBid
{

    protected Long maxCpv;

    /**
     * Gets the value of the maxCpv property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxCpv() {
        return maxCpv;
    }

    /**
     * Sets the value of the maxCpv property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxCpv(Long value) {
        this.maxCpv = value;
    }

}
