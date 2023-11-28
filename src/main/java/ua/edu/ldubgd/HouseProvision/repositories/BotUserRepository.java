package ua.edu.ldubgd.HouseProvision.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.edu.ldubgd.HouseProvision.domains.BotUser;

import java.util.List;

@Repository
public interface BotUserRepository extends JpaRepository<BotUser,Long> {
    List<BotUser> findByTelegramId(Long telegramId);
    List<BotUser> findByPhoneNumber(String phoneNumber);




}
