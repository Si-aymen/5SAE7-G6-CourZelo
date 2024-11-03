package com.pidev.backend.controller;

import com.pidev.backend.entity.Chapter;
import com.pidev.backend.service.ChapterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", exposedHeaders = "Access-Control-Allow-Origin")
@RestController
@AllArgsConstructor
@RequestMapping("/chapters")
public class ChapterController {
    private final ChapterService chapterService;


    @PostMapping("/add-chapter")
    public Chapter addChapter(@RequestBody Chapter c) {
        return chapterService.addChapter(c);
    }

    @GetMapping("/retrieve-chapters")
    public List<Chapter> getAllChapters() {
        return chapterService.getAllChapters();
    }

    @PutMapping("/modify-chapter")
    public Chapter modifyChapter(@RequestBody Chapter c) {
        return chapterService.modifyChapter(c);
    }

    @DeleteMapping("/delete-chapter/{chapter-id}")
    public void deleteChapter(@PathVariable("chapter-id") String chapterId) {
        chapterService.deleteChapter(chapterId);
    }

    @PutMapping ("/assign-chapters/{course-id}")
    public void assignChaptersToCourse (@RequestBody List<Chapter> chapterList , @PathVariable("course-id") String id){
        chapterService.assignChapterToCourse(chapterList,id);
    }


    @GetMapping("/Course/{CourseId}")
    public List<Chapter> getChaptersByCourse(@PathVariable String CourseId) {
        List<Chapter> chapterList = chapterService.GetChapterByCourse(CourseId);
        return  chapterList ;
    }




}
