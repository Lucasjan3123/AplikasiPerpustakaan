package com.example.AplikasiPerpustakaan.Repository;

import com.example.AplikasiPerpustakaan.Entity.Pengembalian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PengembalianRepository extends JpaRepository<Pengembalian,Integer> {
}
