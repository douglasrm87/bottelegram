
package com.copel.sm.solman;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.copel.sm.criarchamados_4800_sm_sync_soap_rfc package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MTSMCriarChamadosLegResp_QNAME = new QName("urn:copel-com:sm:criarchamados_4800-sm_sync_soap-rfc", "MT_SM_CriarChamados_Leg_Resp");
    private final static QName _MTSMCriarChamadosLegReq_QNAME = new QName("urn:copel-com:sm:criarchamados_4800-sm_sync_soap-rfc", "MT_SM_CriarChamados_Leg_Req");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.copel.sm.criarchamados_4800_sm_sync_soap_rfc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DTSMCriarChamadosLegReq }
     * 
     */
    public DTSMCriarChamadosLegReq createDTSMCriarChamadosLegReq() {
        return new DTSMCriarChamadosLegReq();
    }

    /**
     * Create an instance of {@link DTSMCriarChamadosLegReq.ANEXOS }
     * 
     */
    public DTSMCriarChamadosLegReq.ANEXOS createDTSMCriarChamadosLegReqANEXOS() {
        return new DTSMCriarChamadosLegReq.ANEXOS();
    }

    /**
     * Create an instance of {@link DTSMCriarChamadosLegResp }
     * 
     */
    public DTSMCriarChamadosLegResp createDTSMCriarChamadosLegResp() {
        return new DTSMCriarChamadosLegResp();
    }

    /**
     * Create an instance of {@link DTSMCriarChamadosLegReq.ANEXOS.Item }
     * 
     */
    public DTSMCriarChamadosLegReq.ANEXOS.Item createDTSMCriarChamadosLegReqANEXOSItem() {
        return new DTSMCriarChamadosLegReq.ANEXOS.Item();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DTSMCriarChamadosLegResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:copel-com:sm:criarchamados_4800-sm_sync_soap-rfc", name = "MT_SM_CriarChamados_Leg_Resp")
    public JAXBElement<DTSMCriarChamadosLegResp> createMTSMCriarChamadosLegResp(DTSMCriarChamadosLegResp value) {
        return new JAXBElement<DTSMCriarChamadosLegResp>(_MTSMCriarChamadosLegResp_QNAME, DTSMCriarChamadosLegResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DTSMCriarChamadosLegReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:copel-com:sm:criarchamados_4800-sm_sync_soap-rfc", name = "MT_SM_CriarChamados_Leg_Req")
    public JAXBElement<DTSMCriarChamadosLegReq> createMTSMCriarChamadosLegReq(DTSMCriarChamadosLegReq value) {
        return new JAXBElement<DTSMCriarChamadosLegReq>(_MTSMCriarChamadosLegReq_QNAME, DTSMCriarChamadosLegReq.class, null, value);
    }

}
