package main.hrms.business.abstracts;

import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.entities.concretes.CvImg;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CvImgService {
    DataResult<List<CvImg>> getAll();
    Result update(MultipartFile multipartFile,int cvId);
    Result delete(int id);
    DataResult<CvImg> getById(int id);
    Boolean isExist(int id);
}
