package net.codegen.Repositories;

import net.codegen.Models.Contract;
import net.codegen.Models.Result;
import net.codegen.Models.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FindRoomRepository extends JpaRepository<RoomType, Long>
{
//	@Query("SELECT * FROM contract")
	@Query(value = "SELECT * FROM room_type AS r INNER JOIN contract AS c ON r.contract=c.contract_id INNER JOIN hotel AS h ON c.hotel=h.hotel_id WHERE c.start_date < ?1 AND c.end_date > ?2",
			nativeQuery = true)
	List<RoomType> findAvailableRooms(String beginDate, String endDate);

}
