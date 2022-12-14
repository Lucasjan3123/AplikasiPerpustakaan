package com.example.AplikasiPerpustakaan.Service.Impl;

import com.example.AplikasiPerpustakaan.Entity.Anggota;
import com.example.AplikasiPerpustakaan.Entity.DTO.PeminjamanDTO;
import com.example.AplikasiPerpustakaan.Entity.Mapping.AnggotaMapping;
import com.example.AplikasiPerpustakaan.Entity.Mapping.PeminjamanMapping;
import com.example.AplikasiPerpustakaan.Entity.Mapping.PetugasMapping;
import com.example.AplikasiPerpustakaan.Entity.Peminjaman;
import com.example.AplikasiPerpustakaan.Entity.Petugas;
import com.example.AplikasiPerpustakaan.Repository.AnggotaRepository;
import com.example.AplikasiPerpustakaan.Repository.PeminjamanRepository;
import com.example.AplikasiPerpustakaan.Repository.PetugasRepository;
import com.example.AplikasiPerpustakaan.Service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeminjamanServiceImpl implements PeminjamanService {
    @Autowired
    private PeminjamanRepository repository;

    @Autowired
    private AnggotaRepository anggotaRepository;

    @Autowired
    private PetugasRepository petugasRepository;


    @Override
    public PeminjamanDTO save(PeminjamanDTO param) {

       Anggota anggota = AnggotaMapping.instance.toEntity(param.getAnggota());

        Peminjaman data = PeminjamanMapping.instance.toEntity(param);

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

        return PeminjamanMapping.instance.toDto(data);
    }

    @Override
    public List<PeminjamanDTO> findAllData() {
        return PeminjamanMapping.instance.toListDto(repository.findAll());

    }

    @Override
    public PeminjamanDTO update(PeminjamanDTO param, Integer id) {
        Peminjaman data = repository.findById(id).orElse(null);

        if (data != null) {
            data.setTgl_pinjam(param.getTgl_pinjam() == null ? data.getTgl_pinjam() : param.getTgl_pinjam());
            data.setTgl_kembali(param.getTgl_kembali() != null ? param.getTgl_kembali() : data.getTgl_kembali());


            return PeminjamanMapping.instance.toDto(repository.save(data));
        }

        return PeminjamanMapping.instance.toDto(data);

    }

    @Override
    public Boolean delete(Integer id) {
        Peminjaman data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;

    }

    @Override
    public PeminjamanDTO findById(Integer id) {
        return PeminjamanMapping.instance.toDto (repository.findById(id).orElse(null));

    }
}
