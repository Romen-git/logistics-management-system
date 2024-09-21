package com.ro.ejb.remote.dao;

import com.ro.ejb.entity.Cargo;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface CargoDAO {

    Cargo findById(Long id);
    List<Cargo> findAll();
    Boolean save(Cargo cargo);
    Boolean update(Cargo cargo);
    Boolean delete(Cargo cargo);

}
