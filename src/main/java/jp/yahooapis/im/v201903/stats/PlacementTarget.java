
package jp.yahooapis.im.v201903.stats;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlacementTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlacementTarget">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201903/Stats}Target">
 *       &lt;sequence>
 *         &lt;element name="placementUrlListName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliverType" type="{http://im.yahooapis.jp/V201903/Stats}PlacementUrlListType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlacementTarget", propOrder = {
    "placementUrlListName",
    "deliverType"
})
public class PlacementTarget
    extends Target
{

    protected String placementUrlListName;
    @XmlSchemaType(name = "string")
    protected PlacementUrlListType deliverType;

    /**
     * Gets the value of the placementUrlListName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlacementUrlListName() {
        return placementUrlListName;
    }

    /**
     * Sets the value of the placementUrlListName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlacementUrlListName(String value) {
        this.placementUrlListName = value;
    }

    /**
     * Gets the value of the deliverType property.
     * 
     * @return
     *     possible object is
     *     {@link PlacementUrlListType }
     *     
     */
    public PlacementUrlListType getDeliverType() {
        return deliverType;
    }

    /**
     * Sets the value of the deliverType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlacementUrlListType }
     *     
     */
    public void setDeliverType(PlacementUrlListType value) {
        this.deliverType = value;
    }

}
