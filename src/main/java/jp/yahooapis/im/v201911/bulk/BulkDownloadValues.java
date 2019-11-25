
package jp.yahooapis.im.v201911.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201911.ReturnValue;


/**
 * <p>Java class for BulkDownloadValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BulkDownloadValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201911}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="downloadBulkJob" type="{http://im.yahooapis.jp/V201911/Bulk}DownloadBulkJob" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BulkDownloadValues", propOrder = {
    "downloadBulkJob"
})
public class BulkDownloadValues
    extends ReturnValue
{

    protected DownloadBulkJob downloadBulkJob;

    /**
     * Gets the value of the downloadBulkJob property.
     * 
     * @return
     *     possible object is
     *     {@link DownloadBulkJob }
     *     
     */
    public DownloadBulkJob getDownloadBulkJob() {
        return downloadBulkJob;
    }

    /**
     * Sets the value of the downloadBulkJob property.
     * 
     * @param value
     *     allowed object is
     *     {@link DownloadBulkJob }
     *     
     */
    public void setDownloadBulkJob(DownloadBulkJob value) {
        this.downloadBulkJob = value;
    }

}
