package service;

import domain.ProgramAward;
import persistence.IProgramAwardRepository;

public class ProgramAwardService implements IProgramAwardService {
    private final IProgramAwardRepository programAwardRepository;

    public ProgramAwardService(IProgramAwardRepository programAwardRepository) {
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
