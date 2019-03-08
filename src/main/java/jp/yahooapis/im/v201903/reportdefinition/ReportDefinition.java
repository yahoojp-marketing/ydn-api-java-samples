
package jp.yahooapis.im.v201903.reportdefinition;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportDefinition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reportId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="reportName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateRangeType" type="{http://im.yahooapis.jp/V201903/ReportDefinition}ReportDateRangeType" minOccurs="0"/>
 *         &lt;element name="dateRange" type="{http://im.yahooapis.jp/V201903/ReportDefinition}ReportDateRange" minOccurs="0"/>
 *         &lt;element name="frequencyRange" type="{http://im.yahooapis.jp/V201903/ReportDefinition}ReportFrequencyRange" minOccurs="0"/>
 *         &lt;element name="filters" type="{http://im.yahooapis.jp/V201903/ReportDefinition}ReportFilter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sortFields" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fields" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="format" type="{http://im.yahooapis.jp/V201903/ReportDefinition}ReportDownloadFormat" minOccurs="0"/>
 *         &lt;element name="encode" type="{http://im.yahooapis.jp/V201903/ReportDefinition}ReportDownloadEncode" minOccurs="0"/>
 *         &lt;element name="zip" type="{http://im.yahooapis.jp/V201903/ReportDefinition}ReportZip" minOccurs="0"/>
 *         &lt;element name="lang" type="{http://im.yahooapis.jp/V201903/ReportDefinition}ReportLang" minOccurs="0"/>
 *         &lt;element name="intervalType" type="{http://im.yahooapis.jp/V201903/ReportDefinition}ReportIntervalType" minOccurs="0"/>
 *         &lt;element name="specifyDay" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="addTemplate" type="{http://im.yahooapis.jp/V201903/ReportDefinition}ReportAddTemplate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportDefinition", propOrder = {
    "reportId",
    "accountId",
    "reportName",
    "dateRangeType",
    "dateRange",
    "frequencyRange",
    "filters",
    "sortFields",
    "fields",
    "format",
    "encode",
    "zip",
    "lang",
    "intervalType",
    "specifyDay",
    "addTemplate"
})
public class ReportDefinition {

    protected Long reportId;
    protected Long accountId;
    protected String reportName;
    @XmlSchemaType(name = "string")
    protected ReportDateRangeType dateRangeType;
    protected ReportDateRange dateRange;
    @XmlSchemaType(name = "string")
    protected ReportFrequencyRange frequencyRange;
    protected List<ReportFilter> filters;
    protected List<String> sortFields;
    protected List<String> fields;
    @XmlSchemaType(name = "string")
    protected ReportDownloadFormat format;
    @XmlSchemaType(name = "string")
    protected ReportDownloadEncode encode;
    @XmlSchemaType(name = "string")
    protected ReportZip zip;
    @XmlSchemaType(name = "string")
    protected ReportLang lang;
    @XmlSchemaType(name = "string")
    protected ReportIntervalType intervalType;
    protected Integer specifyDay;
    @XmlSchemaType(name = "string")
    protected ReportAddTemplate addTemplate;

    /**
     * Gets the value of the reportId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getReportId() {
        return reportId;
    }

    /**
     * Sets the value of the reportId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setReportId(Long value) {
        this.reportId = value;
    }

    /**
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccountId(Long value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the reportName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * Sets the value of the reportName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportName(String value) {
        this.reportName = value;
    }

    /**
     * Gets the value of the dateRangeType property.
     * 
     * @return
     *     possible object is
     *     {@link ReportDateRangeType }
     *     
     */
    public ReportDateRangeType getDateRangeType() {
        return dateRangeType;
    }

    /**
     * Sets the value of the dateRangeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportDateRangeType }
     *     
     */
    public void setDateRangeType(ReportDateRangeType value) {
        this.dateRangeType = value;
    }

    /**
     * Gets the value of the dateRange property.
     * 
     * @return
     *     possible object is
     *     {@link ReportDateRange }
     *     
     */
    public ReportDateRange getDateRange() {
        return dateRange;
    }

    /**
     * Sets the value of the dateRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportDateRange }
     *     
     */
    public void setDateRange(ReportDateRange value) {
        this.dateRange = value;
    }

    /**
     * Gets the value of the frequencyRange property.
     * 
     * @return
     *     possible object is
     *     {@link ReportFrequencyRange }
     *     
     */
    public ReportFrequencyRange getFrequencyRange() {
        return frequencyRange;
    }

    /**
     * Sets the value of the frequencyRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportFrequencyRange }
     *     
     */
    public void setFrequencyRange(ReportFrequencyRange value) {
        this.frequencyRange = value;
    }

    /**
     * Gets the value of the filters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReportFilter }
     * 
     * 
     */
    public List<ReportFilter> getFilters() {
        if (filters == null) {
            filters = new ArrayList<ReportFilter>();
        }
        return this.filters;
    }

    /**
     * Gets the value of the sortFields property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sortFields property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSortFields().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSortFields() {
        if (sortFields == null) {
            sortFields = new ArrayList<String>();
        }
        return this.sortFields;
    }

    /**
     * Gets the value of the fields property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fields property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFields().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFields() {
        if (fields == null) {
            fields = new ArrayList<String>();
        }
        return this.fields;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link ReportDownloadFormat }
     *     
     */
    public ReportDownloadFormat getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportDownloadFormat }
     *     
     */
    public void setFormat(ReportDownloadFormat value) {
        this.format = value;
    }

    /**
     * Gets the value of the encode property.
     * 
     * @return
     *     possible object is
     *     {@link ReportDownloadEncode }
     *     
     */
    public ReportDownloadEncode getEncode() {
        return encode;
    }

    /**
     * Sets the value of the encode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportDownloadEncode }
     *     
     */
    public void setEncode(ReportDownloadEncode value) {
        this.encode = value;
    }

    /**
     * Gets the value of the zip property.
     * 
     * @return
     *     possible object is
     *     {@link ReportZip }
     *     
     */
    public ReportZip getZip() {
        return zip;
    }

    /**
     * Sets the value of the zip property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportZip }
     *     
     */
    public void setZip(ReportZip value) {
        this.zip = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link ReportLang }
     *     
     */
    public ReportLang getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportLang }
     *     
     */
    public void setLang(ReportLang value) {
        this.lang = value;
    }

    /**
     * Gets the value of the intervalType property.
     * 
     * @return
     *     possible object is
     *     {@link ReportIntervalType }
     *     
     */
    public ReportIntervalType getIntervalType() {
        return intervalType;
    }

    /**
     * Sets the value of the intervalType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportIntervalType }
     *     
     */
    public void setIntervalType(ReportIntervalType value) {
        this.intervalType = value;
    }

    /**
     * Gets the value of the specifyDay property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSpecifyDay() {
        return specifyDay;
    }

    /**
     * Sets the value of the specifyDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSpecifyDay(Integer value) {
        this.specifyDay = value;
    }

    /**
     * Gets the value of the addTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link ReportAddTemplate }
     *     
     */
    public ReportAddTemplate getAddTemplate() {
        return addTemplate;
    }

    /**
     * Sets the value of the addTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportAddTemplate }
     *     
     */
    public void setAddTemplate(ReportAddTemplate value) {
        this.addTemplate = value;
    }

}
