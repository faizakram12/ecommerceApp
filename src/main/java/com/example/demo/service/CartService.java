package com.example.demo.service;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.CartRequest;
import com.example.demo.response.CartResponse;
import com.example.demo.response.ProductResponse;
import com.example.demo.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    // Add Cart


    // Add Cart
//    public CartResponse addCart(CartRequest request) {
//
//        Cart existingCart = cartRepository.findByUserIdAndProductId(
//                request.getUserId(),
//                request.getProductId()
//        );
//
//        if (existingCart != null) {
//
//            existingCart.setQuantity(
//                    existingCart.getQuantity() + request.getQuantity()
//            );
//
//            Cart updatedCart = cartRepository.save(existingCart);
//
//            return convertToResponse(updatedCart);
//        }
//
//        Cart cart = new Cart();
//
//        cart.setUserId(request.getUserId());
//        cart.setProductId(request.getProductId());
//        cart.setQuantity(request.getQuantity());
//
//        Cart savedCart = cartRepository.save(cart);
//
//        return convertToResponse(savedCart);
//    }


//    public CartResponse addCart(CartRequest request) {
//
//        Cart cart = new Cart();
//
//        cart.setUserId(request.getUserId());
//        cart.setProductId(request.getProductId());
//        cart.setQuantity(request.getQuantity());
//
//        Cart savedCart = cartRepository.save(cart);
//
//        return convertToResponse(savedCart);
//    }



    // add cart

    public CartResponse addCart(CartRequest request) {

        // Check Quantity
        if (request.getQuantity() == null || request.getQuantity() <= 0) {
            return null;
        }

        // Check User
        User user = userRepository.findById(request.getUserId()).orElse(null);

        if (user == null) {
            return null;
        }

        // Check Product
        Product product = productRepository.findById(request.getProductId()).orElse(null);

        if (product == null) {
            return null;
        }

        // Check Stock
        if (request.getQuantity() > product.getStock()) {
            return null;
        }

        // Check Existing Cart
        Cart existingCart = cartRepository.findByUserIdAndProductId(
                request.getUserId(),
                request.getProductId()
        );

        if (existingCart != null) {

            existingCart.setQuantity(
                    existingCart.getQuantity() + request.getQuantity()
            );

            Cart updatedCart = cartRepository.save(existingCart);

            return convertToResponse(updatedCart);
        }

        // Create New Cart
        Cart cart = new Cart();

        cart.setUserId(request.getUserId());
        cart.setProductId(request.getProductId());
        cart.setQuantity(request.getQuantity());

        Cart savedCart = cartRepository.save(cart);

        return convertToResponse(savedCart);
    }

    // Get All Cart
    public List<CartResponse> getAllCart() {

        List<Cart> cartList = cartRepository.findAll();

        List<CartResponse> responseList = new ArrayList<>();

        for (Cart cart : cartList) {
            responseList.add(convertToResponse(cart));
        }

        return responseList;
    }

    // Get Cart By Id
    public CartResponse getCartById(String id) {

        Cart cart = cartRepository.findById(id).orElse(null);

        if (cart == null) {
            return null;
        }

        return convertToResponse(cart);
    }

    // Get Cart By UserId
    public List<CartResponse> getCartByUserId(String userId) {

        List<Cart> cartList = cartRepository.findByUserId(userId);

        List<CartResponse> responseList = new ArrayList<>();

        for (Cart cart : cartList) {
            responseList.add(convertToResponse(cart));
        }

        return responseList;
    }

    // Update Cart
//    Cart cart = cartRepository.findById(id).orElse(null);
//
//        cart.setQuantity(request.getQuantity());
//
//        cartRepository.save(cart);
    public CartResponse updateCart(String id, CartRequest request) {

        Cart cart = cartRepository.findById(id).orElse(null);
        if (cart == null) {
            return null;
        }

        cart.setUserId(request.getUserId());
        cart.setProductId(request.getProductId());
        cart.setQuantity(request.getQuantity());

        Cart updatedCart = cartRepository.save(cart);
//
        return convertToResponse(updatedCart);
    }

    // Delete Cart
    public void deleteCart(String id) {

        cartRepository.deleteById(id);

    }

    // Convert Cart To Response
    private CartResponse convertToResponse(Cart cart) {

        CartResponse response = new CartResponse();

        response.setId(cart.getId());
        response.setUserId(cart.getUserId());
        response.setProductId(cart.getProductId());
        response.setQuantity(cart.getQuantity());

        User user = userRepository.findById(cart.getUserId()).orElse(null);

        if (user != null) {

            UserResponse userResponse = new UserResponse();

            userResponse.setId(user.getId());
            userResponse.setName(user.getName());
            userResponse.setEmail(user.getEmail());
            userResponse.setRole(user.getRole());

            response.setUser(userResponse);

        }

        Product product = productRepository.findById(cart.getProductId()).orElse(null);

        if (product != null) {

            ProductResponse productResponse = new ProductResponse();

            productResponse.setId(product.getId());
            productResponse.setProductName(product.getProductName());
            productResponse.setDescription(product.getDescription());
            productResponse.setPrice(product.getPrice());
            productResponse.setStock(product.getStock());
            productResponse.setCategoryId(product.getCategoryId());

            response.setProduct(productResponse);

        }

        return response;
    }

}