/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistence;

import domain.Department;
import java.sql.SQLException;

/**
 *
 * @author ChalewT
 */
public interface IDepartmentPersistence {
    boolean save(Department department)throws SQLException ;
}
