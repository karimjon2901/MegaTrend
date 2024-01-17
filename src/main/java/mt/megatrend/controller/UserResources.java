package mt.megatrend.controller;

import mt.megatrend.dto.LoginDto;
import mt.megatrend.dto.ResponseDto;
import mt.megatrend.dto.UserDto;
import mt.megatrend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class UserResources {
    private final UserService userService;
    @Operation(
            method = "Update admin",
            description = "Need to send AdminDto to this endpoint to update admin",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "User info",
                    content = @Content(mediaType = "application/json"))
    )
    @PatchMapping
    public ResponseDto<UserDto> updateUser(@RequestBody UserDto userDto){
        return userService.update(userDto);
    }

    @Operation(
            method = "Login admin",
            description = "Need to send username and password to this endpoint to login admin. You can get token.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "User info",
                    content = @Content(mediaType = "application/json"))
    )
    @PostMapping("/login")
    public ResponseDto<String> loginUser(@RequestBody LoginDto loginDto) {
        return userService.loginUser(loginDto);
    }
}
