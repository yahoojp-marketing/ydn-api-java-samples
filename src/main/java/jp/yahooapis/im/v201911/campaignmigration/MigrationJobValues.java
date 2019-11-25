
package jp.yahooapis.im.v201911.campaignmigration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.im.v201911.ReturnValue;


/**
 * <p>Java class for MigrationJobValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MigrationJobValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V201911}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="migrationJob" type="{http://im.yahooapis.jp/V201911/CampaignMigration}MigrationJob" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MigrationJobValues", propOrder = {
    "migrationJob"
})
public class MigrationJobValues
    extends ReturnValue
{

    protected MigrationJob migrationJob;

    /**
     * Gets the value of the migrationJob property.
     * 
     * @return
     *     possible object is
     *     {@link MigrationJob }
     *     
     */
    public MigrationJob getMigrationJob() {
        return migrationJob;
    }

    /**
     * Sets the value of the migrationJob property.
     * 
     * @param value
     *     allowed object is
     *     {@link MigrationJob }
     *     
     */
    public void setMigrationJob(MigrationJob value) {
        this.migrationJob = value;
    }

}
