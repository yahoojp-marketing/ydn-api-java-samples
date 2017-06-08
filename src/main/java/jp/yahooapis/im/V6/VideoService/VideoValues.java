
package jp.yahooapis.im.V6.VideoService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VideoValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VideoValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V6}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="video" type="{http://im.yahooapis.jp/V6}Video" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VideoValues", propOrder = {
    "video"
})
public class VideoValues
    extends ReturnValue
{

    protected Video video;

    /**
     * Gets the value of the video property.
     * 
     * @return
     *     possible object is
     *     {@link Video }
     *     
     */
    public Video getVideo() {
        return video;
    }

    /**
     * Sets the value of the video property.
     * 
     * @param value
     *     allowed object is
     *     {@link Video }
     *     
     */
    public void setVideo(Video value) {
        this.video = value;
    }

}
