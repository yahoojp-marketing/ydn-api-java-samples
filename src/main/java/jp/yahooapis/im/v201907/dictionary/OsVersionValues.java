
package jp.yahooapis.im.v201907.dictionary;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201907.ReturnValue;


/**
 * <p>Java class for OsVersionValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OsVersionValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201907}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="osVersion" type="{http://im.yahooapis.jp/V201907/Dictionary}OsVersion" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OsVersionValues", propOrder = {
    "osVersion"
})
public class OsVersionValues
    extends ReturnValue
{

    protected List<OsVersion> osVersion;

    /**
     * Gets the value of the osVersion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the osVersion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOsVersion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OsVersion }
     * 
     * 
     */
    public List<OsVersion> getOsVersion() {
        if (osVersion == null) {
            osVersion = new ArrayList<OsVersion>();
        }
        return this.osVersion;
    }

}
