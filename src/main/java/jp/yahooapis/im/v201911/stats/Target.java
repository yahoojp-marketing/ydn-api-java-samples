
package jp.yahooapis.im.v201911.stats;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Target complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Target">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://im.yahooapis.jp/V201911/Stats}TargetType"/>
 *         &lt;element name="targetSetting" type="{http://im.yahooapis.jp/V201911/Stats}TargetSetting" minOccurs="0"/>
 *         &lt;element name="targetId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Target", propOrder = {
    "type",
    "targetSetting",
    "targetId"
})
@XmlSeeAlso({
    DeviceTarget.class,
    PlacementTarget.class,
    AdScheduleTarget.class,
    SearchTarget.class,
    GenderTarget.class,
    AgeTarget.class,
    OsVersionTarget.class,
    AudienceCategoryTarget.class,
    GeoTarget.class,
    InterestCategoryTarget.class,
    CarrierTarget.class,
    AppTarget.class,
    SiteCategoryTarget.class,
    OsTarget.class,
    SiteRetargetingTarget.class
})
public class Target {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TargetType type;
    @XmlSchemaType(name = "string")
    protected TargetSetting targetSetting;
    protected String targetId;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link TargetType }
     *     
     */
    public TargetType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetType }
     *     
     */
    public void setType(TargetType value) {
        this.type = value;
    }

    /**
     * Gets the value of the targetSetting property.
     * 
     * @return
     *     possible object is
     *     {@link TargetSetting }
     *     
     */
    public TargetSetting getTargetSetting() {
        return targetSetting;
    }

    /**
     * Sets the value of the targetSetting property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetSetting }
     *     
     */
    public void setTargetSetting(TargetSetting value) {
        this.targetSetting = value;
    }

    /**
     * Gets the value of the targetId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetId() {
        return targetId;
    }

    /**
     * Sets the value of the targetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetId(String value) {
        this.targetId = value;
    }

}
