package persistence;

import domain.FieldOfStudy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FieldOfStudyPersistence implements IFieldOfStudyPersistence {

    @Override
    public boolean save(FieldOfStudy fieldOfStudy) throws SQLException {
        int affectedRow;
        String query = "Insert into FieldOfStudy(name, departmentid) values(?,?)";
        try (Connection conn = DbConnection.getConnection()) {
            try (PreparedStatement prepare = conn.prepareStatement(query)) {
                prepare.setString(1, fieldOfStudy.getName());
                prepare.setInt(2, fieldOfStudy.getDepartmentId());
                affectedRow = prepare.executeUpdate();
            }
        }
        return affectedRow > 0;
    }

    @Override
    public List<FieldOfStudy> getByDepartmentId(int departmentId) throws Exception {
        List<FieldOfStudy> fieldOfStudies = new ArrayList<FieldOfStudy>();
        String query = "Select * from FieldOfStudy where departmentid=? Order By name ASC";
        Connection conn = DbConnection.getConnection();
        PreparedStatement prepare = conn.prepareStatement(query);
        prepare.setInt(1, departmentId);
        ResultSet rslt = prepare.executeQuery();
        while (rslt.next()) {
            FieldOfStudy fieldOfStudy = new FieldOfStudy();
            fieldOfStudy.setId(rslt.getInt("id"));
            fieldOfStudy.setName(rslt.getString("name"));
            fieldOfStudy.setDepartmentId(rslt.getInt("collegeid"));
            fieldOfStudies.add(fieldOfStudy);
        }
        return fieldOfStudies;
    }

}
