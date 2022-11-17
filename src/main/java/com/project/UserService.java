package com.project;

import com.project.entity.Message;
import com.project.entity.Topic;
import com.project.entity.User;
import com.project.repository.AccountRepository;
import com.project.view.MessageView;
import com.project.view.RegistrationForm;
import com.project.view.UserView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final LoggedUser loggedUser;

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public UserView getUser(long id) {
        User user = userRepository.getOneUser(id);

        UserView userView = new UserView();
        userView.setId(user.getId());
        userView.setFirstName(user.getFirstName());
        userView.setLastName(user.getLastName());
        userView.setDateOfBirth(user.getDateOfBirth());

        List<MessageView> messages = new ArrayList<>();
        for (Message message : user.getMessages()) {
            MessageView messageView = new MessageView();
            messageView.setId(message.getId());
            messageView.setText(message.getText());
            messageView.setPublicationTime(message.getPublicationTime());
            messages.add(messageView);
        }

        userView.setMessages(messages);

        return userView;
    }

    public void registerUser(RegistrationForm form) {
        User user = new User();
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        user.setDateOfBirth(form.getDateOfBirth());
        user.setPassword(form.getPassword());
        user.setRole(User.Role.USER);

        accountRepository.save(user);
    }

    public List<Message> getAllMessage() {
        return userRepository.getAllMessage();
    }

    public List<Topic> getAllTopics() {
        return userRepository.getAllTopics();
    }

    public void addMessage(String text, long userId) {
        User user = userRepository.getOneUser(userId);
        Message message = new Message();
        message.setText(text);
        message.setUser(user);
        message.setPublicationTime(LocalDateTime.now());
        userRepository.addMessage(message);
    }

    public void deleteMessage(long messageId) {
        userRepository.deleteMessage(messageId);
    }

    public void updateMessage(long messageId, String text) {
        Message message = userRepository.getOneMessage(messageId);
        message.setText(text);
        userRepository.updateMessage(message);
    }

}
