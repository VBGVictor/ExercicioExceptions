package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.ErroPersonalizadoException;

public class Reservation {

	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new ErroPersonalizadoException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}


	public Integer getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}


	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);//este comando serve para coverter o diff que estava em milisegundos para dias!
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {//O comando OU em JAVA é Alt+124
			throw new ErroPersonalizadoException("Dates for update must be future!");
		}
		if (!checkOut.after(checkIn)) {
			throw new ErroPersonalizadoException("Check-out date must be after check-in date");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
			
		}
		


	@Override
	public String toString() {
		return "Room " + roomNumber + ", checkIn: " + sdf.format(checkIn) + ", checkOut: " + sdf.format(checkOut) + ", "+ duration()+" nights";
	}
	
	
	
}
