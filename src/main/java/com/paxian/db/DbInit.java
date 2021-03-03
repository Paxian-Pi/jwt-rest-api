package com.paxian.db;

import com.paxian.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbInit implements CommandLineRunner {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Create users
        User pax = new User("pax", passwordEncoder.encode("pax123"),"USER", "");
        User wendy = new User("wendy", passwordEncoder.encode("wendy123"),"ADMIN", "ACCESS_TEST1, ACCESS_TEST2");
        User pep = new User("pep", passwordEncoder.encode("pep123"),"ADMIN", "ACCESS_TEST1");
        User matt = new User("matt", passwordEncoder.encode("matt123"),"MANAGER", "ACCESS_TEST1");
        User paxian = new User("paxian", passwordEncoder.encode("paxian123"),"MANAGER", "ACCESS_TEST1, ACCESS_TEST2");

        // Drop all users
        this.userRepository.deleteAll();

        // Save all to db
        List<User> users = Arrays.asList(pax,wendy,pep,matt,paxian);
        this.userRepository.saveAll(users);
    }
}
