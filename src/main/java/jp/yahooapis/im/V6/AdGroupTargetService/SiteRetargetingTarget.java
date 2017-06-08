
package jp.yahooapis.im.V6.AdGroupTargetService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://im.yahooapis.jp/V6}TargetType"/>
 *         &lt;element name="targetListId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="targetListName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="targetListDeliverType" type="{http://im.yahooapis.jp/V6}TargetListDeliverType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SiteRetargetingTarget", propOrder = {
    "type",
    "targetListId",
    "targetListName",
    "targetListDeliverType"
})
public class SiteRetargetingTarget {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TargetType type;
    protected long targetListId;
    protected String targetListName;
    @XmlSchemaType(name = "string")
    protected TargetListDeliverType targetListDeliverType;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link TargetType }
     *     
     */
    public TargetType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetType }
     *     
     */
    public void setType(TargetType value) {
        this.type = value;
    }

    /**
     * Gets the value of the targetListId property.
     * 
     */
    public long getTargetListId() {
        return targetListId;
    }

    /**
     * Sets the value of the targetListId property.
     * 
     */
    public void setTargetListId(long value) {
        this.targetListId = value;
    }

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
     * Gets the value of the targetListDeliverType property.
     * 
     * @return
     *     possible object is
     *     {@link TargetListDeliverType }
     *     
     */
    public TargetListDeliverType getTargetListDeliverType() {
        return targetListDeliverType;
    }

    /**
     * Sets the value of the targetListDeliverType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetListDeliverType }
     *     
     */
    public void setTargetListDeliverType(TargetListDeliverType value) {
        this.targetListDeliverType = value;
    }

}
