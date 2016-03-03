package trycrash.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static trycrash.Try.tryCatch;
import static trycrash.Try.tryCrash;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class tryCrashTest {

	@Test
	public void testCatchFail() {
		
		tryCatch(() -> {
			if (Math.random() > 0) throw new IOException();
		});
		
		String hello = tryCatch(() -> {
			if (Math.random() > 0) throw new IOException();
			return "hello";
		}).orElseGet(() -> "failed");		
		assertEquals("failed", hello);
		
		int i = tryCatch(() -> {
			if (Math.random() > 0) throw new IOException();
			return 1;
		}).orElseGet(() -> -1);		
		assertEquals(-1, i);
		
		long l = tryCatch(() -> {
			if (Math.random() > 0) throw new IOException();
			return 1l;
		}).orElseGet(() -> -1);		
		assertEquals(-1, l);
		
		double d = tryCatch(() -> {
			if (Math.random() > 0) throw new IOException();
			return 1.0;
		}).orElseGet(() -> -1);		
		assertEquals(-1, d, 0.0001);
	}

	@Test
	public void testCatchSuccess() {

		tryCatch(() -> {
			if (Math.random() > 1) throw new IOException();
		});
		
		String hello = tryCatch(() -> {
			if (Math.random() > 1) throw new IOException();
			return "hello";
		}).orElseGet(() -> "failed");		
		assertEquals("hello", hello);
		
		int i = tryCatch(() -> {
			if (Math.random() > 1) throw new IOException();
			return 1;
		}).orElseGet(() -> -1);		
		assertEquals(1, i);
		
		long l = tryCatch(() -> {
			if (Math.random() > 1) throw new IOException();
			return 1l;
		}).orElseGet(() -> -1);		
		assertEquals(1, l);
		
		double d = tryCatch(() -> {
			if (Math.random() > 1) throw new IOException();
			return 1.0;
		}).orElseGet(() -> -1);		
		assertEquals(1, d, 0.0001); 
	}

	@Test
	public void testCrashFail() {
		
		boolean failed = false;
		try {
			tryCrash(() -> {
				if (Math.random() > 0) throw new IOException();
			});
		} catch (Exception e) {
			failed = true;
		}
		assertTrue(failed);
		
		failed = false;
		try {
			String hello = tryCrash(() -> {
				if (Math.random() > 0) throw new IOException();
				return "hello";
			});	
		} catch (Exception e) {
			failed = true;
		}
		assertTrue(failed);
		
		failed = false;
		try {
			int i = tryCrash(() -> {
				if (Math.random() > 0) throw new IOException();
				return 1;
			});		
		} catch (Exception e) {
			failed = true;
		}
		assertTrue(failed);
		
		failed = false;
		try {
			long l = tryCrash(() -> {
				if (Math.random() > 0) throw new IOException();
				return 1l;
			});		
		} catch (Exception e) {
			failed = true;
		}
		assertTrue(failed);
		
		failed = false;
		try {
			double d = tryCrash(() -> {
				if (Math.random() > 0) throw new IOException();
				return 1.0;
			});		
		} catch (Exception e) {
			failed = true;
		}
		assertTrue(failed);
	}


	@Test
	public void testrashSuccess() {

		tryCrash(() -> {
			if (Math.random() > 1) throw new IOException();
		});
		
		String hello = tryCrash(() -> {
			if (Math.random() > 1) throw new IOException();
			return "hello";
		});		
		assertEquals("hello", hello);
		
		int i = tryCrash(() -> {
			if (Math.random() > 1) throw new IOException();
			return 1;
		});		
		assertEquals(1, i);
		
		long l = tryCrash(() -> {
			if (Math.random() > 1) throw new IOException();
			return 1l;
		});		
		assertEquals(1, l);
		
		double d = tryCrash(() -> {
			if (Math.random() > 1) throw new IOException();
			return 1.0;
		});		
		assertEquals(1, d, 0.0001); 
	}
}
