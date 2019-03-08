
package jp.yahooapis.im.v201903.stats;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Period complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Period">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="periodStartDate" type="{http://im.yahooapis.jp/V201903/Stats}PeriodDatetime" minOccurs="0"/>
 *         &lt;element name="periodEndDate" type="{http://im.yahooapis.jp/V201903/Stats}PeriodDatetime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Period", propOrder = {
    "periodStartDate",
    "periodEndDate"
})
public class Period {

    protected PeriodDatetime periodStartDate;
    protected PeriodDatetime periodEndDate;

    /**
     * Gets the value of the periodStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link PeriodDatetime }
     *     
     */
    public PeriodDatetime getPeriodStartDate() {
        return periodStartDate;
    }

    /**
     * Sets the value of the periodStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodDatetime }
     *     
     */
    public void setPeriodStartDate(PeriodDatetime value) {
        this.periodStartDate = value;
    }

    /**
     * Gets the value of the periodEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link PeriodDatetime }
     *     
     */
    public PeriodDatetime getPeriodEndDate() {
        return periodEndDate;
    }

    /**
     * Sets the value of the periodEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodDatetime }
     *     
     */
    public void setPeriodEndDate(PeriodDatetime value) {
        this.periodEndDate = value;
    }

}
