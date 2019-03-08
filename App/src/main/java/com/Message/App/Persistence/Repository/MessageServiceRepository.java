package com.Message.App.Persistence.Repository;

import com.Message.App.Persistence.Model.ServiceCountryMapDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageServiceRepository extends JpaRepository<ServiceCountryMapDAO, String> {
}
