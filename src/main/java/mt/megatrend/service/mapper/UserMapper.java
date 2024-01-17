package mt.megatrend.service.mapper;

import mt.megatrend.dto.UserDto;
import mt.megatrend.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public abstract class UserMapper implements CommonMapper<UserDto, Users>{
    @Autowired
    protected PasswordEncoder passwordEncoder;
    @Override
    public abstract UserDto toDto(Users users);

    @Override
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(userDto.getPassword()))")
    public abstract Users toEntity(UserDto userDto);
}
