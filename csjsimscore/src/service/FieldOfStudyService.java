/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.FieldOfStudy;
import java.sql.SQLException;
import java.util.List;
import persistence.IFieldOfStudyPersistence;

/**
 *
 * @author ChalewT
 */
public class FieldOfStudyService implements IFieldOfStudyService {
    
    private final IFieldOfStudyPersistence fieldOfStudyPersistewnce;
    
    public FieldOfStudyService(IFieldOfStudyPersistence fieldOfStudyPersistewnce) {
        this.fieldOfStudyPersistewnce = fieldOfStudyPersistewnce;
    }
    
    @Override
    public boolean register(FieldOfStudy fieldOfStudy) throws SQLException {
        return fieldOfStudyPersistewnce.save(fieldOfStudy);
    }
    
    @Override
    public List<FieldOfStudy> getByDepartmentId(int departmentId) throws Exception {
        return fieldOfStudyPersistewnce.getByDepartmentId(departmentId);
    }
    
}
