package com.nocountry.ecommerce.repository.mapper;

import com.nocountry.ecommerce.dto.UserDto;
import com.nocountry.ecommerce.entities.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

//    @Mapping(target = "name", source = "name")

    UserDto toUserDto(User user);

    @InheritInverseConfiguration
    @Mapping(target = "idUser", ignore = true)
//    @Mapping(target = "password", ignore = true)
    User toUser(UserDto userDto);

}
