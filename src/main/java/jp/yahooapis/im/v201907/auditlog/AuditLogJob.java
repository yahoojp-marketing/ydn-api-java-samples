
package jp.yahooapis.im.v201907.auditlog;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuditLogJob complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuditLogJob">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="auditLogJobId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="auditLogJobName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="auditLogJobUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="auditLogJobStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="auditLogJobEndDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="auditLogJobStatus" type="{http://im.yahooapis.jp/V201907/AuditLog}AuditLogDownloadJobStatus" minOccurs="0"/>
 *         &lt;element name="progress" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="downloadAuditLogDownloadUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuditLogJob", propOrder = {
    "accountId",
    "auditLogJobId",
    "auditLogJobName",
    "auditLogJobUserName",
    "auditLogJobStartDate",
    "auditLogJobEndDate",
    "auditLogJobStatus",
    "progress",
    "downloadAuditLogDownloadUrl"
})
public class AuditLogJob {

    protected Long accountId;
    protected Long auditLogJobId;
    protected String auditLogJobName;
    protected String auditLogJobUserName;
    protected String auditLogJobStartDate;
    protected String auditLogJobEndDate;
    @XmlSchemaType(name = "string")
    protected AuditLogDownloadJobStatus auditLogJobStatus;
    protected Integer progress;
    protected String downloadAuditLogDownloadUrl;

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
     * Gets the value of the auditLogJobId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAuditLogJobId() {
        return auditLogJobId;
    }

    /**
     * Sets the value of the auditLogJobId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAuditLogJobId(Long value) {
        this.auditLogJobId = value;
    }

    /**
     * Gets the value of the auditLogJobName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuditLogJobName() {
        return auditLogJobName;
    }

    /**
     * Sets the value of the auditLogJobName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuditLogJobName(String value) {
        this.auditLogJobName = value;
    }

    /**
     * Gets the value of the auditLogJobUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuditLogJobUserName() {
        return auditLogJobUserName;
    }

    /**
     * Sets the value of the auditLogJobUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuditLogJobUserName(String value) {
        this.auditLogJobUserName = value;
    }

    /**
     * Gets the value of the auditLogJobStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuditLogJobStartDate() {
        return auditLogJobStartDate;
    }

    /**
     * Sets the value of the auditLogJobStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuditLogJobStartDate(String value) {
        this.auditLogJobStartDate = value;
    }

    /**
     * Gets the value of the auditLogJobEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuditLogJobEndDate() {
        return auditLogJobEndDate;
    }

    /**
     * Sets the value of the auditLogJobEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuditLogJobEndDate(String value) {
        this.auditLogJobEndDate = value;
    }

    /**
     * Gets the value of the auditLogJobStatus property.
     * 
     * @return
     *     possible object is
     *     {@link AuditLogDownloadJobStatus }
     *     
     */
    public AuditLogDownloadJobStatus getAuditLogJobStatus() {
        return auditLogJobStatus;
    }

    /**
     * Sets the value of the auditLogJobStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditLogDownloadJobStatus }
     *     
     */
    public void setAuditLogJobStatus(AuditLogDownloadJobStatus value) {
        this.auditLogJobStatus = value;
    }

    /**
     * Gets the value of the progress property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getProgress() {
        return progress;
    }

    /**
     * Sets the value of the progress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setProgress(Integer value) {
        this.progress = value;
    }

    /**
     * Gets the value of the downloadAuditLogDownloadUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadAuditLogDownloadUrl() {
        return downloadAuditLogDownloadUrl;
    }

    /**
     * Sets the value of the downloadAuditLogDownloadUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadAuditLogDownloadUrl(String value) {
        this.downloadAuditLogDownloadUrl = value;
    }

}
