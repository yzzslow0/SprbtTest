package com.yzz.springboot.repository;

import com.yzz.springboot.bean.TList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Yzz
 */
@Repository
public interface ListRepository extends JpaRepository<TList, Long>{


}


