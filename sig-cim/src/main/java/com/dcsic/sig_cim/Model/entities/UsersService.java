package com.dcsic.sig_cim.Model.entities;

import com.dcsic.sig_cim.Model.entities.Repository.UsersRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Data
public class UsersService {
    private final UsersRepository usersRepository;


    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users createUser(Users user) {
        return usersRepository.save(user);
    }
    public Users updateUser(Users user) {
        return usersRepository.save(user);
    }

    public Users deleteUsers(Users users) {
        usersRepository.delete(users);
        return users;
    }
}
