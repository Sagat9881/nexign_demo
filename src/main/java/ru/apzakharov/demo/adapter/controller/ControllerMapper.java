package ru.apzakharov.demo.adapter.controller;

import org.mapstruct.Mapper;
import ru.apzakharov.demo.application.model.Domain;
@Mapper(componentModel = "spring")
public interface ControllerMapper<DTO extends ControllerDto, DOMAIN extends Domain> {

  DTO toDto(DOMAIN domain);
  DOMAIN toDomain(DTO domain);
}
