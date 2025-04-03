/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import domain.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ChalewT
 */
public class DepartmentPersistence implements IDepartmentPersistence {

    @Override
    public boolean save(Department department) throws SQLException {
        int affectedRow;
        String query = "Insert into department (name, collegeid) Values(?,?)";
        try (Connection conn = DbConnection.getConnection()) {
            try (PreparedStatement prepare = conn.prepareStatement(query)) {
                prepare.setString(1, department.getName());
                prepare.setInt(2, department.getCollegeId());
                affectedRow = prepare.executeUpdate();
            }
        }
        return affectedRow > 0;
    }

}
