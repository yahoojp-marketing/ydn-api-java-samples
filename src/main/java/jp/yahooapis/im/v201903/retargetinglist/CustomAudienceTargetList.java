
package jp.yahooapis.im.v201903.retargetinglist;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomAudienceTargetList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomAudienceTargetList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201903/RetargetingList}RetargetingTargetList">
 *       &lt;sequence>
 *         &lt;element name="reachPeriod" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="customAudienceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomAudienceTargetList", propOrder = {
    "reachPeriod",
    "customAudienceId"
})
public class CustomAudienceTargetList
    extends RetargetingTargetList
{

    protected Integer reachPeriod;
    protected String customAudienceId;

    /**
     * Gets the value of the reachPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getReachPeriod() {
        return reachPeriod;
    }

    /**
     * Sets the value of the reachPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setReachPeriod(Integer value) {
        this.reachPeriod = value;
    }

    /**
     * Gets the value of the customAudienceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomAudienceId() {
        return customAudienceId;
    }

    /**
     * Sets the value of the customAudienceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomAudienceId(String value) {
        this.customAudienceId = value;
    }

}
