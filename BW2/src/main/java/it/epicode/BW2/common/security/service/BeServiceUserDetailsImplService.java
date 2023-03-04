package it.epicode.BW2.common.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.epicode.BW2.model.BeServiceUser;
import it.epicode.BW2.repository.BeServiceUserRepository;

@Service
public class BeServiceUserDetailsImplService implements UserDetailsService  {
	@Autowired
	BeServiceUserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<BeServiceUser> user = userRepository.findByUsername(username);

		if (user.isPresent()) {
			return BeServiceUserDetailsImpl.build(user.get());
		} else {
			throw new UsernameNotFoundException("User Not Found with username: " + username);
		}
	}
}
