package lk.nexttravelcompany.vehicle.service.controller;

import lk.nexttravelcompany.vehicle.service.dto.VehicleDTO;
import lk.nexttravelcompany.vehicle.service.service.VehicleService;
import lk.nexttravelcompany.vehicle.service.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vehicle")
@CrossOrigin(origins = {"http://127.0.0.1:5500/custompackage.html","http://127.0.0.1:5500"})
public class VehicleController {

    private final VehicleService vehicleService;

    //handle vehicle post request
    @PostMapping("/save")
    public Mono<ResponseUtil> saveVehicleData(@RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.saveVehicle(vehicleDTO).map(savedVehicle ->
                new ResponseUtil(200, "Vehicle Saved", null));
    }

    //handle vehicle by Id Get request
    @GetMapping("{vehicleId}")
    public Mono<ResponseUtil> getVehicleData(@PathVariable int vehicleId) {
        return vehicleService.getVehicle(vehicleId).map(vehicle ->
                new ResponseUtil(200, vehicleId + "Vehicle Retrieved", vehicle));
    }

    //handle getAll vehicle request
    @GetMapping("/getAll")
    public Flux<ResponseUtil> getAllVehiclesData() {
        return vehicleService.getAllVehicles().map(vehicles ->
                new ResponseUtil(200, "Get All vehicles", vehicles));
    }

    //handle vehicle update request
    @PutMapping("/update")
    public Mono<ResponseUtil> updateVehicleData(@RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.updateVehicle(vehicleDTO).map(updatedvehicle ->
                new ResponseUtil(200, " Vehicle data Updated", null));
    }

    //handle vehicle delete by id request
    @DeleteMapping("{vehicleId}")
    public Mono<ResponseUtil> deleteVehicleData(@PathVariable int vehicleId) {
        return vehicleService.deleteVehicle(vehicleId).map(deletedVehicle ->
                new ResponseUtil(200, vehicleId + " Deleted Success", null));
    }
}
