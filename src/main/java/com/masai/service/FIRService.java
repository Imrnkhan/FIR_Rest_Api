package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.entity.FIR;
import com.masai.entity.FIRResponse;
import com.masai.exception.FIRException;
import com.masai.exception.UserException;

@Service
public interface FIRService {

	public List<FIR> getAllFirOfUser(String username, String uuid)throws FIRException,UserException;

	public FIRResponse deleteFIR(Integer firId, String username, String uuid)throws FIRException,UserException;

	public FIRResponse fileComplaint(FIR fir, String uuid)throws FIRException,UserException;

}
