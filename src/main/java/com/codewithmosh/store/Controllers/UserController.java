package com.codewithmosh.store.Controllers;

import com.codewithmosh.store.Mapper.UserMapper;
import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.details.UserDto;
import com.codewithmosh.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
   // private final UserMapper userMapper;
    @GetMapping
    public Iterable<UserDto> getAllUsers(@RequestParam(required = false,defaultValue = "") String sort) {
        if(!Set.of("name","id").contains(sort))sort="name";
        return userRepository.findAll(Sort.by(sort))
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    /*@GetMapping("/{id}")//THIS is not RESTFUL becouse if ID notFound it return 200-ok but it should be 404
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElse(null);
    }
    */
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto) //
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
