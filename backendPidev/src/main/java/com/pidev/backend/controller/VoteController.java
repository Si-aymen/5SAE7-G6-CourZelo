package com.pidev.backend.controller;

import com.pidev.backend.entity.Vote;

import com.pidev.backend.serviceImpl.VoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200",exposedHeaders="Access-Control-Allow-Origin" )
@RestController
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    VoteServiceImpl voteserv;


    @GetMapping("/nbr-vote/{id-question}")
    @ResponseBody
    public int ajoutdeletevote( @PathVariable("id-question") String idq) {
         return voteserv.nbvotebyquest(idq);

    }
}
