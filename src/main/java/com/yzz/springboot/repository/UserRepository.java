package com.yzz.springboot.repository;

import com.yzz.springboot.bean.Tuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author:Yangzhengzheng
 * @Date: Created in 15:31 2018/7/20
 * @Description:
 * @Modified By:
 */
@Repository
public interface  UserRepository extends JpaRepository<Tuser,Long> {
}
