package com.Message.App.Persistence.Repository;

import com.Message.App.Persistence.Model.MessageServiceLookup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageServiceRepository extends JpaRepository<MessageServiceLookup, String> {
}
