package com.tss.controllers;

import com.tss.services.ProductService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping("/products")
    public String showProductList(Model model) {
        model.addAttribute("products", productService.productList());
        return "products.html";
    }
    
    @GetMapping("/products/report")
    public String downloadPDFFile() throws IOException {
        ServiceInstance instance = loadBalancerClient.choose("eurekaServiceClient8083Report");
        String serviceUrl = "http://" + instance.getHost() + ":" + instance.getPort() + "/reports/userreportpdf";
        return "redirect:" + serviceUrl;
    }
}
