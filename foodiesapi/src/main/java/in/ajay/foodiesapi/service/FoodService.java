package in.ajay.foodiesapi.service;

import in.ajay.foodiesapi.io.FoodRequest;
import in.ajay.foodiesapi.io.FoodResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FoodService {

    String uploadFile(MultipartFile file);

    FoodResponse addFood(FoodRequest request,MultipartFile file);
}
