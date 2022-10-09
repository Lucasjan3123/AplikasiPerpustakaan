package com.example.AplikasiPerpustakaan.Service.Impl;

import com.example.AplikasiPerpustakaan.Entity.*;
import com.example.AplikasiPerpustakaan.Entity.DTO.PengembalianDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.PengembalianDetailDTO;
import com.example.AplikasiPerpustakaan.Entity.Mapping.*;
import com.example.AplikasiPerpustakaan.Repository.BukuRepository;
import com.example.AplikasiPerpustakaan.Repository.PengembalianDetailRepository;
import com.example.AplikasiPerpustakaan.Repository.PengembalianRepository;
import com.example.AplikasiPerpustakaan.Service.PengembalianDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PengembalianDetailServiceImpl implements PengembalianDetailService {

    @Autowired
    private PengembalianDetailRepository pengembalianDetailRepository;

    @Autowired
    private BukuRepository bukuRepository;

    @Autowired
    private PengembalianRepository pengembalianRepository;




    @Override
    public PengembalianDetailDTO save(PengembalianDetailDTO param) {
        Pengembalian pengembalian = PengembalianMapping.instance.toEntity(param.getPengembalian());

        PengembalianDetail data = PengembalianDetailMapping.instance.toEntity(param);

        if (param.getPengembalian() != null) {
            pengembalian = pengembalianRepository.save(pengembalian);

            data.getPengembalian().setId(pengembalian.getId());
        }
        Buku buku = BukuMapping.instance.toEntity(param.getBuku());
        if (param.getBuku() != null) {
            buku = bukuRepository.save(buku);

            data.getBuku().setID(buku.getID());
        }

        data = pengembalianDetailRepository.save(data);

        return PengembalianDetailMapping.instance.toDto(data);
    }

    @Override
    public List<PengembalianDetailDTO> findAllData() {
        return PengembalianDetailMapping.instance.toListDto(pengembalianDetailRepository.findAll());

    }

    @Override
    public PengembalianDetailDTO update(PengembalianDetailDTO param, PengembalianDetailKey id) {
        PengembalianDetail data = pengembalianDetailRepository.findById(id).orElse(null);
        return PengembalianDetailMapping.instance.toDto(pengembalianDetailRepository.save(data));

    }



    @Override
    public Boolean delete(PengembalianDetailKey id) {
        PengembalianDetail data = pengembalianDetailRepository.findById(id).orElse(null);

        if (data != null){
            pengembalianDetailRepository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public PengembalianDetailDTO findById(PengembalianDetailKey id) {
        return PengembalianDetailMapping.instance.toDto (pengembalianDetailRepository.findById(id).orElse(null));

    }
}
