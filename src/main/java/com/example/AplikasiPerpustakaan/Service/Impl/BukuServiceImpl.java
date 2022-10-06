package com.example.AplikasiPerpustakaan.Service.Impl;

import com.example.AplikasiPerpustakaan.Entity.Buku;
import com.example.AplikasiPerpustakaan.Entity.DTO.BukuDTO;
import com.example.AplikasiPerpustakaan.Entity.Mapping.BukuMapping;
import com.example.AplikasiPerpustakaan.Repository.BukuRepository;
import com.example.AplikasiPerpustakaan.Service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BukuServiceImpl implements BukuService {
    @Autowired
    private BukuRepository repository;

    @Override
    public BukuDTO save(BukuDTO param) {
        Buku data = repository.save(BukuMapping.instance.toEntity(param));
        return BukuMapping.instance.toDto(data);

    }

    @Override
    public List<BukuDTO> findAllData() {
        return BukuMapping.instance.toListDto(repository.findAll());

    }

    @Override
    public BukuDTO update(BukuDTO param, Integer id) {
        Buku data = repository.findById(id).orElse(null);

        if (data != null) {
            data.setJudul(param.getJudul() == null ? data.getJudul() : param.getJudul());
            data.setTahun_terbit(param.getTahun_terbit() != null ? param.getTahun_terbit() : data.getTahun_terbit());
            data.setJumlah(param.getJumlah() != null ? param.getJumlah() : data.getJumlah());
            data.setIsbn(param.getIsbn() != null? param.getIsbn() : data.getIsbn());


            return BukuMapping.instance.toDto(repository.save(data));
        }

        return BukuMapping.instance.toDto(data);

    }

    @Override
    public Boolean delete(Integer id) {
        Buku data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;

    }

    @Override
    public BukuDTO findById(Integer id) {
        return BukuMapping.instance.toDto (repository.findById(id).orElse(null));

    }
}
