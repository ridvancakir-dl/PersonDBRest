package com.ridvan.app.sample.repository;

import com.ridvan.app.sample.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<Person,Long>{}
