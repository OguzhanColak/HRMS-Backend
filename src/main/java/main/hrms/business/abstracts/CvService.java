package main.hrms.business.abstracts;

import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.entities.concretes.Cv;

import java.util.List;

public interface CvService {
    public Result add(int employeeId);
    public Result addCv(Cv cv);
    public DataResult<List<Cv>> getAll();

    public DataResult<Cv> getByCvId(int cvId);
    public DataResult<Cv> getByEmployeeId(int employeeId);

    public Result updateGithub(String githublink, int cvId);
    public Result deleteGithub(int cvId);

    public Result updateLinkedin(String linkedinlink, int cvId);
    public Result deleteLinkedin(int cvId);

    public Result updateBiography(String biography, int cvId);
    public Result deleteBiography(int cvId);
}
