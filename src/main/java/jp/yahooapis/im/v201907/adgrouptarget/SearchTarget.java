
package jp.yahooapis.im.v201907.adgrouptarget;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchTarget">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201907/AdGroupTarget}Target">
 *       &lt;sequence>
 *         &lt;element name="searchKeywordListName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchTarget", propOrder = {
    "searchKeywordListName"
})
public class SearchTarget
    extends Target
{

    protected String searchKeywordListName;

    /**
     * Gets the value of the searchKeywordListName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchKeywordListName() {
        return searchKeywordListName;
    }

    /**
     * Sets the value of the searchKeywordListName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchKeywordListName(String value) {
        this.searchKeywordListName = value;
    }

}
