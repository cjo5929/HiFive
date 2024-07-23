package com.ssafy.hifive.domain.token.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ssafy.hifive.domain.token.entity.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {

	Optional<Token> findByRefreshToken(String refreshToken);

	@Query("select t from Token t where t.member.memberId = :memberId")
	Optional<Token> findByMemberId(@Param("memberId") long memberId);
}
