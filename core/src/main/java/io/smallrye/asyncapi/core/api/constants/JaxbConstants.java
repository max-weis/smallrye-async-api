package io.smallrye.asyncapi.core.api.constants;

import org.jboss.jandex.DotName;

/**
 * Constants related to the JAXB Specification
 */
public class JaxbConstants {

    public static final DotName XML_TYPE = DotName.createSimple("javax.xml.bind.annotation.XmlType");

    public static final DotName XML_ELEMENT = DotName.createSimple("javax.xml.bind.annotation.XmlElement");

    public static final DotName XML_ATTRIBUTE = DotName.createSimple("javax.xml.bind.annotation.XmlAttribute");

    public static final String PROP_NAME = "name";

    private JaxbConstants() {
    }
}
