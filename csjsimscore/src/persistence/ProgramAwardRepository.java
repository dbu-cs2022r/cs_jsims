package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

import domain.ProgramAward;
import java.util.List;

public class ProgramAwardRepository implements IProgramAwardRepository {
    @Override
    public boolean addProgramAward(ProgramAward programAward) throws Exception {
       int affectedRow;
        String query = "Insert into ProgramAward(name) values(?)";
        try (Connection conn = DbConnection.getConnection()) {
            try (PreparedStatement prepare = conn.prepareStatement(query)) {
                prepare.setString(1, programAward.getName());
                affectedRow = prepare.executeUpdate();
            }
        }
        return affectedRow > 0;
    }

    @Override
    public List<ProgramAward> getProgramAwards() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
