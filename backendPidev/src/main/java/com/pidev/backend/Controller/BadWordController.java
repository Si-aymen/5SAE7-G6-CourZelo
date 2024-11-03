package com.pidev.backend.controller;

import com.pidev.backend.entity.SignalBadword;
import com.pidev.backend.serviceImpl.SignalBadWordServImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",exposedHeaders="Access-Control-Allow-Origin" )
@RestController
@RequestMapping("/badword")
public class BadWordController {
    private final SignalBadWordServImpl sbwserv;
    public BadWordController(SignalBadWordServImpl sbwserv) {
        this.sbwserv = sbwserv;
    }
    @GetMapping("/get-badword")
    public List<SignalBadword> getBAdword() {
        return sbwserv.afficheBadword();

    }
}
