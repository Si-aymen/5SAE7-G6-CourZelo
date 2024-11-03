package com.pidev.backend.serviceImpl;

import com.pidev.backend.entity.Hashtag;
import com.pidev.backend.repository.HashtagRepository;
import com.pidev.backend.service.IHashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HAshtagServiceImpl implements IHashtagService {

    @Autowired
    HashtagRepository hashrepo;
    @Override
    public boolean ajouthashtag(Hashtag hashtag) {
//contrainte non duplication
            for(Hashtag h:hashrepo.findAll()){
                if(h.getTechnologie().equals(hashtag.getTechnologie())) {
                    return false;
                }
            }
        hashrepo.save(hashtag);
        return true;
    }

    @Override
    public void deletehashtag(String id) {
            hashrepo.deleteById(id);
    }

    @Override
    public List<Hashtag> affichethashtags() {
        return hashrepo.findAll();
    }
}
