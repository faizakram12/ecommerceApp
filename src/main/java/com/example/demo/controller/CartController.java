package com.example.demo.controller;

import com.example.demo.request.CartRequest;
import com.example.demo.response.CartResponse;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public CartResponse addCart(@RequestBody CartRequest request) {
        return cartService.addCart(request);
    }

    @GetMapping
    public List<CartResponse> getAllCart() {
        return cartService.getAllCart();
    }

    @GetMapping("/{id}")
    public CartResponse getCartById(@PathVariable String id) {
        return cartService.getCartById(id);
    }

    @GetMapping("/user/{userId}")
    public List<CartResponse> getCartByUserId(@PathVariable String userId) {
        return cartService.getCartByUserId(userId);
    }

    @PutMapping("/{id}")
    public CartResponse updateCart(@PathVariable String id,
                                   @RequestBody CartRequest request) {
        return cartService.updateCart(id, request);

    }

    @DeleteMapping("/{id}")
    public String deleteCart(@PathVariable String id) {

        cartService.deleteCart(id);

        return "Cart deleted successfully.";
    }

}