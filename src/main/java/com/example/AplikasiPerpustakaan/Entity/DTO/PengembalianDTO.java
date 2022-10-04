package com.example.AplikasiPerpustakaan.Entity.DTO;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PengembalianDTO {
    private Integer pengembalian_id;

    private String tgl_pengembalian;

    private Double Denda;

}
