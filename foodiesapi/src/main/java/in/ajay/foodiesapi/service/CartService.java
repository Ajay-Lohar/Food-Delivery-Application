package in.ajay.foodiesapi.service;

import in.ajay.foodiesapi.io.CartRequest;
import in.ajay.foodiesapi.io.CartResponse;

public interface CartService {

    CartResponse addToCart(CartRequest request);

    CartResponse getCart();

    void clearCart();

    CartResponse removeFromCart(CartRequest cartRequest);

}
