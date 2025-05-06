package persistence;

import domain.ProgramAward;

public interface IProgramAwardRepository {

    public boolean addProgramAward(ProgramAward programAward) throws Exception;

}
