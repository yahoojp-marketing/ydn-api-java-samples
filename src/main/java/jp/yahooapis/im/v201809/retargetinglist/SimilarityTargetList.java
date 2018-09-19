
package jp.yahooapis.im.v201809.retargetinglist;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SimilarityTargetList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SimilarityTargetList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201809/RetargetingList}RetargetingTargetList">
 *       &lt;sequence>
 *         &lt;element name="targetListId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="targetListSize" type="{http://im.yahooapis.jp/V201809/RetargetingList}TargetListSize" minOccurs="0"/>
 *         &lt;element name="targetListSizeReaches" type="{http://im.yahooapis.jp/V201809/RetargetingList}TargetListSizeReaches" maxOccurs="10" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimilarityTargetList", propOrder = {
    "targetListId",
    "targetListSize",
    "targetListSizeReaches"
})
public class SimilarityTargetList
    extends RetargetingTargetList
{

    protected Long targetListId;
    @XmlSchemaType(name = "string")
    protected TargetListSize targetListSize;
    protected List<TargetListSizeReaches> targetListSizeReaches;

    /**
     * Gets the value of the targetListId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTargetListId() {
        return targetListId;
    }

    /**
     * Sets the value of the targetListId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTargetListId(Long value) {
        this.targetListId = value;
    }

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
     * Gets the value of the targetListSizeReaches property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targetListSizeReaches property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTargetListSizeReaches().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TargetListSizeReaches }
     * 
     * 
     */
    public List<TargetListSizeReaches> getTargetListSizeReaches() {
        if (targetListSizeReaches == null) {
            targetListSizeReaches = new ArrayList<TargetListSizeReaches>();
        }
        return this.targetListSizeReaches;
    }

}
