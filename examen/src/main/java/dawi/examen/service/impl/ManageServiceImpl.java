package dawi.examen.service.impl;

import dawi.examen.dto.CarCreateDto;
import dawi.examen.dto.CarDetailDto;
import dawi.examen.dto.CarDto;
import dawi.examen.entity.Car;
import dawi.examen.repository.CarRepository;
import dawi.examen.service.ManageService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl  implements ManageService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() throws Exception {
        List<CarDto> cars = new ArrayList<>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> cars.add(new CarDto(car.getCarId(), car.getMake(), car.getModel(), car.getColor())));
        return cars;
    }


    @Override
    public Optional <CarDetailDto> getDetailCar(int id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
       return optional.map(car ->new CarDetailDto(car.getCarId(),
                                                car.getMake(),
                                                car.getModel(),
                                                car.getYear(),
                                                car.getVin(),
                                                car.getLicensePlate(),
                                                car.getOwnerName(),
                                                car.getOwnerContact(),
                                                car.getPurchaseDate(),
                                                car.getMileage(),
                                                car.getEngineType(),
                                                car.getColor(),
                                                car.getInsuranceCompany(),
                                                car.getInsurancePolicyNumber(),
                                                car.getRegistrationExpirationDate(),
                                                car.getServiceDueDate()));

    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {
        Optional<Car> optional = carRepository.findById(carDto.carId());
        return optional.map(car -> {
            car.setMake(carDto.make());
            car.setModel(carDto.model());
            car.setColor(carDto.color());

            carRepository.save(car);
            return true;

        }).orElse(false);

    }

    @Override
    public boolean deleteCar(int id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean createCar(CarCreateDto carCreateDto) throws Exception {
      Car car = new Car();
      car.setMake(carCreateDto.make());
      car.setModel(carCreateDto.model());
      car.setYear(carCreateDto.year());
      car.setVin(carCreateDto.vin());
      car.setLicensePlate(carCreateDto.licensePlate());
      car.setOwnerName(carCreateDto.ownerName());
      car.setOwnerContact(carCreateDto.ownerContact());
      car.setPurchaseDate(carCreateDto.purchaseDate());
      car.setMileage(carCreateDto.mileage());
      car.setEngineType(carCreateDto.engineType());
      car.setColor(carCreateDto.color());
      car.setInsuranceCompany(carCreateDto.insuranceCompany());
      car.setInsurancePolicyNumber(carCreateDto.insurancePolicyNumber());
      carRepository.save(car);
      return true;
    }
}
