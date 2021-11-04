package service.validation;

import entity.User;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;


@Service
@RequestScoped
public class UserValidationService {

    @Inject
    private UserRepository userRepository;

    private User user;

    public User findByName(String name){
        if(user==null){
            user = userRepository.findByName(name)
                    .map(data->data)
                    .orElseThrow(()-> new NotFoundException("user not found"));
        }
        return user;
    }

}
