
package jp.yahooapis.im.v201903.auditlog;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201903.ReturnValue;


/**
 * <p>Java class for AuditLogDownloadValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuditLogDownloadValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201903}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="auditLogJob" type="{http://im.yahooapis.jp/V201903/AuditLog}AuditLogJob" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuditLogDownloadValues", propOrder = {
    "auditLogJob"
})
public class AuditLogDownloadValues
    extends ReturnValue
{

    protected AuditLogJob auditLogJob;

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

}
