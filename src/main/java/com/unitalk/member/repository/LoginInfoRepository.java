package com.unitalk.member.repository;

import com.unitalk.common.model.entity.User;
import com.unitalk.member.entity.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginInfoRepository extends JpaRepository<LoginInfo, Long> {
    Boolean existsByUser(User user);
    LoginInfo findByUserId(Long userId);
}
