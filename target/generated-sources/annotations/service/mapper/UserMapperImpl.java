package service.mapper;

import dto.UserDto;
import dto.UserRequestDto;
import entity.User;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-04T13:43:24+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.12 (Azul Systems, Inc.)"
)
@ApplicationScoped
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toResource(User person) {
        if ( person == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( person.getId() );
        userDto.setName( person.getName() );

        return userDto;
    }

    @Override
    public User toEntity(UserRequestDto userRequestDto) {
        if ( userRequestDto == null ) {
            return null;
        }

        User user = new User();

        user.setName( userRequestDto.getName() );

        return user;
    }
}
