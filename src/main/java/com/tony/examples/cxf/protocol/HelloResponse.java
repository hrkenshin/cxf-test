
package com.tony.examples.cxf.protocol;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{}AbstractResponseType">
 *       &lt;sequence>
 *         &lt;element name="hello" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="today" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "hello",
    "today"
})
@XmlRootElement(name = "HelloResponse")
public class HelloResponse
    extends AbstractResponseType
    implements Serializable
{

    private final static Long serialVersionUID = -6026937020915831338L;
    @XmlElement(required = true)
    @NotNull
    protected String hello;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    @NotNull
    protected Date today;

    /**
     * Gets the value of the hello property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHello() {
        return hello;
    }

    /**
     * Sets the value of the hello property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHello(String value) {
        this.hello = value;
    }

    /**
     * Gets the value of the today property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getToday() {
        return today;
    }

    /**
     * Sets the value of the today property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToday(Date value) {
        this.today = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.MULTI_LINE_STYLE);
    }

}
