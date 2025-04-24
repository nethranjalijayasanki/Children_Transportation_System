package com.example.userbe.controller;

import com.example.userbe.dto.RouteDetailsDTO;
import com.example.userbe.service.RouteDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/route")
public class RouteDetailsController {
    private final RouteDetailsService routeDetailsService;

    @Autowired
    public RouteDetailsController(RouteDetailsService routeDetailsService) {
        this.routeDetailsService = routeDetailsService;
    }

    @PostMapping("/save")
    public ResponseEntity<RouteDetailsDTO> createRouteDetails(@RequestBody RouteDetailsDTO routeDetailsDTO) {
        RouteDetailsDTO createdRouteDetails = routeDetailsService.createRouteDetails(routeDetailsDTO);
        return ResponseEntity.ok(createdRouteDetails);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<RouteDetailsDTO> getRouteDetailsById(@PathVariable Long id) {
        RouteDetailsDTO routeDetailsDTO = routeDetailsService.getRouteDetailsById(id);
        return ResponseEntity.ok(routeDetailsDTO);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<RouteDetailsDTO>> getAllRouteDetails() {
        List<RouteDetailsDTO> routeDetails = routeDetailsService.getAllRouteDetails();
        return ResponseEntity.ok(routeDetails);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RouteDetailsDTO> updateRouteDetails(@PathVariable Long id, @RequestBody RouteDetailsDTO routeDetailsDTO) {
        RouteDetailsDTO updatedRouteDetails = routeDetailsService.updateRouteDetails(id, routeDetailsDTO);
        return ResponseEntity.ok(updatedRouteDetails);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRouteDetails(@PathVariable Long id) {
        routeDetailsService.deleteRouteDetails(id);
        return ResponseEntity.noContent().build();
    }
}
