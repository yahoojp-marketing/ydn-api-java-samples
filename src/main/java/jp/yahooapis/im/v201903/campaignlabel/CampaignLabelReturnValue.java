
package jp.yahooapis.im.v201903.campaignlabel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201903.ListReturnValue;


/**
 * <p>Java class for CampaignLabelReturnValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignLabelReturnValue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201903}ListReturnValue">
 *       &lt;sequence>
 *         &lt;element name="values" type="{http://im.yahooapis.jp/V201903/CampaignLabel}CampaignLabelValues" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampaignLabelReturnValue", propOrder = {
    "values"
})
public class CampaignLabelReturnValue
    extends ListReturnValue
{

    protected List<CampaignLabelValues> values;

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
     * {@link CampaignLabelValues }
     * 
     * 
     */
    public List<CampaignLabelValues> getValues() {
        if (values == null) {
            values = new ArrayList<CampaignLabelValues>();
        }
        return this.values;
    }

}
