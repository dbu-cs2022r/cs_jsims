package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

import domain.ProgramAward;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProgramAwardPersistence implements IProgramAwardPersistence {

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
        List<ProgramAward> awards = new ArrayList<ProgramAward>();
        String sql = "Select * from ProgramAward Order By name ASC";
        try (Connection conn = DbConnection.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                ResultSet rslt = stmt.executeQuery();
                while (rslt.next()) {
                    ProgramAward award = new ProgramAward();
                    award.setId(rslt.getInt("id"));
                    award.setName(rslt.getString("name"));
                    awards.add(award);
                }
            }
        }
        return awards;
    }

}
