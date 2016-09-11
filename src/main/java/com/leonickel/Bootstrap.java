package com.leonickel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.leonickel.service.StreamService;
import com.leonickel.util.DependencyInjector;
import com.leonickel.util.Utils;

public class Bootstrap {

	private static Logger logger = LoggerFactory.getLogger("application");

	public static void main(String[] args) {
		if(args.length < 1) {
			logger.error(">>>>>>>>>>>>>>>>>>>>> HOW TO RUN <<<<<<<<<<<<<<<<<<<<<<");
			logger.error("First parameter must be size sample (int) ");
			logger.error("Second parameter (optional) must be stream value ");
			logger.error("Example: java -jar target/StreamJava.jar 5 ABCDEFGHIJKL");
			logger.error(">>>>>>>>>>>>>>>>>>>>>> EXITTING <<<<<<<<<<<<<<<<<<<<<<<");
			return; //instead of System.exit(9) for unit tests flow
		}
		int sampleSize = 0;
		try {
			sampleSize = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			logger.error("the sample size must be a positive number, exitting...");
			return;
		}
		
		logger.info("sample size: [{}]", sampleSize);
		final String stream = args.length == 2 ? args[1] : Utils.generateRandomSampler();

		final Injector injector = Guice.createInjector(new DependencyInjector());
		final StreamService service = injector.getInstance(StreamService.class);

		try {
			final String sample = service.getSample(stream, sampleSize);
			logger.info("generated sample: [{}] from stream: [{}]", sample, stream);
		} catch (Exception e) {
			logger.error("something wrong has occurred, please check parameters provided and try starting application again");
		}
	}
}