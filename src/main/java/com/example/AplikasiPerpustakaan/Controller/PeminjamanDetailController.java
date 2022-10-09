package com.example.AplikasiPerpustakaan.Controller;

import com.example.AplikasiPerpustakaan.Common.Response;
import com.example.AplikasiPerpustakaan.Entity.DTO.PeminjamanDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.PeminjamanDetailDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.PenerbitDTO;
import com.example.AplikasiPerpustakaan.Entity.Peminjaman;
import com.example.AplikasiPerpustakaan.Entity.PeminjamanDetail;
import com.example.AplikasiPerpustakaan.Entity.PeminjamanDetailKey;
import com.example.AplikasiPerpustakaan.Repository.BukuRepository;
import com.example.AplikasiPerpustakaan.Repository.PeminjamanRepository;
import com.example.AplikasiPerpustakaan.Service.Impl.PeminjamanDetailServiceImpl;
import com.example.AplikasiPerpustakaan.Service.Impl.PenerbitServiceImpl;
import com.example.AplikasiPerpustakaan.Service.PeminjamanDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peminjamanDetail")
public class PeminjamanDetailController {
    @Autowired
    private PeminjamanDetailServiceImpl Service;

    @GetMapping("/find-all")
    public Response findAllData(){
        List<PeminjamanDetailDTO> data= Service.findAllData();
        return new Response(data, "Get All data pembayaran",data.size(), HttpStatus.OK);

    }

    @PostMapping( "/create")
    public ResponseEntity<?> saveData(@RequestBody PeminjamanDetailDTO param){
        return new ResponseEntity<>(Service.save(param), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateData(@PathVariable PeminjamanDetailKey id,
                                        @RequestBody PeminjamanDetailDTO param){
        PeminjamanDetailDTO data = Service.update(param, id);

        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/find-by-id/{id}")
    public Response findById(@PathVariable PeminjamanDetailKey id){
        return new Response(Service.findById(id), "berhasil mengambil data",HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public Response deleteData(@PathVariable PeminjamanDetailKey id) {
        if (Service.delete(id)) {
            return new Response( "data berhasil dihapus",HttpStatus.OK);
        } else {
            return new Response(  "data berhasil dihapus",HttpStatus.BAD_REQUEST);
        }
    }

}
