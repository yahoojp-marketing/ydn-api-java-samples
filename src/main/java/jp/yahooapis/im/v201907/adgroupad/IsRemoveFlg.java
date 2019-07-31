
package jp.yahooapis.im.v201907.adgroupad;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for isRemoveFlg.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="isRemoveFlg">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRUE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "isRemoveFlg")
@XmlEnum
public enum IsRemoveFlg {

    TRUE;

    public String value() {
        return name();
    }

    public static IsRemoveFlg fromValue(String v) {
        return valueOf(v);
    }

}
