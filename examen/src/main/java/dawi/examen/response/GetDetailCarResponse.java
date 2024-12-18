package dawi.examen.response;

import dawi.examen.dto.CarDetailDto;

public record GetDetailCarResponse(String code,
                                   String error,
                                   CarDetailDto carDetailDto) {
}
