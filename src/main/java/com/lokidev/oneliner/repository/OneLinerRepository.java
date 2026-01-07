package com.lokidev.oneliner.repository;

import com.lokidev.oneliner.entity.OneLiner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OneLinerRepository extends JpaRepository<OneLiner, UUID> {

    List<OneLiner> findByContextIgnoreCase(String context);

    List<OneLiner> findByAuthorIgnoreCase(String author);
}

