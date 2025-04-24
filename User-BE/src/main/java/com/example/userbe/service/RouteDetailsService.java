package com.example.userbe.service;

import com.example.userbe.dto.RouteDetailsDTO;

import java.util.List;

public interface RouteDetailsService {
    RouteDetailsDTO createRouteDetails(RouteDetailsDTO routeDetailsDTO);
    RouteDetailsDTO getRouteDetailsById(Long id);
    List<RouteDetailsDTO> getAllRouteDetails();
    RouteDetailsDTO updateRouteDetails(Long id, RouteDetailsDTO routeDetailsDTO);
    void deleteRouteDetails(Long id);
}
