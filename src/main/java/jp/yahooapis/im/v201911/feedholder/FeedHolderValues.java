
package jp.yahooapis.im.v201911.feedholder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201911.ReturnValue;


/**
 * <p>Java class for FeedHolderValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedHolderValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201911}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="feedHolder" type="{http://im.yahooapis.jp/V201911/FeedHolder}FeedHolderRecord" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedHolderValues", propOrder = {
    "feedHolder"
})
public class FeedHolderValues
    extends ReturnValue
{

    protected FeedHolderRecord feedHolder;

    /**
     * Gets the value of the feedHolder property.
     * 
     * @return
     *     possible object is
     *     {@link FeedHolderRecord }
     *     
     */
    public FeedHolderRecord getFeedHolder() {
        return feedHolder;
    }

    /**
     * Sets the value of the feedHolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeedHolderRecord }
     *     
     */
    public void setFeedHolder(FeedHolderRecord value) {
        this.feedHolder = value;
    }

}
