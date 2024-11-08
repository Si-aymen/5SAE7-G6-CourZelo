package com.pidev.backend.service;

import com.pidev.backend.entity.Vote;

public interface IVoteService {
   //public Vote ajoutdeletevote(Vote v, String idu , String idq);
    public int nbvotebyquest(String idq);

}
