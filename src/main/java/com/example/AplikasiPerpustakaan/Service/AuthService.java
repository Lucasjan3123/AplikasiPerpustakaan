package com.example.AplikasiPerpustakaan.Service;

import com.example.AplikasiPerpustakaan.Entity.DTO.AuthenticationDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.ResponAuthDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.UserDTO;

public interface AuthService {
    ResponAuthDTO register(UserDTO data);

    ResponAuthDTO login(AuthenticationDTO data);
}
