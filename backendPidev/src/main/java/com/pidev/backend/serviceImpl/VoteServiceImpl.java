package com.pidev.backend.serviceImpl;

import com.pidev.backend.entity.Question;

import com.pidev.backend.repository.QuestionRepository;
import com.pidev.backend.repository.UserRepository;
import com.pidev.backend.repository.VoteRepository;
import com.pidev.backend.service.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements IVoteService {
    @Autowired
    UserRepository userrepo;
    @Autowired
    VoteRepository voterepo;
    @Autowired
    QuestionRepository questionrepo;

    @Override
    public int nbvotebyquest(String idq) {
        Question ques =questionrepo.findById(idq).orElse(null);

        if (ques != null && ques.getVotes() != null) {
            return ques.getVotes().size();
        }
        return  0;
    }





}
