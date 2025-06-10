package com.narendra.dtoandexception.controller;

import com.narendra.dtoandexception.dto.productDTO;
import com.narendra.dtoandexception.dto.productDTOins;
import com.narendra.dtoandexception.dto.productDTOupd;
import com.narendra.dtoandexception.entity.product;
import com.narendra.dtoandexception.service.productService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("data")
@Validated
@Tag(name = "Product API", description = "Read,Update & Delete User")
public class productController {

    @Autowired
    private productService service_obj;

    // select all data form service
    @GetMapping("/select")
    public ResponseEntity<?> getdata_service()
    {
        List<productDTO> productDTOS_list=service_obj.getdata_dto();

        if(productDTOS_list.isEmpty()){
            return new ResponseEntity<>("No data foun",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productDTOS_list,HttpStatus.OK);
    }

    // select by id from dto class
    @GetMapping("/select/{id}")
    public ResponseEntity<?> select_by_id(@Valid @PathVariable int id)
    {
        productDTO id_of_dto=service_obj.getdata_by_id(id);
        if(id_of_dto!=null)
        {
            return new ResponseEntity<>(id_of_dto,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Id Not found",HttpStatus.NOT_FOUND);
        }
    }

    // delete by id present in the dto
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete_byid(@Valid @PathVariable int id)
    {
        if(service_obj.delet_from_dto(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // insert data using dto insert class.
    @PostMapping("/add")
    public product inserdata_service(@Valid @RequestBody productDTOins productDTOins)
    {
        return service_obj.datains_dto(productDTOins);
    }

    // update
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update_by_id(@Valid @PathVariable int id,@RequestBody productDTOupd productDTOupd)
    {
        product update_id=service_obj.update_dto(id,productDTOupd);
        if(update_id!=null)
        {
            return new ResponseEntity<>("record updated",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("ID not found",HttpStatus.NOT_FOUND);
        }
    }

}
