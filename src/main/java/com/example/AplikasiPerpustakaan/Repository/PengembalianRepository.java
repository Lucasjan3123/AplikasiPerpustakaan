package com.example.AplikasiPerpustakaan.Repository;

import com.example.AplikasiPerpustakaan.Entity.Buku;
import com.example.AplikasiPerpustakaan.Entity.Pengembalian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PengembalianRepository extends JpaRepository<Pengembalian,Integer> {
    List<Buku> findPengembalianByBukuId(Integer BukuId);

}
