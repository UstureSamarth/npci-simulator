@XmlSchema(
        namespace = "http://npci.org/upi/schema/",
        xmlns = {
                @XmlNs(prefix = "ns3", namespaceURI = "http://npci.org/cm/schema/"),
                @XmlNs(prefix = "ns2", namespaceURI = "http://npci.org/upi/schema/")
        },
        elementFormDefault = XmlNsForm.UNQUALIFIED
)
package com.sarvatra.sim.npci.xml.pojo.request;


import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;