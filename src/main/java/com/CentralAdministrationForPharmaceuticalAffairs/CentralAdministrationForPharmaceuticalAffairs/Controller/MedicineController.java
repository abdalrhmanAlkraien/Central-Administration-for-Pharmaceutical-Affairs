package com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Controller;

import com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Entity.Medicine;
import com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Services.MedicineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController()
@RequestMapping("api")
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping("/medicine")
    public ResponseEntity<Medicine> createMedicine(@RequestBody Medicine medicine, @RequestParam("token") String token) throws Exception {
        return ResponseEntity.created(new URI("api/medicine")).body(medicineService.createNewMedicine(medicine, token));
    }

    @DeleteMapping("/medicine/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable Long id,@RequestParam("token") String token) throws Exception {
        medicineService.deleteMedicine(id, token);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/medicine")
    public ResponseEntity<List<Medicine>> getAllMedicine(@RequestParam("token") String token) throws Exception {
        return ResponseEntity.ok(medicineService.getAllMedicine(token));
    }

    @GetMapping("/medicine/ById/{id}")
    public ResponseEntity<Medicine> getByIdMedicine(@PathVariable Long id,@RequestParam("token") String token) throws Exception {
        return ResponseEntity.ok(medicineService.getMedicineById(id,token));
    }

    @GetMapping("/medicine/ByName/{name}")
    public ResponseEntity<Medicine> getByNameMedicine(@PathVariable String name,@RequestParam("token") String token) throws Exception {
        return ResponseEntity.ok(medicineService.getMedicineByName(name,token));
    }

    @GetMapping("/medicine/Price/{price}")
    public ResponseEntity<List<Medicine>> getByPriceMedicine(@PathVariable Double price,@RequestParam("token") String token) throws Exception {
        return ResponseEntity.ok(medicineService.getMedicineByPrice(price,token));
    }
    @GetMapping("/medicine/medicineFunction/{medicineFunction}")
    public ResponseEntity<List<Medicine>> getByMedicineFunction(@PathVariable String medicineFunction,@RequestParam("token") String token) throws Exception {
        return ResponseEntity.ok(medicineService.getMedicineByMedicineFunction(medicineFunction,token));
    }


}
