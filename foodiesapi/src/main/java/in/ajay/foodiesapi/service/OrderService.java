package in.ajay.foodiesapi.service;

import com.razorpay.RazorpayException;
import in.ajay.foodiesapi.io.OrderRequest;
import in.ajay.foodiesapi.io.OrderResponse;

public interface OrderService {

    OrderResponse createOrderWithPayment(OrderRequest request) throws RazorpayException;

}
