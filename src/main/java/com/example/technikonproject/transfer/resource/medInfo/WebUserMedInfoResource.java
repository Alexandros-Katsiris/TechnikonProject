package com.example.technikonproject.transfer.resource.medInfo;

import com.example.technikonproject.transfer.resource.BaseResource;
import lombok.Data;

@Data
public class WebUserMedInfoResource extends BaseResource {

    private String firstname;

    private String surname;

    private String phoneNumber;

    private String email;
}
