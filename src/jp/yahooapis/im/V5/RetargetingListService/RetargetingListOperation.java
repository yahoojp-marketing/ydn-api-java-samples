
package jp.yahooapis.im.V5.RetargetingListService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetargetingListOperation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetargetingListOperation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V5}Operation">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="targetListType" type="{http://im.yahooapis.jp/V5}TargetListType" minOccurs="0"/>
 *         &lt;element name="operand" type="{http://im.yahooapis.jp/V5}RetargetingList" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetargetingListOperation", propOrder = {
    "accountId",
    "targetListType",
    "operand"
})
public class RetargetingListOperation
    extends Operation
{

    protected long accountId;
    protected TargetListType targetListType;
    @XmlElement(required = true)
    protected List<RetargetingList> operand;

    /**
     * Gets the value of the accountId property.
     * 
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     */
    public void setAccountId(long value) {
        this.accountId = value;
    }

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

    /**
     * Gets the value of the operand property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operand property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperand().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RetargetingList }
     * 
     * 
     */
    public List<RetargetingList> getOperand() {
        if (operand == null) {
            operand = new ArrayList<RetargetingList>();
        }
        return this.operand;
    }

}
