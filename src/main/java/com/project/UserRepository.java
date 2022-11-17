package com.project;

import com.project.entity.Message;
import com.project.entity.Topic;
import com.project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UserRepository {

    @Autowired
    public EntityManager em;

    public List<User> getAllUsers() {
        return em
                .createQuery("select u from User u", User.class)
                .getResultList();
    }

    public List<Message> getAllMessage() {
        return em.createQuery("select m from Message m", Message.class)
                .getResultList();
    }

    public List<Topic> getAllTopics() {
        return em.createQuery("select t from Topic t", Topic.class)
                .getResultList();
    }
    public User getOneUser(long id) {
        return em.find(User.class, id);
    }

    public Topic getOneTopic(long id) {
        return em.find(Topic.class, id);
    }

    public Message getOneMessage(long id) {
        return em.find(Message.class, id);
    }

    public void addMessage(Message message) {
        em.persist(message);
    }

    public void deleteMessage(long id) {
        em.remove(em.find(Message.class, id));
    }

    public void updateMessage(Message message) {
        em.merge(message);
    }
}
