package com.giuseppe.bruxelles.drgoodfood.services;

import java.util.Collection;
import java.util.List;
import java.util.Set;

//TIFORM = Type Input Form
//TUFORM = Type Update Form
public interface CRUDService<T, TID, TIFORM, TUFORM> {



    //CREATE
    T create(TIFORM toInsert);

    //UPDATE
    T update(TID id, TUFORM toUpdate);

    //READ
    T getOne(TID id);
    List<T> getAll();

    //DELETE
    T delete(TID id);


}
