
package jp.yahooapis.im.v201907.conversiontracker;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WebConversion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WebConversion">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201907/ConversionTracker}ConversionTracker">
 *       &lt;sequence>
 *         &lt;element name="snippet" type="{http://im.yahooapis.jp/V201907/ConversionTracker}WebConversionSnippet" maxOccurs="2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WebConversion", propOrder = {
    "snippet"
})
public class WebConversion
    extends ConversionTracker
{

    protected List<WebConversionSnippet> snippet;

    /**
     * Gets the value of the snippet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the snippet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSnippet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WebConversionSnippet }
     * 
     * 
     */
    public List<WebConversionSnippet> getSnippet() {
        if (snippet == null) {
            snippet = new ArrayList<WebConversionSnippet>();
        }
        return this.snippet;
    }

}
