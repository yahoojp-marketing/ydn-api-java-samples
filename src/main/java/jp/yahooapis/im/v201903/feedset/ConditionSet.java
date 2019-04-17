
package jp.yahooapis.im.v201903.feedset;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConditionSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConditionSet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://im.yahooapis.jp/V201903/FeedSet}ConditionType"/>
 *         &lt;element name="orConditions" type="{http://im.yahooapis.jp/V201903/FeedSet}Condition" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConditionSet", propOrder = {
    "type",
    "orConditions"
})
public class ConditionSet {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ConditionType type;
    @XmlElement(required = true)
    protected List<Condition> orConditions;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ConditionType }
     *     
     */
    public ConditionType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionType }
     *     
     */
    public void setType(ConditionType value) {
        this.type = value;
    }

    /**
     * Gets the value of the orConditions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orConditions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrConditions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Condition }
     * 
     * 
     */
    public List<Condition> getOrConditions() {
        if (orConditions == null) {
            orConditions = new ArrayList<Condition>();
        }
        return this.orConditions;
    }

}
