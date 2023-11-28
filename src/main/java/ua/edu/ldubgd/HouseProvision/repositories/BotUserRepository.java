package ua.edu.ldubgd.HouseProvision.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.edu.ldubgd.HouseProvision.domains.BotUser;

import java.util.List;

@Repository
public interface BotUserRepository extends JpaRepository<BotUser,Long> {
    List<BotUser> findByTelegramIdAndPhoneNumber(Long telegramId,String phoneNumber);
    List<BotUser> findByPhoneNumber(String phoneNumber);


}
