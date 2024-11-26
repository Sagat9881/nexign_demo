package ru.apzakharov.demo.port.repository;

import java.util.List;
import ru.apzakharov.demo.application.model.Domain;
public interface EntityMapper<DOMAIN extends Domain,ENTITY extends EntityWithId<?>> {

  ENTITY toEntity(DOMAIN domain);
  DOMAIN toDomain(ENTITY entity);

  List<ENTITY> toEntity(List<DOMAIN> domain);
  List<DOMAIN> toDomain(List<ENTITY> entity);

}
