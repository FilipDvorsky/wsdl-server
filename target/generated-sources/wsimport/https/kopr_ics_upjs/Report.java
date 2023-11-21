
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
 *         &lt;element name="reportText" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "reportText"
})
@XmlRootElement(name = "report")
public class Report {

    @XmlElement(required = true)
    protected String reportText;

    /**
     * Gets the value of the reportText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportText() {
        return reportText;
    }

    /**
     * Sets the value of the reportText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportText(String value) {
        this.reportText = value;
    }

}
