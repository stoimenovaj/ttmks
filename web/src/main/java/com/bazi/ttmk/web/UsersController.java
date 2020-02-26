package com.bazi.ttmk.web;

import com.bazi.ttmk.model.RoleName;
import com.bazi.ttmk.model.User;
import com.bazi.ttmk.model.dto.UserProfile;
import com.bazi.ttmk.model.dto.UserSummary;
import com.bazi.ttmk.model.exception.BadRequestException;
import com.bazi.ttmk.model.exception.ResourceNotFoundException;
import com.bazi.ttmk.repository.UserRepository;
import com.bazi.ttmk.security.CurrentUser;
import com.bazi.ttmk.security.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {

    private UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @GetMapping("/me")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        RoleName role = this.userRepository.findById(currentUser.getId())
                .orElseThrow(() -> new ResourceNotFoundException("user", "id", currentUser.getId()))
                .getRoles()
                .stream()
                .findFirst()
                .orElseThrow(() -> new BadRequestException("No role for user"))
                .getName();
        return new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName(), role.name());
    }

    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        return new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getCreatedAt());
    }

}
