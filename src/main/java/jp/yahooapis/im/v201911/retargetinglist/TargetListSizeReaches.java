
package jp.yahooapis.im.v201911.retargetinglist;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetListSizeReaches complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TargetListSizeReaches">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="targetListSize" type="{http://im.yahooapis.jp/V201911/RetargetingList}TargetListSize" minOccurs="0"/>
 *         &lt;element name="reach" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetListSizeReaches", propOrder = {
    "targetListSize",
    "reach"
})
public class TargetListSizeReaches {

    @XmlSchemaType(name = "string")
    protected TargetListSize targetListSize;
    protected Long reach;

    /**
     * Gets the value of the targetListSize property.
     * 
     * @return
     *     possible object is
     *     {@link TargetListSize }
     *     
     */
    public TargetListSize getTargetListSize() {
        return targetListSize;
    }

    /**
     * Sets the value of the targetListSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetListSize }
     *     
     */
    public void setTargetListSize(TargetListSize value) {
        this.targetListSize = value;
    }

    /**
     * Gets the value of the reach property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getReach() {
        return reach;
    }

    /**
     * Sets the value of the reach property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setReach(Long value) {
        this.reach = value;
    }

}
