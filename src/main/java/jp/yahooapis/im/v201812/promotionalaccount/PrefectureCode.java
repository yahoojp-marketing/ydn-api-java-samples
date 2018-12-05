
package jp.yahooapis.im.v201812.promotionalaccount;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrefectureCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PrefectureCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HOKKAIDO"/>
 *     &lt;enumeration value="AOMORI"/>
 *     &lt;enumeration value="IWATE"/>
 *     &lt;enumeration value="MIYAGI"/>
 *     &lt;enumeration value="AKITA"/>
 *     &lt;enumeration value="YAMAGATA"/>
 *     &lt;enumeration value="FUKUSHIMA"/>
 *     &lt;enumeration value="IBARAKI"/>
 *     &lt;enumeration value="TOCHIGI"/>
 *     &lt;enumeration value="GUNMA"/>
 *     &lt;enumeration value="SAITAMA"/>
 *     &lt;enumeration value="CHIBA"/>
 *     &lt;enumeration value="TOKYO"/>
 *     &lt;enumeration value="KANAGAWA"/>
 *     &lt;enumeration value="NIIGATA"/>
 *     &lt;enumeration value="TOYAMA"/>
 *     &lt;enumeration value="ISHIKAWA"/>
 *     &lt;enumeration value="FUKUI"/>
 *     &lt;enumeration value="YAMANASHI"/>
 *     &lt;enumeration value="NAGANO"/>
 *     &lt;enumeration value="GIFU"/>
 *     &lt;enumeration value="SHIZUOKA"/>
 *     &lt;enumeration value="AICHI"/>
 *     &lt;enumeration value="MIE"/>
 *     &lt;enumeration value="SIGA"/>
 *     &lt;enumeration value="KYOTO"/>
 *     &lt;enumeration value="OSAKA"/>
 *     &lt;enumeration value="HYOGO"/>
 *     &lt;enumeration value="NARA"/>
 *     &lt;enumeration value="WAKAYAMA"/>
 *     &lt;enumeration value="TOTTORI"/>
 *     &lt;enumeration value="SHIMANE"/>
 *     &lt;enumeration value="OKAYAMA"/>
 *     &lt;enumeration value="HIROSHIMA"/>
 *     &lt;enumeration value="YAMAGUCHI"/>
 *     &lt;enumeration value="TOKUSHIMA"/>
 *     &lt;enumeration value="KAGAWA"/>
 *     &lt;enumeration value="EHIME"/>
 *     &lt;enumeration value="KOCHI"/>
 *     &lt;enumeration value="FUKUOKA"/>
 *     &lt;enumeration value="SAGA"/>
 *     &lt;enumeration value="NAGASAKI"/>
 *     &lt;enumeration value="KUMAMOTO"/>
 *     &lt;enumeration value="OITA"/>
 *     &lt;enumeration value="MIYAZAKI"/>
 *     &lt;enumeration value="KAGOSHIMA"/>
 *     &lt;enumeration value="OKINAWA"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PrefectureCode")
@XmlEnum
public enum PrefectureCode {

    HOKKAIDO,
    AOMORI,
    IWATE,
    MIYAGI,
    AKITA,
    YAMAGATA,
    FUKUSHIMA,
    IBARAKI,
    TOCHIGI,
    GUNMA,
    SAITAMA,
    CHIBA,
    TOKYO,
    KANAGAWA,
    NIIGATA,
    TOYAMA,
    ISHIKAWA,
    FUKUI,
    YAMANASHI,
    NAGANO,
    GIFU,
    SHIZUOKA,
    AICHI,
    MIE,
    SIGA,
    KYOTO,
    OSAKA,
    HYOGO,
    NARA,
    WAKAYAMA,
    TOTTORI,
    SHIMANE,
    OKAYAMA,
    HIROSHIMA,
    YAMAGUCHI,
    TOKUSHIMA,
    KAGAWA,
    EHIME,
    KOCHI,
    FUKUOKA,
    SAGA,
    NAGASAKI,
    KUMAMOTO,
    OITA,
    MIYAZAKI,
    KAGOSHIMA,
    OKINAWA,
    NONE;

    public String value() {
        return name();
    }

    public static PrefectureCode fromValue(String v) {
        return valueOf(v);
    }

}
