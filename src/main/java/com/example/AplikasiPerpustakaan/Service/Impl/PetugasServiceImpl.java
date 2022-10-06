package com.example.AplikasiPerpustakaan.Service.Impl;

import com.example.AplikasiPerpustakaan.Entity.DTO.PetugasDTO;
import com.example.AplikasiPerpustakaan.Entity.Mapping.PetugasMapping;
import com.example.AplikasiPerpustakaan.Entity.Petugas;
import com.example.AplikasiPerpustakaan.Repository.PetugasRepository;
import com.example.AplikasiPerpustakaan.Service.PetugasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetugasServiceImpl implements PetugasService {
    @Autowired
    private PetugasRepository repository;


    @Override
    public PetugasDTO save(PetugasDTO param) {
        Petugas data = repository.save(PetugasMapping.instance.toEntity(param));
        return PetugasMapping.instance.toDto(data);

    }

    @Override
    public List<PetugasDTO> findAllData() {
        return PetugasMapping.instance.toListDto(repository.findAll());

    }

    @Override
    public PetugasDTO update(PetugasDTO param, Integer id) {
        Petugas data = repository.findById(id).orElse(null);

        if (data != null) {
            data.setNama(param.getNama() == null ? data.getNama() : param.getNama());
            data.setAlamat(param.getAlamat() != null ? param.getAlamat() : data.getAlamat());
            data.setTelp(param.getTelp() != null? param.getTelp() : data.getTelp());


            return PetugasMapping.instance.toDto(repository.save(data));
        }

        return PetugasMapping.instance.toDto(data);


    }

    @Override
    public Boolean delete(Integer id) {
        Petugas data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;


    }

    @Override
    public PetugasDTO findById(Integer id) {
        return PetugasMapping.instance.toDto (repository.findById(id).orElse(null));
    }
}
