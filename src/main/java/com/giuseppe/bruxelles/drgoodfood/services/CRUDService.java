package com.giuseppe.bruxelles.drgoodfood.services;

import java.util.List;

//TIFORM = Type Input Form
//TUFORM = Type Update Form
public interface CRUDService<TDTO, TID, TFORM> {

    //CREATE
    TDTO create(TFORM toInsert);

    //UPDATE
    TDTO update(TID id, TFORM toUpdate);

    //READ
    TDTO readOne(TID id);
    List<TDTO> readAll();

    //DELETE
    void delete(TID id);



}
