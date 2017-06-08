
package jp.yahooapis.im.V6.ReportDefinitionService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reportCategory" type="{http://im.yahooapis.jp/V6}ReportCategory"/>
 *         &lt;element name="lang" type="{http://im.yahooapis.jp/V6}ReportLang" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "reportCategory",
    "lang"
})
@XmlRootElement(name = "getReportFields")
public class GetReportFields {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ReportCategory reportCategory;
    @XmlSchemaType(name = "string")
    protected ReportLang lang;

    /**
     * Gets the value of the reportCategory property.
     * 
     * @return
     *     possible object is
     *     {@link ReportCategory }
     *     
     */
    public ReportCategory getReportCategory() {
        return reportCategory;
    }

    /**
     * Sets the value of the reportCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportCategory }
     *     
     */
    public void setReportCategory(ReportCategory value) {
        this.reportCategory = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link ReportLang }
     *     
     */
    public ReportLang getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportLang }
     *     
     */
    public void setLang(ReportLang value) {
        this.lang = value;
    }

}
