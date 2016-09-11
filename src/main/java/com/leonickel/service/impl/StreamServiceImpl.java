package com.leonickel.service.impl;

import javax.inject.Singleton;

import com.leonickel.service.StreamService;

@Singleton
public class StreamServiceImpl implements StreamService {

	/**
	 * This method receives stream and sampleSize values, creates a stream using .chars(), change it from serial to parallel 
	 * to improve performance, uses limit clause in order to filter stream and after put the result using a forEach approach
	 * @param stream stream value to be used in algorithm
	 * @param sampleSize size of returned sample
	 */
	@Override
	public String getSample(String stream, int sampleSize) {
		if(stream == null || stream.isEmpty() || sampleSize < 0) {
			return "";
		}
		final StringBuilder result = new StringBuilder();
		stream.chars().parallel().limit(sampleSize).forEach(c -> result.append((char) c));
		return result.toString();
	}
}