
package jp.yahooapis.im.v201911.campaignmigration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampaignDownloadUrlValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignDownloadUrlValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="downloadScope" type="{http://im.yahooapis.jp/V201911/CampaignMigration}MigrationScope"/>
 *         &lt;element name="lang" type="{http://im.yahooapis.jp/V201911/CampaignMigration}MigrationLang"/>
 *         &lt;element name="downloadUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampaignDownloadUrlValue", propOrder = {
    "accountId",
    "downloadScope",
    "lang",
    "downloadUrl"
})
public class CampaignDownloadUrlValue {

    protected Long accountId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected MigrationScope downloadScope;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected MigrationLang lang;
    @XmlElement(required = true)
    protected String downloadUrl;

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
     * Gets the value of the downloadScope property.
     * 
     * @return
     *     possible object is
     *     {@link MigrationScope }
     *     
     */
    public MigrationScope getDownloadScope() {
        return downloadScope;
    }

    /**
     * Sets the value of the downloadScope property.
     * 
     * @param value
     *     allowed object is
     *     {@link MigrationScope }
     *     
     */
    public void setDownloadScope(MigrationScope value) {
        this.downloadScope = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link MigrationLang }
     *     
     */
    public MigrationLang getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link MigrationLang }
     *     
     */
    public void setLang(MigrationLang value) {
        this.lang = value;
    }

    /**
     * Gets the value of the downloadUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadUrl() {
        return downloadUrl;
    }

    /**
     * Sets the value of the downloadUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadUrl(String value) {
        this.downloadUrl = value;
    }

}
