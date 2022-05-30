package com.kebidge.SimpleBackend;

import org.springframework.data.repository.CrudRepository;

public interface SimpleRepository extends CrudRepository<SimpleItem, Long>  {
    
}
