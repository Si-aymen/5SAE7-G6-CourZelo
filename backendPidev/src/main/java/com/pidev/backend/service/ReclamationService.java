package com.pidev.backend.service;

import com.pidev.backend.entity.Reclamation;
import com.pidev.backend.entity.ReclamtionState;

import java.util.List;
import java.util.Map;

public interface ReclamationService {
    List<Reclamation> getAllReclamations();
    Reclamation getReclamationById(String reclamationID);
    Reclamation createReclamation(Reclamation reclamation);
    Reclamation updateReclamation(Reclamation reclamation);
    void deleteReclamation(String id);
    void deleteAllReclamations();
    long getTotalReclamations();

    Map<ReclamtionState, Long> getReclamationsByStateCount();

    List<Reclamation> getReclamationsByUser(String userId);

    void updatePriorities();

    double getAverageResolutionTime();
    long getPendingReclamationsCount();


}
