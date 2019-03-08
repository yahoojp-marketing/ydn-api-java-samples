
package jp.yahooapis.im.v201903.stats;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201903.Page;


/**
 * <p>Java class for StatsPage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatsPage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201903}Page">
 *       &lt;sequence>
 *         &lt;element name="period" type="{http://im.yahooapis.jp/V201903/Stats}Period" minOccurs="0"/>
 *         &lt;element name="values" type="{http://im.yahooapis.jp/V201903/Stats}StatsValues" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatsPage", propOrder = {
    "period",
    "values"
})
public class StatsPage
    extends Page
{

    protected Period period;
    protected List<StatsValues> values;

    /**
     * Gets the value of the period property.
     * 
     * @return
     *     possible object is
     *     {@link Period }
     *     
     */
    public Period getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link Period }
     *     
     */
    public void setPeriod(Period value) {
        this.period = value;
    }

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
     * {@link StatsValues }
     * 
     * 
     */
    public List<StatsValues> getValues() {
        if (values == null) {
            values = new ArrayList<StatsValues>();
        }
        return this.values;
    }

}
