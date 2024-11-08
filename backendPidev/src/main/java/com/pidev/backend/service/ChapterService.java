package com.pidev.backend.service;

import com.pidev.backend.entity.Chapter;

import java.util.List;

public interface ChapterService {

    Chapter addChapter (Chapter chapter);
    List<Chapter> getAllChapters();
    Chapter modifyChapter (Chapter chapter);
    public void deleteChapter(String chapterId);
    public void assignChapterToCourse (List<Chapter> chapterList  , String idCourse);
    public List<Chapter> GetChapterByCourse(String classroomId);

}
