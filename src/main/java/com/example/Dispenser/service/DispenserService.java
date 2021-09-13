package com.example.Dispenser.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Dispenser.model.Denoms;
import com.example.Dispenser.repository.DispenserRepository;

@Service
public class DispenserService {
	
	@Autowired
	private DispenserRepository dispenserRepository;
	
	public List<Denoms> getAllDenoms() {
		return dispenserRepository.findAll(); 
	}
	
	public Optional<Denoms> getDenom(Long id) {
		return dispenserRepository.findById(id); 
	}
	
	//Calculate the denoms needed (change) for amount Y and insert into table 
	public Denoms calculate(Denoms denoms) {
		Integer _amount = Integer.parseInt(denoms.getAmount());
		Integer _denom = 0;
		Integer _division = 0;
		int _change = _amount;
		System.out.println(_change);
		
			for(int i = denoms.getDenoms().length-1; i >= 0; i--){
					if(_change != 0) {
						_denom = Integer.parseInt(denoms.getDenoms()[i]);
			    		System.out.println("_denom " + _denom);
			    		
			    		if(_denom != _amount) {
			    			_division = _change/_denom;
				    		System.out.println("Division = " + _division);
			    		}
			    		
			    		if (_division != 0) {
			    			_change = _change - (_denom * _division);
							System.out.println("CHANGE = " + _change);
						}
					}
					else {
						_division = 0;
						_change = 0;
						_denom = 1;
						System.out.println("_denom " + _denom);
						System.out.println("Division = " + _division);
						System.out.println("CHANGE = " + _change);
					}

				setDenoms(denoms, _denom, _division);	
			}

		removeNulls(denoms);			
		dispenserRepository.save(denoms);
		return denoms;	
	}
	
	//Determine which denoms are needed
	public void setDenoms(Denoms denoms, Integer denomination, Integer dividend) {

	    switch (denomination) {
	      case 100:
	    	denoms.set_100(dividend.toString());
	        System.out.println("Case 100");
	        break;
	      case 50:
	    	denoms.set_50(dividend.toString());
	        System.out.println("Case 50");
	        break;
	      case 20:
	    	denoms.set_20(dividend.toString());
	        System.out.println("Case 20");
	        break;
	      case 10:
	    	denoms.set_10(dividend.toString());
	        System.out.println("Case 10");
	        break;
	      case 5:
	    	denoms.set_5(dividend.toString());
	        System.out.println("Case 5");
	        break;
	      case 2:
	    	denoms.set_2(dividend.toString());
	        System.out.println("Case 2");
	        break;
	      case 1:
	    	denoms.set_1(dividend.toString());  
	        System.out.println("Case 1");
	        break;
	    }
	}
	
	//remove any possible nulls and replace with 0 before persistance
	public void removeNulls(Denoms denoms) {
		if (denoms.get_100() == null) {
			denoms.set_100("0");
		}
		
		if (denoms.get_50() == null) {
			denoms.set_50("0");
		}
		
		if (denoms.get_20() == null) {
			denoms.set_20("0");
		}
		
		if (denoms.get_10() == null) {
			denoms.set_10("0");
		}
		
		if (denoms.get_5() == null) {
			denoms.set_5("0");
		}
		
		if (denoms.get_2() == null) {
			denoms.set_2("0");
		}
		
		if (denoms.get_1() == null) {
			denoms.set_1("0");
		}
	}

}
