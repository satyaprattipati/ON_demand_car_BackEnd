package com.cg.services;



import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.AdminNotFoundException;
import com.cg.exception.WashpackNotFoundException;
import com.cg.models.Admin;
import com.cg.models.UserRating;
import com.cg.models.Washpack;
import com.cg.repository.AdminRepo;
import com.cg.repository.RatingRepo;
import com.cg.repository.WashRepo;


@Service
public class AdminServiceImplementation implements AdminService {
	Logger logger = LoggerFactory.getLogger(AdminServiceImplementation.class);
	@Autowired
	private AdminRepo adminrepo;
	@Autowired
	private RatingRepo ratingrepo;
	@Autowired
	private WashRepo washrepo;

	@Override
	public List<Admin> findAll() {
		logger.info("Getting Admin list");
		List<Admin> admin=adminrepo.findAll();
		return admin;
	}

	@Override
	public void saveAdmin(Admin admin) {
		logger.info("Adding Admins");
		adminrepo.save(admin);

	}

	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Optional<Admin> optionalAdmin = adminrepo.findById(admin.getId());

		if (optionalAdmin.isPresent()) {
			adminrepo.save(admin);
			logger.info("Admin Updated Successfully");
			
		}
		else {
			throw new AdminNotFoundException("Admin not exising with id: ");
		}
		
		
	}

	@Override
	public void deleteAdmin(int id) {
		// TODO Auto-generated method stub
		
		Optional<Admin> optionalAdmin = adminrepo.findById(id);

if (optionalAdmin.isPresent()) {
			
			adminrepo.deleteById(id);
			logger.info("Admin Deleted Successfully");
		}
		else {
			
			throw new AdminNotFoundException ("Admin not found with id: " + id);
		}
	}


	@Override
	public List<Washpack> getWashpack() {
		// TODO Auto-generated method stub
		List<Washpack> washpack=washrepo.findAll();
		logger.info("Successfully got List of washpacks");
		return washpack;
	}

	@Override
	public void saveWashpack(Washpack washpacks) 
	{
		washrepo.save(washpacks);
		logger.info("Successfully added washpacks");


	}

	@Override
	public void updateWashpack(Washpack updatepack) {
		Optional<Washpack> optionalWashpack = washrepo.findById(updatepack.getId());

		if (optionalWashpack.isPresent()) {
			 washrepo.save(updatepack);
			 logger.info("Successfully updated Washpack");
			
		}
		else {
			throw new WashpackNotFoundException("Washpack not exising with id: " + updatepack.getId());
		}

		 
	}
	

	@Override
	public void deleteWashpack(int id) {
		// TODO Auto-generated method stub
		Optional<Washpack> optionalWashpack = washrepo.findById(id);

		if (optionalWashpack.isEmpty()) {
			throw new WashpackNotFoundException("Washpack not exising with id: " + id);
		}

		Washpack wash = optionalWashpack.get();

		washrepo.delete(wash);
		logger.info("Successfully deleted washpack");

	}

	

	@Override
	public Washpack viewPack(int id) {
		// TODO Auto-generated method stub
		Optional<Washpack> optionalPack = washrepo.findById(id);
        if(optionalPack.isEmpty()) {
            throw new WashpackNotFoundException("WashPack  not existing with id: "+id);
        }
        logger.info(" Successfully got pack by id");
        return optionalPack.get();
		
	}

//	@Override
//	public <Washpack> viewPack(int id) {
//		
		
//		Optional<Washpack> optionalPack = washrepo.findById(id);
//        if(optionalPack.isEmpty()) {
//            throw new WashpackNotFoundException("WashPack is not existing with id: "+ id);
//        }
//       Washpack pack = optionalPack.get();
//        washrepo.findById(id);
		
//	}

	

	

}
