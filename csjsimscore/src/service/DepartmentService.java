/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Department;
import java.sql.SQLException;
import java.util.List;
import persistence.DepartmentPersistence;
import persistence.IDepartmentPersistence;

/**
 *
 * @author ChalewT
 */
public class DepartmentService implements IDepartmentService {

    private final IDepartmentPersistence departmentPersistance = new DepartmentPersistence();

    @Override
    public boolean register(Department department) throws SQLException {
        return departmentPersistance.save(department);
    }

    @Override
    public List<Department> getByCollegeId(int collegeId) throws SQLException {
        throw new UnsupportedOperationException("Not implemented yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
