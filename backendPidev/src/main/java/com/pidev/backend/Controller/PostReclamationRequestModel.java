package com.pidev.backend.controller;

import com.pidev.backend.entity.Attachment;
import com.pidev.backend.entity.Reclamation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostReclamationRequestModel {
    private Reclamation rec;
    private Attachment att;
}
