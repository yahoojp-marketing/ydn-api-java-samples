
package jp.yahooapis.im.v201907.auditlog;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuditLogDownloadSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuditLogDownloadSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="updateSources" type="{http://im.yahooapis.jp/V201907/AuditLog}AuditLogUpdateSource" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dateRange" type="{http://im.yahooapis.jp/V201907/AuditLog}AuditLogDateRange" minOccurs="0"/>
 *         &lt;element name="auditLogJob" type="{http://im.yahooapis.jp/V201907/AuditLog}AuditLogJob" minOccurs="0"/>
 *         &lt;element name="lang" type="{http://im.yahooapis.jp/V201907/AuditLog}AuditLogLang" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuditLogDownloadSelector", propOrder = {
    "accountId",
    "campaignIds",
    "updateSources",
    "dateRange",
    "auditLogJob",
    "lang"
})
public class AuditLogDownloadSelector {

    protected long accountId;
    @XmlElement(type = Long.class)
    protected List<Long> campaignIds;
    @XmlSchemaType(name = "string")
    protected List<AuditLogUpdateSource> updateSources;
    protected AuditLogDateRange dateRange;
    protected AuditLogJob auditLogJob;
    @XmlSchemaType(name = "string")
    protected AuditLogLang lang;

    /**
     * Gets the value of the accountId property.
     * 
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     */
    public void setAccountId(long value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the campaignIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the campaignIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCampaignIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getCampaignIds() {
        if (campaignIds == null) {
            campaignIds = new ArrayList<Long>();
        }
        return this.campaignIds;
    }

    /**
     * Gets the value of the updateSources property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the updateSources property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUpdateSources().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AuditLogUpdateSource }
     * 
     * 
     */
    public List<AuditLogUpdateSource> getUpdateSources() {
        if (updateSources == null) {
            updateSources = new ArrayList<AuditLogUpdateSource>();
        }
        return this.updateSources;
    }

    /**
     * Gets the value of the dateRange property.
     * 
     * @return
     *     possible object is
     *     {@link AuditLogDateRange }
     *     
     */
    public AuditLogDateRange getDateRange() {
        return dateRange;
    }

    /**
     * Sets the value of the dateRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditLogDateRange }
     *     
     */
    public void setDateRange(AuditLogDateRange value) {
        this.dateRange = value;
    }

    /**
     * Gets the value of the auditLogJob property.
     * 
     * @return
     *     possible object is
     *     {@link AuditLogJob }
     *     
     */
    public AuditLogJob getAuditLogJob() {
        return auditLogJob;
    }

    /**
     * Sets the value of the auditLogJob property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditLogJob }
     *     
     */
    public void setAuditLogJob(AuditLogJob value) {
        this.auditLogJob = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link AuditLogLang }
     *     
     */
    public AuditLogLang getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditLogLang }
     *     
     */
    public void setLang(AuditLogLang value) {
        this.lang = value;
    }

}
