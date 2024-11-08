package com.pidev.backend.service;

import com.pidev.backend.entity.Conversation;

import java.util.List;

public interface ConversationService {
    Conversation addConversation (Conversation conversation);
    List<Conversation> getALLConversations();
    Conversation modifyConversation (Conversation conversation);
    public void deleteConversation(String ConversationId);

}
