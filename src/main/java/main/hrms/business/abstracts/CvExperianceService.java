package main.hrms.business.abstracts;

import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.entities.concretes.CvExperiance;

import java.util.List;

public interface CvExperianceService {
    Result add(CvExperiance cvExperiance);
    Result delete(int experianceId);
    DataResult<List<CvExperiance>> getByCvId(int id);
}