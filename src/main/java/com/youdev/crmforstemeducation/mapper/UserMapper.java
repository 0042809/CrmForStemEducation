package com.youdev.crmforstemeducation.mapper;
import com.youdev.crmforstemeducation.model.User;
import org.mapstruct.Mapper;
import com.youdev.crmforstemeducation.dto.UserDTO;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
    void updateUserFromDTO(UserDTO userDTO, @MappingTarget User user);

}
