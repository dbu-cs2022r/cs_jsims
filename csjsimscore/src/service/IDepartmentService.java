/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domain.Department;
import java.sql.SQLException;

/**
 *
 * @author ChalewT
 */
public interface IDepartmentService {
    boolean register(Department department)throws SQLException;
}
