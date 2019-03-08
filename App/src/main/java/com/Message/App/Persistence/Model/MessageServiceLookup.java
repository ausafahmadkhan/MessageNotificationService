package com.Message.App.Persistence.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MessageServiceLookup
{
    @Id
    private String countryCode;
    @Column
    private String messageServiceName;
}
