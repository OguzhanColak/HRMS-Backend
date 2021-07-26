package main.hrms.business.abstracts;

import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.entities.concretes.CvPrgSkills;

import java.util.List;

public interface CvPrgSkillsService {
    public Result addSkill(CvPrgSkills cvPrgSkills);
    public Result removeSkill(int skillId);
    public DataResult<List<CvPrgSkills>> getByCvId(int cvId);
}