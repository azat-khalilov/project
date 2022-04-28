package com.company.applicationforcbrf.service;

import com.company.applicationforcbrf.xtable.Xtable;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParserService {
    private final DataFileService dataFileService;
    private final ContentFileService contentFileService;


    public ParserService(DataFileService dataFileService, ContentFileService contentFileService) {
        this.dataFileService = dataFileService;
        this.contentFileService = contentFileService;
    }

    public List<Xtable> parseToXtableList() {
        List<Xtable> result = new ArrayList<>();
        List<String> rows = dataFileService.readTable();
        for (String row : rows) {
            if (row != null) {
                String[] elements = row.split("\\|");
                try {
                    Xtable xtable = new Xtable(elements[0],
                            elements[1],
                            elements[2],
                            elements[3],
                            elements[4],
                            elements[5],
                            elements[6],
                            elements[7],
                            elements[8],
                            elements[9],
                            elements[10]);
                    int length = Integer.parseInt(elements[9].replace("#", ""));
                    int offset = Integer.parseInt(elements[10].replace("#", ""));
                    String xmlString = contentFileService.read(offset, length);
                    DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    Document document = documentBuilder.parse(new ByteArrayInputStream(xmlString.getBytes()));
                    String bic = document.getDocumentElement().getFirstChild().getAttributes().getNamedItem("BIC").getNodeValue();
                    String data1 = document.getDocumentElement().getFirstChild().getAttributes().getNamedItem("Data1").getNodeValue();
                    String name = document.getDocumentElement().getFirstChild().getFirstChild().getAttributes().getNamedItem("Name").getNodeValue();
                    xtable.setBic(bic);
                    xtable.setData1(data1);
                    xtable.setName(name);
                    result.add(xtable);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
