package com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Medicine")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "Name")
    String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "Decription")
    private String description;

    @Column(name = "medicine_function")
    private String medicineFunction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedicineFunction() {
        return medicineFunction;
    }

    public void setMedicineFunction(String medicineFunction) {
        this.medicineFunction = medicineFunction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(id, medicine.id) &&
                Objects.equals(name, medicine.name) &&
                Objects.equals(price, medicine.price) &&
                Objects.equals(description, medicine.description) &&
                Objects.equals(medicineFunction, medicine.medicineFunction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, medicineFunction);
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", medicineFunction='" + medicineFunction + '\'' +
                '}';
    }

    public String validation(){
        String valid="";

        if(getId()!=null)
        {
            valid+="id must be empty ";

        }

        if(getName()==null||getName().equals(""))
        {
            valid+="First name is null";
        }

        if(getDescription()==null||getDescription().equals(""))
        {
            valid+="description is null";
        }

        if (getPrice()==null||getPrice()==0.0)
        {
            valid+="price is null";
        }
        return valid;

    }
}
