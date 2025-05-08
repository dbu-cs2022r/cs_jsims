package service;

import domain.College;
import java.sql.SQLException;
import java.util.List;

public interface ICollegeService {
     boolean register(College college)throws SQLException;

    List<College> getAll()throws SQLException;
}
