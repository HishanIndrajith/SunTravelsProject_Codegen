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
		return contractRepository.findAll();
	}

	public Contract getContractById(long id){
		return contractRepository.findById( id ).get();
	}

	public void removeContractById( long id )
	{
		contractRepository.deleteById( id );
	}
	public Contract updateContract(Contract contract )
	{
		if ( contractRepository.existsById( contract.getId() ) )
		{
			return contractRepository.save( contract );
		}

		return null;
	}
	public Contract insertContract(Contract contract ){
		return contractRepository.save( contract );
	}
}
