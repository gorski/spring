package com.trainings.guava;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

import com.google.common.io.Closer;

public class GuavaCloser {
	private static final Logger LOG = Logger.getLogger(GuavaCloser.class);

	public static void main(String[] args) {
		GuavaCloser test = new GuavaCloser();
		try {
			test.simpleClosingResources();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public void simpleClosingResources() throws IOException {
		Closer closer = Closer.create();
		try {
			// register streams in closer object
			InputStream in = closer.register(openInputStream());
			OutputStream out = closer.register(openOutputStream());
			// do stuff with in and out
		} catch (Throwable e) { // must catch Throwable
			throw closer.rethrow(e);
		} finally {
			// Calling close() on the Closer will safely close all Closeable objects that have been registered with it.
			closer.close();
		}
	}

	private InputStream openInputStream() {
		return null;
	}

	private OutputStream openOutputStream() {
		return null;
	}
}
