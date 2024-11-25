package ru.apzakharov.demo.port.repository;

import org.mapstruct.Mapper;
import ru.apzakharov.demo.application.model.Domain;
@Mapper(componentModel = "spring")
public interface EntityMapper<DOMAIN extends Domain,ENTITY extends EntityWithId<?>> {

  ENTITY toEntity(DOMAIN domain);
  DOMAIN toDomain(ENTITY entity);

}
