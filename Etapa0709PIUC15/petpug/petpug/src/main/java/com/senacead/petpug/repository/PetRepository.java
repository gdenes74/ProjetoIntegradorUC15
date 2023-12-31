package com.senacead.petpug.repository;

import com.senacead.petpug.model.Pet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PetRepository  extends JpaRepository<Pet, Integer>{
 
}