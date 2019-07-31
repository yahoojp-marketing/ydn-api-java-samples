
package jp.yahooapis.im.v201907.adgroup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ManualCPVAdGroupBid complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ManualCPVAdGroupBid">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201907/AdGroup}AdGroupBid">
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
@XmlType(name = "ManualCPVAdGroupBid", propOrder = {
    "maxCpv"
})
public class ManualCPVAdGroupBid
    extends AdGroupBid
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
