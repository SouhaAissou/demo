package com.example.demo.command;



import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CommandRepository extends JpaRepository<command, Long> {


}
