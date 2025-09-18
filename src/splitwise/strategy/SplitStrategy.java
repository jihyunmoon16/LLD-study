package splitwise.strategy;

import java.util.Map;

import splitwise.model.Expense;
import splitwise.model.User;

public interface SplitStrategy {
	Map<User, Double> split(Expense expense);
}
