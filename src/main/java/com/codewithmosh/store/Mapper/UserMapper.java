package com.codewithmosh.store.Mapper;

import com.codewithmosh.store.details.UserDto;
import com.codewithmosh.store.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user); // Let MapStruct generate the implementation!
}