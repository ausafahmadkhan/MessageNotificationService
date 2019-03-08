package com.Message.App.Persistence.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ServiceCountryMap")
public class ServiceCountryMapDAO
{
    @Id
    private String countryCode;
    @Column
    private String messageServiceName;
}
