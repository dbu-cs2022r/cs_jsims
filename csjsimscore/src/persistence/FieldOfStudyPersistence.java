/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import domain.FieldOfStudy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ChalewT
 */
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

}
