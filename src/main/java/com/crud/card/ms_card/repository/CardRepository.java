package com.crud.card.ms_card.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crud.card.ms_card.model.Card;

@Repository
public class CardRepository implements ICardRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Card> findAll() {
        String SQL = "SELECT * FROM cards WHERE status=1";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Card.class));
    }

    @Override
    public int save(Card card) {
        String SQL = "INSERT INTO cards VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(SQL, new Object[]{
            card.getName(),
            card.getNumber(),
            card.getType(),
            card.getCvv(),
            card.getStatus()
        });
    }

    @Override
    public int update(Card card) {
        String SQL = "UPDATE cards SET name=?, number=?, type=?, cvv=? WHERE id_card = ?";
        return jdbcTemplate.update(SQL, new Object[]{
            card.getName(),
            card.getNumber(),
            card.getType(),
            card.getCvv(),
            card.getId_card()
        });
    }

    @Override
    public int deleteById(int id) {
        String SQL = "UPDATE cards SET status=1 WHERE id_card = ?";
        return jdbcTemplate.update(SQL, new Object[]{id});
    }
    
}
