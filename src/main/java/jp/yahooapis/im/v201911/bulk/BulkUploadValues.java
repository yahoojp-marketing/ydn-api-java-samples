
package jp.yahooapis.im.v201911.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201911.ReturnValue;


/**
 * <p>Java class for BulkUploadValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BulkUploadValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201911}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="uploadBulkJob" type="{http://im.yahooapis.jp/V201911/Bulk}UploadBulkJob" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BulkUploadValues", propOrder = {
    "uploadBulkJob"
})
public class BulkUploadValues
    extends ReturnValue
{

    protected UploadBulkJob uploadBulkJob;

    /**
     * Gets the value of the uploadBulkJob property.
     * 
     * @return
     *     possible object is
     *     {@link UploadBulkJob }
     *     
     */
    public UploadBulkJob getUploadBulkJob() {
        return uploadBulkJob;
    }

    /**
     * Sets the value of the uploadBulkJob property.
     * 
     * @param value
     *     allowed object is
     *     {@link UploadBulkJob }
     *     
     */
    public void setUploadBulkJob(UploadBulkJob value) {
        this.uploadBulkJob = value;
    }

}
