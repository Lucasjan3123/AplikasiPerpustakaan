package com.example.AplikasiPerpustakaan.Service.Impl;

import com.example.AplikasiPerpustakaan.Entity.*;
import com.example.AplikasiPerpustakaan.Entity.DTO.PeminjamanDetailDTO;
import com.example.AplikasiPerpustakaan.Entity.Mapping.*;
import com.example.AplikasiPerpustakaan.Repository.BukuRepository;
import com.example.AplikasiPerpustakaan.Repository.PeminjamanDetailRepository;
import com.example.AplikasiPerpustakaan.Repository.PeminjamanRepository;
import com.example.AplikasiPerpustakaan.Service.PeminjamanDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeminjamanDetailServiceImpl implements PeminjamanDetailService {

    @Autowired
    private PeminjamanDetailRepository repository;

    @Autowired
    private PeminjamanRepository peminjamanRepository;

    @Autowired
    private BukuRepository bukuRepository;


    @Override
    public PeminjamanDetailDTO save(PeminjamanDetailDTO param) {
        Peminjaman peminjaman = PeminjamanMapping.instance.toEntity(param.getPeminjaman());

        PeminjamanDetail data = PeminjamanDetailMapping.instance.toEntity(param);

        if (param.getPeminjaman() != null) {
            peminjaman = peminjamanRepository.save(peminjaman);

            data.getPeminjaman().setId(peminjaman.getId());
        }
        Buku buku = BukuMapping.instance.toEntity(param.getBuku());
        if (param.getBuku() != null) {
            buku = bukuRepository.save(buku);

            data.getBuku().setID(buku.getID());
        }

        data = repository.save(data);

        return PeminjamanDetailMapping.instance.toDto(data);
    }


    @Override
    public List<PeminjamanDetailDTO> findAllData() {
        return PeminjamanDetailMapping.instance.toListDto(repository.findAll());

    }

    @Override
    public PeminjamanDetailDTO update(PeminjamanDetailDTO param, PeminjamanDetailKey id) {
        PeminjamanDetail data = repository.findById(id).orElse(null);
        return PeminjamanDetailMapping.instance.toDto(repository.save(data));
    }

    @Override
    public Boolean delete(PeminjamanDetailKey id) {
        PeminjamanDetail data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;



    }

    @Override
    public PeminjamanDetailDTO findById(PeminjamanDetailKey id) {
        return PeminjamanDetailMapping.instance.toDto (repository.findById(id).orElse(null));

    }
}
