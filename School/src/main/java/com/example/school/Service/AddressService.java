package com.example.school.Service;

import com.example.school.Api.ApiException;
import com.example.school.DTO.AddressDTO;
import com.example.school.Model.Address;
import com.example.school.Model.Teacher;
import com.example.school.Repository.AddressRepository;
import com.example.school.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    private final TeacherRepository teacherRepository;

    public List<Address> get(){
       return addressRepository.findAll();
    }


    public void add(AddressDTO addressDTO){
        Teacher teacher=teacherRepository.findTeacherById(addressDTO.getTeacher_id());

        if(teacher==null){
            throw new ApiException("teacher id not found ");
        }
        Address address=new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }


    public void update(AddressDTO addressDTO) {

        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if (address == null) {
            throw new ApiException("address not found");
        }
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(address);


    }

    public void delete(Integer id){
        Address address=addressRepository.findAddressById(id);
        if(address==null){
            throw new ApiException("address id not found ");
        }
        addressRepository.delete(address);

    }
}
