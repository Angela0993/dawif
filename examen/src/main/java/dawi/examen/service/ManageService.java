package dawi.examen.service;

import dawi.examen.dto.CarCreateDto;
import dawi.examen.dto.CarDetailDto;
import dawi.examen.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDto> getAllCars() throws Exception;
    Optional<CarDetailDto> getDetailCar(int id) throws Exception;
    boolean updateCar(CarDto carDto) throws Exception;
    boolean deleteCar(int id) throws Exception;
    boolean createCar(CarCreateDto carCreateDto) throws Exception;

}
