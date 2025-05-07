package persistence;

import domain.Curriculum;

public interface ICurriculumPersistence {

    public boolean addCurriculum(Curriculum curriculum) throws Exception;
}
