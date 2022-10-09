package com.example.AplikasiPerpustakaan.Controller;


import com.example.AplikasiPerpustakaan.Common.Response;
import com.example.AplikasiPerpustakaan.Entity.DTO.PeminjamanDetailDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.PengembalianDetailDTO;
import com.example.AplikasiPerpustakaan.Entity.PeminjamanDetailKey;
import com.example.AplikasiPerpustakaan.Entity.Pengembalian;
import com.example.AplikasiPerpustakaan.Entity.PengembalianDetailKey;
import com.example.AplikasiPerpustakaan.Service.Impl.PeminjamanDetailServiceImpl;
import com.example.AplikasiPerpustakaan.Service.Impl.PengembalianDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pengembalianDetail")

public class PengembalianDetailController {
    @Autowired
    private PengembalianDetailServiceImpl Services;

    @GetMapping("/find-all")
    public Response findAllData(){
        List<PengembalianDetailDTO> data= Services.findAllData();
        return new Response(data, "Get All data pembayaran",data.size(), HttpStatus.OK);

    }

    @PostMapping( "/create")
    public ResponseEntity<?> saveData(@RequestBody PengembalianDetailDTO param){
        return new ResponseEntity<>(Services.save(param), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateData(@PathVariable PengembalianDetailKey id,
                                        @RequestBody PengembalianDetailDTO param){
        PengembalianDetailDTO data = Services.update(param, id);

        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/find-by-id/{id}")
    public Response findById(@PathVariable PengembalianDetailKey id){
        return new Response(Services.findById(id), "berhasil mengambil data",HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public Response deleteData(@PathVariable PengembalianDetailKey id) {
        if (Services.delete(id)) {
            return new Response( "data berhasil dihapus",HttpStatus.OK);
        } else {
            return new Response(  "data berhasil dihapus",HttpStatus.BAD_REQUEST);
        }
    }


}
