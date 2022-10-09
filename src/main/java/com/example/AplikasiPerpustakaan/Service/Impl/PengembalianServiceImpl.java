package com.example.AplikasiPerpustakaan.Service.Impl;

import com.example.AplikasiPerpustakaan.Entity.Anggota;
import com.example.AplikasiPerpustakaan.Entity.Buku;
import com.example.AplikasiPerpustakaan.Entity.DTO.PengembalianDTO;
import com.example.AplikasiPerpustakaan.Entity.Mapping.AnggotaMapping;
import com.example.AplikasiPerpustakaan.Entity.Mapping.BukuMapping;
import com.example.AplikasiPerpustakaan.Entity.Mapping.PengembalianMapping;
import com.example.AplikasiPerpustakaan.Entity.Mapping.PetugasMapping;
import com.example.AplikasiPerpustakaan.Entity.Pengembalian;
import com.example.AplikasiPerpustakaan.Entity.Petugas;
import com.example.AplikasiPerpustakaan.Repository.AnggotaRepository;
import com.example.AplikasiPerpustakaan.Repository.BukuRepository;
import com.example.AplikasiPerpustakaan.Repository.PengembalianRepository;
import com.example.AplikasiPerpustakaan.Repository.PetugasRepository;
import com.example.AplikasiPerpustakaan.Service.PengembalianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PengembalianServiceImpl implements PengembalianService {
    @Autowired
    private PengembalianRepository repository;

    @Autowired
    private AnggotaRepository anggotaRepository;

    @Autowired
    private PetugasRepository petugasRepository;

    @Autowired
    private BukuRepository bukuRepository;

    @Override
    public PengembalianDTO save(PengembalianDTO param) {

        Anggota anggota = AnggotaMapping.instance.toEntity(param.getAnggota());

        Pengembalian data = repository.save(PengembalianMapping.instance.toEntity(param));


        if (param.getAnggota() != null) {
            anggota = anggotaRepository.save(anggota);

            data.getAnggota().setId(anggota.getId());
        }
        Petugas petugas = PetugasMapping.instance.toEntity(param.getPetugas());
        if (param.getPetugas() != null) {
            petugas = petugasRepository.save(petugas);

            data.getPetugas().setId(petugas.getId());
        }




        data = repository.save(data);
        return PengembalianMapping.instance.toDto(data);

    }

    @Override
    public List<PengembalianDTO> findAllData() {
        return PengembalianMapping.instance.toListDto(repository.findAll());

    }

    @Override
    public PengembalianDTO update(PengembalianDTO param, Integer id) {
        Pengembalian data = repository.findById(id).orElse(null);

        if (data != null) {
            data.setTgl_pengembalian(param.getTgl_pengembalian() == null ? data.getTgl_pengembalian() : param.getTgl_pengembalian());
            data.setDenda(param.getDenda() != null ? param.getDenda() : data.getDenda());


            return PengembalianMapping.instance.toDto(repository.save(data));
        }

        return PengembalianMapping.instance.toDto(data);


    }

    @Override
    public Boolean delete(Integer id) {
        Pengembalian data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;

    }

    @Override
    public PengembalianDTO findById(Integer id) {
        return PengembalianMapping.instance.toDto (repository.findById(id).orElse(null));
    }
}
