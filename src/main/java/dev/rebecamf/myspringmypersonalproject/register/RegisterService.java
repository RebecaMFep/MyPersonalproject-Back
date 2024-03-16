package dev.rebecamf.myspringmypersonalproject.register;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;
import dev.rebecamf.myspringmypersonalproject.encryptations.EncoderFacade;
import dev.rebecamf.myspringmypersonalproject.roles.Role;
import dev.rebecamf.myspringmypersonalproject.roles.RoleService;
import dev.rebecamf.myspringmypersonalproject.users.User;
import dev.rebecamf.myspringmypersonalproject.users.UserRepository;

@Service
public class RegisterService {

    UserRepository userRepository;
    RoleService roleService;
    EncoderFacade encoder;

    public RegisterService(UserRepository userRepository, RoleService roleService, EncoderFacade encoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.encoder = encoder;
    }

    public String save(User newUser) {

        String passwordDecoded = encoder.decode("base64", newUser.getPassword());
        String passwordEncoded = encoder.encode("bcrypt", passwordDecoded);

        newUser.setPassword(passwordEncoded);
        assignDefaultRole(newUser);

        userRepository.save(newUser);

        return "user stored successfully :" + newUser.getUsername();

    }

    public void assignDefaultRole(User user) {

        Role defaultRole = roleService.getById(2L);
        Set<Role> roles = new HashSet<>();
        roles.add(defaultRole);

        user.setRoles(roles);
    }
}
