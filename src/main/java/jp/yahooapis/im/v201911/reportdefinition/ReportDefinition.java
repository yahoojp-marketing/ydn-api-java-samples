
package jp.yahooapis.im.v201911.reportdefinition;

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
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="reportJobId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="reportJobStatus" type="{http://im.yahooapis.jp/V201911/ReportDefinition}ReportJobStatus" minOccurs="0"/>
 *         &lt;element name="reportJobErrorDetail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="completeTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportDownloadUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateRangeType" type="{http://im.yahooapis.jp/V201911/ReportDefinition}ReportDateRangeType" minOccurs="0"/>
 *         &lt;element name="dateRange" type="{http://im.yahooapis.jp/V201911/ReportDefinition}ReportDateRange" minOccurs="0"/>
 *         &lt;element name="frequencyRange" type="{http://im.yahooapis.jp/V201911/ReportDefinition}ReportFrequencyRange" minOccurs="0"/>
 *         &lt;element name="filters" type="{http://im.yahooapis.jp/V201911/ReportDefinition}ReportFilter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sortFields" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fields" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="format" type="{http://im.yahooapis.jp/V201911/ReportDefinition}ReportDownloadFormat" minOccurs="0"/>
 *         &lt;element name="encode" type="{http://im.yahooapis.jp/V201911/ReportDefinition}ReportDownloadEncode" minOccurs="0"/>
 *         &lt;element name="compress" type="{http://im.yahooapis.jp/V201911/ReportDefinition}ReportZip" minOccurs="0"/>
 *         &lt;element name="language" type="{http://im.yahooapis.jp/V201911/ReportDefinition}ReportLang" minOccurs="0"/>
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
    "accountId",
    "reportJobId",
    "reportJobStatus",
    "reportJobErrorDetail",
    "requestTime",
    "completeTime",
    "reportDownloadUrl",
    "reportName",
    "dateRangeType",
    "dateRange",
    "frequencyRange",
    "filters",
    "sortFields",
    "fields",
    "format",
    "encode",
    "compress",
    "language"
})
public class ReportDefinition {

    protected Long accountId;
    protected Long reportJobId;
    @XmlSchemaType(name = "string")
    protected ReportJobStatus reportJobStatus;
    protected String reportJobErrorDetail;
    protected String requestTime;
    protected String completeTime;
    protected String reportDownloadUrl;
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
    protected ReportZip compress;
    @XmlSchemaType(name = "string")
    protected ReportLang language;

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
     * Gets the value of the reportJobId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getReportJobId() {
        return reportJobId;
    }

    /**
     * Sets the value of the reportJobId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setReportJobId(Long value) {
        this.reportJobId = value;
    }

    /**
     * Gets the value of the reportJobStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ReportJobStatus }
     *     
     */
    public ReportJobStatus getReportJobStatus() {
        return reportJobStatus;
    }

    /**
     * Sets the value of the reportJobStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportJobStatus }
     *     
     */
    public void setReportJobStatus(ReportJobStatus value) {
        this.reportJobStatus = value;
    }

    /**
     * Gets the value of the reportJobErrorDetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportJobErrorDetail() {
        return reportJobErrorDetail;
    }

    /**
     * Sets the value of the reportJobErrorDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportJobErrorDetail(String value) {
        this.reportJobErrorDetail = value;
    }

    /**
     * Gets the value of the requestTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestTime() {
        return requestTime;
    }

    /**
     * Sets the value of the requestTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestTime(String value) {
        this.requestTime = value;
    }

    /**
     * Gets the value of the completeTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompleteTime() {
        return completeTime;
    }

    /**
     * Sets the value of the completeTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompleteTime(String value) {
        this.completeTime = value;
    }

    /**
     * Gets the value of the reportDownloadUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportDownloadUrl() {
        return reportDownloadUrl;
    }

    /**
     * Sets the value of the reportDownloadUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportDownloadUrl(String value) {
        this.reportDownloadUrl = value;
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
     * Gets the value of the compress property.
     * 
     * @return
     *     possible object is
     *     {@link ReportZip }
     *     
     */
    public ReportZip getCompress() {
        return compress;
    }

    /**
     * Sets the value of the compress property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportZip }
     *     
     */
    public void setCompress(ReportZip value) {
        this.compress = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link ReportLang }
     *     
     */
    public ReportLang getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportLang }
     *     
     */
    public void setLanguage(ReportLang value) {
        this.language = value;
    }

}
