package net.codegen.Services;

import net.codegen.Models.Contract;
import net.codegen.Repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ContractService
{
	@Autowired
	private ContractRepository contractRepository;
	public Collection<Contract> getAllContracts(){
		return contractRepository.getAllContracts();
	}

	public Contract getContractById(int id){
		return contractRepository.getContractById( id );
	}

	public void removeContractById( int id )
	{
		contractRepository.removeContractById(id);
	}
	public void updateContract(Contract contract )
	{
		contractRepository.updateContract( contract );
	}
	public void insertContract(Contract contract ){
		contractRepository.insertContract(contract );
	}
}
