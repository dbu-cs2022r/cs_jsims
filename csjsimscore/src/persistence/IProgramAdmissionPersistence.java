package persistence;

import domain.ProgramAdmission;

public interface IProgramAdmissionPersistence {

    public boolean addProgramAdmission(ProgramAdmission programAdmission) throws Exception;
}
