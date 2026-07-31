package com.example.demo.controller;

import com.example.demo.request.AddressRequest;
import com.example.demo.response.AddressResponse;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@CrossOrigin(origins = "*")
public class AddressController {

    @Autowired
    private AddressService addressService;

    // Add Address
    @PostMapping
    public AddressResponse addAddress(@RequestBody AddressRequest addressRequest) {
        return addressService.addAddress(addressRequest);
    }

    // Get All Addresses
    @GetMapping
    public List<AddressResponse> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    // Get Address By Id
    @GetMapping("/{id}")
    public AddressResponse getAddressById(@PathVariable String id) {
        return addressService.getAddressById(id);
    }

    // Get Addresses By User Id
    @GetMapping("/user/{userId}")
    public List<AddressResponse> getAddressesByUserId(@PathVariable String userId) {
        return addressService.getAddressesByUserId(userId);
    }

    // Update Address
    @PutMapping("/{id}")
    public AddressResponse updateAddress(@PathVariable String id,
                                         @RequestBody AddressRequest addressRequest) {
        return addressService.updateAddress(id, addressRequest);
    }

    // Delete Address
    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable String id) {

        addressService.deleteAddress(id);

        return "Address deleted successfully.";
    }

}