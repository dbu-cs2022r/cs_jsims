package persistence;

import domain.ProgramStudy;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ChalewT
 */
public class ProgramStudyPersistence implements IProgramStudyPersistence {

    @Override
    public boolean addProgramStudy(ProgramStudy programStudy) throws Exception {
        int affectedRow;
        String query = "Insert into ProgramStudy(fieldofstudyid,programawardid,programadmissionid) values(?,?,?)";
        try (Connection conn = DbConnection.getConnection()) {
            try (PreparedStatement prepare = conn.prepareStatement(query)) {
                prepare.setInt(1, programStudy.getFieldOfStudyId());
                prepare.setInt(2, programStudy.getProgramAwardId());
                prepare.setInt(3, programStudy.getProgramAdmissionId());
                affectedRow = prepare.executeUpdate();
            }
        }
        return affectedRow > 0;
    }

}
