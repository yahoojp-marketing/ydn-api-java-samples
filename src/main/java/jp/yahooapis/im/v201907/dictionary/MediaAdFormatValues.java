
package jp.yahooapis.im.v201907.dictionary;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201907.ReturnValue;


/**
 * <p>Java class for MediaAdFormatValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MediaAdFormatValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201907}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="mediaAdFormat" type="{http://im.yahooapis.jp/V201907/Dictionary}MediaAdFormat" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MediaAdFormatValues", propOrder = {
    "mediaAdFormat"
})
public class MediaAdFormatValues
    extends ReturnValue
{

    protected List<MediaAdFormat> mediaAdFormat;

    /**
     * Gets the value of the mediaAdFormat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mediaAdFormat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMediaAdFormat().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MediaAdFormat }
     * 
     * 
     */
    public List<MediaAdFormat> getMediaAdFormat() {
        if (mediaAdFormat == null) {
            mediaAdFormat = new ArrayList<MediaAdFormat>();
        }
        return this.mediaAdFormat;
    }

}
