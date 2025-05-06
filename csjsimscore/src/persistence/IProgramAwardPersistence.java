package persistence;

import domain.ProgramAward;
import java.util.List;

public interface IProgramAwardPersistence {

    public boolean addProgramAward(ProgramAward programAward) throws Exception;

    List<ProgramAward> getProgramAwards() throws Exception;
}
