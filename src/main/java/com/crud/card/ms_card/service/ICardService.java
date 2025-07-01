package com.crud.card.ms_card.service;

import java.util.List;

import com.crud.card.ms_card.model.Card;

public interface ICardService {
    public List<Card> findAll();
    public int save(Card card);
    public int update(Card card);
    public int deleteByID(int id);
}
