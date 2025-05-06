package service;

import domain.ProgramAward;
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
}
