
package jp.yahooapis.im.V5.StatsService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Stats complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Stats">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="imps" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="clickRate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="clickRateComparisionResult" type="{http://im.yahooapis.jp/V5}ComparisionResult" minOccurs="0"/>
 *         &lt;element name="totalClickCost" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="clickCnt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="avgClickCost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="avgClickCostComparisionResult" type="{http://im.yahooapis.jp/V5}ComparisionResult" minOccurs="0"/>
 *         &lt;element name="convCnt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="convRate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="convRateComparisionResult" type="{http://im.yahooapis.jp/V5}ComparisionResult" minOccurs="0"/>
 *         &lt;element name="cpa" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="cpaComparisionResult" type="{http://im.yahooapis.jp/V5}ComparisionResult" minOccurs="0"/>
 *         &lt;element name="avgDeliverRank" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="totalVimps" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="vImps" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="inViewClickCnt" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="inViewRate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="inViewClickRate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Stats", propOrder = {
    "imps",
    "clickRate",
    "clickRateComparisionResult",
    "totalClickCost",
    "clickCnt",
    "avgClickCost",
    "avgClickCostComparisionResult",
    "convCnt",
    "convRate",
    "convRateComparisionResult",
    "cpa",
    "cpaComparisionResult",
    "avgDeliverRank",
    "totalVimps",
    "vImps",
    "inViewClickCnt",
    "inViewRate",
    "inViewClickRate"
})
public class Stats {

    protected Long imps;
    protected Double clickRate;
    @XmlSchemaType(name = "string")
    protected ComparisionResult clickRateComparisionResult;
    protected Long totalClickCost;
    protected Long clickCnt;
    protected Double avgClickCost;
    @XmlSchemaType(name = "string")
    protected ComparisionResult avgClickCostComparisionResult;
    protected Long convCnt;
    protected Double convRate;
    @XmlSchemaType(name = "string")
    protected ComparisionResult convRateComparisionResult;
    protected Double cpa;
    @XmlSchemaType(name = "string")
    protected ComparisionResult cpaComparisionResult;
    protected Double avgDeliverRank;
    protected Long totalVimps;
    protected Long vImps;
    protected Long inViewClickCnt;
    protected Double inViewRate;
    protected Double inViewClickRate;

    /**
     * Gets the value of the imps property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getImps() {
        return imps;
    }

    /**
     * Sets the value of the imps property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setImps(Long value) {
        this.imps = value;
    }

    /**
     * Gets the value of the clickRate property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getClickRate() {
        return clickRate;
    }

    /**
     * Sets the value of the clickRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setClickRate(Double value) {
        this.clickRate = value;
    }

    /**
     * Gets the value of the clickRateComparisionResult property.
     * 
     * @return
     *     possible object is
     *     {@link ComparisionResult }
     *     
     */
    public ComparisionResult getClickRateComparisionResult() {
        return clickRateComparisionResult;
    }

    /**
     * Sets the value of the clickRateComparisionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComparisionResult }
     *     
     */
    public void setClickRateComparisionResult(ComparisionResult value) {
        this.clickRateComparisionResult = value;
    }

    /**
     * Gets the value of the totalClickCost property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalClickCost() {
        return totalClickCost;
    }

    /**
     * Sets the value of the totalClickCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalClickCost(Long value) {
        this.totalClickCost = value;
    }

    /**
     * Gets the value of the clickCnt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getClickCnt() {
        return clickCnt;
    }

    /**
     * Sets the value of the clickCnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setClickCnt(Long value) {
        this.clickCnt = value;
    }

    /**
     * Gets the value of the avgClickCost property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAvgClickCost() {
        return avgClickCost;
    }

    /**
     * Sets the value of the avgClickCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAvgClickCost(Double value) {
        this.avgClickCost = value;
    }

    /**
     * Gets the value of the avgClickCostComparisionResult property.
     * 
     * @return
     *     possible object is
     *     {@link ComparisionResult }
     *     
     */
    public ComparisionResult getAvgClickCostComparisionResult() {
        return avgClickCostComparisionResult;
    }

    /**
     * Sets the value of the avgClickCostComparisionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComparisionResult }
     *     
     */
    public void setAvgClickCostComparisionResult(ComparisionResult value) {
        this.avgClickCostComparisionResult = value;
    }

    /**
     * Gets the value of the convCnt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getConvCnt() {
        return convCnt;
    }

    /**
     * Sets the value of the convCnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setConvCnt(Long value) {
        this.convCnt = value;
    }

    /**
     * Gets the value of the convRate property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getConvRate() {
        return convRate;
    }

    /**
     * Sets the value of the convRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setConvRate(Double value) {
        this.convRate = value;
    }

    /**
     * Gets the value of the convRateComparisionResult property.
     * 
     * @return
     *     possible object is
     *     {@link ComparisionResult }
     *     
     */
    public ComparisionResult getConvRateComparisionResult() {
        return convRateComparisionResult;
    }

    /**
     * Sets the value of the convRateComparisionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComparisionResult }
     *     
     */
    public void setConvRateComparisionResult(ComparisionResult value) {
        this.convRateComparisionResult = value;
    }

    /**
     * Gets the value of the cpa property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCpa() {
        return cpa;
    }

    /**
     * Sets the value of the cpa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCpa(Double value) {
        this.cpa = value;
    }

    /**
     * Gets the value of the cpaComparisionResult property.
     * 
     * @return
     *     possible object is
     *     {@link ComparisionResult }
     *     
     */
    public ComparisionResult getCpaComparisionResult() {
        return cpaComparisionResult;
    }

    /**
     * Sets the value of the cpaComparisionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComparisionResult }
     *     
     */
    public void setCpaComparisionResult(ComparisionResult value) {
        this.cpaComparisionResult = value;
    }

    /**
     * Gets the value of the avgDeliverRank property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAvgDeliverRank() {
        return avgDeliverRank;
    }

    /**
     * Sets the value of the avgDeliverRank property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAvgDeliverRank(Double value) {
        this.avgDeliverRank = value;
    }

    /**
     * Gets the value of the totalVimps property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalVimps() {
        return totalVimps;
    }

    /**
     * Sets the value of the totalVimps property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalVimps(Long value) {
        this.totalVimps = value;
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

    /**
     * Gets the value of the inViewClickCnt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInViewClickCnt() {
        return inViewClickCnt;
    }

    /**
     * Sets the value of the inViewClickCnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInViewClickCnt(Long value) {
        this.inViewClickCnt = value;
    }

    /**
     * Gets the value of the inViewRate property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInViewRate() {
        return inViewRate;
    }

    /**
     * Sets the value of the inViewRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInViewRate(Double value) {
        this.inViewRate = value;
    }

    /**
     * Gets the value of the inViewClickRate property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInViewClickRate() {
        return inViewClickRate;
    }

    /**
     * Sets the value of the inViewClickRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInViewClickRate(Double value) {
        this.inViewClickRate = value;
    }

}
