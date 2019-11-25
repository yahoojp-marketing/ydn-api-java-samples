
package jp.yahooapis.im.v201911.auditlog;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201911.Page;


/**
 * <p>Java class for AuditLogDownloadStatusPage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuditLogDownloadStatusPage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201911}Page">
 *       &lt;sequence>
 *         &lt;element name="values" type="{http://im.yahooapis.jp/V201911/AuditLog}AuditLogDownloadValues" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuditLogDownloadStatusPage", propOrder = {
    "values"
})
public class AuditLogDownloadStatusPage
    extends Page
{

    protected List<AuditLogDownloadValues> values;

    /**
     * Gets the value of the values property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the values property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AuditLogDownloadValues }
     * 
     * 
     */
    public List<AuditLogDownloadValues> getValues() {
        if (values == null) {
            values = new ArrayList<AuditLogDownloadValues>();
        }
        return this.values;
    }

}
