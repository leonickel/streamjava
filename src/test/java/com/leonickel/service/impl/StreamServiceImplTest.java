package com.leonickel.service.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.leonickel.util.Utils;

public class StreamServiceImplTest {

	private StreamServiceImpl streamService;
	
	@Before
	public void setUp() throws Exception {
		streamService = new StreamServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
		streamService = null;
	}
	
	@Test
	public void test_valid_stream_and_sample_size() {
		String sample = streamService.getSample("ABCDEFGHIJ", 5);
		Assert.assertTrue(sample.length() == 5);
	}
	
	@Test
	public void test_valid_random_stream_and_sample_size() {
		String sample = streamService.getSample(Utils.generateRandomSampler(), 5);
		Assert.assertTrue(sample.length() == 5);
	}
	
	@Test
	public void test_valid_stream_and_sample_size_small() {
		String sample = streamService.getSample(Utils.generateRandomSampler(), 1);
		Assert.assertTrue(sample.length() == 1);
	}
	
	@Test
	public void test_valid_stream_and_sample_size_big() {
		String sample = streamService.getSample("ABCDEFGHIJ", 50);
		Assert.assertTrue(sample.length() == 10);
	}

	@Test
	public void test_valid_big_stream_and_sample_size() {
		String sample = streamService.getSample("gergerhtrgeferg34534432r238rfu3oj3oiewfh0932ue023d93n3indeiownfewjf092", 15);
		Assert.assertTrue(sample.length() == 15);
	}
	
	@Test
	public void test_valid_stream_and_sample_size_zero() {
		String sample = streamService.getSample(Utils.generateRandomSampler(), 0);
		Assert.assertTrue(sample.length() == 0);
	}
	
	@Test
	public void test_valid_stream_and_invalid_sample_size() {
		String sample = streamService.getSample(Utils.generateRandomSampler(), -1);
		Assert.assertTrue(sample.length() == 0);
	}
	
	@Test
	public void test_invalid_stream_empty_and_valid_sample_size() {
		String sample = streamService.getSample("", 2);
		Assert.assertTrue(sample.length() == 0);
	}
	
	@Test
	public void test_invalid_stream_null_and_valid_sample_size() {
		String sample = streamService.getSample(null, 2);
		Assert.assertTrue(sample.length() == 0);
	}
	
}
