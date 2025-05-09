/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domain.ProgramAdmission;
import java.util.List;

/**
 *
 * @author ChalewT
 */
public interface IProgramAdmissionService {

    public boolean addProgramAdmission(ProgramAdmission programAdmission) throws Exception;

    List<ProgramAdmission> getProgramAdmissions() throws Exception;
}
