
package com.copel.sm.solman;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de DT_SM_CriarChamados_Leg_Resp complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="DT_SM_CriarChamados_Leg_Resp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DATA" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="HORA" type="{http://www.w3.org/2001/XMLSchema}time" minOccurs="0"/>
 *         &lt;element name="ID_RETORNO" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="6"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MSG_RETORNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NOTIFICADOR_RETORNO" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="32"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OBJECT_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PRAZO_RESPOSTA" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DT_SM_CriarChamados_Leg_Resp", propOrder = {
    "data",
    "hora",
    "idretorno",
    "msgretorno",
    "notificadorretorno",
    "objectid",
    "prazoresposta"
})
public class DTSMCriarChamadosLegResp {

    @XmlElement(name = "DATA")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar data;
    @XmlElement(name = "HORA")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar hora;
    @XmlElement(name = "ID_RETORNO")
    protected String idretorno;
    @XmlElement(name = "MSG_RETORNO")
    protected String msgretorno;
    @XmlElement(name = "NOTIFICADOR_RETORNO")
    protected String notificadorretorno;
    @XmlElement(name = "OBJECT_ID")
    protected String objectid;
    @XmlElement(name = "PRAZO_RESPOSTA")
    protected BigInteger prazoresposta;

    /**
     * Obt�m o valor da propriedade data.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDATA() {
        return data;
    }

    /**
     * Define o valor da propriedade data.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDATA(XMLGregorianCalendar value) {
        this.data = value;
    }

    /**
     * Obt�m o valor da propriedade hora.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getHORA() {
        return hora;
    }

    /**
     * Define o valor da propriedade hora.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setHORA(XMLGregorianCalendar value) {
        this.hora = value;
    }

    /**
     * Obt�m o valor da propriedade idretorno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDRETORNO() {
        return idretorno;
    }

    /**
     * Define o valor da propriedade idretorno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDRETORNO(String value) {
        this.idretorno = value;
    }

    /**
     * Obt�m o valor da propriedade msgretorno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGRETORNO() {
        return msgretorno;
    }

    /**
     * Define o valor da propriedade msgretorno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGRETORNO(String value) {
        this.msgretorno = value;
    }

    /**
     * Obt�m o valor da propriedade notificadorretorno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOTIFICADORRETORNO() {
        return notificadorretorno;
    }

    /**
     * Define o valor da propriedade notificadorretorno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOTIFICADORRETORNO(String value) {
        this.notificadorretorno = value;
    }

    /**
     * Obt�m o valor da propriedade objectid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOBJECTID() {
        return objectid;
    }

    /**
     * Define o valor da propriedade objectid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOBJECTID(String value) {
        this.objectid = value;
    }

    /**
     * Obt�m o valor da propriedade prazoresposta.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPRAZORESPOSTA() {
        return prazoresposta;
    }

    /**
     * Define o valor da propriedade prazoresposta.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPRAZORESPOSTA(BigInteger value) {
        this.prazoresposta = value;
    }

}
