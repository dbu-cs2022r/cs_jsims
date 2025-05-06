
package persistence;

import domain.ProgramAdmission;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
