
package jp.yahooapis.im.V6.AdGroupTargetService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchTarget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://im.yahooapis.jp/V6}TargetType"/>
 *         &lt;element name="searchKeywordListId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="searchKeywordListName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchTarget", propOrder = {
    "type",
    "searchKeywordListId",
    "searchKeywordListName"
})
public class SearchTarget {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TargetType type;
    protected long searchKeywordListId;
    protected String searchKeywordListName;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link TargetType }
     *     
     */
    public TargetType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetType }
     *     
     */
    public void setType(TargetType value) {
        this.type = value;
    }

    /**
     * Gets the value of the searchKeywordListId property.
     * 
     */
    public long getSearchKeywordListId() {
        return searchKeywordListId;
    }

    /**
     * Sets the value of the searchKeywordListId property.
     * 
     */
    public void setSearchKeywordListId(long value) {
        this.searchKeywordListId = value;
    }

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
