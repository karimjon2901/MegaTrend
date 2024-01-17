package mt.megatrend.service;

import mt.megatrend.dto.LoginDto;
import mt.megatrend.dto.ResponseDto;
import mt.megatrend.dto.UserDto;

public interface UserService {
    ResponseDto<UserDto> update(UserDto userDto);
    ResponseDto<String> loginUser(LoginDto loginDto);
}
