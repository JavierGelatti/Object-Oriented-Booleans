package booleans;

import java.util.HashMap;
import java.util.Map;

public abstract class _Boolean {

	public static final _Boolean _true = new True();
	public static final _Boolean _false = new False();
	
	private static Map<Boolean, _Boolean> fromJavaBooleans = new HashMap<Boolean, _Boolean>() {{
		put(true, _true);
		put(false, _false);
	}};
	public static _Boolean asBoolean(boolean aJavaBoolean) {
		return fromJavaBooleans.get(aJavaBoolean);
	}

	public abstract _Boolean not();

	public abstract _Boolean and(_Boolean otherBoolean);

	public abstract _Boolean or(_Boolean otherBoolean);

	public abstract _Boolean ifTrue(Block aBlock);

	public abstract _Boolean ifFalse(Block aBlock);

}

class True extends _Boolean {
	@Override
	public _Boolean not() {
		return _false;
	}

	@Override
	public _Boolean and(_Boolean otherBoolean) {
		return otherBoolean;
	}

	@Override
	public _Boolean or(_Boolean otherBoolean) {
		return this;
	}

	@Override
	public _Boolean ifTrue(Block aBlock) {
		aBlock.execute();
		return this;
	}

	@Override
	public _Boolean ifFalse(Block aBlock) {
		// Do nothing
		return this;
	}
}

class False extends _Boolean {
	@Override
	public _Boolean not() {
		return _true;
	}

	@Override
	public _Boolean and(_Boolean otherBoolean) {
		return this;
	}

	@Override
	public _Boolean or(_Boolean otherBoolean) {
		return otherBoolean;
	}

	@Override
	public _Boolean ifTrue(Block aBlock) {
		// Do nothing
		return this;
	}

	@Override
	public _Boolean ifFalse(Block aBlock) {
		aBlock.execute();
		return this;
	}
}
