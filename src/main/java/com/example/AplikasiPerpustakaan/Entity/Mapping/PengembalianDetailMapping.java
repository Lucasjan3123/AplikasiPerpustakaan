package com.example.AplikasiPerpustakaan.Entity.Mapping;

import com.example.AplikasiPerpustakaan.Entity.DTO.PengembalianDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.PengembalianDetailDTO;
import com.example.AplikasiPerpustakaan.Entity.Pengembalian;
import com.example.AplikasiPerpustakaan.Entity.Pengembalian_detail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PengembalianDetailMapping {
    PengembalianDetailMapping instance= Mappers.getMapper(PengembalianDetailMapping.class);
    Pengembalian_detail toEntity(PengembalianDetailDTO dto);
    PengembalianDetailDTO toDto(Pengembalian_detail param);

    List<PengembalianDetailDTO> toListDto(List<Pengembalian_detail>pengembalian_detailList);

}
