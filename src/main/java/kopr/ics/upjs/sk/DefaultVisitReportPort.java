package kopr.ics.upjs.sk;

import https.kopr_ics_upjs.VisitReportPortType;

import jakarta.jws.WebService;
import kopr.ics.upjs.sk.Daopackage.ReportDao;

import javax.xml.datatype.XMLGregorianCalendar;


@WebService(endpointInterface = "https.kopr_ics_upjs.VisitReportPortType")
public class DefaultVisitReportPort  implements VisitReportPortType {
    private ReportDao reportDao;


    DefaultVisitReportPort(){
        reportDao = ReportDao.INSTANCE;
    }

    @Override
    public String search(int personId, String dateIdentifier) {
        System.out.println(personId + " " + dateIdentifier);
        String reportFromVisit = "";

        reportDao = ReportDao.INSTANCE;
        reportFromVisit= reportDao.getReportByPersonDate(personId,dateIdentifier);
        System.out.println(personId+" "+reportFromVisit);

        return reportFromVisit;
    }
}
