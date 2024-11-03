package com.pidev.backend.serviceImpl;

import com.pidev.backend.entity.SignalBadword;
import com.pidev.backend.repository.SignaBAdWordRepository;
import com.pidev.backend.service.ISignalBadWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignalBadWordServImpl implements ISignalBadWordService {
    @Autowired
    SignaBAdWordRepository sbwrepo;
    @Autowired
    QuestionServiceImpl questrepo;
    @Autowired
    UserServiceImpl userrpo;
    @Autowired
    ReponseServiceImpl reponserepo;



    @Override
    public List<SignalBadword> afficheBadword() {
        return sbwrepo.findAll();
    }
}
