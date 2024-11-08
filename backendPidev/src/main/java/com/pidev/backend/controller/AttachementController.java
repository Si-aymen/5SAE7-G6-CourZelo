package com.pidev.backend.controller;

import com.pidev.backend.entity.Attachment;
import com.pidev.backend.service.AttachementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/attachements")
public class AttachementController {
    private final AttachementService atachementService;

    @GetMapping("/get_all")
    public List<Attachment> getAllAttachements() {
        return atachementService.getAllAttachements();
    }

    @GetMapping("/get/{id}")
    public Attachment getAttachementById(@PathVariable String id) {

        return atachementService.getAttachementById(id);
    }

    @PostMapping("/post")
    public Attachment createAttachement(@RequestBody Attachment attachment) {
        return atachementService.createAttachement(attachment);
    }

    @PutMapping("/put")
    public Attachment updateAttachement(@RequestBody Attachment attachment) {
        return atachementService.updateAttachement(attachment);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAttachement(@PathVariable String id) {
        atachementService.deleteAttachement(id);
    }

    @DeleteMapping("/delete_all")
    public void deleteAllAttachement() {
        atachementService.deleteAllAttachements();
    }

}
