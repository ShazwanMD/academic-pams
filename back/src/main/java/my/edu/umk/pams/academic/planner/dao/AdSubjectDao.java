package my.edu.umk.pams.academic.planner.dao;

import java.util.List;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdUser;

import my.edu.umk.pams.academic.planner.model.AdCurriculum;
import my.edu.umk.pams.academic.planner.model.AdSubject;
import my.edu.umk.pams.academic.planner.model.AdSubjectType;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;

public interface AdSubjectDao extends GenericDao<Long, AdSubject> {
	
	
	 AdSubject findSubjectById(Long id);
	    
	 AdSubject findSubjects();
	    
	 AdSubject findSubjectsByCurriculum(AdCurriculum curriculum);

	 List<AdSubject> find(AdCurriculum curriculum);

	 List<AdSubject> findSubjects(AdSubjectType subjectType, AdCurriculum curriculum);
	void addSubject(AdCurriculum curriculum, AdSubject subject, AdUser user);

    void updateSubject(AdCurriculum Curriculum, AdSubject subject, AdUser user);
    
   
}
