package eu.codeacademy.spring.facebook.service.impl;

import eu.codeacademy.spring.facebook.repository.PermissionEntityRepository;
import eu.codeacademy.spring.facebook.service.PermissionEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionEntityServiceImpl implements PermissionEntityService {

    private final PermissionEntityRepository permissionEntityRepository;
}
