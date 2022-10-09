package com.example.AplikasiPerpustakaan.Controller;

import com.example.AplikasiPerpustakaan.Common.Response;
import com.example.AplikasiPerpustakaan.Entity.DTO.BukuDTO;
import com.example.AplikasiPerpustakaan.Service.Impl.BukuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buku")

public class BukuController {
    @Autowired
    private BukuServiceImpl Service;

    @GetMapping("/find-all")
    public Response findAllData(){
        List<BukuDTO> data= Service.findAllData();
        return new Response(data, "Get All data pembayaran",data.size(), HttpStatus.OK);

    }

    @PostMapping( "/create")
    public ResponseEntity<?> saveData(@RequestBody BukuDTO param){
        return new ResponseEntity<>(Service.save(param), HttpStatus.OK);

    }

    @PutMapping("/update/{Id}")
    public ResponseEntity<?> updateData(@PathVariable Integer Id,
                                        @RequestBody BukuDTO param){
        BukuDTO data = Service.update(param, Id);

        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/find-by-id/{Id}")
    public Response findById(@PathVariable Integer Id){
        return new Response(Service.findById(Id), "berhasil mengambil data",HttpStatus.OK);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<?> findById2(@RequestParam(name = "Id") Integer Id){
        return new ResponseEntity<>(Service.findById(Id), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{Id}")
    public Response deleteData(@PathVariable Integer Id) {
        if (Service.delete(Id)) {
            return new Response( "data berhasil dihapus",HttpStatus.OK);
        } else {
            return new Response(  "data berhasil dihapus",HttpStatus.BAD_REQUEST);
        }
    }

}
