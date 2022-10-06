package com.example.AplikasiPerpustakaan.Service.Impl;

import com.example.AplikasiPerpustakaan.Entity.DTO.PeminjamanDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.PenerbitDTO;
import com.example.AplikasiPerpustakaan.Entity.Mapping.PeminjamanMapping;
import com.example.AplikasiPerpustakaan.Entity.Mapping.PenerbitMapping;
import com.example.AplikasiPerpustakaan.Entity.Peminjaman;
import com.example.AplikasiPerpustakaan.Entity.Penerbit;
import com.example.AplikasiPerpustakaan.Repository.PenerbitRepository;
import com.example.AplikasiPerpustakaan.Service.PenerbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenerbitServiceImpl implements PenerbitService {
    @Autowired
    private PenerbitRepository repository;

    @Override
    public PenerbitDTO save(PenerbitDTO param) {
        Penerbit data = repository.save(PenerbitMapping.instance.toEntity(param));
        return PenerbitMapping.instance.toDto(data);

    }

    @Override
    public List<PenerbitDTO> findAllData() {
        return PenerbitMapping.instance.toListDto(repository.findAll());

    }

    @Override
    public PenerbitDTO update(PenerbitDTO param, Integer id) {
        Penerbit data = repository.findById(id).orElse(null);

        if (data != null) {
            data.setNama(param.getNama() == null ? data.getNama() : param.getNama());
            data.setAlamat(param.getAlamat() != null ? param.getAlamat() : data.getAlamat());
            data.setTelp(param.getTelp() != null ? param.getTelp() : data.getTelp());



            return PenerbitMapping.instance.toDto(repository.save(data));
        }

        return PenerbitMapping.instance.toDto(data);

    }

    @Override
    public Boolean delete(Integer id) {
        Penerbit data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;

    }

    @Override
    public PenerbitDTO findById(Integer id) {
        return PenerbitMapping.instance.toDto (repository.findById(id).orElse(null));

    }
}
