package com.example.isa212.Services.IServices;


import com.example.isa212.Model.Cottage;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ICottageService {

    List<Cottage> findAll();
    Cottage findOneByid_cottage(int id);

    List<Cottage> sortByNameAsc(List<Cottage> cottages);
    List<Cottage> sortByNameDesc(List<Cottage> cottages);
    List<Cottage> sortByAddressAsc(List<Cottage> cottages);
    List<Cottage> sortByAddressDesc(List<Cottage> cottages);
    List<Cottage> sortByGradeAsc(List<Cottage> cottages);
    List<Cottage> sortByGradeDesc(List<Cottage> cottages);

    List<Cottage> findAll(Sort sort);



}
