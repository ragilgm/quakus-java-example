package service.mapper;

import dto.UserDto;
import dto.UserRequestDto;
import entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    UserDto toResource(User person);

    User toEntity(UserRequestDto userRequestDto);
}
