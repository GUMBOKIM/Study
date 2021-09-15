package io.security.corespringsecurity.repository;

import io.security.corespringsecurity.domain.Account;
import io.security.corespringsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Account, Long> {


}
