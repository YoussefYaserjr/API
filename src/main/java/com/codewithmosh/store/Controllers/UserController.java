package com.codewithmosh.store.Controllers;

import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.details.UserDto;

import com.codewithmosh.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    @GetMapping
    public Iterable<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDto(user.getId(), user.getName(), user.getEmail()))
                .toList();
    }

    /*@GetMapping("/{id}")//THIS is not RESTFUL becouse if ID notFound it return 200-ok but it should be 404
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElse(null);
    }
    */
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id)
    {
       var user = userRepository.findById(id).orElse(null);
       if(user == null)
       {
           return ResponseEntity.notFound().build();//404 notFound
       }
       UserDto userDto = new UserDto(user.getId(), user.getName(), user.getEmail());
       return ResponseEntity.ok(userDto);
    }
}
