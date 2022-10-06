package com.example.AplikasiPerpustakaan.Service;

import com.example.AplikasiPerpustakaan.Entity.DTO.AnggotaDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.UserDTO;

import java.util.List;

public interface UserService
{
    UserDTO findByUsername(String username);

    List<UserDTO> getAllData();

}
