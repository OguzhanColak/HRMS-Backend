package main.hrms.business.abstracts;

import main.hrms.entities.concretes.JobSeeker;

public interface JobSeekerCheckService {
	
	void checkFirstName(JobSeeker jobSeeker);

	void checkLastName(JobSeeker jobSeeker);

	void checkNationalityId(JobSeeker jobSeeker);

	void checkBirthYear(JobSeeker jobSeeker);

	void checkEmail(JobSeeker jobSeeker);

	void checkPassword(JobSeeker jobSeeker);

	void checkRepeatPassword(JobSeeker jobSeeker);

	void uniqueEmail(JobSeeker jobSeeker);

	void uniqueNationalityId(JobSeeker jobseeker);
}
