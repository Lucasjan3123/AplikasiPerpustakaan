package com.example.AplikasiPerpustakaan.Entity.Mapping;

import com.example.AplikasiPerpustakaan.Entity.DTO.PenerbitDTO;
import com.example.AplikasiPerpustakaan.Entity.Penerbit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PenerbitMapping {
    PenerbitMapping instance= Mappers.getMapper(PenerbitMapping .class);
    Penerbit toEntity(PenerbitDTO dto);
    PenerbitDTO toDto(Penerbit param);

    List<PenerbitDTO> toListDto(List<Penerbit>penerbitList);

}
