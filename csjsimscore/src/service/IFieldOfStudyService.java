/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domain.FieldOfStudy;
import java.sql.SQLException;

/**
 *
 * @author ChalewT
 */
public interface IFieldOfStudyService {

    boolean register(FieldOfStudy FieldOfStudy) throws SQLException;
}
