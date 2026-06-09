package com.codewithnolan.chatchitflutter.repositories;

import com.codewithnolan.chatchitflutter.entities.Message;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {
    @Query("SELECT m FROM messages m WHERE m.user.id=:id")
    List<Message> getByUser(@NonNull UUID id);
}
