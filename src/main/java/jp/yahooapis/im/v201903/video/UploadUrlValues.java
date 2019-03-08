
package jp.yahooapis.im.v201903.video;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201903.ReturnValue;


/**
 * <p>Java class for UploadUrlValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UploadUrlValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201903}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="uploadUrlValue" type="{http://im.yahooapis.jp/V201903/Video}UploadUrlValue" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UploadUrlValues", propOrder = {
    "uploadUrlValue"
})
public class UploadUrlValues
    extends ReturnValue
{

    protected UploadUrlValue uploadUrlValue;

    /**
     * Gets the value of the uploadUrlValue property.
     * 
     * @return
     *     possible object is
     *     {@link UploadUrlValue }
     *     
     */
    public UploadUrlValue getUploadUrlValue() {
        return uploadUrlValue;
    }

    /**
     * Sets the value of the uploadUrlValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link UploadUrlValue }
     *     
     */
    public void setUploadUrlValue(UploadUrlValue value) {
        this.uploadUrlValue = value;
    }

}
