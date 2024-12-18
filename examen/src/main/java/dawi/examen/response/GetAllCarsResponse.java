package dawi.examen.response;

import dawi.examen.dto.CarDto;


import java.util.List;

public record GetAllCarsResponse(String code,
                                 String error,
                                 List<CarDto> cars) {
}
