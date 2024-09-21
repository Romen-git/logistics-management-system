package com.ro.ejb.remote.dao;

import com.ro.ejb.entity.Location;
import com.ro.ejb.entity.Shipment;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface ShipmentDAO {

    Shipment findById(Long id);
    List<Shipment> findAll();
    Boolean save(Shipment shipment);
    Boolean update(Shipment shipment);
    Boolean delete(Shipment shipment);

}
