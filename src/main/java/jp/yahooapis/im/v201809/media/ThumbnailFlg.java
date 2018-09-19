
package jp.yahooapis.im.v201809.media;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ThumbnailFlg.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ThumbnailFlg">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FALSE"/>
 *     &lt;enumeration value="TRUE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ThumbnailFlg")
@XmlEnum
public enum ThumbnailFlg {

    FALSE,
    TRUE;

    public String value() {
        return name();
    }

    public static ThumbnailFlg fromValue(String v) {
        return valueOf(v);
    }

}
