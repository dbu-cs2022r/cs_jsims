package service;

import domain.ProgramAdmission;
import persistence.IProgramAdmissionPersistence;

public class ProgramAdmissionService implements IProgramAdmissionService {

    private final IProgramAdmissionPersistence programAdmissionPersistence;

    public ProgramAdmissionService(IProgramAdmissionPersistence programAdmissionPersistence) {
        this.programAdmissionPersistence = programAdmissionPersistence;
    }
    
    @Override
    public boolean addProgramAdmission(ProgramAdmission programAdmission) throws Exception {
         return programAdmissionPersistence.addProgramAdmission(programAdmission);
    }
    
}
