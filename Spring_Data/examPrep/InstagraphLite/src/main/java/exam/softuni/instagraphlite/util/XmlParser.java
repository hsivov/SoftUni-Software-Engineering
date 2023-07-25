package exam.softuni.instagraphlite.util;

import jakarta.xml.bind.JAXBException;

public interface XmlParser {
    <T> T fromFile(String filePath, Class<T> tClass) throws JAXBException, JAXBException;
}
