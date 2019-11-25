
package jp.yahooapis.im.v201911.feedftp;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ItemListUploadType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ItemListUploadType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UPDATE_PART"/>
 *     &lt;enumeration value="UPDATE_ALL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ItemListUploadType")
@XmlEnum
public enum ItemListUploadType {

    UPDATE_PART,
    UPDATE_ALL;

    public String value() {
        return name();
    }

    public static ItemListUploadType fromValue(String v) {
        return valueOf(v);
    }

}
