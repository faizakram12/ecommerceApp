package com.example.demo.service;

import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.request.AddressRequest;
import com.example.demo.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    // Add Address
    public AddressResponse addAddress(AddressRequest addressRequest) {

        Address address = new Address();

        address.setUserId(addressRequest.getUserId());
        address.setFullName(addressRequest.getFullName());
        address.setMobileNumber(addressRequest.getMobileNumber());
        address.setHouseNo(addressRequest.getHouseNo());
        address.setStreet(addressRequest.getStreet());
        address.setCity(addressRequest.getCity());
        address.setState(addressRequest.getState());
        address.setPinCode(addressRequest.getPinCode());
        address.setCountry(addressRequest.getCountry());

        Address savedAddress = addressRepository.save(address);

        return convertToResponse(savedAddress);
    }

    // Get All Addresses
    public List<AddressResponse> getAllAddresses() {

        List<Address> addressList = addressRepository.findAll();

        List<AddressResponse> responseList = new ArrayList<>();

        for (Address address : addressList) {
            responseList.add(convertToResponse(address));
        }

        return responseList;
    }

    // Get Address By Id
    public AddressResponse getAddressById(String id) {

        Address address = addressRepository.findById(id).orElse(null);

        if (address == null) {
            return null;
        }

        return convertToResponse(address);
    }

    // Get Address By User Id
    public List<AddressResponse> getAddressesByUserId(String userId) {

        List<Address> addressList = addressRepository.findByUserId(userId);

        List<AddressResponse> responseList = new ArrayList<>();

        for (Address address : addressList) {
            responseList.add(convertToResponse(address));
        }

        return responseList;
    }

    // Update Address
    public AddressResponse updateAddress(String id, AddressRequest addressRequest) {

        Address address = addressRepository.findById(id).orElse(null);

        if (address == null) {
            return null;
        }

        address.setUserId(addressRequest.getUserId());
        address.setFullName(addressRequest.getFullName());
        address.setMobileNumber(addressRequest.getMobileNumber());
        address.setHouseNo(addressRequest.getHouseNo());
        address.setStreet(addressRequest.getStreet());
        address.setCity(addressRequest.getCity());
        address.setState(addressRequest.getState());
        address.setPinCode(addressRequest.getPinCode());
        address.setCountry(addressRequest.getCountry());

        Address updatedAddress = addressRepository.save(address);

        return convertToResponse(updatedAddress);
    }

    // Delete Address
    public void deleteAddress(String id) {

        addressRepository.deleteById(id);

    }

    // Convert Address to AddressResponse
    private AddressResponse convertToResponse(Address address) {

        AddressResponse response = new AddressResponse();

        response.setId(address.getId());
        response.setUserId(address.getUserId());
        response.setFullName(address.getFullName());
        response.setMobileNumber(address.getMobileNumber());
        response.setHouseNo(address.getHouseNo());
        response.setStreet(address.getStreet());
        response.setCity(address.getCity());
        response.setState(address.getState());
        response.setPinCode(address.getPinCode());
        response.setCountry(address.getCountry());

        return response;
    }

}