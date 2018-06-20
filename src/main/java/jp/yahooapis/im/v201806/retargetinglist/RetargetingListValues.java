
package jp.yahooapis.im.v201806.retargetinglist;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201806.ReturnValue;


/**
 * <p>Java class for RetargetingListValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetargetingListValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201806}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="retargetingList" type="{http://im.yahooapis.jp/V201806/RetargetingList}RetargetingList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetargetingListValues", propOrder = {
    "retargetingList"
})
public class RetargetingListValues
    extends ReturnValue
{

    protected RetargetingList retargetingList;

    /**
     * Gets the value of the retargetingList property.
     * 
     * @return
     *     possible object is
     *     {@link RetargetingList }
     *     
     */
    public RetargetingList getRetargetingList() {
        return retargetingList;
    }

    /**
     * Sets the value of the retargetingList property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetargetingList }
     *     
     */
    public void setRetargetingList(RetargetingList value) {
        this.retargetingList = value;
    }

}
