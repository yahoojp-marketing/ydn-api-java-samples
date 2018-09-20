
package jp.yahooapis.im.v201809.report;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201809.ReturnValue;


/**
 * <p>Java class for ReportValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201809}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="reportRecord" type="{http://im.yahooapis.jp/V201809/Report}ReportRecord" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportValues", propOrder = {
    "reportRecord"
})
public class ReportValues
    extends ReturnValue
{

    protected ReportRecord reportRecord;

    /**
     * Gets the value of the reportRecord property.
     * 
     * @return
     *     possible object is
     *     {@link ReportRecord }
     *     
     */
    public ReportRecord getReportRecord() {
        return reportRecord;
    }

    /**
     * Sets the value of the reportRecord property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportRecord }
     *     
     */
    public void setReportRecord(ReportRecord value) {
        this.reportRecord = value;
    }

}
