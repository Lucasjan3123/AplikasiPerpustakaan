package com.example.AplikasiPerpustakaan.Service.Impl;

import com.example.AplikasiPerpustakaan.Entity.Anggota;
import com.example.AplikasiPerpustakaan.Entity.DTO.AnggotaDTO;
import com.example.AplikasiPerpustakaan.Entity.Mapping.AnggotaMapping;
import com.example.AplikasiPerpustakaan.Repository.AnggotaRepository;
import com.example.AplikasiPerpustakaan.Service.AnggotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnggotaServiceImpl implements AnggotaService {
    @Autowired
    private AnggotaRepository repository;


    @Override
    public AnggotaDTO save(AnggotaDTO param) {
        Anggota data = repository.save(AnggotaMapping.instance.toEntity(param));
        return AnggotaMapping.instance.toDto(data);
    }

    @Override
    public List<AnggotaDTO> findAllData() {
        return AnggotaMapping.instance.toListDto(repository.findAll());

    }

    @Override
    public AnggotaDTO update(AnggotaDTO param, Integer id) {
        Anggota data = repository.findById(id).orElse(null);

        if (data != null) {
            data.setNama(param.getNama() == null ? data.getNama() : param.getNama());
            data.setJenis_kelamin(param.getJenis_kelamin() != null ? param.getJenis_kelamin() : data.getJenis_kelamin());
            data.setAlamat(param.getAlamat() != null ? param.getAlamat() : data.getAlamat());
            data.setTelp(param.getTelp() != null? param.getTelp() : data.getTelp());


            return AnggotaMapping.instance.toDto(repository.save(data));
        }

        return AnggotaMapping.instance.toDto(data);

    }

    @Override
    public Boolean delete(Integer id) {
        Anggota data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;

    }

    @Override
    public AnggotaDTO findById(Integer id) {
        return AnggotaMapping.instance.toDto (repository.findById(id).orElse(null));

    }
}
