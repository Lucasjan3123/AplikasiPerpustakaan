package com.example.AplikasiPerpustakaan.Service.Impl;

import com.example.AplikasiPerpustakaan.Config.JwtTokenUtil;
import com.example.AplikasiPerpustakaan.Entity.DTO.AuthenticationDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.ResponAuthDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.UserDTO;
import com.example.AplikasiPerpustakaan.Entity.Mapping.UserMapping;
import com.example.AplikasiPerpustakaan.Entity.User;
import com.example.AplikasiPerpustakaan.Repository.UserRepository;
import com.example.AplikasiPerpustakaan.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public ResponAuthDTO register(UserDTO data) {
        User users = UserMapping.instance.toEntity(data);
        users.setPassword(BCrypt.hashpw(data.getPassword(), BCrypt.gensalt()));

        users = repository.save(users);

        return UserMapping.instance.fromEntityToResponseDto(users);
    }

    @Override
    public ResponAuthDTO login(AuthenticationDTO data) {
        User currentUser = repository.findByUsername(data.getUsername());

        ResponAuthDTO res = UserMapping.instance.fromEntityToResponseDto(currentUser);

        if (currentUser == null){
            return null;
        } else if (currentUser.getPassword() != null && BCrypt.checkpw(data.getPassword(), currentUser.getPassword())) {
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(currentUser.getUsername(), currentUser.getPassword(), new ArrayList<>());

            res.setToken(jwtTokenUtil.doGenerateToken(userDetails));

            return res;
        }

        return null;
    }

}
