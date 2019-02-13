
package jp.yahooapis.im.v201812.feeddata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201812.ReturnValue;


/**
 * <p>Java class for FeedDataValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedDataValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201812}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="feedData" type="{http://im.yahooapis.jp/V201812/FeedData}FeedDataRecord" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedDataValues", propOrder = {
    "feedData"
})
public class FeedDataValues
    extends ReturnValue
{

    protected FeedDataRecord feedData;

    /**
     * Gets the value of the feedData property.
     * 
     * @return
     *     possible object is
     *     {@link FeedDataRecord }
     *     
     */
    public FeedDataRecord getFeedData() {
        return feedData;
    }

    /**
     * Sets the value of the feedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeedDataRecord }
     *     
     */
    public void setFeedData(FeedDataRecord value) {
        this.feedData = value;
    }

}
