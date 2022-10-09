package com.example.AplikasiPerpustakaan.Service;

import com.example.AplikasiPerpustakaan.Entity.DTO.PeminjamanDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.PeminjamanDetailDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.PengembalianDTO;
import com.example.AplikasiPerpustakaan.Entity.PeminjamanDetail;
import com.example.AplikasiPerpustakaan.Entity.PeminjamanDetailKey;

import java.util.List;

public interface PeminjamanDetailService {

    PeminjamanDetailDTO save(PeminjamanDetailDTO param);

    List<PeminjamanDetailDTO> findAllData();

    PeminjamanDetailDTO update(PeminjamanDetailDTO param, PeminjamanDetailKey id);

    Boolean delete(PeminjamanDetailKey id);

    PeminjamanDetailDTO findById(PeminjamanDetailKey id);

}
