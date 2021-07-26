package main.hrms.business.abstracts;

import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.entities.concretes.CvSchool;

import java.util.List;

public interface CvSchoolService {
    public Result addSchool(CvSchool cvSchool);
    public Result deleteSchool(int schoolId);
    public DataResult<List<CvSchool>> getByCvId(int cvId);
}
