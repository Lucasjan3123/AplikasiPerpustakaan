package com.example.AplikasiPerpustakaan.Repository;

import com.example.AplikasiPerpustakaan.Entity.Buku;
import com.example.AplikasiPerpustakaan.Entity.Peminjaman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeminjamanRepository extends JpaRepository<Peminjaman,Integer> {
    List<Buku> findPeminjamanByBukuId(Integer BukuId);

}
