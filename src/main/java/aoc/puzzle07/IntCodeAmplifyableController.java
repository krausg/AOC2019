package aoc.puzzle07;

import java.util.List;

import aoc.puzzle05.IntCodeController;

public interface IntCodeAmplifyableController extends IntCodeController {
	public void setFirstInput(String input);

	public String getFirstInput();

	public List<Integer> getAmplifierPhaseSettings();

	public void setAmplifierPhaseSettings(List<Integer> amplifierPhaseSettings);

	@Override
	IntCodeAmplifyableController klon();

	void setFeedbackLoopMode(boolean feedbackLoopMode);

	boolean isFeedbackLoopMode();

}
