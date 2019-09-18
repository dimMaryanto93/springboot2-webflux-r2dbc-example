package com.maryanto.dimas.example.mappers;

import com.maryanto.dimas.example.dto.ExampleEntityDto;
import com.maryanto.dimas.example.entity.ExampleEntity;
import com.maryanto.dimas.plugins.web.commons.mappers.ObjectMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

public class ExampleEntityMapper {

    @Mapper
    public interface ExampleEntityCreate extends ObjectMapper<ExampleEntity, ExampleEntityDto.Create> {
        ExampleEntityCreate instance = Mappers.getMapper(ExampleEntityCreate.class);

        @Override
        @Mappings(value = {
                @Mapping(target = "id", ignore = true),
                @Mapping(target = "createdDate", ignore = true)
        })
        ExampleEntity convertToEntity(ExampleEntityDto.Create create);
    }
}
