package com.leonickel.service;

public interface StreamService {
	/**
	 * Receives input values and returns generated sample
	 * @param stream
	 * @param sampleSize
	 * @return generated sample based on stream and sampleSize inputs
	 */
	String getSample(String stream, int sampleSize);

}