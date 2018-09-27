package cloud.assignment2.cloudassignment2.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserDao {
	
	@Autowired
	UserRepository userRepository;
	
	public UserPojo checkUser(String email)
	{
		for(UserPojo user: userRepository.findAll())
		{
			if(user.getEmail().equals(email))
				return user;
		}
		return null;
	}
	
	public void addUser(UserPojo userobj)
	{
		userRepository.save(userobj);
	}
	
	public List<UserPojo> getAll(){
		
		List<UserPojo> newls = new ArrayList<UserPojo>();
		userRepository.findAll()
		.forEach(newls::add);
		return newls;
		
	}
}
