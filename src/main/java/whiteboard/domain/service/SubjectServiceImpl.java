package whiteboard.domain.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whiteboard.data.SubjectDao;
import whiteboard.domain.model.Subject;

import javax.transaction.Transactional;
import java.util.List;

@Service("subjectService")
@Transactional
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public List<Subject> getSubjects() {
        return subjectDao.getSubjects();
    }

    @Override
    public void addSubject(Subject subject) {
        subjectDao.save(subject);
    }

    @Override
    public Subject findBySubjectCode(String code) {
        Subject subject = subjectDao.findBySubjectCode(code);
        //logger.info("size: " + subject.getContents().size());
        // here, it works! see explanation https://stackoverflow.com/a/42206232
        return subject;
    }

    private static final Logger logger = LogManager.getLogger(SubjectServiceImpl.class);
}