
package jp.yahooapis.im.v201809.video;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VideoSetting complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VideoSetting">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="videoFileType" type="{http://im.yahooapis.jp/V201809/Video}VideoFileType" minOccurs="0"/>
 *         &lt;element name="videoAdFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fileSize" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="playbackTime" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="downloadOriginalUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="downloadHighBitrateUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="downloadMiddleBitrateUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="downloadLowBitrateUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VideoSetting", propOrder = {
    "videoFileType",
    "videoAdFormat",
    "fileSize",
    "width",
    "height",
    "playbackTime",
    "downloadOriginalUrl",
    "downloadHighBitrateUrl",
    "downloadMiddleBitrateUrl",
    "downloadLowBitrateUrl"
})
public class VideoSetting {

    @XmlSchemaType(name = "string")
    protected VideoFileType videoFileType;
    protected String videoAdFormat;
    protected Long fileSize;
    protected Long width;
    protected Long height;
    protected Long playbackTime;
    protected String downloadOriginalUrl;
    protected String downloadHighBitrateUrl;
    protected String downloadMiddleBitrateUrl;
    protected String downloadLowBitrateUrl;

    /**
     * Gets the value of the videoFileType property.
     * 
     * @return
     *     possible object is
     *     {@link VideoFileType }
     *     
     */
    public VideoFileType getVideoFileType() {
        return videoFileType;
    }

    /**
     * Sets the value of the videoFileType property.
     * 
     * @param value
     *     allowed object is
     *     {@link VideoFileType }
     *     
     */
    public void setVideoFileType(VideoFileType value) {
        this.videoFileType = value;
    }

    /**
     * Gets the value of the videoAdFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVideoAdFormat() {
        return videoAdFormat;
    }

    /**
     * Sets the value of the videoAdFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVideoAdFormat(String value) {
        this.videoAdFormat = value;
    }

    /**
     * Gets the value of the fileSize property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * Sets the value of the fileSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFileSize(Long value) {
        this.fileSize = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setWidth(Long value) {
        this.width = value;
    }

    /**
     * Gets the value of the height property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHeight(Long value) {
        this.height = value;
    }

    /**
     * Gets the value of the playbackTime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPlaybackTime() {
        return playbackTime;
    }

    /**
     * Sets the value of the playbackTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPlaybackTime(Long value) {
        this.playbackTime = value;
    }

    /**
     * Gets the value of the downloadOriginalUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadOriginalUrl() {
        return downloadOriginalUrl;
    }

    /**
     * Sets the value of the downloadOriginalUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadOriginalUrl(String value) {
        this.downloadOriginalUrl = value;
    }

    /**
     * Gets the value of the downloadHighBitrateUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadHighBitrateUrl() {
        return downloadHighBitrateUrl;
    }

    /**
     * Sets the value of the downloadHighBitrateUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadHighBitrateUrl(String value) {
        this.downloadHighBitrateUrl = value;
    }

    /**
     * Gets the value of the downloadMiddleBitrateUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadMiddleBitrateUrl() {
        return downloadMiddleBitrateUrl;
    }

    /**
     * Sets the value of the downloadMiddleBitrateUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadMiddleBitrateUrl(String value) {
        this.downloadMiddleBitrateUrl = value;
    }

    /**
     * Gets the value of the downloadLowBitrateUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadLowBitrateUrl() {
        return downloadLowBitrateUrl;
    }

    /**
     * Sets the value of the downloadLowBitrateUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadLowBitrateUrl(String value) {
        this.downloadLowBitrateUrl = value;
    }

}
