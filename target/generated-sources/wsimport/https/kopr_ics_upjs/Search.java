
package https.kopr_ics_upjs;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="dateIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "personId",
    "dateIdentifier"
})
@XmlRootElement(name = "search")
public class Search {

    protected int personId;
    @XmlElement(required = true)
    protected String dateIdentifier;

    /**
     * Gets the value of the personId property.
     * 
     */
    public int getPersonId() {
        return personId;
    }

    /**
     * Sets the value of the personId property.
     * 
     */
    public void setPersonId(int value) {
        this.personId = value;
    }

    /**
     * Gets the value of the dateIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateIdentifier() {
        return dateIdentifier;
    }

    /**
     * Sets the value of the dateIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateIdentifier(String value) {
        this.dateIdentifier = value;
    }

}
