package com.ballarddesigns.Tests;

import org.testng.annotations.Test;

public class FlightBookingTest {

	@Test(priority=-1)
	public void Signup() {
		System.out.println("Signup");

	}

	@Test
	public void Login() {
		System.out.println("Login");

	}

	@Test(priority=3)
	public void SearchForTheFlight() {
		System.out.println("SearchForTheFlight");

	}

	@Test(priority=3)
	public void BookTheFlight() {
		System.out.println("BookTheFlight");

	}

	@Test(priority=5)
	public void SaveTheTicket() {
		System.out.println("SaveTheTicket");

	}

	@Test(priority=6)
	public void Logout() {
		System.out.println("Logout");

	}

	
}
