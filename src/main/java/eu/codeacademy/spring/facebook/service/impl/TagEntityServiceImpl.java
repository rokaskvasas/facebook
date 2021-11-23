package eu.codeacademy.spring.facebook.service.impl;


import eu.codeacademy.spring.facebook.repository.TagEntityRepository;
import eu.codeacademy.spring.facebook.service.TagEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagEntityServiceImpl implements TagEntityService {

    private final TagEntityRepository tagEntityRepository;
}
