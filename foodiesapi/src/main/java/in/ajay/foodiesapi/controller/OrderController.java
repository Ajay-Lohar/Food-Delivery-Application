package in.ajay.foodiesapi.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.razorpay.RazorpayException;
import in.ajay.foodiesapi.io.OrderRequest;
import in.ajay.foodiesapi.io.OrderResponse;
import in.ajay.foodiesapi.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor 

public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrderWithPayment(@RequestBody OrderRequest request) throws RazorpayException {
        OrderResponse response =orderService.createOrderWithPayment(request);
        return response;
    }

    @PostMapping("/verify")
    public void verifyPayment(@RequestBody Map<String, String> paymentData) throws RazorpayException {
        orderService.verifyPayment(paymentData,"Paid");

    }

    @GetMapping()
    public List<OrderResponse> getOrders() {
        return orderService.getUserOrders();

    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable String orderId) throws RazorpayException {
        orderService.removeOrder(orderId);
    }

    //admin Panel
    @GetMapping("/all")
    public List<OrderResponse> getOrdersOfAllUsers() {
        return orderService.getOrderOfAllUsers();
    }

    //Admin Panel
    @PatchMapping("/status/{orderId}")
    public void updateOrderStatus(@PathVariable String orderId,@RequestParam String status) throws RazorpayException {
        orderService.updateOrderStatus(orderId,status);


    }
}
