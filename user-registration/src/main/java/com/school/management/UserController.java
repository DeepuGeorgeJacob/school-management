package com.school.management;

import com.school.management.common.response.ApiResponse;
import com.school.management.model.UserModel;
import com.school.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping("api/user/register")
    public ResponseEntity<ApiResponse<String>> registerUser(@RequestBody final UserModel userModel) {
       return ResponseEntity.ok(userService.registerUser(userModel));
    }

}
