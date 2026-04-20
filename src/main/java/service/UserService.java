package service;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository UserRepository;

    public UserService(UserRepository userRepository) {
        this.UserRepository = userRepository;
    }

    public User addUser(User request){
        request.setId(UUID.randomUUID().toString());
        return UserRepository.save(request);
    }

    public List<User> getAllUser(){
        return UserRepository.findAllById(id).orElse(null);
    }

    public User updateuser(String id, User request){
        User existingUser=UserRepository.findAllById(id).orElse(null);
        if (existingUser!= null){
            existingUser.setName(request.getName());
            existingUser.setNim(request.getNim());
            return UserRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser(String id){
        UserRepository.deleteById(id);
    }
}
