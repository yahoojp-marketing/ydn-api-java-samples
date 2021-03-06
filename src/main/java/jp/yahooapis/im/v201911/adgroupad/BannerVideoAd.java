
package jp.yahooapis.im.v201911.adgroupad;

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
 *     &lt;extension base="{http://im.yahooapis.jp/V201911/AdGroupAd}Ad">
 *       &lt;sequence>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="displayUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="thumbnailMediaId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="videoStartBeaconUrls" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isRemoveVideoStartBeaconUrls" type="{http://im.yahooapis.jp/V201911/AdGroupAd}isRemoveFlg" minOccurs="0"/>
 *         &lt;element name="video3SecBeaconUrls" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isRemoveVideo3SecBeaconUrls" type="{http://im.yahooapis.jp/V201911/AdGroupAd}isRemoveFlg" minOccurs="0"/>
 *         &lt;element name="videoPaidBeaconUrls" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isRemoveVideoPaidBeaconUrls" type="{http://im.yahooapis.jp/V201911/AdGroupAd}isRemoveFlg" minOccurs="0"/>
 *         &lt;element name="videoCompleteBeaconUrls" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isRemoveVideoCompleteBeaconUrls" type="{http://im.yahooapis.jp/V201911/AdGroupAd}isRemoveFlg" minOccurs="0"/>
 *         &lt;element name="video25PercentBeaconUrls" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isRemoveVideo25PercentBeaconUrls" type="{http://im.yahooapis.jp/V201911/AdGroupAd}isRemoveFlg" minOccurs="0"/>
 *         &lt;element name="video50PercentBeaconUrls" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isRemoveVideo50PercentBeaconUrls" type="{http://im.yahooapis.jp/V201911/AdGroupAd}isRemoveFlg" minOccurs="0"/>
 *         &lt;element name="video75PercentBeaconUrls" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isRemoveVideo75PercentBeaconUrls" type="{http://im.yahooapis.jp/V201911/AdGroupAd}isRemoveFlg" minOccurs="0"/>
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
    "isRemoveVideoCompleteBeaconUrls",
    "video25PercentBeaconUrls",
    "isRemoveVideo25PercentBeaconUrls",
    "video50PercentBeaconUrls",
    "isRemoveVideo50PercentBeaconUrls",
    "video75PercentBeaconUrls",
    "isRemoveVideo75PercentBeaconUrls"
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
    protected List<String> video25PercentBeaconUrls;
    @XmlSchemaType(name = "string")
    protected IsRemoveFlg isRemoveVideo25PercentBeaconUrls;
    protected List<String> video50PercentBeaconUrls;
    @XmlSchemaType(name = "string")
    protected IsRemoveFlg isRemoveVideo50PercentBeaconUrls;
    protected List<String> video75PercentBeaconUrls;
    @XmlSchemaType(name = "string")
    protected IsRemoveFlg isRemoveVideo75PercentBeaconUrls;

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

    /**
     * Gets the value of the video25PercentBeaconUrls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the video25PercentBeaconUrls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVideo25PercentBeaconUrls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVideo25PercentBeaconUrls() {
        if (video25PercentBeaconUrls == null) {
            video25PercentBeaconUrls = new ArrayList<String>();
        }
        return this.video25PercentBeaconUrls;
    }

    /**
     * Gets the value of the isRemoveVideo25PercentBeaconUrls property.
     * 
     * @return
     *     possible object is
     *     {@link IsRemoveFlg }
     *     
     */
    public IsRemoveFlg getIsRemoveVideo25PercentBeaconUrls() {
        return isRemoveVideo25PercentBeaconUrls;
    }

    /**
     * Sets the value of the isRemoveVideo25PercentBeaconUrls property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsRemoveFlg }
     *     
     */
    public void setIsRemoveVideo25PercentBeaconUrls(IsRemoveFlg value) {
        this.isRemoveVideo25PercentBeaconUrls = value;
    }

    /**
     * Gets the value of the video50PercentBeaconUrls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the video50PercentBeaconUrls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVideo50PercentBeaconUrls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVideo50PercentBeaconUrls() {
        if (video50PercentBeaconUrls == null) {
            video50PercentBeaconUrls = new ArrayList<String>();
        }
        return this.video50PercentBeaconUrls;
    }

    /**
     * Gets the value of the isRemoveVideo50PercentBeaconUrls property.
     * 
     * @return
     *     possible object is
     *     {@link IsRemoveFlg }
     *     
     */
    public IsRemoveFlg getIsRemoveVideo50PercentBeaconUrls() {
        return isRemoveVideo50PercentBeaconUrls;
    }

    /**
     * Sets the value of the isRemoveVideo50PercentBeaconUrls property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsRemoveFlg }
     *     
     */
    public void setIsRemoveVideo50PercentBeaconUrls(IsRemoveFlg value) {
        this.isRemoveVideo50PercentBeaconUrls = value;
    }

    /**
     * Gets the value of the video75PercentBeaconUrls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the video75PercentBeaconUrls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVideo75PercentBeaconUrls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVideo75PercentBeaconUrls() {
        if (video75PercentBeaconUrls == null) {
            video75PercentBeaconUrls = new ArrayList<String>();
        }
        return this.video75PercentBeaconUrls;
    }

    /**
     * Gets the value of the isRemoveVideo75PercentBeaconUrls property.
     * 
     * @return
     *     possible object is
     *     {@link IsRemoveFlg }
     *     
     */
    public IsRemoveFlg getIsRemoveVideo75PercentBeaconUrls() {
        return isRemoveVideo75PercentBeaconUrls;
    }

    /**
     * Sets the value of the isRemoveVideo75PercentBeaconUrls property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsRemoveFlg }
     *     
     */
    public void setIsRemoveVideo75PercentBeaconUrls(IsRemoveFlg value) {
        this.isRemoveVideo75PercentBeaconUrls = value;
    }

}
