
package jp.yahooapis.im.v201907.feedftprequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201907.ReturnValue;


/**
 * <p>Java class for FeedFtpRequestValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedFtpRequestValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201907}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="feedFtp" type="{http://im.yahooapis.jp/V201907/FeedFtpRequest}FeedFtpRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedFtpRequestValues", propOrder = {
    "feedFtp"
})
public class FeedFtpRequestValues
    extends ReturnValue
{

    protected FeedFtpRequest feedFtp;

    /**
     * Gets the value of the feedFtp property.
     * 
     * @return
     *     possible object is
     *     {@link FeedFtpRequest }
     *     
     */
    public FeedFtpRequest getFeedFtp() {
        return feedFtp;
    }

    /**
     * Sets the value of the feedFtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeedFtpRequest }
     *     
     */
    public void setFeedFtp(FeedFtpRequest value) {
        this.feedFtp = value;
    }

}
