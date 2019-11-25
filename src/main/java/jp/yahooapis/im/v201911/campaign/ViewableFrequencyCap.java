
package jp.yahooapis.im.v201911.campaign;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ViewableFrequencyCap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ViewableFrequencyCap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="level" type="{http://im.yahooapis.jp/V201911/Campaign}FrequencyLevel" minOccurs="0"/>
 *         &lt;element name="timeUnit" type="{http://im.yahooapis.jp/V201911/Campaign}FrequencyTimeUnit" minOccurs="0"/>
 *         &lt;element name="vImps" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ViewableFrequencyCap", propOrder = {
    "level",
    "timeUnit",
    "vImps"
})
public class ViewableFrequencyCap {

    @XmlSchemaType(name = "string")
    protected FrequencyLevel level;
    @XmlSchemaType(name = "string")
    protected FrequencyTimeUnit timeUnit;
    protected Long vImps;

    /**
     * Gets the value of the level property.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyLevel }
     *     
     */
    public FrequencyLevel getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyLevel }
     *     
     */
    public void setLevel(FrequencyLevel value) {
        this.level = value;
    }

    /**
     * Gets the value of the timeUnit property.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyTimeUnit }
     *     
     */
    public FrequencyTimeUnit getTimeUnit() {
        return timeUnit;
    }

    /**
     * Sets the value of the timeUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyTimeUnit }
     *     
     */
    public void setTimeUnit(FrequencyTimeUnit value) {
        this.timeUnit = value;
    }

    /**
     * Gets the value of the vImps property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getVImps() {
        return vImps;
    }

    /**
     * Sets the value of the vImps property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setVImps(Long value) {
        this.vImps = value;
    }

}
