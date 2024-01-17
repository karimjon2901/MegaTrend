package mt.megatrend.repository;

import mt.megatrend.model.UniqueId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniqueIdRepository extends JpaRepository<UniqueId, String> {
}
