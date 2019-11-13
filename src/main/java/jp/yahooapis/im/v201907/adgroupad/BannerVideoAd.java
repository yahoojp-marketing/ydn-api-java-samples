
package jp.yahooapis.im.v201907.adgroupad;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BannerVideoAd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BannerVideoAd">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201907/AdGroupAd}Ad">
 *       &lt;sequence>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="displayUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="thumbnailMediaId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="videoStartBeaconUrls" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isRemoveVideoStartBeaconUrls" type="{http://im.yahooapis.jp/V201907/AdGroupAd}isRemoveFlg" minOccurs="0"/>
 *         &lt;element name="video3SecBeaconUrls" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isRemoveVideo3SecBeaconUrls" type="{http://im.yahooapis.jp/V201907/AdGroupAd}isRemoveFlg" minOccurs="0"/>
 *         &lt;element name="videoPaidBeaconUrls" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isRemoveVideoPaidBeaconUrls" type="{http://im.yahooapis.jp/V201907/AdGroupAd}isRemoveFlg" minOccurs="0"/>
 *         &lt;element name="videoCompleteBeaconUrls" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isRemoveVideoCompleteBeaconUrls" type="{http://im.yahooapis.jp/V201907/AdGroupAd}isRemoveFlg" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BannerVideoAd", propOrder = {
    "url",
    "displayUrl",
    "thumbnailMediaId",
    "videoStartBeaconUrls",
    "isRemoveVideoStartBeaconUrls",
    "video3SecBeaconUrls",
    "isRemoveVideo3SecBeaconUrls",
    "videoPaidBeaconUrls",
    "isRemoveVideoPaidBeaconUrls",
    "videoCompleteBeaconUrls",
    "isRemoveVideoCompleteBeaconUrls"
})
public class BannerVideoAd
    extends Ad
{

    protected String url;
    protected String displayUrl;
    protected Long thumbnailMediaId;
    protected List<String> videoStartBeaconUrls;
    @XmlSchemaType(name = "string")
    protected IsRemoveFlg isRemoveVideoStartBeaconUrls;
    protected List<String> video3SecBeaconUrls;
    @XmlSchemaType(name = "string")
    protected IsRemoveFlg isRemoveVideo3SecBeaconUrls;
    protected List<String> videoPaidBeaconUrls;
    @XmlSchemaType(name = "string")
    protected IsRemoveFlg isRemoveVideoPaidBeaconUrls;
    protected List<String> videoCompleteBeaconUrls;
    @XmlSchemaType(name = "string")
    protected IsRemoveFlg isRemoveVideoCompleteBeaconUrls;

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the displayUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayUrl() {
        return displayUrl;
    }

    /**
     * Sets the value of the displayUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayUrl(String value) {
        this.displayUrl = value;
    }

    /**
     * Gets the value of the thumbnailMediaId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getThumbnailMediaId() {
        return thumbnailMediaId;
    }

    /**
     * Sets the value of the thumbnailMediaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setThumbnailMediaId(Long value) {
        this.thumbnailMediaId = value;
    }

    /**
     * Gets the value of the videoStartBeaconUrls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the videoStartBeaconUrls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVideoStartBeaconUrls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVideoStartBeaconUrls() {
        if (videoStartBeaconUrls == null) {
            videoStartBeaconUrls = new ArrayList<String>();
        }
        return this.videoStartBeaconUrls;
    }

    /**
     * Gets the value of the isRemoveVideoStartBeaconUrls property.
     * 
     * @return
     *     possible object is
     *     {@link IsRemoveFlg }
     *     
     */
    public IsRemoveFlg getIsRemoveVideoStartBeaconUrls() {
        return isRemoveVideoStartBeaconUrls;
    }

    /**
     * Sets the value of the isRemoveVideoStartBeaconUrls property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsRemoveFlg }
     *     
     */
    public void setIsRemoveVideoStartBeaconUrls(IsRemoveFlg value) {
        this.isRemoveVideoStartBeaconUrls = value;
    }

    /**
     * Gets the value of the video3SecBeaconUrls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the video3SecBeaconUrls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVideo3SecBeaconUrls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVideo3SecBeaconUrls() {
        if (video3SecBeaconUrls == null) {
            video3SecBeaconUrls = new ArrayList<String>();
        }
        return this.video3SecBeaconUrls;
    }

    /**
     * Gets the value of the isRemoveVideo3SecBeaconUrls property.
     * 
     * @return
     *     possible object is
     *     {@link IsRemoveFlg }
     *     
     */
    public IsRemoveFlg getIsRemoveVideo3SecBeaconUrls() {
        return isRemoveVideo3SecBeaconUrls;
    }

    /**
     * Sets the value of the isRemoveVideo3SecBeaconUrls property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsRemoveFlg }
     *     
     */
    public void setIsRemoveVideo3SecBeaconUrls(IsRemoveFlg value) {
        this.isRemoveVideo3SecBeaconUrls = value;
    }

    /**
     * Gets the value of the videoPaidBeaconUrls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the videoPaidBeaconUrls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVideoPaidBeaconUrls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVideoPaidBeaconUrls() {
        if (videoPaidBeaconUrls == null) {
            videoPaidBeaconUrls = new ArrayList<String>();
        }
        return this.videoPaidBeaconUrls;
    }

    /**
     * Gets the value of the isRemoveVideoPaidBeaconUrls property.
     * 
     * @return
     *     possible object is
     *     {@link IsRemoveFlg }
     *     
     */
    public IsRemoveFlg getIsRemoveVideoPaidBeaconUrls() {
        return isRemoveVideoPaidBeaconUrls;
    }

    /**
     * Sets the value of the isRemoveVideoPaidBeaconUrls property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsRemoveFlg }
     *     
     */
    public void setIsRemoveVideoPaidBeaconUrls(IsRemoveFlg value) {
        this.isRemoveVideoPaidBeaconUrls = value;
    }

    /**
     * Gets the value of the videoCompleteBeaconUrls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the videoCompleteBeaconUrls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVideoCompleteBeaconUrls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVideoCompleteBeaconUrls() {
        if (videoCompleteBeaconUrls == null) {
            videoCompleteBeaconUrls = new ArrayList<String>();
        }
        return this.videoCompleteBeaconUrls;
    }

    /**
     * Gets the value of the isRemoveVideoCompleteBeaconUrls property.
     * 
     * @return
     *     possible object is
     *     {@link IsRemoveFlg }
     *     
     */
    public IsRemoveFlg getIsRemoveVideoCompleteBeaconUrls() {
        return isRemoveVideoCompleteBeaconUrls;
    }

    /**
     * Sets the value of the isRemoveVideoCompleteBeaconUrls property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsRemoveFlg }
     *     
     */
    public void setIsRemoveVideoCompleteBeaconUrls(IsRemoveFlg value) {
        this.isRemoveVideoCompleteBeaconUrls = value;
    }

}