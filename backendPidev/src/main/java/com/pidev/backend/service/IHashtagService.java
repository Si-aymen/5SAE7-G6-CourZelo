package com.pidev.backend.service;

import com.pidev.backend.entity.Hashtag;

import java.util.List;

public interface IHashtagService {
    public boolean ajouthashtag(Hashtag h);
    public void deletehashtag(String id);
    public List<Hashtag> affichethashtags();
}
