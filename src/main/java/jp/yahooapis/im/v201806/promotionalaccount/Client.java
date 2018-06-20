
package jp.yahooapis.im.v201806.promotionalaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Client complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Client">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="companyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="companyNameKana" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enterpriseType" type="{http://im.yahooapis.jp/V201806/PromotionalAccount}EnterpriseType" minOccurs="0"/>
 *         &lt;element name="enterpriseTypePosition" type="{http://im.yahooapis.jp/V201806/PromotionalAccount}EnterpriseTypePosition" minOccurs="0"/>
 *         &lt;element name="zip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prefectureCode" type="{http://im.yahooapis.jp/V201806/PromotionalAccount}PrefectureCode" minOccurs="0"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="street1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="street2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="building" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urlType" type="{http://im.yahooapis.jp/V201806/PromotionalAccount}UrlType" minOccurs="0"/>
 *         &lt;element name="clientPersonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Client", propOrder = {
    "companyName",
    "companyNameKana",
    "enterpriseType",
    "enterpriseTypePosition",
    "zip",
    "prefectureCode",
    "city",
    "street1",
    "street2",
    "building",
    "phoneNumber",
    "url",
    "urlType",
    "clientPersonName"
})
public class Client {

    protected String companyName;
    protected String companyNameKana;
    @XmlSchemaType(name = "string")
    protected EnterpriseType enterpriseType;
    @XmlSchemaType(name = "string")
    protected EnterpriseTypePosition enterpriseTypePosition;
    protected String zip;
    @XmlSchemaType(name = "string")
    protected PrefectureCode prefectureCode;
    protected String city;
    protected String street1;
    protected String street2;
    protected String building;
    protected String phoneNumber;
    protected String url;
    @XmlSchemaType(name = "string")
    protected UrlType urlType;
    protected String clientPersonName;

    /**
     * Gets the value of the companyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the value of the companyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyName(String value) {
        this.companyName = value;
    }

    /**
     * Gets the value of the companyNameKana property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyNameKana() {
        return companyNameKana;
    }

    /**
     * Sets the value of the companyNameKana property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyNameKana(String value) {
        this.companyNameKana = value;
    }

    /**
     * Gets the value of the enterpriseType property.
     * 
     * @return
     *     possible object is
     *     {@link EnterpriseType }
     *     
     */
    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    /**
     * Sets the value of the enterpriseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnterpriseType }
     *     
     */
    public void setEnterpriseType(EnterpriseType value) {
        this.enterpriseType = value;
    }

    /**
     * Gets the value of the enterpriseTypePosition property.
     * 
     * @return
     *     possible object is
     *     {@link EnterpriseTypePosition }
     *     
     */
    public EnterpriseTypePosition getEnterpriseTypePosition() {
        return enterpriseTypePosition;
    }

    /**
     * Sets the value of the enterpriseTypePosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnterpriseTypePosition }
     *     
     */
    public void setEnterpriseTypePosition(EnterpriseTypePosition value) {
        this.enterpriseTypePosition = value;
    }

    /**
     * Gets the value of the zip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the value of the zip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZip(String value) {
        this.zip = value;
    }

    /**
     * Gets the value of the prefectureCode property.
     * 
     * @return
     *     possible object is
     *     {@link PrefectureCode }
     *     
     */
    public PrefectureCode getPrefectureCode() {
        return prefectureCode;
    }

    /**
     * Sets the value of the prefectureCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrefectureCode }
     *     
     */
    public void setPrefectureCode(PrefectureCode value) {
        this.prefectureCode = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the street1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreet1() {
        return street1;
    }

    /**
     * Sets the value of the street1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreet1(String value) {
        this.street1 = value;
    }

    /**
     * Gets the value of the street2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreet2() {
        return street2;
    }

    /**
     * Sets the value of the street2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreet2(String value) {
        this.street2 = value;
    }

    /**
     * Gets the value of the building property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuilding() {
        return building;
    }

    /**
     * Sets the value of the building property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuilding(String value) {
        this.building = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the urlType property.
     * 
     * @return
     *     possible object is
     *     {@link UrlType }
     *     
     */
    public UrlType getUrlType() {
        return urlType;
    }

    /**
     * Sets the value of the urlType property.
     * 
     * @param value
     *     allowed object is
     *     {@link UrlType }
     *     
     */
    public void setUrlType(UrlType value) {
        this.urlType = value;
    }

    /**
     * Gets the value of the clientPersonName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientPersonName() {
        return clientPersonName;
    }

    /**
     * Sets the value of the clientPersonName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientPersonName(String value) {
        this.clientPersonName = value;
    }

}
