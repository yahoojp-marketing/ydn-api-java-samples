
package jp.yahooapis.im.v201812.stats;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PeriodDatetime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PeriodDatetime">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="periodDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="periodTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeriodDatetime", propOrder = {
    "periodDate",
    "periodTime"
})
public class PeriodDatetime {

    protected String periodDate;
    protected String periodTime;

    /**
     * Gets the value of the periodDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodDate() {
        return periodDate;
    }

    /**
     * Sets the value of the periodDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodDate(String value) {
        this.periodDate = value;
    }

    /**
     * Gets the value of the periodTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodTime() {
        return periodTime;
    }

    /**
     * Sets the value of the periodTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodTime(String value) {
        this.periodTime = value;
    }

}
