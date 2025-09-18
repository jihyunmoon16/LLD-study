package splitwise.model;

import java.util.List;
import java.util.Map;

import splitwise.strategy.SplitStrategy;

public class Expense {
	private double amount;
	private User payer;
	private List<User> participants;
	private SplitStrategy splitStrategy;

	public Expense(double amount, User payer, List<User> participants, SplitStrategy splitStrategy) {
		this.amount = amount;
		this.payer = payer;
		this.participants = participants;
		this.splitStrategy = splitStrategy;
	}

	public List<User> getParticipants() {
		return participants;
	}

	public double getAmount() {
		return amount;
	}

	public Map<User, Double> calculateSplits() {
		return splitStrategy.split(this);
	}
}
