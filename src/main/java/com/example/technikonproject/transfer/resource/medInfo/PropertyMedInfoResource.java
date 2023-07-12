package com.example.technikonproject.transfer.resource.medInfo;

import com.example.technikonproject.domain.enums.PropertyType;
import com.example.technikonproject.transfer.resource.BaseResource;
import lombok.Data;

@Data
public class PropertyMedInfoResource extends BaseResource {

    private WebUserMedInfoResource webUserMedInfoResource;

    private PropertyType propertyType;

}
