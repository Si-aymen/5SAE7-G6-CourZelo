package com.pidev.backend.serviceImpl;

import com.pidev.backend.entity.Attachment;
import com.pidev.backend.entity.AttachmentType;
import com.pidev.backend.repository.AttachRepository;
import com.pidev.backend.service.AttachementService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Service
public class AttachmentServiceImpl implements AttachementService {
    @Autowired
    private AttachRepository attachRepository;
    @Override
    public List<Attachment> getAllAttachements() {
        return attachRepository.findAll();
    }

    @Override
    public Attachment getAttachementById(String id) {
        return attachRepository.findById(id).orElseGet(Attachment::Empty_);
    }

    @Override
    public Attachment createAttachement(Attachment attachment) {
        AttachmentType t = AttachmentType.FILE;
        String location="";
        switch(attachment.getType()) {
            case IMAGE:
                String data=attachment.getData();
                String base64Image = data.split(",")[1];
                String extension=data.split("/")[1].split(";")[0];
                location=this.saveImage(base64Image, extension);
                break;
        }

        attachment.setLocation(location);
        return attachRepository.save(attachment);
    }

    @Override
    public Attachment updateAttachement(Attachment attachment) {
        return attachRepository.save(attachment);
    }

    @Override
    public void deleteAttachement(String id) {
        attachRepository.deleteById(id);
    }

    @Override
    public void deleteAllAttachements() {
        attachRepository.deleteAll();
    }

    @Override
    public String base64Encode(String filePath) throws IOException {
        byte[] fileContent = FileUtils.readFileToByteArray(new File(filePath));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;
    }

    @Override
    public String saveImage(String base64, String extension) {
        String image_name = UUID.randomUUID().toString();
        String location = "C:\\Users\\seifa.AFI\\pi\\Courzello\\Pidev\\Backend\\backendPidev\\src\\main\\resources\\images\\post\\"+image_name+"."+extension;
        byte[] decodedBytes = Base64.getDecoder().decode(base64);
        try {
            Files.write(Paths.get(location), decodedBytes);
            return location;
        }
        catch(IOException ex) {
            return "";
        }

    }
}
