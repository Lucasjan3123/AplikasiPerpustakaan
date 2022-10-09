package com.example.AplikasiPerpustakaan.Entity.Mapping;

import com.example.AplikasiPerpustakaan.Entity.DTO.PeminjamanDetailDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.PengembalianDetailDTO;
import com.example.AplikasiPerpustakaan.Entity.PeminjamanDetail;
import com.example.AplikasiPerpustakaan.Entity.Pengembalian;
import com.example.AplikasiPerpustakaan.Entity.PengembalianDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PengembalianDetailMapping {
    PengembalianDetailMapping instance= Mappers.getMapper(PengembalianDetailMapping.class);

    default PengembalianDetail toEntity(PengembalianDetailDTO dto) {
        return null;
    }

    default PengembalianDetailDTO toDto(PengembalianDetail param) {
        return null;
    }

    List<PengembalianDetailDTO> toListDto(List<PengembalianDetail>pengembalianDetailList);
}
