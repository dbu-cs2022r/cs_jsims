package service;

import domain.ProgramAward;

public interface IProgramAwardService {
    public boolean addProgramAward(ProgramAward programAward) throws Exception;
    public boolean updateProgramAward(int id, String name) throws Exception;
}
