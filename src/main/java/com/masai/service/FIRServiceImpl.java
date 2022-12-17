package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Accused;
import com.masai.entity.CurrentUserSession;
import com.masai.entity.FIR;
import com.masai.entity.FIRResponse;
import com.masai.entity.User;
import com.masai.exception.FIRException;
import com.masai.exception.UserException;
import com.masai.repository.CurrentUserSessionRepo;
import com.masai.repository.FIRrepo;
import com.masai.repository.UserRepo;


@Service
public class FIRServiceImpl implements FIRService{
	@Autowired
	private UserRepo ur;
	@Autowired
	private FIRrepo fr;
	@Autowired
	private CurrentUserSessionRepo cur;
	
	@Override
	public List<FIR> getAllFirOfUser(String username, String uuid) throws FIRException, UserException {
			CurrentUserSession findByUuid = cur.findByUuid(uuid);
			if(findByUuid == null) throw new UserException("User not Logged In");
			User user = ur.findByUsername(username).orElseThrow(()->new UserException(username+" does not exists"));
			List<FIR> l = user.getFirList();
			if(l.size()==0) throw new FIRException("No FIRs registered by Username: "+username);
		// TODO Auto-generated method stub
		return l;
	}


	@Override
	public FIRResponse fileComplaint(FIR fir, String uuid) throws FIRException, UserException {
		CurrentUserSession findByUuid = cur.findByUuid(uuid);
		if(findByUuid == null) throw new UserException("User not Logged In");
		User user = ur.findByUsername(fir.getUsername()).orElseThrow(()->new UserException("username does not exists"));
		user.getFirList().add(fir);
		Integer c=0;
		List<Accused> la = fir.getAccusedUsername();
		for(Accused i:la) {
			if(ur.findByUsername(i.getUsername()).isPresent()) {
				
			}else throw new UserException("Username :"+i.getUsername()+" does not exist in the database. Do your FIR again");
		}
//		fr.save(fir);
		ur.save(user);
		return new FIRResponse(fir,"Registered");
	}


	@Override
	public FIRResponse deleteFIR(Integer firId, String username, String uuid) throws FIRException, UserException {
		FIR fir = fr.findById(firId).orElseThrow(()-> new FIRException("FIR id "+firId +" is wrong"));
		User user = ur.findByUsername(fir.getUsername()).orElseThrow(()->new UserException("username does not exists"));
		
		if(fir.getLdt().isBefore(fir.getLdt().plusHours(24))){
			
		
		user.getFirList().remove(fir);
		ur.save(user);
		return new FIRResponse(fir,"Deleted Succesfully");
		} throw new FIRException("24 hours have been passed for the FIR id: "+firId);
	}

}
