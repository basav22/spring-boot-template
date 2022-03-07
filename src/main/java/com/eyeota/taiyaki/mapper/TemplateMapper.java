package com.eyeota.taiyaki.mapper;

import com.eyeota.taiyaki.model.dto.NewTemplateDto;
import com.eyeota.taiyaki.model.dto.TemplateDto;
import com.eyeota.taiyaki.model.entity.TemplateEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TemplateMapper {

    @Mapping(target = "id", ignore = true)
    TemplateEntity toEntity(NewTemplateDto dto);

    TemplateDto toDto(TemplateEntity entity);

    List<TemplateDto> toDtoList(List<TemplateEntity> entities);

}
