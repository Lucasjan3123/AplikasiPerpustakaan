package com.example.AplikasiPerpustakaan.Entity.Mapping;

import com.example.AplikasiPerpustakaan.Entity.DTO.ResponAuthDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.UserDTO;
import com.example.AplikasiPerpustakaan.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface UserMapping {
    UserMapping instance= Mappers.getMapper(UserMapping.class);
    User toEntity(UserDTO dto);
    UserDTO toDto(User param);

    List<UserDTO> toListDto(List<User>userList);
    ResponAuthDTO fromEntityToResponseDto(User data);

    ResponAuthDTO fromDtoToResponseDto(UserDTO data);

}
