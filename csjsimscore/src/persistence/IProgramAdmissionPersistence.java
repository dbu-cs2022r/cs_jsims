package persistence;

import domain.ProgramAdmission;
import java.util.List;

public interface IProgramAdmissionPersistence {

    public boolean addProgramAdmission(ProgramAdmission programAdmission) throws Exception;
    List<ProgramAdmission> getProgramAdmissions() throws Exception;
}
