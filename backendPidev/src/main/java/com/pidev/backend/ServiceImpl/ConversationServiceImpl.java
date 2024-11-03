package com.pidev.backend.serviceImpl;

import com.pidev.backend.entity.Conversation;
import com.pidev.backend.repository.ConversationRepository;
import com.pidev.backend.service.ConversationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConversationServiceImpl implements ConversationService {

    ConversationRepository conversationRepository;
    @Override
    public Conversation addConversation(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    @Override
    public List<Conversation> getALLConversations() {
        return conversationRepository.findAll();
    }

    @Override
    public Conversation modifyConversation(Conversation conversation) {
        return conversationRepository.save(conversation) ;
    }

    @Override
    public void deleteConversation(String conversationId) {
         Conversation c  = conversationRepository.findById(conversationId).get();
        conversationRepository.delete(c);

    }


}
