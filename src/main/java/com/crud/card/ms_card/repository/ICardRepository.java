package com.crud.card.ms_card.repository;

import java.util.List;

import com.crud.card.ms_card.model.Card;

public interface ICardRepository {
    public List<Card> findAll();
    public int save(Card card);
    public int update(Card card);
    public int deleteById(int id);
}
