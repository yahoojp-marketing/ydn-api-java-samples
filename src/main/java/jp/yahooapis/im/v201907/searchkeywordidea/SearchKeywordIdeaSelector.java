
package jp.yahooapis.im.v201907.searchkeywordidea;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201907.Paging;


/**
 * <p>Java class for SearchKeywordIdeaSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchKeywordIdeaSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="keywords" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="keywordIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="searchKeywordRecency" type="{http://im.yahooapis.jp/V201907/SearchKeywordIdea}KeywordRecency" minOccurs="0"/>
 *         &lt;element name="searchKeywordFrequency" type="{http://im.yahooapis.jp/V201907/SearchKeywordIdea}KeywordFrequency" minOccurs="0"/>
 *         &lt;element name="sortField" type="{http://im.yahooapis.jp/V201907/SearchKeywordIdea}SortField" minOccurs="0"/>
 *         &lt;element name="sortType" type="{http://im.yahooapis.jp/V201907/SearchKeywordIdea}SortType" minOccurs="0"/>
 *         &lt;element name="matchType" type="{http://im.yahooapis.jp/V201907/SearchKeywordIdea}MatchType" minOccurs="0"/>
 *         &lt;element name="paging" type="{http://im.yahooapis.jp/V201907}Paging" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchKeywordIdeaSelector", propOrder = {
    "keywords",
    "keywordIds",
    "searchKeywordRecency",
    "searchKeywordFrequency",
    "sortField",
    "sortType",
    "matchType",
    "paging"
})
public class SearchKeywordIdeaSelector {

    protected List<String> keywords;
    @XmlElement(type = Long.class)
    protected List<Long> keywordIds;
    @XmlSchemaType(name = "string")
    protected KeywordRecency searchKeywordRecency;
    @XmlSchemaType(name = "string")
    protected KeywordFrequency searchKeywordFrequency;
    @XmlSchemaType(name = "string")
    protected SortField sortField;
    @XmlSchemaType(name = "string")
    protected SortType sortType;
    @XmlSchemaType(name = "string")
    protected MatchType matchType;
    protected Paging paging;

    /**
     * Gets the value of the keywords property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keywords property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeywords().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getKeywords() {
        if (keywords == null) {
            keywords = new ArrayList<String>();
        }
        return this.keywords;
    }

    /**
     * Gets the value of the keywordIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keywordIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeywordIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getKeywordIds() {
        if (keywordIds == null) {
            keywordIds = new ArrayList<Long>();
        }
        return this.keywordIds;
    }

    /**
     * Gets the value of the searchKeywordRecency property.
     * 
     * @return
     *     possible object is
     *     {@link KeywordRecency }
     *     
     */
    public KeywordRecency getSearchKeywordRecency() {
        return searchKeywordRecency;
    }

    /**
     * Sets the value of the searchKeywordRecency property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeywordRecency }
     *     
     */
    public void setSearchKeywordRecency(KeywordRecency value) {
        this.searchKeywordRecency = value;
    }

    /**
     * Gets the value of the searchKeywordFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link KeywordFrequency }
     *     
     */
    public KeywordFrequency getSearchKeywordFrequency() {
        return searchKeywordFrequency;
    }

    /**
     * Sets the value of the searchKeywordFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeywordFrequency }
     *     
     */
    public void setSearchKeywordFrequency(KeywordFrequency value) {
        this.searchKeywordFrequency = value;
    }

    /**
     * Gets the value of the sortField property.
     * 
     * @return
     *     possible object is
     *     {@link SortField }
     *     
     */
    public SortField getSortField() {
        return sortField;
    }

    /**
     * Sets the value of the sortField property.
     * 
     * @param value
     *     allowed object is
     *     {@link SortField }
     *     
     */
    public void setSortField(SortField value) {
        this.sortField = value;
    }

    /**
     * Gets the value of the sortType property.
     * 
     * @return
     *     possible object is
     *     {@link SortType }
     *     
     */
    public SortType getSortType() {
        return sortType;
    }

    /**
     * Sets the value of the sortType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SortType }
     *     
     */
    public void setSortType(SortType value) {
        this.sortType = value;
    }

    /**
     * Gets the value of the matchType property.
     * 
     * @return
     *     possible object is
     *     {@link MatchType }
     *     
     */
    public MatchType getMatchType() {
        return matchType;
    }

    /**
     * Sets the value of the matchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MatchType }
     *     
     */
    public void setMatchType(MatchType value) {
        this.matchType = value;
    }

    /**
     * Gets the value of the paging property.
     * 
     * @return
     *     possible object is
     *     {@link Paging }
     *     
     */
    public Paging getPaging() {
        return paging;
    }

    /**
     * Sets the value of the paging property.
     * 
     * @param value
     *     allowed object is
     *     {@link Paging }
     *     
     */
    public void setPaging(Paging value) {
        this.paging = value;
    }

}
