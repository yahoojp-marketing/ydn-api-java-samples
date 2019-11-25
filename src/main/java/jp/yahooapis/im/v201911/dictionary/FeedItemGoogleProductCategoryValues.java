
package jp.yahooapis.im.v201911.dictionary;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201911.ReturnValue;


/**
 * <p>Java class for FeedItemGoogleProductCategoryValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedItemGoogleProductCategoryValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201911}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="FeedItemGoogleProductCategory" type="{http://im.yahooapis.jp/V201911/Dictionary}FeedItemGoogleProductCategory" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedItemGoogleProductCategoryValues", propOrder = {
    "feedItemGoogleProductCategory"
})
public class FeedItemGoogleProductCategoryValues
    extends ReturnValue
{

    @XmlElement(name = "FeedItemGoogleProductCategory")
    protected FeedItemGoogleProductCategory feedItemGoogleProductCategory;

    /**
     * Gets the value of the feedItemGoogleProductCategory property.
     * 
     * @return
     *     possible object is
     *     {@link FeedItemGoogleProductCategory }
     *     
     */
    public FeedItemGoogleProductCategory getFeedItemGoogleProductCategory() {
        return feedItemGoogleProductCategory;
    }

    /**
     * Sets the value of the feedItemGoogleProductCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeedItemGoogleProductCategory }
     *     
     */
    public void setFeedItemGoogleProductCategory(FeedItemGoogleProductCategory value) {
        this.feedItemGoogleProductCategory = value;
    }

}
