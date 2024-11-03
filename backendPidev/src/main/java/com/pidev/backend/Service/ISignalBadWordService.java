package com.pidev.backend.service;

import com.pidev.backend.entity.SignalBadword;

import java.util.List;

public interface ISignalBadWordService {
    //public SignalBadword ajouterbadword(String idq,String idu,String s);
    public List<SignalBadword> afficheBadword();
}
