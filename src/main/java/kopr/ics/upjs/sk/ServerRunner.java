package kopr.ics.upjs.sk;

import jakarta.xml.ws.Endpoint;
import kopr.ics.upjs.sk.Daopackage.ReportDao;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ServerRunner {
    public static void main(String[] args) {

        List<Source> metadata = new ArrayList<>();

        var wsdlSource = new StreamSource(DefaultVisitReportPort.class.getResourceAsStream("/hippokrates.wsdl"));
        wsdlSource.setSystemId("https://kopr.ics.upjs.sk/hippokrates.wsdl");
        metadata.add(wsdlSource);

        var xsdSource = new StreamSource(DefaultVisitReportPort.class.getResourceAsStream("/hippokrates.xsd"));
        xsdSource.setSystemId("https://kopr.ics.upjs.sk/hippokrates.xsd");
        metadata.add(xsdSource);

        var filter = new HashMap<String, Object>();
        filter.put(Endpoint.WSDL_SERVICE, new QName("https://kopr.ics.upjs.sk", "visitReportService"));
        filter.put(Endpoint.WSDL_PORT, new QName("https://kopr.ics.upjs.sk", "visitReportPort"));

        var endpoint = Endpoint.create(new DefaultVisitReportPort());
        endpoint.setProperties(filter);
        endpoint.setMetadata(metadata);

        File f = new File("./mydb.db");
        if (!f.exists()){
            ReportDao reportDao = ReportDao.INSTANCE;
            reportDao.createNewTable();
            reportDao.fillData();
        }
        //ReportDao reportDao = new ReportDao();
        //reportDao.createNewTable();
        //reportDao.fillData();

        System.out.println("Service uteka");

        endpoint.publish("http://localhost:8080/hospital");

    }


}
