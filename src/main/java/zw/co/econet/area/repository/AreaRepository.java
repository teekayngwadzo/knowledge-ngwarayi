package zw.co.econet.area.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.co.econet.area.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
}
