package com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Services;

import com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Entity.Medicine;
import com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Entity.User;
import com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Repostory.MedicineRepostory;
import com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Repostory.UserRepostory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    private final UserRepostory userRepostory;

    private final MedicineRepostory medicineRepostory;

    public MedicineService(UserRepostory ueUserRepostory, MedicineRepostory medicineRepostory) {
        this.userRepostory = ueUserRepostory;
        this.medicineRepostory = medicineRepostory;
    }

    public Medicine createNewMedicine(Medicine medicine, String token) throws Exception {

        checkToken(token);

        if (!medicine.validation().equals("")) {
            throw new Exception("medicine wrong input check input !");
        }
        return medicineRepostory.save(medicine);


    }

    public List<Medicine> getAllMedicine(String token) throws Exception{
        if (token == null || !userRepostory.findByToken(token).isPresent()) {
            throw new Exception("Token is Wrong");
        }
        return medicineRepostory.findAll();

    }

    public Medicine getMedicineById(Long id,String token) throws Exception {
        if (token == null || !userRepostory.findByToken(token).isPresent()) {
            throw new Exception("Token is Wrong");
        }
        return medicineRepostory.findById(id).get();
    }

    public Medicine getMedicineByName(String name,String token) throws Exception {
        if (token == null || !userRepostory.findByToken(token).isPresent()) {
            throw new Exception("Token is Wrong");
        }
        return medicineRepostory.findByName(name);
    }

    public List<Medicine> getMedicineByPrice(Double price,String token) throws Exception {
        if (token == null || !userRepostory.findByToken(token).isPresent()) {
            throw new Exception("Token is Wrong");
        }
        return medicineRepostory.findByPrice(price);
    }

    public List<Medicine> getMedicineByMedicineFunction(String medicineFunction,String token) throws Exception {
        if (token == null || !userRepostory.findByToken(token).isPresent()) {
            throw new Exception("Token is Wrong");
        }
        return medicineRepostory.findByMedicineFunction(medicineFunction);
    }

    public void deleteMedicine(Long id,String token) throws Exception
    {
        checkToken(token);
        if(!medicineRepostory.findById(id).isPresent())
        {
            throw new Exception("Cannot find medicine");
        }
        medicineRepostory.deleteById(id);
    }


    public void checkToken(String token) throws Exception{
        if (token == null || !userRepostory.findByToken(token).isPresent()) {
            throw new Exception("Token is Wrong");
        }
        User user = userRepostory.findByToken(token).get();
        if (!user.getAccess().toLowerCase().equals("admin")) {
            throw new Exception("access permission denied");
        }
    }
}
