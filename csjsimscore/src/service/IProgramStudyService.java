package service;

import dataobject.ProgramStudyDO;
import domain.ProgramStudy;
import java.util.List;

/**
 *
 * @author ChalewT
 */
public interface IProgramStudyService {

    public boolean addProgramStudy(ProgramStudy programStudy) throws Exception;

    List<ProgramStudyDO> getByFieldOfStudyId(int fieldOfStudyId) throws Exception;
}
