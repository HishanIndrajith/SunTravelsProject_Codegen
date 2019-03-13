package net.codegen.Controllers;

import net.codegen.Models.Contract;
import net.codegen.Models.Requirement;
import net.codegen.Models.Result;
import net.codegen.Models.RoomType;
import net.codegen.Services.FindRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/find")
public class FindRoomController
{
	@Autowired
	private FindRoomService findRoomService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Result> findAvailableRooms(@RequestBody Requirement requirement ){
		List<Result> results = findRoomService.findAvailableRooms(requirement );
		return results;
	}
}
