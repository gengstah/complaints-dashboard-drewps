package org.drewps.domain;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class ComplaintTest {
	private Complaint complaint;
	
	@Before
	public void setUp() {
		complaint = new Complaint();
	}
	
	@Test
	public void testDaysPassed() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
		complaint.setDate(calendar.getTime());
		
		assertEquals(1, complaint.getDaysPassed());
	}
}