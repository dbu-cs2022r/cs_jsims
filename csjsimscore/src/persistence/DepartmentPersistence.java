package persistence;

import domain.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Department> getByCollegeId(int collegeId) throws SQLException {
        List<Department> departments = new ArrayList<Department>();
        String query = "Select * from department where collegeid=? Order By name ASC";
        Connection conn = DbConnection.getConnection();
        PreparedStatement prepare = conn.prepareStatement(query);
        prepare.setInt(1, collegeId);
        ResultSet rslt = prepare.executeQuery();
        while (rslt.next()) {
            Department department = new Department();
            department.setId(rslt.getInt("id"));
            department.setName(rslt.getString("name"));
            department.setCollegeId(rslt.getInt("collegeid"));
            departments.add(department);
        }
        return departments;
    }

}
