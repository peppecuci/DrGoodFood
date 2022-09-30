package com.giuseppe.bruxelles.drgoodfood.services;

import java.util.List;

//TIFORM = Type Input Form
//TUFORM = Type Update Form
public interface CRUDService<T, TID, TFORM> {



    //CREATE
    T create(TFORM toInsert);

    //UPDATE
    T update(TID id, TFORM toUpdate);

    //READ
    T getOne(TID id);
    List<T> getAll();

    //DELETE
    T delete(TID id);


}
