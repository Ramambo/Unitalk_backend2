package com.unitalk.member.repository;

import com.unitalk.common.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 사용자 엔티티에 대한 데이터 접근을 처리하는 리포지토리 인터페이스입니다.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
