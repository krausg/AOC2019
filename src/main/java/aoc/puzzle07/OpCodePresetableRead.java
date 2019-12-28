package aoc.puzzle07;

import java.io.InputStream;
import java.util.Map;

import aoc.puzzle05.IntCodeValue;
import aoc.puzzle05.OpCodeRead;

public class OpCodePresetableRead extends OpCodeRead {

	private Map<Integer, Integer> presetMap;

	public OpCodePresetableRead(String stringAsInput, Map<Integer, Integer> presetMap) {
		super(stringAsInput);
		this.presetMap = presetMap;
	}

	public OpCodePresetableRead(InputStream inputStream, Map<Integer, Integer> presetMap) {
		super(inputStream);
		this.presetMap = presetMap;
	}

	@Override
	public void execute(aoc.puzzle05.IntCodeController pgm, IntCodeValue[] params) {
		Integer result = presetMap.get(pgm.getIntPointer());
		if (result == null) {
			result = scanner.nextInt();
		}
		params[0].value = result;
	}

	@Override
	public int getOpCodeLength() {
		return 2;
	}

}
