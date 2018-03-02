package booleans;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static booleans._Boolean.*;

import org.junit.Test;

public class BooleanTest {
	
	private _Boolean executed = _false;

	@Test
	public void testNot() throws Exception {
		assertThat(_true.not(), is(_false));
		assertThat(_false.not(), is(_true));
	}
	
	@Test
	public void testAnd() throws Exception {
		assertThat(_true.and(_true), is(_true));
		assertThat(_true.and(_false), is(_false));
		assertThat(_false.and(_false), is(_false));
		assertThat(_false.and(_true), is(_false));
	}

	@Test
	public void testOr() throws Exception {
		assertThat(_true.or(_true), is(_true));
		assertThat(_true.or(_false), is(_true));
		assertThat(_false.or(_false), is(_false));
		assertThat(_false.or(_true), is(_true));
	}
	
	@Test
	public void testIfTrueOnTrue() throws Exception {
		_true.ifTrue(() -> executed  = _true);

		assertThat(executed, is(_true));
	}

	@Test
	public void testIfTrueOnFalse() throws Exception {
		_false.ifTrue(() -> executed  = _true);

		assertThat(executed, is(_false));
	}

	@Test
	public void testIfFalseOnTrue() throws Exception {
		_true.ifFalse(() -> executed  = _true);

		assertThat(executed, is(_false));
	}

	@Test
	public void testIfFalseOnFalse() throws Exception {
		_false.ifFalse(() -> executed  = _true);

		assertThat(executed, is(_true));
	}
	
	@Test
	public void testFromJavaBoolean() throws Exception {
		assertThat(_Boolean.asBoolean(true),  is(_true));
		assertThat(_Boolean.asBoolean(false), is(_false));
	}

}
