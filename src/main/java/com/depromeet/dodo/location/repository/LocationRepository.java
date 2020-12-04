package com.depromeet.dodo.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.depromeet.dodo.location.domain.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}

