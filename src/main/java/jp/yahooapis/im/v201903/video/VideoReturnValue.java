
package jp.yahooapis.im.v201903.video;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201903.ListReturnValue;


/**
 * <p>Java class for VideoReturnValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VideoReturnValue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201903}ListReturnValue">
 *       &lt;sequence>
 *         &lt;element name="values" type="{http://im.yahooapis.jp/V201903/Video}VideoValues" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VideoReturnValue", propOrder = {
    "values"
})
public class VideoReturnValue
    extends ListReturnValue
{

    protected List<VideoValues> values;

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
     * {@link VideoValues }
     * 
     * 
     */
    public List<VideoValues> getValues() {
        if (values == null) {
            values = new ArrayList<VideoValues>();
        }
        return this.values;
    }

}
