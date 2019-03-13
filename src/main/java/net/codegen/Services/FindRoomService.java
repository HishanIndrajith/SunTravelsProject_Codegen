package net.codegen.Services;


import net.codegen.Models.Requirement;
import net.codegen.Models.Result;
import net.codegen.Models.RoomType;
import net.codegen.Repositories.FindRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

		List<Integer> roomAdultsCountList = requirement.getPersons();
		List<Integer> roomCountList = requirement.getRooms();
		int originalSize=roomAdultsCountList.size();
		int totalNoOfAdults = 0;
		for(int i=0;i<originalSize;i++){
			int noOfAdultsForARoom = roomAdultsCountList.get(i);
			totalNoOfAdults+=noOfAdultsForARoom;
			int noOfRoomsNeeded= roomCountList.get(i);
			if(noOfRoomsNeeded>1){
				for(int j =1;j<noOfRoomsNeeded;j++){
					roomAdultsCountList.add( noOfAdultsForARoom );
					totalNoOfAdults+=noOfAdultsForARoom;
				}
			}
		}
		int maxCountForRooms = Collections.max(roomAdultsCountList);

		List <RoomType> roomTypeResult = findRoomRepository.findAvailableRooms(startDateString,endDateString,maxCountForRooms,roomAdultsCountList.size());

		List <Result> results = new ArrayList<>( );

		for(RoomType roomType : roomTypeResult){
			String name = roomType.getContract().getHotel().getHotelName()+" "+roomType.getContract().getHotel().getAddress();
			double price = (double)(roomType.getPrice()*1.15*requirement.getNoOfnights()*totalNoOfAdults);
			price = Math.round(price * 100.0) / 100.0;
			Result result = new Result(name,roomType.getTypeName(),price);
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
