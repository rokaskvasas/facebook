package eu.codeacademy.spring.facebook.service.impl;

import eu.codeacademy.spring.facebook.repository.CommentEntityRepository;
import eu.codeacademy.spring.facebook.service.CommentEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentEntityServiceImpl implements CommentEntityService {

    private final CommentEntityRepository commentEntityRepository;
}
