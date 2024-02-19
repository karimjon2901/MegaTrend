package mt.megatrend.repository;

import mt.megatrend.model.DeliveryCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryCityRepository extends JpaRepository<DeliveryCity, String> {
}
