package com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Repostory;

import com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepostory extends JpaRepository<Medicine,Long> {
    Medicine findByName(String name);
    List<Medicine> findByPrice(Double price);
    List<Medicine> findByMedicineFunction(String medicineFunction);
}
