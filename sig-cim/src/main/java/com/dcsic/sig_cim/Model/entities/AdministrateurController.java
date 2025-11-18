package com.dcsic.sig_cim.Model.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdministrateurController {

    final UsersService usersService;


    @Autowired
    public AdministrateurController(UsersService usersService) {
        this.usersService = usersService;
    }



    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers() {
        return new ResponseEntity<>(usersService.getAllUsers(), HttpStatus.OK);

    }
    @PostMapping("/users")
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        return new ResponseEntity<>(usersService.createUser(user), HttpStatus.CREATED);
    }
    @DeleteMapping("/users")
    public ResponseEntity<Users> deleteUsers(@RequestBody Users users) {
        return new ResponseEntity<>(usersService.deleteUsers(users), HttpStatus.OK);

    }


}
