package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial7.model.DealerModel;
import com.apap.tutorial7.repository.DealerDb;

@Service
@Transactional
public class DealerServiceImpl implements DealerService {
	@Autowired
	private DealerDb dealerDb;

	@Override
	public Optional<DealerModel> getDealerDetailById(Long id) {
		// TODO Auto-generated method stub
		return dealerDb.findById(id);
	}
	

	@Override
	public DealerModel addDealer(DealerModel dealer) {
		// TODO Auto-generated method stub
		return dealerDb.save(dealer);
	}

	@Override
	public void deleteDealer(DealerModel dealer) {
		// TODO Auto-generated method stub
		//dealerDb.deleteById(dealerId);
		dealerDb.delete(dealer);
	}

	@Override
	public List<DealerModel> getAllDealer() {
		// TODO Auto-generated method stub
		return dealerDb.findAll();
	}


	@Override
	public void updateDealer(Long id, DealerModel dealer) {
		// TODO Auto-generated method stub
		dealerDb.deleteById(id);
		addDealer(dealer);
	}

}
