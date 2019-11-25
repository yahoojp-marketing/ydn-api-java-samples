
package jp.yahooapis.im.v201911.dictionary;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201911.ReturnValue;


/**
 * <p>Java class for ThirdPartyTrackingDomainValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ThirdPartyTrackingDomainValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201911}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="thirdPartyTrackingDomain" type="{http://im.yahooapis.jp/V201911/Dictionary}ThirdPartyTrackingDomain" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ThirdPartyTrackingDomainValues", propOrder = {
    "thirdPartyTrackingDomain"
})
public class ThirdPartyTrackingDomainValues
    extends ReturnValue
{

    protected List<ThirdPartyTrackingDomain> thirdPartyTrackingDomain;

    /**
     * Gets the value of the thirdPartyTrackingDomain property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the thirdPartyTrackingDomain property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThirdPartyTrackingDomain().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ThirdPartyTrackingDomain }
     * 
     * 
     */
    public List<ThirdPartyTrackingDomain> getThirdPartyTrackingDomain() {
        if (thirdPartyTrackingDomain == null) {
            thirdPartyTrackingDomain = new ArrayList<ThirdPartyTrackingDomain>();
        }
        return this.thirdPartyTrackingDomain;
    }

}
