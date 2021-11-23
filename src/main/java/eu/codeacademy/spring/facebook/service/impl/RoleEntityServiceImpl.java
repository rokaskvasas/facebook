package eu.codeacademy.spring.facebook.service.impl;


import eu.codeacademy.spring.facebook.repository.RoleEntityRepository;
import eu.codeacademy.spring.facebook.service.RoleEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleEntityServiceImpl implements RoleEntityService {

    private final RoleEntityRepository roleEntityRepository;
}
