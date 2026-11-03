package com.sarvatra.sim.npci.xml.util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.StringReader;
import java.io.StringWriter;

import static com.sarvatra.sim.npci.xml.util.JAXBContextConstants.JAXB_CONTEXT_MAP;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NPCIXmlUtil {

    public static <T> T unmarshal(String xml, Class<T> clazz) throws JAXBException {
        JAXBContext context = JAXB_CONTEXT_MAP.get(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            return clazz.cast(unmarshaller.unmarshal(reader));
        }
    }

    public static <T> String toXmlString(T object) throws JAXBException {
        JAXBContext context = JAXB_CONTEXT_MAP.get(object.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter writer = new StringWriter();
        marshaller.marshal(object, writer);
        return writer.toString();
    }
}
