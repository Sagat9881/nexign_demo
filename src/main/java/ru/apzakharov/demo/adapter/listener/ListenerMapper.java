package ru.apzakharov.demo.adapter.listener;

import org.mapstruct.Mapper;
import ru.apzakharov.demo.application.model.Domain;
public interface ListenerMapper <DTO extends ListenerDto, DOMAIN extends Domain> {

  DTO toDto(DOMAIN domain);
  DOMAIN toDomain(DTO domain);


}
