package service;

import domain.ProgramAward;
import java.util.List;
import persistence.IProgramAwardPersistence;

public class ProgramAwardService implements IProgramAwardService {

    private final IProgramAwardPersistence programAwardRepository;

    public ProgramAwardService(IProgramAwardPersistence programAwardRepository) {
        this.programAwardRepository = programAwardRepository;
    }

    @Override
    public boolean addProgramAward(ProgramAward programAward) throws Exception {
        return programAwardRepository.addProgramAward(programAward);
    }

    @Override
    public boolean updateProgramAward(int id, String name) throws Exception {
        // Implement the update logic here
        return false;
    }

    @Override
    public List<ProgramAward> getProgramAwards() throws Exception {
        return programAwardRepository.getProgramAwards();
    }
}
