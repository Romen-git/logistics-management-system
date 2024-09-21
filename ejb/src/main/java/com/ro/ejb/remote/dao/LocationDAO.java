package com.ro.ejb.remote.dao;

import com.ro.ejb.entity.InventoryItem;
import com.ro.ejb.entity.Location;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface LocationDAO {

    Location findById(Long id);
    List<Location> findAll();
    Boolean save(Location location);
    Boolean update(Location location);
    Boolean delete(Location location);

}
