package com.example.AplikasiPerpustakaan.Controller;

import com.example.AplikasiPerpustakaan.Common.Response;
import com.example.AplikasiPerpustakaan.Entity.DTO.PeminjamanDTO;
import com.example.AplikasiPerpustakaan.Service.Impl.PeminjamanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peminjaman")

public class PeminjamanController {
    @Autowired
    private PeminjamanServiceImpl Service;

    @GetMapping("/find-all")
    public Response findAllData(){
        List<PeminjamanDTO> data= Service.findAllData();
        return new Response(data, "Get All data pembayaran",data.size(), HttpStatus.OK);

    }

    @PostMapping( "/create")
    public ResponseEntity<?> saveData(@RequestBody PeminjamanDTO param){
        return new ResponseEntity<>(Service.save(param), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateData(@PathVariable Integer id,
                                        @RequestBody PeminjamanDTO param){
       PeminjamanDTO data = Service.update(param, id);

        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/find-by-id/{id}")
    public Response findById(@PathVariable Integer id){
        return new Response(Service.findById(id), "berhasil mengambil data",HttpStatus.OK);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<?> findById2(@RequestParam(name = "id") Integer id){
        return new ResponseEntity<>(Service.findById(id), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public Response deleteData(@PathVariable Integer id) {
        if (Service.delete(id)) {
            return new Response( "data berhasil dihapus",HttpStatus.OK);
        } else {
            return new Response(  "data berhasil dihapus",HttpStatus.BAD_REQUEST);
        }
    }

}
