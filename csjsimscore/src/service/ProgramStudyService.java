package service;

import domain.ProgramStudy;
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

}
