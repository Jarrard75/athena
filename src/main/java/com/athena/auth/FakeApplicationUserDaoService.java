package com.athena.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import static com.athena.security.ApplicationUserRole.ADMIN;
import static com.athena.security.ApplicationUserRole.USER;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUserList = Lists.newArrayList(
                new ApplicationUser("admin",
                        passwordEncoder.encode("admin"),
                        ADMIN.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true),

                new ApplicationUser("Jarrard75",
                        passwordEncoder.encode("test"),
                        USER.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true),

                new ApplicationUser("sprjai",
                        passwordEncoder.encode("test"),
                        USER.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true),

                new ApplicationUser("elaineisringhausen",
                        passwordEncoder.encode("test"),
                        USER.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true)
        );

        return applicationUserList;
    }
}
