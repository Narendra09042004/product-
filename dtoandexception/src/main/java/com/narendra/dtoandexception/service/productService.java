package com.narendra.dtoandexception.service;

import com.narendra.dtoandexception.dto.productDTO;
import com.narendra.dtoandexception.dto.productDTOins;
import com.narendra.dtoandexception.dto.productDTOupd;
import com.narendra.dtoandexception.entity.product;
import com.narendra.dtoandexception.repository.productRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productService {

    @Autowired
    private productRepository repository_obj;

    @Autowired
    private ModelMapper modelMapper;

    // Select All data using entity to DTO
    public List<productDTO> getdata_dto(){

        List<product> products=repository_obj.findAll();
        return products.stream().map(this::entity_to_dto).toList();
    }

    // select data by id
    public productDTO getdata_by_id(int id)
    {
        Optional<product> product_obj=repository_obj.findById(id);

        if(product_obj.isPresent())
        {
            return entity_to_dto(product_obj.get());
        }
        else
        {
            return null;
        }
    }

    // Insert data form the product using DTO
    public product datains_dto(productDTOins productDTOins)
    {
        return repository_obj.save(entityins_to_dto(productDTOins));
    }

    // delete data with the use of dto.
    public boolean delet_from_dto(int id)
    {
       if(repository_obj.existsById(id))
       {
           repository_obj.deleteById(id);
           return true;
       }
       else {
           return false;
       }
    }

    // update by id using dto.
    public product update_dto(int id,productDTOupd productDTOupd)
    {
        if(repository_obj.existsById(id))
        {
            return repository_obj.save(entityupd_to_dto(id,productDTOupd));
        }

        else
        {
           return null;
        }
    }

//----------------------------------------------------------------------------------------------------------------------------------------------//
    // adding entity data to DTO.
    public productDTO entity_to_dto(product product){

        productDTO productDTO_obj=this.modelMapper.map(product,productDTO.class);
        return productDTO_obj;
//        productDTO_obj.setId(product.getId());
//        productDTO_obj.setName(product.getName());


    }

    // insert data to product using dto.
    public product entityins_to_dto(productDTOins productDTOins)
    {
        product product_obj=this.modelMapper.map(productDTOins,product.class);
        return product_obj;
//        product_obj.setId(productDTOins.getId());
//        product_obj.setName(productDTOins.getName());
//        product_obj.setPrice(productDTOins.getPrice());


    }

    // update data to product using dto
    public product entityupd_to_dto(int id,productDTOupd productDTOupd){
        product product_obj=new product();

        product_obj.setId(id);
        product_obj.setName(productDTOupd.getName());
        product_obj.setPrice(productDTOupd.getPrice());

        return product_obj;
    }
}
