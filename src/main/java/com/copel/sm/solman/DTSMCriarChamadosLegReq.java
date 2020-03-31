
package com.copel.sm.solman;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de DT_SM_CriarChamados_Leg_Req complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="DT_SM_CriarChamados_Leg_Req">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="USUARIO">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="8"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SISTEMA">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="6"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ANEXOS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="NOME_ARQUIVO" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="255"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="TIPO_ARQUIVO" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="128"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="CONTEUDO_ARQ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CANAL_ENTRADA">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CATEGORIA">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="32"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DESCRICAO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NOTIFICADOR">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="32"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PATRIMONIO">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="11"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RESPONSAVEL">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="32"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SOLUCAO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TITULO_MENSAGEM">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DT_SM_CriarChamados_Leg_Req", propOrder = {
    "usuario",
    "sistema",
    "anexos",
    "canalentrada",
    "categoria",
    "descricao",
    "notificador",
    "patrimonio",
    "responsavel",
    "solucao",
    "titulomensagem"
})
public class DTSMCriarChamadosLegReq {

    @XmlElement(name = "USUARIO", required = true)
    protected String usuario;
    @XmlElement(name = "SISTEMA", required = true)
    protected String sistema;
    @XmlElement(name = "ANEXOS")
    protected DTSMCriarChamadosLegReq.ANEXOS anexos;
    @XmlElement(name = "CANAL_ENTRADA", required = true)
    protected String canalentrada;
    @XmlElement(name = "CATEGORIA", required = true)
    protected String categoria;
    @XmlElement(name = "DESCRICAO", required = true)
    protected String descricao;
    @XmlElement(name = "NOTIFICADOR", required = true)
    protected String notificador;
    @XmlElement(name = "PATRIMONIO", required = true)
    protected String patrimonio;
    @XmlElement(name = "RESPONSAVEL", required = true)
    protected String responsavel;
    @XmlElement(name = "SOLUCAO")
    protected String solucao;
    @XmlElement(name = "TITULO_MENSAGEM", required = true)
    protected String titulomensagem;

    /**
     * Obt�m o valor da propriedade usuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSUARIO() {
        return usuario;
    }

    /**
     * Define o valor da propriedade usuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSUARIO(String value) {
        this.usuario = value;
    }

    /**
     * Obt�m o valor da propriedade sistema.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSISTEMA() {
        return sistema;
    }

    /**
     * Define o valor da propriedade sistema.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSISTEMA(String value) {
        this.sistema = value;
    }

    /**
     * Obt�m o valor da propriedade anexos.
     * 
     * @return
     *     possible object is
     *     {@link DTSMCriarChamadosLegReq.ANEXOS }
     *     
     */
    public DTSMCriarChamadosLegReq.ANEXOS getANEXOS() {
        return anexos;
    }

    /**
     * Define o valor da propriedade anexos.
     * 
     * @param value
     *     allowed object is
     *     {@link DTSMCriarChamadosLegReq.ANEXOS }
     *     
     */
    public void setANEXOS(DTSMCriarChamadosLegReq.ANEXOS value) {
        this.anexos = value;
    }

    /**
     * Obt�m o valor da propriedade canalentrada.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCANALENTRADA() {
        return canalentrada;
    }

    /**
     * Define o valor da propriedade canalentrada.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCANALENTRADA(String value) {
        this.canalentrada = value;
    }

    /**
     * Obt�m o valor da propriedade categoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCATEGORIA() {
        return categoria;
    }

    /**
     * Define o valor da propriedade categoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCATEGORIA(String value) {
        this.categoria = value;
    }

    /**
     * Obt�m o valor da propriedade descricao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESCRICAO() {
        return descricao;
    }

    /**
     * Define o valor da propriedade descricao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDESCRICAO(String value) {
        this.descricao = value;
    }

    /**
     * Obt�m o valor da propriedade notificador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOTIFICADOR() {
        return notificador;
    }

    /**
     * Define o valor da propriedade notificador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOTIFICADOR(String value) {
        this.notificador = value;
    }

    /**
     * Obt�m o valor da propriedade patrimonio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPATRIMONIO() {
        return patrimonio;
    }

    /**
     * Define o valor da propriedade patrimonio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPATRIMONIO(String value) {
        this.patrimonio = value;
    }

    /**
     * Obt�m o valor da propriedade responsavel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESPONSAVEL() {
        return responsavel;
    }

    /**
     * Define o valor da propriedade responsavel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESPONSAVEL(String value) {
        this.responsavel = value;
    }

    /**
     * Obt�m o valor da propriedade solucao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSOLUCAO() {
        return solucao;
    }

    /**
     * Define o valor da propriedade solucao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSOLUCAO(String value) {
        this.solucao = value;
    }

    /**
     * Obt�m o valor da propriedade titulomensagem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTITULOMENSAGEM() {
        return titulomensagem;
    }

    /**
     * Define o valor da propriedade titulomensagem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTITULOMENSAGEM(String value) {
        this.titulomensagem = value;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="NOME_ARQUIVO" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="255"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="TIPO_ARQUIVO" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="128"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="CONTEUDO_ARQ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "item"
    })
    public static class ANEXOS {

        protected List<DTSMCriarChamadosLegReq.ANEXOS.Item> item;

        /**
         * Gets the value of the item property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DTSMCriarChamadosLegReq.ANEXOS.Item }
         * 
         * 
         */
        public List<DTSMCriarChamadosLegReq.ANEXOS.Item> getItem() {
            if (item == null) {
                item = new ArrayList<DTSMCriarChamadosLegReq.ANEXOS.Item>();
            }
            return this.item;
        }


        /**
         * <p>Classe Java de anonymous complex type.
         * 
         * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="NOME_ARQUIVO" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="255"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="TIPO_ARQUIVO" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="128"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="CONTEUDO_ARQ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "nomearquivo",
            "tipoarquivo",
            "conteudoarq"
        })
        public static class Item {

            @XmlElement(name = "NOME_ARQUIVO")
            protected String nomearquivo;
            @XmlElement(name = "TIPO_ARQUIVO")
            protected String tipoarquivo;
            @XmlElement(name = "CONTEUDO_ARQ")
            protected String conteudoarq;

            /**
             * Obt�m o valor da propriedade nomearquivo.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNOMEARQUIVO() {
                return nomearquivo;
            }

            /**
             * Define o valor da propriedade nomearquivo.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNOMEARQUIVO(String value) {
                this.nomearquivo = value;
            }

            /**
             * Obt�m o valor da propriedade tipoarquivo.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTIPOARQUIVO() {
                return tipoarquivo;
            }

            /**
             * Define o valor da propriedade tipoarquivo.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTIPOARQUIVO(String value) {
                this.tipoarquivo = value;
            }

            /**
             * Obt�m o valor da propriedade conteudoarq.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCONTEUDOARQ() {
                return conteudoarq;
            }

            /**
             * Define o valor da propriedade conteudoarq.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCONTEUDOARQ(String value) {
                this.conteudoarq = value;
            }

        }

    }

}
