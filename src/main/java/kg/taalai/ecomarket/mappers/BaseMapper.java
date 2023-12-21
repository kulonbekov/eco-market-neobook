package kg.taalai.ecomarket.mappers;

import jakarta.persistence.MappedSuperclass;

import java.util.List;

@MappedSuperclass
public interface BaseMapper<Entity, Dto> {

    Entity toEntity(Dto dto);

    Dto toDto(Entity entity);

    List<Entity> toEntities(List<Dto> dtoList);

    List<Dto> toDtos(List<Entity> entityList);
}
