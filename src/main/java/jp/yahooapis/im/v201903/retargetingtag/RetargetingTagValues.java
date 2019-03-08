
package jp.yahooapis.im.v201903.retargetingtag;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201903.ReturnValue;


/**
 * <p>Java class for RetargetingTagValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetargetingTagValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201903}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="retargetingTag" type="{http://im.yahooapis.jp/V201903/RetargetingTag}RetargetingTag" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetargetingTagValues", propOrder = {
    "retargetingTag"
})
public class RetargetingTagValues
    extends ReturnValue
{

    protected RetargetingTag retargetingTag;

    /**
     * Gets the value of the retargetingTag property.
     * 
     * @return
     *     possible object is
     *     {@link RetargetingTag }
     *     
     */
    public RetargetingTag getRetargetingTag() {
        return retargetingTag;
    }

    /**
     * Sets the value of the retargetingTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetargetingTag }
     *     
     */
    public void setRetargetingTag(RetargetingTag value) {
        this.retargetingTag = value;
    }

}
