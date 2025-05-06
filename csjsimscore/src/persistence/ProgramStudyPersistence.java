package persistence;

import dataobject.ProgramStudyDO;
import domain.ProgramStudy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<ProgramStudyDO> getByFieldOfStudyId(int fieldOfStudyId) throws Exception {
        List<ProgramStudyDO> programStudies = new ArrayList<ProgramStudyDO>();
        String query = "Select * from ProgramStudyView where fieldofstudyid=?";
        Connection conn = DbConnection.getConnection();
        PreparedStatement prepare = conn.prepareStatement(query);
        prepare.setInt(1, fieldOfStudyId);
        ResultSet rslt = prepare.executeQuery();
        while (rslt.next()) {
            ProgramStudyDO programStudy = new ProgramStudyDO();
            programStudy.setProgramStudyId(rslt.getInt("programstudyid"));
            programStudy.setFieldOfStudy(rslt.getString("fieldofstudy"));
            programStudy.setProgramAward(rslt.getString("programaward"));
            programStudy.setProgramAdmission(rslt.getString("programadmission"));
            programStudies.add(programStudy);
        }
        return programStudies;
    }

}
