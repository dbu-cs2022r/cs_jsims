/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domain.FieldOfStudy;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ChalewT
 */
public interface IFieldOfStudyService {

    boolean register(FieldOfStudy FieldOfStudy) throws SQLException;
     List<FieldOfStudy> getByDepartmentId(int departmentId) throws Exception;
}
