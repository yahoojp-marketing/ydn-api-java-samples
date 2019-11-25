
package jp.yahooapis.im.v201911.feedftp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ScheduleWeekly complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ScheduleWeekly">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201911/FeedFtp}Schedule">
 *       &lt;sequence>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="week" type="{http://im.yahooapis.jp/V201911/FeedFtp}ScheduleWeek"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScheduleWeekly", propOrder = {
    "time",
    "week"
})
public class ScheduleWeekly
    extends Schedule
{

    protected int time;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ScheduleWeek week;

    /**
     * Gets the value of the time property.
     * 
     */
    public int getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     */
    public void setTime(int value) {
        this.time = value;
    }

    /**
     * Gets the value of the week property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleWeek }
     *     
     */
    public ScheduleWeek getWeek() {
        return week;
    }

    /**
     * Sets the value of the week property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleWeek }
     *     
     */
    public void setWeek(ScheduleWeek value) {
        this.week = value;
    }

}
