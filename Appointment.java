package com.example.lab_1_nabin;

public class Appointment {
    private int ID;
    private String Name;
    private String Doctor;
    private int Room;

    public Appointment(int ID, String name, String doctor, int room) {
        this.ID = ID;
        Name = name;
        Doctor = doctor;
        Room = room;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDoctor() {
        return Doctor;
    }

    public void setDoctor(String doctor) {
        Doctor = doctor;
    }

    public int getRoom() {
        return Room;
    }

    public void setRoom(int room) {
        Room = room;
    }
}

