package com.ro.ejb.remote.dao;

import com.ro.ejb.entity.Cargo;
import com.ro.ejb.entity.InventoryItem;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface InventoryItemDAO {

    InventoryItem findById(Long id);
    List<InventoryItem> findAll();
    Boolean save(InventoryItem inventoryItem);
    Boolean update(InventoryItem inventoryItem);
    Boolean delete(InventoryItem inventoryItem);

}
