package main.hrms.core.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService {

    Cloudinary cloudinary;
    private Map<String,String> valuesMap=new HashMap<>();

    public CloudinaryService(){
        valuesMap.put("cloud_name","dkyzgi4rz" );
        valuesMap.put("api_key", "772795118981167" );
        valuesMap.put("api_secret","_o9pGKKIMv-9TD4JiSsBQB7tw3I" );
        cloudinary=new Cloudinary(valuesMap);
    }

    public Map<String,String> upload(MultipartFile multipartFile) throws IOException{
        File file= convert(multipartFile);
        Map<String,String> result=cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return result;
    }

    public Map<String,String> delete(String id) throws IOException{
        Map<String,String> result= cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
        return result;
    }

    public File convert(MultipartFile multipartFile) throws IOException {
        File file=new File(multipartFile.getOriginalFilename());
        FileOutputStream stream=new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();
        return file;
    }
}
