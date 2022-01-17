package com.example.isa212.Services.IServices;

import com.example.isa212.Model.Adventure;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAdventureService {
    List<Adventure> findAll();
    Adventure findOneById(int id);

    List<Adventure> sortByNameAsc(List<Adventure> adventures);
    List<Adventure> sortByNameDesc(List<Adventure> adventures);
    List<Adventure> sortByAddressAsc(List<Adventure> adventures);
    List<Adventure> sortByAddressDesc(List<Adventure> adventures);
    List<Adventure> sortByGradeAsc(List<Adventure> adventures);
    List<Adventure> sortByGradeDesc(List<Adventure> adventures);

    List<Adventure> findAll(Sort sort);
}
