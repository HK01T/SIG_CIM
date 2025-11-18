package com.dcsic.sig_cim.Model.entities;

import com.dcsic.sig_cim.Model.entities.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Users")
public class UsersController {

    final UsersService usersService;
    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return new ResponseEntity<>(usersService.getAllUsers(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        return new ResponseEntity<>(usersService.createUser(user), HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Users> deleteUsers(@RequestBody Users users) {
        return new ResponseEntity<>(usersService.deleteUsers(users), HttpStatus.OK);

    }
    }
