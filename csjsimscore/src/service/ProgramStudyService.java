package service;

import dataobject.ProgramStudyDO;
import domain.ProgramStudy;
import java.util.List;
import persistence.IProgramStudyPersistence;

/**
 *
 * @author ChalewT
 */
public class ProgramStudyService implements IProgramStudyService {

    private final IProgramStudyPersistence programStudyPersistence;

    public ProgramStudyService(IProgramStudyPersistence programStudyPersistence) {
        this.programStudyPersistence = programStudyPersistence;
    }

    @Override
    public boolean addProgramStudy(ProgramStudy programStudy) throws Exception {
        return programStudyPersistence.addProgramStudy(programStudy);
    }

    @Override
    public List<ProgramStudyDO> getByFieldOfStudyId(int fieldOfStudyId) throws Exception {
        return programStudyPersistence.getByFieldOfStudyId(fieldOfStudyId);
    }

}
