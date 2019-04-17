
package jp.yahooapis.im.v201903.feedftp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201903.ReturnValue;


/**
 * <p>Java class for FeedFtpValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedFtpValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201903}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="feedFtp" type="{http://im.yahooapis.jp/V201903/FeedFtp}FeedFtp" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedFtpValues", propOrder = {
    "feedFtp"
})
public class FeedFtpValues
    extends ReturnValue
{

    protected FeedFtp feedFtp;

    /**
     * Gets the value of the feedFtp property.
     * 
     * @return
     *     possible object is
     *     {@link FeedFtp }
     *     
     */
    public FeedFtp getFeedFtp() {
        return feedFtp;
    }

    /**
     * Sets the value of the feedFtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeedFtp }
     *     
     */
    public void setFeedFtp(FeedFtp value) {
        this.feedFtp = value;
    }

}
