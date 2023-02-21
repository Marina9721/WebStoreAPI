package com.m2i.WebStoreAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.WebStoreAPI.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

}
