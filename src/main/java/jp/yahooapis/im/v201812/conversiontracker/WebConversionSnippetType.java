
package jp.yahooapis.im.v201812.conversiontracker;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WebConversionSnippetType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WebConversionSnippetType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IMG"/>
 *     &lt;enumeration value="JS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WebConversionSnippetType")
@XmlEnum
public enum WebConversionSnippetType {

    IMG,
    JS;

    public String value() {
        return name();
    }

    public static WebConversionSnippetType fromValue(String v) {
        return valueOf(v);
    }

}
