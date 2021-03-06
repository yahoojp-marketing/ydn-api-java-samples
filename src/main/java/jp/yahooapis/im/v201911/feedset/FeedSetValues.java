
package jp.yahooapis.im.v201911.feedset;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201911.ReturnValue;


/**
 * <p>Java class for FeedSetValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedSetValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201911}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="feedSet" type="{http://im.yahooapis.jp/V201911/FeedSet}FeedSet" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedSetValues", propOrder = {
    "feedSet"
})
public class FeedSetValues
    extends ReturnValue
{

    protected FeedSet feedSet;

    /**
     * Gets the value of the feedSet property.
     * 
     * @return
     *     possible object is
     *     {@link FeedSet }
     *     
     */
    public FeedSet getFeedSet() {
        return feedSet;
    }

    /**
     * Sets the value of the feedSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeedSet }
     *     
     */
    public void setFeedSet(FeedSet value) {
        this.feedSet = value;
    }

}
