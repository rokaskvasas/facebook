package eu.codeacademy.spring.facebook.service.impl;


import eu.codeacademy.spring.facebook.repository.PostEntityRepository;
import eu.codeacademy.spring.facebook.service.PostEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostEntityServiceImpl implements PostEntityService {

    private final PostEntityRepository postEntityRepository;
}
