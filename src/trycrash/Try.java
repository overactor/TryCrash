package trycrash;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class Try {
	
	private static final String msg = "Code in a tryCrash function threw an Exception.";
	
	public static void tryCrash(ThrowingCode code) {
		
		try {
			code.exec();
		} catch (Exception e) {
			throw getErr(e);
		}
	}
	
	public static void tryCatch(ThrowingCode code) {
		
		try {
			code.exec();
		} catch (Exception e) {
			// No problem
		}
	}
	
	public static <T> T tryCrash(ThrowingSupplier<T> code) {
		
		try {
			return code.exec();
		} catch (Exception e) {
			throw getErr(e);
		}
	}
	
	public static <T> Optional<T> tryCatch(ThrowingSupplier<T> code) {
		
		try {
			return Optional.of(code.exec());
		} catch (Exception e) {
			return Optional.empty();
		}
	}
	
	public static int tryCrash(ThrowingIntSupplier code) {
		
		try {
			return code.exec();
		} catch (Exception e) {
			throw getErr(e);
		}
	}
	
	public static OptionalInt tryCatch(ThrowingIntSupplier code) {
		
		try {
			return OptionalInt.of(code.exec());
		} catch (Exception e) {
			return OptionalInt.empty();
		}
	}
	
	public static long tryCrash(ThrowingLongSupplier code) {
		
		try {
			return code.exec();
		} catch (Exception e) {
			throw getErr(e);
		}
	}
	
	public static OptionalLong tryCatch(ThrowingLongSupplier code) {
		
		try {
			return OptionalLong.of(code.exec());
		} catch (Exception e) {
			return OptionalLong.empty();
		}
	}
	
	public static double tryCrash(ThrowingDoubleSupplier code) {
		
		try {
			return code.exec();
		} catch (Exception e) {
			throw getErr(e);
		}
	}
	
	public static OptionalDouble tryCatch(ThrowingDoubleSupplier code) {
		
		try {
			return OptionalDouble.of(code.exec());
		} catch (Exception e) {
			return OptionalDouble.empty();
		}
	}
	
	private static TryCrashException getErr(Exception e) {
		
		return new TryCrashException(msg, e);
	}
	
	private static class TryCrashException extends RuntimeException {
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	
		TryCrashException(String message, Exception e) {
			
			super(message, e);
		}
	}
	
	public static interface ThrowingCode {
		
		public void exec() throws Exception;
	}
	
	public static interface ThrowingSupplier<T> {
		
		public T exec() throws Exception;
	}

	public static interface ThrowingIntSupplier {
		
		public int exec() throws Exception;
	}

	public static interface ThrowingLongSupplier {
		
		public long exec() throws Exception;
	}

	public static interface ThrowingDoubleSupplier {
		
		public double exec() throws Exception;
	}
}
