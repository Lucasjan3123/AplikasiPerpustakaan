package com.example.AplikasiPerpustakaan.Entity.Mapping;

import com.example.AplikasiPerpustakaan.Entity.Buku;
import com.example.AplikasiPerpustakaan.Entity.DTO.BukuDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.UserDTO;
import com.example.AplikasiPerpustakaan.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BukuMapping {
    BukuMapping instance= Mappers.getMapper(BukuMapping.class);
    Buku toEntity(BukuDTO dto);
    BukuDTO toDto(Buku param);

    List<BukuDTO> toListDto(List<Buku>bukuList);

}
