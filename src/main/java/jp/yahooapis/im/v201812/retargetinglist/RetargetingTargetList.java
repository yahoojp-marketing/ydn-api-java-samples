
package jp.yahooapis.im.v201812.retargetinglist;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetargetingTargetList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetargetingTargetList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="targetListType" type="{http://im.yahooapis.jp/V201812/RetargetingList}TargetListType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetargetingTargetList", propOrder = {
    "targetListType"
})
@XmlSeeAlso({
    SimilarityTargetList.class,
    RuleTargetList.class,
    CombinationTargetList.class,
    CustomAudienceTargetList.class
})
public abstract class RetargetingTargetList {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TargetListType targetListType;

    /**
     * Gets the value of the targetListType property.
     * 
     * @return
     *     possible object is
     *     {@link TargetListType }
     *     
     */
    public TargetListType getTargetListType() {
        return targetListType;
    }

    /**
     * Sets the value of the targetListType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetListType }
     *     
     */
    public void setTargetListType(TargetListType value) {
        this.targetListType = value;
    }

}
