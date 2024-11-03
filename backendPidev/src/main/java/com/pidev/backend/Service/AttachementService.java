package com.pidev.backend.service;

import com.pidev.backend.entity.Attachment;

import java.io.IOException;
import java.util.List;

public interface AttachementService {
        List<Attachment> getAllAttachements();
        Attachment getAttachementById(String reclamationID);
        Attachment createAttachement(Attachment reclamation);
        Attachment updateAttachement(Attachment reclamation);
        void deleteAttachement(String id);
        void deleteAllAttachements();

        public String base64Encode(String imagePath) throws IOException;
        public String saveImage(String base64, String extension);
}
