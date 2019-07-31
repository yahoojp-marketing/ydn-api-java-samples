
package jp.yahooapis.im.v201907.stats;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SiteRetargetingTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SiteRetargetingTarget">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201907/Stats}Target">
 *       &lt;sequence>
 *         &lt;element name="targetListName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliverType" type="{http://im.yahooapis.jp/V201907/Stats}TargetListDeliverType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SiteRetargetingTarget", propOrder = {
    "targetListName",
    "deliverType"
})
public class SiteRetargetingTarget
    extends Target
{

    protected String targetListName;
    @XmlSchemaType(name = "string")
    protected TargetListDeliverType deliverType;

    /**
     * Gets the value of the targetListName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetListName() {
        return targetListName;
    }

    /**
     * Sets the value of the targetListName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetListName(String value) {
        this.targetListName = value;
    }

    /**
     * Gets the value of the deliverType property.
     * 
     * @return
     *     possible object is
     *     {@link TargetListDeliverType }
     *     
     */
    public TargetListDeliverType getDeliverType() {
        return deliverType;
    }

    /**
     * Sets the value of the deliverType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetListDeliverType }
     *     
     */
    public void setDeliverType(TargetListDeliverType value) {
        this.deliverType = value;
    }

}
