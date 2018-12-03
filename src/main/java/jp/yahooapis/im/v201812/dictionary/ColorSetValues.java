
package jp.yahooapis.im.v201812.dictionary;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201812.ReturnValue;


/**
 * <p>Java class for ColorSetValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ColorSetValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201812}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="colorSetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="colorSet" type="{http://im.yahooapis.jp/V201812/Dictionary}ColorSet" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ColorSetValues", propOrder = {
    "colorSetId",
    "name",
    "colorSet"
})
public class ColorSetValues
    extends ReturnValue
{

    protected Long colorSetId;
    protected String name;
    protected List<ColorSet> colorSet;

    /**
     * Gets the value of the colorSetId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getColorSetId() {
        return colorSetId;
    }

    /**
     * Sets the value of the colorSetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setColorSetId(Long value) {
        this.colorSetId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the colorSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the colorSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColorSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColorSet }
     * 
     * 
     */
    public List<ColorSet> getColorSet() {
        if (colorSet == null) {
            colorSet = new ArrayList<ColorSet>();
        }
        return this.colorSet;
    }

}
