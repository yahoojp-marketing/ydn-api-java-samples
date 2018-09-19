
package jp.yahooapis.im.v201809.conversiontracker;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StatsPeriodCustomDate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatsPeriodCustomDate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="statsStartDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statsEndDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatsPeriodCustomDate", propOrder = {
    "statsStartDate",
    "statsEndDate"
})
public class StatsPeriodCustomDate {

    @XmlElement(required = true)
    protected String statsStartDate;
    @XmlElement(required = true)
    protected String statsEndDate;

    /**
     * Gets the value of the statsStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatsStartDate() {
        return statsStartDate;
    }

    /**
     * Sets the value of the statsStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatsStartDate(String value) {
        this.statsStartDate = value;
    }

    /**
     * Gets the value of the statsEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatsEndDate() {
        return statsEndDate;
    }

    /**
     * Sets the value of the statsEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatsEndDate(String value) {
        this.statsEndDate = value;
    }

}
