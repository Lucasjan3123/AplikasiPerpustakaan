package com.example.AplikasiPerpustakaan.Service.Impl;

import com.example.AplikasiPerpustakaan.Entity.*;
import com.example.AplikasiPerpustakaan.Entity.DTO.BukuDTO;
import com.example.AplikasiPerpustakaan.Entity.Mapping.*;
import com.example.AplikasiPerpustakaan.Repository.BukuRepository;
import com.example.AplikasiPerpustakaan.Repository.PenerbitRepository;
import com.example.AplikasiPerpustakaan.Repository.PengarangRepository;
import com.example.AplikasiPerpustakaan.Service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BukuServiceImpl implements BukuService {
    @Autowired
    private BukuRepository repository;

    @Autowired
    private PenerbitRepository penerbitRepository;

    @Autowired
    private PengarangRepository pengarangRepository;

    @Override
    public BukuDTO save(BukuDTO param) {

        Penerbit penerbit = PenerbitMapping.instance.toEntity(param.getPenerbit());

        Buku data = repository.save(BukuMapping.instance.toEntity(param));

        if (param.getPenerbit() != null) {
            penerbit = penerbitRepository.save(penerbit);

            data.getPenerbit().setId(penerbit.getId());
        }
        Pengarang pengarang = PengarangMapping.instance.toEntity(param.getPengarang());
        if (param.getPengarang() != null) {
           pengarang = pengarangRepository.save(pengarang);

            data.getPengarang().setId(pengarang.getId());
        }

        data = repository.save(data);
        return BukuMapping.instance.toDto(data);

    }

    @Override
    public List<BukuDTO> findAllData() {
        return BukuMapping.instance.toListDto(repository.findAll());

    }

    @Override
    public BukuDTO update(BukuDTO param, Integer Id) {
        Buku data = repository.findById(Id).orElse(null);

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
    public Boolean delete(Integer Id) {
        Buku data = repository.findById(Id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;

    }

    @Override
    public BukuDTO findById(Integer Id) {
        return BukuMapping.instance.toDto (repository.findById(Id).orElse(null));

    }
}
