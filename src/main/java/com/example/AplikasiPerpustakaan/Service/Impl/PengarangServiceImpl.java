package com.example.AplikasiPerpustakaan.Service.Impl;

import com.example.AplikasiPerpustakaan.Entity.DTO.PengarangDTO;
import com.example.AplikasiPerpustakaan.Entity.Mapping.PenerbitMapping;
import com.example.AplikasiPerpustakaan.Entity.Mapping.PengarangMapping;
import com.example.AplikasiPerpustakaan.Entity.Penerbit;
import com.example.AplikasiPerpustakaan.Entity.Pengarang;
import com.example.AplikasiPerpustakaan.Repository.PengarangRepository;
import com.example.AplikasiPerpustakaan.Service.PengarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PengarangServiceImpl implements PengarangService {
    @Autowired
    private PengarangRepository repository;

    @Override
    public PengarangDTO save(PengarangDTO param) {
        Pengarang data = repository.save(PengarangMapping.instance.toEntity(param));
        return PengarangMapping.instance.toDto(data);

    }

    @Override
    public List<PengarangDTO> findAllData() {
        return PengarangMapping.instance.toListDto(repository.findAll());

    }

    @Override
    public PengarangDTO update(PengarangDTO param, Integer id) {
        Pengarang data = repository.findById(id).orElse(null);

        if (data != null) {
            data.setNama(param.getNama() != null ? data.getNama() : param.getNama());
            data.setAlamat(param.getAlamat() != null ? param.getAlamat() : data.getAlamat());
            data.setTelp(param.getTelp() != null ? param.getTelp() : data.getTelp());



            return PengarangMapping.instance.toDto(repository.save(data));
        }

        return PengarangMapping.instance.toDto(data);

    }

    @Override
    public Boolean delete(Integer id) {
        Pengarang data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;


    }

    @Override
    public PengarangDTO findById(Integer id) {
        return PengarangMapping.instance.toDto (repository.findById(id).orElse(null));
    }
}
