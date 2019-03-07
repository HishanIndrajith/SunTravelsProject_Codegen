package net.codegen.Repositories;

import net.codegen.Models.Contract;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ContractRepository
{
	private static Map<Integer,Contract> contracts;

	static {

		contracts = new HashMap<Integer, Contract>(){
			{
				try
				{
					SimpleDateFormat format1 = new SimpleDateFormat( "dd/MM/yyyy" );
					Date date1 = format1.parse( "01/02/2019" );
					Date date2 = format1.parse( "01/05/2019" );
					Date date3 = format1.parse( "03/01/2019" );
					Date date4 = format1.parse( "01/11/2019" );
					Date date5 = format1.parse( "31/02/2019" );
					Date date6 = format1.parse( "01/09/2019" );
					put(1,new Contract(1,date1,date2));
					put(2,new Contract(2,date3,date4));
					put(3,new Contract(3,date5,date6));
				}catch ( Exception e ){

				}


			}
		};
	}

	public Collection<Contract> getAllContracts(){
		return this.contracts.values();
	}

	public Contract getContractById(int id){
		return this.contracts.get(id);
	}

	public void removeContractById( int id )
	{
		this.contracts.remove( id );
	}

	public void updateContract(Contract contract )
	{
		Contract s = this.contracts.get( contract.getId() );
		s.setStartDate( contract.getStartDate());
		s.setEndDate( contract.getEndDate());
		this.contracts.put( contract.getId(), s);
	}
	public void insertContract(Contract contract ){
		this.contracts.put(contract.getId(),contract );
	}
}
