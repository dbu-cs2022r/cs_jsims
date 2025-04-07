/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domain.Department;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ChalewT
 */
public interface IDepartmentService {

    boolean register(Department department) throws SQLException;

    List<Department> getByCollegeId(int collegeId) throws SQLException;
}
