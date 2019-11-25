
package jp.yahooapis.im.v201911.campaignmigration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MigrationJob complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MigrationJob">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="migrationJobId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="migrationScope" type="{http://im.yahooapis.jp/V201911/CampaignMigration}MigrationScope"/>
 *         &lt;element name="migrationJobStatus" type="{http://im.yahooapis.jp/V201911/CampaignMigration}MigrationJobStatus"/>
 *         &lt;element name="migrationJobSubmitDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="migrationJobEndDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalCount" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="inProgressCount" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="succeededCount" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="failedCount" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="downloadOriginalFileUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="downloadErrorFileUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MigrationJob", propOrder = {
    "migrationJobId",
    "accountId",
    "migrationScope",
    "migrationJobStatus",
    "migrationJobSubmitDate",
    "migrationJobEndDate",
    "totalCount",
    "inProgressCount",
    "succeededCount",
    "failedCount",
    "downloadOriginalFileUrl",
    "downloadErrorFileUrl"
})
public class MigrationJob {

    protected long migrationJobId;
    protected Long accountId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected MigrationScope migrationScope;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected MigrationJobStatus migrationJobStatus;
    @XmlElement(required = true)
    protected String migrationJobSubmitDate;
    protected String migrationJobEndDate;
    protected long totalCount;
    protected long inProgressCount;
    protected long succeededCount;
    protected long failedCount;
    @XmlElement(required = true)
    protected String downloadOriginalFileUrl;
    protected String downloadErrorFileUrl;

    /**
     * Gets the value of the migrationJobId property.
     * 
     */
    public long getMigrationJobId() {
        return migrationJobId;
    }

    /**
     * Sets the value of the migrationJobId property.
     * 
     */
    public void setMigrationJobId(long value) {
        this.migrationJobId = value;
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
     * Gets the value of the migrationScope property.
     * 
     * @return
     *     possible object is
     *     {@link MigrationScope }
     *     
     */
    public MigrationScope getMigrationScope() {
        return migrationScope;
    }

    /**
     * Sets the value of the migrationScope property.
     * 
     * @param value
     *     allowed object is
     *     {@link MigrationScope }
     *     
     */
    public void setMigrationScope(MigrationScope value) {
        this.migrationScope = value;
    }

    /**
     * Gets the value of the migrationJobStatus property.
     * 
     * @return
     *     possible object is
     *     {@link MigrationJobStatus }
     *     
     */
    public MigrationJobStatus getMigrationJobStatus() {
        return migrationJobStatus;
    }

    /**
     * Sets the value of the migrationJobStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link MigrationJobStatus }
     *     
     */
    public void setMigrationJobStatus(MigrationJobStatus value) {
        this.migrationJobStatus = value;
    }

    /**
     * Gets the value of the migrationJobSubmitDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMigrationJobSubmitDate() {
        return migrationJobSubmitDate;
    }

    /**
     * Sets the value of the migrationJobSubmitDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMigrationJobSubmitDate(String value) {
        this.migrationJobSubmitDate = value;
    }

    /**
     * Gets the value of the migrationJobEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMigrationJobEndDate() {
        return migrationJobEndDate;
    }

    /**
     * Sets the value of the migrationJobEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMigrationJobEndDate(String value) {
        this.migrationJobEndDate = value;
    }

    /**
     * Gets the value of the totalCount property.
     * 
     */
    public long getTotalCount() {
        return totalCount;
    }

    /**
     * Sets the value of the totalCount property.
     * 
     */
    public void setTotalCount(long value) {
        this.totalCount = value;
    }

    /**
     * Gets the value of the inProgressCount property.
     * 
     */
    public long getInProgressCount() {
        return inProgressCount;
    }

    /**
     * Sets the value of the inProgressCount property.
     * 
     */
    public void setInProgressCount(long value) {
        this.inProgressCount = value;
    }

    /**
     * Gets the value of the succeededCount property.
     * 
     */
    public long getSucceededCount() {
        return succeededCount;
    }

    /**
     * Sets the value of the succeededCount property.
     * 
     */
    public void setSucceededCount(long value) {
        this.succeededCount = value;
    }

    /**
     * Gets the value of the failedCount property.
     * 
     */
    public long getFailedCount() {
        return failedCount;
    }

    /**
     * Sets the value of the failedCount property.
     * 
     */
    public void setFailedCount(long value) {
        this.failedCount = value;
    }

    /**
     * Gets the value of the downloadOriginalFileUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadOriginalFileUrl() {
        return downloadOriginalFileUrl;
    }

    /**
     * Sets the value of the downloadOriginalFileUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadOriginalFileUrl(String value) {
        this.downloadOriginalFileUrl = value;
    }

    /**
     * Gets the value of the downloadErrorFileUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadErrorFileUrl() {
        return downloadErrorFileUrl;
    }

    /**
     * Sets the value of the downloadErrorFileUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadErrorFileUrl(String value) {
        this.downloadErrorFileUrl = value;
    }

}
