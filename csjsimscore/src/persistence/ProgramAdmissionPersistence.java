package persistence;

import domain.ProgramAdmission;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProgramAdmissionPersistence implements IProgramAdmissionPersistence {

    @Override
    public boolean addProgramAdmission(ProgramAdmission programAdmission) throws Exception {
        int affectedRow;
        String query = "Insert into ProgramAdmission(name) values(?)";
        try (Connection conn = DbConnection.getConnection()) {
            try (PreparedStatement prepare = conn.prepareStatement(query)) {
                prepare.setString(1, programAdmission.getName());
                affectedRow = prepare.executeUpdate();
            }
        }
        return affectedRow > 0;
    }

    @Override
    public List<ProgramAdmission> getProgramAdmissions() throws Exception {
        List<ProgramAdmission> admissions = new ArrayList<ProgramAdmission>();
        String sql = "Select * from ProgramAdmission Order By name ASC";
        try (Connection conn = DbConnection.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                ResultSet rslt = stmt.executeQuery();
                while (rslt.next()) {
                    ProgramAdmission admission = new ProgramAdmission();
                    admission.setId(rslt.getInt("id"));
                    admission.setName(rslt.getString("name"));
                    admissions.add(admission);
                }
            }
        }
        return admissions;
    }

}
