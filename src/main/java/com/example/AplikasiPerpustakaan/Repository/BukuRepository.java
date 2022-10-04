package com.example.AplikasiPerpustakaan.Repository;

import com.example.AplikasiPerpustakaan.Entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BukuRepository extends JpaRepository<Buku,Integer> {

}
