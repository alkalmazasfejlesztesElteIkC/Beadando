package hu.inf.elte.csaladitodo.csaladitodo2000.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hu.inf.elte.csaladitodo.csaladitodo2000.modell.User;
import hu.inf.elte.csaladitodo.csaladitodo2000.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

	
}
