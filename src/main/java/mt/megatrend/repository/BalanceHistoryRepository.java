package mt.megatrend.repository;

import mt.megatrend.model.BalanceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BalanceHistoryRepository extends JpaRepository<BalanceHistory, String> {

    @Query("SELECT bh FROM BalanceHistory bh WHERE bh.time BETWEEN :startDateTime AND :endDateTime")
    List<BalanceHistory> findByTimeBetween(@Param("startDateTime") LocalDateTime startDateTime, @Param("endDateTime") LocalDateTime endDateTime);
}
