ALTER TABLE minions.towns
    CHANGE COLUMN town_id id int NOT NULL AUTO_INCREMENT;


ALTER TABLE minions.minions
    ADD COLUMN town_id int NOT NULL,
    ADD CONSTRAINT fk_minions_towns
        FOREIGN KEY (town_id)
            REFERENCES towns (id);