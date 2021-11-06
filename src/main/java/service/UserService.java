package service;

import dto.UserDto;
import dto.UserRequestDto;
import entity.User;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import service.mapper.UserMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ApplicationScoped
public class UserService {

    @Inject
    private UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    private static final String ERROR_USER_NOT_FOUND= "user id not found";

    public List<UserDto> getUsers(){
        return userRepository.findAll().stream()
                .map(data-> userMapper.toResource(data))
                .collect(Collectors.toList());
    }

    public UserDto createUser(UserRequestDto userRequestDto) {
        User user = userRepository.save(userMapper.toEntity(userRequestDto));
        return userMapper.toResource(userRepository.save(user));
    }

    public UserDto updateUser(Long id, UserRequestDto userRequestDto) {
        return userRepository.findById(id).map(data-> {
            data.setName(userRequestDto.getName());
            return userMapper.toResource(userRepository.save(data));
        }).orElseThrow(()-> new NotFoundException(ERROR_USER_NOT_FOUND));

    }

    public UserDto deleteUser(Long id) {
        return userRepository.findById(id).map(data-> {
            userRepository.delete(data);
            return userMapper.toResource(data);
        }).orElseThrow(()-> new NotFoundException(ERROR_USER_NOT_FOUND));
    }

    public UserDto getUserById(Long id) {
        return userRepository.findById(id).map(data-> userMapper.toResource(data))
                .orElseThrow(()-> new NotFoundException(ERROR_USER_NOT_FOUND));
    }
}
