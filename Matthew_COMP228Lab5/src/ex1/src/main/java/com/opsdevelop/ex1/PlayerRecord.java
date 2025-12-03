package com.opsdevelop.ex1;

// Matthew Elliott - 301424215
// Lab 05
// December 3, 2025

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

// Creating a record for the Player

public class PlayerRecord {
    private final IntegerProperty game_id = new SimpleIntegerProperty();
    private final StringProperty game_title = new SimpleStringProperty();
    private final IntegerProperty player_id = new SimpleIntegerProperty();
    private final StringProperty first_name = new SimpleStringProperty();
    private final StringProperty last_name = new SimpleStringProperty();
    private final StringProperty address = new SimpleStringProperty();
    private final StringProperty postal_code = new SimpleStringProperty();
    private final StringProperty province = new SimpleStringProperty();
    private final StringProperty phone_number = new SimpleStringProperty();
    private final IntegerProperty player_game_id = new SimpleIntegerProperty();
    private final StringProperty playing_date = new SimpleStringProperty();
    private final IntegerProperty score = new SimpleIntegerProperty();

    public PlayerRecord(int game_id, String game_title, int player_id,
                        String first_name, String last_name, String address,
                        String postal_code, String province, String phone_number,
                        int player_game_id, String playing_date, int score) {
        this.game_id.set(game_id);
        this.game_title.set(game_title);
        this.player_id.set(player_id);
        this.first_name.set(first_name);
        this.last_name.set(last_name);
        this.address.set(address);
        this.postal_code.set(postal_code);
        this.province.set(province);
        this.phone_number.set(phone_number);
        this.player_game_id.set(player_game_id);
        this.playing_date.set(playing_date);
        this.score.set(score);
    }

    public IntegerProperty gameIDProperty() {return game_id;}
    public StringProperty gameTitleProperty() {return game_title;}
    public IntegerProperty playerIDProperty() {return player_id;}
    public StringProperty firstNameProperty() {return first_name;}
    public StringProperty lastNameProperty() {return last_name;}
    public StringProperty addressProperty() {return address;}
    public StringProperty postalProperty() {return postal_code;}
    public StringProperty provinceProperty() {return province;}
    public StringProperty phoneProperty() {return phone_number;}
    public IntegerProperty playerGameProperty() {return player_game_id;}
    public StringProperty playDateProperty() {return playing_date;}
    public IntegerProperty scoreProperty() {return score;}

    public int getGameID(){return game_id.get();}
    public String getGameTitle(){return game_title.get();}
    public int getPlayerID(){return player_id.get();}
    public String getFirstName() {
        return first_name.get();
    }
    public String getLastName() {
        return last_name.get();
    }
    public String getAddress(){return address.get();}
    public String getPostal(){return postal_code.get();}
    public String getProvince(){return province.get();}
    public String getPhone(){return phone_number.get();}
    public int getPlayerGameID(){return player_game_id.get();}
    public String getPlayDate(){return playing_date.get();}
    public int getScore(){return score.get();}
}
