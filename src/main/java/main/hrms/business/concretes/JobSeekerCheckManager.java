package main.hrms.business.concretes;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.hrms.business.abstracts.JobSeekerCheckService;
import main.hrms.dataAccess.abstracts.JobSeekerDao;
import main.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerCheckManager implements JobSeekerCheckService {

	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public JobSeekerCheckManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public void checkFirstName(JobSeeker jobSeeker) {
		if (jobSeeker.getFirstName().isEmpty()) {
			System.out.println("İsim alanı boş bırakılamaz.");
			
		} else {
			if (jobSeeker.getFirstName().length() < 4) {
				System.out.println("İsim alanı 4 karakterden büyük olmalıdır.");
			
			}
		}
	
	}

	@Override
	public void checkLastName(JobSeeker jobSeeker) {
		if (jobSeeker.getLastName().isEmpty()) {
			System.out.println("Soyisim alanı boş bırakılamaz.");
			
		} else {
			if (jobSeeker.getLastName().length() < 4) {
				System.out.println("Soyisim alanı 4 karakterden büyük olmalıdır.");
				
			}
		}
		
	}

	@Override
	public void checkNationalityId(JobSeeker jobSeeker) {
		if (jobSeeker.getNationalityId().isEmpty()) {
			System.out.println("Vatandaşlık kimlik numarası alanı boş bırakılamaz.");
			
		} else {
			if (jobSeeker.getNationalityId().length() < 11 || jobSeeker.getNationalityId().length() > 11) {
				System.out.println("Vatandaşlık kimlik numarası 11 karakter olmalıdır.");
				
			}
		}
		
	}

	@Override
	public void checkBirthYear(JobSeeker jobSeeker) {
		if (jobSeeker.getBirthYear() > 1930 && jobSeeker.getBirthYear() < 2021) {
			
		} else {
			System.out.println("1930 - 2021 aralığında tarih giriniz.");
			
		}

	}

	@Override
	public void checkEmail(JobSeeker jobSeeker) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		if (jobSeeker.getEmail().isEmpty()) {
			System.out.println("Email alanı boş bırakılamaz.");
		
		} else {
			if (pattern.matcher(jobSeeker.getEmail()).find() == false) {
				System.out.println("Girilen email adresi formata uygun değil. Örnek: ornek@ornek.com");
				
			}
		}
		
	}

	@Override
	public void checkPassword(JobSeeker jobSeeker) {
		if (jobSeeker.getPassword().isEmpty()) {
			System.out.println("Soyisim alanı boş bırakılamaz.");
			
		} else {
			if (jobSeeker.getPassword().length() < 6) {
				System.out.println("Parola 6 karakterden daha küçük olamaz.");
				
			}
		}
		
	}

	@Override
	public void checkRepeatPassword(JobSeeker jobSeeker) {
		if (jobSeeker.getPasswordCheck().isEmpty()) {
			
		} else {
			if (jobSeeker.getPassword() == jobSeeker.getPasswordCheck()) {
				
			}
		}	
		
	}
	
	@Override
	public void uniqueEmail(JobSeeker jobseeker) {
		if (jobSeekerDao.findByEmail(jobseeker.getEmail()) != null) {
			
		}
		
	}

	@Override
	public void uniqueNationalityId(JobSeeker jobseeker) {
		if (jobSeekerDao.findByEmail(jobseeker.getNationalityId()) != null) {
			
		}
		
	}
	

}
