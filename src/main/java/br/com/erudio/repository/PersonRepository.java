package br.com.erudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erudio.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {} //JpaRepository implements the main functions of a CRUD, just requiring the type of object, in that case is Person, and the type of the generable id of this object, in that case is Long