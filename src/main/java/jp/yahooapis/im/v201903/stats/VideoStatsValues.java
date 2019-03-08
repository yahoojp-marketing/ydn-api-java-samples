
package jp.yahooapis.im.v201903.stats;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VideoStatsValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VideoStatsValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201903/Stats}StatsValues">
 *       &lt;sequence>
 *         &lt;element name="mediaId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="videoName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="videoTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stats" type="{http://im.yahooapis.jp/V201903/Stats}Stats" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VideoStatsValues", propOrder = {
    "mediaId",
    "videoName",
    "videoTitle",
    "stats"
})
public class VideoStatsValues
    extends StatsValues
{

    protected Long mediaId;
    protected String videoName;
    protected String videoTitle;
    protected Stats stats;

    /**
     * Gets the value of the mediaId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMediaId() {
        return mediaId;
    }

    /**
     * Sets the value of the mediaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMediaId(Long value) {
        this.mediaId = value;
    }

    /**
     * Gets the value of the videoName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVideoName() {
        return videoName;
    }

    /**
     * Sets the value of the videoName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVideoName(String value) {
        this.videoName = value;
    }

    /**
     * Gets the value of the videoTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVideoTitle() {
        return videoTitle;
    }

    /**
     * Sets the value of the videoTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVideoTitle(String value) {
        this.videoTitle = value;
    }

    /**
     * Gets the value of the stats property.
     * 
     * @return
     *     possible object is
     *     {@link Stats }
     *     
     */
    public Stats getStats() {
        return stats;
    }

    /**
     * Sets the value of the stats property.
     * 
     * @param value
     *     allowed object is
     *     {@link Stats }
     *     
     */
    public void setStats(Stats value) {
        this.stats = value;
    }

}
