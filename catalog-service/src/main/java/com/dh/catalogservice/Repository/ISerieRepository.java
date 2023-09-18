package com.dh.catalogservice.Repository;


import com.dh.catalogservice.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends MongoRepository<Serie,Long> {
    List<Serie> findByGenre(String genre);
}
