package service;

import domain.Curriculum;
import persistence.ICurriculumPersistence;

/**
 *
 * @author ChalewT
 */
public class CurriculumService implements ICurriculumService {
    
    private final ICurriculumPersistence curriculumPersistence;
    
    public CurriculumService(ICurriculumPersistence curriculumPersistence) {
        this.curriculumPersistence = curriculumPersistence;
    }
    
    @Override
    public boolean addCurriculum(Curriculum curriculum) throws Exception {
        return curriculumPersistence.addCurriculum(curriculum);
    }
    
}
