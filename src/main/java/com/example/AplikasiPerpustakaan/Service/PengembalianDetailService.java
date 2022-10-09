package com.example.AplikasiPerpustakaan.Service;

import com.example.AplikasiPerpustakaan.Entity.DTO.PengembalianDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.PengembalianDetailDTO;
import com.example.AplikasiPerpustakaan.Entity.Pengembalian;
import com.example.AplikasiPerpustakaan.Entity.PengembalianDetailKey;

import java.util.List;

public interface PengembalianDetailService {

    PengembalianDetailDTO save(PengembalianDetailDTO param);

    List<PengembalianDetailDTO> findAllData();

    PengembalianDetailDTO update(PengembalianDetailDTO param, PengembalianDetailKey id);

    Boolean delete(PengembalianDetailKey id);

    PengembalianDetailDTO findById(PengembalianDetailKey id);
}
