package service;

import domain.ProgramAward;
import java.util.List;

public interface IProgramAwardService {

    public boolean addProgramAward(ProgramAward programAward) throws Exception;

    public boolean updateProgramAward(int id, String name) throws Exception;

    List<ProgramAward> getProgramAwards() throws Exception;
}
