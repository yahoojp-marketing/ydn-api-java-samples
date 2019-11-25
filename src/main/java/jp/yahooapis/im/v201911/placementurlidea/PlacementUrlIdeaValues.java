
package jp.yahooapis.im.v201911.placementurlidea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201911.ReturnValue;


/**
 * <p>Java class for PlacementUrlIdeaValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlacementUrlIdeaValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201911}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="placementUrlIdea" type="{http://im.yahooapis.jp/V201911/PlacementUrlIdea}PlacementUrlIdea" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlacementUrlIdeaValues", propOrder = {
    "placementUrlIdea"
})
public class PlacementUrlIdeaValues
    extends ReturnValue
{

    protected PlacementUrlIdea placementUrlIdea;

    /**
     * Gets the value of the placementUrlIdea property.
     * 
     * @return
     *     possible object is
     *     {@link PlacementUrlIdea }
     *     
     */
    public PlacementUrlIdea getPlacementUrlIdea() {
        return placementUrlIdea;
    }

    /**
     * Sets the value of the placementUrlIdea property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlacementUrlIdea }
     *     
     */
    public void setPlacementUrlIdea(PlacementUrlIdea value) {
        this.placementUrlIdea = value;
    }

}
