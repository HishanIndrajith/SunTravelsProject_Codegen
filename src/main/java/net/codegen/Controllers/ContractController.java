package net.codegen.Controllers;

import net.codegen.Models.Contract;
import net.codegen.Models.RoomType;
import net.codegen.Services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/contracts")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContractController
{
	@Autowired
	private ContractService contractService;

	//Get the list of contracts
	@RequestMapping(method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200/")
	public Collection<Contract> getAllContracts(){
		System.out.println("get");
		return contractService.getAllContracts();
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Contract getContractById(@PathVariable("id") int id){
		return contractService.getContractById(id);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void deleteContractById(@PathVariable("id") int id){
		contractService.removeContractById(id);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateContract(@RequestBody Contract contract){
		contractService.updateContract(contract);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertContract(@RequestBody Contract contract ){
		Contract savedContract = contractService.insertContract(contract );
	}
}
