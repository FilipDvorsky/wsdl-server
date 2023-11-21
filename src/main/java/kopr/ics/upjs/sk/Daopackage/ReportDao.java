package kopr.ics.upjs.sk.Daopackage;

import java.sql.*;
import java.util.ArrayList;

public enum ReportDao{

    INSTANCE;
    class Tuple {
        public int a, b;
    }
    private String url = "jdbc:sqlite:mydb.db";
    private ArrayList<String> list = new ArrayList<String>();



    public void createNewTable() {
        String sql = "CREATE TABLE IF NOT EXISTS hospital ( id INTEGER PRIMARY KEY AUTOINCREMENT, personid integer NOT NULL, dateidentifier text NOT NULL, report text);";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void fillData(){

        insert(1,"2023-11-10T09:00:00","Pacient 1 je ok :)");
        insert(1,"2023-11-10T09:30:00","Pacient 1 je stale OK");
        insert(1,"2023-11-10T11:00:00","Po treti raz je Pacient ok");
        insert(2,"2023-11-11T10:30:00","Novy pacient 2 urcite nieje chory.");
        insert(2,"2023-11-11T12:00:00","Pacient 2 je mozno chory.");
        insert(3,"2023-11-14T13:30:00","Novy pacient 3 ma nadchu.");
        insert(2,"2023-11-15T09:45:00","Pacient 2 je urcite chory.");
        insert(3,"2023-11-15T12:00:00","Pacient 3 stale nie je chory");
        insert(4,"2023-11-16T13:00:00","Novy pacient 4 ");
        insert(5,"2023-11-17T10:00:00","Dna 2023-11-17T10:00:00 prisiel novy pacient cislo 5 a nieje chory");
        insert(6,"2023-11-18T11:30:00","6 Je ok ");
        insert(7,"2023-11-22T11:00:00","7 nieje ok :(");


    }
    public void insert(int personid, String dateidentifier, String report) {
        String sql = "INSERT INTO hospital(personid, dateidentifier, report) VALUES(?,?,?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, personid);
            pstmt.setString(2, dateidentifier);
            pstmt.setString(3, report);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public String getReportByPersonDate(int PersonId, String dateIdentifier)  {
        String sql = "SELECT report FROM hospital WHERE dateidentifier = ? AND personid = ?";
        String output = "";

        if (PersonId <= 0 && dateIdentifier == null){
            output = "Wrong. PersonId and DateIdentifier format.";
        }else if (dateIdentifier == null || dateIdentifier.length()<19){
            output = "Wrong. DateIdentifier format.";
        }else if (PersonId <= 0 ) {
            output = "Wrong. PersonId format.";
        } else {
            try (Connection conn = DriverManager.getConnection(url);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                String ldt = dateIdentifier.substring(0, 19);
                pstmt.setString(1, ldt);
                pstmt.setInt(2, PersonId);

                ResultSet rs = pstmt.executeQuery();

                output = rs.getString("report");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());;
                output = "Report not in DB.";
            }
        }
        if (output == null){
            output= "Wrong. Report not in DB.";
        }
        return output;
    }
}

