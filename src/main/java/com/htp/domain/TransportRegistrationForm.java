package com.htp.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "m_transport_registration_forms")
public class TransportRegistrationForm extends AbstractFrom {

    @Length(min = 7, max = 9, message = "���������� ���������� �������� �� 7 �� 9")
    @Column(name = "car_license_plate")
    private String carLicensePlate;

    @Length(min = 1, max = 20, message = "���������� ���������� �������� �� 1 �� 20")
    @Column(name = "car_brand")
    private String carBrand;

    @Length(min = 1, max = 17, message = "���������� �������� ������ ���� ����� 17")
    @Column(name = "win_number")
    private String winNumber;

    @Length(min = 1, max = 9, message = "���������� �������� ������ ���� ����� 9")
    @Column(name = "driver_license_number")
    private String driverLicenseNumber;

    @NotNull(message = "���� ������ ������� �� �������")
    @Column(name = "date_of_first_trip")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfFirstTrip;

}
