package net.codegen.Services;


import net.codegen.Models.Requirement;
import net.codegen.Models.Result;
import net.codegen.Models.RoomType;
import net.codegen.Repositories.FindRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class FindRoomService
{
	@Autowired
	private FindRoomRepository findRoomRepository;

	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public List<Result> findAvailableRooms(Requirement requirement )
	{

		Date startDate = requirement.getCheckInDate();
		Date endDate = addDaystoDate(startDate,requirement.getNoOfnights());
		String startDateString = dateFormat.format(startDate);
		String endDateString = dateFormat.format(endDate);
		System.out.println(startDateString);
		System.out.println(endDateString);
		List <RoomType> roomTypeResult = findRoomRepository.findAvailableRooms(startDateString,endDateString);

		List <Result> results = new ArrayList<>( );

		System.out.println(results.size());
		for(RoomType roomType : roomTypeResult){
			Result result = new Result(roomType.getContract().getHotel().getHotelName(),roomType.getTypeName(),1000);
			results.add(result);
		}
		return results;
	}

	private Date addDaystoDate(Date currentDate,int days){
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);

		// manipulate date
		c.add(Calendar.DATE, days);

		// convert calendar to date
		Date currentDatePlusOne = c.getTime();
		return currentDatePlusOne;

	}
}